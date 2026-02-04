import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App extends JFrame {
    
    public App() {

        super("Supermusic");
        this.setSize(1280, 800);
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(5, 1));
        header.setPreferredSize(new Dimension(1280, 140));

        miEtiqueta mensaje = new miEtiqueta("Supermusic");

        JPanel intermedio = new JPanel();
        intermedio.setLayout(new GridLayout(1, 3));
        miBoton menuGeneral = new miBoton("Menú general", "src/images/menu.png");
        miBoton buscador = new miBoton("Buscar", "src/images/buscador.png");
        miBoton inicioSesion = new miBoton("Iniciar sesión", "src/images/usuario.png");
        intermedio.add(menuGeneral);
        intermedio.add(buscador);
        intermedio.add(inicioSesion);

        miMenuBar menuBar = new miMenuBar();
        
        miEtiqueta bienvenido = new miEtiqueta("Bienvenido");

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
                String usuario = dialogoModal.getUsuario();
                String contraseña = dialogoModal.getContraseña();
                String nombreUsuario = dialogoModal.validarUsuario(usuario, contraseña);
                if (!nombreUsuario.isEmpty()) {
                    bienvenido.setText("Bienvenido, " + nombreUsuario);
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Datos incorrectos.");
                }
            }
        });

        miEtiqueta nuestrasCategorias = new miEtiqueta("Nuestras categorías:");

        header.add(mensaje);
        header.add(intermedio);
        header.add(menuBar);
        header.add(bienvenido);
        header.add(nuestrasCategorias, BorderLayout.NORTH);

        CardLayout navegador = new CardLayout();
        JPanel cuerpo = new JPanel(navegador);
        cuerpo.setBackground(new Color(255, 255, 255));

        try {
            Inicio vistaInicio = new Inicio();
            GuitarrasEspañolas vistaEspañolas = new GuitarrasEspañolas();
            GuitarrasElectricas vistaElectricas = new GuitarrasElectricas();
            GuitarrasElectroacusticas vistaElectroacusticas = new GuitarrasElectroacusticas();
            Pedales vistaPedales = new Pedales();
            cuerpo.add(vistaInicio, "Inicio");
            cuerpo.add(vistaEspañolas, "GuitarrasEspañolas");
            cuerpo.add(vistaElectricas, "GuitarrasElectricas");
            cuerpo.add(vistaElectroacusticas, "GuitarrasElectroacusticas");
            cuerpo.add(vistaPedales, "Pedales");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new GridLayout(5, 1));
        panelMenu.setPreferredSize(new Dimension(250, 0));
        panelMenu.setVisible(false);
        miBoton cerrarMenu = new miBoton("Cerrar menú", "src/images/x.png");
        panelMenu.add(cerrarMenu);
        miBoton guitarrasEspañolas = new miBoton("Guitarras Españolas", null);
        miBoton guitarrasElectricas = new miBoton("Guitarras Eléctricas", null);
        miBoton guitarrasElectroacusticas = new miBoton("Guitarras Electroacústicas", null);
        miBoton pedalesEfecto = new miBoton("Pedales de Efectos", null);
        panelMenu.add(guitarrasEspañolas);
        panelMenu.add(guitarrasElectricas);
        panelMenu.add(guitarrasElectroacusticas);
        panelMenu.add(pedalesEfecto);

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

        guitarrasEspañolas.addActionListener(e -> {
            navegador.show(cuerpo, "GuitarrasEspañolas");
        });

        guitarrasElectricas.addActionListener(e -> {
            navegador.show(cuerpo, "GuitarrasElectricas");
        });

        guitarrasElectroacusticas.addActionListener(e -> {
            navegador.show(cuerpo, "GuitarrasElectroacusticas");
        });

        pedalesEfecto.addActionListener(e -> {
            navegador.show(cuerpo, "Pedales");
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