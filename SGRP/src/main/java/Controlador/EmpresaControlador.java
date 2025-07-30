package Controlador;

import Modelo.DAO.EmpresaDAO;
import Modelo.Entidades.EmpresaEntidad;

public class EmpresaControlador {

    private EmpresaDAO dao;

    public EmpresaControlador() {
        dao = new EmpresaDAO();
    }

    public boolean guardarEmpresa(String nombre, String contacto, String correo, String rfc, String direccion, String descripcion) {
        EmpresaEntidad empresa = new EmpresaEntidad();
        empresa.setNombre(nombre);
        empresa.setContacto(contacto);
        empresa.setCorreo(correo);
        empresa.setRfc(rfc);
        empresa.setDireccion(direccion);
        empresa.setDescripcion(descripcion);
        return dao.insertarEmpresa(empresa);
    }

    public boolean actualizarEmpresa(int id, String nombre, String contacto, String correo, String rfc, String direccion, String descripcion) {
        EmpresaEntidad empresa = new EmpresaEntidad();
        empresa.setIdEmpresa(id);
        empresa.setNombre(nombre);
        empresa.setContacto(contacto);
        empresa.setCorreo(correo);
        empresa.setRfc(rfc);
        empresa.setDireccion(direccion);
        empresa.setDescripcion(descripcion);
        return dao.actualizarEmpresa(empresa);
    }

    public boolean eliminarEmpresa(int id) {
        return dao.eliminar(id);
    }
}
