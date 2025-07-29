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
import Modelo.Entidades.ExpedienteAlumno;
import Utilidades.Conexion;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class opcionAlumno2 extends javax.swing.JPanel {
    
    private final AcomodarImagen acomodarImagen = new AcomodarImagen();

    CardLayout card;
    private JPanel panelContainer;
    private EditarAlumno editar;
    
    static List<ExpedienteAlumno> lista;
    
    public opcionAlumno2() {}

     public opcionAlumno2(CardLayout layout, JPanel container) {
        this.card = layout;
        this.panelContainer = container;
        this.setPreferredSize(new Dimension(905, 539));
        initComponents();
        actualizarTablaAlumnos(tablaAlumnos);
        


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
   
     
public String seleccionObligatoria(JFrame parent) {
    JDialog dialogo = new JDialog(parent, "Selecciona una opción", true); // true = modal
    dialogo.setUndecorated(true);
    
    JComboBox<String> combo = new JComboBox<>(new String[]{"Recibida", "Enviada a firmar",
        "Firmada y sellada", "Entregada al alumno"});
    
    JButton aceptar = new JButton("Aceptar");

    final String[] seleccion = new String[1];

    aceptar.addActionListener(e -> {
        if (combo.getSelectedIndex() != -1) {
            seleccion[0] = combo.getSelectedItem().toString();
            dialogo.dispose();
        } else {
            JOptionPane.showMessageDialog(dialogo, "Debes seleccionar una opción");
        }
    });

    JPanel panel = new JPanel();
    panel.add(combo);
    panel.add(aceptar);
    dialogo.add(panel);
    dialogo.pack();
    dialogo.setLocationRelativeTo(parent);
    dialogo.setVisible(true); // aquí se bloquea hasta que se cierre

    return seleccion[0];
}

     
    public void actualizarTabla() {
        AlumnoContr controlador = new AlumnoContr();
        controlador.actualizarTablaAlumnos(tablaAlumnos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuDocumentos = new javax.swing.JPopupMenu();
        opcionSoli = new javax.swing.JMenuItem();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDocumentos = new javax.swing.JTable();
        btnSubirDocumento = new javax.swing.JButton();
        btnEliminarDocumento = new javax.swing.JButton();
        btnReporteAlumnos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        JPanelLOGO = new javax.swing.JPanel();
        JPanelBack = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JPanelImport = new javax.swing.JPanel();
        JPanelImport1 = new javax.swing.JPanel();
        btnAgregarAlumno = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        opcionSoli.setLabel("Solicitud de residencia");
        opcionSoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionSoliActionPerformed(evt);
            }
        });
        menuDocumentos.add(opcionSoli);

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
        jPanel1.setPreferredSize(new java.awt.Dimension(536, 370));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        lblControl.setText("Numero de  control");

        lblNombreAlumno.setText("Nombre completo");

        lblTelefono.setText("Telefono");

        lblCorreo.setText("Correo electronico");

        lblProyecto.setForeground(new java.awt.Color(0, 102, 255));
        lblProyecto.setText("Proyecto");

        tablaDocumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Documento", "Recibido"
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
        tablaDocumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDocumentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDocumentos);

        btnSubirDocumento.setText("Subir");
        btnSubirDocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubirDocumentoMouseClicked(evt);
            }
        });
        btnSubirDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirDocumentoActionPerformed(evt);
            }
        });

        btnEliminarDocumento.setText("Eliminar");
        btnEliminarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDocumentoActionPerformed(evt);
            }
        });

        btnReporteAlumnos.setText("Generar reporte");
        btnReporteAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteAlumnosActionPerformed(evt);
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
                            .addComponent(lblProyecto)
                            .addComponent(lblCorreo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEliminarDocumento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReporteAlumnos))
                            .addComponent(btnSubirDocumento)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(168, Short.MAX_VALUE))
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
                .addGap(22, 22, 22)
                .addComponent(btnSubirDocumento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarDocumento)
                    .addComponent(btnReporteAlumnos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelAlumnos.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 167, -1, 440));

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("GESTIÓN DE ALUMNOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(JPanelBack, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(296, 296, 296)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                .addComponent(JPanelLOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JPanelLOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(JPanelBack, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelAlumnos.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 1000, -1));

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

        btnAgregarAlumno.setBackground(new java.awt.Color(51, 153, 255));
        btnAgregarAlumno.setText("Agregar");
        btnAgregarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAlumnoActionPerformed(evt);
            }
        });
        panelAlumnos.add(btnAgregarAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 515, -1, -1));

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

    
    public void mostrarDocumentosTabla(JTable tabla, String nControl) throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(0);

        try{
            lista = DocumentoDao.obtenerDocumentos(nControl);
            
            for(ExpedienteAlumno e : lista){
                modelo.addRow(new Object[]{
                    e.getNombre(),
                    e.getEstatus() ? "Si" : "No"
                });
            }
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel label = (JLabel) super.getTableCellRendererComponent(
            table, value, isSelected, hasFocus, row, column);

        label.setText("<html><u><font color='blue'>" + value + "</font></u></html>");
        return label;
    }
});

        }catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al mostrar documentos.");
    }}
    
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


          mostrarDocumentosTabla(tablaDocumentos, lblControl.getText());
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
        String nControl = lblControl.getText();
        try {
            AlumnoDAO dao = new AlumnoDAO(); //objeto para los metodos de la clase
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
       Window ventana = SwingUtilities.getWindowAncestor(this);
        if (ventana != null) ventana.dispose(); 
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

    private void btnAgregarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAlumnoActionPerformed
    JFrame ventanaAgregar = new JFrame("Agregar Alumno");
    AgregarAlumno panelAgregar = new AgregarAlumno();
    ventanaAgregar.setContentPane(panelAgregar);
    ventanaAgregar.setSize(325, 630); // Ajusta el tamaño según tu diseño
    ventanaAgregar.setLocationRelativeTo(null); // Centrar en pantalla
    ventanaAgregar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierre sin terminar la app
    ventanaAgregar.setVisible(true);

    // Al cerrar, actualizar tabla
    ventanaAgregar.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosed(java.awt.event.WindowEvent e) {
            actualizarTablaAlumnos(tablaAlumnos);
        }
    });
    }//GEN-LAST:event_btnAgregarAlumnoActionPerformed

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

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void btnEliminarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDocumentoActionPerformed
        if(tablaAlumnos.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Selecciona un alumno primero.");
        }else{
            menuDocumentos.removeAll();   
            for(ExpedienteAlumno e : lista){
            JMenuItem item = new JMenuItem(e.getNombre());    
            item.addActionListener(evtB -> {
                Path directorio = Paths.get("C:\\SGRP\\" + lblControl.getText());
                try {
                    DocumentosAlumno.eliminarArchivo(e.getNombre(), directorio, lblControl.getText());
                    DocumentoDao.setEstadoDocumento(lblControl.getText(), false, e.getNombre());
                    mostrarDocumentosTabla(tablaDocumentos, lblControl.getText());
                } catch (SQLException ex) {
                    Logger.getLogger(opcionAlumno2.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            menuDocumentos.add(item);
            }
            menuDocumentos.show(btnEliminarDocumento, 0, btnEliminarDocumento.getHeight());
        }
    }//GEN-LAST:event_btnEliminarDocumentoActionPerformed

    private void btnSubirDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirDocumentoActionPerformed
        if(tablaAlumnos.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Selecciona un alumno primero.");
        }else{
            menuDocumentos.removeAll();
            for(ExpedienteAlumno e : lista){
                JMenuItem item = new JMenuItem(e.getNombre());    
                item.addActionListener(evtB -> {
                    try {
                        if(DocumentosAlumno.subirDocumentoAlumno(lblControl.getText(),
                                e.getNombre() , this)){
                            DocumentoDao.setEstadoDocumento(lblControl.getText(), true,
                                    e.getNombre());
                            mostrarDocumentosTabla(tablaDocumentos, lblControl.getText());   
                        }else{
                        JOptionPane.showMessageDialog(null, "Solo puede subir imagenes y PDF");
                    }
                    }
                    catch (SQLException ex) {
                        Logger.getLogger(opcionAlumno2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                menuDocumentos.add(item);
            }
            menuDocumentos.show(btnSubirDocumento, 0, btnSubirDocumento.getHeight());
        }
    }//GEN-LAST:event_btnSubirDocumentoActionPerformed


    private void tablaDocumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDocumentosMouseClicked
            if (evt.getClickCount() == 2) {
            int fila = tablaDocumentos.rowAtPoint(evt.getPoint());
            int columna = tablaDocumentos.columnAtPoint(evt.getPoint());

            if (columna == 0 && fila != -1) {
                String carpeta ="C:\\SGRP\\" + lblControl.getText();
                CarpetaOculta.abrirPDF(tablaDocumentos.getValueAt(fila, 0).toString(), carpeta);
            }
        }
    }//GEN-LAST:event_tablaDocumentosMouseClicked

    private void btnSubirDocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubirDocumentoMouseClicked

    }//GEN-LAST:event_btnSubirDocumentoMouseClicked

    private void opcionSoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionSoliActionPerformed
        try {
            DocumentosAlumno.subirDocumentoAlumno(lblControl.getText(), "Solicitud de residencia" , this);
        } catch (SQLException ex) {
            Logger.getLogger(opcionAlumno2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_opcionSoliActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void btnReporteAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteAlumnosActionPerformed
        try {
            DocumentosAlumno.generarPDFPendientes(AlumnoDAO.obtenerPendientes());
        } catch (SQLException ex) {
            Logger.getLogger(opcionAlumno2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(opcionAlumno2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteAlumnosActionPerformed

    
    
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
    private javax.swing.JButton btnAgregarAlumno;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminarDocumento;
    private javax.swing.JButton btnReporteAlumnos;
    private javax.swing.JButton btnSubirDocumento;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblControl;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombreAlumno;
    private javax.swing.JLabel lblProyecto;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JPopupMenu menuDocumentos;
    private javax.swing.JMenuItem opcionSoli;
    private javax.swing.JPanel panelAlumnos;
    public javax.swing.JTable tablaAlumnos;
    private javax.swing.JTable tablaDocumentos;
    // End of variables declaration//GEN-END:variables

   
}
