package Modelo.Entidades;

/**
 *
 * @author Jobae
 */
public class ExpedienteAlumno {
    
    String nombre;
    Boolean estatus;
    
    public ExpedienteAlumno(String nombre, Boolean estaus){
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public ExpedienteAlumno() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstatus() {
        return estatus;
    }



    
    
    public String getNombre() {
        return nombre;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }


    
    
    
}
