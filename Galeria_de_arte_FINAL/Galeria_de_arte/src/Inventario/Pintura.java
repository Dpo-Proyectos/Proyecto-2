package Inventario;

public class Pintura extends Pieza {
    public Pintura(String titulo, Autor autor, int anioCreacion, String lugarCreacion, int tiempoGaleria,
			int tiempoMaximo, String codigoPieza, boolean exhibida) {
		super(titulo, autor, anioCreacion, lugarCreacion, tiempoGaleria, tiempoMaximo, codigoPieza, exhibida);

	}

	private String tipoPintura;

    

    // Métodos getters y setters para tipoPintura
    public String getTipoPintura() {
        return tipoPintura;
    }

    public void setTipoPintura(String tipoPintura) {
        this.tipoPintura = tipoPintura;
    }
}
