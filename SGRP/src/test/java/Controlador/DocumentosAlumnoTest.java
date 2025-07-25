package Controlador;

import java.awt.Component;
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
public class DocumentosAlumnoTest {
    
    public DocumentosAlumnoTest() {
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
     * Test of subirDocumentoAlumno method, of class DocumentosAlumno.
     */
    @Test
    public void testSubirDocumentoAlumno() {
        System.out.println("subirDocumentoAlumno");
        String nControl = "22222222";
        String nuevoNombre = "testSubirDocumento";
        Component parentComponent = null;
        DocumentosAlumno.subirDocumentoAlumno(nControl, nuevoNombre, parentComponent);
    }

    /**
     * Test of archivoYaSubido method, of class DocumentosAlumno.
     */
    @Test
    public void testArchivoYaSubido() throws Exception {
        System.out.println("archivoYaSubido");
        String nControl = "22222222";
        boolean expResult = false;
        boolean result = DocumentosAlumno.archivoYaSubido(nControl);
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminarArchivo method, of class DocumentosAlumno.
     */
    @Test
    public void testEliminarArchivo() throws Exception {
        System.out.println("eliminarArchivo");
        String nombreSinExtension = "Proceso residenciadrawio - copia";
        Path directorio = Paths.get("C:\\Users\\Jobae\\Desktop\\");
        String nControl = "22222222";
        DocumentosAlumno.eliminarArchivo(nombreSinExtension, directorio, nControl);
    }
    
}
