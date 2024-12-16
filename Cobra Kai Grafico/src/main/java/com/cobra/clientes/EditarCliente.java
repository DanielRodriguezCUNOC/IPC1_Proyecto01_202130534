package com.cobra.clientes;

import com.cobra.ClientModule;
import com.cobra.util.Utilidades;

import javax.swing.*;
import java.awt.*;

public class EditarCliente extends JFrame {
    Utilidades util = new Utilidades();
    ControlClienteDAO controlClienteDAO = ControlClienteDAO.getInstance();
    JComboBox<String> clienteComboBox;
    JTextField txtNit;

    public EditarCliente() {
        setTitle("Editar Cliente");
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

        clienteComboBox = new JComboBox<>(controlClienteDAO.getNombresClientes().toArray(new String[0]));
        clienteComboBox.setBounds(120, 20, 200, 30);
        clienteComboBox.setFont(util.getFont(1));
        clienteComboBox.addActionListener(e -> {
            String selectedClient = (String) clienteComboBox.getSelectedItem();
            if (selectedClient != null) {
                String nit = controlClienteDAO.getNIT(selectedClient);
                txtNit.setText(nit);
            }
        });
        add(clienteComboBox);

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
        eventosBoton(btnGuardar);
        add(btnGuardar);
    }

    private void eventosBoton(JButton button) {
        util.efectosBotones(button);
        button.addActionListener((e) -> {
            editCliente();
        });
    }

    private void editCliente() {
        int confirmation = JOptionPane.showConfirmDialog(null, "Desea editar al cliente?", "Guardar", JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            String selectedClient = (String) clienteComboBox.getSelectedItem();
            String nit;
            if (txtNit.getText().isEmpty()) {
                nit = "C/F";
            } else {
                nit = txtNit.getText();
            }
            controlClienteDAO.editarNit(selectedClient, nit);
            JOptionPane.showMessageDialog(null, "Cliente guardado");
        }
        int option = JOptionPane.showConfirmDialog(null, "Desea editar otro cliente?", "Editar Cliente", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.NO_OPTION) {
            new ClientModule();
            dispose();
        }

    }
}
