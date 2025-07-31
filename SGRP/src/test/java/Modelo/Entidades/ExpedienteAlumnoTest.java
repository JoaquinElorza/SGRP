package Modelo.Entidades;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author EdRyz
 */
public class ExpedienteAlumnoTest {
    
    public ExpedienteAlumnoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        // Se ejecuta una sola vez antes de todos los tests
    }
    
    @AfterAll
    public static void tearDownClass() {
        // Se ejecuta una sola vez después de todos los tests
    }
    
    @BeforeEach
    public void setUp() {
        // Se ejecuta antes de cada test
    }
    
    @AfterEach
    public void tearDown() {
        // Se ejecuta después de cada test
    }

    /**
     * Test de setNombre y getNombre de ExpedienteAlumno.
     */
    @Test
    public void testSetAndGetNombre() {
        System.out.println("Probando setNombre y getNombre");
        String nombreEsperado = "Documento de Prueba";
        ExpedienteAlumno instance = new ExpedienteAlumno();

        instance.setNombre(nombreEsperado);
        String nombreObtenido = instance.getNombre();

        assertEquals(nombreEsperado, nombreObtenido, "El nombre debe coincidir con el asignado");
    }

    /**
     * Test de setEstatus y getEstatus de ExpedienteAlumno.
     */
    @Test
    public void testSetAndGetEstatus() {
        System.out.println("Probando setEstatus y getEstatus");
        boolean estatusEsperado = true;
        ExpedienteAlumno instance = new ExpedienteAlumno();

        instance.setEstatus(estatusEsperado);
        boolean estatusObtenido = instance.getEstatus();

        assertTrue(estatusObtenido, "El estatus debe ser verdadero");
    }

    /**
     * Test de getEstatus inicial (debe ser false si no se asigna).
     */
    @Test
    public void testEstatusInicialEsFalse() {
        System.out.println("Probando estatus inicial");
        ExpedienteAlumno instance = new ExpedienteAlumno();
        assertFalse(instance.getEstatus(), "El estatus inicial debería ser false");
    }

    /**
     * Test de getNombre inicial (debe ser null si no se asigna).
     */
    @Test
    public void testNombreInicialEsNull() {
        System.out.println("Probando nombre inicial");
        ExpedienteAlumno instance = new ExpedienteAlumno();
        assertNull(instance.getNombre(), "El nombre inicial debería ser null");
    }
}
