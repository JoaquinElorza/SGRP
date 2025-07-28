package Modelo.DAO;

import Modelo.Entidades.ExpedienteAlumno;
import java.util.List;
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
public class DocumentoDaoTest {
    
    public DocumentoDaoTest() {
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
     * Test of comboSolicitud method, of class DocumentoDao.
     */
    @Test
    public void testComboSolicitud() throws Exception {
        System.out.println("comboSolicitud");
        String nControl = "123456789";
        Integer expResult = 0;
        Integer result = DocumentoDao.comboSolicitud(nControl);
        assertEquals(expResult, result);
    }

    /**
     * Test of crearSoli method, of class DocumentoDao.
     */
    @Test
    public void testCrearSoli() throws Exception {
        System.out.println("crearSoli");
        String nControl = "";
        DocumentoDao.crearSoli(nControl);
    }

    /**
     * Test of actualizarEstatusSoli method, of class DocumentoDao.
     */
    @Test
    public void testActualizarEstatusSoli() throws Exception {
        System.out.println("actualizarEstatusSoli");
        String nControl = "";
        String nuevoStatus = "";
        DocumentoDao.actualizarEstatusSoli(nControl, nuevoStatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDocumentos method, of class DocumentoDao.
     */
    @Test
    public void testObtenerDocumentos() throws Exception {
        System.out.println("obtenerDocumentos");
        String nControl = "";
        List<ExpedienteAlumno> expResult = null;
        List<ExpedienteAlumno> result = DocumentoDao.obtenerDocumentos(nControl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoDocumento method, of class DocumentoDao.
     */
    @Test
    public void testSetEstadoDocumento() throws Exception {
        System.out.println("setEstadoDocumento");
        String nControl = "";
        boolean estado = false;
        String nombreDocumento = "";
        DocumentoDao.setEstadoDocumento(nControl, estado, nombreDocumento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarSolicitudSoli method, of class DocumentoDao.
     */
    @Test
    public void testEliminarSolicitudSoli() throws Exception {
        System.out.println("eliminarSolicitudSoli");
        String nControl = "";
        DocumentoDao.eliminarSolicitudSoli(nControl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
