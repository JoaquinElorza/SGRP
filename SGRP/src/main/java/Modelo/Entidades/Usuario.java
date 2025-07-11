// Usuario.java
package Modelo.Entidades;

public class Usuario extends Persona {
    private int idUsuario;
    private String password;
    private TipoUsuario tipoUsuario;

    public Usuario() {
        super();
    }

    public Usuario(int idPersona, String nombre, String apellidoPaterno, String apellidoMaterno, String correo,
                   int idUsuario, String password, TipoUsuario tipoUsuario) {
        super(idPersona, nombre, apellidoPaterno, apellidoMaterno, correo);
        this.idUsuario   = idUsuario;
        this.password    = password;
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
