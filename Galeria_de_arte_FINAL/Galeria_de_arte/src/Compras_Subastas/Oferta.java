package Compras_Subastas;


public class Oferta {
	
    private final Cliente cliente;
    private final int cantidad;
    private boolean aceptada; 
    
    public Oferta(Cliente cliente, int cantidad) {
    	
    	this.cliente = cliente;
        this.cantidad = cantidad;
        //Inicialmente la oferta no ha sido aceptada
        this.aceptada = false; 
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean isAceptada() {
        return aceptada;
    }

    public void setAceptada(boolean aceptada) {
        this.aceptada = aceptada;
    }
    
}
