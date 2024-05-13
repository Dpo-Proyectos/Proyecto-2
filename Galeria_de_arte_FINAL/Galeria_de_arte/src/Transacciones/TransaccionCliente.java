package Transacciones;

import java.util.Date;
import java.util.UUID;

import Compras_Subastas.Cliente;
import Inventario.Galeria;

public class TransaccionCliente extends Transaccion{
	
	private final boolean validez;
	private final int cantidad;
	private final Galeria destino;
	private final Cliente origen;
	
	
	public TransaccionCliente(MetodoPago metodoPago, int cantidad, Cliente cliente, Banco banco, Galeria galeria) {
		
		this.origen = cliente;
		this.destino = galeria;
		this.cantidad = cantidad;
		
	    if (metodoPago instanceof TarjetaCredito) {
	    	
	        TarjetaCredito tarjetaCredito = (TarjetaCredito) metodoPago;
	        TarjetaCredito tarjetaCliente = cliente.getTarjeta();
	        int numeroIngresado = tarjetaCredito.getNumero();
	        Date fechaIngresada = tarjetaCredito.getFechaCaducidad();
	        int codigoIngresado = tarjetaCredito.getCodigoSeguridad();

	        boolean datosValidos = tarjetaCliente.autenticarTarjeta(numeroIngresado, fechaIngresada, codigoIngresado);

	        if (datosValidos) {
	            UUID codigoCliente = cliente.getCodigoCliente();
	            boolean transaccionAprobada = banco.setBalance(cantidad, codigoCliente, "TarjetaCredito", false);
	            this.validez = transaccionAprobada;
	        } else {
	            this.validez = false;
	        }
	    } else if (metodoPago instanceof Efectivo) {
	    	
	    	Efectivo efectivo = (Efectivo) metodoPago;
	    	Efectivo efectivoCliente = cliente.getEfectivo();
	    	int pin = efectivo.getPin();
	    	
	    	boolean datosValidos = efectivoCliente.autenticarTraspasoEfectivo(pin);
	    	
	    	if (datosValidos) {
	    		
	    		UUID codigoCliente = cliente.getCodigoCliente();
	    		boolean transaccionAprobada = banco.setBalance(cantidad, codigoCliente, "Efectivo", false);
	    		this.validez = transaccionAprobada;
	    	} else {
	    		this.validez = false;
	    	}
	    }
	    else if (metodoPago instanceof TransferenciaElectronica) {
	    	
	    	TransferenciaElectronica transferenciaElectronica = (TransferenciaElectronica) metodoPago;
	    	TransferenciaElectronica transferenciaCliente = cliente.getTransferencia();
	    	int pin = transferenciaElectronica.getPin();
	    	String usuario = transferenciaElectronica.getUsuario();
	    	
	    	boolean datosValidos = transferenciaCliente.autenticarTransferencia(pin, usuario);
	    	
	    	if (datosValidos) {
	    		
	    		UUID codigoCliente = cliente.getCodigoCliente();
	    		boolean transaccionAprobada = banco.setBalance(cantidad, codigoCliente, "TransferenciaElectronica", false);
	    		this.validez = transaccionAprobada;
	    		} else {
	    			this.validez = false;
	    	}
	    	
	    
	    } else {
	        this.validez = false;
	    }
	}
	


	public boolean getValidez() {
		return this.validez;
	}


	public int getCantidad() {
		return this.cantidad;
	}


	public Galeria getDestino() {
		return this.destino;
	}


	public Cliente getOrigen() {
		return this.origen;
	}
}