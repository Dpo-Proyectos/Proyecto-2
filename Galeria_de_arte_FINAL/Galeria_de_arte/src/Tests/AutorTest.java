package Tests;

import Inventario.Autor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AutorTest {

    @Test
    void testCrearAutorConocidoIndividual() {
        Autor autor = new Autor("Rick Sanchez", false);
        assertEquals("Rick Sanchez", autor.getNombre(), "El nombre del autor debe ser 'Rick Sanchez'");
        assertFalse(autor.esColectivo(), "El autor no debe ser colectivo");
        assertFalse(autor.esAnonimo(), "El autor no debe ser anónimo");
    }

    @Test
    void testCrearAutorConocidoColectivo() {
        Autor autor = new Autor("Grupo Niche", true);
        assertEquals("Grupo Niche", autor.getNombre(), "El nombre del autor debe ser 'Grupo Niche'");
        assertTrue(autor.esColectivo(), "El autor debe ser colectivo");
        assertFalse(autor.esAnonimo(), "El autor no debe ser anónimo");
    }

    @Test
    void testCrearAutorAnonimo() {
        Autor autor = new Autor();
        assertEquals("Anónimo", autor.getNombre(), "El nombre del autor debe ser 'Anónimo'");
        assertFalse(autor.esColectivo(), "El autor no debe ser colectivo");
        assertTrue(autor.esAnonimo(), "El autor debe ser anónimo");
    }

    @Test
    void testCambiarNombreAutor() {
        Autor autor = new Autor("Rick Sanchez", false);
        autor.setNombre("Morty");
        assertEquals("Morty", autor.getNombre(), "El nombre del autor debe ser actualizado a 'Morty'");
        assertFalse(autor.esAnonimo(), "El autor no debe ser anónimo tras cambiar el nombre");
    }

    @Test
    void testEstablecerNombreVacio() {
        Autor autor = new Autor("Rick Sanchez", false);
        autor.setNombre("");
        assertTrue(autor.esAnonimo(), "El autor debe ser anónimo si el nombre está vacío");
    }

    @Test
    void testEstablecerNombreNull() {
        Autor autor = new Autor("Rick Sanchez", false);
        autor.setNombre(null);
        assertTrue(autor.esAnonimo(), "El autor debe ser anónimo si el nombre es null");
    }
}
