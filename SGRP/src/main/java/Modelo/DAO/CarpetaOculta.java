package Modelo.DAO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.DosFileAttributeView;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.Desktop;


public class CarpetaOculta {

    private static final String RUTA_BASE = "C:\\SGRP";

    // Crea la carpeta base oculta si no existe
    public static void crearCarpetaBaseOculta() {
        File carpeta = new File(RUTA_BASE);
        if (!carpeta.exists()) {
            boolean creada = carpeta.mkdir();
            if (creada) {
                try {
                    Path path = carpeta.toPath();
                    DosFileAttributeView attr = Files.getFileAttributeView(path, DosFileAttributeView.class);
                    if (attr != null) {
                        attr.setHidden(true);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // Copiar un archivo PDF a la carpeta del alumno
    public static boolean copiarArchivoPDF(File archivoOriginal, String numeroControl,
            String nuevoNombre, Component parentComponent) {
 
        if (!archivoOriginal.getName().toLowerCase().endsWith(".pdf")) {
            System.out.println("El archivo debe ser .PDF");
            return false;
        }

        // Crear carpeta del alumno si no existe
        File carpetaAlumno = new File(RUTA_BASE + "\\" + numeroControl);
        if (!carpetaAlumno.exists()) {
            carpetaAlumno.mkdir();
        }

        // Definir ruta destino
        Path origen = archivoOriginal.toPath();
        nuevoNombre+=".pdf";
        Path destino = Paths.get(carpetaAlumno.getAbsolutePath(), nuevoNombre);

            if (Files.exists(destino)) {
        int opcion = JOptionPane.showConfirmDialog(
            parentComponent,
            "Ya existe un archivo llamado \"" + nuevoNombre + "\".\n¿Deseas reemplazarlo?",
            "Archivo existente",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (opcion != JOptionPane.YES_OPTION) {
            return false; // Usuario eligió NO
        }
    }
        
        
        try {
            // REEMPLAZA si ya existe uno con el mismo nombre
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiado correctamente.");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void abrirPDF(Path archivo) {
        try {
            if (Files.exists(archivo)) {
                Desktop.getDesktop().open(archivo.toFile());
            } else {
                JOptionPane.showMessageDialog(null, "No se ha subido este documento o ha sido eliminado");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo: " + e.getMessage());
        }
    }
    
    public static boolean eliminarArchivo(Path archivo) {
        try {
            if (Files.exists(archivo)) {
                Files.delete(archivo);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "El archivo no existe.");
                return false;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el archivo: " + e.getMessage());
            return false;
        }
    }
    
    }

