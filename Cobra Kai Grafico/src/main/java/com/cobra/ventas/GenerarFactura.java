package com.cobra.ventas;

import com.cobra.clientes.ControlClienteDAO;
import com.cobra.productos.ControlProductosDAO;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class GenerarFactura {
    ControlProductosDAO controlProductosDAO = ControlProductosDAO.getInstance();
    ControlClienteDAO controlClienteDAO = ControlClienteDAO.getInstance();

    // Metodo utilizado en RealizarVenta para crear la factura
    public void crearFactura(String nombreCliente, String nombreProducto, int cantidad, String fechaVenta) {
        double precioUnitario = controlProductosDAO.getPrecioProducto(nombreProducto);
        double total = precioUnitario * cantidad;
        String nombreArchivo = "FACTURAS/Factura_" + nombreCliente + "_" + fechaVenta + ".html";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {

            writer.write("<html lang=\"es\">");
            writer.write("<head>");
            writer.write("<meta charset=\"UTF-8\">");
            writer.write("<title>Factura de Compra</title>");
            writer.write("<style>");
            writer.write("body { font-family: Arial, sans-serif; background-color: #f4f4f4; color: #333; margin: 0; padding: 20px; }");
            writer.write("h1, h2 { text-align: center; }");
            writer.write(".container { width: 80%; margin: auto; background: #fff; padding: 20px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
            writer.write(".detalle { margin: 20px 0; }");
            writer.write(".detalle-cliente { text-align: center; margin: 20px 0; }");
            writer.write(".campo { margin: 10px 0; }");
            writer.write(".valor { font-weight: bold; }");
            writer.write(".table { width: 100%; border-collapse: collapse; margin: 20px 0; }");
            writer.write(".table th, .table td { padding: 12px; border: 1px solid #ddd; text-align: center; }");
            writer.write(".table th { background-color: #f2f2f2; color: #333; }");
            writer.write(".table tr:nth-child(even) { background-color: #f9f9f9; }");
            writer.write(".table tr:hover { background-color: #f1f1f1; }");
            writer.write("</style>");
            writer.write("</head>");
            writer.write("<body>");
            writer.write("<div class='container'>");
            writer.write("<h1>Factura de Compra</h1>");
            writer.write("<div class='detalle detalle-cliente'>");
            writer.write("<h2>Datos del Cliente</h2>");
            writer.write("<p class='campo'>Nombre: <span class='valor'>" + nombreCliente + "</span></p>");
            writer.write("<p class='campo'>NIT: <span class='valor'>" + controlClienteDAO.getNIT(nombreCliente) + "</span></p>");
            writer.write("</div>");
            writer.write("<div class='detalle'>");
            writer.write("<h2>Detalles de la Compra</h2>");
            writer.write("<table class='table'>");
            writer.write("<tr><th>Producto</th><th>Precio Unitario</th><th>Cantidad</th><th>Total</th></tr>");
            writer.write("<tr>");
            writer.write("<td>" + nombreProducto + "</td>");
            writer.write("<td>Q" + String.format("%.2f", precioUnitario) + "</td>");
            writer.write("<td>" + cantidad + "</td>");
            writer.write("<td>Q" + String.format("%.2f", total) + "</td>");
            writer.write("</tr>");
            writer.write("</table>");
            writer.write("<p class='campo'>Fecha de Venta: <span class='valor'>" + fechaVenta.replace("_", " ") + "</span></p>");
            writer.write("</div>");
            writer.write("</div>");
            writer.write("</body>");
            writer.write("</html>");

            JOptionPane.showMessageDialog(null, "Factura generada con éxito.", "Factura Generada", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar la factura.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(System.err);
        }
    }
}