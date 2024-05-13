package Inventario;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public abstract class Pieza {
	
    private String titulo;
    private Autor autor;
    private int anioCreacion;
    private String lugarCreacion;
    private Date fechaentrada;
    // Tiempos dado en dias.
    private int tiempoGaleria;
    private int tiempoMaximo;
    private final UUID codigoPieza;
    private boolean exhibida;
    public ArrayList<String> dueñosAnteriores;
    public ArrayList<Integer> preciosDeVenta;
    public ArrayList<Date> fechasDeVenta;
    

    // Constructor que inicializa todos los atributos
    public Pieza(String titulo, Autor autor, int anioCreacion, String lugarCreacion, int tiempoGaleria, int tiempoMaximo, String codigoPieza, boolean exhibida) {
        this.codigoPieza = UUID.randomUUID();
		this.titulo = titulo;
        this.autor = autor;
        this.anioCreacion = anioCreacion;
        this.lugarCreacion = lugarCreacion;
        this.tiempoGaleria = 0;
        this.fechaentrada = new Date();
        this.tiempoMaximo = tiempoMaximo;
        this.setExhibida(exhibida);
    } 


	// Métodos getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getAnioCreacion() {
        return anioCreacion;
    }

    public void setAnioCreacion(int anioCreacion) {
        this.anioCreacion = anioCreacion;
    }

    public String getLugarCreacion() {
        return lugarCreacion;
    }

    public void setLugarCreacion(String lugarCreacion) {
        this.lugarCreacion = lugarCreacion;
    }

    public int getTiempoGaleria() {
    	int tiempoActual = (int) (new Date().getTime() - fechaentrada.getTime());
		float tiempoDias = tiempoActual / (1000 * 60 * 60 * 24);
		this.tiempoGaleria = (int) tiempoDias;
		return this.tiempoGaleria;
    }

    public int getTiempoMaximo() {
        return tiempoMaximo;
    }

    public void setTiempoMaximo(int tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
    }


	public UUID getCodigo() {
		return this.codigoPieza;
	}


	public boolean getExhibida() {
		return exhibida;
	}


	public void setExhibida(boolean exhibida) {
		this.exhibida = exhibida;
	}
	
	public void addDueño(String dueño) {
		this.dueñosAnteriores.add(dueño);
    }
	
	public void addPrecioVendido(int precio) {
        this.preciosDeVenta.add(precio);
    }
	
	public void addFechaVenta(Date fecha) {
		this.fechasDeVenta.add(fecha);
	}
	
	public ArrayList<String> getDueñosAnteriores() {
		return dueñosAnteriores;
	}
	
	public ArrayList<Integer> getPreciosDeVenta() {
		return preciosDeVenta;
	}
	
	public ArrayList<Date> getFechasDeVenta() {
		return fechasDeVenta;
	}
	
}
