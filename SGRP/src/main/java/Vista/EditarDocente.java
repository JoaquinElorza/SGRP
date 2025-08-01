package Vista;

import Modelo.DAO.DocenteCarg;
import Modelo.DAO.DocenteDAO;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class EditarDocente extends JFrame {

    private JTextField txtNombre, txtApPaterno, txtApMaterno, txtTelefono, txtCorreo, txtRFC;
    private JButton btnGuardar, btnCancelar;
    private String rfcOriginal;
    private OpcionDocentes padre;

    public EditarDocente(OpcionDocentes padre) {
        this.padre = padre;
        setUndecorated(true); // Solución al error de frame decorado
        setTitle("Editar Docente");
        setSize(435, 350);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setLocationRelativeTo(null);
        setLayout(null);

        Font fuente = new Font("Dialog", Font.PLAIN, 12);

       
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new java.awt.Color(255, 102, 0));
        headerPanel.setBounds(0, 0, getWidth(), 40);
        headerPanel.setLayout(null);
        add(headerPanel);

        // Campos de texto
        txtNombre    = new JTextField(); txtNombre.setBounds(130, 60, 250, 30); txtNombre.setFont(fuente); add(txtNombre);
        txtApPaterno = new JTextField(); txtApPaterno.setBounds(130, 100, 250, 30); txtApPaterno.setFont(fuente); add(txtApPaterno);
        txtApMaterno = new JTextField(); txtApMaterno.setBounds(130, 140, 250, 30); txtApMaterno.setFont(fuente); add(txtApMaterno);
        txtTelefono  = new JTextField(); txtTelefono.setBounds(130, 180, 250, 30); txtTelefono.setFont(fuente); add(txtTelefono);
        txtCorreo    = new JTextField(); txtCorreo.setBounds(130, 220, 250, 30); txtCorreo.setFont(fuente); add(txtCorreo);
        txtRFC       = new JTextField(); txtRFC.setBounds(130, 260, 250, 30); txtRFC.setFont(fuente); add(txtRFC);

        // Botones
        btnGuardar  = new JButton("Guardar");  btnGuardar.setBounds(160, 310, 100, 30); add(btnGuardar);
        btnCancelar = new JButton("Cancelar"); btnCancelar.setBounds(270, 310, 100, 30); add(btnCancelar);

        btnGuardar.addActionListener(e -> actualizar());
        btnCancelar.addActionListener(e -> dispose()); // Cierra la ventana

        // Etiquetas
        JLabel[] labels = {
            new JLabel("Nombre"), new JLabel("Apellido Paterno"), new JLabel("Apellido Materno"),
            new JLabel("Teléfono"), new JLabel("Correo electrónico"), new JLabel("RFC")
        };

        int y = 60;
        for (JLabel label : labels) {
            label.setBounds(20, y, 130, 25);
            label.setFont(fuente);
            add(label);
            y += 40;
        }
    }

    public void cargarDatos(String rfc, String nombre, String apPaterno,
                            String apMaterno, String telefono, String correo) {
        rfcOriginal = rfc;
        txtRFC.setText(rfc);
        txtNombre.setText(nombre);
        txtApPaterno.setText(apPaterno);
        txtApMaterno.setText(apMaterno);
        txtTelefono.setText(telefono);
        txtCorreo.setText(correo);
    }

    public void actualizar() {
        String nombre   = txtNombre.getText().trim();
        String apPaterno = txtApPaterno.getText().trim();
        String apMaterno = txtApMaterno.getText().trim();
        String telefono  = txtTelefono.getText().trim();
        String correo    = txtCorreo.getText().trim();
        String rfc       = txtRFC.getText().trim().toUpperCase();

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
            JOptionPane.showMessageDialog(this, "⚠️ El teléfono debe tener 10 dígitos.");
            return;
        }

        if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(this, "⚠️ El correo electrónico no es válido.");
            return;
        }

        if (!rfc.matches("^[A-Z&Ñ]{3,4}[0-9]{6}[A-Z0-9]{3}$")) {
            JOptionPane.showMessageDialog(this, "⚠️ RFC inválido. Verifica formato y estructura.");
            return;
        }

        DocenteDAO dao = new DocenteDAO();

        if (!rfc.equals(rfcOriginal) && dao.existeRFC(rfc)) {
            JOptionPane.showMessageDialog(this, "⚠️ Ese RFC ya está registrado, contacte al administrador.");
            return;
        }

        DocenteCarg d = new DocenteCarg(nombre, apPaterno, apMaterno, rfc, telefono, correo);
        boolean ok = dao.actualizarDocente(d, rfcOriginal);

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