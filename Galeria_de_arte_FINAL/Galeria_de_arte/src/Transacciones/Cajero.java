package Transacciones;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Cajero implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Transaccion> transaccionesRegistradas;

    public Cajero() {
        this.transaccionesRegistradas = new ArrayList<>();
    }

    public boolean registrarTransaccion(Transaccion transaccion) {
        if (transaccion.realizarTransaccion()) {
            transaccionesRegistradas.add(transaccion);
            System.out.println("Transacción registrada exitosamente.");
            return true;
        } else {
            System.out.println("Error al registrar la transacción.");
            return false;
        }
    }

    public void mostrarTransacciones() {
        System.out.println("Todas las transacciones registradas:");
        for (Transaccion transaccion : transaccionesRegistradas) {
            System.out.println(transaccion);
        }
    }
}