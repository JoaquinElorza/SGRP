/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

import Utilidades.Conexion; // usa tu clase de conexión
import Utilidades.EnviarCorreoUtil;

public class Reporte extends javax.swing.JFrame {

    private opcionAlumno2 panelPadre;
    private String numeroControl;

    public Reporte(opcionAlumno2 panelPadre, String numeroControl) {
        this.panelPadre = panelPadre;
        this.numeroControl = numeroControl;

        setUndecorated(true);
        initComponents();

        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setLocationRelativeTo(null);

        ImageIcon iconoBack = new ImageIcon(getClass().getResource("/img/backbutton.png"));
        Image imagenBack = iconoBack.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

        regresar.setIcon(
                new ImageIcon(imagenBack));
        regresar.setBorderPainted(
                false);
        regresar.setContentAreaFilled(
                false);
        regresar.setFocusPainted(
                false);
        regresar.setOpaque(
                false);

        ImageIcon iconoLogo = new ImageIcon(getClass().getResource("/img/ITOlogo.png"));
        Image imagenLogo = iconoLogo.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);

        logo.setIcon(
                new ImageIcon(imagenLogo));
        logo.setBorderPainted(
                false);
        logo.setContentAreaFilled(
                false);
        logo.setFocusPainted(
                false);
        logo.setOpaque(
                false);
    }

    public static void enviarCorreoReporte(String nControl, String inicio, String r1, String r2, String r3, String fin) {
        String correo = "";

        // Buscar correo del alumno
        try (Connection conn = Conexion.getConexion()) {
            String sql = "SELECT correo FROM alumno WHERE n_control = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nControl);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                correo = rs.getString("correo");
            } else {
                JOptionPane.showMessageDialog(null, "❌ No se encontró el correo del alumno.");
                return;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "❌ Error al obtener el correo.");
            return;
        }

        // Preparar y enviar
        String asunto = "📅 Fechas de reportes de residencia";
        String cuerpo = "Hola,\n\nEstas son tus fechas:\n"
                + "Inicio: " + inicio + "\n"
                + "Reporte 1: " + r1 + "\n"
                + "Reporte 2: " + r2 + "\n"
                + "Reporte 3: " + r3 + "\n"
                + "Fin: " + fin + "\n\n"
                + "Recuerda entregar puntualmente cada uno.\n\n"
                + "Saludos,\nSistema de Gestión de Residencias Profesionales";

        try {
            EnviarCorreoUtil.enviarCorreo(correo, asunto, cuerpo);
            JOptionPane.showMessageDialog(null, "✅ Correo enviado a " + correo);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "❌ Error al enviar el correo.");
        }
    }

    public Reporte() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        btnCalcular = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        regresar = new javax.swing.JButton();
        logo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));

        regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/backbutton.png"))); // NOI18N
        regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regresarMouseClicked(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ITOlogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCalcular)
                .addGap(166, 166, 166))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCalcular)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarMouseClicked
        this.dispose();
    }//GEN-LAST:event_regresarMouseClicked

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed

        try {
            // 1. Obtener fecha seleccionada
            Date fechaSeleccionada = jCalendar1.getDate();
            if (fechaSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "⚠️ Selecciona una fecha en el calendario.");
                return;
            }

            // Convertir a LocalDate
            LocalDate inicio = fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate reporte1 = inicio.plusMonths(2);
            LocalDate reporte2 = inicio.plusMonths(4);
            LocalDate reporte3 = inicio.plusMonths(6);
            LocalDate fin = inicio.plusMonths(6);

            // 2. Obtener id_alumno desde número de control
            int idAlumno = -1;
            try (Connection conn = Conexion.getConexion()) {
                String sql = "SELECT id_alumno FROM alumno WHERE n_control = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, numeroControl);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    idAlumno = rs.getInt("id_alumno");
                } else {
                    JOptionPane.showMessageDialog(this, "❌ Alumno no encontrado.");
                    return;
                }

                // 3. Insertar fechas en tabla reporte
                sql = "INSERT INTO reporte (fk_alumno, fecha_inicio, fecha_reporte1, fecha_reporte2, fecha_reporte3, fecha_fin) VALUES (?, ?, ?, ?, ?, ?)";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, idAlumno);
                ps.setDate(2, java.sql.Date.valueOf(inicio));
                ps.setDate(3, java.sql.Date.valueOf(reporte1));
                ps.setDate(4, java.sql.Date.valueOf(reporte2));
                ps.setDate(5, java.sql.Date.valueOf(reporte3));
                ps.setDate(6, java.sql.Date.valueOf(fin));
                ps.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "✅ Fechas calculadas y guardadas correctamente.");
            this.dispose(); // Cierra la ventana

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "❌ Error al calcular o guardar fechas.");
        }

    }//GEN-LAST:event_btnCalcularActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reporte.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton logo;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}
