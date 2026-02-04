import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Inicio extends JPanel {

    public Inicio() throws Exception {

        this.setLayout(new GridLayout(2, 2, 20, 20)); 
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        this.setSize(640,640);
        this.setBackground(Color.WHITE);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document documento = builder.parse(new File("src/categorias.xml"));
        documento.getDocumentElement().normalize();
        NodeList nodosListaCategorias = documento.getElementsByTagName("categoria");
        for (int i = 0; i < nodosListaCategorias.getLength(); i++) {
            Node categoria = nodosListaCategorias.item(i);         
            if (categoria.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) categoria;               
                String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                String rutaIcono = elemento.getElementsByTagName("icono").item(0).getTextContent();
                miEtiqueta etiquetaCategoria = new miEtiqueta(nombre);
                try {
                    ImageIcon iconoOriginal = new ImageIcon(rutaIcono);
                    Image imgEscalada = iconoOriginal.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                    etiquetaCategoria.setIcon(new ImageIcon(imgEscalada));
                } catch (Exception e) {
                    System.err.println("No se pudo cargar la imagen: " + rutaIcono);
                }
                this.add(etiquetaCategoria);
            }
        }

    }

}