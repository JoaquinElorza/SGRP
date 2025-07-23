package Controlador;

import Modelo.DAO.CarpetaOculta;
import java.awt.Component;
import java.io.File;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DocumentosAlumno {
   
    public static void subirDocumentoAlumno(String nControl, String nuevoNombre, Component parentComponent){
        CarpetaOculta.crearCarpetaBaseOculta();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
        int resultado = chooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = chooser.getSelectedFile();
            String numeroControl = nControl;

            boolean exito = CarpetaOculta.copiarArchivoPDF(archivoSeleccionado, numeroControl,
                    nuevoNombre, parentComponent); 
            if (exito) {
                JOptionPane.showMessageDialog(null, "Documento subido exitosamente.");
            } else {
                System.out.println("Hubo un error al subir el documento.");
            }
        }

    }

    public static void eliminarArchivo(Path archivo){
              int opcion = JOptionPane.showConfirmDialog(
            null,
            "¿Estás seguro de que deseas eliminar este documento?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (opcion == JOptionPane.YES_OPTION) {
            boolean eliminado = CarpetaOculta.eliminarArchivo(archivo);
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Archivo eliminado correctamente.");
            }
        }
    }
    
}
