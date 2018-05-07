package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import static java.lang.Integer.parseInt;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Marco
 */
public class CreationProject extends JFrame implements ActionListener, KeyListener,
        Serializable {

    private JLabel lblSizeMosaic, lblGridSize, lblN, lblIcon, lblValueX, lblValueY;
    private JTextField txtValueX, txtValueY, txtN;
    private JButton btnAcept;
    //Atributos
    public static int vWidth;
    public static int vHeigth;
    public static int sizeGrid;
    private Font font;

    public CreationProject() {
        //Creación de los componentes de la GUI

        this.setLayout(null);
        this.setIconImage(new ImageIcon("./ProjectImages/iconMain.jpg").getImage());
        this.setTitle("Create a new mosaic");
        this.font = new Font("Century Gothic", Font.PLAIN, 17);

        lblSizeMosaic = new JLabel("Size Mosaic");
        lblSizeMosaic.setFont(font);
        lblSizeMosaic.setForeground(Color.black);
        lblSizeMosaic.setBounds(170, 20, 150, 20);
        
        
        lblValueX = new JLabel("Value width");
        lblValueX.setFont(font);
        lblValueX.setForeground(Color.black);
        lblValueX.setBounds(50, 50, 100, 50);
        
        
        txtValueX = new JTextField();
        txtValueX.setBounds(170, 65, 50, 20);
        txtValueX.addKeyListener(this);
        txtValueX.setBorder(null);

        lblValueY = new JLabel("Value height");
        lblValueY.setFont(font);
        lblValueY.setForeground(Color.black);
        lblValueY.setBounds(50, 100, 130, 50);
        
        txtValueY = new JTextField();
        txtValueY.setBounds(170, 115, 50, 20);
        txtValueY.addKeyListener(this);
        txtValueY.setBorder(null);

        lblGridSize = new JLabel("Size Grid (nxn)");
        lblGridSize.setFont(font);
        lblGridSize.setForeground(Color.black);
        lblGridSize.setBounds(150, 170, 120, 50);
        
        lblN = new JLabel("Value n");
        lblN.setFont(font);
        lblN.setForeground(Color.black);
        lblN.setBounds(50, 220, 90, 20);
        
        txtN = new JTextField();
        txtN.setBounds(170, 225, 50, 20);
        txtN.addKeyListener(this);
        txtN.setBorder(null);

        btnAcept = new JButton(new ImageIcon("./ProjectImages/ok.png"));
        btnAcept.setBounds(250, 250, 40, 40);
        btnAcept.setVisible(false);
        btnAcept.addActionListener(this);
        btnAcept.setBackground(Color.white);
        btnAcept.setFont(font);
        
        lblIcon = new JLabel(new ImageIcon("./ProjectImages/fondoDos.jpg"));
        lblIcon.setBounds(0, 0, 720, 400);
        
        
        this.add(lblGridSize);
        this.add(btnAcept);
        this.add(lblN);
        this.add(lblSizeMosaic);
        this.add(lblValueX);
        this.add(lblValueY);
        this.add(txtN);
        this.add(txtValueX);
        this.add(txtValueY);
        this.add(lblIcon);
        
        this.setVisible(true);
        this.setSize(720, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnAcept)) {
            vWidth = parseInt(txtValueX.getText());
            vHeigth = parseInt(txtValueY.getText());
            sizeGrid = parseInt(txtN.getText());
            this.dispose();
        }

    }

    //Validaciones para que se permita solo introducir valores correctamente
    @Override
    public void keyTyped(KeyEvent ke) {

        if (ke.getSource() == txtValueY) {
            if (txtValueY.getText().length() > 3) {
                ke.consume();
            }
            if (!Character.isDigit(ke.getKeyChar()) && ke.getKeyChar()
                    != KeyEvent.VK_ENTER && ke.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
                JOptionPane.showMessageDialog(null, "Enter only numbers");
                ke.consume();
            }
            if (txtValueY.getText().length() == 0) {
                if (ke.getKeyChar() == KeyEvent.VK_SPACE) {
                    JOptionPane.showMessageDialog(null, "Enter text");
                    ke.consume();
                }

            }
        }

        if (ke.getSource() == txtValueX) {
            if (txtValueX.getText().length() > 3) {
                ke.consume();
            }
            if (!Character.isDigit(ke.getKeyChar()) && ke.getKeyChar()
                    != KeyEvent.VK_ENTER && ke.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
                JOptionPane.showMessageDialog(null, "Enter only numbers");
                ke.consume();
            }
            if (txtValueX.getText().length() == 0) {
                if (ke.getKeyChar() == KeyEvent.VK_SPACE) {
                    JOptionPane.showMessageDialog(null, "Enter text");
                    ke.consume();
                }
            }
        }

        if (ke.getSource() == txtN) {
            if (txtN.getText().length() > 2) {
                ke.consume();
            }
            if (!Character.isDigit(ke.getKeyChar()) && ke.getKeyChar()
                    != KeyEvent.VK_ENTER && ke.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
                JOptionPane.showMessageDialog(null, "Enter only numbers");
                ke.consume();
            }
            if (txtN.getText().length() == 0) {
                if (ke.getKeyChar() == KeyEvent.VK_SPACE) {
                    JOptionPane.showMessageDialog(null, "Enter text");
                    ke.consume();
                }
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        this.fieldVerify();
    }

    /**
     * Método muestra el botón add si se cumplen las validaciones
     */
    public void fieldVerify() {
        if (!txtValueX.getText().equals("") && !txtValueY.getText().equals("")
                && !txtN.getText().equals("")) {
            btnAcept.setVisible(true);
        } else {
            btnAcept.setVisible(false);
        }

    }

}
