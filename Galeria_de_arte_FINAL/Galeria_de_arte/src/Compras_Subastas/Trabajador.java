package Compras_Subastas;

public class Trabajador extends Usuario {
    protected boolean permisoEspecial;

    public Trabajador(String usuario, String contrasena, boolean permisoEspecial) {
        super(usuario, contrasena);
        this.permisoEspecial = permisoEspecial;
    }

  
}
