package com.cobra.productos;

import com.cobra.ProductModule;
import com.cobra.util.Utilidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CrearProducto extends JFrame {
    ControlProductosDAO controlProductosDAO = ControlProductosDAO.getInstance();
    Utilidades util = new Utilidades();
    JTextField txtNombreProducto = new JTextField();
    JTextField txtPrecioProducto = new JTextField();
    JTextField txtCantidadProducto = new JTextField();

    public CrearProducto() {
        setTitle("Crear Producto");
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(64, 64, 64));
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel lblNombreProducto = new JLabel("Nombre del producto");
        lblNombreProducto.setBounds(20, 20, 200, 30);
        lblNombreProducto.setFont(util.getFont(1));
        lblNombreProducto.setForeground(Color.WHITE);
        add(lblNombreProducto);

        txtNombreProducto.setBounds(240, 20, 200, 30);
        txtNombreProducto.setFont(util.getFont(5));
        add(txtNombreProducto);

        JLabel lblPrecioProducto = new JLabel("Precio del producto");
        lblPrecioProducto.setBounds(20, 90, 200, 30);
        lblPrecioProducto.setFont(util.getFont(1));
        lblPrecioProducto.setForeground(Color.WHITE);
        add(lblPrecioProducto);

        txtPrecioProducto.setBounds(240, 90, 200, 30);
        txtPrecioProducto.setFont(util.getFont(5));
        add(txtPrecioProducto);

        JLabel lblCantidadProducto = new JLabel("Cantidad del producto");
        lblCantidadProducto.setBounds(20, 160, 200, 30);
        lblCantidadProducto.setFont(util.getFont(1));
        lblCantidadProducto.setForeground(Color.WHITE);
        add(lblCantidadProducto);

        txtCantidadProducto.setBounds(240, 160, 200, 30);
        txtCantidadProducto.setFont(util.getFont(5));
        add(txtCantidadProducto);

        JButton btnGuardarProducto = new JButton("Guardar producto");
        btnGuardarProducto.setBounds(150, 250, 200, 30);
        btnGuardarProducto.setBackground(Color.WHITE);
        btnGuardarProducto.setFocusPainted(false);
        btnGuardarProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        eventoBotonGuardarProducto(btnGuardarProducto);
        add(btnGuardarProducto);

    }

    private void eventoBotonGuardarProducto(JButton button) {
        util.efectosBotones(button);
        button.addActionListener((ActionEvent e) -> {
            accionesBotones();
        });
    }

    private void accionesBotones() {
        if (txtNombreProducto.getText().isEmpty() || txtPrecioProducto.getText().isEmpty() || txtCantidadProducto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String nombreProducto = txtNombreProducto.getText();
            double precioProducto = Double.parseDouble(txtPrecioProducto.getText());
            int cantidadProducto = Integer.parseInt(txtCantidadProducto.getText());
            controlProductosDAO.addProductoIndividual(nombreProducto, precioProducto, cantidadProducto);
            if (controlProductosDAO.getConfirmarAccion()) {
                JOptionPane.showMessageDialog(this, "Producto agregado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "No se ha podido agregar el producto, revise los datos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        int option = JOptionPane.showConfirmDialog(this, "Desea agregar otro producto?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.NO_OPTION) {
            new ProductModule();
            dispose();
        } else {
            txtNombreProducto.setText("");
            txtPrecioProducto.setText("");
            txtCantidadProducto.setText("");
        }
    }

}
