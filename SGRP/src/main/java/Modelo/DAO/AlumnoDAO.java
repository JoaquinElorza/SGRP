package Modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Utilidades.Conexion; 

public class AlumnoDAO {
    
    public void insertarAlumno() {
        
    }
    
    public void actualizarAlumno() {
        
    }
    
    public boolean eliminarAlumno(String n_control) {
        String sql = "DELETE FROM alumno WHERE n_control = ?";
        try (
            Connection conn = Conexion.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, n_control);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
