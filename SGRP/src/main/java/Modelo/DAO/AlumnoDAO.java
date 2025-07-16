package Modelo.DAO;

import Modelo.Entidades.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Utilidades.Conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class AlumnoDAO {

    public boolean agregarAlumno(Alumno alumno) {
    Connection conn = null;
    PreparedStatement psPersona = null;
    PreparedStatement psAlumno = null;
    PreparedStatement psVerificar = null;
    ResultSet rs = null;
    ResultSet rsId = null;

    try {
        conn = Conexion.getConexion();

        // 1. Verificar si el número de control ya existe
        String sqlVerificar = "SELECT COUNT(*) FROM alumno WHERE n_control = ?";
        psVerificar = conn.prepareStatement(sqlVerificar);
        psVerificar.setString(1, alumno.getNumeroControl());
        rs = psVerificar.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(null, "⛔ Ya existe un alumno con el número de control: " + alumno.getNumeroControl());
            return false;
        }

        conn.setAutoCommit(false);

        // 2. Insertar en persona
        String sqlPersona = "INSERT INTO persona (nombre, ap_paterno, ap_materno) VALUES (?, ?, ?)";
        psPersona = conn.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);
        psPersona.setString(1, alumno.getNombre());
        psPersona.setString(2, alumno.getApellidoPaterno());
        psPersona.setString(3, alumno.getApellidoMaterno());
        psPersona.executeUpdate();

        rsId = psPersona.getGeneratedKeys();
        int idPersona = -1;
        if (rsId.next()) {
            idPersona = rsId.getInt(1);
        } else {
            throw new SQLException("❌ No se generó ID para persona.");
        }

        // 3. Insertar en alumno
        String sqlAlumno = "INSERT INTO alumno (n_control, telefono, correo, fk_persona) VALUES (?, ?, ?, ?)";
        psAlumno = conn.prepareStatement(sqlAlumno);
        psAlumno.setString(1, alumno.getNumeroControl());
        psAlumno.setString(2, alumno.getTelefono());
        psAlumno.setString(3, alumno.getCorreo());
        psAlumno.setInt(4, idPersona);
        psAlumno.executeUpdate();

        conn.commit();
        return true;

    } catch (SQLException e) {
        e.printStackTrace();
        try {
            if (conn != null) conn.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    } finally {
        try {
            if (rs != null) rs.close();
            if (rsId != null) rsId.close();
            if (psVerificar != null) psVerificar.close();
            if (psPersona != null) psPersona.close();
            if (psAlumno != null) psAlumno.close();
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
} 

    public static AlumnoCarg consultarAlumno(JTable tablaAlumnos) throws SQLException {
        int fila = tablaAlumnos.getSelectedRow();
        System.out.println("Fila seleccionada: " + fila);
        
        String nControl = tablaAlumnos.getValueAt(fila, 0).toString();
        System.out.println("Consultando alumno con n_control: " + nControl);

        String sql = "SELECT n_control, telefono, nombre, ap_paterno, ap_materno, correo\n" +
                     "FROM alumno join persona on alumno.fk_persona = persona.id_persona\n" +
                     "where n_control= ?;";

        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nControl);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String telefono = rs.getString("telefono");
                String nombre = rs.getString("nombre");
                String ap1 = rs.getString("ap_paterno");
                String ap2 = rs.getString("ap_materno");
                String correo = rs.getString("correo");

            AlumnoCarg alumnoConsultar = new AlumnoCarg(nombre, ap1, ap2, nControl, correo, telefono);    
            return alumnoConsultar;
            } else {
                System.out.println("❌ No se encontró el alumno con ese número de control.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean actualizarAlumno(AlumnoCarg alumno) {

        String obtenerIdPersona = "SELECT fk_persona FROM alumno WHERE n_control = ?";
        String actualizarPersona = "UPDATE persona SET nombre = ?, ap_paterno = ?, ap_materno = ? WHERE id_persona = ?";
        String actualizarAlumno = "UPDATE alumno SET n_control = ?, correo = ?, telefono = ? WHERE fk_persona = ?";

        Connection conn = null;
        PreparedStatement psBuscarPersona = null;
        PreparedStatement psActualizarPersona = null;
        PreparedStatement psActualizarAlumno = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConexion();
            conn.setAutoCommit(false); // Inicia la transacción

            // 1. Obtener ID de persona
            psBuscarPersona = conn.prepareStatement(obtenerIdPersona);
            psBuscarPersona.setString(1, alumno.getNumeroControl());
            rs = psBuscarPersona.executeQuery();

            int id_persona = -1;
            if (rs.next()) {
                id_persona = rs.getInt("fk_persona");
            } else {
                System.out.println("Alumno no encontrado con número de control: " + alumno.getNumeroControl());
                return false;
            }

            // 2. Actualizar datos de persona
            psActualizarPersona = conn.prepareStatement(actualizarPersona);
            psActualizarPersona.setString(1, alumno.getNombre());
            psActualizarPersona.setString(2, alumno.getApellidoPaterno());
            psActualizarPersona.setString(3, alumno.getApellidoMaterno());
            psActualizarPersona.setInt(4, id_persona);
            psActualizarPersona.executeUpdate();

            // 3. Actualizar número de control en alumno
            psActualizarAlumno = conn.prepareStatement(actualizarAlumno);
            psActualizarAlumno.setString(1, alumno.getNumeroControl());
            psActualizarAlumno.setString(2, alumno.getCorreoElectronico());
            psActualizarAlumno.setString(3, alumno.getNumeroTelefono());
            psActualizarAlumno.setInt(4, id_persona);
            psActualizarAlumno.executeUpdate();

            // 4. Confirmar la transacción
            conn.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (psBuscarPersona != null) {
                    psBuscarPersona.close();
                }
                if (psActualizarPersona != null) {
                    psActualizarPersona.close();
                }
                if (psActualizarAlumno != null) {
                    psActualizarAlumno.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean eliminarAlumno(String n_control) {
        //no lo elimina; si su status es "E", no lo muestra en la lista
        String saberPersona = "SELECT FK_PERSONA FROM ALUMNO WHERE N_CONTROL = ?";
        String borrarPersona = "UPDATE persona SET status = 'E' WHERE (id_persona = ?);";

        Connection conn = null;
        PreparedStatement psSaberPersona = null;
        PreparedStatement psBorrarPersona = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConexion();
            conn.setAutoCommit(false); // Iniciar transacción

            // 1. Obtener ID de persona
            psSaberPersona = conn.prepareStatement(saberPersona);
            psSaberPersona.setString(1, n_control);
            rs = psSaberPersona.executeQuery();

            int id_persona = -1;
            if (rs.next()) {
                id_persona = rs.getInt("fk_persona");
            } else {
                System.out.println("No se encontró al alumno con ese número de control.");
                return false;
            }


            // 3. Eliminar a la persona
            psBorrarPersona = conn.prepareStatement(borrarPersona);
            psBorrarPersona.setInt(1, id_persona);
            psBorrarPersona.executeUpdate();

            conn.commit(); // Confirmar transacción
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback(); // Revertir en caso de error
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (psSaberPersona != null) {
                    psSaberPersona.close();
                }
                if (psBorrarPersona != null) {
                    psBorrarPersona.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true); // Restaurar estado original
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<AlumnoCarg> obtenerTodosLosAlumnos() {
        List<AlumnoCarg> lista = new ArrayList<>();
        String sql = "select n_control, nombre, ap_paterno, ap_materno, status from sgrp.alumno join sgrp.persona\n"
                + "on alumno.fk_persona = persona.id_persona;";

        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                if(rs.getString("Status").equals("E")){
                    rs.next();
                }
                AlumnoCarg alumno = new AlumnoCarg();
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellidoPaterno(rs.getString("ap_paterno"));
                alumno.setApellidoMaterno(rs.getString("ap_materno"));
                alumno.setNumeroControl(rs.getString("n_control"));
                lista.add(alumno);
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
