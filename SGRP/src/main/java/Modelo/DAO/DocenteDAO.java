package Modelo.DAO;

import Utilidades.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DocenteDAO {

    public boolean agregarDocente(DocenteCarg d) {
        String sqlPersona = "INSERT INTO persona (nombre, ap_paterno, ap_materno, status) VALUES (?, ?, ?, 'A')";
        String sqlDocente = "INSERT INTO docente (rfc, telefono, correo, fk_persona) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.getConexion()) {
            conn.setAutoCommit(false);

            try (PreparedStatement psPersona = conn.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS)) {
                psPersona.setString(1, d.getNombre());
                psPersona.setString(2, d.getApellidoPaterno());
                psPersona.setString(3, d.getApellidoMaterno());
                psPersona.executeUpdate();

                ResultSet rs = psPersona.getGeneratedKeys();
                int idPersona = rs.next() ? rs.getInt(1) : -1;

                try (PreparedStatement psDocente = conn.prepareStatement(sqlDocente)) {
                    psDocente.setString(1, d.getRfc());
                    psDocente.setString(2, d.getTelefono());
                    psDocente.setString(3, d.getCorreo());
                    psDocente.setInt(4, idPersona);
                    psDocente.executeUpdate();
                }

                conn.commit();
                return true;

            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public int consultarIdPorRFC(String rfc) {
    int idDocente = -1; // Valor por defecto si no se encuentra

    String query = "SELECT id_docente FROM docente WHERE rfc = ?";

    try (Connection conn = Conexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(query)) {

        ps.setString(1, rfc.trim().toUpperCase());

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                idDocente = rs.getInt("id_docente");
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al consultar ID del docente: " + e.getMessage());
    }

    return idDocente;
}

    public List<DocenteCarg> obtenerTodos() {
        String sql = "SELECT d.rfc, p.nombre, p.ap_paterno, p.ap_materno, d.telefono, d.correo " +
                     "FROM docente d JOIN persona p ON d.fk_persona = p.id_persona WHERE p.status = 'A'";
        List<DocenteCarg> lista = new ArrayList<>();

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DocenteCarg d = new DocenteCarg();
                d.setRfc(rs.getString("rfc"));
                d.setNombre(rs.getString("nombre"));
                d.setApellidoPaterno(rs.getString("ap_paterno"));
                d.setApellidoMaterno(rs.getString("ap_materno"));
                d.setTelefono(rs.getString("telefono"));
                d.setCorreo(rs.getString("correo"));
                lista.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public DocenteCarg consultarPorRFC(String rfc) {
        String sql = "SELECT d.rfc, p.nombre, p.ap_paterno, p.ap_materno, d.telefono, d.correo " +
                     "FROM docente d JOIN persona p ON d.fk_persona = p.id_persona " +
                     "WHERE d.rfc = ? AND p.status = 'A'";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, rfc);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                DocenteCarg d = new DocenteCarg();
                d.setRfc(rs.getString("rfc"));
                d.setNombre(rs.getString("nombre"));
                d.setApellidoPaterno(rs.getString("ap_paterno"));
                d.setApellidoMaterno(rs.getString("ap_materno"));
                d.setTelefono(rs.getString("telefono"));
                d.setCorreo(rs.getString("correo"));
                return d;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean eliminarDocente(String rfc) {
        String sql = "UPDATE persona SET status = 'E' WHERE id_persona = " +
                     "(SELECT fk_persona FROM docente WHERE rfc = ?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, rfc);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<DocenteCarg> consultarPorRFCParcial(String rfcParcial) {
    String sql = "SELECT d.rfc, p.nombre, p.ap_paterno, p.ap_materno, d.telefono, d.correo " +
                 "FROM docente d JOIN persona p ON d.fk_persona = p.id_persona " +
                 "WHERE d.rfc LIKE ? AND p.status = 'A'";
    List<DocenteCarg> lista = new ArrayList<>();

    try (Connection conn = Conexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, rfcParcial + "%"); // 👈 RFC parcial
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            DocenteCarg d = new DocenteCarg();
            d.setRfc(rs.getString("rfc"));
            d.setNombre(rs.getString("nombre"));
            d.setApellidoPaterno(rs.getString("ap_paterno"));
            d.setApellidoMaterno(rs.getString("ap_materno"));
            d.setTelefono(rs.getString("telefono"));
            d.setCorreo(rs.getString("correo"));
            lista.add(d);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}
    public List<DocenteCarg> consultarTodos() {
    return obtenerTodos();
}

    public boolean actualizarDocente(DocenteCarg docente, String rfcOriginal) {
        String obtenerIdPersona = 
            "SELECT d.fk_persona FROM docente d JOIN persona p ON d.fk_persona = p.id_persona " +
            "WHERE d.rfc = ? AND p.status = 'A'";

        String actualizarPersona = 
            "UPDATE persona SET nombre = ?, ap_paterno = ?, ap_materno = ? WHERE id_persona = ?";

        String actualizarDocente = 
            "UPDATE docente SET rfc = ?, telefono = ?, correo = ? WHERE fk_persona = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement psBuscar = conn.prepareStatement(obtenerIdPersona)) {

            conn.setAutoCommit(false);

            psBuscar.setString(1, rfcOriginal);
            ResultSet rs = psBuscar.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "⚠️ El docente no está activo o no existe.");
                conn.rollback();
                return false;
            }

            int idPersona = rs.getInt("fk_persona");

            try (PreparedStatement psPersona = conn.prepareStatement(actualizarPersona);
                 PreparedStatement psDocente = conn.prepareStatement(actualizarDocente)) {

                psPersona.setString(1, docente.getNombre());
                psPersona.setString(2, docente.getApellidoPaterno());
                psPersona.setString(3, docente.getApellidoMaterno());
                psPersona.setInt(4, idPersona);
                psPersona.executeUpdate();

                psDocente.setString(1, docente.getRfc());
                psDocente.setString(2, docente.getTelefono());
                psDocente.setString(3, docente.getCorreo());
                psDocente.setInt(4, idPersona);
                psDocente.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean existeRFC(String rfc) {
        String sql = "SELECT COUNT(*) FROM docente d JOIN persona p ON d.fk_persona = p.id_persona WHERE d.rfc = ? AND p.status = 'A'";
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, rfc);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
