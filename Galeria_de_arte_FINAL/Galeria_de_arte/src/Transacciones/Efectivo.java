package Transacciones;

public class Efectivo extends MetodoPago {
	
    private int pin;

    public Efectivo(int pin) {
    	this.pin = pin;
    }

    
    public boolean autenticarTraspasoEfectivo(int pin) {
    	if (this.pin == pin){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public int getPin() {
    	return this.pin;
    }
   }