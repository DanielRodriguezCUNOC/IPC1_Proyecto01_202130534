package com.cobra.productos;

import com.cobra.ProductModule;
import com.cobra.util.Utilidades;

import javax.swing.*;
import java.awt.*;

public class EliminarProducto extends JFrame {
    ControlProductosDAO controlProductosDAO = ControlProductosDAO.getInstance();
    JComboBox<String> productComboBox;
    JButton btnEliminarProducto;
    Utilidades util = new Utilidades();

    public EliminarProducto() {
        setTitle("Eliminar Producto");
        setSize(500, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(64, 64, 64));
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel lblNombreProducto = new JLabel("Nombre del producto");
        lblNombreProducto.setBounds(20, 80, 200, 30);
        lblNombreProducto.setFont(util.getFont(1));
        lblNombreProducto.setForeground(Color.WHITE);
        add(lblNombreProducto);

        productComboBox = new JComboBox<>(controlProductosDAO.getNombresProductos().toArray(new String[0]));
        productComboBox.setBounds(240, 80, 200, 30);
        productComboBox.setFont(util.getFont(1));

        add(productComboBox);

        btnEliminarProducto = new JButton("Eliminar producto");
        btnEliminarProducto.setBounds(150, 180, 200, 30);
        btnEliminarProducto.setBackground(Color.WHITE);
        btnEliminarProducto.setFocusPainted(false);
        btnEliminarProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        eventoBoton(btnEliminarProducto);
        add(btnEliminarProducto);

    }

    private void eventoBoton(JButton button) {
        util.efectosBotones(button);
        button.addActionListener(e -> {
            accionBoton();
        });

    }

    private void accionBoton() {
        String selectedProduct = (String) productComboBox.getSelectedItem();
        // Verificamos si se ha seleccionado un producto
        if (selectedProduct != null && !selectedProduct.isEmpty()) {
            int confirmation = JOptionPane.showConfirmDialog(this,
                    "¿Estás seguro de eliminar " + selectedProduct + "?",
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                controlProductosDAO.deleteProducto(selectedProduct);
                JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.");
                productComboBox.removeItem(selectedProduct); // Actualizamos el combobox
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un producto para eliminar.");
        }
        // Preguntamos si desea eliminar otro producto
        int option = JOptionPane.showConfirmDialog(this, "¿Deseas eliminar otro producto?", "Eliminar Producto", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.NO_OPTION) {
            new ProductModule();
            this.dispose();
        }
    }
}
