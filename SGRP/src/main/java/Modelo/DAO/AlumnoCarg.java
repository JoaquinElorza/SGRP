package Modelo.DAO;

public class AlumnoCarg {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String numeroControl;
    private String correoElectronico;
    private String numeroTelefono;
    private String proyecto;

    public AlumnoCarg() {}

    public AlumnoCarg(String nombre, String apellidoPaterno, String apellidoMaterno,
                      String numeroControl, String correoElectronico, String numeroTelefono,
                      String proyecto) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numeroControl = numeroControl;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.proyecto = proyecto;
    }

    public AlumnoCarg(String nombre, String apellidoPaterno, String apellidoMaterno,
                      String numeroControl) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numeroControl = numeroControl;
    }
    
        public AlumnoCarg(String nombre, String apellidoPaterno, String apellidoMaterno,
                      String numeroControl, String correoElectronico, String numeroTelefono) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numeroControl = numeroControl;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String apellidoPaterno) { this.apellidoPaterno = apellidoPaterno; }

    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String apellidoMaterno) { this.apellidoMaterno = apellidoMaterno; }

    public String getNumeroControl() { return numeroControl; }
    public void setNumeroControl(String numeroControl) { this.numeroControl = numeroControl; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    public String getNumeroTelefono() { return numeroTelefono; }
    public void setNumeroTelefono(String numeroTelefono) { this.numeroTelefono = numeroTelefono; }

    public String getProyecto() { return proyecto; }
    public void setProyecto(String proyecto) { this.proyecto = proyecto; }
}
