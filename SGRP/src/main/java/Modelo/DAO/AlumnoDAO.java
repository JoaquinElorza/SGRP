package Modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Utilidades.Conexion; 
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JTable;


public class AlumnoDAO {
    public static String[] alumnito = new String[4]; 
    
    public void insertarAlumno() {
        
    }
    
    public static String[] consultarAlumno(JTable tablaAlumnos) throws SQLException{
       int Fila = tablaAlumnos.getSelectedRow();
       String nControl = tablaAlumnos.getValueAt(Fila,0).toString();
       
       
       Connection conn = Conexion.getConexion();
        String sql = "SELECT telefono, nombre, ap_paterno, ap_materno, correo\n" +
                     "FROM sgrp.alumno join sgrp.persona on alumno.fk_persona = persona.id_persona\n" +
                     "where n_control= ?;";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nControl);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String telefono = rs.getString("telefono");
                String nombre = rs.getString("nombre");
                String ap1 = rs.getString("ap_paterno");
                String ap2 = rs.getString("ap_materno");
                String correo = rs.getString("correo");
                alumnito[0]=nControl;
                alumnito[1]=(nombre + " " + ap1 + " " + ap2);
                alumnito[2]=telefono;
                alumnito[3]=correo;
            } else {
                System.out.println("No se encontró ningún alumno con ese número de control.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnito;
    }
    
    public void actualizarAlumno() {
        
    }
    
    public boolean eliminarAlumno(String n_control) {
        String sql = "DELETE FROM alumno WHERE n_control = ?";
        try (
            Connection conn = Conexion.getConexion();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, n_control);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<AlumnoCarg> obtenerTodosLosAlumnos() {
    List<AlumnoCarg> lista = new ArrayList<>();
    String sql = "SELECT id, nombre, apellido_paterno, apellido_materno, numero_control, correo_electronico, numero_telefono FROM alumnos";

    try (Connection conn = Conexx.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            AlumnoCarg alumno = new AlumnoCarg();
            alumno.setId(rs.getInt("id"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setApellidoPaterno(rs.getString("apellido_paterno"));
            alumno.setApellidoMaterno(rs.getString("apellido_materno"));
            alumno.setNumeroControl(rs.getString("numero_control"));
            alumno.setCorreoElectronico(rs.getString("correo_electronico"));
            alumno.setNumeroTelefono(rs.getString("numero_telefono"));
            lista.add(alumno);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
} 

    public AlumnoCarg buscarPorNumeroControl(String numeroControl) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
