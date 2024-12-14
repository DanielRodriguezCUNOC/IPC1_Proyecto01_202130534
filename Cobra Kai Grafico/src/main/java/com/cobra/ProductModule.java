package com.cobra;

import com.cobra.productos.CrearProducto;
import com.cobra.productos.EditarProducto;
import com.cobra.productos.EliminarProducto;
import com.cobra.util.Utilidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProductModule extends JFrame {
    Utilidades util = new Utilidades();

    public ProductModule() {
        //Configuracion de la ventana
        setTitle("Módulo de Productos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(64, 64, 64));

        //Tabla de productos
        String[] columnNames = {"Producto", "Precio", "Stock"};
        Object[][] data = {
                {"Traje", 200, 20},
                {"Cinta Negra", 175, 10},
                {"Cinta Amarilla", 150, 30},
                {"Cinta Roja", 100, 25},
                {"Cinta Verde", 75, 15}
        };
        JTable productsTable = new JTable(data, columnNames);
        productsTable.setBounds(20, 50, 400, 180);
        productsTable.setRowHeight(30);
        productsTable.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));
        JScrollPane tableScrollPane = new JScrollPane(productsTable);
        tableScrollPane.setBounds(20, 50, 400, 180);
        add(tableScrollPane);

        // Botón generar reportes de productos mas vendidos
        JButton btnGenerarReporteMasVendidos = new JButton("Generar reporte de productos más vendidos");
        btnGenerarReporteMasVendidos.setBounds(20, 260, 400, 30);
        btnGenerarReporteMasVendidos.setBackground(Color.WHITE);
        btnGenerarReporteMasVendidos.setFocusPainted(false);
        btnGenerarReporteMasVendidos.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Botones para módulos

        //Boton creacion de producto
        JButton btnCrearProductoIndividual = new JButton("Creacion de producto");
        btnCrearProductoIndividual.setBounds(500, 50, 200, 30);
        btnCrearProductoIndividual.setBackground(Color.WHITE);
        btnCrearProductoIndividual.setFocusPainted(false);
        btnCrearProductoIndividual.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));

        //Boton carga masiva de productos
        JButton btnCargaMasivaProductos = new JButton("Carga masiva de productos");
        btnCargaMasivaProductos.setBounds(500, 120, 200, 30);
        btnCargaMasivaProductos.setBackground(Color.WHITE);
        btnCargaMasivaProductos.setFocusPainted(false);
        btnCargaMasivaProductos.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));

        //Boton edicion de productos
        JButton btnEditarProducto = new JButton("Edicion de productos");
        btnEditarProducto.setBounds(500, 190, 200, 30);
        btnEditarProducto.setBackground(Color.WHITE);
        btnEditarProducto.setFocusPainted(false);
        btnEditarProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));

        //Boton eleminiar producto
        JButton btnDeleteProduct = new JButton("Eliminar Producto");
        btnDeleteProduct.setBounds(500, 260, 200, 30);
        btnDeleteProduct.setBackground(Color.WHITE);
        btnDeleteProduct.setFocusPainted(false);
        btnDeleteProduct.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));

        // Botón volver al modulo administrador
        JButton btnBackAdminView = new JButton("Volver modulo administrador");
        btnBackAdminView.setBounds(20, 370, 300, 30);
        btnBackAdminView.setBackground(Color.WHITE);
        btnBackAdminView.setFocusPainted(false);
        btnBackAdminView.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //Agregamos eventos a los botones
        eventosBotones(btnCrearProductoIndividual, 1);
        eventosBotones(btnCargaMasivaProductos, 2);
        eventosBotones(btnEditarProducto, 3);
        eventosBotones(btnDeleteProduct, 4);
        eventosBotones(btnGenerarReporteMasVendidos, 5);
        eventosBotones(btnBackAdminView, 6);

        //Agregamos los botones al frame
        add(btnCrearProductoIndividual);
        add(btnCargaMasivaProductos);
        add(btnEditarProducto);
        add(btnDeleteProduct);
        add(btnGenerarReporteMasVendidos);
        add(btnBackAdminView);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void eventosBotones(JButton button, int option) {
        util.efectosBotones(button);
        //Agregar funcionalidad a los botones
        button.addActionListener((ActionEvent e) -> {
            switch (option) {
                case 1:
                    new CrearProducto();
                    dispose();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(this, "Carga Masiva de Productos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    new EditarProducto();
                    dispose();
                    break;
                case 4:
                    new EliminarProducto();
                    dispose();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(this, "Reporte Productos Mas Vendidos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 6:
                    new AdminView();
                    dispose();
                    break;

            }
        });

    }
}
