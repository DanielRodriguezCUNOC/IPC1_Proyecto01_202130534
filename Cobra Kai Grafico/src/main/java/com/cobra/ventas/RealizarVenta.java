package com.cobra.ventas;

import com.cobra.SaleModule;
import com.cobra.clientes.ControlClienteDAO;
import com.cobra.productos.ControlProductosDAO;
import com.cobra.util.Utilidades;

import javax.swing.*;
import java.awt.*;

public class RealizarVenta extends JFrame {
    private final ControlProductosDAO controlProductosDAO = ControlProductosDAO.getInstance();
    private final ControlVentasDAO controlVentasDAO = ControlVentasDAO.getInstance();
    private final ControlClienteDAO controlClienteDAO = new ControlClienteDAO();
    private final Utilidades util = new Utilidades();
    private GenerarFactura generarFactura;
    private JComboBox<String> clienteComboBox;
    private JComboBox<String> productosComboBox;
    private JTextField txtCantidad;

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

        clienteComboBox = new JComboBox<>(controlClienteDAO.getNombresClientes().toArray(new String[0]));
        clienteComboBox.setBounds(120, 20, 200, 30);
        clienteComboBox.setFont(util.getFont(1));
        add(clienteComboBox);

        JLabel lblProducto = new JLabel("Producto:");
        lblProducto.setBounds(20, 70, 100, 30);
        lblProducto.setForeground(Color.WHITE);
        lblProducto.setFont(util.getFont(1));
        add(lblProducto);

        productosComboBox = new JComboBox<>(controlProductosDAO.getNombresProductos().toArray(new String[0]));
        productosComboBox.setBounds(120, 70, 200, 30);
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
                generarVenta();
                new SaleModule();
                dispose();
            }
        });
    }

    private void generarVenta() {
        //Obtener los datos de los campos
        String nombreCliente = (String) clienteComboBox.getSelectedItem();
        String nombreProducto = (String) productosComboBox.getSelectedItem();
        String cantidadTexto = txtCantidad.getText();

        //Validar que los campos no estén vacíos
        if (nombreCliente == null || nombreProducto == null || cantidadTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return;
        }

        int cantidad;
        //Validar que la cantidad sea un número válido
        try {
            cantidad = Integer.parseInt(cantidadTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un número válido.");
            return;
        }

        //Obtener el precio del producto y calcular el total de la venta
        double precioUnitario = controlProductosDAO.getPrecioProducto(nombreProducto);
        double totalVenta = precioUnitario * cantidad;
        String fechaVenta = util.getFecha();

        //Crear una nueva venta y agregarla a la lista de ventas
        Venta venta = new Venta(nombreCliente, controlClienteDAO.getNIT(nombreCliente), fechaVenta, totalVenta);
        controlVentasDAO.addVenta(venta);
        controlVentasDAO.addProductosVendidos(nombreProducto, cantidad);
        //Generamos la factura
        generarFactura = new GenerarFactura();
        generarFactura.crearFactura(nombreCliente, nombreProducto, cantidad, fechaVenta);
        JOptionPane.showMessageDialog(null, "Venta agregada exitosamente.");
    }
}
