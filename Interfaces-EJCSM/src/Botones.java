import javax.swing.*;

public class Botones {

    private static int suma = 0;

    public static void main(String[] args) throws Exception {
        
        // Crear ventana.
        JFrame ventana = new JFrame("Ventana.");

        // Establecer título
        // ventana.setTitle("Ventana");
        
        // Cerrar la ventana con el botón de cierre.
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear panel.
        JPanel panel = new JPanel();

        // Crear etiqueta de texto.
        JLabel etiqueta = new JLabel("Hola. Haz click en el botón de abajo. Este texto cambiará cuando se pulse el botón.");

        // Crear botones.
        JButton boton1 = new JButton("Pulsa aquí para cambiar el texto.");
        boton1.addActionListener(e -> {
            etiqueta.setText("El botón se ha pulsado 1.");
        });
        JButton boton2 = new JButton("Pulsa aquí para sumar 1.");
        boton2.addActionListener(e -> {
            suma = suma+1;
            etiqueta.setText(String.valueOf(suma));
        });

        // Añadir los componentes.
        panel.add(etiqueta);
        panel.add(boton1);
        panel.add(boton2);
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