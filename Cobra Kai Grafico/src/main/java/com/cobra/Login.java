package com.cobra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    Color bgColor = new Color(64,64,64);
    CustomFonts cf = new CustomFonts();

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
        titleLabel.setFont(cf.getFont(2));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel);

        //Label usuario
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(100, 100, 100, 25);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(cf.getFont(1));
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(200, 100, 150, 25);
        userField.setForeground(Color.BLACK);
        userField.setBorder(BorderFactory.createLineBorder(bgColor, 0, false));
        userField.setBackground(Color.WHITE);
        add(userField);

        JLabel passLabel = new JLabel("Contraseña:");
        passLabel.setBounds(100, 150, 100, 25);
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(cf.getFont(1));
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(200, 150, 150, 25);
        passField.setForeground(Color.BLACK);
        passField.setBorder(BorderFactory.createLineBorder(bgColor, 0, false));
        passField.setBackground(Color.WHITE);
        add(passField);

        loginButton = new JButton("Ingresar");
        loginButton.setBounds(200, 200, 150, 25);
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(Color.BLACK);
        loginButton.setFont(cf.getFont(1));
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createLineBorder(bgColor, 0, false));
        //Agregamos un efecto hover
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(Color.BLACK);
                loginButton.setForeground(Color.WHITE);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(Color.WHITE);
                loginButton.setForeground(Color.BLACK);
            }
        });
        loginButton.addActionListener((ActionEvent e) -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if (user.equals("admin") && pass.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Login exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(loginButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }


}
