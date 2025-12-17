package GamePad;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class miVentana extends JFrame {
    
    public miVentana() {

        super("GamePad");
        this.setSize(640, 480);
        this.setLayout(new BorderLayout());
        miPanel panelCentral = new miPanel();
        panelCentral.setLayout(new GridBagLayout());
        panelCentral.setBackground(new Color(250, 250, 250));

        JTextField textoCentral = new JTextField();
        textoCentral.setHorizontalAlignment(JTextField.CENTER);
        textoCentral.setText("PANTALLA VIDEOJUEGO");
        textoCentral.setEditable(false);
        textoCentral.setForeground(Color.BLACK);
        textoCentral.setBackground(new Color(250, 250, 250));
        textoCentral.setPreferredSize(new Dimension(200, 30));
        panelCentral.add(textoCentral);

        miPanel panelSuperior = new miPanel();
        panelSuperior.setPreferredSize(new Dimension(640, 50));

        miPanel panelIzquierdo = new miPanel();
        panelIzquierdo.setPreferredSize(new Dimension(100, 400));
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS)); 
        panelIzquierdo.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JPanel btnContainerLeft = new JPanel();
        btnContainerLeft.setOpaque(false);
        btnContainerLeft.setLayout(new BoxLayout(btnContainerLeft, BoxLayout.Y_AXIS));
        btnContainerLeft.add(new miBoton("X", textoCentral));
        btnContainerLeft.add(Box.createVerticalStrut(25));
        btnContainerLeft.add(new miBoton("O", textoCentral));
        btnContainerLeft.add(Box.createVerticalStrut(25));
        btnContainerLeft.add(new miBoton("|", textoCentral));
        panelIzquierdo.add(btnContainerLeft);

        miPanel panelDerecho = new miPanel();
        panelDerecho.setPreferredSize(new Dimension(100, 400));
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
        panelDerecho.setBorder(new EmptyBorder(10, 10, 10, 10)); 

        JPanel btnContainerRight = new JPanel();
        btnContainerRight.setOpaque(false);
        btnContainerRight.setLayout(new BoxLayout(btnContainerRight, BoxLayout.Y_AXIS));
        btnContainerRight.add(new miBoton("X", textoCentral));
        btnContainerRight.add(Box.createVerticalStrut(25));
        btnContainerRight.add(new miBoton("O", textoCentral));
        btnContainerRight.add(Box.createVerticalStrut(25));
        btnContainerRight.add(new miBoton("|", textoCentral));
        panelDerecho.add(btnContainerRight);

        miPanel panelInferior = new miPanel();
        panelInferior.setPreferredSize(new Dimension(640, 100));
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
        panelInferior.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        panelInferior.add(Box.createHorizontalGlue());
        panelInferior.add(new miBoton("A", textoCentral));
        panelInferior.add(Box.createHorizontalStrut(15));
        panelInferior.add(new miBoton("W", textoCentral));
        panelInferior.add(Box.createHorizontalStrut(15));
        panelInferior.add(new miBoton("S", textoCentral));
        panelInferior.add(Box.createHorizontalStrut(15));
        panelInferior.add(new miBoton("D", textoCentral));
        panelInferior.add(Box.createHorizontalGlue());

        this.add(panelSuperior, BorderLayout.NORTH);
        this.add(panelCentral, BorderLayout.CENTER);
        this.add(panelIzquierdo, BorderLayout.WEST);
        this.add(panelDerecho, BorderLayout.EAST);
        this.add(panelInferior, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new miVentana();
        });
        
    }
}