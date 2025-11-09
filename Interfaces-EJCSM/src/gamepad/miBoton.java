package gamepad;

import java.awt.*;
import javax.swing.*;

public class miBoton extends JButton {
    
    private static final Dimension FIXED_SIZE = new Dimension(60, 60);

    public miBoton(String texto) {
        super(texto);
        setBackground(new Color(34, 113, 179));
        setForeground(Color.WHITE); 
        setFocusPainted(false);
        setAlignmentX(CENTER_ALIGNMENT);
    }

    @Override
    public Dimension getPreferredSize() {
        return FIXED_SIZE;
    }

    @Override
    public Dimension getMinimumSize() {
        return FIXED_SIZE;
    }

    @Override
    public Dimension getMaximumSize() {
        return FIXED_SIZE;
    }
    

}