package Modelo.DAO;

import Modelo.Entidades.Alumno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Utilidades.Conexion;
import java.util.HashMap;
import java.util.Map;

public class AlumnoDAO {

    // Agrega un nuevo alumno y persona en transacción
    public boolean agregarAlumno(Alumno alumno) {
        Connection conn = null;
        PreparedStatement psPersona = null;
        PreparedStatement psAlumno = null;
        PreparedStatement psVerificar = null;
        ResultSet rs = null;
        ResultSet rsId = null;

        try {
            conn = Conexion.getConexion();

            String sqlVerificar = 
                "SELECT COUNT(*) FROM alumno a " +
                "JOIN persona p ON a.fk_persona = p.id_persona " +
                "WHERE a.n_control = ? AND (p.status IS NULL OR p.status <> 'E')";
            psVerificar = conn.prepareStatement(sqlVerificar);
            psVerificar.setString(1, alumno.getNumeroControl());
            rs = psVerificar.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null,
                    "⛔ Ya existe un alumno activo con ese número de control.");
                return false;
            }

            conn.setAutoCommit(false);

            String sqlPersona = 
                "INSERT INTO persona (nombre, ap_paterno, ap_materno, status) " +
                "VALUES (?, ?, ?, ?)";
            psPersona = conn.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);
            psPersona.setString(1, alumno.getNombre());
            psPersona.setString(2, alumno.getApellidoPaterno());
            psPersona.setString(3, alumno.getApellidoMaterno());
            psPersona.setString(4, "A");
            psPersona.executeUpdate();

            rsId = psPersona.getGeneratedKeys();
            int idPersona = rsId.next() ? rsId.getInt(1) : -1;

            String sqlAlumno = 
                "INSERT INTO alumno (n_control, telefono, correo, fk_persona) " +
                "VALUES (?, ?, ?, ?)";
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

    // Consulta un alumno activo por número de control
    public AlumnoCarg consultarAlumno(String nControl) throws SQLException {
        String sql = 
            "SELECT a.n_control, a.telefono, a.correo, " +
            "p.nombre, p.ap_paterno, p.ap_materno " +
            "FROM alumno a " +
            "JOIN persona p ON a.fk_persona = p.id_persona " +
            "WHERE a.n_control = ? AND (p.status IS NULL OR p.status <> 'E')";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
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

    // Verifica existencia de número de control activo
    public boolean existeNumeroControl(String numeroControl) {
        String sql = 
            "SELECT COUNT(*) FROM alumno a " +
            "JOIN persona p ON a.fk_persona = p.id_persona " +
            "WHERE a.n_control = ? AND (p.status IS NULL OR p.status <> 'E')";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, numeroControl);
            ResultSet rs = ps.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Actualiza alumno/persona usando el control ORIGINAL en el WHERE
    public boolean actualizarAlumno(AlumnoCarg alumno, String controlOriginal) {
        String sqlBuscar = "SELECT fk_persona FROM alumno WHERE n_control = ?";
        String sqlUpdPersona = 
            "UPDATE persona SET nombre = ?, ap_paterno = ?, ap_materno = ? " +
            "WHERE id_persona = ?";
        String sqlUpdAlumno = 
            "UPDATE alumno SET n_control = ?, correo = ?, telefono = ? " +
            "WHERE fk_persona = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement psBuscar = conn.prepareStatement(sqlBuscar)) {

            conn.setAutoCommit(false);
            psBuscar.setString(1, controlOriginal);
            ResultSet rs = psBuscar.executeQuery();
            if (!rs.next()) {
                conn.rollback();
                return false;
            }
            int idPersona = rs.getInt("fk_persona");

            try (PreparedStatement psP = conn.prepareStatement(sqlUpdPersona);
                 PreparedStatement psA = conn.prepareStatement(sqlUpdAlumno)) {

                psP.setString(1, alumno.getNombre());
                psP.setString(2, alumno.getApellidoPaterno());
                psP.setString(3, alumno.getApellidoMaterno());
                psP.setInt(4, idPersona);
                psP.executeUpdate();

                psA.setString(1, alumno.getNumeroControl());
                psA.setString(2, alumno.getCorreoElectronico());
                psA.setString(3, alumno.getNumeroTelefono());
                psA.setInt(4, idPersona);
                psA.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Versión obsoleta o de conveniencia (sin control original)
    public boolean actualizarAlumno(AlumnoCarg alumno) {
        return actualizarAlumno(alumno, alumno.getNumeroControl());
    }

    // Marca persona como eliminada
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

    // Obtiene id_persona dado un número de control
    public int obtenerIdPersonaPorNumeroControl(String nControl) {
        String sql = "SELECT fk_persona FROM alumno WHERE n_control = ?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nControl);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("fk_persona");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Lista todos los alumnos activos
    public List<AlumnoCarg> obtenerTodosLosAlumnos() {
        List<AlumnoCarg> lista = new ArrayList<>();
        String sql = 
            "SELECT a.n_control, a.telefono, a.correo, p.nombre, p.ap_paterno, p.ap_materno " +
            "FROM alumno a " +
            "JOIN persona p ON a.fk_persona = p.id_persona " +
            "WHERE (p.status IS NULL OR p.status <> 'E')";

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
    
    public static List<Alumno> obtenerAlumnosSinProyecto() {
           List<Alumno> lista = new ArrayList<>();
           try (Connection con = Conexion.getConexion()) {
               String sql = "SELECT a.*, p.nombre, p.ap_paterno, p.ap_materno " +
                            "FROM alumno a " +
                            "JOIN persona p ON a.fk_persona = p.id_persona " +
                            "WHERE a.fk_proyecto IS NULL";
               PreparedStatement pst = con.prepareStatement(sql);
               ResultSet rs = pst.executeQuery();

               while (rs.next()) {
                   Alumno a = new Alumno();
                   a.setIdPersona(rs.getInt("fk_persona"));  // o usa setIdAlumno según tu modelo
                   a.setNombre(rs.getString("nombre"));
                   a.setApellidoPaterno(rs.getString("ap_paterno"));
                   a.setApellidoMaterno(rs.getString("ap_materno"));
                   lista.add(a);
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
           return lista;
       }
        
    public static Map<String, List<String>> obtenerPendientes() throws SQLException {
    Map<String, List<String>> pendientes = new HashMap<>();

    String sql = """
                 SELECT 
                     a.n_control,
                     d.documento
                 FROM 
                     alumno a
                 JOIN
                 \tpersona p on p.id_persona = a.fk_persona
                 CROSS JOIN 
                     documentos d
                 LEFT JOIN 
                     expediente_alumno ea ON ea.fk_alumno = a.id_alumno AND ea.fk_documento = d.id_documento
                 WHERE 
                     (ea.estatus = 0 OR ea.estatus IS NULL)
                     AND p.status<>'E';""";

    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            String nControl = rs.getString("n_control");
            String documento = rs.getString("documento");

            // Agregar a la lista del alumno
            pendientes.computeIfAbsent(nControl, k -> new ArrayList<>()).add(documento);
        }
    }

    return pendientes;
}

}
