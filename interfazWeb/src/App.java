import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) throws Exception {

        //Creamos la ventana principal con distribución BorderLayout
        JFrame ventana = new JFrame();
        ventana.setLayout(new BorderLayout());
        ventana.setSize(1280,720);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creamos JPanel para la parte superior del BorderLayout
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(2, 3));

        //Creamos la barra de menús
        JMenuBar menuBar = new JMenuBar();
        //Creamos los elementos principales (raiz) del menú
        JMenu guitarrasEsp = new JMenu("Guitarras Españolas");
        JMenu guitarrasEle = new JMenu("Guitarras Eléctricas");
        JMenu guitarrasAcu = new JMenu("Guitarras Electroacísticas");
        JMenu pedalesGuita = new JMenu("Pedales de Efectos");
        
        //Creamos los elementos de cada opción del menú raíz
        JMenuItem ibanez = new JMenuItem("Ibanez");
        JMenuItem yamaha = new JMenuItem("Yamaha");
        JMenuItem gibson = new JMenuItem("Gibson");
        JMenuItem fender = new JMenuItem("Fender");

        JMenuItem nux = new JMenuItem("Nux");
        JMenuItem harmonix = new JMenuItem("Harmonix");
        JMenuItem boss = new JMenuItem("Boss");
        JMenuItem donner = new JMenuItem("Donner");

        //Añadimos los elementos al menu raíz
        guitarrasEsp.add(ibanez);
        guitarrasEsp.add(yamaha);
        guitarrasEsp.add(gibson);
        guitarrasEsp.add(fender);

        pedalesGuita.add(nux);
        pedalesGuita.add(harmonix);
        pedalesGuita.add(boss);
        pedalesGuita.add(donner);

        //Añadimos los elementos de menú raíz a la barra de menús
        menuBar.add(guitarrasEsp);
        menuBar.add(guitarrasEle);
        menuBar.add(guitarrasAcu);
        menuBar.add(pedalesGuita);

        //Creamos botón de menú general y lo añadimos al panel header
        JButton menuGeneral = new JButton("OMG");
        ImageIcon icono = new ImageIcon("menu-icon.png");
        menuGeneral.setIcon(icono);
        menuGeneral.setBackground(new Color(0, true));
        menuGeneral.setFocusPainted(false);
        menuGeneral.setBorderPainted(false);
        header.add(menuGeneral);

        //Creamos zona de texto para el mensaje de bienvenida
        JLabel mensaje = new JLabel("Bienvenido");
        header.add(mensaje);

        //Creamos botón de inicio de sesión y lo añadimos al panel header
        JButton inicioSesion = new JButton("Iniciar sesión");
        header.add(inicioSesion);
        
        
        //Añadimos la barra de menús al panel header
        header.add(menuBar);

        

        

        //Añadimos el panel con el menú a la parte de arriba del BorderLayout
        ventana.add(header, BorderLayout.NORTH);        
        
        

        LoginModal dialogoModal = new LoginModal((Frame) ventana);
        //dialogoModal.pack(); // para darle tamaño automático a la ventana.
        dialogoModal.setVisible(false);

        //Creamos el panel del lateral izquierdo para el menú general y lo dejamos oculto por defecto
        JPanel panelIzda = new JPanel();
        panelIzda.setLayout(new GridLayout(5, 1));
        panelIzda.setVisible(false);

        //Añadimos el panel izquierdo al BorderLayout WEST
        ventana.add(panelIzda, BorderLayout.WEST);
        ventana.setVisible(true);


        JButton cerrarMenu = new JButton("Cerrar menú");
        ImageIcon cerrarPan = new ImageIcon("close-icon.png");
        cerrarMenu.setIcon(cerrarPan);
        cerrarMenu.setBorderPainted(false);
        cerrarMenu.setFocusPainted(false);
        cerrarMenu.setBackground(new Color(0,true));
        panelIzda.add(cerrarMenu);
        
        //Creamos las opciones principales del menú general y las añadimos al panel izquierdo
        JLabel guitarraEsp = new JLabel("Guitarras Españolas");
        JLabel guitarraEle = new JLabel("Guitarras Elécricas");
        JLabel guitarraEla = new JLabel("Guitarras Electroacústicas");
        JLabel pedalesEfx = new JLabel("Pedales de Efectos");
        panelIzda.add(guitarraEsp);
        panelIzda.add(guitarraEle);
        panelIzda.add(guitarraEla);
        panelIzda.add(pedalesEfx);

        //Creamos un listener para el botón inicar sesión para hacer visible la ventana modal
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

        //Creamos un listener para hacer visible el menú general del panel izquierdo
        menuGeneral.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                panelIzda.setVisible(true);
            }
        });
        

        //Creamos un listener para hacer visible el menú general del panel izquierdo
        cerrarMenu.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                panelIzda.setVisible(false);
            }
        });

    }
}
