package Modelo.Entidades;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase TipoUsuario.
 * Verifica los métodos getter y setter.
 * 
 * @author EdRyz
 */
public class TipoUsuarioTest {
    
    public TipoUsuarioTest() {
    }
  
    /**
     * Test de setIdTipoUsuario y getIdTipoUsuario.
     */
    @Test
    public void testSetAndGetIdTipoUsuario() {
        TipoUsuario instance = new TipoUsuario();
        int idEsperado = 5;

        instance.setIdTipoUsuario(idEsperado);
        int idObtenido = instance.getIdTipoUsuario();

        assertEquals(idEsperado, idObtenido, "El ID del tipo de usuario debe coincidir con el asignado.");
    }

    /**
     * Test de setNombreTipoUsuario y getNombreTipoUsuario.
     */
    @Test
    public void testSetAndGetNombreTipoUsuario() {
        TipoUsuario instance = new TipoUsuario();
        String nombreEsperado = "Coordinador";

        instance.setNombreTipoUsuario(nombreEsperado);
        String nombreObtenido = instance.getNombreTipoUsuario();

        assertEquals(nombreEsperado, nombreObtenido, "El nombre del tipo de usuario debe coincidir con el asignado.");
    }

    /**
     * Test de valores iniciales por defecto.
     */
    @Test
    public void testValoresIniciales() {
        TipoUsuario instance = new TipoUsuario();

        assertEquals(0, instance.getIdTipoUsuario(), "El ID inicial debe ser 0.");
        assertNull(instance.getNombreTipoUsuario(), "El nombre inicial debe ser null.");
    }

    /**
     * Test del constructor con parámetros.
     */
    @Test
    public void testConstructorConParametros() {
        int idEsperado = 10;
        String nombreEsperado = "Administrador";
        
        TipoUsuario instance = new TipoUsuario(idEsperado, nombreEsperado);

        assertEquals(idEsperado, instance.getIdTipoUsuario(), "El ID debe coincidir con el pasado al constructor.");
        assertEquals(nombreEsperado, instance.getNombreTipoUsuario(), "El nombre debe coincidir con el pasado al constructor.");
    }
}
