package Modelo.DAO;

import Modelo.Entidades.Alumno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Utilidades.Conexion;

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

            String sqlVerificar = "SELECT COUNT(*) FROM alumno a JOIN persona p ON a.fk_persona = p.id_persona WHERE a.n_control = ? AND p.status = 'A'";
            psVerificar = conn.prepareStatement(sqlVerificar);
            psVerificar.setString(1, alumno.getNumeroControl());
            rs = psVerificar.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "⛔ Ya existe un alumno activo con ese número de control.");
                return false;
            }

            conn.setAutoCommit(false);

            String sqlPersona = "INSERT INTO persona (nombre, ap_paterno, ap_materno, status) VALUES (?, ?, ?, ?)";
            psPersona = conn.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);
            psPersona.setString(1, alumno.getNombre());
            psPersona.setString(2, alumno.getApellidoPaterno());
            psPersona.setString(3, alumno.getApellidoMaterno());
            psPersona.setString(4, "A");
            psPersona.executeUpdate();

            rsId = psPersona.getGeneratedKeys();
            int idPersona = rsId.next() ? rsId.getInt(1) : -1;

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
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
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

    public AlumnoCarg consultarAlumno(String nControl) throws SQLException {
        String sql = "SELECT a.n_control, a.telefono, a.correo, " +
                     "p.nombre, p.ap_paterno, p.ap_materno " +
                     "FROM alumno a " +
                     "JOIN persona p ON a.fk_persona = p.id_persona " +
                     "WHERE a.n_control = ? AND p.status = 'A'";

        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nControl);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                AlumnoCarg alumno = new AlumnoCarg();
                alumno.setNumeroControl(rs.getString("n_control"));
                alumno.setNumeroTelefono(rs.getString("telefono"));
                alumno.setCorreoElectronico(rs.getString("correo"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellidoPaterno(rs.getString("ap_paterno"));
                alumno.setApellidoMaterno(rs.getString("ap_materno"));
                return alumno;
            }
        }

        return null;
    }

    public boolean actualizarAlumno(AlumnoCarg alumno) {
        String obtenerIdPersona = "SELECT fk_persona FROM alumno WHERE n_control = ?";
        String actualizarPersona = "UPDATE persona SET nombre = ?, ap_paterno = ?, ap_materno = ? WHERE id_persona = ?";
        String actualizarAlumno = "UPDATE alumno SET n_control = ?, correo = ?, telefono = ? WHERE fk_persona = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement psBuscar = conn.prepareStatement(obtenerIdPersona)) {

            conn.setAutoCommit(false);

            psBuscar.setString(1, alumno.getNumeroControl());
            ResultSet rs = psBuscar.executeQuery();

            if (!rs.next()) return false;
            int id_persona = rs.getInt("fk_persona");

            try (PreparedStatement psPersona = conn.prepareStatement(actualizarPersona);
                 PreparedStatement psAlumno = conn.prepareStatement(actualizarAlumno)) {

                psPersona.setString(1, alumno.getNombre());
                psPersona.setString(2, alumno.getApellidoPaterno());
                psPersona.setString(3, alumno.getApellidoMaterno());
                psPersona.setInt(4, id_persona);
                psPersona.executeUpdate();

                psAlumno.setString(1, alumno.getNumeroControl());
                psAlumno.setString(2, alumno.getCorreoElectronico());
                psAlumno.setString(3, alumno.getNumeroTelefono());
                psAlumno.setInt(4, id_persona);
                psAlumno.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarAlumno(int idPersona) {
        String sql = "UPDATE persona SET status = 'E' WHERE id_persona = ?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPersona);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<AlumnoCarg> obtenerTodosLosAlumnos() {
        List<AlumnoCarg> lista = new ArrayList<>();
        String sql = "SELECT a.n_control, a.telefono, a.correo, p.nombre, p.ap_paterno, p.ap_materno " +
                     "FROM alumno a " +
                     "JOIN persona p ON a.fk_persona = p.id_persona " +
                     "WHERE p.status = 'A'";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                AlumnoCarg alumno = new AlumnoCarg();
                alumno.setNumeroControl(rs.getString("n_control"));
                alumno.setNumeroTelefono(rs.getString("telefono"));
                alumno.setCorreoElectronico(rs.getString("correo"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellidoPaterno(rs.getString("ap_paterno"));
                alumno.setApellidoMaterno(rs.getString("ap_materno"));
                lista.add(alumno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
