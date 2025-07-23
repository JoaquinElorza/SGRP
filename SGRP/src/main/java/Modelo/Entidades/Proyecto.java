package Modelo.Entidades;

public class Proyecto {
    private int idProyecto;
    private int idEmpresa;
    private String nombre;
    private String descripcion;
    private String estatus;
  
    public Proyecto() {}

    public Proyecto(int idEmpresa, String nombre, String descripcion, String estatus) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estatus = estatus;
    }

    // Getters y setters
    public int getIdProyecto() { return idProyecto; }
    public void setIdProyecto(int idProyecto) { this.idProyecto = idProyecto; }

    public int getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(int idEmpresa) { this.idEmpresa = idEmpresa; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getEstatus() { return estatus; }
    public void setEstatus(String estatus) { this.estatus = estatus; }

  
}
