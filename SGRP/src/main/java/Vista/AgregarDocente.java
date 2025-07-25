package Vista;

import Modelo.DAO.DocenteDAO;
import Modelo.DAO.DocenteCarg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AgregarDocente extends JFrame {

    private JTextField txtNombre, txtApPaterno, txtApMaterno, txtTelefono, txtCorreo, txtRFC;
    private JButton btnGuardar, btnCancelar;
    private int mouseX, mouseY;

    public AgregarDocente() {
        setTitle("Agregar Docente");
        setUndecorated(true); // 🔧 Sin barra superior
        setType(Type.UTILITY); // ✅ Permite minimizar
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(null);

        // 🖱️ Movilidad al arrastrar fondo
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX(); mouseY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                setLocation(e.getXOnScreen() - mouseX, e.getYOnScreen() - mouseY);
            }
        });

        txtNombre    = new JTextField(); txtNombre.setBounds(150, 20, 200, 30); add(txtNombre);
        txtApPaterno = new JTextField(); txtApPaterno.setBounds(150, 60, 200, 30); add(txtApPaterno);
        txtApMaterno = new JTextField(); txtApMaterno.setBounds(150, 100, 200, 30); add(txtApMaterno);
        txtTelefono  = new JTextField(); txtTelefono.setBounds(150, 140, 200, 30); add(txtTelefono);
        txtCorreo    = new JTextField(); txtCorreo.setBounds(150, 180, 200, 30); add(txtCorreo);
        txtRFC       = new JTextField(); txtRFC.setBounds(150, 220, 200, 30); add(txtRFC);

        btnGuardar  = new JButton("Guardar");  btnGuardar.setBounds(150, 260, 90, 30); add(btnGuardar);
        btnCancelar = new JButton("Cancelar"); btnCancelar.setBounds(250, 260, 90, 30); add(btnCancelar);

        btnGuardar.addActionListener(e -> guardar());
        btnCancelar.addActionListener(e -> {
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSED));
            dispose();
        });

        JLabel[] labels = {
            new JLabel("Nombre"), new JLabel("Apellido Paterno"), new JLabel("Apellido Materno"),
            new JLabel("Teléfono (10 dígitos)"), new JLabel("Correo electrónico"), new JLabel("RFC")
        };

        int y = 20;
        for (JLabel label : labels) {
            label.setBounds(20, y, 120, 25);
            add(label);
            y += 40;
        }

        configurarInteracciones(); // 🚀 Enter en cascada
    }

    private void configurarInteracciones() {
        txtNombre.addActionListener(e -> txtApPaterno.requestFocusInWindow());
        txtApPaterno.addActionListener(e -> txtApMaterno.requestFocusInWindow());
        txtApMaterno.addActionListener(e -> txtTelefono.requestFocusInWindow());
        txtTelefono.addActionListener(e -> txtCorreo.requestFocusInWindow());
        txtCorreo.addActionListener(e -> txtRFC.requestFocusInWindow());
        txtRFC.addActionListener(e -> guardar());
    }

    private void guardar() {
        String nombre    = txtNombre.getText().trim();
        String apPaterno = txtApPaterno.getText().trim();
        String apMaterno = txtApMaterno.getText().trim();
        String telefono  = txtTelefono.getText().trim();
        String correo    = txtCorreo.getText().trim();
        String rfc       = txtRFC.getText().trim();

        // 🛡️ Validaciones
        if (nombre.isEmpty() || apPaterno.isEmpty() || apMaterno.isEmpty() ||
            telefono.isEmpty() || correo.isEmpty() || rfc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "⚠️ Todos los campos son obligatorios.");
            return;
        }

        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") ||
            !apPaterno.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") ||
            !apMaterno.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            JOptionPane.showMessageDialog(this, "⚠️ El nombre y apellidos solo deben tener letras.");
            return;
        }

        if (!telefono.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "⚠️ El teléfono debe tener 10 dígitos numéricos.");
            return;
        }

        if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(this, "⚠️ El correo electrónico no es válido.");
            return;
        }

        if (!rfc.matches("^[A-Z&Ñ]{3,4}[0-9]{6}[A-Z0-9]{3}$")) {
            JOptionPane.showMessageDialog(this, "️RFC inválido. Debe tener entre 12 y 13 caracteres con estructura válida y mayúsculas.");
            return;
        }

        // 🚀 Registro
        DocenteCarg d = new DocenteCarg(nombre, apPaterno, apMaterno, rfc, telefono, correo);
        boolean ok = new DocenteDAO().agregarDocente(d);

        if (ok) {
            JOptionPane.showMessageDialog(this, "✅ Docente registrado correctamente.");
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSED));
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "❌ El RFC ya existe, contacte al administrador.");
        }
    }
}
