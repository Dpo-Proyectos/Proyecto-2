package consola;

import java.util.Scanner;

import Compras_Subastas.Administrador;
import Compras_Subastas.Cliente;
import Compras_Subastas.Sesiones;
import Compras_Subastas.Usuario;
import Exceptions.UsuarioOContrasenaIncorrecta;
import Inventario.Galeria;

public class GaleriaDeArte {
	
	public static void main(String[] args) {
		
		Sesiones sesiones = new Sesiones();
		Galeria galeria = new Galeria();	
		
		System.out.println("Bienvenido a la Galería de Arte");
		System.out.println("-------------------------------");
		Scanner sc = new Scanner(System.in);
		
		while (true) {
		
			System.out.println("Introduce tu Usuario: ");
			String nombre = sc.nextLine();
			System.out.println("Introduce tu Contraseña: ");
			String contrasena = sc.nextLine();
			
			Usuario usuario = sesiones.getUsuario(nombre);
			
			if (usuario == null) {
				System.out.println("Usuario y/o contraseña incorrectos");
			}
			else { 
				try{
					usuario.iniciarSesion(nombre, contrasena);
				}
				catch (UsuarioOContrasenaIncorrecta e) {
	                System.out.println("Usuario y/o contraseña incorrectos");
	            }
			}
			
			if (usuario.getSesionIniciada()) {
                System.out.println("Sesión iniciada con éxito");
                break;
            }
			
		sc.close();
        
		
		if (usuario instanceof Cliente) {
			ConsolaCliente consolaCliente = new ConsolaCliente();
            consolaCliente.consolaCliente(galeria, (Cliente) usuario);
        }
		else if (usuario instanceof Administrador) {
			ConsolaAdministrador consolaAdministrador = new ConsolaAdministrador();
			consolaAdministrador.consolaAdministrador();
		}
		else {
			ConsolaEmpleado consolaEmpleado = new ConsolaEmpleado();
			consolaEmpleado.consolaEmpleado();
		}
		
			
	}
}}
