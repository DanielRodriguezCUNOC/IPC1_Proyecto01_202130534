package com.cobra.manejodatos;

import com.cobra.clientes.Cliente;
import com.cobra.clientes.ControlClienteDAO;
import com.cobra.productos.ControlProductosDAO;
import com.cobra.productos.Producto;
import com.cobra.ventas.ControlVentasDAO;
import com.cobra.ventas.Venta;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializarObjetos {
    ControlClienteDAO controlClienteDAO = ControlClienteDAO.getInstance();
    ControlProductosDAO controlProductosDAO = ControlProductosDAO.getInstance();
    ControlVentasDAO controlVentasDAO = ControlVentasDAO.getInstance();

    public DeserializarObjetos() {
        cargarClientesDesdeArchivo();
        cargarProductosDesdeArchivo();
        cargarVentasDesdeArchivo();
    }

    public void cargarClientesDesdeArchivo() {
        String nombreArchivo = "DATA/ALMACENAR_CLIENTES/clientes.dat";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            ArrayList<Cliente> listadoClientes = (ArrayList<Cliente>) ois.readObject();
            controlClienteDAO.setListaClientes(listadoClientes);
            System.out.println("Clientes cargados con éxito.");
            //Archivo vacío
        } catch (EOFException ae) {
            System.out.println("No hay clientes registrados.");
            //Si no encuentra la clase Cliente o no puede leer el archivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
            System.out.println("Error al cargar clientes.");
        }
    }

    public void cargarProductosDesdeArchivo() {
        String nombreArchivo = "DATA/ALMACENAR_PRODUCTOS/productos.dat";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            ArrayList<Producto> listadoProductos = (ArrayList<Producto>) ois.readObject();
            controlProductosDAO.setListaProductos(listadoProductos);
            System.out.println("Productos cargados con éxito.");
            //Archivo vacío
        } catch (EOFException ae) {
            System.out.println("No hay productos registrados.");
            //Si no encuentra la clase Producto o no puede leer el archivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
            System.out.println("Error al cargar productos.");
        }
    }

    public void cargarVentasDesdeArchivo() {
        String nombreArchivo = "DATA/ALMACENAR_VENTAS/ventas.dat";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            ArrayList<Venta> listadoVentas = (ArrayList<Venta>) ois.readObject();
            controlVentasDAO.setListaVentas(listadoVentas);
            System.out.println("Ventas cargadas con éxito.");
            //Archivo vacío
        } catch (EOFException ae) {
            System.out.println("No hay ventas registradas.");
            //Si no encuentra la clase Cliente o no puede leer el archivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
            System.out.println("Error al cargar ventas.");
        }
    }
}
