/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.AcomodarImagen;
import Modelo.DAO.ProyectoDAO;
import Modelo.Entidades.Proyecto;
import Utilidades.Conexion;
import java.awt.CardLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emili
 */
public class vistaProyectos extends javax.swing.JPanel {
        private CardLayout card;
        private JPanel panelContainer;
        private JPanel panelCambiante;

    
    private final AcomodarImagen acomodarImagen = new AcomodarImagen();

    /**
     * Creates new form vistaProyectos
     */
    public vistaProyectos(CardLayout layout, JPanel container) {
        initComponents();
        mostrarProyectosEnTabla();
        this.card = layout;
        this.panelContainer = container;
        this.panelCambiante = container;
        
       // vistaProyectos proyectos = new vistaProyectos(card, panelCambiante);
        //agregarProyecto agregar = new agregarProyecto(card, panelCambiante, proyectos);
         
         //panelContainer.add(agregar, "panelAgregarProyecto");
        //panelCambiante.add(proyectos, "panelProyectos");
        
        /**acomodarImagen.configurarPanelConImagen("/img/itoaxaca.png", panelProyectos);
        panelProyectos.setOpaque(false);
        panelProyectos.setBorder(null);
        panelProyectos.setBackground(new Color(0, 0, 0, 0));
        this.setVisible(true);
        */
         acomodarImagen.configurarPanelConImagen("/img/ITOlogo.png", JPanelLOGO);  
         JPanelLOGO.setOpaque(false);
         JPanelLOGO.setBorder(null);
         JPanelLOGO.setBackground(new Color(0,0,0,0));
         this.setVisible(true);
       

    }
            private void mostrarProyectosEnTabla() {
            DefaultTableModel modelo = (DefaultTableModel) tablaProyectos.getModel();
            modelo.setRowCount(0); // limpia tabla

            ProyectoDAO dao = new ProyectoDAO();
            List<Proyecto> lista = dao.obtenerTodos();

            for (Proyecto p : lista) {
                String nombreEmpresa = obtenerNombreEmpresa(p.getIdEmpresa());
                modelo.addRow(new Object[]{
                    p.getNombre(),
                    p.getDescripcion(),
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProyectos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JPanelLOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(JPanelLOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tablaProyectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Descripcion", "Estatus", "Empresa"
            }
        ));
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

        javax.swing.GroupLayout panelProyectosLayout = new javax.swing.GroupLayout(panelProyectos);
        panelProyectos.setLayout(panelProyectosLayout);
        panelProyectosLayout.setHorizontalGroup(
            panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelProyectosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelProyectosLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        panelProyectosLayout.setVerticalGroup(
            panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProyectosLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProyectos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProyectosMouseClicked
        
    }//GEN-LAST:event_panelProyectosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        card.show(panelContainer, "panelAgregarProyecto");
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int fila = tablaProyectos.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "⚠️ Debes seleccionar un proyecto para editar.");
            return;
        }

        // Suponiendo que tienes las columnas: Nombre, Descripción, Estatus, Empresa
        String nombre = tablaProyectos.getValueAt(fila, 0).toString();
        String descripcion = tablaProyectos.getValueAt(fila, 1).toString();
        String estatus = tablaProyectos.getValueAt(fila, 2).toString();
        String empresa = tablaProyectos.getValueAt(fila, 3).toString();

        // 🔍 Aquí necesitas obtener el ID del proyecto (ej. desde BD)
        int id = obtenerIdProyectoDesdeBD(nombre, descripcion); // ← te ayudo a implementarlo si no lo tienes

        // Abrir el panel de edición
        editarProyecto panelEditar = new editarProyecto(card, panelCambiante);
        panelEditar.cargarDatos(id, nombre, empresa, descripcion, estatus);
        panelCambiante.add(panelEditar, "panelEditarProyecto");
        card.show(panelCambiante, "panelEditarProyecto");
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         jButtonEliminarActionPerformed(evt);
    }//GEN-LAST:event_jButton3ActionPerformed
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

        
        private int obtenerIdProyectoDesdeBD(String nombre, String descripcion) {
    String sql = "SELECT id_proyecto FROM proyecto WHERE nombre = ? AND descripcion = ? LIMIT 1";

    try (Connection conn = Utilidades.Conexion.getConexion();
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

    return -1; // si no se encuentra
}
        
        
        
        private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {
    int filaSeleccionada = tablaProyectos.getSelectedRow();

    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "⚠️ Selecciona un proyecto para eliminar.");
        return;
    }

    // Confirmación
    int confirmacion = JOptionPane.showConfirmDialog(this, 
        "¿Estás seguro de eliminar este proyecto?", 
        "Confirmar eliminación", 
        JOptionPane.YES_NO_OPTION);

    if (confirmacion == JOptionPane.YES_OPTION) {
        //int idProyecto = Integer.parseInt(tablaProyectos.getValueAt(filaSeleccionada, 0).toString());
        
        String nombre = tablaProyectos.getValueAt(filaSeleccionada, 0).toString();
        String descripcion = tablaProyectos.getValueAt(filaSeleccionada, 1).toString();
        int idProyecto = obtenerIdProyectoDesdeBD(nombre, descripcion);


        Modelo.DAO.ProyectoDAO dao = new Modelo.DAO.ProyectoDAO();
        boolean eliminado = dao.eliminarProyecto(idProyecto);

        if (eliminado) {
            JOptionPane.showMessageDialog(this, "✅ Proyecto eliminado exitosamente.");
            //cargarDatos(); // vuelve a cargar la tabla actualizada
        } else {
            JOptionPane.showMessageDialog(this, "❌ Error al eliminar el proyecto.");
        }
    }
    
    
}
        
        
        
        



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelLOGO;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelProyectos;
    private javax.swing.JTable tablaProyectos;
    // End of variables declaration//GEN-END:variables
}
