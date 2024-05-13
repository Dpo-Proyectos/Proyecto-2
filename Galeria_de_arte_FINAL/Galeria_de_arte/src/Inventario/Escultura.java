package Inventario;

public class Escultura extends Pieza {
    public Escultura(String titulo, Autor autor, int anioCreacion, String lugarCreacion, int tiempoGaleria,
			int tiempoMaximo, String codigoPieza, boolean exhibida) {
		super(titulo, autor, anioCreacion, lugarCreacion, tiempoGaleria, tiempoMaximo, codigoPieza, exhibida);
		// TODO Auto-generated constructor stub
	}

	private double peso;  // Peso de la escultura en kilogramos
    private String material;  // Material de la escultura


    

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
