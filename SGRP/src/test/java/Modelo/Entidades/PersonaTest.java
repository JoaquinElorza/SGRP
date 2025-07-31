/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo.Entidades;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 *
 * @author EdRyz
 */

class PersonaTest {

    @Test
    @DisplayName("Constructor con parámetros debe asignar campos correctamente")
    void testConstructorConParametros() {
        // Dado
        int id      = 42;
        String nom  = "María";
        String ap   = "López";
        String am   = "García";
        String mail = "maria.lopez@example.com";

        // Cuando
        Persona p = new Persona(id, nom, ap, am, mail);

        // Entonces
        assertEquals(id,   p.getIdPersona(),       "El ID no coincide");
        assertEquals(nom,  p.getNombre(),          "El nombre no coincide");
        assertEquals(ap,   p.getApellidoPaterno(), "El apellido paterno no coincide");
        assertEquals(am,   p.getApellidoMaterno(), "El apellido materno no coincide");
        assertEquals(mail, p.getCorreo(),          "El correo no coincide");
    }

    @Test
    @DisplayName("Constructor vacío y setters/getters funcionan correctamente")
    void testConstructorVacioYSettersGetters() {
        // Dado
        Persona p = new Persona();

        // Cuando
        p.setIdPersona(7);
        p.setNombre("Luis");
        p.setApellidoPaterno("Martínez");
        p.setApellidoMaterno("Soto");
        p.setCorreo("luis.martinez@correo.com");

        // Entonces
        assertAll("Validar getters tras setters",
            () -> assertEquals(7,   p.getIdPersona()),
            () -> assertEquals("Luis",     p.getNombre()),
            () -> assertEquals("Martínez", p.getApellidoPaterno()),
            () -> assertEquals("Soto",     p.getApellidoMaterno()),
            () -> assertEquals("luis.martinez@correo.com", p.getCorreo())
        );
    }
}
