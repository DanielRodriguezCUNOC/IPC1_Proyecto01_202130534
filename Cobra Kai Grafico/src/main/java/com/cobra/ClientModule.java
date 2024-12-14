package com.cobra;

import com.cobra.util.Utilidades;

import javax.swing.*;
import java.awt.*;

public class ClientModule extends JFrame {
    Utilidades util = new Utilidades();

    public ClientModule() {
        setTitle("Módulo de Clientes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(64, 64, 64));
        setLocationRelativeTo(null);
        setVisible(true);

        JButton btnCrearCliente = new JButton("Crear Cliente");
        btnCrearCliente.setBounds(100, 50, 200, 30);
        btnCrearCliente.setBackground(Color.WHITE);
        btnCrearCliente.setFocusPainted(false);
        btnCrearCliente.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));


        JButton btnEditarCliente = new JButton("Editar Cliente");
        btnEditarCliente.setBounds(100, 100, 200, 30);
        btnEditarCliente.setBackground(Color.WHITE);
        btnEditarCliente.setFocusPainted(false);
        btnEditarCliente.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));

        JButton btnBackAdminView = new JButton("Volver al modulo de administrador");
        btnBackAdminView.setBounds(50, 180, 300, 30);
        btnBackAdminView.setBackground(Color.WHITE);
        btnBackAdminView.setFocusPainted(false);
        btnBackAdminView.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));

        eventoBotones(btnCrearCliente, 1);
        eventoBotones(btnEditarCliente, 2);
        eventoBotones(btnBackAdminView, 3);

        add(btnCrearCliente);
        add(btnEditarCliente);
        add(btnBackAdminView);

    }

    public void eventoBotones(JButton button, int option) {
        util.efectosBotones(button);
        button.addActionListener((e) -> {
            switch (option) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Crear Cliente");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Editar Cliente");
                    break;
                case 3:
                    new AdminView();
                    dispose();
                    break;
            }
        });
    }
}
