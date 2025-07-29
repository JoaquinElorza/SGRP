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
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


public class DocumentosAlumno {
   
    public static boolean subirDocumentoAlumno(String nControl, String nuevoNombre,
            Component parentComponent) throws SQLException{
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
                return true;
            } else {
                System.out.println("Hubo un error al subir el documento.");
                return false;
            }
        }
return false;
    }

    public static boolean archivoYaSubido(String nControl) throws IOException{
        File carpeta = new File("C:\\SGRP\\" + nControl);
        if(carpeta.exists() && carpeta.isDirectory()){
        Path directorio = Paths.get("C:\\SGRP\\" + nControl);
        
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directorio)) {

        for (Path archivo : stream) {
            String nombreArchivo = archivo.getFileName().toString();
            if (nombreArchivo.startsWith("Solicitud de residencia")) {
                return true;
            }
        }
    }
        }
         return false;
    }
    
    
    public static void eliminarArchivo(String nombreSinExtension, Path directorio,
            String nControl) throws SQLException{
        
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
    
    public static void generarPDFPendientes(Map<String, List<String>> data) throws Exception {
    String escritorio = System.getProperty("user.home") + File.separator + "Desktop";
    String ruta = escritorio + File.separator + "documentos_pendientes.pdf";
    PdfWriter writer = new PdfWriter(ruta);

    LocalDateTime hoy = LocalDateTime.now(); 
        
    PdfDocument pdf = new PdfDocument(writer);
    Document document = new Document(pdf);

    document.add(new Paragraph(hoy.getDayOfMonth() + " de " + hoy.getMonth() + " de "
            + hoy.getYear()));
    document.add(new Paragraph("Lista de alumnos de residencia profesional con documentos"
            + "faltantes")
                        .setFontSize(14));
    
    for (Map.Entry<String, List<String>> entry : data.entrySet()) {
        String nControl = entry.getKey();
        List<String> docs = entry.getValue();

        // Escribir el encabezado del alumno
        document.add(new Paragraph(nControl)
                        .setFontSize(14));

        // Agregar lista de documentos
        for (String doc : docs) {
            document.add(new Paragraph("• " + doc));
        }

        document.add(new Paragraph("\n")); // Espacio entre alumnos
    }

    document.close();
    JOptionPane.showMessageDialog(null, "Reporte generado en el escritorio");
    System.out.println("PDF generado correctamente.");
}

}
