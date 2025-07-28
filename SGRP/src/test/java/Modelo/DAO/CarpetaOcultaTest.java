package Modelo.DAO;

import java.awt.Component;
import java.io.File;
import java.nio.file.Path;
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
public class CarpetaOcultaTest {
    
    public CarpetaOcultaTest() {
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
     * Test of crearCarpetaBaseOculta method, of class CarpetaOculta.
     */
    @Test
    public void testCrearCarpetaBaseOculta() {
        System.out.println("crearCarpetaBaseOculta");
        CarpetaOculta.crearCarpetaBaseOculta();
    }

    /**
     * Test of getExtension method, of class CarpetaOculta.
     */
    @Test
    public void testGetExtension() {
        System.out.println("getExtension");
        File file = new File("C:\\Users\\Jobae\\Desktop\\Proceso residenciadrawio.pdf");
        String expResult = "pdf";
        String result = CarpetaOculta.getExtension(file);
        assertEquals(expResult, result);
    }

    /**
     * Test of copiarArchivoPDF method, of class CarpetaOculta.
     */
    @Test
    public void testCopiarArchivoPDF() {
        System.out.println("copiarArchivoPDF");
        File archivoOriginal = new File("C:\\Users\\Jobae\\Pictures\\formatoEnfrente.jpg");
        String numeroControl = "22161052";
        String nuevoNombre = "solicitud Prueba";
        Component parentComponent = null;
        boolean expResult = true;
        boolean result = CarpetaOculta.copiarArchivoPDF(archivoOriginal, numeroControl, nuevoNombre, parentComponent);
        assertEquals(expResult, result);
    }

    /**
     * Test of abrirPDF method, of class CarpetaOculta.
     */
    @Test
    public void testAbrirPDF() {
        System.out.println("abrirPDF");
        String nombreSinExtension = "";
        String carpeta = "";
        CarpetaOculta.abrirPDF(nombreSinExtension, carpeta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarArchivo method, of class CarpetaOculta.
     */
    @Test
    public void testEliminarArchivo() {
        System.out.println("eliminarArchivo");
        Path archivo = null;
        boolean expResult = false;
        boolean result = CarpetaOculta.eliminarArchivo(archivo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
