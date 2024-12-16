package com.cobra.ventas;

import com.cobra.clientes.ControlClienteDAO;
import com.cobra.productos.ControlProductosDAO;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class GenerarFactura {
    ControlProductosDAO controlProductosDAO = ControlProductosDAO.getInstance();
    ControlClienteDAO controlClienteDAO = ControlClienteDAO.getInstance();

    //Metodo utilizado en RealizarVenta para crear la factura
    public void crearFactura(String nombreCliente, String nombreProducto, int cantidad, String fechaVenta) {
        double precioUnitario = controlProductosDAO.getPrecioProducto(nombreProducto);
        double total = precioUnitario * cantidad;
        String nombreArchivo = "FACTURAS/Factura_" + nombreCliente + "_" + fechaVenta + ".html";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("<html>");
            writer.write("<head>");
            writer.write("<title>Factura de Compra</title>");
            writer.write("<link rel='stylesheet' href='CSS/factura.css'>");
            writer.write("</head>");
            writer.write("<body>");
            writer.write("<h1>Factura de Compra</h1>");
            writer.write("<div class='detalle'>");
            writer.write("<h2>Datos del Cliente</h2>");
            writer.write("<p class='campo'>Nombre:<span class='valor'>" + nombreCliente + "</span></p>");
            writer.write("<p class='campo'>NIT:<span class='valor'>" + controlClienteDAO.getNIT(nombreCliente) + "</span></p>");
            writer.write("<h2>Detalles de la Compra</h2>");
            writer.write("<p class='campo'>Producto:<span class='valor'>" + nombreProducto + "</span></p>");
            writer.write("<p class='campo'>Precio Unitario:<span class='valor'>Q" + String.format("%.2f", precioUnitario) + "</span></p>");
            writer.write("<p class='campo'>Cantidad Vendida:<span class='valor'>" + cantidad + "</span></p>");
            writer.write("<p class='campo'>Total de la Venta:<span class='valor'>Q" + String.format("%.2f", total) + "</span></p>");
            writer.write("<p class='campo'>Fecha de Venta:<span class='valor'>" + fechaVenta.replace("_", " ") + "</span></p>");
            writer.write("</div>");
            writer.write("</body>");
            writer.write("</html>");

            System.out.println("Factura creada con éxito.");
        } catch (Exception e) {
            System.out.println("Error al crear la factura.");
            e.printStackTrace(System.err);
        }

    }
}
