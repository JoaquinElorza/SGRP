package Vista;

import Controlador.AlumnoContr;
import Modelo.DAO.AlumnoCarg;
import org.apache.poi.ss.usermodel.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;

public class VentanaCargaProgreso extends JDialog {

    private JProgressBar barraProgreso;
    private JLabel texto;
    private JButton botonCancelar;
    private volatile boolean cancelado = false;

    public VentanaCargaProgreso(Frame owner, File archivoExcel, opcionAlumno2 vistaTabla) {
        super(owner, "Importando alumnos...", true);
        setLayout(new BorderLayout());
        setSize(400, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        barraProgreso = new JProgressBar(0, 100);
        barraProgreso.setStringPainted(true);
        texto = new JLabel("Procesando...");
        texto.setHorizontalAlignment(SwingConstants.CENTER);

        botonCancelar = new JButton("Cancelar importación");
        botonCancelar.addActionListener(e -> cancelado = true);

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.add(texto, BorderLayout.NORTH);
        panelCentro.add(barraProgreso, BorderLayout.CENTER);
        panelCentro.add(botonCancelar, BorderLayout.SOUTH);

        add(panelCentro, BorderLayout.CENTER);

        new Thread(() -> importarConProgreso(archivoExcel, vistaTabla)).start();
    }

    private void importarConProgreso(File archivoExcel, opcionAlumno2 vistaTabla) {
        try (Workbook workbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook(new FileInputStream(archivoExcel))) {
            Sheet hoja = workbook.getSheetAt(0);
            AlumnoContr controlador = new AlumnoContr();

            int total = hoja.getLastRowNum();
            int procesados = 0;
            int importados = 0;

            for (Row fila : hoja) {
                if (cancelado) break;
                if (fila.getRowNum() == 0) continue;

                String numeroControl = controlador.obtenerValorCelda(fila.getCell(3));
                boolean vacia = controlador.obtenerValorCelda(fila.getCell(0)).isEmpty()
                        && controlador.obtenerValorCelda(fila.getCell(1)).isEmpty()
                        && controlador.obtenerValorCelda(fila.getCell(2)).isEmpty()
                        && numeroControl.isEmpty();

                if (!vacia && !controlador.existeNumeroControl(numeroControl)) {
                    controlador.guardarFilaManual(fila);
                    importados++;
                }

                procesados++;
                int porcentaje = (int) ((double) procesados / total * 100);
                barraProgreso.setValue(Math.min(porcentaje, 100));
                texto.setText("Importando: " + procesados + " / " + total);
                Thread.sleep(50);
            }

            if (cancelado) {
                JOptionPane.showMessageDialog(this, "⚠️ Importación cancelada por el usuario.", "Cancelado", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "✅ Se importaron " + importados + " alumno(s).", "Completado", JOptionPane.INFORMATION_MESSAGE);
                SwingUtilities.invokeLater(vistaTabla::actualizarTabla);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            dispose();
        }
    }
}
