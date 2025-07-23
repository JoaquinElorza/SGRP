package Modelo.Entidades;

public class ExpedienteAlumno {
    
    String nombre;
    boolean estatus;
    
    public ExpedienteAlumno(String nombre, boolean estatus){
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public ExpedienteAlumno() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEstatus() {
        return estatus;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
}
