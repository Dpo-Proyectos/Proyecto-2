package Inventario;
import java.util.List;

import Compras_Subastas.Administrador;
import Compras_Subastas.Subasta;
import Compras_Subastas.Usuario;
import Compras_Subastas.Venta;
import Exceptions.SinPermisoAdministradorException;

import java.util.ArrayList;


public class Galeria {
	
    private ArrayList<Pieza> inventario;
    private ArrayList<Subasta> subastas;
    private ArrayList<Venta> ventas;

    public Galeria() {
        inventario = new ArrayList<>();
        subastas = new ArrayList<>();
        ventas = new ArrayList<>();
    }

    public void ingresarPieza(Pieza pieza, Usuario usuario, boolean SubastaTrueVentaFalse, int precio) throws SinPermisoAdministradorException{
    	
    	if (usuario instanceof Administrador) {
    		inventario.add(pieza);
			if (SubastaTrueVentaFalse) {
				subastas.add(new Subasta(pieza, precio));
			} else {
				ventas.add(new Venta(pieza, precio));
			}
    		
    	} else {
    		throw new SinPermisoAdministradorException();
    	}
    }

    public void registrarIngresoPiezaVenta(Pieza pieza, int precio) {
        // Registrar pieza para venta
        inventario.add(pieza);
        
    }

    public void registrarIngresoPiezaSubasta(Pieza pieza, int precioMinimo) {
        // Registrar pieza para subasta
        inventario.add(pieza);
        
    }

    // Método para consultar piezas en el inventario
    public List<Pieza> consultarInventario() {
        return new ArrayList<>(inventario);
    }

	public ArrayList<Subasta> getSubastas() {
		return subastas;
	}

	public void addSubastas(Subasta subasta) {
		this.subastas.add(subasta);
	}

	public ArrayList<Venta> getVentas() {
		return ventas;
	}

	public void addVentas(Venta venta) {
		this.ventas.add(venta);
	}
}

