package GUI;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Marco
 */

public class Palette extends JPanel implements ActionListener {

    /**
     * Componentes
     */
    
//    private JLabel lblPalette, lblTurn;
//    private JSlider slrTurn;
    private JButton btnFlipHorizontal, btnFlipVertical, btnApplyChanges;
    public static JCheckBox cbxDelete, cbxSelect;
    public static BufferedImage imageTemp2;

    /**
     * Constructor
     */
    public Palette() {
        //Creación componetes de la GUI
        this.setLayout(null);
//        lblPalette = new JLabel("Palette");
//        lblPalette.setBounds(30, 10, 80, 20);
//        btnFlipHorizontal = new JButton("Horizontal");
//        //new ImageIcon("horizontal.png")
//        btnFlipHorizontal.setBounds(10, 50, 40, 40);
//        btnFlipHorizontal.setEnabled(false);
//        btnFlipHorizontal.addActionListener(this);
//        btnFlipVertical = new JButton("Vertical");
//        //new ImageIcon("vertical.png")
//        btnFlipVertical.setBounds(55, 50, 40, 40);
//        btnFlipVertical.setEnabled(false);
//        btnFlipVertical.addActionListener(this);
//        
//        lblTurn = new JLabel("Flip image");
//        lblTurn.setBounds(20, 105, 80, 20);
//        slrTurn = new JSlider(0, 360);
//        slrTurn.setBounds(10, 130, 80, 20);
//        slrTurn.setEnabled(false);
//        slrTurn.setValue(0);
//        slrTurn.setBackground(Color.white);
//        slrTurn.addChangeListener(new javax.swing.event.ChangeListener() {
//
//            @Override
//            public void stateChanged(ChangeEvent ce) {
//                MainWindow.edition.setDegrees(slrTurn.getValue());
//            }
//        });

        cbxSelect = new JCheckBox("Select");
        cbxSelect.setBounds(20, 160, 80, 20);
        cbxSelect.setBackground(Color.white);
        cbxSelect.addActionListener(this);
        cbxDelete = new JCheckBox("Delete");
        cbxDelete.setBounds(20, 180, 80, 20);
        cbxDelete.setBackground(Color.white);
        cbxDelete.setEnabled(false);
        cbxDelete.addActionListener(this);
        btnApplyChanges = new JButton("Apply");
        btnApplyChanges.setBounds(20, 200, 90, 20);
        btnApplyChanges.addActionListener(this);
        this.setBackground(Color.white);
//        this.add(lblPalette);
        this.add(btnFlipHorizontal);
        this.add(btnFlipVertical);
//        this.add(lblTurn);
//        this.add(slrTurn);
        this.add(cbxSelect);
        this.add(cbxDelete);
        this.add(btnApplyChanges);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == getCbxSelect()) {
            if (getCbxSelect().isSelected() == true) {
                btnFlipHorizontal.setEnabled(true);
                btnFlipVertical.setEnabled(true);
//                slrTurn.setEnabled(true);
                getCbxDelete().setEnabled(true);
            } else {
                btnFlipHorizontal.setEnabled(false);
                btnFlipVertical.setEnabled(false);
//                slrTurn.setEnabled(false);
                if (getCbxDelete().isSelected() == true) {
                    getCbxDelete().setSelected(false);
                }
                getCbxDelete().setEnabled(false);
            }
        }
        if (ae.getSource() == getCbxDelete()) {
            if (getCbxDelete().isSelected() == true) {
                btnFlipHorizontal.setEnabled(false);
                btnFlipVertical.setEnabled(false);
//                slrTurn.setEnabled(false);
            } else {
                btnFlipHorizontal.setEnabled(true);
                btnFlipVertical.setEnabled(true);
//                slrTurn.setEnabled(true);
            }
        }
        if (ae.getSource() == btnApplyChanges) {
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
        if (ae.getSource().equals(btnFlipHorizontal)) {
            MainWindow.edition.setDegrees(90);
        }
        if (ae.getSource().equals(btnFlipVertical)) {
            MainWindow.edition.setDegrees(180);
        }
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
