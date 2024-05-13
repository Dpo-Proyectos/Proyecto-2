package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import Compras_Subastas.Cliente;
import Inventario.Galeria;
import Transacciones.*;

import java.util.Date;

class TransaccionClienteTest {
    
    Cliente cliente;
    Galeria galeria;
    Banco banco;

    @BeforeEach
    void setUp() {
        cliente = new Cliente(); 
        galeria = new Galeria(); 
        banco = new Banco();
    }

    @Test
    void testTransaccionTarjetaCreditoExitosa() {
        TarjetaCredito tarjeta = new TarjetaCredito(123456789, new Date(), 123);
        when(cliente.getTarjeta()).thenReturn(tarjeta); // Necesitas configurar esto según tu implementación
        when(banco.setBalance(anyInt(), anyString(), eq("TarjetaCredito"), eq(false))).thenReturn(true);
        
        TransaccionCliente transaccion = new TransaccionCliente(tarjeta, 100, cliente, banco, galeria);
        
        assertTrue(transaccion.getValidez(), "La transacción debería ser válida cuando la autenticación y la transacción son aprobadas.");
    }

    @Test
    void testTransaccionTarjetaCreditoFallaPorAutenticacion() {
        TarjetaCredito tarjeta = new TarjetaCredito(123456789, new Date(), 123);
        when(cliente.getTarjeta()).thenReturn(new TarjetaCredito(987654321, new Date(), 321)); // Datos incorrectos para fallar autenticación
        when(banco.setBalance(anyInt(), anyString(), eq("TarjetaCredito"), eq(false))).thenReturn(false);
        
        TransaccionCliente transaccion = new TransaccionCliente(tarjeta, 100, cliente, banco, galeria);
        
        assertFalse(transaccion.getValidez(), "La transacción no debería ser válida si la autenticación falla.");
    }


}