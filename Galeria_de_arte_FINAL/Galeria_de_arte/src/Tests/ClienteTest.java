package Tests;


import Compras_Subastas.Cliente;
import Inventario.Pieza;
import Transacciones.TarjetaCredito;
import Transacciones.Efectivo;
import Transacciones.TransferenciaElectronica;
import Exceptions.ClienteNoTienePieza;
import Exceptions.PiezaYaEntregada;

import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;
    private Pieza pieza;
    private UUID codigoPieza;

    @BeforeEach
    void setUp() {

        TarjetaCredito tarjeta = new TarjetaCredito(1234, "1234567890123456", "123", "12/25");
        Efectivo efectivo = new Efectivo(1000);  
        TransferenciaElectronica transferencia = new TransferenciaElectronica(9876, "user123");

        cliente = new Cliente("usuario", "contraseña123", tarjeta, efectivo, transferencia);
        pieza = new Pieza(); 
        codigoPieza = UUID.randomUUID();
        pieza.setCodigo(codigoPieza);
    }

    @Test
    void testRecibirPiezaExitosamente() throws PiezaYaEntregada {
        cliente.recibirPieza(pieza);
        assertTrue(cliente.getPiezasPropias().contains(pieza), "La pieza debería haber sido agregada a las piezas del cliente.");
    }

    @Test
    void testRecibirPiezaYaExistente() {
        assertThrows(PiezaYaEntregada.class, () -> {
            cliente.recibirPieza(pieza);
            cliente.recibirPieza(pieza); // Intentar agregar la misma pieza nuevamente
        }, "No se puede agregar la misma pieza dos veces.");
    }

    @Test
    void testEntregarPiezaExitosamente() throws ClienteNoTienePieza, PiezaYaEntregada {
        cliente.recibirPieza(pieza);
        Pieza entregada = cliente.entregarPieza(codigoPieza);
        assertEquals(pieza, entregada, "La pieza entregada debería ser la misma que la recibida.");
        assertFalse(cliente.getPiezasPropias().contains(pieza), "La pieza debería haber sido removida de las piezas del cliente.");
    }

    @Test
    void testEntregarPiezaNoExistente() {
        assertThrows(ClienteNoTienePieza.class, () -> {
            cliente.entregarPieza(codigoPieza);
        }, "No se puede entregar una pieza que no se posee.");
    }
}
