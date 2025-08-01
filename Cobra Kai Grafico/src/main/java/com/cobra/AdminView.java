package com.cobra;

import com.cobra.clientes.DatosParaTablaCliente;
import com.cobra.manejodatos.SerializarObjetos;
import com.cobra.util.Utilidades;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminView extends JFrame {

    Utilidades util = new Utilidades();
    DatosParaTablaCliente datosTabla;

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
        datosTabla = new DatosParaTablaCliente();
        JTable clientTable = new JTable(datosTabla.getData(), datosTabla.getColumns());
        //Alinear los datos al centro
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < clientTable.getColumnCount(); i++) {
            clientTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        clientTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        clientTable.setBounds(20, 50, 400, 100);
        clientTable.setRowHeight(30);
        clientTable.setFont(util.getFont(1));
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
        button.addActionListener((ActionEvent e) -> {
            switch (option) {
                case 1:
                    try {
                        new SerializarObjetos();
                        JOptionPane.showMessageDialog(null, "Información guardada con éxito");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error al guardar la información");
                    }
                    break;
                case 2:
                    new Login();
                    dispose();
                    break;
                case 3:
                    new ProductModule();
                    dispose();
                    break;
                case 4:
                    new ClientModule();
                    dispose();
                    break;
                case 5:
                    new SaleModule();
                    dispose();
                    break;
            }
        });

    }

}
