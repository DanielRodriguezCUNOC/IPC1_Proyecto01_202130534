package com.cobra.productos;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CargarProductos {

    public static void cargarProductosArchivo(String ruta) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            br.readLine(); // Omitir la primera línea
            int lineNumber = 1;
            while ((linea = br.readLine()) != null) {
                lineNumber++;
                String[] partes = linea.split(";");
                if (partes.length != 3) {
                    JOptionPane.showMessageDialog(null, "Error en la línea " + lineNumber + ": formato incorrecto.");
                    continue;
                }
                try {
                    String nombre = partes[0].trim();
                    double precio = Double.parseDouble(partes[1]);
                    int stock = Integer.parseInt(partes[2]);
                    Producto producto = new Producto(nombre, precio, stock);
                    ControlProductosDAO.getInstance().addMasiveProducts(producto);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error en la línea " + lineNumber + ": datos numéricos incorrectos.");
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo: " + e.getMessage());
            throw e;
        }
    }
}