/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.AcomodarImagen;
import Controlador.ReportePDF;
import Modelo.DAO.AlumnoDAO;
import Modelo.DAO.ProyectoDAO;
import Modelo.Entidades.Alumno;
import Modelo.Entidades.Proyecto;
import Utilidades.Conexion;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emili
 */
public class vistaProyectos extends javax.swing.JPanel {
        private CardLayout card;
        private JPanel panelContainer;
        private JPanel panelCambiante;
        private editarProyecto editarPanel;
        private List<Alumno> listaAlumnos;
        

    
    private final AcomodarImagen acomodarImagen = new AcomodarImagen();

    /**
     * Creates new form vistaProyectos
     */
    public vistaProyectos(CardLayout layout, JPanel container) {
        initComponents();
        txtAreaDescripcion.setLineWrap(true);
        txtAreaDescripcion.setWrapStyleWord(true);
        txtAreaDescripcion.setEditable(false);
        txtAreaDescripcion.setOpaque(false);
        txtAreaDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        
   
        mostrarProyectosEnTabla();
        this.card = layout;
        this.panelContainer = container;
        this.panelCambiante = container;
            editarPanel = new editarProyecto(card, panelContainer,this); // ✅ inicializa correctamente
            panelContainer.add(editarPanel, "panelEditar"); 

         acomodarImagen.configurarPanelConImagen("/img/backbutton.png", JPanelBack);  
         JPanelBack.setOpaque(false);
         JPanelBack.setBorder(null);
         JPanelBack.setBackground(new Color(0,0,0,0));
         this.setVisible(true);
       
         acomodarImagen.configurarPanelConImagen("/img/ITOlogo.png", JPanelLOGO);  
         JPanelLOGO.setOpaque(false);
         JPanelLOGO.setBorder(null);
         JPanelLOGO.setBackground(new Color(0,0,0,0));
         this.setVisible(true);
       

    }
            public void mostrarProyectosEnTabla() {
            DefaultTableModel modelo = (DefaultTableModel) tablaProyectos.getModel();
            modelo.setRowCount(0); // limpia tabla

            ProyectoDAO dao = new ProyectoDAO();
            List<Proyecto> lista = dao.obtenerTodos();

            for (Proyecto p : lista) {
                String nombreEmpresa = obtenerNombreEmpresa(p.getIdEmpresa());
                modelo.addRow(new Object[]{
                p.getNombre(),
                p.getEstatus(),
                nombreEmpresa
            });
            }

            // Verificación rápida
            System.out.println("✅ Se cargaron " + lista.size() + " proyectos.");
        }


        private String obtenerNombreEmpresa(int idEmpresa) {
            String nombre = "";
            String sql = "SELECT nombre FROM empresa WHERE id_empresa = ?";

            try (Connection conn = Conexion.getConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, idEmpresa);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    nombre = rs.getString("nombre");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return nombre;
        }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProyectos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        JPanelLOGO = new javax.swing.JPanel();
        JPanelBack = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProyectos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblNombreProyecto = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDescripcion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        btnVerArchivo = new javax.swing.JButton();
        comboArchivos = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(828, 543));

        panelProyectos.setBackground(new java.awt.Color(255, 255, 255));
        panelProyectos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelProyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelProyectosMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

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

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("BANCO DE PROYECTOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(JPanelBack, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(211, 211, 211)
                .addComponent(JPanelLOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(JPanelLOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(JPanelBack, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        tablaProyectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Estatus", "Empresa"
            }
        ));
        tablaProyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProyectosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaProyectosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProyectos);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreProyecto.setText("nameproyecto");
        jPanel2.add(lblNombreProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, -1));

        lblDescripcion.setText("Descripcion:");
        jPanel2.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 82, -1, -1));

        lblEmpresa.setText("empresa");
        jPanel2.add(lblEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        txtAreaDescripcion.setColumns(20);
        txtAreaDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtAreaDescripcion);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 280, 210));

        jLabel1.setText("Empresa:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel2.setText("Nombre del Proyecto:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jButton4.setText("Subir Documento");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        btnVerArchivo.setText("Ver Documento ");
        btnVerArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerArchivoActionPerformed(evt);
            }
        });
        jPanel2.add(btnVerArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 120, -1));

        comboArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboArchivosActionPerformed(evt);
            }
        });
        jPanel2.add(comboArchivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 170, -1));

        jButton5.setText("Generar Reporte ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProyectosLayout = new javax.swing.GroupLayout(panelProyectos);
        panelProyectos.setLayout(panelProyectosLayout);
        panelProyectosLayout.setHorizontalGroup(
            panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelProyectosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProyectosLayout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelProyectosLayout.setVerticalGroup(
            panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProyectosLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProyectosLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton5)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProyectos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProyectos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProyectosMouseClicked

    }//GEN-LAST:event_panelProyectosMouseClicked

    private void comboArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboArchivosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboArchivosActionPerformed

    private void btnVerArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerArchivoActionPerformed
        // TODO add your handling code here:
        abrirArchivoSeleccionado();
    }//GEN-LAST:event_btnVerArchivoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        btnSubirPDFActionPerformed(evt);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jButtonEliminarActionPerformed(evt);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int fila = tablaProyectos.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "⚠️ Debes seleccionar un proyecto para editar.");
            return;
        }

        // Suponiendo columnas: Nombre (0), Estatus (1), Empresa (2)
        Object nombreObj = tablaProyectos.getValueAt(fila, 0);
        Object estatusObj = tablaProyectos.getValueAt(fila, 1);
        Object empresaObj = tablaProyectos.getValueAt(fila, 2);

        if (nombreObj == null || estatusObj == null || empresaObj == null) {
            JOptionPane.showMessageDialog(this, "❌ El proyecto seleccionado tiene datos incompletos.");
            return;
        }

        String nombre = nombreObj.toString();
        String estatus = estatusObj.toString();
        String empresa = empresaObj.toString();

        // Obtener el ID del proyecto desde la BD
        int idProyecto = obtenerIdProyectoDesdeBD(nombre, estatus, empresa);

        if (idProyecto == -1) {
            JOptionPane.showMessageDialog(this, "❌ No se pudo encontrar el ID del proyecto en la base de datos.");
            return;
        }

        // Obtener descripción desde la BD
        String descripcion = obtenerDescripcionProyecto(idProyecto);
        if (descripcion == null) {
            JOptionPane.showMessageDialog(this, "❌ No se pudo obtener la descripción del proyecto.");
            return;
        }

        // Abrir el panel de edición
        vistaProyectos estaVista = this;

        editarProyecto panelEditar = new editarProyecto(card, panelContainer, estaVista);
        panelEditar.cargarDatos(idProyecto, nombre, empresa, descripcion, estatus);
        panelContainer.add(panelEditar, "panelEditarProyecto");
        card.show(panelContainer, "panelEditarProyecto");
        panelContainer.revalidate();
        panelContainer.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame ventanaAgregar = new JFrame("Agregar Proyecto");
        agregarProyecto panelAgregar = new agregarProyecto();

        ventanaAgregar.setContentPane(panelAgregar);
        ventanaAgregar.pack(); // <- Esto ajusta el tamaño al contenido
        ventanaAgregar.setLocationRelativeTo(null); // centrado
        ventanaAgregar.setVisible(true);
        ventanaAgregar.setContentPane(panelAgregar);
        ventanaAgregar.setSize(400, 450);
        ventanaAgregar.setLocationRelativeTo(null);
        ventanaAgregar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaAgregar.setVisible(true);

        ventanaAgregar.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                mostrarProyectosEnTabla();
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaProyectosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProyectosMousePressed
        int fila = tablaProyectos.getSelectedRow();
        if (fila == -1) return;

        String nombre = tablaProyectos.getValueAt(fila, 0).toString();
        String estatus = tablaProyectos.getValueAt(fila, 1).toString();  // ahora columna 1
        String empresa = tablaProyectos.getValueAt(fila, 2).toString();  // ahora columna 2

        lblNombreProyecto.setText("📝 " + nombre);
        lblEmpresa.setText("🏢 " + empresa);

        int idProyecto = obtenerIdProyectoDesdeBD(nombre, estatus, empresa);
        String descripcion = obtenerDescripcionProyecto(idProyecto);
        txtAreaDescripcion.setText(descripcion);

        cargarArchivosDelProyecto(idProyecto);
    }//GEN-LAST:event_tablaProyectosMousePressed

    private void tablaProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProyectosMouseClicked

    }//GEN-LAST:event_tablaProyectosMouseClicked

    private void JPanelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPanelBackMouseClicked
        Window ventana = SwingUtilities.getWindowAncestor(this);
        if (ventana != null) ventana.dispose();
    }//GEN-LAST:event_JPanelBackMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
       try {
        List<Integer> aniosDisponibles = ProyectoDAO.obtenerAniosConProyectos();
        if (aniosDisponibles.isEmpty()) {
            JOptionPane.showMessageDialog(this, "⚠️ No hay proyectos registrados aún.");
            return;
        }

        JComboBox<Integer> comboAnios = new JComboBox<>();
        for (Integer anio : aniosDisponibles) {
            comboAnios.addItem(anio);
        }

        String[] semestres = {"Enero-Junio", "Julio-Diciembre"};
        JComboBox<String> comboSemestres = new JComboBox<>(semestres);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Selecciona el año:"));
        panel.add(comboAnios);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("Selecciona el semestre:"));
        panel.add(comboSemestres);

        int opcion = JOptionPane.showConfirmDialog(this, panel, "Generar Reporte",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (opcion == JOptionPane.OK_OPTION) {
            int anioSeleccionado = (Integer) comboAnios.getSelectedItem();
            int semestre = comboSemestres.getSelectedIndex() + 1;

            List<Proyecto> proyectos = ProyectoDAO.obtenerProyectosPorSemestre(anioSeleccionado, semestre);

            if (proyectos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "⚠️ No hay proyectos para ese periodo.");
            } else {
                ReportePDF.generarReporte(proyectos, anioSeleccionado, semestre);
                JOptionPane.showMessageDialog(this, "✅ Reporte generado correctamente.");
            }
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "❌ Error al generar el reporte.");
    }
    }//GEN-LAST:event_jButton5ActionPerformed
        public int obtenerIdPorNombreYDescripcion(String nombre, String descripcion) {
            String sql = "SELECT id_proyecto FROM proyecto WHERE nombre = ? AND descripcion = ? LIMIT 1";
            try (Connection conn = Conexion.getConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, nombre);
                ps.setString(2, descripcion);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("id_proyecto");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return -1;
        }

        private int obtenerIdProyectoDesdeBD(String nombre, String estatus, String empresa) {
            String sql = """
                SELECT p.id_proyecto
                FROM proyecto p
                JOIN empresa e ON p.fk_empresa = e.id_empresa
                WHERE p.nombre = ? AND p.estatus = ? AND e.nombre = ?
                LIMIT 1
            """;

            try (Connection conn = Conexion.getConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, nombre);
                ps.setString(2, estatus);
                ps.setString(3, empresa);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("id_proyecto");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return -1;
        }
    
        
        
   
    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {
    int filaSeleccionada = tablaProyectos.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "⚠️ Selecciona un proyecto para eliminar.");
        return;
    }

    int confirmacion = JOptionPane.showConfirmDialog(this, 
        "¿Estás seguro de eliminar este proyecto?", 
        "Confirmar eliminación", 
        JOptionPane.YES_NO_OPTION);

    if (confirmacion == JOptionPane.YES_OPTION) {
        String nombre = tablaProyectos.getValueAt(filaSeleccionada, 0).toString();
        String estatus = tablaProyectos.getValueAt(filaSeleccionada, 1).toString();
        String empresa = tablaProyectos.getValueAt(filaSeleccionada, 2).toString();
        int idProyecto = obtenerIdProyectoDesdeBD(nombre, estatus, empresa);
        Modelo.DAO.ProyectoDAO dao = new Modelo.DAO.ProyectoDAO();
        boolean eliminado = dao.eliminarProyecto(idProyecto);

        if (eliminado) {
            JOptionPane.showMessageDialog(this, "✅ Proyecto eliminado exitosamente.");
            
            // 🔁 ACTUALIZAR LA TABLA
            mostrarProyectosEnTabla();

        } else {
            JOptionPane.showMessageDialog(this, "❌ Error al eliminar el proyecto.");
        }
    }
}
    

        
                
    private void ajustarVentana() {
    java.awt.Window ventana = javax.swing.SwingUtilities.getWindowAncestor(this);
    if (ventana instanceof javax.swing.JFrame) {
        ((javax.swing.JFrame) ventana).pack();
        ventana.setLocationRelativeTo(null);
    }
}
   
    private void btnSubirPDFActionPerformed(java.awt.event.ActionEvent evt) {
                    int fila = tablaProyectos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "⚠️ Selecciona un proyecto para subir un archivo.");
                return;
            }

            String nombre = tablaProyectos.getValueAt(fila, 0).toString();
            String estatus = tablaProyectos.getValueAt(fila, 1).toString();
            String empresa = tablaProyectos.getValueAt(fila, 2).toString();
            int idProyecto = obtenerIdProyectoDesdeBD(nombre, estatus, empresa);

            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Selecciona el archivo de la propuesta");

            FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                "Documentos (PDF, Word, Excel, Imágenes)", 
                "pdf", "doc", "docx", "xls", "xlsx", "png", "jpg", "jpeg", "bmp"
            );
            chooser.setFileFilter(filtro);

            int seleccion = chooser.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File archivoOriginal = chooser.getSelectedFile();

                // Crear carpeta por proyecto
                File carpeta = new File("DocumentosProyectos/proyecto_" + idProyecto);
                if (!carpeta.exists()) carpeta.mkdirs();

                // Guardar con nombre original (o renombrar si lo deseas)
                File destino = new File(carpeta, archivoOriginal.getName());

                try {
                    Files.copy(archivoOriginal.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(this, "✅ Archivo cargado correctamente.");

                    // 🔄 ACTUALIZAR EL COMBOBOX AUTOMÁTICAMENTE
                    cargarArchivosDelProyecto(idProyecto);

                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "❌ Error al guardar el archivo.");
                }
            }
       }

    
    private void abrirPropuestaPDF() {
            int fila = tablaProyectos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona un proyecto.");
                return;
            }

            String nombre = tablaProyectos.getValueAt(fila, 0).toString();
            String estatus = tablaProyectos.getValueAt(fila, 1).toString();
            String empresa = tablaProyectos.getValueAt(fila, 2).toString();
            int idProyecto = obtenerIdProyectoDesdeBD(nombre, estatus, empresa);

            File carpeta = new File("DocumentosProyectos/proyecto_" + idProyecto);
            File[] archivos = carpeta.listFiles();

            if (archivos == null || archivos.length == 0) {
                JOptionPane.showMessageDialog(this, "❌ No hay archivos disponibles para este proyecto.");
                return;
            }

            // 🧠 Ordenar por fecha de modificación (de más nuevo a más viejo)
            Arrays.sort(archivos, (a, b) -> Long.compare(b.lastModified(), a.lastModified()));

            File archivoMasReciente = archivos[0]; // ✅ este es el más nuevo

            try {
                Desktop.getDesktop().open(archivoMasReciente);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "❌ Error al abrir el archivo más reciente.");
            }
        }
        
    
    
    
            private void cargarArchivosDelProyecto(int idProyecto) {
            comboArchivos.removeAllItems();

            File carpeta = new File("DocumentosProyectos/proyecto_" + idProyecto);
            if (!carpeta.exists() || carpeta.listFiles() == null) {
                comboArchivos.addItem("Sin archivos");
                comboArchivos.setEnabled(false);
                btnVerArchivo.setEnabled(false);
                return;
            }

            File[] archivos = carpeta.listFiles();
            if (archivos.length == 0) {
                comboArchivos.addItem("Sin archivos");
                comboArchivos.setEnabled(false);
                btnVerArchivo.setEnabled(false);
            } else {
                Arrays.sort(archivos); // opcional: orden alfabético
                for (File archivo : archivos) {
                    comboArchivos.addItem(archivo.getName());
                }
                comboArchivos.setEnabled(true);
                btnVerArchivo.setEnabled(true);
            }
        }
            
            private void abrirArchivoSeleccionado() {
            int fila = tablaProyectos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona un proyecto.");
                return;
            }

            String archivoSeleccionado = (String) comboArchivos.getSelectedItem();
            if (archivoSeleccionado == null || archivoSeleccionado.equals("Sin archivos")) {
                JOptionPane.showMessageDialog(this, "No hay archivo seleccionado.");
                return;
            }

            String nombre = tablaProyectos.getValueAt(fila, 0).toString();
            String estatus = tablaProyectos.getValueAt(fila, 1).toString();
            String empresa = tablaProyectos.getValueAt(fila, 2).toString();
            int idProyecto = obtenerIdProyectoDesdeBD(nombre, estatus, empresa);

            File archivo = new File("DocumentosProyectos/proyecto_" + idProyecto + "/" + archivoSeleccionado);
            if (archivo.exists()) {
                try {
                    Desktop.getDesktop().open(archivo);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "❌ Error al abrir el archivo.");
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "❌ Archivo no encontrado.");
            }
        }
            
            
            private String obtenerDescripcionProyecto(int idProyecto) {
                String descripcion = "Sin descripción disponible.";
                String sql = "SELECT descripcion FROM proyecto WHERE id_proyecto = ?";
                try (Connection conn = Conexion.getConexion();
                     PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, idProyecto);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        descripcion = rs.getString("descripcion");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return descripcion;
            }



        




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelBack;
    private javax.swing.JPanel JPanelLOGO;
    private javax.swing.JButton btnVerArchivo;
    private javax.swing.JComboBox<String> comboArchivos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblNombreProyecto;
    private javax.swing.JPanel panelProyectos;
    private javax.swing.JTable tablaProyectos;
    private javax.swing.JTextArea txtAreaDescripcion;
    // End of variables declaration//GEN-END:variables
}
