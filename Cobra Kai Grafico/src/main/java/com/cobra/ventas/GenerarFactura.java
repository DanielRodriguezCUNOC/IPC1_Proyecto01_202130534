package com.cobra.ventas;

import com.cobra.clientes.ControlClienteDAO;
import com.cobra.productos.ControlProductosDAO;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class GenerarFactura {
    ControlProductosDAO controlProductosDAO = ControlProductosDAO.getInstance();
    ControlClienteDAO controlClienteDAO = new ControlClienteDAO();

    //Metodo utilizado en RealizarVenta para crear la factura
    public void crearFactura(String nombreCliente, String nombreProducto, int cantidad, String fechaVenta) {
        double precioUnitario = controlProductosDAO.getPrecioProducto(nombreProducto);
        double total = precioUnitario * cantidad;
        String nombreArchivo = "facturas/Factura_" + nombreCliente + "_" + fechaVenta + ".html";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("<html>");
            writer.write("<head>");
            writer.write("<title>Factura de Compra</title>");
            writer.write("<style>");
            writer.write("body { font-family: Arial, sans-serif; margin: 40px; }");
            writer.write("h1, h2 { text-align: center; color: #333; }");
            writer.write(".detalle { margin: 20px auto; width: 60%; border: 1px solid #ddd; padding: 20px; border-radius: 8px; background: #f9f9f9; }");
            writer.write(".campo { font-weight: bold; margin-top: 10px; }");
            writer.write(".valor { margin-left: 10px; color: #555; }");
            writer.write("</style>");
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
