package Modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Utilidades.Conexion; 

public class AlumnoDAO {
    
    public boolean eliminarAlumno(int id) {
        String sql = "DELETE FROM alumno WHERE id = ?";
        try (
            Connection conn = Conexion.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
