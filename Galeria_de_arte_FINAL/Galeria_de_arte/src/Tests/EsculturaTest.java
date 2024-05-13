package Tests;


import Inventario.Escultura;
import Inventario.Autor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EsculturaTest {

    @Test
    void testEscultura() {
        Autor autor = new Autor("Eduardo Sánchez", false);
        Escultura escultura = new Escultura("La Espera", autor, 1990, "Valencia", 30, 365, 150.0, "Bronce");

        assertEquals("La Espera", escultura.getTitulo());
        assertEquals(150.0, escultura.getPeso());
        assertEquals("Bronce", escultura.getMaterial());

        // Test setters
        escultura.setPeso(155.0);
        assertEquals(155.0, escultura.getPeso());
        escultura.setMaterial("Madera");
        assertEquals("Madera", escultura.getMaterial());
    }
}
