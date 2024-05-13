package Persistencia;

import Compras_Subastas.Usuario;
import Compras_Subastas.Cliente;
import Compras_Subastas.Operador;
import Compras_Subastas.Trabajador;
import Compras_Subastas.Administrador;
import Inventario.Pieza;
import Transacciones.MetodoPago;

import java.io.*;
import java.util.Properties;

public class CentralPersistencia {
	
	public CentralPersistencia(String rutaArchivo, Object object) {
		
		
		try {
			if (rutaArchivo.equals("dataSerializacion/Clientes.txt")) {
				serializarCliente(rutaArchivo, (Cliente) object);
			}
			
			else if(rutaArchivo.equals("dataSerializacion/Trabajadores.txt")) {
				serializarTrabajador(rutaArchivo, (Usuario) object);
			}
			
			
			else if (rutaArchivo.equals("dataSerializacion/Administradores.txt")) {
				serializarAdministrador(rutaArchivo, (Administrador) object);
			}
			
			else if (rutaArchivo.equals("dataSerializacion/Piezas.txt")) {
				serializarPieza(rutaArchivo, (Pieza) object);
			}
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void serializarCliente(String rutaArchivo, Cliente cliente) throws IOException {
	    File archivo = new File(rutaArchivo);
	    if (!archivo.exists()) {
	        archivo.createNewFile();  
	    }
	    try (FileWriter escribir = new FileWriter(archivo, true);
	         PrintWriter linea = new PrintWriter(escribir)) {
	       
	        linea.println(cliente.getUsuario() + ":" + cliente.getcontrasena() + ":" + cliente.getCodigoCliente());
	    }  
	}
	
	public void serializarTrabajador(String rutaArchivo, Usuario usuario) throws IOException {
	    File archivo = new File(rutaArchivo);
	    if (!archivo.exists()) {
	        archivo.createNewFile();
	    }
	    try (FileWriter escribir = new FileWriter(archivo, true);
	         PrintWriter linea = new PrintWriter(escribir)) {
	        if (usuario instanceof Trabajador) {
	            Trabajador trabajador = (Trabajador) usuario;
	            linea.println(trabajador.getUsuario() + ":" + trabajador.getContrasena() + ":" + trabajador.getPermisoEspecial());
	        } else {
	            linea.println(usuario.getUsuario() + ":" + usuario.getContrasena());
	        }
	    }  // This automatically closes PrintWriter and FileWriter
	}
	
	
	
	public void serializarAdministrador(String rutaArchivo, Administrador administrador) throws IOException {
        File archivo = new File(rutaArchivo);
        File lockFile = new File(rutaArchivo + ".lock");

        if (!archivo.exists()) {
            archivo.createNewFile();
            escribirEnArchivo(archivo, administrador);
            crearBloqueo(lockFile);
        } else {
            if (!lockFile.exists()) {
                if (archivo.length() == 0) { 
                    escribirEnArchivo(archivo, administrador);
                    crearBloqueo(lockFile);
                } else {
                    System.out.println("El archivo no está vacío. No se puede escribir.");
                }
            } else {
                if (archivo.length() == 0) { 
                    eliminarBloqueo(lockFile);
                    escribirEnArchivo(archivo, administrador);
                    crearBloqueo(lockFile);
                } else {
                    System.out.println("El archivo ya está bloqueado y no está vacío. No se puede escribir.");
                }
            }
        }
    }
	

	private void escribirEnArchivo(File archivo, Administrador administrador) throws IOException {
	    try (FileWriter escribir = new FileWriter(archivo, true);
	         PrintWriter linea = new PrintWriter(escribir)) {
	        linea.println(administrador.getUsuario() + ":" + administrador.getPermisoEspecial() + ":" + administrador.getContrasena());
	    }  // This automatically closes PrintWriter and FileWriter
	}
    

    private void crearBloqueo(File lockFile) throws IOException {
        lockFile.createNewFile();
    }

    private void eliminarBloqueo(File lockFile) {
        lockFile.delete();
    }
			
	public void serializarPieza(String rutaArchivo, Pieza pieza) throws IOException {
		File archivo = new File(rutaArchivo);
		if (!archivo.exists()) {
			archivo.createNewFile();
			FileWriter escribir = new FileWriter(archivo, true);
			PrintWriter linea = new PrintWriter(escribir);
			linea.println(pieza.getTitulo()+":"+pieza.getAnioCreacion()+":"+pieza.getLugarCreacion()+":"+pieza.getAutor());
			linea.close();
			escribir.close();
		}else {
			FileWriter escribir = new FileWriter(archivo, true);
			PrintWriter linea = new PrintWriter(escribir);
			linea.println(pieza.getTitulo()+":"+pieza.getAnioCreacion()+":"+pieza.getLugarCreacion()+":"+pieza.getAutor());
			linea.close();
			escribir.close();
			
		}
	}
	public static Administrador getAdministradorByID(String adminUser) throws IOException {
	    try (BufferedReader br = new BufferedReader(new FileReader("dataSerializacion/Administradores.txt"))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            String[] datos = linea.split(":");
	            if (datos[0].equals(adminUser)) {  // Check if the ID matches the required one
	                String usuario = datos[1];
	                String contrasena = datos[2];
	                boolean permisoEspecial = Boolean.parseBoolean(datos[3]);  // Assuming the fourth part is the boolean permisoEspecial
	                return new Administrador(usuario, contrasena, permisoEspecial);
	            }
	        }
	    }
	    return null;  // Return null if no matching administrator is found
	}
	
	public static Cliente getCompradorByID(String user) throws IOException {
	    try (BufferedReader br = new BufferedReader(new FileReader("dataSerializacion/Compradores.txt"))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            String[] datos = linea.split(":");
	            if (datos[0].equals(user)) {
	                String usuario = datos[0];
	                String contraseña = datos[1];
	                String codigoCliente = datos[2];
	               

	                // Mock implementations assuming you have a way to deserialize or create these objects:
	                //TarjetaCredito tarjetaCredito = deserializeTarjetaCredito(datos[2]);
	                //Efectivo efectivo = deserializeEfectivo(datos[3]);
	                //TransferenciaElectronica transferenciaElectronica = deserializeTransferenciaElectronica(datos[4]);

	                Cliente cliente = new Cliente(usuario, contraseña, codigoCliente);
	                return cliente;
	            }
	        }
	    }
	    return null;  // Return null if no matching client is found
	}
	
	public static Usuario getTrabajadorByUser(String User) throws IOException {
	    try (BufferedReader br = new BufferedReader(new FileReader("dataSerializacion/Trabajadors.txt"))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            String[] datos = linea.split(":");
	            if (datos[0].equals(User)) {
	                String userId = datos[0];
	                String contrasena = datos[1];
	                boolean permisoEspecial = Boolean.parseBoolean(datos[2]);
	                String tipoTipo = datos[3];

	                if (tipoTipo.equals("Trabajador")) {
	                    return new Trabajador(userId, contrasena, permisoEspecial);
	                } else if (tipoTipo.equals("OPERADOR")) {
	                    return new Operador(userId, contrasena, permisoEspecial);
	                }
	            }
	        }
	    }
	    return null;  // Return null if no matching user is found
	}
}
