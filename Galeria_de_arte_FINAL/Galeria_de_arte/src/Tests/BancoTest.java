package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import Transacciones.Banco;
class BancoTest {
    private Banco banco;

    @BeforeEach
    void setUp() {
        banco = new Banco();
        banco.informacion = new HashMap<>();
        HashMap<String, Integer> cuentas = new HashMap<>();
        cuentas.put("ahorro", 1000);
        banco.informacion.put("cliente1", cuentas);
    }

    @Test
    void testSetBalanceClienteInexistente() {
        assertFalse(banco.setBalance(500, "cliente2", "ahorro", true));
    }

    @Test
    void testIngresoPositivo() {
        assertTrue(banco.setBalance(500, "cliente1", "ahorro", true));
        assertEquals(1500, banco.informacion.get("cliente1").get("ahorro").intValue());
    }

    @Test
    void testRetiroExcedeSaldo() {
        assertFalse(banco.setBalance(1100, "cliente1", "ahorro", false));
    }

    @Test
    void testRetiroValido() {
        assertTrue(banco.setBalance(500, "cliente1", "ahorro", false));
        assertEquals(500, banco.informacion.get("cliente1").get("ahorro").intValue());
    }
}
