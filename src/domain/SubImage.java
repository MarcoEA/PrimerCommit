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
    

    public int getCoordX() {
        return coordX;
    }


    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }


    public int getCoordY() {
        return coordY;
    }


    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }


    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }


    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

    
    
}
