package Modelo.Entidades;

/**
 *
 * @author Jobae
 */
public class ExpedienteAlumno {
    
    String nombre;
    String estatus;
    
    public ExpedienteAlumno(String nombre, String estaus){
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public String getEstatus() {
        return estatus;
    }
    
    
    
}
