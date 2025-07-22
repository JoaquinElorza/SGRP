/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entidades;

import Modelo.DAO.EmpresaDAO;

public class EmpresaEntidad {

    private int idEmpresa;
    private String nombre;
    private String contacto;

    public EmpresaEntidad() {
    }

    public EmpresaEntidad(int idEmpresa, String nombre, String contacto) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public boolean eliminarEmpresa(int id) {
        EmpresaDAO dao = new EmpresaDAO();
        return dao.eliminar(id);
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}
