package Vista;

import Controlador.AlumnoContr;
import java.awt.CardLayout;
import javax.smartcardio.Card;
import javax.swing.JPanel;
import Modelo.DAO.AlumnoDAO;
import Vista.opcionAlumno2;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class AgregarAlumno extends javax.swing.JPanel {

    private opcionAlumno2 panelAlumno2;
    private CardLayout card;
    private JPanel panelContainer;

    public AgregarAlumno(CardLayout layout, JPanel container, opcionAlumno2 panelAlumno2) {
        this.card = layout;
        this.panelContainer = container;
        this.panelAlumno2 = panelAlumno2;
        initComponents();
    }

    private void limpiarCampos() {
        tf_nControl.setText("");
        tf_Nombre.setText("");
        tf_paterno.setText("");
        tf_Materno.setText("");
        tf_Correo.setText("");
        tf_Telefono.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_AgregarAlumno = new javax.swing.JPanel();
        tf_Nombre = new javax.swing.JTextField();
        tf_paterno = new javax.swing.JTextField();
        tf_Materno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_Telefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_nControl = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tf_Correo = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        pnl_AgregarAlumno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 51)));

        tf_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_NombreActionPerformed(evt);
            }
        });

        tf_Materno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_MaternoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido Paterno");

        jLabel3.setText("Apellido Materno");

        jLabel4.setText("Correo");

        tf_Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_TelefonoActionPerformed(evt);
            }
        });

        jLabel5.setText("Numero de Control");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Telefono");

        tf_Correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_CorreoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_AgregarAlumnoLayout = new javax.swing.GroupLayout(pnl_AgregarAlumno);
        pnl_AgregarAlumno.setLayout(pnl_AgregarAlumnoLayout);
        pnl_AgregarAlumnoLayout.setHorizontalGroup(
            pnl_AgregarAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_AgregarAlumnoLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(pnl_AgregarAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_AgregarAlumnoLayout.createSequentialGroup()
                        .addGroup(pnl_AgregarAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(29, 29, 29)
                        .addGroup(pnl_AgregarAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_Nombre)
                            .addComponent(tf_paterno)
                            .addComponent(tf_Materno)
                            .addComponent(tf_Telefono)
                            .addComponent(tf_nControl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_Correo, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(pnl_AgregarAlumnoLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jButton1)))
                .addGap(22, 22, 22))
        );
        pnl_AgregarAlumnoLayout.setVerticalGroup(
            pnl_AgregarAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_AgregarAlumnoLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(pnl_AgregarAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_nControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnl_AgregarAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_AgregarAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_paterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_AgregarAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Materno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_AgregarAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(13, 13, 13)
                .addGroup(pnl_AgregarAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
        );

        add(pnl_AgregarAlumno, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_TelefonoActionPerformed
    private boolean validarCampos() {
        String numeroControl = tf_nControl.getText().trim();
        String nombre = tf_Nombre.getText().trim();
        String apellidoP = tf_paterno.getText().trim();
        String apellidoM = tf_Materno.getText().trim();
        String correo = tf_Correo.getText().trim();
        String telefono = tf_Telefono.getText().trim();

        if (numeroControl.isEmpty() || nombre.isEmpty() || apellidoP.isEmpty() || apellidoM.isEmpty() ||
            correo.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "⚠️ Todos los campos son obligatorios.");
            return false;
        }

        // Teléfono: exactamente 10 dígitos numéricos
        if (!telefono.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "⚠️ El número de teléfono debe contener exactamente 10 dígitos.");
            return false;
        }

        // Correo: formato válido
        String correoRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        if (!Pattern.matches(correoRegex, correo)) {
            JOptionPane.showMessageDialog(this, "⚠️ Ingresa un correo electrónico válido.");
            return false;
        }

        return true;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if (!validarCampos()) return;

    String numeroControl = tf_nControl.getText().trim();
    String nombre        = tf_Nombre.getText().trim();
    String apellidoP     = tf_paterno.getText().trim();
    String apellidoM     = tf_Materno.getText().trim();
    String correo        = tf_Correo.getText().trim();
    String telefono      = tf_Telefono.getText().trim();
    String proyecto      = "Sin asignar";

    // 🧠 Validaciones adicionales
    if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") ||
        !apellidoP.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") ||
        !apellidoM.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
        JOptionPane.showMessageDialog(this,
            "⚠️ Nombre y apellidos solo deben contener letras y espacios.");
        return;
    }

    if (!telefono.matches("\\d{10}")) {
        JOptionPane.showMessageDialog(this,
            "⚠️ El número de teléfono debe contener solo 10 dígitos.");
        return;
    }

    AlumnoContr controlador = new AlumnoContr();
    boolean exito = controlador.agregarAlumnoManual(nombre, apellidoP, apellidoM,
                                                    numeroControl, correo, telefono);

    if (exito) {
        JOptionPane.showMessageDialog(this, "✅ Alumno agregado correctamente.");
        panelAlumno2.actualizarTabla();
        limpiarCampos();
        card.show(panelContainer, "panelAlumnos");
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_NombreActionPerformed

    private void tf_CorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_CorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_CorreoActionPerformed

    private void tf_MaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_MaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_MaternoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel pnl_AgregarAlumno;
    private javax.swing.JTextField tf_Correo;
    private javax.swing.JTextField tf_Materno;
    private javax.swing.JTextField tf_Nombre;
    private javax.swing.JTextField tf_Telefono;
    private javax.swing.JTextField tf_nControl;
    private javax.swing.JTextField tf_paterno;
    // End of variables declaration//GEN-END:variables
}
