package com.cobra;

import com.cobra.util.Utilidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminView extends JFrame {

    Utilidades util = new Utilidades();

    public AdminView() {

        // Configuración de la ventana
        setTitle("Módulo Administrador");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(64, 64, 64));

        // Título principal
        JLabel titleTablaClientes = new JLabel("Clientes registrados");
        titleTablaClientes.setBounds(20, 10, 300, 30);
        titleTablaClientes.setFont(util.getFont(2));
        titleTablaClientes.setForeground(Color.WHITE);
        add(titleTablaClientes);

        // Tabla de clientes
        String[] columnNames = {"Cliente", "Nit", "Compras realizadas"};
        Object[][] data = {
                {"Erwin Vásquez", "C/F", 78},
                {"Cliente anónimo", "1234456", 12}
        };
        JTable clientTable = new JTable(data, columnNames);
        clientTable.setBounds(20, 50, 400, 100);
        clientTable.setRowHeight(30);
        clientTable.setFont(util.getFont(4));
        clientTable.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));
        JScrollPane tableScrollPane = new JScrollPane(clientTable);
        tableScrollPane.setBounds(20, 50, 400, 180);
        add(tableScrollPane);

        // Botón "Guardar información"
        JButton saveButton = new JButton("Guardar información");
        saveButton.setBounds(20, 250, 200, 30);
        saveButton.setBackground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Botón "Cerrar sesión"
        JButton logoutButton = new JButton("Cerrar sesión");
        logoutButton.setBounds(20, 320, 150, 30);
        logoutButton.setBackground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Botones para módulos
        JButton productModuleButton = new JButton("Módulo de productos");
        productModuleButton.setBounds(450, 50, 200, 30);
        productModuleButton.setBackground(Color.WHITE);
        productModuleButton.setFocusPainted(false);
        productModuleButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));

        JButton clientModuleButton = new JButton("Módulo de clientes");
        clientModuleButton.setBounds(450, 120, 150, 30);
        clientModuleButton.setBackground(Color.WHITE);
        clientModuleButton.setFocusPainted(false);
        clientModuleButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));

        JButton salesModuleButton = new JButton("Módulo de ventas");
        salesModuleButton.setBounds(450, 190, 150, 30);
        salesModuleButton.setBackground(Color.WHITE);
        salesModuleButton.setFocusPainted(false);
        salesModuleButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));

        //Agregamos efectos a los botones
        eventosBotones(saveButton, 1);
        eventosBotones(logoutButton, 2);
        eventosBotones(productModuleButton, 3);
        eventosBotones(clientModuleButton, 4);
        eventosBotones(salesModuleButton, 5);

        //Agregamos los botones al frame
        add(saveButton);
        add(logoutButton);
        add(productModuleButton);
        add(clientModuleButton);
        add(salesModuleButton);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void eventosBotones(JButton button, int option) {
        util.efectosBotones(button);
        //Agregar funcionalidad a los botones
        button.addActionListener((ActionEvent e) -> {
            switch (option) {
                case 1:
                    //Lógica para guardar información
                    JOptionPane.showMessageDialog(this, "Info Guardada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    //Lógica para cerrar sesión
                    new Login();
                    dispose();
                    break;
                case 3:
                    //Lógica para abrir módulo de productos
                    new ProductModule();
                    dispose();
                    break;
                case 4:
                    //Lógica para abrir módulo de clientes
                    new ClientModule();
                    dispose();
                    break;
                case 5:
                    //Lógica para abrir módulo de ventas
                    new SaleModule();
                    dispose();
                    break;
            }
        });

    }

}
