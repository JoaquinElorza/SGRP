package Vista;

import java.awt.CardLayout;
import javax.swing.JPanel;
import Modelo.DAO.AlumnoDAO;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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
        LbLimportar = new javax.swing.JLabel();
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

        LbLimportar.setText("Importar alumnos");
        LbLimportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbLimportarMouseClicked(evt);
            }
        });

        lblAgregarAlumno.setText("Agregar un alumno");
        lblAgregarAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarAlumnoMouseClicked(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane2.setToolTipText("");
        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setName(""); // NOI18N

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Numero de control", "Correo electronico", "Numero de telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
                        .addComponent(LbLimportar)
                        .addGap(28, 28, 28)
                        .addComponent(lblAgregarAlumno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 480, Short.MAX_VALUE)
                        .addComponent(lblAtras)
                        .addGap(80, 80, 80)
                        .addComponent(lblCerrarSesion))
                    .addGroup(panelAlumnosLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(LbLimportar))
                .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlumnosLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(panelAlumnosLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
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

    private void LbLimportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbLimportarMouseClicked
    JFileChooser selector = new JFileChooser();
    int resultado = selector.showOpenDialog(this);

    if (resultado == JFileChooser.APPROVE_OPTION) {
        File archivo = selector.getSelectedFile();
        Vista.VentanaCargaProgreso panel = new Vista.VentanaCargaProgreso(null, archivo, this);
        panel.setVisible(true);
    }
    }//GEN-LAST:event_LbLimportarMouseClicked
    void actualizarTablaAlumnos() {
    AlumnoDAO dao = new AlumnoDAO();
    java.util.List<Modelo.DAO.AlumnoCarg> lista = dao.obtenerTodosLosAlumnos();

    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tablaAlumnos.getModel();
    model.setRowCount(0); // Limpiar tabla

    for (Modelo.DAO.AlumnoCarg a : lista) {
        model.addRow(new Object[]{
            a.getId(),
            a.getNombre(),
            a.getApellidoPaterno(),
            a.getApellidoMaterno(),
            a.getNumeroControl(),
            a.getCorreoElectronico(),
            a.getNumeroTelefono()
        });
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbLimportar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAgregarAlumno;
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JPanel panelAlumnos;
    private javax.swing.JTable tablaAlumnos;
    // End of variables declaration//GEN-END:variables
}

