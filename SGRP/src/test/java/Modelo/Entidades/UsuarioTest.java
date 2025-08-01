package Modelo.Entidades;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Usuario.
 * Verifica los métodos getter y setter de la clase.
 * @author EdRyz
 */
public class UsuarioTest {
    
    public UsuarioTest() {
    }

    /**
     * Test de setIdUsuario y getIdUsuario.
     */
    @Test
    public void testSetAndGetIdUsuario() {
        Usuario instance = new Usuario();
        int idEsperado = 123;

        instance.setIdUsuario(idEsperado);
        int idObtenido = instance.getIdUsuario();

        assertEquals(idEsperado, idObtenido, "El ID de usuario debe coincidir con el asignado.");
    }

    /**
     * Test de setPassword y getPassword.
     */
    @Test
    public void testSetAndGetPassword() {
        Usuario instance = new Usuario();
        String passwordEsperada = "MiClaveSegura";

        instance.setPassword(passwordEsperada);
        String passwordObtenida = instance.getPassword();

        assertEquals(passwordEsperada, passwordObtenida, "La contraseña debe coincidir con la asignada.");
    }

    /**
     * Test de setTipoUsuario y getTipoUsuario.
     */
    @Test
    public void testSetAndGetTipoUsuario() {
        Usuario instance = new Usuario();
        TipoUsuario tipoEsperado = new TipoUsuario(1, "Administrador");

        instance.setTipoUsuario(tipoEsperado);
        TipoUsuario tipoObtenido = instance.getTipoUsuario();

        assertNotNull(tipoObtenido, "El tipo de usuario no debe ser null.");
        assertEquals(tipoEsperado.getIdTipoUsuario(), tipoObtenido.getIdTipoUsuario(),
                "El ID de tipo de usuario debe coincidir.");
        assertEquals(tipoEsperado.getNombreTipoUsuario(), tipoObtenido.getNombreTipoUsuario(),
                "El nombre de tipo de usuario debe coincidir.");
    }

    /**
     * Test de valores iniciales por defecto de Usuario.
     */
    @Test
    public void testValoresIniciales() {
        Usuario instance = new Usuario();

        assertEquals(0, instance.getIdUsuario(), "El ID inicial debe ser 0.");
        assertNull(instance.getPassword(), "La contraseña inicial debe ser null.");
        assertNull(instance.getTipoUsuario(), "El tipo de usuario inicial debe ser null.");
    }
}
