package Compras_Subastas;
import java.util.HashMap;

public class Sesiones {
	
	private HashMap<String, Usuario> sesiones;
	
	public Sesiones() {
		sesiones = new HashMap<String, Usuario>();
	}
	

    

	public Usuario getUsuario(String nombre) {

		return sesiones.get(nombre);
	}

}
