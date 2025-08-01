package Modelo.Entidades;

import java.sql.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Proyecto. Verifica los getters y setters de
 * todos los atributos y el constructor con parámetros.
 *
 * @author EdRyz
 */
public class ProyectoTest {

    public ProyectoTest() {
    }
    
    /**
     * Test de setIdProyecto y getIdProyecto.
     */
    @Test
    public void testSetAndGetIdProyecto() {
        Proyecto instance = new Proyecto();
        int idEsperado = 101;

        instance.setIdProyecto(idEsperado);
        int idObtenido = instance.getIdProyecto();

        assertEquals(idEsperado, idObtenido, "El ID del proyecto debe coincidir con el asignado.");
    }

    /**
     * Test de setIdEmpresa y getIdEmpresa.
     */
    @Test
    public void testSetAndGetIdEmpresa() {
        Proyecto instance = new Proyecto();
        int idEmpresaEsperado = 202;

        instance.setIdEmpresa(idEmpresaEsperado);
        int idEmpresaObtenido = instance.getIdEmpresa();

        assertEquals(idEmpresaEsperado, idEmpresaObtenido, "El ID de la empresa debe coincidir con el asignado.");
    }

    /**
     * Test de setNombre y getNombre.
     */
    @Test
    public void testSetAndGetNombre() {
        Proyecto instance = new Proyecto();
        String nombreEsperado = "Sistema de Gestión";

        instance.setNombre(nombreEsperado);
        String nombreObtenido = instance.getNombre();

        assertEquals(nombreEsperado, nombreObtenido, "El nombre debe coincidir con el asignado.");
    }

    /**
     * Test de setDescripcion y getDescripcion.
     */
    @Test
    public void testSetAndGetDescripcion() {
        Proyecto instance = new Proyecto();
        String descripcionEsperada = "Proyecto de residencia profesional para gestión de datos.";

        instance.setDescripcion(descripcionEsperada);
        String descripcionObtenida = instance.getDescripcion();

        assertEquals(descripcionEsperada, descripcionObtenida, "La descripción debe coincidir con la asignada.");
    }

    /**
     * Test de setEstatus y getEstatus.
     */
    @Test
    public void testSetAndGetEstatus() {
        Proyecto instance = new Proyecto();
        String estatusEsperado = "Activo";

        instance.setEstatus(estatusEsperado);
        String estatusObtenido = instance.getEstatus();

        assertEquals(estatusEsperado, estatusObtenido, "El estatus debe coincidir con el asignado.");
    }

    /**
     * Test de setFechaRegistro y getFechaRegistro.
     */
    @Test
    public void testSetAndGetFechaRegistro() {
        Proyecto instance = new Proyecto();
        Date fechaEsperada = Date.valueOf("2025-07-31");

        instance.setFechaRegistro(fechaEsperada);
        Date fechaObtenida = instance.getFechaRegistro();

        assertEquals(fechaEsperada, fechaObtenida, "La fecha de registro debe coincidir con la asignada.");
    }

    /**
     * Test de setEmpresa y getEmpresa.
     */
    @Test
    public void testSetAndGetEmpresa() {
        Proyecto instance = new Proyecto();
        EmpresaEntidad empresaEsperada = new EmpresaEntidad();
        empresaEsperada.setNombre("OpenAI Corp"); // ✅ Ahora usamos setNombre()

        instance.setEmpresa(empresaEsperada);
        EmpresaEntidad empresaObtenida = instance.getEmpresa();

        assertNotNull(empresaObtenida, "La empresa no debe ser null.");
        assertEquals("OpenAI Corp", empresaObtenida.getNombre(), "El nombre de la empresa debe coincidir."); // ✅ Usamos getNombre()
    }

    /**
     * Test de valores iniciales por defecto en Proyecto.
     */
    @Test
    public void testValoresIniciales() {
        Proyecto instance = new Proyecto();

        assertEquals(0, instance.getIdProyecto(), "El ID inicial debe ser 0.");
        assertEquals(0, instance.getIdEmpresa(), "El ID de empresa inicial debe ser 0.");
        assertNull(instance.getNombre(), "El nombre inicial debe ser null.");
        assertNull(instance.getDescripcion(), "La descripción inicial debe ser null.");
        assertNull(instance.getEstatus(), "El estatus inicial debe ser null.");
        assertNull(instance.getFechaRegistro(), "La fecha de registro inicial debe ser null.");
        assertNull(instance.getEmpresa(), "La empresa inicial debe ser null.");
    }

    /**
     * Test del constructor con parámetros (sin empresa ni fecha).
     */
    @Test
    public void testConstructorConParametros() {
        int idEmpresa = 300;
        String nombre = "Proyecto Web";
        String descripcion = "Desarrollo de un sistema web";
        String estatus = "Pendiente";

        Proyecto instance = new Proyecto(idEmpresa, nombre, descripcion, estatus);

        assertEquals(idEmpresa, instance.getIdEmpresa(), "El ID de la empresa debe coincidir.");
        assertEquals(nombre, instance.getNombre(), "El nombre debe coincidir.");
        assertEquals(descripcion, instance.getDescripcion(), "La descripción debe coincidir.");
        assertEquals(estatus, instance.getEstatus(), "El estatus debe coincidir.");
        assertNull(instance.getEmpresa(), "La empresa debe iniciar como null si no se pasa en el constructor.");
        assertNull(instance.getFechaRegistro(), "La fecha de registro debe iniciar como null.");
    }
}
