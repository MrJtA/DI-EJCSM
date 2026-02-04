import java.awt.*;
import javax.swing.*;

public class LayoutCuadriculado extends JFrame {

    public LayoutCuadriculado() {
        
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 200));
        
        panel.setLayout(new GridLayout(2, 2));

        // Crear componentes
        JLabel usuario = new JLabel("Usuario:");
        JTextField entradaUsuario = new JTextField(10);
        JLabel contraseña = new JLabel("Contraseña:");
        JPasswordField entradaContraseña = new JPasswordField(10);

        panel.add(usuario); // Celda 0,0
        panel.add(entradaUsuario); // Celda 0,1
        panel.add(contraseña); // Celda 1,0
        panel.add(entradaContraseña); // Celda 1,1
        add(panel);
        setVisible(true);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new LayoutCuadriculado();
        });

    }
    
}