package Inventario;

public class Fotografia extends Pieza {
    public Fotografia(String titulo, Autor autor, int anioCreacion, String lugarCreacion, int tiempoGaleria,
			int tiempoMaximo, String codigoPieza, boolean exhibida) {
		super(titulo, autor, anioCreacion, lugarCreacion, tiempoGaleria, tiempoMaximo, codigoPieza, exhibida);

	}

	private String tipoCamara;  // Tipo de cámara utilizada para la fotografía
    private String formato;     // Formato de la imagen (digital, film, etc.)

  

    public String getTipoCamara() {
        return tipoCamara;
    }

    public void setTipoCamara(String tipoCamara) {
        this.tipoCamara = tipoCamara;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
