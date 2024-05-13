package Inventario;

public class Autor {
    private String nombre;
    private boolean esColectivo;
    private boolean esAnonimo;

    // Constructor para autor conocido individual o colectivo
    public Autor(String nombre, boolean esColectivo) {
        this.nombre = nombre;
        this.esColectivo = esColectivo;
        this.esAnonimo = false; // Si se proporciona un nombre, no es anónimo
    }

    // Constructor para autor anónimo
    public Autor() {
        this.nombre = "Anónimo";
        this.esColectivo = false;
        this.esAnonimo = true;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        this.esAnonimo = (nombre == null || nombre.trim().isEmpty());
    }

    public boolean esColectivo() {
        return esColectivo;
    }

    public void setEsColectivo(boolean esColectivo) {
        this.esColectivo = esColectivo;
    }

    public boolean esAnonimo() {
        return esAnonimo;
    }

    // No hay necesidad de un setter para esAnonimo ya que está determinado por el estado del nombre
}
