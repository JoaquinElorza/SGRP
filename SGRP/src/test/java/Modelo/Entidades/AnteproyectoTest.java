package Modelo.Entidades;

import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnteproyectoTest {

    @Test
    public void testSetAndGetIdAnteproyecto() {
        Anteproyecto anteproyecto = new Anteproyecto();
        anteproyecto.setIdAnteproyecto(10);
        assertEquals(10, anteproyecto.getIdAnteproyecto());
    }

    @Test
    public void testSetAndGetNombre() {
        Anteproyecto anteproyecto = new Anteproyecto();
        anteproyecto.setNombre("Proyecto de IA");
        assertEquals("Proyecto de IA", anteproyecto.getNombre());
    }

    @Test
    public void testSetAndGetDescripcion() {
        Anteproyecto anteproyecto = new Anteproyecto();
        anteproyecto.setDescripcion("Este es un anteproyecto de inteligencia artificial");
        assertEquals("Este es un anteproyecto de inteligencia artificial", anteproyecto.getDescripcion());
    }

    @Test
    public void testSetAndGetLineaInvestigacion() {
        Anteproyecto anteproyecto = new Anteproyecto();
        anteproyecto.setLineaInvestigacion("Machine Learning");
        assertEquals("Machine Learning", anteproyecto.getLineaInvestigacion());
    }

    @Test
    public void testSetAndGetFechaRegistro() {
        Anteproyecto anteproyecto = new Anteproyecto();
        Date fecha = new Date();
        anteproyecto.setFechaRegistro(fecha);
        assertEquals(fecha, anteproyecto.getFechaRegistro());
    }

    @Test
    public void testSetAndGetEstado() {
        Anteproyecto anteproyecto = new Anteproyecto();
        anteproyecto.setEstado("Aprobado");
        assertEquals("Aprobado", anteproyecto.getEstado());
    }

    @Test
    public void testSetAndGetUsuarioRegistro() {
        Anteproyecto anteproyecto = new Anteproyecto();
        anteproyecto.setUsuarioRegistro("admin");
        assertEquals("admin", anteproyecto.getUsuarioRegistro());
    }

    @Test
    public void testSetAndGetFkAlumno() {
        Anteproyecto anteproyecto = new Anteproyecto();
        anteproyecto.setFkAlumno(12345);
        assertEquals(12345, anteproyecto.getFkAlumno());
    }

    @Test
    public void testSetAndGetRfcEmpresa() {
        Anteproyecto anteproyecto = new Anteproyecto();
        anteproyecto.setRfcEmpresa("RFC123456789");
        assertEquals("RFC123456789", anteproyecto.getRfcEmpresa());
    }
}
