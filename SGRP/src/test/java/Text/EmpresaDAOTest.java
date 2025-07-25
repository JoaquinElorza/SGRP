/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Text;

import Modelo.DAO.EmpresaDAO;
import Modelo.Entidades.EmpresaEntidad;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmpresaDAOTest {

    private EmpresaDAO dao;
    private EmpresaEntidad empresaPrueba;

    @BeforeEach
    public void setUp() {
        dao = new EmpresaDAO();

        empresaPrueba = new EmpresaEntidad();
        empresaPrueba.setNombre("JUnitPrueba S.A.");
        empresaPrueba.setContacto("1234567890");
        empresaPrueba.setCorreo("test@gmail.com");
        empresaPrueba.setRfc("ABC850101T99");
        empresaPrueba.setDireccion("Calle Falsa 123");
    }

    @Test
    public void testInsertarEmpresa() {
        boolean resultado = dao.insertarEmpresa(empresaPrueba);
        assertTrue(resultado, "La empresa debería insertarse correctamente.");
    }

    @Test
    public void testListarEmpresas() {
        List<EmpresaEntidad> lista = dao.listarEmpresas();
        assertNotNull(lista, "La lista de empresas no debe ser null.");
        assertTrue(lista.size() >= 0, "La lista debe tener al menos cero elementos.");
    }

    @Test
    public void testExisteNombre() {
        dao.insertarEmpresa(empresaPrueba);
        assertTrue(dao.existeNombre("JUnitPrueba S.A."), "El nombre debería existir en la base.");
    }

    @Test
    public void testExisteContacto() {
        dao.insertarEmpresa(empresaPrueba);
        assertTrue(dao.existeContacto("1234567890"), "El contacto debería existir en la base.");
    }

    @Test
    public void testExisteRfc() {
        dao.insertarEmpresa(empresaPrueba);
        assertTrue(dao.existeRfc("ABC850101T99"), "El RFC debería existir.");
    }

    @Test
    public void testActualizarEmpresa() {
        dao.insertarEmpresa(empresaPrueba);
        List<EmpresaEntidad> lista = dao.listarEmpresas();

        EmpresaEntidad existente = lista.get(lista.size() - 1); // Tomamos la última

        existente.setNombre("JUnit Actualizada");
        boolean actualizado = dao.actualizarEmpresa(existente);

        assertTrue(actualizado, "La empresa debería actualizarse.");
    }

    @Test
    public void testEliminarEmpresa() {
        dao.insertarEmpresa(empresaPrueba);
        List<EmpresaEntidad> lista = dao.listarEmpresas();

        EmpresaEntidad existente = lista.get(lista.size() - 1);
        boolean eliminado = dao.eliminar(existente.getIdEmpresa());

        assertTrue(eliminado, "La empresa debería marcarse como inactiva.");
    }
}

