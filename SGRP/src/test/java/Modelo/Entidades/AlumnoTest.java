package Modelo.Entidades;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Alumno.
 * Verifica el correcto funcionamiento de getters y setters.
 * 
 * @author EdRyz
 */
public class AlumnoTest {
    
    @Test
    public void testSetAndGetNumeroControl() {
        // Arrange
        Alumno alumno = new Alumno();
        String numeroControlEsperado = "21160001";

        // Act
        alumno.setNumeroControl(numeroControlEsperado);
        String numeroControlObtenido = alumno.getNumeroControl();

        // Assert
        assertEquals(numeroControlEsperado, numeroControlObtenido, 
            "El número de control devuelto no coincide con el esperado");
    }

    @Test
    public void testSetAndGetTelefono() {
        // Arrange
        Alumno alumno = new Alumno();
        String telefonoEsperado = "2281234567";

        // Act
        alumno.setTelefono(telefonoEsperado);
        String telefonoObtenido = alumno.getTelefono();

        // Assert
        assertEquals(telefonoEsperado, telefonoObtenido, 
            "El teléfono devuelto no coincide con el esperado");
    }

    @Test
    public void testConstructorConParametros() {
        // Este test solo aplica si Alumno tiene un constructor con parámetros (ajusta si no existe)
        Alumno alumno = new Alumno("21160002", "2287654321");

        assertEquals("21160002", alumno.getNumeroControl(), 
            "El número de control del constructor no es el esperado");
        assertEquals("2287654321", alumno.getTelefono(), 
            "El teléfono del constructor no es el esperado");
    }
}
