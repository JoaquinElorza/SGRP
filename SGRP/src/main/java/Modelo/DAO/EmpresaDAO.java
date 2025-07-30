/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Entidades.EmpresaEntidad;
import Utilidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class EmpresaDAO {

    public boolean insertarEmpresa(EmpresaEntidad empresa) {
        String sql = "INSERT INTO empresa(nombre, contacto, correo, rfc, direccion, descripcion) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, empresa.getNombre());
            ps.setString(2, empresa.getContacto());
            ps.setString(3, empresa.getCorreo());
            ps.setString(4, empresa.getRfc());
            ps.setString(5, empresa.getDireccion());
            ps.setString(6, empresa.getDescripcion());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar empresa: " + e.getMessage());
            return false;
        }
    }

    public List<EmpresaEntidad> listarEmpresas() {
        List<EmpresaEntidad> lista = new ArrayList<>();
        String sql = "SELECT * FROM empresa WHERE activo = true";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                EmpresaEntidad emp = new EmpresaEntidad();
                emp.setIdEmpresa(rs.getInt("id_empresa"));
                emp.setNombre(rs.getString("nombre"));
                emp.setContacto(rs.getString("contacto"));
                emp.setCorreo(rs.getString("correo"));
                emp.setRfc(rs.getString("rfc"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setDescripcion(rs.getString("descripcion"));

                lista.add(emp);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar empresas: " + e.getMessage());
        }

        return lista;
    }

    public boolean actualizarEmpresa(EmpresaEntidad empresa) {
        String sql = "UPDATE empresa SET nombre = ?, contacto = ?, correo = ?, rfc = ?, direccion = ?, descripcion = ? WHERE id_empresa = ?";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, empresa.getNombre());
            ps.setString(2, empresa.getContacto());
            ps.setString(3, empresa.getCorreo());
            ps.setString(4, empresa.getRfc());
            ps.setString(5, empresa.getDireccion());
            ps.setString(6, empresa.getDescripcion());
            ps.setInt(7, empresa.getIdEmpresa());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar empresa: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "UPDATE empresa SET activo = false WHERE id_empresa = ?";
        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean existeNombre(String nombre) {
        String sql = "SELECT COUNT(*) FROM empresa WHERE nombre = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean existeContacto(String contacto) {
        String sql = "SELECT COUNT(*) FROM empresa WHERE contacto = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contacto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean existeNombreExcepto(String nombre, int idEmpresa) {
        String sql = "SELECT COUNT(*) FROM empresa WHERE nombre = ? AND id_empresa != ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setInt(2, idEmpresa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean existeContactoExcepto(String contacto, int idEmpresa) {
        String sql = "SELECT COUNT(*) FROM empresa WHERE contacto = ? AND id_empresa != ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contacto);
            stmt.setInt(2, idEmpresa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean existeRfc(String rfc) {
        String sql = "SELECT COUNT(*) FROM empresa WHERE rfc = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, rfc);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean existeRfcExcepto(String rfc, int idEmpresa) {
        String sql = "SELECT COUNT(*) FROM empresa WHERE rfc = ? AND id_empresa != ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, rfc);
            stmt.setInt(2, idEmpresa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
