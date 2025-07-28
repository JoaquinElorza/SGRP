/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo.DAO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author emili
 */
public class LoginDAOTest {
    
    public LoginDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of autenticarUsuario method, of class LoginDAO.
     */
    @Test
    public void testAutenticarUsuario() {
        System.out.println("autenticarUsuario");
        String usuario = "emilio";
        String contrasena = "090774";
        LoginDAO instance = new LoginDAO();
        String expResult = "emilio";
        String result = instance.autenticarUsuario(usuario, contrasena);
        assertEquals(expResult, result);
       
    }
    
}
