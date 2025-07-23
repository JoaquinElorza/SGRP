package Vista;

import Controlador.AcomodarImagen;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import Vista.OpcionDocentes;
import Vista.vistaProyectos;


public class MenuPrincipal extends javax.swing.JFrame {

    CardLayout card;
    private final AcomodarImagen acomodarImagen = new AcomodarImagen();

    public MenuPrincipal() {
        initComponents();
        card = (CardLayout) panelCambiante.getLayout();
        //this.setPreferredSize(new Dimension(626, 468));
        //setSize(626,470);
        
        vistaProyectos proyectos = new vistaProyectos(card, panelCambiante);
        opcionAlumno2 panelAlumnos = new opcionAlumno2(card, panelCambiante);
        AgregarAlumno agregarAlumno = new AgregarAlumno(card, panelCambiante, panelAlumnos);
        agregarProyecto panelAgregar = new agregarProyecto(card, panelCambiante);

        
        panelCambiante.add(panelAgregar, "panelAgregarProyecto");
        panelCambiante.add(panelPrincipal, "menu principal");
        panelCambiante.add(panelAlumnos, "panelAlumnos");
        panelCambiante.add(agregarAlumno, "Agregar alumno");
        panelCambiante.add(proyectos, "panelProyectos");

        //IMAGEN DE LOGO
        acomodarImagen.configurarPanelConImagen("/img/ITOlogo.png", jPanel2);
        jPanel2.setOpaque(false);
        jPanel2.setBorder(null);
        jPanel2.setBackground(new Color(0, 0, 0, 0));
        this.setVisible(true);

        //IMAGEN OPCION ALUMNOS
        acomodarImagen.configurarPanelConImagen("/img/user.png", panelOpAlumno);
        panelOpAlumno.setOpaque(false);
        panelOpAlumno.setBorder(null);
        panelOpAlumno.setBackground(new Color(0, 0, 0, 0));
        this.setVisible(true);

        //imagen proyectos 
        acomodarImagen.configurarPanelConImagen("/img/proyectos.png", jPanelProyectos);
        jPanelProyectos.setOpaque(false);
        jPanelProyectos.setBorder(null);
        jPanelProyectos.setBackground(new Color(0, 0, 0, 0));
        this.setVisible(true);
        //Imagen Docentes
        acomodarImagen.configurarPanelConImagen("/img/docentes.png", jPanelDocentes);
        jPanelDocentes.setOpaque(false);
        jPanelDocentes.setBorder(null);
        jPanelDocentes.setBackground(new Color(0, 0, 0, 0));
        this.setVisible(true);
        //Imagen Empresas
        acomodarImagen.configurarPanelConImagen("/img/empresas.png", jPanelEmpresas);
        jPanelEmpresas.setOpaque(false);
        jPanelEmpresas.setBorder(null);
        jPanelEmpresas.setBackground(new Color(0, 0, 0, 0));
        this.setVisible(true);

        //Imagen LogOut
        acomodarImagen.configurarPanelConImagen("/img/logout.png", JPanelLogOut);
        JPanelLogOut.setOpaque(false);
        JPanelLogOut.setBorder(null);
        JPanelLogOut.setBackground(new Color(0, 0, 0, 0));
        this.setVisible(true);
        
        card.show(panelCambiante, "menu principal");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCambiante = new javax.swing.JPanel();
        panelPrincipal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JPanelLogOut = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelProyectos = new javax.swing.JPanel();
        jPanelDocentes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelOpAlumno = new javax.swing.JPanel();
        jPanelEmpresas = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelCambiante.setLayout(new java.awt.CardLayout());

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Cerrar sesion");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, 20));

        JPanelLogOut.setBackground(new java.awt.Color(255, 255, 255));
        JPanelLogOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPanelLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPanelLogOutMouseClicked(evt);
            }
        });
        JPanelLogOut.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(JPanelLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 30, 30));

        jLabel1.setText("Alumno");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jPanelProyectos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProyectos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelProyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelProyectosMouseClicked(evt);
            }
        });
        jPanelProyectos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelDocentes.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDocentes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelDocentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelDocentesMouseClicked(evt);
            }
        });
        jPanelDocentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Proyectos");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setText("Docentes");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setText("Empresas");

        panelOpAlumno.setBackground(new java.awt.Color(255, 255, 255));
        panelOpAlumno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelOpAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelOpAlumnoMouseClicked(evt);
            }
        });
        panelOpAlumno.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelEmpresas.setBackground(new java.awt.Color(255, 255, 255));
        jPanelEmpresas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelEmpresasMouseClicked(evt);
            }
        });
        jPanelEmpresas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelEmpresas.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 110, 100));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jPanelEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanelProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanelDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel5)
                .addGap(104, 104, 104)
                .addComponent(jLabel3)
                .addGap(88, 88, 88)
                .addComponent(jLabel4))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(panelOpAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel1))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addGap(12, 12, 12)
                .addComponent(panelOpAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1))
        );

        panelCambiante.add(panelPrincipal, "card2");

        getContentPane().add(panelCambiante, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        card.show(panelCambiante, "panelAlumnos");
        this.pack();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        new Vista.Login1().setVisible(true); // Abre el login
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void panelOpAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOpAlumnoMouseClicked
        // TODO add your handling code here:
        card.show(panelCambiante, "panelAlumnos");
        this.pack();
    }//GEN-LAST:event_panelOpAlumnoMouseClicked

    private void JPanelLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPanelLogOutMouseClicked
        // TODO add your handling code here:
        new Vista.Login1().setVisible(true); // Abre el login
        dispose();

    }//GEN-LAST:event_JPanelLogOutMouseClicked

    private void jPanelEmpresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelEmpresasMouseClicked
        this.setVisible(false); // ocultar el menú principal temporalmente
        Vista.Empresa.Empresa ventanaEmpresa = new Vista.Empresa.Empresa(this);
        ventanaEmpresa.setVisible(true);
        ventanaEmpresa.setLocationRelativeTo(this);
    }//GEN-LAST:event_jPanelEmpresasMouseClicked

    private void jPanelDocentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelDocentesMouseClicked
       OpcionDocentes opc = new OpcionDocentes();
        opc.setVisible(true);
        opc.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_jPanelDocentesMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jPanelProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProyectosMouseClicked
        // TODO add your handling code here:
         card.show(panelCambiante, "panelProyectos");
          
    }//GEN-LAST:event_jPanelProyectosMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
         card.show(panelCambiante, "panelProyectos");
         
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelLogOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelDocentes;
    private javax.swing.JPanel jPanelEmpresas;
    private javax.swing.JPanel jPanelProyectos;
    private javax.swing.JPanel panelCambiante;
    private javax.swing.JPanel panelOpAlumno;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
