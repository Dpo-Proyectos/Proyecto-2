package Tests;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Transacciones.TarjetaCredito;
import java.util.Date;

class TarjetaCreditoTest {

    @Test
    void testAutenticarTarjetaExitosa() {
        Date fechaCaducidad = new Date();
        TarjetaCredito tarjeta = new TarjetaCredito(123456789, fechaCaducidad, 123);

        assertTrue(tarjeta.autenticarTarjeta(123456789, fechaCaducidad, 123), "La autenticación debería ser exitosa con datos correctos");
    }

    @Test
    void testAutenticarTarjetaFallaPorNumero() {
        Date fechaCaducidad = new Date();
        TarjetaCredito tarjeta = new TarjetaCredito(123456789, fechaCaducidad, 123);

        assertFalse(tarjeta.autenticarTarjeta(987654321, fechaCaducidad, 123), "La autenticación debería fallar con número incorrecto");
    }

    @Test
    void testAutenticarTarjetaFallaPorFecha() {
        Date fechaCaducidad = new Date();
        Date fechaIncorrecta = new Date(fechaCaducidad.getTime() + 100000); // Una fecha futura
        TarjetaCredito tarjeta = new TarjetaCredito(123456789, fechaCaducidad, 123);

        assertFalse(tarjeta.autenticarTarjeta(123456789, fechaIncorrecta, 123), "La autenticación debería fallar con fecha de caducidad incorrecta");
    }

    @Test
    void testAutenticarTarjetaFallaPorCodigo() {
        Date fechaCaducidad = new Date();
        TarjetaCredito tarjeta = new TarjetaCredito(123456789, fechaCaducidad, 123);

        assertFalse(tarjeta.autenticarTarjeta(123456789, fechaCaducidad, 999), "La autenticación debería fallar con código de seguridad incorrecto");
    }
}
