package com.cobra.ventas;

import com.cobra.SaleModule;
import com.cobra.util.Utilidades;

import javax.swing.*;
import java.awt.*;

public class RealizarVenta extends JFrame {
    private final Utilidades util = new Utilidades();
    JComboBox<String> clienteComboBox;
    JComboBox<String> productosComboBox;
    JTextField txtCantidad;

    public RealizarVenta() {
        setTitle("Realizar Venta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(64, 64, 64));
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel lblNombreCliente = new JLabel("Nombre:");
        lblNombreCliente.setBounds(20, 20, 100, 30);
        lblNombreCliente.setForeground(Color.WHITE);
        lblNombreCliente.setFont(util.getFont(1));
        add(lblNombreCliente);

        clienteComboBox = new JComboBox<>();
        clienteComboBox.setBounds(120, 20, 200, 30);
        clienteComboBox.addItem("Erwin Vásquez");
        clienteComboBox.setFont(util.getFont(1));
        add(clienteComboBox);

        JLabel lblProducto = new JLabel("Producto:");
        lblProducto.setBounds(20, 70, 100, 30);
        lblProducto.setForeground(Color.WHITE);
        lblProducto.setFont(util.getFont(1));
        add(lblProducto);

        productosComboBox = new JComboBox<>();
        productosComboBox.setBounds(120, 70, 200, 30);
        productosComboBox.addItem("Producto 1");
        productosComboBox.setFont(util.getFont(1));
        add(productosComboBox);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(20, 120, 100, 30);
        lblCantidad.setForeground(Color.WHITE);
        lblCantidad.setFont(util.getFont(1));
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(120, 120, 200, 30);
        txtCantidad.setFont(util.getFont(5));
        add(txtCantidad);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(20, 180, 100, 30);
        btnGuardar.setBackground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));
        eventosBoton(btnGuardar);
        add(btnGuardar);
    }

    private void eventosBoton(JButton button) {
        util.efectosBotones(button);
        button.addActionListener((e) -> {
            int confirmation = JOptionPane.showConfirmDialog(null, "Desea agregar la compra?", "Guardar", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Compra guardada");
                new SaleModule();
                dispose();
            }
        });
    }
}
