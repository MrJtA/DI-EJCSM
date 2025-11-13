import java.awt.*;
import javax.swing.*;

public class LayoutFlotantes extends JFrame {

    public LayoutFlotantes() {

        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 200));

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        // Añade espacio alrededor de cada componente
        gbc.insets = new Insets(5, 5, 5, 5);

        // Crear componentes
        JLabel usuario = new JLabel("Usuario:");
        JTextField entradaUsuario = new JTextField(10);
        JLabel contraseña = new JLabel("Contraseña:");
        JPasswordField entradaContraseña = new JPasswordField(10);

        // --- Componente 1: Etiqueta "Usuario" (Columna 0, Fila 0) ---
        gbc.gridx = 0;       // Columna 0
        gbc.gridy = 0;       // Fila 0
        gbc.anchor = GridBagConstraints.EAST; // Alineación a la derecha
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;     // No queremos que las etiquetas estiren la columna
        panel.add(usuario, gbc);

        gbc.gridx = 1;       // Columna 1
        gbc.gridy = 0;       // Fila 0
        gbc.weightx = 1.0;   // ¡Esta columna puede estirarse!
        gbc.fill = GridBagConstraints.HORIZONTAL; // Estirar para llenar el ancho
        panel.add(entradaUsuario, gbc);

        // --- Componente 3: Etiqueta "Contraseña" (Columna 0, Fila 1) ---
        gbc.gridx = 0;       // Columna 0
        gbc.gridy = 1;       // Fila 1
        gbc.weightx = 0;     // No estirar la columna 0
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(contraseña, gbc);

        // --- Componente 4: Campo de Contraseña (Columna 1, Fila 1) ---
        gbc.gridx = 1;       // Columna 1
        gbc.gridy = 1;       // Fila 1
        gbc.weightx = 1.0;   // Esta columna puede estirarse
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(entradaContraseña, gbc);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            new LayoutFlotantes();
        });
    }
    
}