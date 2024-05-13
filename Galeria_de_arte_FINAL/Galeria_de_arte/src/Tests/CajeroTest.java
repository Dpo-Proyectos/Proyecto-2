package Tests;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Transacciones.Cajero;
import Transacciones.Transaccion;

class CajeroTest {

    private Cajero cajero;
    private Transaccion transaccion;

    @BeforeEach
    void setUp() {
        cajero = new Cajero();
        transaccion = new Transaccion() {
            public boolean realizarTransaccion() {
                return true;
        };
    }

    @Test
    void testRegistrarTransaccionExitosa() {
        assertTrue(cajero.registrarTransaccion(transaccion), "La transacción debería registrarse correctamente");
        assertFalse(cajero.transaccionesRegistradas.isEmpty(), "La lista de transacciones no debería estar vacía");
    }

    @Test
    void testRegistrarTransaccionFalla() {
        transaccion = new Transaccion() {
            public boolean realizarTransaccion() {
                return false;
            }
        };
        assertFalse(cajero.registrarTransaccion(transaccion), "La transacción no debería registrarse");
        assertTrue(cajero.transaccionesRegistradas.isEmpty(), "La lista de transacciones debería estar vacía");
    }
}
