package Modelo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexx {
    public static Connection getConexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sistema_alumnos";
        String usuario = "root";
        String clave = "manzana";
        return DriverManager.getConnection(url, usuario, clave);
    }
}
