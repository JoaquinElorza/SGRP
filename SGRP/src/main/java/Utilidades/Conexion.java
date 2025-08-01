package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/sgrp?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "manzana";

    
    //contraseña emilio: 090774
    //contraseña yahir: manzana
    //contraseña Baruc: E@e$l@c@d3m7s1

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }   

    public static Connection getConnection() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/sgrp?serverTimezone=UTC";
    String user = "root";
    String password = "manzana";
    
       //contraseña emilio: 090774
    //contraseña yahir: manzana
    //contraseña Baruc: E@e$l@c@d3m7s1
    
    return DriverManager.getConnection(url, user, password);
}

}