/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entidades;

/**
 *
 * @author yahir
 */
import java.util.Date;

public class Anteproyecto {
    private int idAnteproyecto;
    private String nombre;
    private String descripcion;
    private String lineaInvestigacion;
    private Date fechaRegistro;
    private String estado;
    private String usuarioRegistro;
    private int fkAlumno;
    private String rfcEmpresa;

   
    public void setIdAnteproyecto(int id) { this.idAnteproyecto = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setLineaInvestigacion(String linea) { this.lineaInvestigacion = linea; }
    public void setFechaRegistro(Date fecha) { this.fechaRegistro = fecha; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setUsuarioRegistro(String usuario) { this.usuarioRegistro = usuario; }
    public void setFkAlumno(int fkAlumno) { this.fkAlumno = fkAlumno; }
    public void setRfcEmpresa(String rfc) { this.rfcEmpresa = rfc; }

    public int getIdAnteproyecto() { return idAnteproyecto; }
    public String getNombre() { return nombre; }

public String getDescripcion() { return descripcion; }
public String getLineaInvestigacion() { return lineaInvestigacion; }
public Date getFechaRegistro() { return fechaRegistro; }
public String getEstado() { return estado; }
public String getUsuarioRegistro() { return usuarioRegistro; }
public int getFkAlumno() { return fkAlumno; }
public String getRfcEmpresa() { return rfcEmpresa; }
}