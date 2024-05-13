package Transacciones;

import java.util.HashMap;
import java.util.UUID;


public class Banco {
    private HashMap<UUID, HashMap<String, Integer>> informacion;

    public boolean setBalance(int cantidad, UUID codigoCliente, String tipoCuenta, boolean positivo) {
        HashMap<String, Integer> informacionCliente = informacion.get(codigoCliente);
        
        if (positivo) {
        	if (informacionCliente == null) {
        	return false;
        	} else {
        		if (informacionCliente.get(tipoCuenta) == null) {
        			return false;
        		} else {
        			
					int balance = informacionCliente.get(tipoCuenta);
					int nuevoBalance = balance + cantidad;
					informacionCliente.replace(tipoCuenta, nuevoBalance);
					return true;
        		}
    
        	}
        	
        } else {

        if (informacionCliente == null) {
            return false;
        } else {
        	
        	if (informacionCliente.get(tipoCuenta) == null){
        		return false;
        	} else {
        		int balance = informacionCliente.get(tipoCuenta);
        		if (cantidad > balance) {
        			return false;
        		} else {
        			int nuevoBalance = balance - cantidad;
        			informacionCliente.replace(tipoCuenta, nuevoBalance);
        			return true;
        		}
        	}
        }

    }
}
}

