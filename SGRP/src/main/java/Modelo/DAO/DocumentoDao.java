package Modelo.DAO;

import Modelo.Entidades.ExpedienteAlumno;
import Utilidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jobae
 */
public class DocumentoDao {
    
    public static Integer comboSolicitud(String nControl) throws SQLException{
        String sql = "SELECT e.id_estatus\n" +
                        "FROM alumno a\n" +
                        "JOIN soli_residencia sr ON a.id_alumno = sr.fk_alumno\n" +
                        "JOIN estatus_soli_residencia e ON sr.fk_estatus = e.id_estatus\n" +
                        "WHERE a.n_control = ?;";
        
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nControl);
            ResultSet rs = stmt.executeQuery();
            
        if(rs.next()){
           return rs.getInt("id_estatus");
        }
    }
        return 0;
    }
    
    public static void crearSoli(String nControl) throws SQLException{
        String sql1 = "select id_alumno from alumno where n_control = (?);";
        String sql2 = "insert into soli_residencia (fk_alumno) values (?);";
        
            try (Connection conn = Conexion.getConexion();) {
                
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setString(1, nControl);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            int id_alumno = rs.getInt("id_alumno");
            
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, id_alumno);
            ps2.executeUpdate();
            
            }else{
                System.out.println("No se pudo crear soli");
            }
            
            
        }
    }
    
    public static void actualizarEstatusSoli(String nControl, String nuevoStatus) throws SQLException {
    String sql1 = "SELECT id_estatus FROM estatus_soli_residencia WHERE estatus = ?;";
    String sql2 = "SELECT id_alumno FROM alumno WHERE n_control = ?;";
    String sql3 = "UPDATE soli_residencia SET fk_estatus = ? WHERE fk_alumno = ?;";

    try (Connection conn = Conexion.getConexion()) {

        // Obtener id_estatus a partir del nombre del estatus
        int id_estatus;
        try (PreparedStatement ps1 = conn.prepareStatement(sql1)) {
            ps1.setString(1, nuevoStatus);
            try (ResultSet rs1 = ps1.executeQuery()) {
                if (rs1.next()) {
                    id_estatus = rs1.getInt("id_estatus");
                } else {
                    throw new SQLException("Estatus no encontrado: " + nuevoStatus);
                }
            }
        }

        // Obtener id_alumno a partir del nControl
        int id_alumno;
        try (PreparedStatement ps2 = conn.prepareStatement(sql2)) {
            ps2.setString(1, nControl);
            try (ResultSet rs2 = ps2.executeQuery()) {
                if (rs2.next()) {
                    id_alumno = rs2.getInt("id_alumno");
                } else {
                    throw new SQLException("Alumno no encontrado con nControl: " + nControl);
                }
            }
        }

        // Actualizar fk_estatus en soli_residencia
        try (PreparedStatement ps3 = conn.prepareStatement(sql3)) {
            ps3.setInt(1, id_estatus);
            ps3.setInt(2, id_alumno);
            ps3.executeUpdate();
        }

    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
}
    
    public static List<ExpedienteAlumno> obtenerDocumentos(String nControl) throws SQLException {
    List<ExpedienteAlumno> lista = new ArrayList<>();

    String sql = "SELECT d.documento, ea.estatus " +
                 "FROM documentos d " +
                 "LEFT JOIN expediente_alumno ea ON d.id_documento = ea.fk_documento " +
                 "LEFT JOIN alumno a ON ea.fk_alumno = a.id_alumno " +
                 "WHERE a.n_control = ? OR a.n_control IS NULL;";

    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nControl);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String nombreDocumento = rs.getString("documento");
            boolean estatus = rs.getBoolean("estatus");
            boolean isNull = rs.wasNull(); // Detecta si estatus es NULL

            ExpedienteAlumno ea;
            if (isNull) {
                ea = new ExpedienteAlumno(nombreDocumento, false); // No entregado
            } else {
                ea = new ExpedienteAlumno(nombreDocumento, estatus);
            }

            lista.add(ea);
        }
    }

    return lista;
}

    public static void setEstadoDocumento(String nControl, boolean estado, String nombreDocumento) throws SQLException{
        String sql = "UPDATE expediente_alumno ea\n" +
                    "JOIN alumno a ON ea.fk_alumno = a.id_alumno\n" +
                    "JOIN documentos d ON ea.fk_documento = d.id_documento\n" +
                    "SET ea.estatus = ?\n" +
                    "WHERE a.n_control = ? AND d.documento = ?;";
        
         try (Connection conn = Conexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)){
         
                ps.setBoolean(1, estado);
                ps.setString(2, nControl);
                ps.setString(3, nombreDocumento);
                ps.executeUpdate();
         }   
        
    }
}