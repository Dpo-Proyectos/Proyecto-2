
package Inventario;

public class Video extends Pieza {
    private int duracion;  // Duración del video en minutos

    public Video(String titulo, String autor, int anioCreacion, String lugarCreacion, int tiempoGaleria, int tiempoMaximo, int duracion) {
        super(titulo, autor, anioCreacion, lugarCreacion, tiempoGaleria, tiempoMaximo);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
