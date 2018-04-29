package GUI;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.awt.ComponentOrientation;

/**
 *
 * @author Marco
 */
public class MyFileChooser extends JFileChooser {

    private String extension;
    private FileNameExtensionFilter extensionFilter;

    public MyFileChooser(FileNameExtensionFilter extensionFilter) {
        super();
        this.extensionFilter = extensionFilter;
        addChoosableFileFilter(this.extensionFilter);
        applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        //setPreferredSize(new Dimension(450, 350));
    }

    @Override
    public String getDialogTitle() {
        return "Seleccione un Archivo";
    }

    @Override
    public File getSelectedFile() {
        File selectedFile = super.getSelectedFile();
        return selectedFile;
    }
}//class
