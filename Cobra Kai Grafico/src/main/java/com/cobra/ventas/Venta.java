package com.cobra.ventas;

import java.io.Serial;
import java.io.Serializable;

public class Venta implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String nombreCliente;
    private String nitCliente;
    private String fecha;
    private double totalVenta;

    public Venta(String nombreCliente, String nitCliente, String fecha, double totalVenta) {
        this.nombreCliente = nombreCliente;
        this.nitCliente = nitCliente;
        this.fecha = fecha;
        this.totalVenta = totalVenta;
    }

    //Getters y Setters

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }
}
