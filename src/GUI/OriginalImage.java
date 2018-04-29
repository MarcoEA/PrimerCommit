package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 *
 * @author Marco
 */
public class OriginalImage extends JPanel implements MouseListener, Serializable{
    
    /**
     * Componentes
     */
    public Graphics2D graphics2D;
    public BufferedImage bufferedImage;
    public static BufferedImage subImage;
    private URL url;
    public static ArrayList<BufferedImage> imageLonding = new ArrayList<>();
    /**
     * Constructor
     */
    public OriginalImage(){
        this.addMouseListener(this);
        this.bufferedImage = null;
    }

    /**
     * Método que pinta las líneas que dividirá la imagen que se cargue en
     * cuadrículas del tamaño antes ingresado por el usuario.
     * @param graphics2D 
     */
    private void paintOriginalImage(Graphics2D graphics2D){  
        //Se pinta la imagen original en el panel.
        graphics2D.drawImage(this.getBufferedImage(), 0, 0, null);
        //For que pinta las lineas horizontales para la creación de las cuadriculas
        //con el tamaño antes indicado por el usuario
        for(int i=MainWindow.creation.sizeGrid; i<getBufferedImage().getWidth();
                i+=MainWindow.creation.sizeGrid) {
            graphics2D.drawLine(i, 0, i, getBufferedImage().getHeight());
        }
        //For que pinta las lineas verticales para la creación de las cuadriculas
        //con el tamaño antes indicado por el usuario
        for(int i=MainWindow.creation.sizeGrid; i<getBufferedImage().getHeight(this);
                i+=MainWindow.creation.sizeGrid) {
            graphics2D.drawLine(0, i, getBufferedImage().getWidth(), i);
        }     
         
    }
   
    /**
     * Método que se encarga de inicializar la variable Graphics2D y llamar
     * al método paintOriginalImage.
     * @param g: Graphics.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.graphics2D = (Graphics2D)g;
        this.paintOriginalImage(graphics2D);  
    }
    
    /**
     * Método que permite cargar una imagen desde el sistema
     * para ser utilizada en la creación del mosaico.
     */
    public void loandingImage(){
        
        try{   
            this.bufferedImage = ImageIO.read(this.getUrl());
        } catch (IOException ex) {
        }   
        this.setPreferredSize(new Dimension(bufferedImage.getWidth(),
                bufferedImage.getHeight()));
        imageLonding.add(bufferedImage);
        
    }
    
    /**
     * Método que crea las dimensiones del panel de acuerdo a las que posea
     * la imagen, además agrega la imagen al arrayList de tipo BufferedImage
     * el cual será utilizado para guardar el proyecto.
     */
    public void createImage () {
        this.setPreferredSize(new Dimension(bufferedImage.getWidth(),
                bufferedImage.getHeight()));
        imageLonding.add(bufferedImage);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        int tempX, tempY;
        //Se recorre la imagen para detectar cual cuadrícula fue la que
        //se seleccionó.
        for(int i=0; i<getBufferedImage().getHeight();
                i+=MainWindow.creation.sizeGrid){
            tempY = i+MainWindow.creation.sizeGrid;
            for(int j=0; j<getBufferedImage().getWidth();
                    j+=MainWindow.creation.sizeGrid) {
               tempX = j+MainWindow.creation.sizeGrid;
               //Si las posiciones sobre la cual se hizo click se encuentran
               //dentro del rango dela cuadrícula.
                if(me.getX() >= j && me.getX() <= tempX && me.getY() >= i &&
                       me.getY() <= tempY) {
                    //Se verifica si la cuadricula seleccionada debe tener el
                    //correspondiente ya que en ocasiones ciertas cuadrículas
                    //deberán ser de menor tamaño (principalmente las de los
                    //bordes de la imagen).
                    if(tempY > getBufferedImage().getHeight() && tempX > 
                            getBufferedImage().getWidth()){
                        subImage = getBufferedImage().getSubimage(j, i,
                                MainWindow.creation.sizeGrid-
                                        (tempX-getBufferedImage().getWidth()),
                                MainWindow.creation.sizeGrid-
                                        (tempY-getBufferedImage().getHeight()));
                        
                    } else if(tempY > getBufferedImage().getHeight()) {
                        subImage = getBufferedImage().getSubimage(j, i, 
                                MainWindow.creation.sizeGrid,
                                MainWindow.creation.sizeGrid-
                                        (tempY-getBufferedImage().getHeight()));
                        
                    } else if(tempX > getBufferedImage().getWidth()){
                        subImage = getBufferedImage().getSubimage(j, i,
                                MainWindow.creation.sizeGrid-
                                        (tempX-getBufferedImage().getWidth()),
                                MainWindow.creation.sizeGrid);
                    } else {
                        subImage = getBufferedImage().getSubimage(j, i,
                                MainWindow.creation.sizeGrid,
                                MainWindow.creation.sizeGrid);
                    }
                }
            } 
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    /**
     * @return the bufferedImage
     */
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    /**
     * @param bufferedImage the bufferedImage to set
     */
    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        this.setPreferredSize(new Dimension(bufferedImage.getWidth(),
                bufferedImage.getHeight()));
        //se llena un ArrayList con las imágenes cargadas al sistema
        imageLonding.add(bufferedImage);
    }

    /**
     * @return the url
     */
    public URL getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(URL url) {
        this.url = url;
    }
    
}