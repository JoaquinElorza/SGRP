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
    private int idDocente;
    private String nombre;
    private String descripcion;
    private String lineaInvestigacion;
    private Date fechaRegistro;
    private String estado;
    private String usuarioRegistro;
    private Integer fkAlumno;
     private int fkDocente;
    private String rfcEmpresa;

    private String statusant;
    private String rfcDocente;


    public int getIdAnteproyecto() {
        return idAnteproyecto;
    }

    public void setIdAnteproyecto(int idAnteproyecto) {
        this.idAnteproyecto = idAnteproyecto;
    }
    
    public int getIdDocente() {
    return idDocente;
}
    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLineaInvestigacion() {
        return lineaInvestigacion;
    }

    public void setLineaInvestigacion(String lineaInvestigacion) {
        this.lineaInvestigacion = lineaInvestigacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public int getFkAlumno() {
        return fkAlumno;
    }

    public void setFkAlumno(int fkAlumno) {
        this.fkAlumno = fkAlumno;
    }
    public int getFkDocente() {
        return fkDocente;
    }

    public void setFkDocente(int fkDocente) {
        this.fkDocente = fkDocente;
    }

    public String getRfcEmpresa() {
        return rfcEmpresa;
    }

    public void setRfcEmpresa(String rfcEmpresa) {
        this.rfcEmpresa = rfcEmpresa;
    }


    public String getStatusant() {
        return statusant;
    }

    public void setStatusant(String statusant) {
        this.statusant = statusant;
    }

    public String getRfcDocente() {
        return rfcDocente;
    }

    public void setRfcDocente(String rfcDocente) {
        this.rfcDocente = rfcDocente;
    }}
