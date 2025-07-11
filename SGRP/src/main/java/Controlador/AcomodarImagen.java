package Controlador;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AcomodarImagen {

    public void configurarPanelConImagen(String rutaImagen, JPanel panelDestino) {
        // Cargar imagen como recurso
        URL ruta = getClass().getResource(rutaImagen);
        if (ruta == null) {
            System.err.println("No se encontró la imagen: " + rutaImagen);
            return;
        }

        ImageIcon iconoOriginal = new ImageIcon(ruta);
        Image imagenOriginal = iconoOriginal.getImage();

        // Configurar el panel de destino con BorderLayout
        panelDestino.setLayout(new BorderLayout());

        // Crear JLabel con imagen escalable
        JLabel labelImagen = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagenOriginal != null) {
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    int panelWidth = getWidth();
                    int panelHeight = getHeight();
                    int imgWidth = imagenOriginal.getWidth(null);
                    int imgHeight = imagenOriginal.getHeight(null);

                    double escala = Math.min((double) panelWidth / imgWidth, (double) panelHeight / imgHeight);
                    int anchoEscalado = (int) (imgWidth * escala);
                    int altoEscalado = (int) (imgHeight * escala);

                    int x = (panelWidth - anchoEscalado) / 2;
                    int y = (panelHeight - altoEscalado) / 2;

                    g2.drawImage(imagenOriginal, x, y, anchoEscalado, altoEscalado, this);
                }
            }
        };

        panelDestino.add(labelImagen, BorderLayout.CENTER);
        panelDestino.revalidate();
        panelDestino.repaint();
    }
}
