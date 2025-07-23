package Vista;

import Modelo.DAO.DocenteCarg;
import Modelo.DAO.DocenteDAO;
import java.awt.Font;
import javax.swing.*;

public class EditarDocente extends JFrame {

    private JTextField txtNombre, txtApPaterno, txtApMaterno, txtTelefono, txtCorreo, txtControl;
    private JButton btnGuardar;
    private String numeroControlOriginal;

    private OpcionDocentes padre;

    public EditarDocente(OpcionDocentes padre) {
        this.padre = padre;
        setTitle("Editar Docente");
        setSize(435, 350); // ventana más ancha
        setLocationRelativeTo(null);
        setLayout(null);

        Font fuente = new Font("Dialog", Font.PLAIN, 12);

        txtNombre    = new JTextField(); txtNombre.setBounds(130, 20, 250, 30); txtNombre.setFont(fuente); add(txtNombre);
        txtApPaterno = new JTextField(); txtApPaterno.setBounds(130, 60, 250, 30); txtApPaterno.setFont(fuente); add(txtApPaterno);
        txtApMaterno = new JTextField(); txtApMaterno.setBounds(130, 100, 250, 30); txtApMaterno.setFont(fuente); add(txtApMaterno);
        txtTelefono  = new JTextField(); txtTelefono.setBounds(130, 140, 250, 30); txtTelefono.setFont(fuente); add(txtTelefono);
        txtCorreo    = new JTextField(); txtCorreo.setBounds(130, 180, 250, 30); txtCorreo.setFont(fuente); add(txtCorreo);
        txtControl   = new JTextField(); txtControl.setBounds(130, 220, 250, 30); txtControl.setFont(fuente); add(txtControl);

        btnGuardar   = new JButton("Guardar"); btnGuardar.setBounds(160, 270, 100, 30); add(btnGuardar);
        btnGuardar.addActionListener(e -> actualizar());

        JLabel[] labels = {
            new JLabel("Nombre"), new JLabel("Apellido Paterno"), new JLabel("Apellido Materno"),
            new JLabel("Teléfono"), new JLabel("Correo electrónico"), new JLabel("Número de control")
        };

        int y = 20;
        for (JLabel label : labels) {
            label.setBounds(20, y, 130, 25);
            label.setFont(fuente);
            add(label);
            y += 40;
        }
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

    public void actualizar() {
        String nombre        = txtNombre.getText().trim();
        String apPaterno     = txtApPaterno.getText().trim();
        String apMaterno     = txtApMaterno.getText().trim();
        String telefono      = txtTelefono.getText().trim();
        String correo        = txtCorreo.getText().trim();
        String numeroControl = txtControl.getText().trim();

        if (nombre.isEmpty() || apPaterno.isEmpty() || apMaterno.isEmpty() ||
            telefono.isEmpty() || correo.isEmpty() || numeroControl.isEmpty()) {
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

        DocenteDAO dao = new DocenteDAO();

        if (!numeroControl.equals(numeroControlOriginal) && dao.existeNumeroControl(numeroControl)) {
            JOptionPane.showMessageDialog(this, "⚠️ Ese número de control ya existe.");
            return;
        }

        DocenteCarg d = new DocenteCarg(nombre, apPaterno, apMaterno, numeroControl, telefono, correo);
        boolean ok = dao.actualizarDocente(d, numeroControlOriginal);

        if (ok) {
            JOptionPane.showMessageDialog(this, "✅ Docente actualizado correctamente.");
            if (padre != null) {
                padre.actualizarTablaDocentes();
                padre.actualizarPanelLateral(d);
                System.out.println("✔ Se actualizó tabla desde EditarDocente");
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "❌ Error al actualizar el docente.");
        }
    }
}
