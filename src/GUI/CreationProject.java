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

    /**
     * etiquetas *
     */
    
    private JLabel lblSizeMosaic, lblGridSize, lblN, lblIcon, lblValueX, lblValueY;
    /**
     * campos de texto*
     */
    private JTextField txtValueX, txtValueY, txtN;
    /**
     * boton*
     */
    private JButton btnAcept;
    //Atributos
    public static int vWidth;
    public static int vHeigth;
    public static int sizeGrid;

    public CreationProject() {
        //Creación de los componentes de la GUI
        this.setLayout(null);
        lblSizeMosaic = new JLabel("Size Mosaic");
        lblSizeMosaic.setFont(new Font("Arial", Font.BOLD, 14));
        lblSizeMosaic.setForeground(Color.white);
        lblSizeMosaic.setBounds(50, 10, 90, 20);

        lblValueX = new JLabel("Value width");
        lblValueX.setFont(new Font("Arial", Font.BOLD, 14));
        lblValueX.setForeground(Color.white);
        lblValueX.setBounds(50, 40, 100, 20);

        txtValueX = new JTextField();
        txtValueX.setBounds(140, 40, 50, 20);
        txtValueX.addKeyListener(this);

        lblValueY = new JLabel("Value height");
        lblValueY.setFont(new Font("Arial", Font.BOLD, 14));
        lblValueY.setForeground(Color.white);
        lblValueY.setBounds(50, 70, 100, 20);

        txtValueY = new JTextField();
        txtValueY.setBounds(140, 70, 50, 20);
        txtValueY.addKeyListener(this);

        lblGridSize = new JLabel("Size Grid (nxn)");
        lblGridSize.setFont(new Font("Arial", Font.BOLD, 14));
        lblGridSize.setForeground(Color.white);
        lblGridSize.setBounds(50, 100, 120, 20);

        lblN = new JLabel("Value n");
        lblN.setFont(new Font("Arial", Font.BOLD, 14));
        lblN.setForeground(Color.white);
        lblN.setBounds(50, 130, 90, 20);

        txtN = new JTextField();
        txtN.setBounds(140, 130, 50, 20);
        txtN.addKeyListener(this);

        btnAcept = new JButton("Acept");
        btnAcept.setFont(new Font("Arial", NORMAL, 14));
        btnAcept.setBounds(80, 170, 80, 20);
        btnAcept.setVisible(false);
        btnAcept.addActionListener(this);
        btnAcept.setBackground(Color.white);
        lblIcon = new JLabel(new ImageIcon("./ProjectImages/backgroundMain.jpg"));
        lblIcon.setBounds(0, 0, 500, 300);

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
        this.setSize(500, 500);
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
