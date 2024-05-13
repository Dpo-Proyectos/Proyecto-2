package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Compras_Subastas.Venta;
import Inventario.Pieza;

class VentaTest {

    private Venta venta;
    private Pieza pieza;
    private Ofrecimiento ofrecimiento;

    @BeforeEach
    void setUp() {
        pieza = new Pieza(); // Asumimos que tienes un constructor adecuado
        ofrecimiento = new Ofrecimiento(1000); // Asumimos que tienes un constructor que acepta un precio
        venta = new Venta(pieza, 1000, 1234);
    }

    @Test
    void testRecibirOfrecimientoCompraBloqueaPieza() {
        assertFalse(venta.isBloqueo(), "La pieza no debería estar bloqueada inicialmente.");
        venta.recibirOfrecimientoCompra(ofrecimiento);
        assertTrue(venta.isBloqueo(), "La pieza debería estar bloqueada después de recibir un ofrecimiento.");
    }

    @Test
    void testFinalizarVenta() {
        venta.finalizarVenta();
        assertTrue(venta.ventaFinalizada, "La venta debería estar marcada como finalizada.");
    }

    @Test
    void testNoAceptarOfrecimientoSiVentaFinalizada() {
        venta.finalizarVenta();
        Ofrecimiento nuevoOfrecimiento = new Ofrecimiento(2000);
        venta.recibirOfrecimientoCompra(nuevoOfrecimiento);
        assertNull(venta.ofrecimientoActual, "No debería aceptar un nuevo ofrecimiento si la venta ya está finalizada.");
    }

    @Test
    void testOfrecimientoActualSeEstableceCorrectamente() {
        venta.recibirOfrecimientoCompra(ofrecimiento);
        assertNotNull(venta.ofrecimientoActual, "El ofrecimiento actual debería establecerse correctamente.");
        assertEquals(ofrecimiento, venta.ofrecimientoActual, "El ofrecimiento actual debería ser el que se acaba de recibir.");
    }
}
