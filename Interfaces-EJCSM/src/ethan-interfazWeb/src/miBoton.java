import java.awt.*;
import javax.swing.*;


class miBoton extends JButton {

    public miBoton(String nombre, String rutaImagen) {
        super(nombre);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setOpaque(false);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setFont(new Font("Calibri", Font.PLAIN, 14));
        this.setIconTextGap(10);
        this.setHorizontalTextPosition(SwingConstants.RIGHT);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        if (rutaImagen != null && !rutaImagen.isEmpty()) {
            this.setIcon(generarIcono(rutaImagen));
        }
    }

    private ImageIcon generarIcono(String rutaImagen) {
        try {
            ImageIcon iconoOriginal = new ImageIcon(rutaImagen);
            Image img = iconoOriginal.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        } catch (Exception e) {
            System.err.println("Error al cargar: " + rutaImagen);
            return null;
        }
    }

}