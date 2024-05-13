package Compras_Subastas;

import Transacciones.TransaccionCliente;

public class Ofrecimiento {
	
	public final TransaccionCliente transaccion;
	public final Cliente cliente;
	
	public Ofrecimiento(TransaccionCliente transaccion, Cliente cliente){
		
		this.cliente = cliente;
		this.transaccion = transaccion;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public TransaccionCliente getTransaccion() {
		return this.transaccion;
	}
	
}
