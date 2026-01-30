package interfazWeb;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginModal extends JDialog {
    private JTextField usuario;
    private JTextField password;
    private Boolean logueado;
    private JButton enviar;

    public LoginModal(Frame padre) {
        super(padre, true);
        logueado = false;
        setTitle("Guitar Center Login ");
        setSize(200,320);
        setLayout(new GridBagLayout());
        GridBagConstraints datosGrid = new GridBagConstraints();
        //datosGrid.gridwidth = 4;
        //datosGrid.gridheight = 8;
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
        getContentPane().add(usuario, datosGrid);
        datosGrid.weightx = 0.4;
        datosGrid.weighty = 0.12;
        datosGrid.gridx = 1;
        datosGrid.gridy = 5;
        JLabel passwordLabel = new JLabel("Password");
        add(passwordLabel, datosGrid);
        datosGrid.weightx = 0.4;
        datosGrid.weighty = 0.12;
        datosGrid.gridx = 2;
        datosGrid.gridy = 5;
        password = new JTextField(20);
        add(password, datosGrid);
        getContentPane().add(password, datosGrid);
        datosGrid.gridx = 2;
        datosGrid.gridy = 7;
        enviar = new JButton("Enviar");
        add(enviar, datosGrid);

        //Añadimos un listener al botón enviar para cerrar la ventan modal y poner logueado a 1
        enviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                this.logueado = true; 
            }
        });
    }
    public String getUsuario() { 
        return usuario.getUsuario(); 
    }
    public JButton getEnviar() {
        return enviar;
    }


}
