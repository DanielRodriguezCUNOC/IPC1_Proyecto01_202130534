package com.cobra.productos;

import com.cobra.ProductModule;
import com.cobra.util.Utilidades;

import javax.swing.*;
import java.awt.*;

public class EditarProducto extends JFrame {
    private final ControlProductosDAO ctrlProductos = ControlProductosDAO.getInstance();
    private final Utilidades util = new Utilidades();
    private final JComboBox<String> productComboBox;
    private final JTextField txtPrecioProducto;
    private final JTextField txtStockProducto;

    public EditarProducto() {
        setTitle("Editar Producto");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(64, 64, 64));
        setLocationRelativeTo(null);
        setVisible(true);

        //Creamos los componentes de la ventana
        JLabel lblNombreProducto = new JLabel("Nombre del producto");
        lblNombreProducto.setBounds(20, 20, 200, 30); //Posicion del label en la ventana
        lblNombreProducto.setFont(util.getFont(1));
        lblNombreProducto.setForeground(Color.WHITE);
        add(lblNombreProducto);


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

        productComboBox = new JComboBox<>(ctrlProductos.getNombresProductos().toArray(new String[0]));
        productComboBox.setBounds(240, 20, 200, 30);
        productComboBox.setFont(util.getFont(1));
        // Autocompletamos los campos del producto seleccionado
        productComboBox.addActionListener(e -> {
            String selectedProduct = (String) productComboBox.getSelectedItem();
            if (selectedProduct != null) {
                double price = ctrlProductos.getPrecioProducto(selectedProduct);
                int stock = ctrlProductos.getStockProducto(selectedProduct);
                txtPrecioProducto.setText(String.valueOf(price));
                txtStockProducto.setText(String.valueOf(stock));
            }
        });
        add(productComboBox);

        JButton editarProducto = new JButton("Editar producto");
        editarProducto.setBounds(240, 250, 200, 30);
        editarProducto.setBackground(Color.WHITE);
        editarProducto.setFocusPainted(false);
        editarProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        eventosBotones(editarProducto);
        add(editarProducto);
    }

    private void eventosBotones(JButton button) {
        util.efectosBotones(button);
        String productoSeleccionado = (String) productComboBox.getSelectedItem();
        button.addActionListener(e -> {
            accionBoton();
        });
    }

    private void accionBoton() {
        String productoSeleccionado = (String) productComboBox.getSelectedItem();
        try {
            if (productoSeleccionado != null) {
                double newPrice = Double.parseDouble(txtPrecioProducto.getText());
                int newStock = Integer.parseInt(txtStockProducto.getText());
                ctrlProductos.editarProducto(productoSeleccionado, newPrice, newStock);
                if (ctrlProductos.getConfirmarAccion()) {
                    JOptionPane.showMessageDialog(null, "Producto editado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al editar el producto, revise los datos ingresados");
                }
            }
            int option = JOptionPane.showConfirmDialog(null, "Desea editar otro producto?", "Editar Producto", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                txtPrecioProducto.setText("");
                txtStockProducto.setText("");
            } else {
                new ProductModule();
                dispose();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace(System.out);
            int opcion = JOptionPane.showConfirmDialog(null, "Error al editar el producto. Desea seguir editando?", "Error", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                txtPrecioProducto.setText("");
                txtStockProducto.setText("");
            } else {
                new ProductModule();
                dispose();
            }
        }
    }
}

