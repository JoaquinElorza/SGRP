/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.AcomodarImagen;
import Modelo.DAO.AlumnoDAO;
import Modelo.DAO.ProyectoDAO;
import Modelo.Entidades.Alumno;
import Modelo.Entidades.Proyecto;
import Utilidades.Conexion;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
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
        cargarAlumnosDisponibles();
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
        JPanelBack = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProyectos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblNombreProyecto = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        comboAlumnos = new javax.swing.JComboBox<>();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(JPanelLOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JPanelBack, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPanelLOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(JPanelBack, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
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

        lblNombreProyecto.setText("Nombre del Proyecto");

        lblDescripcion.setText("Descripcion:");

        lblEmpresa.setText("Empresa:");

        jButton4.setText("Asignar Alumno");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addComponent(lblEmpresa))
                        .addContainerGap(202, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblNombreProyecto)
                        .addGap(73, 73, 73))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(comboAlumnos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreProyecto)
                .addGap(18, 18, 18)
                .addComponent(lblDescripcion)
                .addGap(45, 45, 45)
                .addComponent(lblEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(comboAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout panelProyectosLayout = new javax.swing.GroupLayout(panelProyectos);
        panelProyectos.setLayout(panelProyectosLayout);
        panelProyectosLayout.setHorizontalGroup(
            panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelProyectosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelProyectosLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(46, 46, 46)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        panelProyectosLayout.setVerticalGroup(
            panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProyectosLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(panelProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProyectos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProyectosMouseClicked
        
    }//GEN-LAST:event_panelProyectosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame ventanaAgregar = new JFrame("Agregar Proyecto");
    agregarProyecto panelAgregar = new agregarProyecto();
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
        
        
        int fila = tablaProyectos.getSelectedRow();

    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "⚠️ Debes seleccionar un proyecto para editar.");
        return;
    }

    // Suponiendo que tienes las columnas: Nombre, Descripción, Estatus, Empresa
        Object nombreObj = tablaProyectos.getValueAt(fila, 0);
        Object descripcionObj = tablaProyectos.getValueAt(fila, 1);
        Object estatusObj = tablaProyectos.getValueAt(fila, 2);
        Object empresaObj = tablaProyectos.getValueAt(fila, 3);

        if (nombreObj == null || descripcionObj == null || estatusObj == null || empresaObj == null) {
            JOptionPane.showMessageDialog(this, "❌ El proyecto seleccionado tiene datos incompletos.");
            return;
        }

        String nombre = nombreObj.toString();
        String descripcion = descripcionObj.toString();
        String estatus = estatusObj.toString();
        String empresa = empresaObj.toString();

    // 🔍 Aquí necesitas obtener el ID del proyecto (ej. desde BD)
    int id = obtenerIdProyectoDesdeBD(nombre, descripcion); // ← te ayudo a implementarlo si no lo tienes

    // Abrir el panel de edición
    vistaProyectos estaVista = this; // 👈 hace referencia a sí mismo

        editarProyecto panelEditar = new editarProyecto(card, panelContainer, estaVista);
        panelEditar.cargarDatos(id, nombre, empresa, descripcion, estatus);
        panelContainer.add(panelEditar, "panelEditarProyecto");
        card.show(panelContainer, "panelEditarProyecto");
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         jButtonEliminarActionPerformed(evt);
         
         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void JPanelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPanelBackMouseClicked
        Window ventana = SwingUtilities.getWindowAncestor(this);
        if (ventana != null) ventana.dispose();
    }//GEN-LAST:event_JPanelBackMouseClicked

    private void tablaProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProyectosMouseClicked
 
    }//GEN-LAST:event_tablaProyectosMouseClicked

    private void tablaProyectosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProyectosMousePressed
        // TODO add your handling code here:
        int fila = tablaProyectos.getSelectedRow();
            if (fila == -1) return;

            String nombre = tablaProyectos.getValueAt(fila, 0).toString();
            String descripcion = tablaProyectos.getValueAt(fila, 1).toString();
            String empresa = tablaProyectos.getValueAt(fila, 3).toString();  // columna 3 = Empresa

            lblNombreProyecto.setText("📌 " + nombre);
            lblDescripcion.setText("📝 " + descripcion);
            lblEmpresa.setText("🏢 " + empresa);
    }//GEN-LAST:event_tablaProyectosMousePressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
           int fila = tablaProyectos.getSelectedRow(); // 🔧 NECESARIO
            int indexAlumno = comboAlumnos.getSelectedIndex();

            if (fila == -1 || indexAlumno == -1) {
                JOptionPane.showMessageDialog(null, "Selecciona un proyecto y un alumno.");
                return;
            }

            String nombre = tablaProyectos.getValueAt(fila, 0).toString();
            String descripcion = tablaProyectos.getValueAt(fila, 1).toString();
            int idProyecto = obtenerIdProyectoDesdeBD(nombre, descripcion); // 🚨 Usa el método que ya tienes

            Alumno alumno = listaAlumnos.get(indexAlumno);

            boolean exito = ProyectoDAO.asignarProyectoAAlumno(idProyecto, alumno.getIdPersona());

            if (exito) {
                ProyectoDAO.cambiarEstatus(idProyecto, "No disponible");
                mostrarProyectosEnTabla(); // ✅ Usas este, no `mostrarProyectos()`
                cargarAlumnosDisponibles(); // 🔄 Recarga combo
                JOptionPane.showMessageDialog(null, "Proyecto asignado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "El alumno ya tiene un proyecto.");
            }

    
    }//GEN-LAST:event_jButton4ActionPerformed
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

    int confirmacion = JOptionPane.showConfirmDialog(this, 
        "¿Estás seguro de eliminar este proyecto?", 
        "Confirmar eliminación", 
        JOptionPane.YES_NO_OPTION);

    if (confirmacion == JOptionPane.YES_OPTION) {
        String nombre = tablaProyectos.getValueAt(filaSeleccionada, 0).toString();
        String descripcion = tablaProyectos.getValueAt(filaSeleccionada, 1).toString();

        int idProyecto = obtenerIdProyectoDesdeBD(nombre, descripcion);
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
   
        
        
  private void cargarAlumnosDisponibles() {
    listaAlumnos = AlumnoDAO.obtenerAlumnosSinProyecto();
    comboAlumnos.removeAllItems();

    for (Alumno a : listaAlumnos) {
        String nombreCompleto = a.getNombre() + " " + a.getApellidoPaterno() + " " + a.getApellidoMaterno();
        comboAlumnos.addItem(nombreCompleto);
    }

    if (listaAlumnos.isEmpty()) {
        comboAlumnos.addItem("Sin alumnos disponibles");
    }

}




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelBack;
    private javax.swing.JPanel JPanelLOGO;
    private javax.swing.JComboBox<String> comboAlumnos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblNombreProyecto;
    private javax.swing.JPanel panelProyectos;
    private javax.swing.JTable tablaProyectos;
    // End of variables declaration//GEN-END:variables
}
