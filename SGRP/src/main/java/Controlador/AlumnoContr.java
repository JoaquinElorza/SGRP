package Controlador;

import Modelo.DAO.AlumnoCarg;
import Modelo.DAO.AlumnoDAO;
import Utilidades.Conexion;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.List;

public class AlumnoContr {

    public int importarDesdeExcel(File archivoExcel, JTable tablaAlumnos) {
        int importados = 0;
        int duplicados = 0;

        try (FileInputStream fis = new FileInputStream(archivoExcel);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet hoja = workbook.getSheetAt(0);
            for (Row fila : hoja) {
                if (fila.getRowNum() == 0) continue;

                String nombre         = obtenerValorCelda(fila.getCell(0));
                String apPaterno      = obtenerValorCelda(fila.getCell(1));
                String apMaterno      = obtenerValorCelda(fila.getCell(2));
                String numeroControl  = obtenerValorCelda(fila.getCell(3));
                String correo         = obtenerValorCelda(fila.getCell(4));
                String telefono       = obtenerValorCelda(fila.getCell(5));

                if (numeroControl.isEmpty()) continue;

                if (existeNumeroControl(numeroControl)) {
                    duplicados++;
                    continue;
                }

                try (Connection conn = Conexion.getConexion()) {
                    conn.setAutoCommit(false);

                    String sqlPersona = "INSERT INTO persona (nombre, ap_paterno, ap_materno, status) VALUES (?, ?, ?, ?)";
                    PreparedStatement psPersona = conn.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);
                    psPersona.setString(1, nombre);
                    psPersona.setString(2, apPaterno);
                    psPersona.setString(3, apMaterno);
                    psPersona.setString(4, "A");
                    psPersona.executeUpdate();

                    ResultSet rs = psPersona.getGeneratedKeys();
                    int idPersona = rs.next() ? rs.getInt(1) : -1;

                    String sqlAlumno = "INSERT INTO alumno (n_control, telefono, fk_persona, correo) VALUES (?, ?, ?, ?)";
                    PreparedStatement psAlumno = conn.prepareStatement(sqlAlumno);
                    psAlumno.setString(1, numeroControl);
                    psAlumno.setString(2, telefono);
                    psAlumno.setInt(3, idPersona);
                    psAlumno.setString(4, correo);
                    psAlumno.executeUpdate();

                    conn.commit();
                    importados++;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null,
            "✅ Importados: " + importados + "\n⛔ Duplicados: " + duplicados);

        actualizarTablaAlumnos(tablaAlumnos);
        return importados;
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

    public boolean existeNumeroControl(String numeroControl) {
        String sql = "SELECT COUNT(*) FROM alumno a JOIN persona p ON a.fk_persona = p.id_persona WHERE a.n_control = ? AND p.status = 'A'";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, numeroControl);
            ResultSet rs = ps.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean agregarAlumnoManual(String nombre, String apellidoP, String apellidoM,
                                       String numeroControl, String correo, String telefono) {
        if (existeNumeroControl(numeroControl)) {
            JOptionPane.showMessageDialog(null,
                    "⛔ Ya existe un alumno con el número de control: " + numeroControl);
            return false;
        }

        AlumnoCarg alumno = new AlumnoCarg();
        alumno.setNombre(nombre);
        alumno.setApellidoPaterno(apellidoP);
        alumno.setApellidoMaterno(apellidoM);
        alumno.setNumeroControl(numeroControl);
        alumno.setCorreoElectronico(correo);
        alumno.setNumeroTelefono(telefono);

        guardarAlumnoEnBD(alumno);
        return true;
    }

    private void guardarAlumnoEnBD(AlumnoCarg alumno) {
        try (Connection conn = Conexion.getConexion()) {
            conn.setAutoCommit(false);

            String sqlPersona = "INSERT INTO persona (nombre, ap_paterno, ap_materno, status) VALUES (?, ?, ?, ?)";
            PreparedStatement psPersona = conn.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);
            psPersona.setString(1, alumno.getNombre());
            psPersona.setString(2, alumno.getApellidoPaterno());
            psPersona.setString(3, alumno.getApellidoMaterno());
            psPersona.setString(4, "A");
            psPersona.executeUpdate();

            ResultSet rs = psPersona.getGeneratedKeys();
            int idPersona = rs.next() ? rs.getInt(1) : -1;

            String sqlAlumno = "INSERT INTO alumno (n_control, telefono, fk_persona, correo) VALUES (?, ?, ?, ?)";
            PreparedStatement psAlumno = conn.prepareStatement(sqlAlumno);
            psAlumno.setString(1, alumno.getNumeroControl());
            psAlumno.setString(2, alumno.getNumeroTelefono());
            psAlumno.setInt(3, idPersona);
            psAlumno.setString(4, alumno.getCorreoElectronico());
            psAlumno.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void guardarFilaManual(Row fila) {
    String nombre         = obtenerValorCelda(fila.getCell(0));
    String apPaterno      = obtenerValorCelda(fila.getCell(1));
    String apMaterno      = obtenerValorCelda(fila.getCell(2));
    String numeroControl  = obtenerValorCelda(fila.getCell(3));
    String correo         = obtenerValorCelda(fila.getCell(4));
    String telefono       = obtenerValorCelda(fila.getCell(5));

    if (numeroControl.isEmpty()) return;
    if (existeNumeroControl(numeroControl)) return;

    AlumnoCarg alumno = new AlumnoCarg(nombre, apPaterno, apMaterno, numeroControl, correo, telefono);
    guardarAlumnoEnBD(alumno);
}

    public void actualizarTablaAlumnos(JTable tablaAlumnos) {
        AlumnoDAO dao = new AlumnoDAO();
        List<AlumnoCarg> lista = dao.obtenerTodosLosAlumnos();
        DefaultTableModel model = (DefaultTableModel) tablaAlumnos.getModel();
        model.setRowCount(0);

        for (AlumnoCarg a : lista) {
            String nombreCompleto = a.getNombre() + " " + a.getApellidoPaterno() + " " + a.getApellidoMaterno();
            model.addRow(new Object[]{a.getNumeroControl(), nombreCompleto});
        }
    }
}
