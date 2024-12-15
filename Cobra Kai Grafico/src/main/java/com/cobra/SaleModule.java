package com.cobra;

import com.cobra.util.Utilidades;
import com.cobra.ventas.RealizarVenta;

import javax.swing.*;
import java.awt.*;

public class SaleModule extends JFrame {
    Utilidades util = new Utilidades();

    public SaleModule() {
        setTitle("Módulo de Ventas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(64, 64, 64));
        setLocationRelativeTo(null);
        setVisible(true);

        JButton btnCrearVenta = new JButton("Crear Venta");
        btnCrearVenta.setBounds(100, 50, 200, 30);
        btnCrearVenta.setBackground(Color.WHITE);
        btnCrearVenta.setFocusPainted(false);
        btnCrearVenta.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));

        JButton btnCrearReporteVentas = new JButton("Crear Reporte de Ventas");
        btnCrearReporteVentas.setBounds(100, 100, 200, 30);
        btnCrearReporteVentas.setBackground(Color.WHITE);
        btnCrearReporteVentas.setFocusPainted(false);
        btnCrearReporteVentas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));

        JButton btnBackAdminView = new JButton("Volver al modulo de administrador");
        btnBackAdminView.setBounds(50, 180, 300, 30);
        btnBackAdminView.setBackground(Color.WHITE);
        btnBackAdminView.setFocusPainted(false);
        btnBackAdminView.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));

        eventoBotones(btnCrearVenta, 1);
        eventoBotones(btnCrearReporteVentas, 2);
        eventoBotones(btnBackAdminView, 3);

        add(btnCrearVenta);
        add(btnCrearReporteVentas);
        add(btnBackAdminView);
    }

    private void eventoBotones(JButton button, int option) {
        util.efectosBotones(button);
        button.addActionListener((e) -> {
            switch (option) {
                case 1:
                    new RealizarVenta();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Crear Reporte de Ventas");
                    break;
                case 3:
                    new AdminView();
                    dispose();
                    break;
            }
        });
    }
}
