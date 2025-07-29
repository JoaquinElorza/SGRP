package Modelo.DAO;

import Modelo.Entidades.Proyecto;
import Utilidades.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAO {
    
    public boolean actualizarProyecto(Proyecto proyecto) {
    String sql = "UPDATE proyecto SET nombre = ?, descripcion = ?, estatus = ?, fk_empresa = ? WHERE id_proyecto = ?";

    try (Connection conn = Conexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

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

    public boolean eliminarProyecto(int idProyecto) {
    String sql = "DELETE FROM proyecto WHERE id_proyecto = ?";
    try (Connection conn = Conexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, idProyecto);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    
    
    
    
    

    public boolean agregarProyecto(Proyecto proyecto) {
        String sql = "INSERT INTO proyecto (fk_empresa, nombre, descripcion, estatus) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

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

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

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
    try (Connection conn = Conexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {
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
    try (Connection conn = Conexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {
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
    
    


        public static Proyecto obtenerProyectoPorId(int id) {
            String sql = "SELECT * FROM proyecto WHERE id_proyecto = ?";
            try (Connection conn = Conexion.getConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Proyecto p = new Proyecto();
                    p.setIdProyecto(id);
                    p.setNombre(rs.getString("nombre"));
                    p.setDescripcion(rs.getString("descripcion"));
                    p.setEstatus(rs.getString("estatus"));
                    p.setIdEmpresa(rs.getInt("id_empresa"));
                    return p;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    
    
    
    
    
    
}
