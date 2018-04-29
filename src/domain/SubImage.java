package domain;

import java.awt.image.BufferedImage;

/**
 * @author Marco
 */
public class SubImage {
    
    /**
     * Atributos
     */
    private int degrees;
    private int coordX;
    private int coordY;
    private BufferedImage image;

    /**
     * Constructor
     */
    
    public SubImage(int cordX, int cordY, BufferedImage image){
        this.coordX = cordX;
        this.coordY = cordY;
        this.image = image;
    }
    
    public SubImage(){
        this.coordX = 0;
        this.coordY = 0;
        this.image = null;
    }
    
    /**
     * Métodos constructores
     */

    /**
     * @return the coordX
     */
    public int getCoordX() {
        return coordX;
    }

    /**
     * @param coordX the coordX to set
     */
    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    /**
     * @return the coordY
     */
    public int getCoordY() {
        return coordY;
    }

    /**
     * @param coordY the coordY to set
     */
    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    /**
     * @return the image
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

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
    }

    
    
}
