package com.cobra;

import java.awt.*;

public class CustomFonts {

    public Font getFont(int font){
        return switch (font) {
            case 1 -> new Font("Arial", Font.PLAIN, 16);
            case 2 -> new Font("Helvetica", Font.BOLD, 24);
            case 3 -> new Font("Courier New", Font.ITALIC, 16);
            case 4 -> new Font("Tahoma", Font.BOLD, 16);
            default -> new Font("Times New Roman", Font.PLAIN, 16);
        };
    }
}
