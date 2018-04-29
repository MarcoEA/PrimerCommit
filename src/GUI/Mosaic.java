package GUI;

import domain.SubImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Marco
 */
public class Mosaic extends JPanel implements MouseListener, Serializable{
    
    /**
     * Componentes
     */
    Graphics2D graphics2D;
    SubImage subImageTemp;  
    /**
     * Atributos
     */
    public static ArrayList<SubImage> subImages;
    
    /**
     * Constructor
     */
    public Mosaic(){
        this.setBackground(Color.white);
        this.addMouseListener(this);
        this.setPreferredSize(new Dimension(
                MainWindow.creation.vWidth,MainWindow.creation.vHeigth));
        this.subImages = new ArrayList<>();
    }
    
    /**
     * Método que se encarga de pintar cada uno de los componentes del mosaico.
     * @param graphics2D 
     */
    private void paintMosaic(Graphics2D graphics2D){
        //For que pinta las lineas horizontales para la creación de las cuadriculas
        //con el tamaño antes indicado por el usuario
        for(int i=MainWindow.creation.sizeGrid; i<this.getWidth();
                i+=MainWindow.creation.sizeGrid) {
            graphics2D.drawLine(i, 0, i, this.getHeight());
        }
        //For que pinta las lineas verticales para la creación de las cuadriculas
        //con el tamaño antes indicado por el usuario
        for(int i=MainWindow.creation.sizeGrid; i<this.getHeight();
                i+=MainWindow.creation.sizeGrid) {
            graphics2D.drawLine(0, i,this.getWidth(), i);
        } 
        //For que recorre el arrayList de tipo SubImage con el fin de pintar la
        //subimagen en las coordenadas correspondientes.
        for(int i=0; i<subImages.size(); i++){
            graphics2D.drawImage(subImages.get(i).getImage(), 
                    subImages.get(i).getCoordX(),
                    subImages.get(i).getCoordY(), null);
        }
    }
    
    /**
     * Método que se encarga de inicializar la variable Graphics2D y llamar
     * al método paintMosaic.
     * @param g: Graphics.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        this.graphics2D = (Graphics2D)g;
        
        this.paintMosaic(graphics2D);        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(Palette.cbxSelect.isSelected() == true){
            //Si el combobox delete se encuentra activado aspi como el combobox
            //select se borra la cuadricula sobre la cual se dio click.
            if(Palette.cbxDelete.isSelected() == true){
                MainWindow.edition.paintSubImage(new SubImage(0, 0, null));
                int tempX, tempY;
                //Se recorre el mosaico con el fin de detectar la cuadricula
                //sobre la cual se dio el click.
                for(int i=0; i<this.getHeight(); i+=MainWindow.creation.sizeGrid){
                    tempY = i+MainWindow.creation.sizeGrid;
                    for(int j=0; j<this.getWidth(); j+=MainWindow.creation.sizeGrid) {
                        tempX = j+MainWindow.creation.sizeGrid;
                        //Si el punto sobre el cual se dio click está dentro de las
                        //dimensiones correspondientes entonces se borra la subimagen
                        //que contenga las dimensiones.
                        if(me.getX() >= j && me.getX() <= tempX && me.getY() >= i &&
                           me.getY() <= tempY) {
                            for(int m=0; m<subImages.size(); m++) {
                                if(subImages.get(m).getCoordX() == j && 
                                        subImages.get(m).getCoordY() == i) {
                                    subImages.remove(m);
                                    break;
                                }
                            }
                        }
                    }
                }
                repaint();
                //Si el combobox "select" está activado se coloca la subImagen
                //en las dimensiones sobre el cual se dio el click en el panel
                //edition al cual por medio de la palette se le podrán hacer las
                //las modificaciones que se deseen.
            } else {
                Boolean exists = false;
                int tempX, tempY;
                //Se recorre el mosaico con el fin de detectar la cuadricula
                //sobre la cual se dio el click.
                for(int i=0; i<this.getHeight(); i+=MainWindow.creation.sizeGrid){
                    tempY = i+MainWindow.creation.sizeGrid;
                    for(int j=0; j<this.getWidth(); j+=MainWindow.creation.sizeGrid) {
                        tempX = j+MainWindow.creation.sizeGrid;
                        //Si el punto sobre el cual se dio click está dentro de las
                        //dimensiones correspondientes entonces se carga la subImagen
                        //con las coordenadas correspondientes el el panel edition
                        //para ser modificada.
                        if(me.getX() >= j && me.getX() <= tempX && me.getY() >= i &&
                           me.getY() <= tempY) {
                            for(int m=0; m<subImages.size(); m++) {
                                if(subImages.get(m).getCoordX() == j && 
                                        subImages.get(m).getCoordY() == i) {
                                    MainWindow.edition.paintSubImage(subImages.get(m));
                                    exists = true;
                                }
                            }
                        }
                    }
                }
                //Si la cuadricula seleccionada no contenía ninguna subImagen 
                //se pasa como parametro una subImagen nula con el fin de que
                //el panel edition no presente ninguna subImagen.
                if(exists == false) {
                    MainWindow.edition.paintSubImage(new SubImage(0, 0, null));
                }
            }
        //Si el combobox select está desactivado se pinta en el mosaico la subImagen
        //que se encuentre en memoria.
        }else {
            Boolean exists = false;
            int tempX, tempY;
            //Se recorre el mosaico con el fin de detectar la cuadricula
            //sobre la cual se dio el click.
            for(int i=0; i<this.getHeight(); i+=MainWindow.creation.sizeGrid){
                tempY = i+MainWindow.creation.sizeGrid;
               for(int j=0; j<this.getWidth(); j+=MainWindow.creation.sizeGrid) {
                   tempX = j+MainWindow.creation.sizeGrid;
                   if(me.getX() >= j && me.getX() <= tempX && me.getY() >= i &&
                           me.getY() <= tempY) {
                    //Se recorre el arrayList de subImagenes para saber si la
                    //la cuadricula seleccionada ya poseía alguna imagen, en caso
                    //de que esto pase se sustituye el bufferedImage que esta
                    //contenía
                    for(int m=0; m<subImages.size(); m++) {
                        if(subImages.get(m).getCoordX() == j && 
                                subImages.get(m).getCoordY() == i) {
                            subImages.get(m).setImage(OriginalImage.subImage);
                            exists = true;
                        }
                    }
                    //Si la cuadricula seleccionada aún no tenía alguna imagen
                    //se agrega una subImagen nueva con las coordenadas e imagen
                    //correspondiente al arrayList contenedor de estas.
                    if(exists == false){
                        subImageTemp = new SubImage(j, i, OriginalImage.subImage);
                        subImages.add(subImageTemp);
                    }
                    repaint();
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
    
    public void changeSubImage() {
        repaint();
    }
    
}