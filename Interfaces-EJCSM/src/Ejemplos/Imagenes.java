import java.awt.*;
import javax.swing.*;

public class Imagenes extends JFrame {

    public Imagenes() {

        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new GridLayout(1,1));
        JPanel panel1 = new JPanel() {
            // Poner de fondo imagen
            private Image fondoPanel = new ImageIcon("imagenes/ahorasi.jpg").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondoPanel, 0, 0, getWidth(), getHeight(),this);
            }
        };
        panel1.setPreferredSize(new Dimension(200,100));

        JPanel panel2 = new JPanel() {
            private Image fondoPanel = new ImageIcon("imagenes/mad.jpg").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondoPanel, 0, 0, getWidth(), getHeight(),this);
            }
        };
        panel2.setPreferredSize(new Dimension(400,200));
    
        JLabel etiqueta = new JLabel();
        // Poner de fondo imagen
        etiqueta.setIcon(new ImageIcon("imagenes/logointefhead.jpg"));
    
        panel1.add(etiqueta);
        add(panel1);
        add(panel2);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            new Imagenes();
        });
    }
    
}