/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author yahir
 */
import Modelo.DAO.DocenteCarg;
import Modelo.DAO.DocenteDAO;
import javax.swing.*;

public class EditarDocente extends JFrame {

    private JTextField txtNombre, txtApPaterno, txtApMaterno, txtTelefono, txtCorreo, txtRFC;
    private JButton btnGuardar;

    public EditarDocente() {
        setTitle("Editar Docente");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(null);

        txtNombre    = new JTextField(); txtNombre.setBounds(150, 20, 200, 25); add(txtNombre);
        txtApPaterno = new JTextField(); txtApPaterno.setBounds(150, 60, 200, 25); add(txtApPaterno);
        txtApMaterno = new JTextField(); txtApMaterno.setBounds(150, 100, 200, 25); add(txtApMaterno);
        txtTelefono  = new JTextField(); txtTelefono.setBounds(150, 140, 200, 25); add(txtTelefono);
        txtCorreo    = new JTextField(); txtCorreo.setBounds(150, 180, 200, 25); add(txtCorreo);
        txtRFC       = new JTextField(); txtRFC.setBounds(150, 220, 200, 25); txtRFC.setEditable(false); add(txtRFC);

        btnGuardar   = new JButton("Guardar"); btnGuardar.setBounds(150, 260, 100, 30); add(btnGuardar);
        btnGuardar.addActionListener(e -> actualizar());

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
    }

    public void cargarDatos(String rfc, String nombre, String apPaterno,
                            String apMaterno, String telefono, String correo) {
        txtRFC.setText(rfc);
        txtNombre.setText(nombre);
        txtApPaterno.setText(apPaterno);
        txtApMaterno.setText(apMaterno);
        txtTelefono.setText(telefono);
        txtCorreo.setText(correo);
    }

    private void actualizar() {
        String nombre     = txtNombre.getText().trim();
        String apPaterno  = txtApPaterno.getText().trim();
        String apMaterno  = txtApMaterno.getText().trim();
        String telefono   = txtTelefono.getText().trim();
        String correo     = txtCorreo.getText().trim();
        String rfc        = txtRFC.getText().trim();

        if (nombre.isEmpty() || apPaterno.isEmpty() || apMaterno.isEmpty() ||
            telefono.isEmpty() || correo.isEmpty()) {
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
            JOptionPane.showMessageDialog(this, "⚠️ El teléfono debe tener 10 dígitos.");
            return;
        }

        if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(this, "⚠️ El correo electrónico no es válido.");
            return;
        }

        DocenteCarg d = new DocenteCarg(nombre, apPaterno, apMaterno, rfc, telefono, correo);
        boolean ok = new DocenteDAO().actualizarDocente(d);

        if (ok) {
            JOptionPane.showMessageDialog(this, "✅ Docente actualizado correctamente.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "❌ Error al actualizar el docente.");
        }
    }
}
