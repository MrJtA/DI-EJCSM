import java.awt.*;
import javax.swing.*;

public class LayoutCardinales extends JFrame {

    public LayoutCardinales() {
        
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 200));

        panel.setLayout(new BorderLayout());

        // Añadir los componentes.
        panel.add(new JButton("1"), BorderLayout.NORTH);
        panel.add(new JButton("2"), BorderLayout.SOUTH);
        panel.add(new JButton("3"), BorderLayout.WEST);
        panel.add(new JButton("4"), BorderLayout.EAST);
        panel.add(new JButton("5"), BorderLayout.CENTER);
        add(panel);
        setVisible(true);

    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            new LayoutCardinales();
        });

    }
    
}