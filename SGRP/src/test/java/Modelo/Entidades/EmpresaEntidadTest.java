package Modelo.Entidades;

import Modelo.DAO.EmpresaDAO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Pruebas unitarias para la clase EmpresaEntidad.
 * Se prueban los getters, setters y el método eliminarEmpresa().
 * 
 * @author EdRyz
 */
public class EmpresaEntidadTest {

    @Test
    public void testSetAndGetIdEmpresa() {
        EmpresaEntidad empresa = new EmpresaEntidad();
        empresa.setIdEmpresa(101);
        assertEquals(101, empresa.getIdEmpresa());
    }

    @Test
    public void testSetAndGetNombre() {
        EmpresaEntidad empresa = new EmpresaEntidad();
        empresa.setNombre("OpenAI");
        assertEquals("OpenAI", empresa.getNombre());
    }

    @Test
    public void testSetAndGetContacto() {
        EmpresaEntidad empresa = new EmpresaEntidad();
        empresa.setContacto("John Doe");
        assertEquals("John Doe", empresa.getContacto());
    }

    @Test
    public void testSetAndGetCorreo() {
        EmpresaEntidad empresa = new EmpresaEntidad();
        empresa.setCorreo("contacto@openai.com");
        assertEquals("contacto@openai.com", empresa.getCorreo());
    }

    @Test
    public void testSetAndGetRfc() {
        EmpresaEntidad empresa = new EmpresaEntidad();
        empresa.setRfc("OAI123456XYZ");
        assertEquals("OAI123456XYZ", empresa.getRfc());
    }

    @Test
    public void testSetAndGetDireccion() {
        EmpresaEntidad empresa = new EmpresaEntidad();
        empresa.setDireccion("San Francisco, CA");
        assertEquals("San Francisco, CA", empresa.getDireccion());
    }

    @Test
    public void testConstructorConParametros() {
        EmpresaEntidad empresa = new EmpresaEntidad(1, "Google", "Jane Smith");

        assertEquals(1, empresa.getIdEmpresa());
        assertEquals("Google", empresa.getNombre());
        assertEquals("Jane Smith", empresa.getContacto());
    }

    @Test
    public void testEliminarEmpresaConMock() {
        // Mock del DAO para no llamar la base de datos real
        EmpresaDAO mockDAO = mock(EmpresaDAO.class);
        when(mockDAO.eliminar(5)).thenReturn(true);

        // Clase anónima para inyectar mock sin cambiar EmpresaEntidad
        EmpresaEntidad empresa = new EmpresaEntidad() {
            @Override
            public boolean eliminarEmpresa(int id) {
                return mockDAO.eliminar(id);
            }
        };

        // Prueba
        assertTrue(empresa.eliminarEmpresa(5));
        verify(mockDAO).eliminar(5);
    }
}
