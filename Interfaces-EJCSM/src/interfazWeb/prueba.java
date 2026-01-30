package interfazWeb;

import java.awt.*;
import javax.swing.*;

class menuBar extends JMenuBar {

    public menuBar() {

        this.add(Box.createHorizontalGlue());
        JMenu guitarrasEspañolas = new JMenu("Guitarras Españolas");
        JMenu guitarrasElectricas = new JMenu("Guitarras Eléctricas");
        JMenu guitarrasAcusticas = new JMenu("Guitarras Electroacústicas");
        JMenu pedales = new JMenu("Pedales de Efectos");
        JMenuItem alhambra = new JMenuItem("Alhambra");
        JMenuItem ibanez = new JMenuItem("Ibanez");
        JMenuItem yamaha = new JMenuItem("Yamaha");
        JMenuItem gibson = new JMenuItem("Gibson");
        JMenuItem fender = new JMenuItem("Fender");
        JMenuItem nux = new JMenuItem("Nux");
        JMenuItem harmonix = new JMenuItem("Harmonix");
        JMenuItem boss = new JMenuItem("Boss");
        JMenuItem donner = new JMenuItem("Donner");
        guitarrasEspañolas.add(alhambra);
        guitarrasEspañolas.add(ibanez);
        guitarrasEspañolas.add(yamaha);
        guitarrasElectricas.add(fender);
        guitarrasElectricas.add(gibson);
        guitarrasElectricas.add(ibanez);
        guitarrasElectricas.add(yamaha);
        guitarrasAcusticas.add(fender);
        guitarrasAcusticas.add(gibson);
        guitarrasAcusticas.add(ibanez);
        guitarrasAcusticas.add(yamaha);
        pedales.add(boss);
        pedales.add(donner);
        pedales.add(harmonix);
        pedales.add(nux);
        this.add(guitarrasEspañolas);
        this.add(guitarrasElectricas);
        this.add(guitarrasAcusticas);
        this.add(pedales);
        this.add(Box.createHorizontalGlue());

    }

}

public class prueba extends JFrame {
    
    public prueba() {

        super("Supermusic");
        this.setSize(1280, 720);
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(4, 1));
        header.setPreferredSize(new Dimension(1280, 125));

        JLabel mensaje = new JLabel("Supermusic", SwingConstants.CENTER);
        mensaje.setFont(new Font("Arial", Font.BOLD, 20));
        mensaje.setHorizontalAlignment(JLabel.CENTER);

        JPanel intermedio = new JPanel();
        intermedio.setLayout(new GridLayout(1, 3));
        JButton menuGeneral = new JButton("---");
        ImageIcon icono = new ImageIcon("menu-icon.png");
        menuGeneral.setIcon(icono);
        menuGeneral.setBackground(new Color(0, true));
        menuGeneral.setFocusPainted(false);
        menuGeneral.setBorderPainted(false);
        JButton buscador = new JButton("Buscar");
        JButton inicioSesion = new JButton("Iniciar sesión");
        intermedio.add(menuGeneral);
        intermedio.add(buscador);
        intermedio.add(inicioSesion);

        menuBar menuBar = new menuBar();

        String nombreUsuario = "";
        JLabel bienvenido = new JLabel("Bienvenido, " + nombreUsuario, SwingConstants.CENTER);

        header.add(mensaje);
        header.add(intermedio);
        header.add(menuBar);
        header.add(bienvenido);


        JPanel cuerpo = new JPanel();
        cuerpo.setBackground(new Color(72,45,130));


        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new GridLayout(5, 1));
        panelMenu.setVisible(false);
        JButton cerrarMenu = new JButton("Cerrar menú");
        ImageIcon cerrarPan = new ImageIcon("close-icon.png");
        cerrarMenu.setIcon(cerrarPan);
        cerrarMenu.setBorderPainted(false);
        cerrarMenu.setFocusPainted(false);
        cerrarMenu.setBackground(new Color(0,true));
        panelMenu.add(cerrarMenu);
        JLabel guitarraEsp = new JLabel("Guitarras Españolas");
        JLabel guitarraEle = new JLabel("Guitarras Elécricas");
        JLabel guitarraEla = new JLabel("Guitarras Electroacústicas");
        JLabel pedalesEfx = new JLabel("Pedales de Efectos");
        panelMenu.add(guitarraEsp);
        panelMenu.add(guitarraEle);
        panelMenu.add(guitarraEla);
        panelMenu.add(pedalesEfx);

        LoginModal dialogoModal = new LoginModal((Frame) this);
        dialogoModal.setVisible(false);

        inicioSesion.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                dialogoModal.setVisible(true); 
            } 
        });

        dialogoModal.getEnviar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialogoModal.setVisible(false);
            }
        });

        menuGeneral.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelMenu.setVisible(true);
            }
        });
        
        cerrarMenu.addActionListener(new ActionListener() {          
            public void actionPerformed(ActionEvent e) {
                panelMenu.setVisible(false);
            }         
        });
        
        this.add(header, BorderLayout.NORTH);
        this.add(cuerpo, BorderLayout.CENTER);
        this.add(panelMenu, BorderLayout.WEST);
        this.setVisible(true);

    }
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            new prueba();
        });

    }

}