package File;




import domain.*;
import GUI.MainWindow;
import GUI.OriginalImage;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;

/**
 *
 * @author Marco
 */
public class SerializableImage {
    //Atributos
    public static int width;
    public static int heigth;
    public static int sizeGrid;
    //Constructor
    public SerializableImage(int width, int heigth, int sizeGrid) {
        this.width = width;
        this.heigth = heigth;
        this.sizeGrid = sizeGrid;
    }
    //Constructor
    public SerializableImage() {
        this.width = 0;
        this.heigth = 0;
        this.sizeGrid = 0;
    }
    /**
     * Método que escribe en el archivo el mosaico e imagenes que el usuario ha 
     * introducido para realiazar el proyecto
     * @param out Objeto Serializable
     * @param subImages Contiene cada subImagen del mosaico con sus respectivas coordenadas
     * @param imagesLonding Contiene las imagenes que se cargar para modificarlas
     * @throws IOException 
     */
    public void writeObject(ObjectOutputStream out, ArrayList<SubImage> subImages,
            ArrayList<BufferedImage> imagesLonding) throws IOException {
        //Escritura del tamaño de los dos ArrayList para posteriormente poder leer
        out.writeObject(subImages.size());
        out.writeObject(imagesLonding.size());
        //Escritura de los valores pertenecientes al tamaño del mosaico
        out.writeObject(width);
        out.writeObject(heigth);
        out.writeObject(sizeGrid);
        //for que permite guardar las imagenes que contenga el ArrayList de BufferedImage
        for (int i = 0; i < imagesLonding.size(); i++) {
            out.writeObject(i);
            //formato de escritura del BufferedImage
            ImageWriter writer = (ImageWriter) ImageIO.getImageWritersBySuffix("jpg").next();
            writer.setOutput(ImageIO.createImageOutputStream(out));
            ImageWriteParam param = writer.getDefaultWriteParam();
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(0.85f);
            writer.write(null, new IIOImage((BufferedImage)imagesLonding.get(i), null, null), param);
        }
        //for que permite escribir los components de las SubImages contenidas en el ArrayList
        for (int i = 0; i < subImages.size(); i++) {
            //Escritura de las coordenadas de las subImagenes
            out.writeObject(subImages.get(i).getCoordX());
            out.writeObject(subImages.get(i).getCoordY());
            //Formato y escritura del BufferedImage 
            ImageWriter writer = (ImageWriter) ImageIO.getImageWritersBySuffix("jpg").next();
            writer.setOutput(ImageIO.createImageOutputStream(out));
            ImageWriteParam param = writer.getDefaultWriteParam();
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(0.85f);
            writer.write(null, new IIOImage(subImages.get(i).getImage(), null, null), param);
        }

    }
    /**
     * Método que lee el archivo para retornar el mosaico y las imagenes que fueron 
     * utilizadas en el proyecto
     * @param in Objeto a leer
     * @return images Contiene un ArrayList con las subImagenes y otro con BufferedImage
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public ArrayList<Object> readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        ArrayList<SubImage> subImages = new ArrayList<>();
        ArrayList<OriginalImage> Originalimages = new ArrayList<>();
        //Lectura primeros elementos guardados
        int size = (int) in.readObject();
        int size2 = (int) in.readObject();
        MainWindow.creation.vWidth = (int) in.readObject();
        MainWindow.creation.vHeigth = (int) in.readObject();
        MainWindow.creation.sizeGrid = (int) in.readObject();
        //Lectura de BufferdImages 
        for (int i = 0; i < size2; i++) {
            in.readObject();
            OriginalImage original = new OriginalImage();
            original.setBufferedImage(ImageIO.read(ImageIO.createImageInputStream(in)));
            Originalimages.add(original);
        }
        //Lectura de SubImage
        for (int i = 0; i < size; i++) {
            SubImage subImage = new SubImage();
            subImage.setCoordX((int) in.readObject());
            subImage.setCoordY((int) in.readObject());
            subImage.setImage(ImageIO.read(ImageIO.createImageInputStream(in)));
            subImages.add(subImage);
        }
        ArrayList<Object> images = new ArrayList<>();
        images.add(subImages);
        images.add(Originalimages);
        
        return images;
    }
    
          
        
        

}
