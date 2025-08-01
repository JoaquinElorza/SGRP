package Modelo.DAO;

import Utilidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocenteCarg {
    private int idDocente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String rfc;
    private String telefono;
    private String correo;

    public DocenteCarg() {}

    public DocenteCarg(
                       String nombre,
                       String apellidoPaterno,
                       String apellidoMaterno,
                       String rfc,
                       String telefono,
                       String correo) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.rfc = rfc;
        this.telefono = telefono;
        this.correo = correo;
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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public DocenteCarg consultarPorId(int idDocente) {
    String sql = """
        SELECT d.id_docente, d.rfc, d.telefono, d.correo,
               p.nombre, p.ap_paterno, p.ap_materno
          FROM docente d
          JOIN persona p ON d.fk_persona = p.id_persona
         WHERE d.id_docente = ? AND p.status = 'A'
    """;

    try (Connection conn = Conexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {
         
        ps.setInt(1, idDocente);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            DocenteCarg d = new DocenteCarg();
            d.setIdDocente(rs.getInt("id_docente"));
            d.setRfc(rs.getString("rfc"));
            d.setTelefono(rs.getString("telefono"));
            d.setCorreo(rs.getString("correo"));
            d.setNombre(rs.getString("nombre"));
            d.setApellidoPaterno(rs.getString("ap_paterno"));
            d.setApellidoMaterno(rs.getString("ap_materno"));
            return d;
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;

}}