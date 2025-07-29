/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author yahir
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Modelo.DAO.DocenteCarg;

public class DocenteCargTest {

    @Test
    void constructorDebeAsignarTodosLosCamposCorrectamente() {
        DocenteCarg d = new DocenteCarg("Luis", "Sánchez", "Gómez",
                                        "SAGL891231HDF", "5551234567", "luis@example.com");

        assertEquals("Luis", d.getNombre());
        assertEquals("Sánchez", d.getApellidoPaterno());
        assertEquals("Gómez", d.getApellidoMaterno());
        assertEquals("SAGL891231HDF", d.getRfc());
        assertEquals("5551234567", d.getTelefono());
        assertEquals("luis@example.com", d.getCorreo());
    }

    @Test
    void settersYGettersDebenEstablecerYObtenerCorrectamente() {
        DocenteCarg d = new DocenteCarg();
        d.setIdDocente(7);
        d.setNombre("Ana");
        d.setApellidoPaterno("Martínez");
        d.setApellidoMaterno("Ruiz");
        d.setRfc("MARA800101KZT");
        d.setTelefono("5559876543");
        d.setCorreo("ana@example.com");

        assertEquals(7, d.getIdDocente());
        assertEquals("Ana", d.getNombre());
        assertEquals("Martínez", d.getApellidoPaterno());
        assertEquals("Ruiz", d.getApellidoMaterno());
        assertEquals("MARA800101KZT", d.getRfc());
        assertEquals("5559876543", d.getTelefono());
        assertEquals("ana@example.com", d.getCorreo());
    }
}
