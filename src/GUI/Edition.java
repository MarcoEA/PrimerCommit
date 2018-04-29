package GUI;

import domain.SubImage;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * @author Marco
 */
public class Edition extends JPanel {

    /**
     * Componentes
     */
    Graphics2D graphics2D;
    public static BufferedImage subImageTemp;
    public static SubImage subImage;
    public static int degrees;
    

    /**
     * Constructor
     */
    public Edition() {
        this.setLayout(null);
        this.setBackground(Color.white);
        this.degrees = 0;
    }

    /**
     * Método que permite editar la subImagen creando una rotación con respecto
     * a los grados que se le indique
     */
    public void paintEdition(Graphics2D graphics2D) throws AWTException {
        if (subImageTemp != null) {
            AffineTransform rotation = new AffineTransform();
            //Asiganción de grados para rotar
            rotation.rotate(Math.toRadians(this.getDegrees()), 
                    MainWindow.creation.sizeGrid / 2,
                    MainWindow.creation.sizeGrid / 2);
            graphics2D.setTransform(rotation);
            graphics2D.drawImage(subImageTemp, 0, 0, MainWindow.creation.sizeGrid,
                    MainWindow.creation.sizeGrid, null);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.graphics2D = (Graphics2D) g;
        try {
            this.paintEdition(graphics2D);
        } catch (AWTException ex) {
        }
    }
    /**
     *Método que pinta las subImagenes
     *@param subImage contiene la subImagen para pintar 
     */ 
    public void paintSubImage(SubImage subImage) {
        this.subImage = subImage;
        subImageTemp = this.subImage.getImage();
        repaint();
    }

    /**
     * Métodos accesores
     */
    /**
     * @return the degrees
     */
    public int getDegrees() {
        return degrees;
    }

    /**
     * @param degrees the degrees to set
     */
    public void setDegrees(int degrees) {
        this.degrees = degrees;
        repaint();
    }

}
