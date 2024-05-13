package Inventario;

public class impresion extends Pieza {
    private String tecnicaImpresion;  // Técnica de impresión utilizada
    private String tamaño;            // Tamaño de la impresión

    public impresion(String titulo, String autor, int anioCreacion, String lugarCreacion, int tiempoGaleria, int tiempoMaximo, String tecnicaImpresion, String tamaño) {
        super(titulo, autor, anioCreacion, lugarCreacion, tiempoGaleria, tiempoMaximo);
        this.tecnicaImpresion = tecnicaImpresion;
        this.tamaño = tamaño;
    }

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
