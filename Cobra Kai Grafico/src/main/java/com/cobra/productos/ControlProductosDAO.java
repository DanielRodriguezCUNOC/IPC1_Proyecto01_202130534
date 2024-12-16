package com.cobra.productos;

import java.util.ArrayList;

public class ControlProductosDAO {
    private final ArrayList<Producto> productos;
    public static ControlProductosDAO instance;
    private boolean confirmarAccion = false;

    public ControlProductosDAO() {
        productos = new ArrayList<>();
    }

    public static ControlProductosDAO getInstance() {
        if (instance == null) {
            instance = new ControlProductosDAO();
        }
        return instance;
    }

    // Metodos de la clase

    public ArrayList<String> getNombresProductos() {
        ArrayList<String> nombres = new ArrayList<>();
        for (Producto producto : productos) {
            nombres.add(producto.getNombre());
        }
        return nombres;
    }

    public double getPrecioProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto.getPrecio();
            }
        }
        return 0;
    }

    public int getStockProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto.getStock();
            }
        }
        return 0;
    }

    public void deleteProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                productos.remove(producto);
                break;
            }
        }
    }

    public boolean productExists(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public int getStock(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto.getStock();
            }
        }
        return 0;
    }

    public void restarStock(String nombre, int cantidad) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                producto.setStock(producto.getStock() - cantidad);
                break;
            }
        }
    }

    public void editarProducto(String nombre, double precio, int stock) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre) && precio >= 0 && stock >= 0) {
                producto.setPrecio(precio);
                producto.setStock(stock);
                confirmarAccion = true;
                break;
            } else {
                confirmarAccion = false;
            }
        }
    }

    public void addMasiveProducts(Producto producto) {
        if (!productExists(producto.getNombre()) && validarNombreProducto(producto.getNombre()) && producto.getPrecio() >= 0 && producto.getStock() >= 0) {
            productos.add(producto);
        } else {
            System.out.println("Error al cargar el producto");
        }
    }

    private boolean validarNombreProducto(String nombre) {
        boolean esUnaPalabra;
        esUnaPalabra = nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+");
        return esUnaPalabra;
    }

    public void addProductoIndividual(String nombre, double precio, int stock) {
        if (!productExists(nombre) && precio >= 0 && stock >= 0) {
            Producto producto = new Producto(nombre, precio, stock);
            productos.add(producto);
            confirmarAccion = true;
        } else {
            confirmarAccion = false;
        }
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public boolean getConfirmarAccion() {
        return confirmarAccion;
    }

}
