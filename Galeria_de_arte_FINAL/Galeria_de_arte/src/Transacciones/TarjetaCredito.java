package Transacciones;
import java.util.Date;

public class TarjetaCredito extends MetodoPago {
    private int numero;
    private Date fechaCaducidad;
    private int codigoSeguridad;

    public TarjetaCredito(int numero, Date fechaCaducidad, int codigoSeguridad) {
        this.numero = numero;
        this.fechaCaducidad = fechaCaducidad;
        this.codigoSeguridad = codigoSeguridad;
    }


    public boolean autenticarTarjeta(int numero, Date fechaCaducidad, int codigoSeguridad) {
    
        if (this.numero == numero && 
            this.fechaCaducidad == fechaCaducidad &&  
            this.codigoSeguridad == codigoSeguridad) {
            return true;
        } else {
            return false;
        }
    }
    
    public int getNumero() {
    	return this.numero;
    }
    
    public Date getFechaCaducidad() {
    	return this.fechaCaducidad;
    }
    
    public int getCodigoSeguridad() {
    	return this.codigoSeguridad;
    }
    
}



