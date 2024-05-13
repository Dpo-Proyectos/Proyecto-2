package Transacciones;

import java.util.UUID;

import Compras_Subastas.Cliente;
import Inventario.Galeria;

public class TransaccionGaleria {
	
	private final boolean validez;
	private final int cantidad;
	private final Galeria origen;
	private final Cliente destino;
	
	public TransaccionGaleria(int cantidad, Galeria galeria, Cliente cliente, Banco banco) {
        
		//La galeria solamente realiza transferencias electronicas
		
        this.origen = galeria;
        this.destino = cliente;
        this.cantidad = cantidad;
        
        UUID codigoCliente = cliente.getCodigoCliente();
        boolean transaccionAprobada = banco.setBalance(cantidad, codigoCliente, "TransferenciaElectronica", true);
        this.validez = transaccionAprobada;
        
        
	}

	public boolean getValidez() {
		return validez;
	}
	
	public Cliente getDestino() {
		return destino;
	}
	public Galeria getOrigen() {
        return origen;
    }
	
	public int getCantidad() {
		return cantidad;
    }
	}

