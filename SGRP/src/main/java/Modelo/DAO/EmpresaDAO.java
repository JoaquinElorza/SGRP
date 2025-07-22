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
        String sql = "INSERT INTO empresa(nombre, contacto) VALUES (?, ?)";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, empresa.getNombre());
            ps.setString(2, empresa.getContacto());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar empresa: " + e.getMessage());
            return false;
        }
    }

    public List<Modelo.Entidades.EmpresaEntidad> listarEmpresas() {
        List<Modelo.Entidades.EmpresaEntidad> lista = new ArrayList<>();
        String sql = "SELECT * FROM empresa";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Modelo.Entidades.EmpresaEntidad emp = new Modelo.Entidades.EmpresaEntidad();
                emp.setIdEmpresa(rs.getInt("id_empresa"));
                emp.setNombre(rs.getString("nombre"));
                emp.setContacto(rs.getString("contacto"));
                lista.add(emp);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar empresas: " + e.getMessage());
        }

        return lista;
    }

    public boolean actualizarEmpresa(EmpresaEntidad empresa) {
        String sql = "UPDATE empresa SET nombre = ?, contacto = ? WHERE id_empresa = ?";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, empresa.getNombre());
            ps.setString(2, empresa.getContacto());
            ps.setInt(3, empresa.getIdEmpresa());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar empresa: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM empresa WHERE id_empresa = ?";
        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
