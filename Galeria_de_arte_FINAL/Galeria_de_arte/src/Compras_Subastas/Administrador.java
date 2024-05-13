package Compras_Subastas;

import Exceptions.PiezaYaEntregada;
import Exceptions.SinPermisoAdministradorException;
import Inventario.Galeria;
import Inventario.Pieza;




public class Administrador extends Trabajador {

    public Administrador(String usuario, String contrasena, boolean permisoEspecial) {
        super(usuario, contrasena, permisoEspecial);
    }

	public void ingresarPieza(Pieza pieza, Galeria galeria, boolean SubastaTrueVentaFalse, int precio) {
		try {
			galeria.ingresarPieza(pieza, this, SubastaTrueVentaFalse, precio);
		} catch (SinPermisoAdministradorException e) {
			// Nunca ocurrira esto
			e.printStackTrace();
		}
	}
	
	public void confirmarVenta(Venta venta) {
		venta.finalizarVenta();
		Cliente cliente = venta.getOfrecimientoActual().getCliente();
		Pieza pieza = venta.getPieza();
		try {
			cliente.recibirPieza(pieza);
		} catch (PiezaYaEntregada e) {
			
		}
	}
	
}