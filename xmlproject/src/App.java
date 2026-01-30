import org.w3c.dom.*;

import javax.swing.*;
import java.awt.*;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;
import java.io.*;


public class App {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory dBfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dBfactory.newDocumentBuilder();

        //Creamos un JFrame
        JFrame ventana = new JFrame();
        ventana.setSize(800,600);
        ventana.setLayout(new FlowLayout());
        JTextArea areaTexto = new JTextArea();
        areaTexto.setSize(320,200);
        ventana.add(areaTexto);


        // Cargo el fichero XML
        Document document = builder.parse(new File("estudiantes.xml"));
        document.getDocumentElement().normalize();
        //Obtenemos el nodo raiz del documento XML
        Element raiz = document.getDocumentElement();
        System.out.println(raiz.getNodeName());

        //Get all students
        NodeList nList = document.getElementsByTagName("student");
        System.out.println(nList);
        System.out.println(".................................");
        for (var i=0; i<nList.getLength(); i++) {
            Node estudiante = nList.item(i);
            if (estudiante.getNodeType() == Node.ELEMENT_NODE) {
                //Imprime los detalles de cada estudiante
                Element element = (Element) estudiante;
                areaTexto.append("Student id : " + element.getAttribute("id") + "\n");
                var nombre = element.getElementsByTagName("Name").item(0).getTextContent();
                areaTexto.append("Student name : " + nombre + "\n");
                var pais = element.getElementsByTagName("location").item(0).getTextContent();
                areaTexto.append("Student location : " + pais + "\n");
                var rol = element.getElementsByTagName("id").item(0).getTextContent();
                areaTexto.append("Student roll : " + rol + "\n\n");
            }

        }

        //Hacemos la ventana visible
        ventana.setVisible(true);
    }
}
