package GUI;

import static GUI.MainWindow.btnFlipHorizontal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Marco
 */
public class PrincipalWindow extends JFrame implements ActionListener, Serializable {

    private Dimension dimension;
    public static JButton start;
    private Font font, fontDos,fontTres;
    private JLabel welcome, other;
 

    public PrincipalWindow() {
        this.font = new Font("Amatic SC", Font.BOLD, 150);
        this.fontDos = new Font("Amatic SC", Font.BOLD, 50);
        this.fontTres = new Font("Amatic SC", Font.BOLD, 30);

        this.setTitle("Mosaic Maker");
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
        this.setIconImage(new ImageIcon("./ProjectImages/iconMain.jpg").getImage());
        super.setSize(dimension);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        start = new JButton("START");
        start.setBounds(570, 420, 200, 50);
        start.setEnabled(true);
        start.addActionListener(this);
        start.setBorder(null);
       start.setFont(fontTres);
            
        welcome = new JLabel("¡ W E L C O M E !");
        welcome.setFont(font);
        welcome.setForeground(Color.WHITE);
        welcome.setBounds(420, 100, 800, 300);
       
        other = new JLabel("– P R E S S   S T A R T   T O   B E G I N –");
        other.setFont(fontDos);
        other.setForeground(Color.WHITE);
        other.setBounds(480, 200, 500, 300);
       
        add(start);
        add(welcome);
        add(other);
       
    }  //constructor

     @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            MainWindow m = new MainWindow();
            m.setVisible(true);
        }
    }
}//class
