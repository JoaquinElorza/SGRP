
import Modelo.DAO.DocenteDAO;
import Modelo.DAO.DocenteCarg;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DocenteDAOTest {

    static DocenteDAO dao;
    static String rfcTest = "PRUE900101XYZ";

    @BeforeAll
    static void setup() {
        dao = new DocenteDAO();
    }

    @Test
    @Order(1)
    void agregarDocente_debeInsertarEnPersonaYDocente() {
        DocenteCarg d = new DocenteCarg("Prueba", "Unit", "Test", rfcTest, "5550001111", "prueba@correo.com");
        assertTrue(dao.agregarDocente(d));
    }

    @Test
    @Order(2)
    void consultarPorRFC_debeRecuperarDatosCorrectos() {
        DocenteCarg d = dao.consultarPorRFC(rfcTest);
        assertNotNull(d);
        assertEquals("Prueba", d.getNombre());
        assertEquals("Unit", d.getApellidoPaterno());
        assertEquals("Test", d.getApellidoMaterno());
    }

    @Test
    @Order(3)
    void existeRFC_debeConfirmarExistencia() {
        assertTrue(dao.existeRFC(rfcTest));
    }

    @Test
    @Order(4)
    void consultarPorRFCParcial_debeEncontrarCoincidencias() {
        List<DocenteCarg> resultados = dao.consultarPorRFCParcial("PRUE");
        assertFalse(resultados.isEmpty());
        assertEquals(rfcTest, resultados.get(0).getRfc());
    }

    @Test
    @Order(5)
    void actualizarDocente_debeModificarDatos() {
        DocenteCarg actualizado = new DocenteCarg("Actualizado", "DAO", "Test", rfcTest, "5559998888", "update@correo.com");
        assertTrue(dao.actualizarDocente(actualizado, rfcTest));

        DocenteCarg d = dao.consultarPorRFC(rfcTest);
        assertEquals("Actualizado", d.getNombre());
        assertEquals("update@correo.com", d.getCorreo());
    }

    @Test
    @Order(6)
    void eliminarDocente_debeCambiarStatusEnPersona() {
        assertTrue(dao.eliminarDocente(rfcTest));
        assertNull(dao.consultarPorRFC(rfcTest));
        assertFalse(dao.existeRFC(rfcTest));
    }
}
