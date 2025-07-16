package Controlador;

import Modelo.DAO.LoginDAO;
import Vista.MenuPrincipal;
import javax.swing.JOptionPane;
import Vista.Login1;

public class LoginController {
    private final LoginDAO loginDAO;

    public LoginController() {
        this.loginDAO = new LoginDAO();
    }

    public boolean validarCredenciales(String usuario, String contrasena, javax.swing.JFrame vista) {
     if (usuario.isEmpty() || contrasena.isEmpty()) {
        JOptionPane.showMessageDialog(vista, "⚠️ Todos los campos son obligatorios.");
        return false;
    }

    String nombre = loginDAO.autenticarUsuario(usuario, contrasena);
    if (nombre != null) {
        MenuPrincipal p = new MenuPrincipal();
        p.setVisible(true);
        vista.dispose();
        return true;
    } else {
        return false; 
    }
}

    
}