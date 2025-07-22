/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.EmpresaDAO;
import Modelo.Entidades.EmpresaEntidad;

public class EmpresaControlador {

    private EmpresaDAO dao;

    public EmpresaControlador() {
        dao = new EmpresaDAO();
    }

    public boolean guardarEmpresa(String nombre, String contacto) {
        EmpresaEntidad empresa = new EmpresaEntidad();
        empresa.setNombre(nombre);
        empresa.setContacto(contacto);
        return dao.insertarEmpresa(empresa);
    }

    public boolean actualizarEmpresa(int id, String nombre, String contacto) {
        EmpresaEntidad empresa = new EmpresaEntidad();
        empresa.setIdEmpresa(id);
        empresa.setNombre(nombre);
        empresa.setContacto(contacto);

        EmpresaDAO dao = new EmpresaDAO();
        return dao.actualizarEmpresa(empresa);
    }

    public boolean eliminarEmpresa(int id) {
        EmpresaDAO dao = new EmpresaDAO();
        return dao.eliminar(id);
    }

}
