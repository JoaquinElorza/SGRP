package Vista;

import java.awt.CardLayout;
import javax.swing.JPanel;
import Modelo.DAO.AlumnoDAO;

public class opcionAlumno2 extends javax.swing.JPanel {

    CardLayout card;
    private JPanel panelContainer;
    
    public opcionAlumno2(CardLayout layout, javax.swing.JPanel container) {
    this.card = layout;
    this.panelContainer = container;
    initComponents();
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAlumnos = new javax.swing.JPanel();
        lblCerrarSesion = new javax.swing.JLabel();
        lblAtras = new javax.swing.JLabel();
        lblImportar = new javax.swing.JLabel();
        lblAgregarAlumno = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        lblCerrarSesion.setText("Cerrar sesión");

        lblAtras.setText("Atrás");
        lblAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtrasMouseClicked(evt);
            }
        });

        lblImportar.setText("Importar alumnos");

        lblAgregarAlumno.setText("Agregar un alumno");
        lblAgregarAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarAlumnoMouseClicked(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Numero de control", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaAlumnos);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jButton1.setText("Editar");

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAlumnosLayout = new javax.swing.GroupLayout(panelAlumnos);
        panelAlumnos.setLayout(panelAlumnosLayout);
        panelAlumnosLayout.setHorizontalGroup(
            panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlumnosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlumnosLayout.createSequentialGroup()
                        .addComponent(lblImportar)
                        .addGap(28, 28, 28)
                        .addComponent(lblAgregarAlumno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                        .addComponent(lblAtras)
                        .addGap(80, 80, 80)
                        .addComponent(lblCerrarSesion))
                    .addGroup(panelAlumnosLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelAlumnosLayout.setVerticalGroup(
            panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlumnosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCerrarSesion)
                    .addComponent(lblAtras)
                    .addComponent(lblAgregarAlumno)
                    .addComponent(lblImportar))
                .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlumnosLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(panelAlumnosLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        add(panelAlumnos, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void lblAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasMouseClicked
        card.show(panelContainer, "menuPrincipal");
    }//GEN-LAST:event_lblAtrasMouseClicked

    private void lblAgregarAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarAlumnoMouseClicked
       card.show(panelContainer, "Agregar alumno");
    }//GEN-LAST:event_lblAgregarAlumnoMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AlumnoDAO a = new AlumnoDAO();
        int fs = tablaAlumnos.getSelectedRow();
        String nControl = tablaAlumnos.getValueAt(0, fs).toString();
        a.eliminarAlumno(nControl);
        //actualizarTabla(tablaAlumnos);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAgregarAlumno;
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblImportar;
    private javax.swing.JPanel panelAlumnos;
    private javax.swing.JTable tablaAlumnos;
    // End of variables declaration//GEN-END:variables
}
