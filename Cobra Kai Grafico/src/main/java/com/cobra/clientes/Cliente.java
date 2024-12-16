package com.cobra.clientes;

public class Cliente {
    private String nombre;
    private String nit;
    private int cantidadCompras;

    public Cliente(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        cantidadCompras = 0;
    }

    //Getters y Setters

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadCompras() {
        return cantidadCompras;
    }

    public void setCantidadCompras(int cantidadCompras) {
        if (cantidadCompras >= 0) {
            this.cantidadCompras = cantidadCompras;
        }
    }
}
