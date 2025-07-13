package Modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Utilidades.Conexion; 
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import Modelo.DAO.AlumnoCarg;


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
    public List<AlumnoCarg> obtenerTodosLosAlumnos() {
    List<AlumnoCarg> lista = new ArrayList<>();
    String sql = "SELECT id, nombre, apellido_paterno, apellido_materno, numero_control, correo_electronico, numero_telefono FROM alumnos";

    try (Connection conn = Conexx.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            AlumnoCarg alumno = new AlumnoCarg();
            alumno.setId(rs.getInt("id"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setApellidoPaterno(rs.getString("apellido_paterno"));
            alumno.setApellidoMaterno(rs.getString("apellido_materno"));
            alumno.setNumeroControl(rs.getString("numero_control"));
            alumno.setCorreoElectronico(rs.getString("correo_electronico"));
            alumno.setNumeroTelefono(rs.getString("numero_telefono"));
            lista.add(alumno);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
} 

    public AlumnoCarg buscarPorNumeroControl(String numeroControl) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
