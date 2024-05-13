package Inventario;

public class Fotografia extends Pieza {
    private String tipoCamara;  // Tipo de cámara utilizada para la fotografía
    private String formato;     // Formato de la imagen (digital, film, etc.)

    public Fotografia(String titulo, String autor, int anioCreacion, String lugarCreacion, int tiempoGaleria, int tiempoMaximo, String tipoCamara, String formato) {
        super(titulo, autor, anioCreacion, lugarCreacion, tiempoGaleria, tiempoMaximo);
        this.tipoCamara = tipoCamara;
        this.formato = formato;
    }

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
