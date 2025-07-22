package Vista;

import Controlador.AcomodarImagen;
import java.awt.CardLayout;
import javax.swing.JPanel;
import Modelo.DAO.AlumnoDAO;
import java.io.File;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import Controlador.AlumnoContr;
import Controlador.DocumentosAlumno;
import Modelo.DAO.AlumnoCarg;
import Modelo.DAO.CarpetaOculta;
import Modelo.DAO.DocumentoDao;
import Utilidades.Conexion;
import java.awt.Color;
import java.awt.Dimension;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class opcionAlumno2 extends javax.swing.JPanel {
    
    private final AcomodarImagen acomodarImagen = new AcomodarImagen();

    CardLayout card;
    private JPanel panelContainer;
    private EditarAlumno editar;
    
    
    public opcionAlumno2() {}

     public opcionAlumno2(CardLayout layout, JPanel container) {
        this.card = layout;
        this.panelContainer = container;
        this.setPreferredSize(new Dimension(905, 539));
        initComponents();
        actualizarTablaAlumnos(tablaAlumnos);

        if(comboSoli.getSelectedIndex()!=0){
            lblSolicitud.setForeground(Color.blue);
        }
        
        
        //Imagen Logo
        acomodarImagen.configurarPanelConImagen("/img/ITOlogo.png", JPanelLOGO);  
         JPanelLOGO.setOpaque(false);
         JPanelLOGO.setBorder(null);
         JPanelLOGO.setBackground(new Color(0,0,0,0));
         this.setVisible(true);
         
         //Imagen Back
         
         acomodarImagen.configurarPanelConImagen("/img/backbutton.png", JPanelBack);  
         JPanelBack.setOpaque(false);
         JPanelBack.setBorder(null);
         JPanelBack.setBackground(new Color(0,0,0,0));
         this.setVisible(true);
         
         //Imagen Import
         acomodarImagen.configurarPanelConImagen("/img/import.png", JPanelImport1);  
         JPanelImport1.setOpaque(false);
         JPanelImport1.setBorder(null);
         JPanelImport1.setBackground(new Color(0,0,0,0));
         this.setVisible(true);
    } 
   
     

     
    public void actualizarTabla() {
        AlumnoContr controlador = new AlumnoContr();
        controlador.actualizarTablaAlumnos(tablaAlumnos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAlumnos = new javax.swing.JPanel();
        LbLimportar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblControl = new javax.swing.JLabel();
        lblNombreAlumno = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblProyecto = new javax.swing.JLabel();
        btnSubirDocumento = new javax.swing.JButton();
        btnEiminarDocumento = new javax.swing.JButton();
        lblSolicitud = new javax.swing.JLabel();
        comboSoli = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        JPanelLOGO = new javax.swing.JPanel();
        JPanelBack = new javax.swing.JPanel();
        JPanelImport = new javax.swing.JPanel();
        JPanelImport1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        panelAlumnos.setBackground(new java.awt.Color(255, 255, 255));
        panelAlumnos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelAlumnos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LbLimportar.setText("Importar archvio .csv");
        LbLimportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbLimportarMouseClicked(evt);
            }
        });
        panelAlumnos.add(LbLimportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 125, -1, -1));

        jScrollPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        jScrollPane2.setToolTipText("");
        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setName(""); // NOI18N
        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        panelAlumnos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 167, 475, 336));

        btnEditar.setBackground(new java.awt.Color(51, 153, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        panelAlumnos.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 515, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        lblControl.setText("Numero de  control");

        lblNombreAlumno.setText("Nombre completo");

        lblTelefono.setText("Telefono");

        lblCorreo.setText("Correo electronico");

        lblProyecto.setForeground(new java.awt.Color(0, 102, 255));
        lblProyecto.setText("Proyecto");

        btnSubirDocumento.setText("Subir");
        btnSubirDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirDocumentoActionPerformed(evt);
            }
        });

        btnEiminarDocumento.setText("Eliminar");
        btnEiminarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEiminarDocumentoActionPerformed(evt);
            }
        });

        lblSolicitud.setText("Solicitud de residencia");
        lblSolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSolicitudMouseClicked(evt);
            }
        });

        comboSoli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No recibida", "Recibida", "Enviada a firmar", "Firmada y sellada", "Entregada al alumno" }));
        comboSoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSoliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreAlumno)
                            .addComponent(lblControl)
                            .addComponent(lblTelefono)
                            .addComponent(lblCorreo)
                            .addComponent(lblProyecto)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblSolicitud)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSubirDocumento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboSoli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEiminarDocumento)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblControl)
                .addGap(18, 18, 18)
                .addComponent(lblNombreAlumno)
                .addGap(18, 18, 18)
                .addComponent(lblTelefono)
                .addGap(18, 18, 18)
                .addComponent(lblProyecto)
                .addGap(20, 20, 20)
                .addComponent(lblCorreo)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSolicitud)
                    .addComponent(comboSoli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEiminarDocumento)
                    .addComponent(btnSubirDocumento))
                .addContainerGap(230, Short.MAX_VALUE))
        );

        panelAlumnos.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 167, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JPanelLOGO.setBackground(new java.awt.Color(255, 255, 255));
        JPanelLOGO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPanelLOGO.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPanelBack.setBackground(new java.awt.Color(255, 255, 255));
        JPanelBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPanelBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPanelBackMouseClicked(evt);
            }
        });
        JPanelBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(JPanelBack, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JPanelLOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JPanelLOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(JPanelBack, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelAlumnos.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 904, -1));

        JPanelImport.setBackground(new java.awt.Color(255, 255, 255));
        JPanelImport.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPanelImport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelAlumnos.add(JPanelImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 426, -1, -1));

        JPanelImport1.setBackground(new java.awt.Color(255, 255, 255));
        JPanelImport1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPanelImport1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPanelImport1MouseClicked(evt);
            }
        });
        JPanelImport1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelAlumnos.add(JPanelImport1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 35, 35));

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelAlumnos.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 515, -1, -1));

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelAlumnos.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 515, 91, -1));

        add(panelAlumnos, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void lblAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasMouseClicked
        card.show(panelContainer, "menu principal");
    }//GEN-LAST:event_lblAtrasMouseClicked

    private void lblAgregarAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarAlumnoMouseClicked
        card.show(panelContainer, "Agregar alumno");
    }//GEN-LAST:event_lblAgregarAlumnoMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tablaAlumnos.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "⚠️ Selecciona un alumno para eliminar.");
        return;
    }

    String nControl = tablaAlumnos.getValueAt(fila, 0).toString();
    String nombreCompleto = lblNombreAlumno.getText();

    int confirmacion = JOptionPane.showConfirmDialog(this,
        "¿Deseas eliminar al alumno " + nombreCompleto +
        " con número de control " + nControl + "?",
        "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

    if (confirmacion == JOptionPane.YES_OPTION) {
        try {
            Connection conn = Conexion.getConexion();
            String sql = "SELECT fk_persona FROM alumno WHERE n_control = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nControl);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int idPersona = rs.getInt("fk_persona");
                AlumnoDAO dao = new AlumnoDAO();
                boolean eliminado = dao.eliminarAlumno(idPersona);

                if (eliminado) {
                    JOptionPane.showMessageDialog(this, "✅ Alumno marcado como eliminado.");
                    actualizarTablaAlumnos(tablaAlumnos);
                    limpiarPanelAlumno();
                } else {
                    JOptionPane.showMessageDialog(this, "❌ No se pudo eliminar al alumno.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "⚠️ No se encontró el alumno.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "❌ Error al intentar eliminar.");
        }
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void LbLimportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbLimportarMouseClicked
        JFileChooser selector = new JFileChooser();
    int resultado = selector.showOpenDialog(this);
    if (resultado == JFileChooser.APPROVE_OPTION) {
    File archivo = selector.getSelectedFile();
    VentanaCargaProgreso progreso = new VentanaCargaProgreso(null, archivo, this);
    progreso.setVisible(true); 
    }
    }//GEN-LAST:event_LbLimportarMouseClicked


    private void tablaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnosMouseClicked
      int fila = tablaAlumnos.getSelectedRow();
    if (fila == -1) return;

    String nControl = tablaAlumnos.getValueAt(fila, 0).toString();
    try {
        AlumnoCarg alumnoTabla = new AlumnoDAO().consultarAlumno(nControl);

        lblControl.setText(alumnoTabla.getNumeroControl());
        lblNombreAlumno.setText(alumnoTabla.getNombre() + " " + alumnoTabla.getApellidoPaterno() + " " + alumnoTabla.getApellidoMaterno());
        lblTelefono.setText(alumnoTabla.getNumeroTelefono());
        lblCorreo.setText(alumnoTabla.getCorreoElectronico());
        
        
        comboSoli.setSelectedIndex(DocumentoDao.comboSolicitud(lblControl.getText()));
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }//GEN-LAST:event_tablaAlumnosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tablaAlumnos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "⚠️ Selecciona un alumno para editar.");
            return;
        }

        String nControl = tablaAlumnos.getValueAt(fila, 0).toString();
        try {
            AlumnoDAO dao = new AlumnoDAO();
AlumnoCarg datos = dao.consultarAlumno(nControl);
editar = new EditarAlumno();
editar.cargarDatos(datos.getNumeroControl(), datos.getNombre(), datos.getApellidoPaterno(),
                   datos.getApellidoMaterno(), datos.getNumeroTelefono(), datos.getCorreoElectronico());


            editar.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    actualizarTablaAlumnos(tablaAlumnos);
                }
            });

            editar.setVisible(true);
            editar.setLocationRelativeTo(null);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "❌ No se pudo cargar el alumno.");
        }
    
    }//GEN-LAST:event_btnEditarActionPerformed


    private void lblactualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblactualizarMouseClicked
         actualizarTablaAlumnos(tablaAlumnos);
    }//GEN-LAST:event_lblactualizarMouseClicked

    private void JPanelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPanelBackMouseClicked
        // TODO add your handling code here:
         card.show(panelContainer, "menu principal");
         ajustarVentana(); 
          
    }//GEN-LAST:event_JPanelBackMouseClicked

    private void JPanelImport1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPanelImport1MouseClicked
        // TODO add your handling code here:
        
            JFileChooser selector = new JFileChooser();
    int resultado = selector.showOpenDialog(this);
    if (resultado == JFileChooser.APPROVE_OPTION) {
    File archivo = selector.getSelectedFile();
    VentanaCargaProgreso progreso = new VentanaCargaProgreso(null, archivo, this);
    progreso.setVisible(true); 
    }
    }//GEN-LAST:event_JPanelImport1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        card.show(panelContainer, "Agregar alumno");
        ajustarVentana(); 
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
               int fs = tablaAlumnos.getSelectedRow();

    // Verifica si se seleccionó una fila
    if (fs == -1) {
        JOptionPane.showMessageDialog(this, "⚠️ Debes seleccionar un alumno.");
        return;
    }

    // Asegúrate de que el índice de columna corresponde al "Número de Control"
    // Ajusta el número de columna según tu tabla: aquí se asume que está en la columna 4
    String nControl;
    try {
        nControl = tablaAlumnos.getValueAt(fs, 0).toString();
    } catch (ArrayIndexOutOfBoundsException e) {
        JOptionPane.showMessageDialog(this, "❌ Error: La columna del número de control no existe.");
        return;
    }

    // Confirmar eliminación
    int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Estás seguro de que deseas eliminar al alumno con número de control " + nControl + "?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION);

    if (confirmacion != JOptionPane.YES_OPTION) return;

    // Obtener ID persona y eliminar
    AlumnoDAO dao = new AlumnoDAO();
    int idPersona = dao.obtenerIdPersonaPorNumeroControl(nControl);

    if (idPersona != -1) {
        boolean eliminado = dao.eliminarAlumno(idPersona);
        if (eliminado) {
            JOptionPane.showMessageDialog(this, "✅ Alumno eliminado correctamente.");
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "❌ No se pudo eliminar al alumno.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "❌ No se encontró el alumno en la base de datos.");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSubirDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirDocumentoActionPerformed
        if(tablaAlumnos.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Selecciona un alumno primero.");
        }else{
            DocumentosAlumno.subirDocumentoAlumno(lblControl.getText(), "Solicitud de residencia", this);
            try {
                DocumentoDao.crearSoli(lblControl.getText());
            } catch (SQLException ex) {
                Logger.getLogger(opcionAlumno2.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
    }//GEN-LAST:event_btnSubirDocumentoActionPerformed

    private void btnEiminarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEiminarDocumentoActionPerformed
        if(tablaAlumnos.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Selecciona un alumno primero.");
        }else{
            String rutaCadena = "C:\\SGRP\\" + lblControl.getText() + "\\Solicitud de residencia.pdf";
            Path ruta = Paths.get(rutaCadena);
            DocumentosAlumno.eliminarArchivo(ruta);
        }
    }//GEN-LAST:event_btnEiminarDocumentoActionPerformed

    private void lblSolicitudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSolicitudMouseClicked
            String rutaCadena = "C:\\SGRP\\" + lblControl.getText() + "\\Solicitud de residencia.pdf";
            Path ruta = Paths.get(rutaCadena);
            CarpetaOculta.abrirPDF(ruta);
    }//GEN-LAST:event_lblSolicitudMouseClicked

    private void comboSoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSoliActionPerformed
        try {
            DocumentoDao.actualizarEstatusSoli(lblControl.getText(), comboSoli.getSelectedItem().toString());
        } catch (SQLException ex) {
            Logger.getLogger(opcionAlumno2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboSoliActionPerformed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked

    void actualizarTablaAlumnos(JTable tablaAlumnos) {
         AlumnoDAO dao = new AlumnoDAO();
        List<AlumnoCarg> lista = dao.obtenerTodosLosAlumnos();
        DefaultTableModel model = (DefaultTableModel) tablaAlumnos.getModel();
        model.setRowCount(0);

        for (AlumnoCarg a : lista) {
            String nombreCompleto = a.getNombre() + " " + a.getApellidoPaterno() + " " + a.getApellidoMaterno();
            model.addRow(new Object[]{a.getNumeroControl(), nombreCompleto});
        }
    }
        private void limpiarPanelAlumno() {
        lblControl.setText("Número de control");
    lblNombreAlumno.setText("Nombre completo");
    lblTelefono.setText("Teléfono");
    lblCorreo.setText("Correo electrónico");
    }
        
        
    private void ajustarVentana() {
    java.awt.Window ventana = javax.swing.SwingUtilities.getWindowAncestor(this);
    if (ventana instanceof javax.swing.JFrame) {
        ((javax.swing.JFrame) ventana).pack();
        ventana.setLocationRelativeTo(null);
    }
}
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelBack;
    private javax.swing.JPanel JPanelImport;
    private javax.swing.JPanel JPanelImport1;
    private javax.swing.JPanel JPanelLOGO;
    private javax.swing.JLabel LbLimportar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEiminarDocumento;
    private javax.swing.JButton btnSubirDocumento;
    private javax.swing.JComboBox<String> comboSoli;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblControl;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombreAlumno;
    private javax.swing.JLabel lblProyecto;
    private javax.swing.JLabel lblSolicitud;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JPanel panelAlumnos;
    public javax.swing.JTable tablaAlumnos;
    // End of variables declaration//GEN-END:variables

   
}
