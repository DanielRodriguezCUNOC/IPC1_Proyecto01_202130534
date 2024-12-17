package com.cobra.productos;

import com.cobra.ventas.ControlVentasDAO;
import com.cobra.ventas.ProductoVendido;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReporteProductosMasVendidos {
    ControlVentasDAO controlVentasDAO = ControlVentasDAO.getInstance();
    ArrayList<ProductoVendido> productosVendidos;

    public ReporteProductosMasVendidos() {
        metodosAEjecutar();
    }

    private void metodosAEjecutar() {
        productosVendidos = new ArrayList<>();
        obtenerProductosVendidos();
        //Verificamos si la lista no está vacía
        if (!productosVendidos.isEmpty()) {
            // Eliminar elementos null de la lista
            productosVendidos.removeIf(producto -> producto == null);
            ordenarProductos(productosVendidos);
            generarReporte();
        } else {
            JOptionPane.showMessageDialog(null, "No hay productos vendidos para generar el reporte");
        }
    }

    private void obtenerProductosVendidos() {
        productosVendidos = controlVentasDAO.getProductosVendidos();
    }

    public void ordenarProductos(ArrayList<ProductoVendido> productosVendidos) {

        //Utilizamos el algoritmo de ordenamiento de inserción

        for (int i = 1; i < productosVendidos.size(); i++) {
            ProductoVendido actual = productosVendidos.get(i);
            int j = i - 1;

            // Desplaza elementos mayores hacia la derecha
            while (j >= 0 && productosVendidos.get(j).getCantidadVendida() < actual.getCantidadVendida()) {
                productosVendidos.set(j + 1, productosVendidos.get(j));
                j--;
            }
            //Insertamos el elemento en su lugar
            productosVendidos.set(j + 1, actual);
        }
    }

    public void generarReporte() {
        //Obtenemos la fecha actual
        LocalDateTime fecha = LocalDateTime.now();
        //Formateamos la fecha dia-mes-año
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaActual = fecha.format(formato);
        //Nombre del archivo que se guardara en una ruta dentro del proyecto
        String nombreArchivo = "REPORTES/TOPRODUCTOS/ReporteProductosMasVendidos_" + fechaActual + ".html";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {

            writer.write("<html lang=\"es\">");
            writer.write("<head>");
            writer.write("<meta charset=\"UTF-8\">");
            writer.write("<title>Reporte de productos más vendidos</title>");
            writer.write("<style>");
            writer.write("body { font-family: Arial, sans-serif; background-color: #f4f4f4; color: #333; margin: 0; padding: 20px; }");
            writer.write("h1 { text-align: center; }");
            writer.write(".container { width: 80%; margin: auto; background: #fff; padding: 20px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
            writer.write("table { width: 100%; border-collapse: collapse; margin: 20px 0; box-shadow: 0 2px 3px rgba(0,0,0,0.1); }");
            writer.write("table th, table td { padding: 12px; border: 1px solid #ddd; text-align: center; }");
            writer.write("table th { background-color: #f2f2f2; color: #333; }");
            writer.write("table tr:nth-child(even) { background-color: #f9f9f9; }");
            writer.write("table tr:hover { background-color: #f1f1f1; }");
            writer.write("</style>");
            writer.write("</head>");
            writer.write("<body>");
            writer.write("<div class='container'>");
            writer.write("<h1>Reporte de productos más vendidos</h1>");
            writer.write("<table>");
            writer.write("<tr><th>Producto</th><th>Precio (Q)</th><th>Cantidad vendida</th></tr>");
            for (ProductoVendido producto : productosVendidos) {
                writer.write("<tr>");
                writer.write("<td>" + producto.getNombreProducto() + "</td>");
                writer.write("<td>Q" + String.format("%.2f", producto.getPrecioUnitario()) + "</td>");
                writer.write("<td>" + producto.getCantidadVendida() + "</td>");
                writer.write("</tr>");
            }
            writer.write("</table>");
            writer.write("</div>");
            writer.write("</body>");
            writer.write("</html>");
            JOptionPane.showMessageDialog(null, "Reporte generado con éxito");

        } catch (Exception e) {
            e.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al generar el reporte");
        }
    }

}
