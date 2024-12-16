package com.cobra.ventas;

import com.cobra.productos.ControlProductosDAO;

import java.util.ArrayList;

public class ControlVentasDAO {
    private static ControlVentasDAO instance;
    private final ControlProductosDAO controlProductosDAO = ControlProductosDAO.getInstance();
    private final ArrayList<Venta> listadoVentas;
    private final ArrayList<ProductoVendido> productosVendidos;

    private ControlVentasDAO() {
        listadoVentas = new ArrayList<>();
        productosVendidos = new ArrayList<>();
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
    
    //Al realizar una venta se añaden los productos vendidos a la lista de productos vendidos
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
}
