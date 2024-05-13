package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Compras_Subastas.Subasta;
import Compras_Subastas.Oferta;
import Inventario.Pieza;

class SubastaTest {

    private Subasta subasta;
    private Pieza pieza;
    private Oferta ofertaBaja, ofertaAlta, ofertaMasAlta;

    @BeforeEach
    void setUp() {
        pieza = new Pieza(); // Asumimos que tienes un constructor adecuado para Pieza
        subasta = new Subasta(pieza, 1000);
        ofertaBaja = new Oferta(900); // Oferta por debajo del precio mínimo
        ofertaAlta = new Oferta(1100); // Oferta válida que supera el precio mínimo
        ofertaMasAlta = new Oferta(1200); // Otra oferta válida que supera a la oferta actual
    }

    @Test
    void testOfertaPorDebajoDelPrecioMinimoEsRechazada() {
        assertFalse(subasta.recibir_oferta(ofertaBaja), "La oferta por debajo del precio mínimo debe ser rechazada.");
        assertTrue(subasta.ofertasDeclinadas.contains(ofertaBaja), "La oferta baja debe estar en la lista de ofertas declinadas.");
    }

    @Test
    void testOfertaValidaSuperaOfertaActual() {
        subasta.recibir_oferta(ofertaAlta);
        assertEquals(ofertaAlta, subasta.ofertaActual, "La oferta válida debería ser aceptada como la actual.");
    }

    @Test
    void testOfertaInferiorNoSuperaOfertaActual() {
        subasta.recibir_oferta(ofertaAlta);
        assertFalse(subasta.recibir_oferta(ofertaBaja), "Una oferta inferior no debería superar la oferta actual.");
        assertTrue(subasta.ofertasDeclinadas.contains(ofertaBaja), "La oferta inferior debería estar en la lista de ofertas declinadas.");
    }

    @Test
    void testFinalizarSubastaRetornaOfertaActual() {
        subasta.recibir_oferta(ofertaAlta);
        subasta.recibir_oferta(ofertaMasAlta);
        Oferta ofertaFinal = subasta.finalizarSubasta();
        assertTrue(subasta.subastaFinalizada, "La subasta debe estar marcada como finalizada.");
        assertEquals(ofertaMasAlta, ofertaFinal, "Debería retornar la oferta más alta como la oferta final al finalizar la subasta.");
    }
}
