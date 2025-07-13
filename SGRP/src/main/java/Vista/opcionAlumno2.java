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

    tablaAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int filaSeleccionada = tablaAlumnos.getSelectedRow();
            if (filaSeleccionada >= 0) {
                String numeroControl = tablaAlumnos.getValueAt(filaSeleccionada, 0).toString();

                AlumnoDAO dao = new AlumnoDAO();
                Modelo.DAO.AlumnoCarg alumno = dao.buscarPorNumeroControl(numeroControl);

                jLabel1.setText("Número de control: " + alumno.getNumeroControl());
                jLabel2.setText("Nombre completo: " + alumno.getNombre() + " " + alumno.getApellidoPaterno() + " " + alumno.getApellidoMaterno());
                jLabel3.setText("Teléfono: " + alumno.getNumeroTelefono());
                jLabel4.setText("Correo: " + alumno.getCorreoElectronico());
                jLabel5.setText("Proyecto: " + alumno.getProyecto()); // Este atributo debes tenerlo en AlumnoCarg
            }
        }
    });
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Numero de  control", "Nombre"
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

        jButton1.setText("Editar");

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51)));

        jLabel1.setText("Numero de  control");

        jLabel2.setText("Nombre completo");

        jLabel3.setText("Telefono");

        jLabel4.setText("Correo electronico");

        jLabel5.setText("Proyecto");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Documento", "Estatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(65, 65, 65))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
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
                        .addGap(88, 88, 88)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(panelAlumnosLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    String nombreCompleto = a.getNombre() + " " + a.getApellidoPaterno() + " " + a.getApellidoMaterno();
    model.addRow(new Object[]{
        a.getNumeroControl(),
        nombreCompleto
    });
}
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbLimportar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAgregarAlumno;
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JPanel panelAlumnos;
    private javax.swing.JTable tablaAlumnos;
    // End of variables declaration//GEN-END:variables
}

