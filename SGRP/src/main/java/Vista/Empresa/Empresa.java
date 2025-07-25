/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista.Empresa;

import Modelo.DAO.EmpresaDAO;
import Modelo.Entidades.EmpresaEntidad;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author stranger
 */
public class Empresa extends javax.swing.JFrame {

    private Vista.MenuPrincipal ventanaMenu;

    public Empresa(Vista.MenuPrincipal ventanaMenu) {
        setUndecorated(true);

        initComponents();
        this.ventanaMenu = ventanaMenu;

        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setLocationRelativeTo(null);
        cargarTablaEmpresas();

        // Botón de regreso
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/img/backbutton.png"));
        Image imagenRedimensionada = iconoOriginal.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        jButton4.setIcon(new ImageIcon(imagenRedimensionada));
    }

    private void cargarTablaEmpresas() {
        EmpresaDAO dao = new EmpresaDAO();
        List<EmpresaEntidad> lista = dao.listarEmpresas();

        String[] columnas = {"ID", "Nombre", "Contacto"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        for (EmpresaEntidad emp : lista) {
            Object[] fila = {
                emp.getIdEmpresa(), // Se usará internamente, pero no se muestra
                emp.getNombre(),
                emp.getContacto()
            };
            modelo.addRow(fila);
        }

        jTable1.setModel(modelo);

        jTable1.setShowGrid(false); // Oculta líneas internas
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0)); // Elimina el espacio entre celdas

        jTable1.setBackground(Color.WHITE);
        jTable1.setForeground(Color.BLACK);
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new Color(100, 150, 255));

        // 🔒 Ocultar columna ID visualmente
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setWidth(0);
    }

    public void recargarTabla() {
        cargarTablaEmpresas(); // reutiliza el método que ya tienes
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("EDITAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/backbutton.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(153, 153, 153)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una empresa.");
            return;
        }

        // ✅ Obtén el ID desde el modelo, no desde la vista
        int id = Integer.parseInt(jTable1.getModel().getValueAt(fila, 0).toString()); // <- getModel()
        String nombre = jTable1.getModel().getValueAt(fila, 1).toString();
        String contacto = jTable1.getModel().getValueAt(fila, 2).toString();

        EmpresaEntidad empresa = new EmpresaEntidad();
        empresa.setIdEmpresa(id);
        empresa.setNombre(nombre);
        empresa.setContacto(contacto);

        Editar editarVentana = new Editar(empresa, this);
        editarVentana.setVisible(true);
        editarVentana.setLocationRelativeTo(this);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una empresa para eliminar.");
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this, "¿Deseas quitar esta empresa?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (opcion != JOptionPane.YES_OPTION) {
            return;
        }

        // ✅ Obtener ID oculto desde el modelo (columna 0)
        int id = Integer.parseInt(jTable1.getModel().getValueAt(fila, 0).toString());

        EmpresaDAO dao = new EmpresaDAO();
        if (dao.eliminar(id)) {
            JOptionPane.showMessageDialog(this, "Empresa eliminada correctamente.");
            recargarTabla(); // ✅ Recarga los datos desde la base
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar empresa.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose(); // Cierra esta ventana
        ventanaMenu.setVisible(true); // Vuelve a mostrar el menú principal
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Agregar ventanaAgregar = new Agregar(this);
        ventanaAgregar.setVisible(true);
        ventanaAgregar.setLocationRelativeTo(this); // Centrar
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Crea un menú temporal solo para probar
                Vista.MenuPrincipal menuFalso = new Vista.MenuPrincipal();
                new Vista.Empresa.Empresa(menuFalso).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
