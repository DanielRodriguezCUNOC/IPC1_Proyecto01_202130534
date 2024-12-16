package com.cobra.manejodatos;

import com.cobra.clientes.ControlClienteDAO;
import com.cobra.productos.ControlProductosDAO;
import com.cobra.ventas.ControlVentasDAO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializarObjetos {
    ControlClienteDAO controlClienteDAO = ControlClienteDAO.getInstance();
    ControlVentasDAO controlVentasDAO = ControlVentasDAO.getInstance();
    ControlProductosDAO controlProductosDAO = ControlProductosDAO.getInstance();

    public SerializarObjetos() {
        guardarClientesEnArchivo();
        guardarVentasEnArchivo();
        guardarProductosEnArchivo();
    }

    public void guardarClientesEnArchivo() {
        String nombreArchivo = "DATA/ALMACENAR_CLIENTES/clientes.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(controlClienteDAO.getClientes());
            System.out.println("Clientes guardados con éxito.");
        } catch (IOException e) {
            e.printStackTrace(System.err);
            System.out.println("Error al guardar clientes.");
        }
    }

    public void guardarVentasEnArchivo() {
        String nombreArchivo = "DATA/ALMACENAR_VENTAS/ventas.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(controlVentasDAO.getVentas());
            System.out.println("Ventas guardados con éxito.");
        } catch (IOException e) {
            e.printStackTrace(System.err);
            System.out.println("Error al guardar ventas.");
        }
    }

    public void guardarProductosEnArchivo() {
        String nombreArchivo = "DATA/ALMACENAR_PRODUCTOS/productos.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(controlProductosDAO.getProductos());
            System.out.println("Productos guardados con éxito.");
        } catch (IOException e) {
            e.printStackTrace(System.err);
            System.out.println("Error al guardar productos.");
        }
    }
}
