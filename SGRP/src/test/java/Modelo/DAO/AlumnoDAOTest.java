/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo.DAO;

import Modelo.Entidades.Alumno;
import java.util.List;
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
public class AlumnoDAOTest {

    public AlumnoDAOTest() {
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
     * Test of agregarAlumno method, of class AlumnoDAO.
     */
    @Test
    public void testAgregarAlumno() {
        System.out.println("agregarAlumno");
        Alumno alumno = new Alumno();
        AlumnoDAO instance = new AlumnoDAO();
        boolean expResult = true;
        boolean result = instance.agregarAlumno(alumno);
        assertEquals(expResult, result);
    }

    /**
     * Test of consultarAlumno method, of class AlumnoDAO.
     */
    @Test
    public void testConsultarAlumno() throws Exception {
        System.out.println("consultarAlumno");
        String nControl = "21160001";
        AlumnoDAO instance = new AlumnoDAO();

        AlumnoCarg result = instance.consultarAlumno(nControl);

        assertNotNull(result, "El alumno no debe ser null");
        System.out.println("Alumno consultado: " + result);
    }

    /**
     * Test of existeNumeroControl method, of class AlumnoDAO.
     */
    @Test
    public void testExisteNumeroControl() {
        System.out.println("existeNumeroControl");
        String numeroControl = "21160001";
        AlumnoDAO instance = new AlumnoDAO();
        boolean expResult = true;
        boolean result = instance.existeNumeroControl(numeroControl);
        assertEquals(expResult, result);
    }

    /**
     * Test of actualizarAlumno method, of class AlumnoDAO.
     */
    @Test
    public void testActualizarAlumno_AlumnoCarg_String() {
        System.out.println("actualizarAlumno");
        AlumnoCarg alumno = new AlumnoCarg();
        String controlOriginal = "21160001";
        AlumnoDAO instance = new AlumnoDAO();
        boolean expResult = true;
        boolean result = instance.actualizarAlumno(alumno, controlOriginal);
        assertEquals(expResult, result);
    }

    /**
     * Test of actualizarAlumno method, of class AlumnoDAO.
     */
    @Test
    public void testActualizarAlumno_AlumnoCarg() {
        System.out.println("actualizarAlumno");
        AlumnoCarg alumno = new AlumnoCarg();
        AlumnoDAO instance = new AlumnoDAO();
        boolean expResult = true;
        boolean result = instance.actualizarAlumno(alumno);
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminarAlumno method, of class AlumnoDAO.
     */
    @Test
    public void testEliminarAlumno() {
        System.out.println("eliminarAlumno");
        int idPersona = 2;
        AlumnoDAO instance = new AlumnoDAO();
        boolean expResult = true;
        boolean result = instance.eliminarAlumno(idPersona);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerIdPersonaPorNumeroControl method, of class AlumnoDAO.
     */
    @Test
    public void testObtenerIdPersonaPorNumeroControl() {
        System.out.println("obtenerIdPersonaPorNumeroControl");
        String nControl = "21160001";
        AlumnoDAO instance = new AlumnoDAO();
        int expResult = 101;
        int result = instance.obtenerIdPersonaPorNumeroControl(nControl);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerTodosLosAlumnos method, of class AlumnoDAO.
     */
    @Test
    public void testObtenerTodosLosAlumnos() {
        System.out.println("obtenerTodosLosAlumnos");
        AlumnoDAO instance = new AlumnoDAO();
        List<AlumnoCarg> result = instance.obtenerTodosLosAlumnos();

        // Verificamos que la lista no sea null
        assertNotNull(result, "La lista no debe ser null");

        // Verificamos que hay al menos un alumno (o que está vacía si lo que esperas es lo contrario)
        assertTrue(result.size() > 0, "Debe devolver al menos un alumno");
    }

    /**
     * Test funcional: Flujo completo de registrar y eliminar alumno.
     */
    @Test
    void testFlujoCompleto_RegistrarYEliminarAlumno() throws Exception {
        AlumnoDAO dao = new AlumnoDAO();

        // 1️⃣ Registrar un alumno de prueba
        Alumno alumno = new Alumno();
        alumno.setNumeroControl("99999999");
        alumno.setTelefono("2281112233");
        boolean agregado = dao.agregarAlumno(alumno);
        assertTrue(agregado, "El alumno debe registrarse correctamente");

        // 2️⃣ Verificar que el alumno existe después de registrarlo
        AlumnoCarg alumnoConsultado = dao.consultarAlumno("99999999");
        assertNotNull(alumnoConsultado, "El alumno debe existir después de registrarlo");

        // 3️⃣ Obtener el idPersona del alumno para poder eliminarlo
        int idPersona = dao.obtenerIdPersonaPorNumeroControl("99999999");
        assertTrue(idPersona > 0, "El idPersona debe ser válido después de registrar el alumno");

        // 4️⃣ Eliminar el alumno
        boolean eliminado = dao.eliminarAlumno(idPersona);
        assertTrue(eliminado, "El alumno debe eliminarse correctamente");

        // 5️⃣ Intentar consultar el alumno eliminado
        AlumnoCarg alumnoDespuesDeEliminar = dao.consultarAlumno("99999999");
        assertNull(alumnoDespuesDeEliminar, "El alumno eliminado no debe encontrarse en la base de datos");
    }

    /**
     * Prueba de aceptación: Eliminar alumno. Valida que el método
     * eliminarAlumno cumpla con el criterio de aceptación del cliente.
     */
    @Test
    void testAceptacion_EliminarAlumno() {
        AlumnoDAO dao = new AlumnoDAO();

        // 📌 Criterio de aceptación: el cliente espera que si existe un alumno con idPersona=5, se pueda eliminar
        int idAlumnoParaEliminar = 5;
        boolean resultado = dao.eliminarAlumno(idAlumnoParaEliminar);

        assertTrue(resultado, "✅ El cliente espera que el alumno con id=5 se elimine correctamente.");
    }

    /**
     * Prueba de regresión: Verificar que eliminarAlumno siga funcionando
     * después de cambios.
     */
    @Test
    void testRegresion_EliminarAlumno_SigueFuncionando() {
        AlumnoDAO dao = new AlumnoDAO();

        // 📌 Usamos un alumno que sabemos que existe para probar regresión
        int idAlumnoParaEliminar = 6; // Debe ser un alumno existente de prueba

        boolean eliminado = dao.eliminarAlumno(idAlumnoParaEliminar);

        // ✅ Validamos que eliminarAlumno siga cumpliendo su función
        assertTrue(eliminado, "La eliminación de alumno debe seguir funcionando después de cambios en el sistema.");
    }

}
