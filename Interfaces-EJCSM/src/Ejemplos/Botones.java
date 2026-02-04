import java.awt.event.*;
import javax.swing.*;

public class Botones extends JFrame {
    
    private int suma = 0;

    private static class miBoton extends JButton {
    
        private String texto;
    
        public miBoton(String texto) {
            this.texto = texto;
        }

        public String getTexto() {
            return this.texto;
        }
    
    }

    public Botones() {
        
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel etiqueta = new JLabel("Hola. Pulsa un botón y se cambiará el texto");
        
        miBoton boton1 = new miBoton("Suma 1");
        boton1.setText(boton1.getTexto());
        boton1.addActionListener( e -> {
            this.suma += 1;
            etiqueta.setText(String.valueOf(this.suma));
        });

        miBoton boton2 = new miBoton("2");
        boton2.setText(boton2.getTexto());
        boton2.addActionListener( e -> {
            etiqueta.setText("Has pulsado el dos.");
        });

        miBoton boton3 = new miBoton("Presiona una tecla");
        boton3.addActionListener(e -> {
            etiqueta.setText(boton3.getTexto());
        });
        boton3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'e' || e.getKeyChar() == 'E') {
                    etiqueta.setText("E");
                }
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Mostrar la tecla presionada
                etiqueta.setText(String.valueOf(e.getKeyChar()));
            }
        });

        // Añadir los componentes.
        panel.add(etiqueta);
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        add(panel);
        setVisible(true);
        setFocusable(true);
        requestFocusInWindow();

    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            new Botones();
        });

    }
    
}