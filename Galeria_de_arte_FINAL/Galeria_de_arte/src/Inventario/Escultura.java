package Inventario;

public class Escultura extends Pieza {
    private double peso;  // Peso de la escultura en kilogramos
    private String material;  // Material de la escultura

    public Escultura(String titulo, String autor, int anioCreacion, String lugarCreacion, int tiempoGaleria, int tiempoMaximo, double peso, String material) {
        super(titulo, autor, anioCreacion, lugarCreacion, tiempoGaleria, tiempoMaximo);
        this.peso = peso;
        this.material = material;
    }

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
