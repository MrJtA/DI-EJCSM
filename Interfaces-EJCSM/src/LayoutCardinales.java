import java.awt.BorderLayout;
import javax.swing.*;

public class LayoutCardinales {
    public static void main(String[] args) throws Exception {
        
        // Crear ventana.
        JFrame ventana = new JFrame("Ventana.");

        // Establecer título
        // ventana.setTitle("Ventana");
        
        // Cerrar la ventana con el botón de cierre.
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear paneles.
        JPanel panel = new JPanel();

        // Estructurar los componentes en regiones cardinales.
        panel.setLayout(new BorderLayout());

        // Crear botones.
        JButton boton1 = new JButton("1");
        JButton boton2 = new JButton("2");
        JButton boton3 = new JButton("3");
        JButton boton4 = new JButton("4");
        JButton boton5 = new JButton("5");

        // Añadir los componentes.
        panel.add(boton1, BorderLayout.NORTH);
        panel.add(boton2, BorderLayout.SOUTH);
        panel.add(boton3, BorderLayout.WEST);
        panel.add(boton4, BorderLayout.EAST);
        panel.add(boton5, BorderLayout.CENTER);
        ventana.add(panel);

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