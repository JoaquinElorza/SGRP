package Vista;

import Controlador.AlumnoContr;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class CargarPanel extends JFrame {

    public CargarPanel() {
        setTitle("Importar alumnos desde Excel");
        setSize(350, 100);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton boton = new JButton("Seleccionar archivo Excel");

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selector = new JFileChooser();
                int resultado = selector.showOpenDialog(null);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File archivo = selector.getSelectedFile();
                    AlumnoContr controlador = new AlumnoContr();
                    int cantidad = controlador.importarDesdeExcel(archivo);
                    JOptionPane.showMessageDialog(null, "Se importaron " + cantidad + " alumnos correctamente.");
                }
            }
        });

        add(boton);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CargarPanel();
    }
}

