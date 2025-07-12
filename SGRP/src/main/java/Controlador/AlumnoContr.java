package Controlador;

import Modelo.DAO.AlumnoCarg;
import Modelo.DAO.Conexx;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlumnoContr {

    public int importarDesdeExcel(File archivoExcel) {
        int contador = 0;
        try (FileInputStream fis = new FileInputStream(archivoExcel);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet hoja = workbook.getSheetAt(0);
            for (Row fila : hoja) {
                if (fila.getRowNum() == 0) continue;

                AlumnoCarg alumno = new AlumnoCarg();
                alumno.setNombre(obtenerValorCelda(fila.getCell(0)));
                alumno.setApellidoPaterno(obtenerValorCelda(fila.getCell(1)));
                alumno.setApellidoMaterno(obtenerValorCelda(fila.getCell(2)));
                alumno.setNumeroControl(obtenerValorCelda(fila.getCell(3)));
                alumno.setCorreoElectronico(obtenerValorCelda(fila.getCell(4)));
                alumno.setNumeroTelefono(obtenerValorCelda(fila.getCell(5)));

                // Validar si la fila contiene al menos algún dato útil
                boolean filaValida = !alumno.getNombre().isEmpty()
                    || !alumno.getApellidoPaterno().isEmpty()
                    || !alumno.getApellidoMaterno().isEmpty()
                    || !alumno.getNumeroControl().isEmpty()
                    || !alumno.getCorreoElectronico().isEmpty()
                    || !alumno.getNumeroTelefono().isEmpty();

                if (!filaValida) continue;

                guardarAlumnoEnBD(alumno);
                contador++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contador;
    }

    private String obtenerValorCelda(Cell celda) {
        if (celda == null) return "";
        switch (celda.getCellType()) {
            case STRING:
                return celda.getStringCellValue();
            case NUMERIC:
                return String.valueOf((long) celda.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(celda.getBooleanCellValue());
            case FORMULA:
                try {
                    return celda.getStringCellValue();
                } catch (Exception e) {
                    return String.valueOf(celda.getNumericCellValue());
                }
            default:
                return "";
        }
    }

    private void guardarAlumnoEnBD(AlumnoCarg alumno) {
        String sql = "INSERT INTO alumnos (nombre, apellido_paterno, apellido_materno, numero_control, correo_electronico, numero_telefono) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexx.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellidoPaterno());
            ps.setString(3, alumno.getApellidoMaterno());
            ps.setString(4, alumno.getNumeroControl());
            ps.setString(5, alumno.getCorreoElectronico());
            ps.setString(6, alumno.getNumeroTelefono());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
