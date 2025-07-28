/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo.DAO;

import Modelo.Entidades.Proyecto;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author emili
 */
public class ProyectoDAOTest {
    
    public ProyectoDAOTest() {
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
     * Test of actualizarProyecto method, of class ProyectoDAO.
     */
    @Test
    public void testActualizarProyecto() {
          System.out.println("actualizarProyecto");

    Proyecto proyecto = ProyectoDAO.obtenerProyectoPorId(8); // Usa un ID válido existente
    assertNotNull(proyecto, "El proyecto debe existir para poder actualizarlo.");

    proyecto.setDescripcion("Nueva descripción actualizada");
    boolean result = new ProyectoDAO().actualizarProyecto(proyecto);
    assertTrue(result, "El proyecto no se actualizó correctamente.");
    }

    /**
     * Test of eliminarProyecto method, of class ProyectoDAO.
     */
    @Test
    public void testEliminarProyecto() {
        System.out.println("eliminarProyecto");
        int idProyecto = 8;
        ProyectoDAO instance = new ProyectoDAO();
        boolean expResult = false;
        boolean result = instance.eliminarProyecto(idProyecto);
        assertEquals(expResult, result);
    
    }

    /**
     * Test of agregarProyecto method, of class ProyectoDAO.
     */
    @Test
    public void testAgregarProyecto() {
        System.out.println("agregarProyecto");
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre("Test Proyecto");
        proyecto.setDescripcion("Test");
        proyecto.setEstatus("Disponible");
        proyecto.setIdEmpresa(1);
        ProyectoDAO instance = new ProyectoDAO();
        //boolean expResult = false;
        boolean result = instance.agregarProyecto(proyecto);
        assertEquals(result,"El proyecto no se agrego correctamente");
        
    }

    /**
     * Test of obtenerTodos method, of class ProyectoDAO.
     */
    @Test
    public void testObtenerTodos() {
       System.out.println("obtenerTodos");
        ProyectoDAO dao = new ProyectoDAO();
        List<Proyecto> lista = dao.obtenerTodos();
        assertNotNull(lista);
        assertTrue(lista.size() > 0, "La lista de proyectos debería tener al menos uno.");
    }

    /**
     * Test of existeNombreProyecto method, of class ProyectoDAO.
     */
    @Test
    public void testExisteNombreProyecto() {
          System.out.println("existeNombreProyecto");
            ProyectoDAO dao = new ProyectoDAO();
            boolean existe = dao.existeNombreProyecto("Proyecto Prueba"); // Asegúrate que exista
            assertTrue(existe, "Debería existir el proyecto.");
    }

    /**
     * Test of existeNombreProyectoConOtroId method, of class ProyectoDAO.
     */
    @Test
    public void testExisteNombreProyectoConOtroId() {
         System.out.println("existeNombreProyectoConOtroId");

                ProyectoDAO dao = new ProyectoDAO();
                // Si el proyecto "Proyecto Prueba" tiene ID 18 por ejemplo:
                boolean existe = dao.existeNombreProyectoConOtroId("Proyecto Prueba", 999); // otro id
                assertTrue(existe, "Debería detectar duplicado con diferente ID.");
    }

    /**
  

    /**
     * Test of obtenerProyectoPorId method, of class ProyectoDAO.
     */
    @Test
    public void testObtenerProyectoPorId() {
        System.out.println("obtenerProyectoPorId");
        int id = 16;
        Proyecto expResult = null;
        Proyecto result = ProyectoDAO.obtenerProyectoPorId(id);
        assertEquals(expResult, result);

    }
    
}
