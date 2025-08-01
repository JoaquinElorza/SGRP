package Modelo.DAO;

import Modelo.Entidades.EmpresaEntidad;
import Modelo.Entidades.Proyecto;
import Utilidades.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.Entidades.Anteproyecto;

public class ProyectoDAO {

    public boolean actualizarProyecto(Proyecto proyecto) {
        String sql = "UPDATE proyecto SET nombre = ?, descripcion = ?, estatus = ?, fk_empresa = ? WHERE id_proyecto = ?";

        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getDescripcion());
            ps.setString(3, proyecto.getEstatus());
            ps.setInt(4, proyecto.getIdEmpresa());
            ps.setInt(5, proyecto.getIdProyecto());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Proyecto buscarPorNombre(String nombre) {
        Proyecto proyecto = null;
        String sql = "SELECT * FROM proyecto WHERE nombre = ?";

        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                proyecto = new Proyecto();
                proyecto.setIdProyecto(rs.getInt("id_proyecto"));
                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setEstatus(rs.getString("estatus"));
                proyecto.setIdEmpresa(rs.getInt("fk_empresa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proyecto;
    }

    public boolean eliminarProyecto(int idProyecto) {
        String sql = "DELETE FROM proyecto WHERE id_proyecto = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idProyecto);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean agregarProyecto(Proyecto proyecto) {
        String sql = "INSERT INTO proyecto (fk_empresa, nombre, descripcion, estatus) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, proyecto.getIdEmpresa());
            ps.setString(2, proyecto.getNombre());
            ps.setString(3, proyecto.getDescripcion());
            ps.setString(4, proyecto.getEstatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Proyecto> obtenerTodos() {
        List<Proyecto> lista = new ArrayList<>();
        String sql = "SELECT * FROM proyecto";

        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Proyecto p = new Proyecto();
                p.setIdProyecto(rs.getInt("id_proyecto"));
                p.setIdEmpresa(rs.getInt("fk_empresa"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setEstatus(rs.getString("estatus"));

                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean existeNombreProyecto(String nombre) {
        String sql = "SELECT COUNT(*) FROM proyecto WHERE nombre = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean existeNombreProyectoConOtroId(String nombre, int idActual) {
        String sql = "SELECT COUNT(*) FROM proyecto WHERE nombre = ? AND id_proyecto != ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setInt(2, idActual);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void cambiarEstatus(int idProyecto, String nuevoEstatus) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "UPDATE proyecto SET estatus = ? WHERE id_proyecto = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nuevoEstatus);
            pst.setInt(2, idProyecto);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Anteproyecto obtenerAnteproyectoPorNombre(String nombre) {
        String sql = "SELECT * FROM anteproyecto WHERE nombre = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Anteproyecto ap = new Anteproyecto();
                ap.setNombre(rs.getString("nombre"));
                ap.setDescripcion(rs.getString("descripcion"));
                ap.setLineaInvestigacion(rs.getString("linea_investigacion"));
                ap.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                ap.setEstado(rs.getString("estado"));
                ap.setUsuarioRegistro(rs.getString("usuario_registro"));
                ap.setFkAlumno(rs.getInt("fk_alumno"));
                ap.setRfcEmpresa(rs.getString("rfc_empresa"));
                return ap;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Proyecto obtenerProyectoPorId(int id) {
        String sql = "SELECT * FROM proyecto WHERE id_proyecto = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Proyecto p = new Proyecto();
                p.setIdProyecto(id);
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setEstatus(rs.getString("estatus"));
                p.setIdEmpresa(rs.getInt("id_empresa"));
                p.setFechaRegistro(rs.getDate("fecha_registro"));
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Proyecto> obtenerProyectosPorSemestre(int año, int semestre) {
        List<Proyecto> lista = new ArrayList<>();

        String sql = """
        SELECT p.id_proyecto, p.nombre, p.descripcion, p.estatus, p.fk_empresa,
               e.nombre AS nombre_empresa
        FROM proyecto p
        JOIN empresa e ON p.fk_empresa = e.id_empresa
        WHERE YEAR(p.fecha_registro) = ? AND 
              MONTH(p.fecha_registro) BETWEEN ? AND ?
    """;

        int mesInicio = (semestre == 1) ? 1 : 7;
        int mesFin = (semestre == 1) ? 6 : 12;

        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, año);
            ps.setInt(2, mesInicio);
            ps.setInt(3, mesFin);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Proyecto p = new Proyecto();
                p.setIdProyecto(rs.getInt("id_proyecto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setEstatus(rs.getString("estatus"));
                p.setIdEmpresa(rs.getInt("fk_empresa"));

                // Crear la empresa
                EmpresaEntidad empresa = new EmpresaEntidad();
                empresa.setIdEmpresa(rs.getInt("fk_empresa"));
                empresa.setNombre(rs.getString("nombre_empresa"));
                p.setEmpresa(empresa); // 👉 Asegúrate de tener este setter en tu modelo Proyecto

                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Anteproyecto obtenerAnteproyectoPorId(int id) {
        String sql = "SELECT * FROM anteproyecto WHERE id_anteproyecto = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Anteproyecto ap = new Anteproyecto();
                ap.setIdAnteproyecto(rs.getInt("id_anteproyecto"));
                ap.setNombre(rs.getString("nombre"));
                ap.setDescripcion(rs.getString("descripcion"));
                ap.setLineaInvestigacion(rs.getString("linea_investigacion"));
                ap.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                ap.setEstado(rs.getString("estado"));
                ap.setUsuarioRegistro(rs.getString("usuario_registro"));
                ap.setFkAlumno(rs.getInt("fk_alumno"));
                ap.setRfcEmpresa(rs.getString("rfc_empresa"));
                return ap;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Integer> obtenerAniosConProyectos() {
        List<Integer> anios = new ArrayList<>();
        String sql = "SELECT DISTINCT YEAR(fecha_registro) AS anio FROM proyecto ORDER BY anio DESC";

        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                anios.add(rs.getInt("anio"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return anios;
    }
}
