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
        fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String nombreArchivo = "REPORTES/HISTORICO_VENTAS/ReporteHistoricoVentas" + fecha + ".html";
        ArrayList<Venta> listaVentas = controlVentasDAO.getVentas();
        int contadorVentas = controlVentasDAO.getContadorVentas();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            bw.write("<!DOCTYPE html>");
            bw.write("<html>");
            bw.write("<head>");
            bw.write("<title>Reporte Histórico de Ventas</title>");
            bw.write("<link rel='stylesheet' href='CSS/reporteventas.css'>");
            bw.write("</head>");
            bw.write("<body>");
            bw.write("<h1>Reporte Histórico de Ventas</h1>");
            bw.write("<h2>Fecha: " + fecha + "</h2>");
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
