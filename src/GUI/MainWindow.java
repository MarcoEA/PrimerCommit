package GUI;

import data.MosaicFile;
import domain.SubImage;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Marco
 */
public class MainWindow extends JFrame implements ActionListener, Serializable {

    public static Mosaic mosaic;
    public static Edition edition;
    public static CreationProject creation;
    private Dimension dimension;
    public static JButton btnFlipHorizontal, btnFlipVertical, btnApplyChanges, btnDelete, btnSelect;
    public static BufferedImage imageTemp2;
    private Font font;
    public static JCheckBox cbxDelete, cbxSelect;
    private JScrollPane scrollMosaic1, scrollPanel, scrollMosaic;
    private JMenuBar mbBar;
    private JMenu mnFile;
    private JMenuItem itOpenProject, itOpenImage, itNew, itSave, itClose, itExport, itOpenMosaic;
    private JPanel pnlImages, pnlMosaic;
    private JLabel lblAddImages, lblOpenMosaic, lblBackground;

    public MainWindow() {
        //Creación de los componentes de la GUI
        this.setLayout(null);
        this.font = new Font("Century Gothic", Font.PLAIN, 13);
        this.setTitle("Mosaic Maker");

        lblAddImages = new JLabel(new ImageIcon("./ProjectImages/addImages.png"));
        lblAddImages.setBounds(170, 130, 300, 300);
        pnlImages = new JPanel();
        pnlImages.setBounds(0, 20, 600, 600);
        pnlImages.setBackground(Color.white);
        pnlImages.setLayout(new BoxLayout(pnlImages, BoxLayout.Y_AXIS));
        scrollPanel = new JScrollPane(pnlImages);
        scrollPanel.setBounds(20, 20, 650, 600);

        lblOpenMosaic = new JLabel(new ImageIcon("./ProjectImages/labelMosaic.png"));
        lblOpenMosaic.setBounds(870, 140, 300, 300);
        pnlMosaic = new JPanel();
        pnlMosaic.setBounds(370, 20, 700, 600);
        pnlMosaic.setBackground(Color.white);
        scrollMosaic = new JScrollPane(pnlMosaic);
        scrollMosaic.setBounds(690, 20, 650, 600);

        edition = new Edition();
        edition.setBounds(1150, 300, 0, 0);

        mbBar = new JMenuBar();
        mnFile = new JMenu("Options");
        mnFile.setFont(font);
        mbBar.setBackground(Color.WHITE);

        itNew = new JMenuItem("New project");
        itNew.setFont(font);
        itNew.setIcon(new ImageIcon("./ProjectImages/newProject.png"));
        itNew.addActionListener(this);

        mnFile.add(itNew);
        setJMenuBar(mbBar);

        itOpenMosaic = new JMenuItem("Open Mosaic");
        itOpenMosaic.setFont(font);
        itOpenMosaic.addActionListener(this);
        itOpenMosaic.setEnabled(false);
        itOpenMosaic.setIcon(new ImageIcon("./ProjectImages/openMosaic.png"));

        mnFile.add(itOpenMosaic);
        mbBar.add(mnFile);

        itOpenProject = new JMenuItem("Open project");
        itOpenProject.setFont(font);
        itOpenProject.addActionListener(this);
        itOpenProject.setIcon(new ImageIcon("./ProjectImages/openProject.jpg"));
        mnFile.add(itOpenProject);

        itOpenImage = new JMenuItem("Open image");
        itOpenImage.setFont(font);
        itOpenImage.addActionListener(this);
        itOpenImage.setEnabled(false);
        itOpenImage.setIcon(new ImageIcon("./ProjectImages/open.gif"));

        mnFile.add(itOpenImage);

        mbBar.add(mnFile);

        itSave = new JMenuItem("Save project");
        itSave.setFont(font);
        itSave.addActionListener(this);
        itSave.setIcon(new ImageIcon("./ProjectImages/save.gif"));
        mnFile.add(itSave);

        itExport = new JMenuItem("Export mosaic");
        itExport.setFont(font);
        itExport.addActionListener(this);
        itExport.setIcon(new ImageIcon("./ProjectImages/exportImage.png"));
        mnFile.add(itExport);

        itClose = new JMenuItem("Close");
        itClose.setFont(font);
        itClose.addActionListener(this);
        itClose.setIcon(new ImageIcon("./ProjectImages/close.gif"));
        mnFile.add(itClose);

        btnSelect = new JButton(new ImageIcon("./ProjectImages/select.jpg"));
        btnSelect.setBounds(20, 650, 40, 40);
        btnSelect.setEnabled(false);
        btnSelect.addActionListener(this);
        btnSelect.setBorder(null);

        cbxSelect = new JCheckBox("");
        cbxSelect.setBounds(60, 650, 30, 40);
        cbxSelect.setBackground(Color.white);
        cbxSelect.addActionListener(this);

        btnDelete = new JButton(new ImageIcon("./ProjectImages/delete.png"));
        btnDelete.setBounds(120, 650, 40, 40);
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(this);
        btnDelete.setBorder(null);

        cbxDelete = new JCheckBox("");
        cbxDelete.setBounds(160, 650, 30, 40);
        cbxDelete.setBackground(Color.white);
        cbxDelete.setEnabled(false);
        cbxDelete.addActionListener(this);

        btnFlipHorizontal = new JButton(new ImageIcon("./ProjectImages/horizontal.png"));
        btnFlipHorizontal.setBounds(220, 650, 40, 40);
        btnFlipHorizontal.setEnabled(false);
        btnFlipHorizontal.addActionListener(this);
        btnFlipHorizontal.setBorder(null);

        btnFlipVertical = new JButton(new ImageIcon("./ProjectImages/vertical.png"));
        btnFlipVertical.setBounds(280, 650, 40, 40);
        btnFlipVertical.setEnabled(false);
        btnFlipVertical.addActionListener(this);
        btnFlipVertical.setBorder(null);

        btnApplyChanges = new JButton(new ImageIcon("./ProjectImages/ok.png"));
        btnApplyChanges.setBounds(340, 650, 40, 40);
        btnApplyChanges.addActionListener(this);
        btnApplyChanges.setBorder(null);

        lblBackground = new JLabel(new ImageIcon("./ProjectImages/backgroundMain.jpg"));
        lblBackground.setBounds(0, 0, 1440, 900);

        this.setIconImage(new ImageIcon("./ProjectImages/iconMain.jpg").getImage());

//------------------------------------------------------------------------------------------
        add(btnFlipHorizontal);
        add(btnFlipVertical);
        add(btnSelect);
        add(btnDelete);
        add(cbxSelect);
        add(cbxDelete);
        add(btnApplyChanges);
        add(lblOpenMosaic);
        add(lblAddImages);
        add(scrollPanel);
        add(scrollMosaic);
        add(edition);
        add(lblBackground);

        setLocationRelativeTo(null);
        setResizable(false);
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/assets/backgroundMain.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        dimension = super.getToolkit().getScreenSize();
        super.setSize(dimension);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(itOpenImage)) {
            //Se obtiene la imagen dede ruta y se carga al panel contenedor
            OriginalImage panel = new OriginalImage();
            panel.setBackground(Color.white);
            panel.setUrl(new OpenGuard().windowsOpenImage());
            if (panel.getUrl() != null) {
                this.pnlImages.add(panel);
                pnlImages.updateUI();
                panel.loandingImage();
                panel.updateUI();

            }
            lblAddImages.setVisible(false);
        }
        if (e.getSource().equals(itOpenMosaic)) {
            //Se obtiene el panel del mosaico con las divisiones correspondientes 
            if (mosaic == null) {
                mosaic = new Mosaic();
                scrollMosaic1 = new JScrollPane(mosaic);
                pnlMosaic.add(scrollMosaic1);
                pnlMosaic.updateUI();
                itOpenMosaic.setEnabled(false);
                edition.setSize(creation.sizeGrid, creation.sizeGrid);
                lblOpenMosaic.setVisible(false);
            } else {
                mosaic.setPreferredSize(new Dimension(creation.vWidth, creation.vHeigth));
                edition.setSize(creation.sizeGrid, creation.sizeGrid);
                pnlMosaic.updateUI();
            }
            pnlImages.removeAll();
            OriginalImage.imageLonding.clear();
            mosaic.subImages.clear();
            pnlImages.updateUI();
            MainWindow.mosaic.updateUI();
            MainWindow.mosaic.changeSubImage();
        }
        if (e.getSource().equals(itNew)) {
            //Se instancia la ventana para ingresar los datos (tamaño mosaico y 
            // tamaño cuadrícula
            CreationProject newProject = new CreationProject();
            itOpenMosaic.setEnabled(true);
            itOpenImage.setEnabled(true);
//            newProject.setVisible(true);
        }

        if (e.getSource().equals(itExport)) {
            //Se instancia OpenGuard para abrir la ventana y asiganar la ruta donde
            //se desea exportar
            try {
                OpenGuard export = new OpenGuard();
                //El panel mosaic se convierte en BufferedImage por medio del método createImage()
                export.windowsSaveImage(createImage(mosaic));
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null, "You must first create the mosaic.");
            }
        }

        if (e.getSource() == itSave) {
            //Se instancia la MosaicFile para utilizar sus métodos
            MosaicFile image = new MosaicFile(creation.vWidth,
                    creation.vHeigth, creation.sizeGrid);
            String path = new OpenGuard().windowsSaveProject();
            if (path != null) {
                try {
                    //Creación del archivo
                    ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(path));
                    //Escritura del archivo
                    image.writeObject(file, Mosaic.subImages, OriginalImage.imageLonding);
                } catch (FileNotFoundException ex) {
                } catch (IOException ex) {
                }
            }
        }

        if (e.getSource() == itOpenProject) {
            //Instancia de MosaicFile para utilizar sus métodos
            MosaicFile image = new MosaicFile();
            ObjectInputStream read;
            String path = new OpenGuard().windowsOpenProject();
            if (path != null) {
                try {
                    //Lectura del archivo
                    read = new ObjectInputStream(new FileInputStream(path));
                    ArrayList<Object> myArray = new ArrayList<>();
                    myArray = image.readObject(read);
                    //Asignación del contenido de las subImage al ArrayList correspondiente
                    ArrayList<SubImage> subImages = new ArrayList<>();
                    subImages = (ArrayList<SubImage>) myArray.get(0);
                    //Asignación del contenido de BufferedImages al ArrayList correspondiente
                    ArrayList<OriginalImage> images = new ArrayList<>();
                    images = (ArrayList<OriginalImage>) myArray.get(1);
                    if (mosaic == null) {
                        //Asignación de las subImages al panel correspondiente
                        mosaic = new Mosaic();
                        scrollMosaic1 = new JScrollPane(mosaic);
                        pnlMosaic.add(scrollMosaic1);
                        pnlMosaic.updateUI();
                        itOpenMosaic.setEnabled(false);
                        edition.setSize(creation.sizeGrid, creation.sizeGrid);
                        lblOpenMosaic.setVisible(false);
                        itOpenImage.setEnabled(true);
                    } else {
                        mosaic.setPreferredSize(new Dimension(creation.vWidth, creation.vHeigth));
                        edition.setSize(creation.sizeGrid, creation.sizeGrid);
                        pnlMosaic.updateUI();
                    }
                    //Asiganción de BufferedImages al panel correspondiente
                    pnlImages.removeAll();
                    OriginalImage.imageLonding.clear();
                    for (int i = 0; i < images.size(); i++) {
                        OriginalImage myOrigianlImage = new OriginalImage();
                        myOrigianlImage.setBufferedImage(images.get(i).getBufferedImage());
                        this.pnlImages.add(myOrigianlImage);
                        myOrigianlImage.updateUI();
                    }
                    //Actualización de paneles
                    lblAddImages.setVisible(false);
                    pnlImages.updateUI();
                    MainWindow.mosaic.subImages = subImages;
                    MainWindow.mosaic.updateUI();
                    MainWindow.mosaic.changeSubImage();

                } catch (IOException ex) {
                } catch (ClassNotFoundException ex) {
                }
            }

        }
        if (e.getSource().equals(itClose)) {
            this.dispose();
        }

        if (e.getSource() == getCbxSelect()) {

            if (getCbxSelect().isSelected() == true) {
                btnFlipHorizontal.setEnabled(true);
                btnFlipVertical.setEnabled(true);
                btnDelete.setEnabled(true);
                btnSelect.setEnabled(true);
                getCbxDelete().setEnabled(true);
            } else {
                btnFlipHorizontal.setEnabled(false);
                btnFlipVertical.setEnabled(false);
                btnDelete.setEnabled(false);
                btnSelect.setEnabled(false);

                if (getCbxDelete().isSelected() == true) {

                    getCbxDelete().setSelected(false);
                }
                getCbxDelete().setEnabled(false);
            }
        }
        if (e.getSource() == getCbxDelete()) {
            if (getCbxDelete().isSelected() == true) {
                btnFlipHorizontal.setEnabled(false);
                btnFlipVertical.setEnabled(false);
                btnDelete.setEnabled(true);

            } else {
                btnFlipHorizontal.setEnabled(true);
                btnFlipVertical.setEnabled(true);
                btnDelete.setEnabled(false);

            }
        }
        if (e.getSource() == btnApplyChanges) {
            try {
                //Se crea una captura del mosaico modificado y luego se busca este
                //dentro del arrayList de subImagenes para realizar el cambio
                //en el mosaico.
                imageTemp2 = new Robot().createScreenCapture(
                        new Rectangle(1173, 369, MainWindow.creation.sizeGrid,
                                MainWindow.creation.sizeGrid));
                Edition.subImage.setImage(imageTemp2);
                //se aplican los cambios al mosaic
                MainWindow.mosaic.changeSubImage();
//                slrTurn.setValue(0);
            } catch (AWTException ex) {
            }
        }
        if (e.getSource().equals(btnFlipHorizontal)) {
            MainWindow.edition.setDegrees(90);
        }
        if (e.getSource().equals(btnFlipVertical)) {
            MainWindow.edition.setDegrees(180);
        }
    }

    /**
     * Método que convierte un panel a BufferedImage
     *
     * @param panel panel que se desea convertir
     * @return imagen correspondiente al panel
     */
    private BufferedImage createImage(JPanel panel) {
        // Create BufferedImage del panel
        BufferedImage image = new BufferedImage(panel.getWidth(),
                panel.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        panel.paint(g2d);
        g2d.dispose();
        //Dimensiones del BufferedImage para retornar
        AffineTransform at = new AffineTransform();
        at.scale(0.7, 0.7);
        AffineTransformOp scaleOp = new AffineTransformOp(at,
                AffineTransformOp.TYPE_BILINEAR);
        return scaleOp.filter(image, null);
    }

    public JCheckBox getCbxDelete() {
        return cbxDelete;
    }

    public void setCbxDelete(JCheckBox cbxDelete) {
        this.cbxDelete = cbxDelete;
    }

    public JCheckBox getCbxSelect() {
        return cbxSelect;
    }

    public void setCbxSelect(JCheckBox cbxSelect) {
        this.cbxSelect = cbxSelect;
    }
}
