package com.cobra.clientes;


import com.cobra.ClientModule;
import com.cobra.util.Utilidades;

import javax.swing.*;
import java.awt.*;

public class CrearCliente extends JFrame {
    Utilidades util = new Utilidades();

    public CrearCliente() {
        setTitle("Crear Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(64, 64, 64));
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 100, 30);
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(util.getFont(1));
        add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(120, 20, 200, 30);
        txtNombre.setFont(util.getFont(5));
        add(txtNombre);

        JLabel lblNit = new JLabel("Nit:");
        lblNit.setBounds(20, 70, 100, 30);
        lblNit.setForeground(Color.WHITE);
        lblNit.setFont(util.getFont(1));
        add(lblNit);

        JTextField txtNit = new JTextField();
        txtNit.setBounds(120, 70, 200, 30);
        txtNit.setFont(util.getFont(5));
        add(txtNit);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(20, 180, 100, 30);
        btnGuardar.setBackground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));
        eventoBoton(btnGuardar);
        add(btnGuardar);

    }

    private void eventoBoton(JButton button) {
        util.efectosBotones(button);
        button.addActionListener((e) -> {
            JOptionPane.showMessageDialog(null, "Cliente guardado");
            new ClientModule();
            dispose();
        });


    }
}
