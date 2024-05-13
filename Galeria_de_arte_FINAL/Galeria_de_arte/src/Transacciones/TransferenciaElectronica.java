package Transacciones;


public class TransferenciaElectronica extends MetodoPago {
	
    private int pin;
    private String usuario;

    public TransferenciaElectronica(int pin, String usuario) {
    	this.pin = pin;
    	this.usuario = usuario;
    }

    
    public boolean autenticarTransferencia(int pin, String usuario) {
    	if (this.pin == pin &&
    		this.usuario == usuario){
    		return true;
    	}
    	else {
    		return false;
    	}
    }

	public int getPin() {
    	return this.pin;
    }

	public String getUsuario() {
		return this.usuario;
	}
   }