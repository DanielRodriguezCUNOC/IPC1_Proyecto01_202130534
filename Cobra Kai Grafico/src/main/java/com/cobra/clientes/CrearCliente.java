package com.cobra.clientes;


import com.cobra.ClientModule;
import com.cobra.util.Utilidades;

import javax.swing.*;
import java.awt.*;

public class CrearCliente extends JFrame {
    private ControlClienteDAO controlClienteDAO = ControlClienteDAO.getInstance();
    private Utilidades util = new Utilidades();
    private JTextField txtNombre;
    private JTextField txtNit;

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

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 20, 200, 30);
        txtNombre.setFont(util.getFont(5));
        add(txtNombre);

        JLabel lblNit = new JLabel("Nit:");
        lblNit.setBounds(20, 70, 100, 30);
        lblNit.setForeground(Color.WHITE);
        lblNit.setFont(util.getFont(1));
        add(lblNit);

        txtNit = new JTextField();
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
            guardarCliente();
        });
    }

    private void guardarCliente() {
        String nombre = txtNombre.getText();
        String nit;
        //Verificar que todos los campos esten llenos
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //Verificar si el cliente ya existe
            if (controlClienteDAO.clienteExists(nombre)) {
                JOptionPane.showMessageDialog(null, "El cliente ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (txtNit.getText().isEmpty()) {
                    nit = "C/F";
                } else {
                    nit = txtNit.getText();
                }
                Cliente cliente = new Cliente(nombre, nit);
                controlClienteDAO.addCliente(cliente);
                JOptionPane.showMessageDialog(null, "Cliente guardado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                new ClientModule();
                dispose();
            }
        }
    }
}
