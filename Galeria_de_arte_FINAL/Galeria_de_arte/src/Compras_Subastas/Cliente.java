package Compras_Subastas;

import Inventario.Pieza;
import Transacciones.Efectivo;
import Transacciones.TarjetaCredito;
import Transacciones.TransferenciaElectronica;

import java.util.List;
import java.util.UUID;

import Exceptions.ClienteNoTienePieza;
import Exceptions.PiezaYaEntregada;

import java.util.ArrayList;
import java.util.HashMap;

public class Cliente {
	
    private UUID codigoCliente;
    private TarjetaCredito tarjetaCredito;
    private Efectivo efectivo;
    private TransferenciaElectronica transferenciaElectronica;
    private HashMap<UUID, Pieza> piezasPropias;

    // Constructor
    public Cliente(String usuario, String contraseña, TarjetaCredito tarjetaCredito, Efectivo efectivo, TransferenciaElectronica transferenciaElectronica) {
        this.codigoCliente = UUID.randomUUID();
        this.piezasPropias = new HashMap<UUID, Pieza>();
        this.tarjetaCredito = tarjetaCredito;
        this.efectivo = efectivo;
        this.transferenciaElectronica = transferenciaElectronica;
    }
    
	public void recibirPieza(Pieza pieza) throws PiezaYaEntregada {
		
		// Comprueba si el cliente ya tiene la pieza. Si la tiene da una excepcion
		
		if (this.piezasPropias.containsKey(pieza.getCodigo())) {
			throw new PiezaYaEntregada();
		} else {
			this.piezasPropias.put(pieza.getCodigo(), pieza);	
	}
	
	}
	public Pieza entregarPieza(UUID codigoPieza) throws ClienteNoTienePieza{
		
		// Comprueba si el cliente tiene la pieza. Si no la tiene da una excepcion
		if (this.piezasPropias.containsKey(codigoPieza)) {
			Pieza piezaEntregar = this.piezasPropias.get(codigoPieza);
			this.piezasPropias.remove(codigoPieza);
			return piezaEntregar;
			
		} else {
			throw new ClienteNoTienePieza();
		}
	}


    
    public void entregarPiezaExhibicion(Pieza pieza) {
     
    }

    public void entregarPiezaVenta(Pieza pieza, int precio) {
      
    }

    public void entregarPiezaSubasta(Pieza pieza, int precioMinimo) {
        // Lógica para entregar una pieza para subasta
    }

    // Métodos para realizar ofertas
    public void realizarOfertaVenta(MetodoPago metodoPago) {
     
    }

    public void realizarOfertaSubasta() {
       
    }



    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public UUID getCodigoCliente() {
        return this.codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public List<Pieza> getPiezasPropias() {
        return new ArrayList<>(piezasPropias);
    }

    public void agregarPiezaPropia(Pieza pieza) {
        this.piezasPropias.put(pieza.getCodigo(), pieza);
    }

	public TarjetaCredito getTarjeta() {
		return this.tarjetaCredito;
	}

	public Efectivo getEfectivo() {
		return this.efectivo;
	}

	public TransferenciaElectronica getTransferencia() {
		return this.transferenciaElectronica;
	}
}
