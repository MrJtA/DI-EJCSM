import java.awt.*;
import javax.swing.*;

public class LayoutCuadriculado {
    public static void main(String[] args) throws Exception {
        
        // Crear ventana.
        JFrame ventana = new JFrame("Ventana.");

        // Establecer título
        // ventana.setTitle("Ventana");
        
        // Estructurar los componentes en regiones cardinales.
        ventana.setLayout(new BorderLayout());

        // Cerrar la ventana con el botón de cierre.
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear panel especificando filas y columnas.
        JPanel panelFormulario = new JPanel(new GridLayout(2, 2));

        // Ajustar tamaño del panel.
        panelFormulario.setPreferredSize(new Dimension(400, 200));

        // Crear componentes
        JLabel usuario = new JLabel("Usuario:");
        JTextField entradaUsuario = new JTextField(10);
        JLabel contraseña = new JLabel("Contraseña:");
        JPasswordField entradaContraseña = new JPasswordField(10);

        // Añadir los componentes.
        panelFormulario.add(usuario); // Celda 0,0
        panelFormulario.add(entradaUsuario); // Celda 0,1
        panelFormulario.add(contraseña); // Celda 1,0
        panelFormulario.add(entradaContraseña); // Celda 1,1
        ventana.add(panelFormulario, BorderLayout.EAST);

        // Ajustar tamaño de la ventana.
        ventana.setSize(800, 400);

        // Poner la ventana en el centro.
        ventana.setLocationRelativeTo(null);

        // Ajustar tamaño de la ventana a los componentes.
        // ventana.pack();

        // Hacer la ventana visible (siempre al final).
        ventana.setVisible(true);

    }
    
}