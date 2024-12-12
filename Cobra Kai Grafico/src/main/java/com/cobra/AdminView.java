package com.cobra;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class AdminView extends JFrame {

    public AdminView() {
        setTitle("Módulo Administrador");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Título principal
        JLabel titleTablaClientes = new JLabel("Clientes registrados");
        titleTablaClientes.setBounds(20, 10, 200, 25);
        titleTablaClientes.setFont(new Font("Arial", Font.BOLD, 14));
        add(titleTablaClientes);

        // Tabla de clientes
        String[] columnNames = {"Cliente", "Nit", "Compras realizadas"};
        Object[][] data = {
                {"Erwin Vásquez", "C/F", 78},
                {"Cliente anónimo", "1234456", 12}
        };
        JTable clientTable = new JTable(data, columnNames);
        clientTable.setBounds(20, 50, 400, 100);
        clientTable.setRowHeight(25);
        clientTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JScrollPane tableScrollPane = new JScrollPane(clientTable);
        tableScrollPane.setBounds(20, 50, 400, 100);
        add(tableScrollPane);

        // Botón "Guardar información"
        JButton saveButton = new JButton("Guardar información");
        saveButton.setBounds(20, 160, 200, 30);
        saveButton.setBackground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        // Botón "Cerrar sesión"
        JButton logoutButton = new JButton("Cerrar sesión");
        logoutButton.setBounds(20, 320, 150, 30);
        logoutButton.setBackground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        // Módulos
        JButton productModuleButton = new JButton("Módulo de productos");
        productModuleButton.setBounds(450, 50, 150, 30);
        productModuleButton.setBackground(Color.WHITE);
        productModuleButton.setFocusPainted(false);
        productModuleButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        JButton clientModuleButton = new JButton("Módulo de clientes");
        clientModuleButton.setBounds(450, 90, 150, 30);
        clientModuleButton.setBackground(Color.WHITE);
        clientModuleButton.setFocusPainted(false);
        clientModuleButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton salesModuleButton = new JButton("Módulo de ventas");
        salesModuleButton.setBounds(450, 130, 150, 30);
        salesModuleButton.setBackground(Color.WHITE);
        salesModuleButton.setFocusPainted(false);
        salesModuleButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //Agregamos efectos a los botones
        hoverEffect(saveButton);
        hoverEffect(logoutButton);
        hoverEffect(productModuleButton);
        hoverEffect(clientModuleButton);
        hoverEffect(salesModuleButton);

        //Agregamos los botones al frame
        add(saveButton);
        add(logoutButton);
        add(productModuleButton);
        add(clientModuleButton);
        add(salesModuleButton);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void hoverEffect(JButton button){
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button.setBackground(new Color(220, 220, 220));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                button.setBackground(Color.WHITE);
            }
        });

    }

}
