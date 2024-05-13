package Tests;


import Inventario.Fotografia;
import Inventario.Autor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FotografiaTest {

    @Test
    void testFotografia() {
        Autor autor = new Autor("Peter Parker", false);
        Fotografia fotografia = new Fotografia("Torre del reloj", autor, 2015, "Queens", 10, 180, "Nikon D3500", "Digital");

        assertEquals("Atardecer", fotografia.getTitulo());
        assertEquals("Nikon D3500", fotografia.getTipoCamara());
        assertEquals("Digital", fotografia.getFormato());

        // Test setters
        fotografia.setTipoCamara("Canon EOS Rebel");
        assertEquals("Canon EOS Rebel", fotografia.getTipoCamara());
        fotografia.setFormato("Film");
        assertEquals("Film", fotografia.getFormato());
    }
}
