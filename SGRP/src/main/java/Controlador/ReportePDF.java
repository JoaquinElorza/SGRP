/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author emili
 */
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import Modelo.Entidades.Proyecto;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ReportePDF {

    public static void generarReporte(List<Proyecto> proyectos, int año, int semestre) throws IOException {
        String nombreArchivo = "ReporteProyectos_" + año + "_S" + semestre + ".pdf";
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();

            Paragraph titulo = new Paragraph(
                "Reporte de Proyectos - " + (semestre == 1 ? "Enero-Junio" : "Julio-Diciembre") + " " + año,
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)
            );
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(titulo);
            document.add(new Paragraph(" ")); // Espacio

            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Nombre");
            tabla.addCell("Descripción");
            tabla.addCell("Empresa");

            for (Proyecto p : proyectos) {
                tabla.addCell(p.getNombre());
                tabla.addCell(p.getDescripcion());
                tabla.addCell(p.getEmpresa().getNombre());
            }

            document.add(tabla);
            document.close();

            System.out.println("📄 PDF generado correctamente: " + nombreArchivo);

        } catch (DocumentException | java.io.IOException e) {
            e.printStackTrace();
        }
        java.awt.Desktop.getDesktop().open(new File(nombreArchivo));

    }
}