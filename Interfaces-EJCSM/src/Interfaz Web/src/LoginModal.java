import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class LoginModal extends JDialog {

    private JTextField usuario;
    private JTextField password;
    private Boolean logueado;
    private JButton enviar; 

    public LoginModal(Frame padre) {
        super(padre, true);
        this.logueado = false;
        setTitle("Guitar Center Login ");   
        setSize(200, 320);
        setLayout(new GridBagLayout());
        GridBagConstraints datosGrid = new GridBagConstraints();

        datosGrid.weightx = 0.1;
        datosGrid.weighty = 0.12;
        datosGrid.gridx = 0;
        datosGrid.gridy = 0;
        datosGrid.fill = GridBagConstraints.HORIZONTAL;
        JLabel espaciadorIzqda = new JLabel("    ");
        add(espaciadorIzqda, datosGrid);

        datosGrid.weightx = 0.1;
        datosGrid.weighty = 0.12;
        datosGrid.gridx = 3;
        datosGrid.gridy = 0;
        datosGrid.fill = GridBagConstraints.HORIZONTAL;
        JLabel espaciadorDcha = new JLabel("    ");
        add(espaciadorDcha, datosGrid);

        datosGrid.weightx = 0.4;
        datosGrid.weighty = 0.12;
        datosGrid.gridx = 1;
        datosGrid.gridy = 1;
        JLabel usuarioLabel = new JLabel("Usuario");
        add(usuarioLabel, datosGrid);

        datosGrid.weightx = 0.4;
        datosGrid.weighty = 0.12;
        datosGrid.fill = GridBagConstraints.HORIZONTAL;
        datosGrid.gridx = 2;
        datosGrid.gridy = 1;
        usuario = new JTextField(20);
        add(usuario, datosGrid);

        datosGrid.weightx = 0.4;
        datosGrid.weighty = 0.12;
        datosGrid.gridx = 1;
        datosGrid.gridy = 5;
        datosGrid.fill = GridBagConstraints.NONE; 
        JLabel passwordLabel = new JLabel("Password");
        add(passwordLabel, datosGrid);

        datosGrid.weightx = 0.4;
        datosGrid.weighty = 0.12;
        datosGrid.fill = GridBagConstraints.HORIZONTAL;
        datosGrid.gridx = 2;
        datosGrid.gridy = 5;
        password = new JTextField(20);
        add(password, datosGrid);

        datosGrid.gridx = 2;
        datosGrid.gridy = 7;
        enviar = new JButton("Enviar");
        add(enviar, datosGrid);

        enviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                LoginModal.this.logueado = true; 
                setVisible(false);
            }
        });
    }

    public String validarUsuario(String userTxt, String passTxt) {
        try {
            File archivo = new File("src/usuarios.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(archivo);
            documento.getDocumentElement().normalize();
            NodeList listaUsuarios = documento.getElementsByTagName("usuario");
            for (int i = 0; i < listaUsuarios.getLength(); i++) {
                Element usuarioNode = (Element) listaUsuarios.item(i);          
                String userXML = usuarioNode.getElementsByTagName("username").item(0).getTextContent();
                String passXML = usuarioNode.getElementsByTagName("password").item(0).getTextContent();
                String userName = usuarioNode.getElementsByTagName("nombre").item(0).getTextContent();
                if (userXML.equals(userTxt) && passXML.equals(passTxt)) {
                    return userName;
                }
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            System.err.println("Error leyendo usuarios: " + e.getMessage());
        }
        return "";
    }

    public String getUsuario() { 
        return usuario.getText(); 
    }

    public String getContraseña() {
        return password.getText();
    }

    public JButton getEnviar() {
        return enviar;
    }
    
    public Boolean isLogueado() {
        return logueado;
    }

}