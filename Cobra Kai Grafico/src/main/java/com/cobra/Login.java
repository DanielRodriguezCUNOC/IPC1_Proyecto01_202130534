package com.cobra;

import com.cobra.util.Utilidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    Color bgColor = new Color(64, 64, 64);
    Utilidades util = new Utilidades();

    public Login() {
        setTitle("Login");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(bgColor);


        //Label titulo
        JLabel titleLabel = new JLabel("Inicio Sesion Cobra Kai Dojo");
        titleLabel.setBounds(100, 20, 400, 30);
        titleLabel.setFont(util.getFont(2));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel);

        //Label usuario
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(100, 100, 100, 25);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(util.getFont(1));
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(200, 100, 150, 25);
        userField.setForeground(Color.BLACK);
        userField.setFont(util.getFont(5));
        userField.setBorder(BorderFactory.createLineBorder(bgColor, 0, false));
        userField.setBackground(Color.WHITE);
        add(userField);

        JLabel passLabel = new JLabel("Contraseña:");
        passLabel.setBounds(100, 150, 100, 25);
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(util.getFont(1));
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(200, 150, 150, 25);
        passField.setForeground(Color.BLACK);
        passField.setFont(util.getFont(5));
        passField.setBorder(BorderFactory.createLineBorder(bgColor, 0, false));
        passField.setBackground(Color.WHITE);
        add(passField);

        loginButton = new JButton("Ingresar");
        loginButton.setBounds(200, 200, 150, 25);
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(Color.BLACK);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createLineBorder(bgColor, 0, false));
        //Agregamos un efecto hover
        util.efectosBotones(loginButton);
        //Agregamos un evento al botón
        loginButton.addActionListener((ActionEvent e) -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if (user.equals("sensei_202130534") && pass.equals("ipc1_202130534")) {
                int opcion = JOptionPane.showConfirmDialog(this, "Login exitoso!", "Éxito", JOptionPane.OK_CANCEL_OPTION);
                if (opcion == JOptionPane.OK_OPTION) {
                    new AdminView(); //Iniciamos la vista de administrador
                    dispose();//Cerramos la ventana de login
                }
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(loginButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

}
