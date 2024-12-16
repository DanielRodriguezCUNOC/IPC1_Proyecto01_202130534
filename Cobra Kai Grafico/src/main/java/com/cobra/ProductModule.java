package com.cobra;

import com.cobra.productos.*;
import com.cobra.util.Utilidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProductModule extends JFrame {
    ControlProductosDAO controlProductosDAO = ControlProductosDAO.getInstance();
    Utilidades util = new Utilidades();
    DatosParaTablaProductos datosTabla;

    public ProductModule() {
        //Configuracion de la ventana
        setTitle("Módulo de Productos");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(64, 64, 64));

        //Tabla de productos
        datosTabla = new DatosParaTablaProductos();
        JTable productsTable = new JTable(datosTabla.getData(), datosTabla.getColumns());
        productsTable.setBounds(20, 50, 400, 180);
        productsTable.setRowHeight(30);
        productsTable.setFont(util.getFont(1));
        productsTable.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));
        JScrollPane tableScrollPane = new JScrollPane(productsTable);
        tableScrollPane.setBounds(20, 50, 400, 180);
        add(tableScrollPane);
        addButtons();
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
                    accionCargaMasiva();
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
                    new ReporteProductosMasVendidos();
                    break;
                case 6:
                    new AdminView();
                    dispose();
                    break;

            }
        });
    }

    private void accionCargaMasiva() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Carga Masiva de Productos");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            try {
                CargarProductos.cargarProductosArchivo(ruta);
                JOptionPane.showMessageDialog(this, "Productos cargados correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                refreshTableData(); // Refresh the table data
            } catch (Exception e) {
                e.printStackTrace(System.err);
                JOptionPane.showMessageDialog(this, "Error al cargar los productos desde FileChooser", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private void refreshTableData() {
        getContentPane().removeAll(); // Eliminar todos los componentes
        datosTabla = new DatosParaTablaProductos();
        JTable productsTable = new JTable(datosTabla.getData(), datosTabla.getColumns());
        productsTable.setBounds(20, 50, 400, 180);
        productsTable.setRowHeight(30);
        productsTable.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));
        JScrollPane tableScrollPane = new JScrollPane(productsTable);
        tableScrollPane.setBounds(20, 50, 400, 180);
        add(tableScrollPane);

        // Reagregar los botones
        addButtons();

        revalidate();
        repaint();
    }

    private void addButtons() {
        // Botón generar reportes de productos mas vendidos
        JButton btnGenerarReporteMasVendidos = new JButton("Generar reporte de productos más vendidos");
        btnGenerarReporteMasVendidos.setBounds(20, 260, 400, 30);
        btnGenerarReporteMasVendidos.setBackground(Color.WHITE);
        btnGenerarReporteMasVendidos.setFocusPainted(false);
        btnGenerarReporteMasVendidos.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Botones para módulos

        // Boton creacion de producto
        JButton btnCrearProductoIndividual = new JButton("Creacion de producto");
        btnCrearProductoIndividual.setBounds(500, 50, 200, 30);
        btnCrearProductoIndividual.setBackground(Color.WHITE);
        btnCrearProductoIndividual.setFocusPainted(false);
        btnCrearProductoIndividual.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));

        // Boton carga masiva de productos
        JButton btnCargaMasivaProductos = new JButton("Carga masiva de productos");
        btnCargaMasivaProductos.setBounds(450, 120, 280, 30);
        btnCargaMasivaProductos.setBackground(Color.WHITE);
        btnCargaMasivaProductos.setFocusPainted(false);
        btnCargaMasivaProductos.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));

        // Boton edicion de productos
        JButton btnEditarProducto = new JButton("Edicion de productos");
        btnEditarProducto.setBounds(500, 190, 200, 30);
        btnEditarProducto.setBackground(Color.WHITE);
        btnEditarProducto.setFocusPainted(false);
        btnEditarProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));

        // Boton eliminar producto
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

        // Agregar eventos a los botones
        eventosBotones(btnCrearProductoIndividual, 1);
        eventosBotones(btnCargaMasivaProductos, 2);
        eventosBotones(btnEditarProducto, 3);
        eventosBotones(btnDeleteProduct, 4);
        eventosBotones(btnGenerarReporteMasVendidos, 5);
        eventosBotones(btnBackAdminView, 6);

        // Agregar los botones al frame
        add(btnCrearProductoIndividual);
        add(btnCargaMasivaProductos);
        add(btnEditarProducto);
        add(btnDeleteProduct);
        add(btnGenerarReporteMasVendidos);
        add(btnBackAdminView);
    }
}
