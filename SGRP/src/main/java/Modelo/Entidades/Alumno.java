package Modelo.Entidades;

public class Alumno extends Persona {
    private String numeroControl;
    private String telefono;

    public Alumno() {
        super();
    }

    public Alumno(Integer idPersona, String nombre, String apellidoPaterno,
                  String apellidoMaterno, String correo,
                  String numeroControl, String telefono) {
        super(idPersona, nombre, apellidoPaterno, apellidoMaterno, correo);
        this.numeroControl = numeroControl;
        this.telefono      = telefono;
    }

    public Alumno(String nControl, String Nombre){
        nControl = nControl;
        Nombre = Nombre;
    }
    
    public String getNumeroControl() { return numeroControl; }
    public void setNumeroControl(String numeroControl) { this.numeroControl = numeroControl; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
