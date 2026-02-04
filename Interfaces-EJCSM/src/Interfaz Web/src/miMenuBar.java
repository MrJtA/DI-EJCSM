import java.awt.*;
import javax.swing.*;

public class miMenuBar extends JMenuBar {

    public miMenuBar() {
        
        this.add(Box.createHorizontalGlue());
        this.setBackground(new Color(0, 0, 0));

        JMenu guitarrasEspañolas = crearMenu("Guitarras Españolas");
        JMenu guitarrasElectricas = crearMenu("Guitarras Eléctricas");
        JMenu guitarrasAcusticas = crearMenu("Guitarras Electroacústicas");
        JMenu pedales = crearMenu("Pedales de Efectos");

        JMenuItem alhambraEspañolas = new JMenuItem("Alhambra");
        JMenuItem ibanezEspañolas = new JMenuItem("Ibanez");
        JMenuItem yamahaEspañolas = new JMenuItem("Yamaha");

        JMenuItem fenderElectricas = new JMenuItem("Fender");
        JMenuItem gibsonElectricas = new JMenuItem("Gibson");
        JMenuItem ibanezElectricas = new JMenuItem("Ibanez");
        JMenuItem yamahaElectricas = new JMenuItem("Yamaha");

        JMenuItem fenderElectroacusticas = new JMenuItem("Fender");
        JMenuItem gibsonElectroacusticas = new JMenuItem("Gibson");
        JMenuItem ibanezElectroacusticas = new JMenuItem("Ibanez");
        JMenuItem yamahaElectroacusticas = new JMenuItem("Yamaha");

        JMenuItem nux = new JMenuItem("Nux");
        JMenuItem harmonix = new JMenuItem("Harmonix");
        JMenuItem boss = new JMenuItem("Boss");
        JMenuItem donner = new JMenuItem("Donner");

        guitarrasEspañolas.add(alhambraEspañolas);
        guitarrasEspañolas.add(ibanezEspañolas);
        guitarrasEspañolas.add(yamahaEspañolas);
        guitarrasElectricas.add(fenderElectricas);
        guitarrasElectricas.add(gibsonElectricas);
        guitarrasElectricas.add(ibanezElectricas);
        guitarrasElectricas.add(yamahaElectricas);
        guitarrasAcusticas.add(fenderElectroacusticas);
        guitarrasAcusticas.add(gibsonElectroacusticas);
        guitarrasAcusticas.add(ibanezElectroacusticas);
        guitarrasAcusticas.add(yamahaElectroacusticas);
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

    private JMenu crearMenu(String texto) {
        JMenu menu = new JMenu(texto);
        menu.setFont(new Font("Arial", Font.BOLD, 12));
        menu.setForeground(new Color(255, 255, 255));
        return menu;
    }

}