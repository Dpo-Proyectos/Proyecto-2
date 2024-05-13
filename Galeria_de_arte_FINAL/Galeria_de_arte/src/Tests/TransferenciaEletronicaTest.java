package Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Transacciones.TransferenciaElectronica; 

class TransferenciaElectronicaTest {

    private TransferenciaElectronica transferencia;

    @BeforeEach
    void setUp() {
        transferencia = new TransferenciaElectronica(123456, "usuarioEjemplo");
    }

    @Test
    void testAutenticacionExitosa() {
        assertTrue(transferencia.autenticarTransferencia(123456, "usuarioEjemplo"),
                   "La autenticación debería ser exitosa con el PIN y usuario correctos.");
    }

    @Test
    void testAutenticacionFallidaPorPinIncorrecto() {
        assertFalse(transferencia.autenticarTransferencia(654321, "usuarioEjemplo"),
                    "La autenticación debería fallar con un PIN incorrecto.");
    }

    @Test
    void testAutenticacionFallidaPorUsuarioIncorrecto() {
        assertFalse(transferencia.autenticarTransferencia(123456, "otroUsuario"),
                    "La autenticación debería fallar con un nombre de usuario incorrecto.");
    }
}
