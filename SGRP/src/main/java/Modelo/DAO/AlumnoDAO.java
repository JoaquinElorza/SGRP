package Modelo.DAO;

import Modelo.Entidades.Alumno;
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

    public boolean agregarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (nombre, apellido_paterno, apellido_materno, correo, numero_control) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellidoPaterno());
            ps.setString(3, alumno.getApellidoMaterno());
            ps.setString(4, alumno.getCorreo());
            ps.setString(5, alumno.getNumeroControl());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String[] consultarAlumno(JTable tablaAlumnos) throws SQLException {
        int fila = tablaAlumnos.getSelectedRow();
        if (fila == -1) {
            System.out.println("⚠️ No hay fila seleccionada.");
            return new String[4];
        }

        String nControl = tablaAlumnos.getValueAt(fila, 0).toString();
        System.out.println("🔍 Consultando alumno con n_control: " + nControl);

        String sql = "SELECT a.n_control, a.telefono, p.nombre, p.ap_paterno, p.ap_materno, p.correo "
                + "FROM alumno a JOIN persona p ON a.fk_persona = p.id_persona "
                + "WHERE a.n_control = ?";

        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nControl);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String telefono = rs.getString("telefono");
                String nombre = rs.getString("nombre");
                String ap1 = rs.getString("ap_paterno");
                String ap2 = rs.getString("ap_materno");
                String correo = rs.getString("correo");

                alumnito[0] = nControl;
                alumnito[1] = nombre + " " + ap1 + " " + ap2;
                alumnito[2] = telefono;
                alumnito[3] = correo;
            } else {
                System.out.println("❌ No se encontró el alumno con ese número de control.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alumnito;
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
        String saberPersona = "SELECT FK_PERSONA FROM ALUMNO WHERE N_CONTROL = ?";
        String borrarAlumno = "DELETE FROM alumno WHERE n_control = ?";
        String borrarPersona = "DELETE FROM persona WHERE id_persona = ?";

        Connection conn = null;
        PreparedStatement psSaberPersona = null;
        PreparedStatement psBorrarAlumno = null;
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

            // 2. Eliminar al alumno
            psBorrarAlumno = conn.prepareStatement(borrarAlumno);
            psBorrarAlumno.setString(1, n_control);
            psBorrarAlumno.executeUpdate();

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
                if (psBorrarAlumno != null) {
                    psBorrarAlumno.close();
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
        String sql = "select n_control, nombre, ap_paterno, ap_materno from sgrp.alumno join sgrp.persona\n"
                + "on alumno.fk_persona = persona.id_persona;";

        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
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
