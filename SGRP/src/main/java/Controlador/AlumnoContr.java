
package Controlador;

import Modelo.DAO.AlumnoCarg;
import Modelo.DAO.AlumnoDAO;
import Utilidades.Conexion;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.List;

public class AlumnoContr {

    public int importarDesdeExcel(File archivoExcel) {
        int contador = 0;
        try (FileInputStream fis = new FileInputStream(archivoExcel);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet hoja = workbook.getSheetAt(0);
            for (Row fila : hoja) {
                if (fila.getRowNum() == 0) continue; // Saltar encabezados

                String nombre = obtenerValorCelda(fila.getCell(0));
                String apPaterno = obtenerValorCelda(fila.getCell(1));
                String apMaterno = obtenerValorCelda(fila.getCell(2));
                String numeroControl = obtenerValorCelda(fila.getCell(3));
                String correo = obtenerValorCelda(fila.getCell(4));
                String telefono = obtenerValorCelda(fila.getCell(5));

                try (Connection conn = Conexion.getConexion()) {
                    conn.setAutoCommit(false);

                    String sqlPersona = "INSERT INTO persona (nombre, ap_paterno, ap_materno) VALUES (?, ?, ?)";
                    PreparedStatement psPersona = conn.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);
                    psPersona.setString(1, nombre);
                    psPersona.setString(2, apPaterno);
                    psPersona.setString(3, apMaterno);
                    psPersona.executeUpdate();

                    ResultSet rs = psPersona.getGeneratedKeys();
                    int idPersona = -1;
                    if (rs.next()) {
                        idPersona = rs.getInt(1);
                    }

                    String sqlAlumno = "INSERT INTO alumno (n_control, telefono, fk_persona, correo) VALUES (?, ?, ?, ?)";
                    PreparedStatement psAlumno = conn.prepareStatement(sqlAlumno);
                    psAlumno.setString(1, numeroControl);
                    psAlumno.setString(2, telefono);
                    psAlumno.setInt(3, idPersona);
                    psAlumno.setString(4, correo);
                    psAlumno.executeUpdate();

                    conn.commit();
                    contador++;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return contador;
    }

    public String obtenerValorCelda(Cell celda) {
        if (celda == null) return "";
        switch (celda.getCellType()) {
            case STRING: return celda.getStringCellValue();
            case NUMERIC: return String.valueOf((long) celda.getNumericCellValue());
            case BOOLEAN: return String.valueOf(celda.getBooleanCellValue());
            case FORMULA:
                try { return celda.getStringCellValue(); }
                catch (Exception e) { return String.valueOf(celda.getNumericCellValue()); }
            default: return "";
        }
    }

    private void guardarAlumnoEnBD(AlumnoCarg alumno) {
        String sql = "INSERT INTO alumnos (nombre, apellido_paterno, apellido_materno, numero_control, correo_electronico, numero_telefono, proyecto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellidoPaterno());
            ps.setString(3, alumno.getApellidoMaterno());
            ps.setString(4, alumno.getNumeroControl());
            ps.setString(5, alumno.getCorreoElectronico());
            ps.setString(6, alumno.getNumeroTelefono());
            ps.setString(7, alumno.getProyecto());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existeNumeroControl(String numeroControl) {
        String sql = "SELECT COUNT(*) FROM alumnos WHERE numero_control = ?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, numeroControl);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void guardarFilaManual(Row fila) {
        AlumnoCarg alumno = new AlumnoCarg();
        alumno.setNombre(obtenerValorCelda(fila.getCell(0)));
        alumno.setApellidoPaterno(obtenerValorCelda(fila.getCell(1)));
        alumno.setApellidoMaterno(obtenerValorCelda(fila.getCell(2)));
        alumno.setNumeroControl(obtenerValorCelda(fila.getCell(3)));
        alumno.setCorreoElectronico(obtenerValorCelda(fila.getCell(4)));
        alumno.setNumeroTelefono(obtenerValorCelda(fila.getCell(5)));
        alumno.setProyecto(obtenerValorCelda(fila.getCell(6)));

        if (!alumno.getNumeroControl().isEmpty() && !existeNumeroControl(alumno.getNumeroControl())) {
            guardarAlumnoEnBD(alumno);
        }
    }

    public boolean agregarAlumnoManual(String nombre, String apellidoP, String apellidoM, String numeroControl, String correo, String telefono, String proyecto) {
        if (existeNumeroControl(numeroControl)) {
            JOptionPane.showMessageDialog(null,
                    "❌ Ya existe un alumno con el número de control: " + numeroControl,
                    "Duplicado",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        AlumnoCarg alumno = new AlumnoCarg();
        alumno.setNombre(nombre);
        alumno.setApellidoPaterno(apellidoP);
        alumno.setApellidoMaterno(apellidoM);
        alumno.setNumeroControl(numeroControl);
        alumno.setCorreoElectronico(correo);
        alumno.setNumeroTelefono(telefono);
        alumno.setProyecto(proyecto);

        guardarAlumnoEnBD(alumno);
        return true;
    }

    public void actualizarTablaAlumnos(JTable tablaAlumnos) {
        AlumnoDAO dao = new AlumnoDAO();
        List<AlumnoCarg> lista = dao.obtenerTodosLosAlumnos();
        DefaultTableModel model = (DefaultTableModel) tablaAlumnos.getModel();
        model.setRowCount(0);

        for (AlumnoCarg a : lista) {
            String nombreCompleto = a.getNombre() + " " + a.getApellidoPaterno() + " " + a.getApellidoMaterno();
            model.addRow(new Object[]{ a.getNumeroControl(), nombreCompleto });
        }
    }
}