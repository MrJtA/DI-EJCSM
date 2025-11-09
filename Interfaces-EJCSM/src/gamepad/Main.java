package gamepad;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("GamePad");
        ventana.setSize(640, 480);
        ventana.setLayout(new BorderLayout());

        miPanel panelCentral = new miPanel();
        panelCentral.setLayout(new GridBagLayout());
        JTextField textoCentral = new JTextField();
        textoCentral.setHorizontalAlignment(JTextField.CENTER);
        String texto = "PANTALLA VIDEOJUEGO";
        textoCentral.setText(texto);
        panelCentral.add(textoCentral);

        miPanel panelSuperior = new miPanel();
        panelSuperior.setPreferredSize(new Dimension(640, 50));

        miPanel panelIzquierdo = new miPanel();
        panelIzquierdo.setPreferredSize(new Dimension(100, 400));
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS)); 
        panelIzquierdo.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelIzquierdo.add(new miBoton("X"));
        panelIzquierdo.add(Box.createVerticalStrut(25));
        panelIzquierdo.add(new miBoton("O"));
        panelIzquierdo.add(Box.createVerticalStrut(25));
        panelIzquierdo.add(new miBoton("|"));

        miPanel panelDerecho = new miPanel();
        panelDerecho.setPreferredSize(new Dimension(100, 400));
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
        panelDerecho.setBorder(new EmptyBorder(10, 10, 10, 10)); 
        panelDerecho.add(new miBoton("X"));
        panelDerecho.add(Box.createVerticalStrut(25));
        panelDerecho.add(new miBoton("O"));
        panelDerecho.add(Box.createVerticalStrut(25));
        panelDerecho.add(new miBoton("|"));

        miPanel panelInferior = new miPanel();
        panelInferior.setPreferredSize(new Dimension(640, 100));
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
        panelInferior.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelInferior.add(Box.createHorizontalGlue());
        panelInferior.add(new miBoton("A"));
        panelInferior.add(Box.createHorizontalStrut(25));
        panelInferior.add(new miBoton("W"));
        panelInferior.add(Box.createHorizontalStrut(25));
        panelInferior.add(new miBoton("S"));
        panelInferior.add(Box.createHorizontalStrut(25));
        panelInferior.add(new miBoton("D"));
        panelInferior.add(Box.createHorizontalGlue());

        ventana.add(panelSuperior, BorderLayout.NORTH);
        ventana.add(panelCentral, BorderLayout.CENTER);
        ventana.add(panelIzquierdo, BorderLayout.WEST);
        ventana.add(panelDerecho, BorderLayout.EAST);
        ventana.add(panelInferior, BorderLayout.SOUTH);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

    }
    
}