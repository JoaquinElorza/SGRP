package Modelo.DAO;

import java.awt.Component;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    
    String archivoPrueba = "C:\\Users\\Jobae\\Desktop\\Proceso residenciadrawio.pdf";
    
    
    public CarpetaOcultaTest() {
    } 
    
    @BeforeAll
    public static void setUpClass() {
       // System.out.println("setup class before all");
    }
    
    @AfterAll
    public static void tearDownClass() {
       // System.out.println("tearDownClass after all");
    }
    
    @BeforeEach
    public void setUp() {
       // System.out.println("setup before each");
    }
    
    @AfterEach
    public void tearDown() {
       // System.out.println("tear down after each");
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
        File file = new File(archivoPrueba);
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
        File archivoOriginal = new File(archivoPrueba);
        String numeroControl = "11111111";
        String nuevoNombre = "archivoPruebaCopiado";
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
        String nombreSinExtension = "Proceso residenciadrawio";
        String carpeta = "C:\\Users\\Jobae\\Desktop\\";
        CarpetaOculta.abrirPDF(nombreSinExtension, carpeta);
    }

    /**
     * Test of eliminarArchivo method, of class CarpetaOculta.
     */
    @Test
    public void testEliminarArchivo() {
        System.out.println("eliminarArchivo");
        Path archivo= Paths.get("C:\\Users\\Jobae\\Desktop\\Proceso residenciadrawio - copia (3).pdf");
        boolean expResult = true;
        boolean result = CarpetaOculta.eliminarArchivo(archivo);
        assertEquals(expResult, result);
    }

    /**
     * Test of renombrarCarpeta method, of class CarpetaOculta.
     
    @Test
    public void testRenombrarCarpeta() {
        System.out.println("renombrarCarpeta");
        String nControlA = "11111111";
        String nControlB = "22161052";
        boolean expResult = true;
        boolean result = CarpetaOculta.renombrarCarpeta(nControlA, nControlB);
        assertEquals(expResult, result);
    }
    */
}
