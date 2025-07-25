package Vista;

import Modelo.DAO.AlumnoCarg;
import Modelo.DAO.AlumnoDAO;
import Modelo.DAO.CarpetaOculta;
import javax.swing.*;
import java.awt.*;

public class EditarAlumno extends JFrame {

    private JTextField txtNombre, txtApPaterno, txtApMaterno, txtCorreo, txtTelefono, txtControl;
    private JButton btnGuardar, btnCerrar;

    // Guarda aquí el control anterior
    private String numeroControlOriginal;

    public EditarAlumno() {
        setTitle("Editar Alumno");
        setSize(400, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // 🧩 Panel de formularios
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));

        formPanel.add(new JLabel("Nombre"));
        txtNombre = new JTextField();
        formPanel.add(txtNombre);

        formPanel.add(new JLabel("Apellido Paterno"));
        txtApPaterno = new JTextField();
        formPanel.add(txtApPaterno);

        formPanel.add(new JLabel("Apellido Materno"));
        txtApMaterno = new JTextField();
        formPanel.add(txtApMaterno);

        formPanel.add(new JLabel("Correo"));
        txtCorreo = new JTextField();
        formPanel.add(txtCorreo);

        formPanel.add(new JLabel("Teléfono (10 dígitos)"));
        txtTelefono = new JTextField();
        formPanel.add(txtTelefono);

        formPanel.add(new JLabel("Número de Control"));
        txtControl = new JTextField();
        formPanel.add(txtControl);

        add(formPanel, BorderLayout.CENTER);

        // 🛎 Botones inferiores
        JPanel btnPanel = new JPanel();
        btnGuardar = new JButton("Guardar");
        btnCerrar = new JButton("Cerrar");

        btnGuardar.addActionListener(e -> guardarAlumno());
        btnCerrar.addActionListener(e -> dispose());

        btnPanel.add(btnCerrar);
        btnPanel.add(btnGuardar);
        add(btnPanel, BorderLayout.SOUTH);
    }

    public void cargarDatos(String numeroControl, String nombre, String apPaterno,
            String apMaterno, String telefono, String correo) {
        numeroControlOriginal = numeroControl;
        txtControl.setText(numeroControl);
        txtNombre.setText(nombre);
        txtApPaterno.setText(apPaterno);
        txtApMaterno.setText(apMaterno);
        txtTelefono.setText(telefono);
        txtCorreo.setText(correo);
    }

    private void guardarAlumno() {
        String nombre = txtNombre.getText().trim();
        String apPaterno = txtApPaterno.getText().trim();
        String apMaterno = txtApMaterno.getText().trim();
        String correo = txtCorreo.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String numeroControl = txtControl.getText().trim();

        String numeroControlNuevo = txtControl.getText().trim();

        // 🛡️ Validaciones obligatorias
        if (nombre.isEmpty() || apPaterno.isEmpty() || numeroControl.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡Todos los campos son obligatorios!");
            return;
        }

        // 🔡 Validación de nombre y apellidos (solo letras y espacios)
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")
                || !apPaterno.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")
                || !apMaterno.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            JOptionPane.showMessageDialog(this, "⚠️ Nombre y apellidos solo deben contener letras.");
            return;
        }

        // 📞 Validación de teléfono (10 dígitos exactos, sin letras)
        if (!telefono.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "⚠️ El teléfono debe tener solo números (10 dígitos).");
            return;
        }

        // 📧 Validación de correo electrónico estándar
        if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(this, "⚠️ El correo electrónico no es válido.");
            return;
        }

        // chequeo de duplicados (igual que en docentes)
        if (!numeroControlNuevo.equals(numeroControlOriginal)
                && new AlumnoDAO().existeNumeroControl(numeroControlNuevo)) {
            JOptionPane.showMessageDialog(this,
                    "⚠️ Ese número de control ya existe.");
            return;
        }

        // crea objeto con los valores nuevos
        AlumnoCarg alumno = new AlumnoCarg(
                nombre, apPaterno, apMaterno,
                numeroControlNuevo, correo, telefono
        );

        // llama al DAO pasándole el control original
        boolean ok = new AlumnoDAO()
                .actualizarAlumno(alumno, numeroControlOriginal);

        if (ok) {
            JOptionPane.showMessageDialog(this,
                    "✅ Alumno actualizado correctamente.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "❌ Error al actualizar. Revisa los datos.");
        }
    }
}
