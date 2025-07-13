package Vista;

import java.awt.CardLayout;
import javax.swing.JPanel;
import Modelo.DAO.AlumnoDAO;
import static Modelo.DAO.AlumnoDAO.consultarAlumno;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

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
        lblControl = new javax.swing.JLabel();
        lblNombreAlumno = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblProyecto = new javax.swing.JLabel();
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
                {"22161052", null}
            },
            new String [] {
                "Numero de  control", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlumnosMouseClicked(evt);
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

        lblControl.setText("Numero de  control");

        lblNombreAlumno.setText("Nombre completo");

        lblTelefono.setText("Telefono");

        lblCorreo.setText("Correo electronico");

        lblProyecto.setForeground(new java.awt.Color(0, 102, 255));
        lblProyecto.setText("Proyecto");

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
                        .addComponent(lblProyecto)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreAlumno)
                            .addComponent(lblControl))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCorreo)
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
                .addComponent(lblControl)
                .addGap(18, 18, 18)
                .addComponent(lblNombreAlumno)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(lblCorreo))
                .addGap(18, 18, 18)
                .addComponent(lblProyecto)
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


    
    private void tablaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnosMouseClicked
        try {
            consultarAlumno(tablaAlumnos);
            lblControl.setText(AlumnoDAO.alumnito[0]);
            System.out.println(AlumnoDAO.alumnito[0]);
            
            lblNombreAlumno.setText(AlumnoDAO.alumnito[1]);
            System.out.println(AlumnoDAO.alumnito[1]);
            
            lblTelefono.setText(AlumnoDAO.alumnito[2]);
            System.out.println(AlumnoDAO.alumnito[2]);
            
            lblCorreo.setText(AlumnoDAO.alumnito[3]);
            System.out.println(AlumnoDAO.alumnito[3]);
        } catch (SQLException ex) {
            Logger.getLogger(opcionAlumno2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tablaAlumnosMouseClicked
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAgregarAlumno;
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblControl;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombreAlumno;
    private javax.swing.JLabel lblProyecto;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JPanel panelAlumnos;
    private javax.swing.JTable tablaAlumnos;
    // End of variables declaration//GEN-END:variables
}

