import java.awt.*;
import javax.swing.*;

public class miEtiqueta extends JLabel {
    
    public miEtiqueta(String mensaje) {

        super(mensaje);
        this.setFont(new Font("Calibri", Font.BOLD, 20));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.setIconTextGap(15);

    }

}