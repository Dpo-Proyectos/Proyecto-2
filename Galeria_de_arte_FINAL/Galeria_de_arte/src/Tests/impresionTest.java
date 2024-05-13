package Tests;


import Inventario.impresion;
import Inventario.Autor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class impresionTest {

    @Test
    void testImpresion() {
        Autor autor = new Autor("JJ Jameson", false);
        impresion impresion = new impresion("Daily Bugle", autor, 2018, "New York City", 20, 360, "Litografía", "A3");

        assertEquals("Daily Bugle", impresion.getTitulo());
        assertEquals("Litografía", impresion.getTecnicaImpresion());
        assertEquals("A3", impresion.getTamaño());

        // Test setters
        impresion.setTecnicaImpresion("Serigrafía");
        assertEquals("Serigrafía", impresion.getTecnicaImpresion());
        impresion.setTamaño("A4");
        assertEquals("A4", impresion.getTamaño());
    }
}
