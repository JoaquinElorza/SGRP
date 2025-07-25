package Controlador;

import Modelo.DAO.CarpetaOculta;
import Modelo.DAO.DocumentoDao;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class DocumentosAlumno {
   
    public static void subirDocumentoAlumno(String nControl, String nuevoNombre,
            Component parentComponent){
        CarpetaOculta.crearCarpetaBaseOculta();
        JFileChooser chooser = new JFileChooser();
     //   chooser.setFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
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

    public static boolean archivoYaSubido(String nControl) throws IOException{
        Path directorio = Paths.get("C:\\SGRP\\" + nControl);
         try (DirectoryStream<Path> stream = Files.newDirectoryStream(directorio)) {

        for (Path archivo : stream) {
            String nombreArchivo = archivo.getFileName().toString();
            if (nombreArchivo.startsWith("Solicitud de residencia")) {
                return true;
            }
        }
    }
         return false;
    }
    
    
    public static void eliminarArchivo(String nombreSinExtension, Path directorio, String nControl) throws SQLException{
        
         try (DirectoryStream<Path> stream = Files.newDirectoryStream(directorio)) {
        boolean encontrado = false;

        for (Path archivo : stream) {
            String nombreArchivo = archivo.getFileName().toString();
            
            // Compara solo el nombre sin extensión
            if (nombreArchivo.startsWith(nombreSinExtension + ".")) {
                encontrado = true;

                int opcion = JOptionPane.showConfirmDialog(
                    null,
                    "¿Estás seguro de que deseas eliminar este documento?\n" + nombreArchivo,
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
                );

                if (opcion == JOptionPane.YES_OPTION) {
                    boolean eliminado = CarpetaOculta.eliminarArchivo(archivo);
                    if (eliminado) {
                        JOptionPane.showMessageDialog(null, "Archivo eliminado correctamente: " + nombreArchivo);
                        DocumentoDao.setEstadoDocumento(nControl, false, nombreSinExtension);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar: " + nombreArchivo);
                    }
                }
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo: " + nombreSinExtension);
        }

    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al acceder al directorio.");
    }
    }
    
}
