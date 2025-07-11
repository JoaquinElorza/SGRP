package Modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    public String autenticarUsuario(String usuario, String contrasena) {
        try (Connection conn = Utilidades.Conexion.obtenerConexion()) {
            String sql = "SELECT nombre_usuario FROM usuario WHERE nombre_usuario = ? AND contraseña = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("nombre_usuario"); // éxito
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return null; // falló
    }
}