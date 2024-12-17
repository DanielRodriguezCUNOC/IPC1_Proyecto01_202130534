package com.cobra;

import com.cobra.manejodatos.DeserializarObjetos;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //Intentamos cargar los datos de los archivos
        try {
            new DeserializarObjetos();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Error al cargar los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Ingresamos al sistema
        new Login();
    }
}
