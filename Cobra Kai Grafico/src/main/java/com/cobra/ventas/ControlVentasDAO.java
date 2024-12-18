package com.cobra.ventas;

import com.cobra.productos.ControlProductosDAO;

import java.util.ArrayList;

public class ControlVentasDAO {
    private static ControlVentasDAO instance;
    private final ControlProductosDAO controlProductosDAO = ControlProductosDAO.getInstance();
    private final ArrayList<Venta> listadoVentas;
    private final ArrayList<ProductoVendido> productosVendidos;
    private int contadorVentas;

    private ControlVentasDAO() {
        listadoVentas = new ArrayList<>();
        productosVendidos = new ArrayList<>();
        contadorVentas = 0;
    }

    public static ControlVentasDAO getInstance() {
        if (instance == null) {
            instance = new ControlVentasDAO();
        }
        return instance;
    }

    //Al realizar una venta se añade la venta a la lista de ventas
    public void addVenta(Venta venta) {
        listadoVentas.add(venta);
    }

    //Al realizar una venta los productos son añadidos a la lista
    public void addProductosVendidos(String nombreProducto, int cantidadVendida) {
        double precioUnitario = controlProductosDAO.getPrecioProducto(nombreProducto);
        ProductoVendido productoVendido = new ProductoVendido(nombreProducto, cantidadVendida, precioUnitario);
        productosVendidos.add(productoVendido);
    }

    public ArrayList<Venta> getVentas() {
        return listadoVentas;
    }

    public ArrayList<ProductoVendido> getProductosVendidos() {
        return productosVendidos;
    }

    public int getContadorVentas() {
        return contadorVentas;
    }

    public void incrementarContadorVentas() {
        contadorVentas++;
    }

    public void setListaVentas(ArrayList<Venta> ventas) {
        if (ventas != null && !ventas.isEmpty()) {
            this.listadoVentas.addAll(ventas);
            //Al momento de cargar las ventas se actualiza el contador de ventas
            for (int i = 0; i < listadoVentas.size(); i++) {
                contadorVentas++;
            }
        }
    }
}
