/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Controlador;

import javax.swing.JPanel;
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
public class AcomodarImagenTest {
    
    public AcomodarImagenTest() {
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
     * Test of configurarPanelConImagen method, of class AcomodarImagen.
     */
    @Test
    public void testConfigurarPanelConImagen() {
        JPanel Panel1 = new JPanel();
        System.out.println("configurarPanelConImagen");
        String rutaImagen = "/img/itoLOGO.png";
        JPanel panelDestino = Panel1;
        AcomodarImagen instance = new AcomodarImagen();
        instance.configurarPanelConImagen(rutaImagen, panelDestino);
       
    }
    
}
