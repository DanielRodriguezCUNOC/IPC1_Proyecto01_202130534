package com.cobra.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;

public class Utilidades {

    public Font getFont(int font) {
        return switch (font) {
            case 1 -> new Font("Arial", Font.BOLD, 16);
            case 2 -> new Font("Helvetica", Font.BOLD, 24);
            case 3 -> new Font("Courier New", Font.ITALIC, 16);
            case 4 -> new Font("Tahoma", Font.BOLD, 14);
            case 5 -> new Font("Open Sans", Font.BOLD, 18);
            default -> new Font("Times New Roman", Font.BOLD, 16);
        };
    }

    public void efectosBotones(JButton button) {
        button.setFont(getFont(1));
        //Agregamos efectos a los botones
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button.setBackground(new Color(255, 167, 31));
                button.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
            }
        });
    }

    //Obtenemos la fecha actual del sistema
    public String getFecha() {
        LocalDateTime fecha = LocalDateTime.now();
        return fecha.getDayOfMonth() + "-" + fecha.getMonthValue() + "-" + fecha.getYear();
    }
}
