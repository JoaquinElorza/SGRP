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
        int rechazados = 0;

        for (Row fila : hoja) {
            if (cancelado) break;
            if (fila.getRowNum() == 0) continue;

            String nombre         = controlador.obtenerValorCelda(fila.getCell(0));
            String apPaterno      = controlador.obtenerValorCelda(fila.getCell(1));
            String apMaterno      = controlador.obtenerValorCelda(fila.getCell(2));
            String numeroControl  = controlador.obtenerValorCelda(fila.getCell(3));
            String correo         = controlador.obtenerValorCelda(fila.getCell(4));
            String telefono       = controlador.obtenerValorCelda(fila.getCell(5));

            boolean vacia = nombre.isEmpty() && apPaterno.isEmpty() &&
                            apMaterno.isEmpty() && numeroControl.isEmpty();

            boolean datosValidos = 
                nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") &&
                apPaterno.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") &&
                apMaterno.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") &&
                telefono.matches("\\d{10}");

            if (vacia || !datosValidos || controlador.existeNumeroControl(numeroControl)) {
                rechazados++;
                continue;
            }

            controlador.guardarFilaManual(fila);
            importados++;

            procesados++;
            int porcentaje = (int) ((double) procesados / total * 100);
            barraProgreso.setValue(Math.min(porcentaje, 100));
            texto.setText("Importando: " + procesados + " / " + total);
            Thread.sleep(50);
        }

        if (cancelado) {
            JOptionPane.showMessageDialog(this, "⚠️ Importación cancelada por el usuario.", "Cancelado", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                "✅ Se importaron " + importados + " alumno(s).\n" +
                "⛔ Rechazados por datos inválidos o duplicados: " + rechazados,
                "Resultado de importación", JOptionPane.INFORMATION_MESSAGE);
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
