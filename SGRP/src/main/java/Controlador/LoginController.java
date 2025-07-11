package controlador;

import Modelo.DAO.LoginDAO;
import Vista.MenuPrincipal;
import javax.swing.JOptionPane;
import vista.Login1;

public class LoginController {
    private final LoginDAO loginDAO;

    public LoginController() {
        this.loginDAO = new LoginDAO();
    }

    public void validarCredenciales(String usuario, String contrasena, javax.swing.JFrame vista) {
      /*  if(usuario.equals("Baruc Elorza")){
            
            Login1 l = new Login1();
            l.dispose();
        }*/
        
        if (usuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "⚠️ Todos los campos son obligatorios.");
            return;
        }
        
        String nombre = loginDAO.autenticarUsuario(usuario, contrasena);
        if (nombre != null) {
            MenuPrincipal p = new MenuPrincipal();
            p.setVisible(true);
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista, "❌ Usuario o contraseña incorrectos");
        }
    }
    
}