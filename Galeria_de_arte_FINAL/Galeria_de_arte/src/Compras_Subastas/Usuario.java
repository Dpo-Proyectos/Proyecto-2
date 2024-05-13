package Compras_Subastas;

import Exceptions.UsuarioOContrasenaIncorrecta;


public class Usuario {
    private String usuario;
    private String contrasena;
    private boolean sesionIniciada = false;

    // Constructor
    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    
   
	public void iniciarSesion(String usuario, String contrasena) throws UsuarioOContrasenaIncorrecta{
		
		// Comprueba si el usuario y la contrasena son correctos. Si lo son inicia la sesion. Si no tira una excepcion
		if (this.usuario.equals(usuario) && this.contrasena.equals(contrasena)) {
			this.sesionIniciada = true;
		}
		else {
			throw new UsuarioOContrasenaIncorrecta();
		}
	}
	
	public boolean getSesionIniciada() {
		return sesionIniciada;
	}
	
	public void cambiarContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	
	
}