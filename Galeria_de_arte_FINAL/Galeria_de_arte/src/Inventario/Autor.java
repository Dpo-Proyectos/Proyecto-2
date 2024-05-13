package Inventario;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Autor {
    private String nombre;
    private boolean esColectivo;
    private boolean esAnonimo;
    private ArrayList<UUID> piezasHechas;
    private ArrayList<Date> fechasVendidas;
    private ArrayList<Integer> preciosVendidos;

    // Constructor para autor conocido individual o colectivo
    public Autor(String nombre, boolean esColectivo) {
        this.nombre = nombre;
        this.esColectivo = esColectivo;
        this.esAnonimo = false; // Si se proporciona un nombre, no es anónimo
    }

    // Constructor para autor anónimo
    public Autor() {
        this.nombre = "Anónimo";
        this.esColectivo = false;
        this.esAnonimo = true;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        this.esAnonimo = (nombre == null || nombre.trim().isEmpty());
    }

    public boolean esColectivo() {
        return esColectivo;
    }

    public void setEsColectivo(boolean esColectivo) {
        this.esColectivo = esColectivo;
    }

    public boolean esAnonimo() {
        return esAnonimo;
    }

	public ArrayList<UUID> getPiezasHechas() {
		return piezasHechas;
	}

	public void addPiezaHecha(UUID pieza) {
		this.piezasHechas.add(pieza);
	}

	public ArrayList<Date> getFechasVendidas() {
		return fechasVendidas;
	}

	public void addFechasVendidas(Date fecha) {
		this.fechasVendidas.add(fecha);
	}

	public ArrayList<Integer> getPreciosVendidos() {
		return preciosVendidos;
	}

	public void setPreciosVendidos(int precio) {
		this.preciosVendidos.add(precio);
	}

    // No hay necesidad de un setter para esAnonimo ya que está determinado por el estado del nombre
}
