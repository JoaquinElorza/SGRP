package Vista;

import Controlador.AlumnoContr;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class CargarPanel extends JFrame {

    public CargarPanel(opcionAlumno2 vistaTabla) {
        setTitle("Importar alumnos desde Excel");
        setSize(350, 120);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton botonSeleccionar = new JButton("Seleccionar archivo Excel");

        botonSeleccionar.addActionListener(e -> {
            JFileChooser selector = new JFileChooser();
            int resultado = selector.showOpenDialog(null);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = selector.getSelectedFile();
                VentanaCargaProgreso progreso = new VentanaCargaProgreso(this, archivo, vistaTabla);
                progreso.setVisible(true);
            }
        });

        setLayout(new BorderLayout());
        add(botonSeleccionar, BorderLayout.CENTER);
        setVisible(true);
    }
}
