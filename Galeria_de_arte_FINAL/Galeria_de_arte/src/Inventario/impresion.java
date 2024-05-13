package Inventario;

public class impresion extends Pieza {
    public impresion(String titulo, Autor autor, int anioCreacion, String lugarCreacion, int tiempoGaleria,
			int tiempoMaximo, String codigoPieza, boolean exhibida) {
		super(titulo, autor, anioCreacion, lugarCreacion, tiempoGaleria, tiempoMaximo, codigoPieza, exhibida);

	}

	private String tecnicaImpresion;  // Técnica de impresión utilizada
    private String tamaño;            // Tamaño de la impresión

    

    public String getTecnicaImpresion() {
        return tecnicaImpresion;
    }

    public void setTecnicaImpresion(String tecnicaImpresion) {
        this.tecnicaImpresion = tecnicaImpresion;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
}
