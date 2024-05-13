package Compras_Subastas;

import Inventario.Pieza;


import Exceptions.OfertaMenorAlPrecioMinimoException;
import Exceptions.OfertaMenorOfertaAcualException;

import java.util.ArrayList;

public class Subasta {
	
    private final Pieza piezaSubasta;
    private final int precioMinimo;
    private boolean subastaFinalizada = false;
    private Oferta ofertaActual = null;
    private ArrayList<Oferta> ofertasAceptadas;
    private ArrayList<Oferta> ofertasDeclinadas;
    
    public Subasta(Pieza piezaSubasta, int precioMinimo) {
        this.piezaSubasta = piezaSubasta;
        this.precioMinimo = precioMinimo;
        }
    
    public void recibir_oferta(Oferta oferta) throws OfertaMenorAlPrecioMinimoException, OfertaMenorOfertaAcualException{
    	
    	//Comprueba si la oferta es mayor al precio minimo. Si no lo es tira una excepcion
    	
    	if(oferta.getCantidad() > precioMinimo) {
    		
    		//Comprueba si existe una oferta actual. Si no la hay, la oferta actual es la oferta que se recibe
    		
    		if (ofertaActual == null) {
    			oferta.setAceptada(true);
    			this.registrarOferta(oferta);
    			this.ofertaActual = oferta;
    		}
    		else {
    			
    			//Comprueba si la oferta recibida es mayor a la oferta actual. Si lo es, la oferta actual se actualiza. Si no se tira una excepcion.
    			
				if (oferta.getCantidad() > ofertaActual.getCantidad()) {
					oferta.setAceptada(true);
					this.registrarOferta(oferta);
					ofertaActual = oferta;
				}
				else {
					this.registrarOferta(oferta);
					throw new OfertaMenorOfertaAcualException();
				}
    		}
    		
    	} else {
    		this.registrarOferta(oferta);
    		throw new OfertaMenorAlPrecioMinimoException();
    	}
    }
    
    private void registrarOferta(Oferta oferta) {
    	
    	if (oferta.isAceptada()){
    		ofertasAceptadas.addLast(oferta);
    	}
    	else {
    		ofertasDeclinadas.addLast(oferta);
    	}
    }

	public Oferta finalizarSubasta() {
		this.subastaFinalizada = true;
		return ofertaActual;
		
		}
	
	public Pieza getPiezaSubasta() {
		return this.piezaSubasta;
	}
	
	public int getPrecioMinimo() {
		return this.precioMinimo;
	}
	
	public boolean getSubastaFinalizada() {
		return this.subastaFinalizada;
	}
	
}