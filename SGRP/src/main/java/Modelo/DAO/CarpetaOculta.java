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


    
    public static String getExtension(File file) {
        String nombre = file.getName();
        int i = nombre.lastIndexOf('.');
        if (i > 0 && i < nombre.length() - 1) {
            return nombre.substring(i + 1).toLowerCase(); // "pdf", "jpg", etc.
        } else {
            return ""; // No tiene extensión
        }
    }
    
    
    // Copiar un archivo PDF a la carpeta del alumno
    public static boolean copiarArchivoPDF(File archivoOriginal, String numeroControl,
            String nuevoNombre, Component parentComponent) {

        String ext ="." + getExtension(archivoOriginal);
        
        if(!ext.equalsIgnoreCase(".PDF") &&
           !ext.equalsIgnoreCase(".PNG") &&
           !ext.equalsIgnoreCase(".JPG")){
            System.out.println("formato de archivo invalido");
            return false;
        }else{

        // Crear carpeta del alumno si no existe
        File carpetaAlumno = new File(RUTA_BASE + "\\" + numeroControl);
        if (!carpetaAlumno.exists()) {
            carpetaAlumno.mkdir();
        }

        // Definir ruta destino
        Path origen = archivoOriginal.toPath();
        nuevoNombre+=ext;
        Path destino = Paths.get(carpetaAlumno.getAbsolutePath(), nuevoNombre);

            if (Files.exists(destino)) {
        int opcion = JOptionPane.showConfirmDialog(
            parentComponent,
            "Ya has subido ese documento\n¿Deseas reemplazarlo?",
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
    }
    
    public static void abrirPDF(String nombreSinExtension, String carpeta) {
           File directorio = new File(carpeta);

           if (directorio.exists() && directorio.isDirectory()) {
               File[] archivos = directorio.listFiles();

               if (archivos != null) {
                   for (File archivo : archivos) {
                       // Compara el nombre del archivo sin la extensión
                       String nombreArchivo = archivo.getName();
                       int punto = nombreArchivo.lastIndexOf('.');
                       if (punto > 0) {
                           String nombreSinExt = nombreArchivo.substring(0, punto);
                           if (nombreSinExt.equals(nombreSinExtension)) {
                               try {
                                   Desktop.getDesktop().open(archivo);
                                   return;
                               } catch (Exception e) {
                                   e.printStackTrace();
                                   System.out.println("No se pudo abrir el archivo.");
                                   return;
                               }
                           }
                       }
                   }
               }
    }}
    
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
    
 /*   public static boolean renombrarCarpeta(String nControlA, String nControlB){
        File oldNombre = new File (RUTA_BASE + "\\" + nControlA);
        if(oldNombre.exists()){
            File newNombre = new File(RUTA_BASE + "\\" + nControlB);
            
            if (oldNombre.renameTo(newNombre)) {
                System.out.println("archivo renombrado");
                return true;
            } else {
                System.out.println("error al renombrar");
            }   
        }
        System.out.println("No se ha creado la carpeta para renombrarla");
        return false;
    }
*/
    
    }

