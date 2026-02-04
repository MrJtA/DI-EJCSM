import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class GuitarrasElectroacusticas extends JPanel {
    
    public GuitarrasElectroacusticas() throws Exception {
        this.setLayout((LayoutManager) new FlowLayout(FlowLayout.LEFT, 20, 20));
        this.setBackground(Color.WHITE);
        DocumentBuilder builder;
        builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document documento = builder.parse(new File("src/categorias.xml"));
        documento.getDocumentElement().normalize();
        NodeList nodosListaCategorias = documento.getElementsByTagName("categoria");
        for (int i = 0; i < nodosListaCategorias.getLength(); i++) {
            Element elemento = (Element) nodosListaCategorias.item(i);
            String nombreCat = elemento.getElementsByTagName("nombre").item(0).getTextContent();
            if (nombreCat.equals("Guitarras Electroacústicas")) {
                NodeList nodosListaMarcas = elemento.getElementsByTagName("marca");              
                for (int j = 0; j < nodosListaMarcas.getLength(); j++) {
                    Element marca = (Element) nodosListaMarcas.item(j);
                    String nombreMarca = marca.getElementsByTagName("nombre").item(0).getTextContent();
                    NodeList listaModelos = marca.getElementsByTagName("modelo");
                    for (int k = 0; k < listaModelos.getLength(); k++) {
                        String nombreModelo = listaModelos.item(k).getTextContent();
                        this.add(new miEtiqueta(nombreMarca + " - " + nombreModelo));
                    }
                }
            }
        }
    } 

}