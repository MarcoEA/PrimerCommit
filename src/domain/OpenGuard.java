package domain;

import GUI.MyFileChooser;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Marco
 */
public class OpenGuard {

    //Atributos
    private FileNameExtensionFilter filterImage = new FileNameExtensionFilter("Archivo de Imagen", "jpg", "png");

    private FileNameExtensionFilter filterProject = new FileNameExtensionFilter("Archivo de Proyecto", "bin");

    /**
     * Método que permite guardar la imagen que se diseñó
     *
     * @param format formato de la imagen png o jog
     * @param image Imagen a guardar
     */
    public void saveImage(String format, BufferedImage image) {
        try {
            //se extrae el fomato y se guarda
            ImageIO.write(image, "png", new File(format));
        } catch (IOException e) {
        }
    }//end Method

    /**
     * Método que abre la ventana para seleccionar la ruta donde se desea
     * exportar la imagen
     *
     * @param image contiene la imagen a guardar
     */
    public void windowsSaveImage(BufferedImage image) {
       try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Unable to load Windows look and feel");
        }//try-catch

        UIManager.put("FileChooser.saveButtonText", "Guardar");
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.updateButtonText", "Actualizar");
        UIManager.put("FileChooser.helpButtonText", "Ayuda");
        UIManager.put("FileChooser.saveButtonToolTipText", "Guardar");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");
        UIManager.put("FileChooser.updateButtonToolTipText", "Actualizar");
        UIManager.put("FileChooser.helpButtonToolTipText", "Ayuda");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.lookInLabelText", "Archivo:");
        UIManager.put("FileChooser.newFolderToolTipText", "Nueva carpeta");
        UIManager.put("FileChooser.fileNameLabelText", "Nombre Archivo");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Tipo de Archivo");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalles");
        UIManager.put("FileChooser.upFolderToolTipText", "Folder");

        MyFileChooser chooser = new MyFileChooser(filterProject);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileHidingEnabled(false);
        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            //se obtiene la direccion donde se guardara la imagen
            String url = chooser.getSelectedFile().toString();
            //Se guarda la imagen
            saveImage(url, image);
        }
    }//end method

    /**
     * Método que abre la ventana para obtener la rura donde se encuentra el
     * proyecto
     *
     * @return urlToReturn dirección para guardar
     */
    public String windowsOpenProject() {

      try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Unable to load Windows look and feel");
        }//try-catch

        UIManager.put("FileChooser.saveButtonText", "Guardar");
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.updateButtonText", "Actualizar");
        UIManager.put("FileChooser.helpButtonText", "Ayuda");
        UIManager.put("FileChooser.saveButtonToolTipText", "Guardar");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");
        UIManager.put("FileChooser.updateButtonToolTipText", "Actualizar");
        UIManager.put("FileChooser.helpButtonToolTipText", "Ayuda");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.lookInLabelText", "Archivo:");
        UIManager.put("FileChooser.newFolderToolTipText", "Nueva carpeta");
        UIManager.put("FileChooser.fileNameLabelText", "Nombre Archivo");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Tipo de Archivo");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalles");
        UIManager.put("FileChooser.upFolderToolTipText", "Folder");

        MyFileChooser chooser = new MyFileChooser(filterProject);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileHidingEnabled(false);

        int result = chooser.showOpenDialog(null);
        URL url = null;
        String urlToReturn = null;
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                //se asigna a "url" el archivo de imagen seleccionado
                url = chooser.getSelectedFile().toURL();
                urlToReturn = url.getPath();
            } catch (IOException ex) {
            }
        }
        return urlToReturn;
    }

    /**
     * Método que abre la ventana para seleccionar la ruta donde se debe guardar
     * el proyecto
     *
     * @return urlToReturn dirección para guardar
     */
    public String windowsSaveProject() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Unable to load Windows look and feel");
        }//try-catch

        UIManager.put("FileChooser.saveButtonText", "Guardar");
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.updateButtonText", "Actualizar");
        UIManager.put("FileChooser.helpButtonText", "Ayuda");
        UIManager.put("FileChooser.saveButtonToolTipText", "Guardar");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");
        UIManager.put("FileChooser.updateButtonToolTipText", "Actualizar");
        UIManager.put("FileChooser.helpButtonToolTipText", "Ayuda");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.lookInLabelText", "Archivo:");
        UIManager.put("FileChooser.newFolderToolTipText", "Nueva carpeta");
        UIManager.put("FileChooser.fileNameLabelText", "Nombre Archivo");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Tipo de Archivo");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalles");
        UIManager.put("FileChooser.upFolderToolTipText", "Folder");

        MyFileChooser chooser = new MyFileChooser(filterProject);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileHidingEnabled(false);

        int result = chooser.showOpenDialog(null);
        URL url = null;
        String urlToReturn = null;
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                //se asigna a "url" el archivo de imagen seleccionado
                url = chooser.getSelectedFile().toURL();
                urlToReturn = url.getPath();
            } catch (IOException ex) {
            }
        }
        return urlToReturn;
    }

    /**
     * Método que abre la ventana para obtener la ruta donde se encuentra la
     * imagen
     *
     * @return url contiene la dirección para abrir
     */
    public URL windowsOpenImage() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Unable to load Windows look and feel");
        }//try-catch

        UIManager.put("FileChooser.saveButtonText", "Guardar");
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.updateButtonText", "Actualizar");
        UIManager.put("FileChooser.helpButtonText", "Ayuda");
        UIManager.put("FileChooser.saveButtonToolTipText", "Guardar");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");
        UIManager.put("FileChooser.updateButtonToolTipText", "Actualizar");
        UIManager.put("FileChooser.helpButtonToolTipText", "Ayuda");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.lookInLabelText", "Archivo:");
        UIManager.put("FileChooser.newFolderToolTipText", "Nueva carpeta");
        UIManager.put("FileChooser.fileNameLabelText", "Nombre Archivo");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Tipo de Archivo");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalles");
        UIManager.put("FileChooser.upFolderToolTipText", "Folder");

        MyFileChooser chooser = new MyFileChooser(filterImage);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileHidingEnabled(false);

        int result = chooser.showOpenDialog(null);
        URL url = null;
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                //se asigna a "url" el archivo de imagen seleccionado
                url = chooser.getSelectedFile().toURL();
            } catch (IOException ex) {
            }
        }
        return url;
    }

}//class
