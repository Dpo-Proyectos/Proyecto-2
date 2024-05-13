package Inventario;

public class Pintura extends Pieza {
    private String tipoPintura;

    public Pintura(String titulo, String autor, int anioCreacion, String lugarCreacion, int tiempoGaleria, int tiempoMaximo, String tipoPintura) {
        super(titulo, autor, anioCreacion, lugarCreacion, tiempoGaleria, tiempoMaximo);
        this.tipoPintura = tipoPintura;
    }

    // Métodos getters y setters para tipoPintura
    public String getTipoPintura() {
        return tipoPintura;
    }

    public void setTipoPintura(String tipoPintura) {
        this.tipoPintura = tipoPintura;
    }
}
