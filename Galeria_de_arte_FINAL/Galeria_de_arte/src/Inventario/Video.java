
package Inventario;

public class Video extends Pieza {
	
    public Video(String titulo, Autor autor, int anioCreacion, String lugarCreacion, int tiempoGaleria,
			int tiempoMaximo, String codigoPieza, boolean exhibida) {
		super(titulo, autor, anioCreacion, lugarCreacion, tiempoGaleria, tiempoMaximo, codigoPieza, exhibida);

	}

	private int duracion;  // Duración del video en minutos


    

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
