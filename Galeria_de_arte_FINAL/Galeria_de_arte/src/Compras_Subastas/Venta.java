package Compras_Subastas;
import Exceptions.OfrecimientoMenorAlPrecioVentaException;
import Exceptions.PiezaBloqueadaException;
import Inventario.Pieza;
 

public class Venta {
	
    public final Pieza pieza;
    public final int precioVenta;
    public boolean bloqueo;
	private Ofrecimiento ofrecimientoActual;
	public boolean ventaFinalizada;

    public Venta(Pieza pieza, int precioVenta) {
        this.pieza = pieza;
        this.precioVenta = precioVenta;
        this.bloqueo = false;
        this.ofrecimientoActual = null;
        this.ventaFinalizada = false;
    }
    
    public void recibirOfrecimientoCompra(Ofrecimiento ofrecimiento) throws PiezaBloqueadaException, OfrecimientoMenorAlPrecioVentaException {
    	
    	//Se checkea si la pieza esta bloqueada. Si lo esta hay una excepcion
		if (this.bloqueo) {
			throw new PiezaBloqueadaException();
		}
		else {
			//Se checkea si el ofrecimiento es mayor o igual al precio de venta
			if (ofrecimiento.getTransaccion().getCantidad() >= this.precioVenta) {
				this.setOfrecimiento(ofrecimiento);
				this.bloquearPieza();
			}
			else {
				throw new OfrecimientoMenorAlPrecioVentaException();
			}
		}
    }
    
    public void finalizarVenta() {
    	
    	this.ventaFinalizada = true;
    }
    	
    private void bloquearPieza() {
    	this.bloqueo = true;
    }

    public Pieza getPieza() {
        return pieza;
    }
    
    public int getPrecioVenta() {
        return precioVenta;
    }

    public boolean isBloqueo() {
        return bloqueo;
    }

    private void setOfrecimiento(Ofrecimiento ofrecimiento) {
    	this.ofrecimientoActual = ofrecimiento;
    }
    
	public Ofrecimiento getOfrecimientoActual() {
		return this.ofrecimientoActual;
	}
}

