package Utilidades;

import java.sql.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jobae
 */
public class ConexionTest {
    
    public ConexionTest() {
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
     * Test of getConexion method, of class Conexion.
     */
    @Test
    public void testGetConexion() throws Exception {
        System.out.println("getConexion");
        Connection result = Conexion.getConexion();
        assertNotNull(result, "La conexion no puede ser null");
        assertFalse(result.isClosed(), "La conexion debe estar abierta");
        
        result.close();
    }
    
}
