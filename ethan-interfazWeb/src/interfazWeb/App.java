package interfazWeb;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

class menuBar extends JMenuBar {

    public menuBar() {
        
        this.add(Box.createHorizontalGlue());
        this.setBackground(new Color(0, 0, 0));
        Font fuenteCalibri = new Font("Calibri", Font.PLAIN, 14);
        Color blanco = Color.WHITE;

        JMenu guitarrasEspañolas = crearMenu("Guitarras Españolas", fuenteCalibri, blanco);
        JMenu guitarrasElectricas = crearMenu("Guitarras Eléctricas", fuenteCalibri, blanco);
        JMenu guitarrasAcusticas = crearMenu("Guitarras Electroacústicas", fuenteCalibri, blanco);
        JMenu pedales = crearMenu("Pedales de Efectos", fuenteCalibri, blanco);

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

    private JMenu crearMenu(String texto, Font fuente, Color color) {
        JMenu menu = new JMenu(texto);
        menu.setFont(fuente);
        menu.setForeground(color);
        return menu;
    }

}

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

public class App extends JFrame {
    
    public App() {

        super("Supermusic");
        this.setSize(1280, 720);
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(4, 1));
        header.setPreferredSize(new Dimension(1280, 140));

        JLabel mensaje = new JLabel("Supermusic", SwingConstants.CENTER);
        mensaje.setFont(new Font("Calibri", Font.BOLD, 20));
        mensaje.setHorizontalAlignment(JLabel.CENTER);

        JPanel intermedio = new JPanel();
        intermedio.setLayout(new GridLayout(1, 3));
        miBoton menuGeneral = new miBoton("Menú general", "src/images/menu.png");
        miBoton buscador = new miBoton("Buscar", "src/images/buscador.png");
        miBoton inicioSesion = new miBoton("Iniciar sesión", "src/images/usuario.png");
        intermedio.add(menuGeneral);
        intermedio.add(buscador);
        intermedio.add(inicioSesion);

        menuBar menuBar = new menuBar();

        String nombreUsuario = "";
        JLabel bienvenido = new JLabel("Bienvenido, " + nombreUsuario, SwingConstants.CENTER);
        bienvenido.setFont(new Font("Calibri", Font.BOLD, 20));
        bienvenido.setHorizontalAlignment(JLabel.CENTER);

        header.add(mensaje);
        header.add(intermedio);
        header.add(menuBar);
        header.add(bienvenido);


        JPanel cuerpo = new JPanel();
        cuerpo.setBackground(new Color(255, 255, 255));
        cuerpo.setLayout(new BorderLayout());

        JLabel nuestrasCategorias = new JLabel("Nuestras categorías", SwingConstants.CENTER);
        cuerpo.add(nuestrasCategorias, BorderLayout.NORTH);
        nuestrasCategorias.setFont(new Font("Calibri", Font.BOLD, 20));
        nuestrasCategorias.setHorizontalAlignment(JLabel.CENTER);

        JPanel panelIzquierdoRelleno = new JPanel();
        panelIzquierdoRelleno.setPreferredSize(new Dimension(0, 100));
        cuerpo.add(panelIzquierdoRelleno, BorderLayout.WEST);
        JPanel panelDerechoRelleno = new JPanel();
        cuerpo.add(panelDerechoRelleno, BorderLayout.EAST);
        panelIzquierdoRelleno.setPreferredSize(new Dimension(0, 100));

        JPanel contenido = new JPanel();
        contenido.setLayout(new GridLayout(2, 2));
        cuerpo.add(contenido, BorderLayout.CENTER);



        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new GridLayout(5, 1));
        panelMenu.setPreferredSize(new Dimension(250, 0));
        panelMenu.setVisible(false);
        miBoton cerrarMenu = new miBoton("Cerrar menú", "src/images/x.png");
        panelMenu.add(cerrarMenu);
        miBoton guitarraEsp = new miBoton("Guitarras Españolas", null);
        miBoton guitarraEle = new miBoton("Guitarras Elécricas", null);
        miBoton guitarraEla = new miBoton("Guitarras Electroacústicas", null);
        miBoton pedalesEfx = new miBoton("Pedales de Efectos", null);
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

        menuGeneral.addActionListener(e -> {
            panelMenu.setVisible(!panelMenu.isVisible());
            this.revalidate();
            this.repaint();
        });

        cerrarMenu.addActionListener(e -> {
            panelMenu.setVisible(false);
            this.revalidate();
            this.repaint();
        });
        
        this.add(header, BorderLayout.NORTH);
        this.add(cuerpo, BorderLayout.CENTER);
        this.add(panelMenu, BorderLayout.WEST);
        this.setVisible(true);

    }
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            new App();
        });

    }

}