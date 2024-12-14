package com.cobra.productos;

import com.cobra.ProductModule;
import com.cobra.util.Utilidades;

import javax.swing.*;
import java.awt.*;

public class EditarProducto extends JFrame {
    private JComboBox<String> productComboBox;
    private final JTextField txtPrecioProducto;
    private final JTextField txtStockProducto;
    private final ControlProductosDao ctrlProductos = new ControlProductosDao();
    private final Utilidades util = new Utilidades();
    private JButton buscarProducto, editarProducto;

    public EditarProducto() {
        setTitle("Editar Producto");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(64, 64, 64));
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel lblNombreProducto = new JLabel("Nombre del producto");
        lblNombreProducto.setBounds(20, 20, 200, 30); //Posicion del label en la ventana
        lblNombreProducto.setFont(new Font("Arial", Font.BOLD, 14));
        lblNombreProducto.setForeground(Color.WHITE);
        add(lblNombreProducto);

        productComboBox = new JComboBox<>();
        productComboBox.setBounds(240, 20, 200, 30);
        productComboBox.addItem("Traje");
        productComboBox.addItem("Cinta Negra");
        productComboBox.addItem("Cinta Amarilla");
        productComboBox.addItem("Cinta Roja");
        productComboBox.addItem("Cinta Verde");
        //productComboBox = new JComboBox<>(ctrlProductos.getProductsName().toArray(new String[0]));
        add(productComboBox);

        JLabel lblPrecioProducto = new JLabel("Precio del producto");
        lblPrecioProducto.setBounds(20, 90, 200, 30);
        lblPrecioProducto.setFont(util.getFont(1));
        lblPrecioProducto.setForeground(Color.WHITE);
        add(lblPrecioProducto);

        txtPrecioProducto = new JTextField();
        txtPrecioProducto.setBounds(240, 90, 200, 30);
        txtPrecioProducto.setFont(util.getFont(5));
        add(txtPrecioProducto);

        JLabel lblStockProducto = new JLabel("Stock del producto");
        lblStockProducto.setBounds(20, 160, 200, 30);
        lblStockProducto.setFont(util.getFont(1));
        lblStockProducto.setForeground(Color.WHITE);
        add(lblStockProducto);

        txtStockProducto = new JTextField();
        txtStockProducto.setBounds(240, 160, 200, 30);
        txtStockProducto.setFont(util.getFont(5));
        add(txtStockProducto);

        buscarProducto = new JButton("Buscar producto");
        buscarProducto.setBounds(480, 20, 200, 30);
        buscarProducto.setBackground(Color.WHITE);
        buscarProducto.setFocusPainted(false);
        buscarProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        editarProducto = new JButton("Editar producto");
        editarProducto.setBounds(240, 250, 200, 30);
        editarProducto.setBackground(Color.WHITE);
        editarProducto.setFocusPainted(false);
        editarProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        eventosBotones(buscarProducto, 1);
        eventosBotones(editarProducto, 2);

        add(buscarProducto);
        add(editarProducto);
    }

    private void eventosBotones(JButton button, int option) {
        util.efectosBotones(button);
        String productoSeleccionado = (String) productComboBox.getSelectedItem();
        button.addActionListener(e -> {
            switch (option) {
                case 1:
                    if (productoSeleccionado != null) {
                        //  Producto producto = ctrlProductos.getProductByName(productoSeleccionado);
                        // txtPrecioProducto.setText(String.valueOf(producto.getPrice()));
                        //txtStockProducto.setText(String.valueOf(producto.getStock()));
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado");
                    }
                    new ProductModule();
                    dispose();
                    break;
                case 2:
                    if (productoSeleccionado != null) {
                        try {
                            double newPrice = Double.parseDouble(txtPrecioProducto.getText());
                            int newStock = Integer.parseInt(txtStockProducto.getText());
                            //ctrlProductos.updateProduct(productoSeleccionado, newPrice, newStock);
                            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error al actualizar el producto");
                        }
                    }
                    new ProductModule();
                    dispose();
                    break;
            }
        });
    }
}

