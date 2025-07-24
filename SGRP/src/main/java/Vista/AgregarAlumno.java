package Vista;

import Controlador.AlumnoContr;
import java.awt.CardLayout;
import javax.smartcardio.Card;
import javax.swing.JPanel;
import Modelo.DAO.AlumnoDAO;
import Vista.opcionAlumno2;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import Controlador.AcomodarImagen;
import Controlador.Placeholder;
import java.awt.Color;
import java.awt.Dimension;


public class AgregarAlumno extends javax.swing.JPanel {

    private opcionAlumno2 panelAlumno2;
    private CardLayout card;
    private JPanel panelContainer;
    private final AcomodarImagen acomodarImagen = new AcomodarImagen();

    public AgregarAlumno(CardLayout layout, JPanel container, opcionAlumno2 panelAlumno2) {
        this.setPreferredSize(new Dimension(325, 652));
        this.card = layout;
        this.panelContainer = container;
        this.panelAlumno2 = panelAlumno2;
        initComponents();
             //Imagenes Back y Logo
         acomodarImagen.configurarPanelConImagen("/img/ITOlogo.png", JPanelLOGO2);  
         JPanelLOGO2.setOpaque(false);
         JPanelLOGO2.setBorder(null);
         JPanelLOGO2.setBackground(new Color(0,0,0,0));
         this.setVisible(true);
        
         acomodarImagen.configurarPanelConImagen("/img/backbutton.png", JPanelBack2);  
         JPanelBack2.setOpaque(false);
         JPanelBack2.setBorder(null);
         JPanelBack2.setBackground(new Color(0,0,0,0));
         this.setVisible(true);
        
         //PlaceHolder
           Placeholder.agregarPlaceholder(tf_nControl, "Numero de Control");
           Placeholder.agregarPlaceholder(tf_Nombre, "Nombre/s");
           Placeholder.agregarPlaceholder(tf_paterno, "Apellido Paterno");
           Placeholder.agregarPlaceholder(tf_Materno, "Apellido Materno");
           Placeholder.agregarPlaceholder(tf_Correo, "Correo Electronico");
           Placeholder.agregarPlaceholder(tf_Telefono, "Numero Telefonico");
        
        
        
        
        
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
        jButton1 = new javax.swing.JButton();
        JPanelLOGO2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tf_nControl = new javax.swing.JTextField();
        tf_Nombre = new javax.swing.JTextField();
        tf_paterno = new javax.swing.JTextField();
        tf_Materno = new javax.swing.JTextField();
        tf_Correo = new javax.swing.JTextField();
        tf_Telefono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JPanelBack2 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        pnl_AgregarAlumno.setBackground(new java.awt.Color(255, 255, 255));
        pnl_AgregarAlumno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Liberation Mono", 2, 16)); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JPanelLOGO2.setBackground(new java.awt.Color(255, 255, 255));
        JPanelLOGO2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPanelLOGO2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        tf_Correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_CorreoActionPerformed(evt);
            }
        });

        tf_Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_TelefonoActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero de Control:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido Paterno");

        jLabel4.setText("Apellido Materno");

        jLabel5.setText("Correo Electronico:");

        jLabel6.setText("Numero Telefonico ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tf_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_Materno, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_paterno, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_nControl, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_nControl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(tf_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addComponent(tf_paterno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addComponent(tf_Materno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addComponent(tf_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(2, 2, 2)
                .addComponent(tf_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JPanelBack2.setBackground(new java.awt.Color(255, 255, 255));
        JPanelBack2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPanelBack2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPanelBack2MouseClicked(evt);
            }
        });
        JPanelBack2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout pnl_AgregarAlumnoLayout = new javax.swing.GroupLayout(pnl_AgregarAlumno);
        pnl_AgregarAlumno.setLayout(pnl_AgregarAlumnoLayout);
        pnl_AgregarAlumnoLayout.setHorizontalGroup(
            pnl_AgregarAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_AgregarAlumnoLayout.createSequentialGroup()
                .addGroup(pnl_AgregarAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_AgregarAlumnoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JPanelBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(JPanelLOGO2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_AgregarAlumnoLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_AgregarAlumnoLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jButton1)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        pnl_AgregarAlumnoLayout.setVerticalGroup(
            pnl_AgregarAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_AgregarAlumnoLayout.createSequentialGroup()
                .addGroup(pnl_AgregarAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPanelLOGO2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPanelBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        add(pnl_AgregarAlumno, java.awt.BorderLayout.PAGE_START);
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

    private void JPanelBack2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPanelBack2MouseClicked
        // TODO add your handling code here:
        card.show(panelContainer, "panelAlumnos"); 
        ajustarVentana();
        
    }//GEN-LAST:event_JPanelBack2MouseClicked
    
    private void ajustarVentana() {
    java.awt.Window ventana = javax.swing.SwingUtilities.getWindowAncestor(this);
    if (ventana instanceof javax.swing.JFrame) {
        ((javax.swing.JFrame) ventana).pack();
        ventana.setLocationRelativeTo(null);
    }
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelBack2;
    private javax.swing.JPanel JPanelLOGO2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnl_AgregarAlumno;
    private javax.swing.JTextField tf_Correo;
    private javax.swing.JTextField tf_Materno;
    private javax.swing.JTextField tf_Nombre;
    private javax.swing.JTextField tf_Telefono;
    private javax.swing.JTextField tf_nControl;
    private javax.swing.JTextField tf_paterno;
    // End of variables declaration//GEN-END:variables
}
