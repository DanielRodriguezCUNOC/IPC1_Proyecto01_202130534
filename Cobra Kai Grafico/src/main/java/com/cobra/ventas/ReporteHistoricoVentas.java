package com.cobra.ventas;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReporteHistoricoVentas {
    ControlVentasDAO controlVentasDAO = ControlVentasDAO.getInstance();

    public ReporteHistoricoVentas() {
        generarReporteHistoricoVentas();
    }

    public void generarReporteHistoricoVentas() {
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = fecha.format(formato);
        String nombreArchivo = "REPORTES/HISTORICO_VENTAS/ReporteHistoricoVentas_" + fechaFormateada + ".html";
        ArrayList<Venta> listaVentas = controlVentasDAO.getVentas();
        int contadorVentas = controlVentasDAO.getContadorVentas();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            bw.write("<!DOCTYPE html>");
            bw.write("<html lang=\"es\">");
            bw.write("<head>");
            bw.write("<title>Reporte Histórico de Ventas</title>");
            bw.write("<style>");
            bw.write("body { font-family: Arial, sans-serif; background-color: #f4f4f4; color: #333; margin: 0; padding: 20px; }");
            bw.write("h1, h2 { text-align: center; }");
            bw.write("table { width: 100%; border-collapse: collapse; margin: 20px 0; box-shadow: 0 2px 3px rgba(0,0,0,0.1); }");
            bw.write("table th, table td { padding: 12px; border: 1px solid #ddd; text-align: left; }");
            bw.write("table th { background-color: #f2f2f2; color: #333; }");
            bw.write("table tr:nth-child(even) { background-color: #f9f9f9; }");
            bw.write("table tr:hover { background-color: #f1f1f1; }");
            bw.write("</style>");
            bw.write("</head>");
            bw.write("<body>");
            bw.write("<h1>Reporte Histórico de Ventas</h1>");
            bw.write("<h2>Fecha: " + fechaFormateada + "</h2>");
            bw.write("<h2>Total de ventas: " + contadorVentas + "</h2>");
            bw.write("<table border='1'>");
            bw.write("<tr><th>Venta</th><th>Nombre Cliente</th><th>NIT Cliente</th><th>Fecha</th><th>Total Venta</th></tr>");
            for (int i = 0; i < contadorVentas; i++) {
                bw.write("<tr>");
                bw.write("<td>" + (i + 1) + "</td>");
                bw.write("<td>" + listaVentas.get(i).getNombreCliente() + "</td>");
                bw.write("<td>" + listaVentas.get(i).getNitCliente() + "</td>");
                bw.write("<td>" + listaVentas.get(i).getFecha() + "</td>");
                bw.write("<td>" + listaVentas.get(i).getTotalVenta() + "</td>");
                bw.write("</tr>");
            }

            bw.write("</table>");
            bw.write("</body>");
            bw.write("</html>");
            JOptionPane.showMessageDialog(null, "Reporte generado con éxito");
        } catch (Exception e) {
            e.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al generar el reporte");
        }
    }
}