package com.cobra.clientes;

import java.util.ArrayList;

public class ControlClienteDAO {

    public static ControlClienteDAO instance;
    ArrayList<Cliente> listadoClientes;

    public ControlClienteDAO() {
        listadoClientes = new ArrayList<>();
    }

    public static ControlClienteDAO getInstance() {
        if (instance == null) {
            instance = new ControlClienteDAO();
        }
        return instance;
    }

    public void addCliente(Cliente cliente) {
        listadoClientes.add(cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return listadoClientes;
    }

    public boolean clienteExists(String nombreCliente) {
        for (Cliente cliente : listadoClientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                return true;
            }
        }
        return false;
    }

    //Metodo para aumentar las compras de un cliente
    public void aumentarCompras(String nombreCliente) {
        for (Cliente cliente : listadoClientes) {
            if (cliente.getNombre().equals(nombreCliente)) {
                cliente.setCantidadCompras(cliente.getCantidadCompras() + 1);
            }
        }
    }

    public String getNIT(String nombreCliente) {
        for (Cliente cliente : listadoClientes) {
            if (cliente.getNombre().equals(nombreCliente)) {
                return cliente.getNit();
            }
        }
        return null;

    }

    public ArrayList<String> getNombresClientes() {
        ArrayList<String> nombres = new ArrayList<>();
        for (Cliente cliente : listadoClientes) {
            nombres.add(cliente.getNombre());
        }
        return nombres;
    }

    //Metodo para editar el nit de un cliente
    public void editarNit(String nombreCliente, String nit) {
        for (Cliente cliente : listadoClientes) {
            if (cliente.getNombre().equals(nombreCliente)) {
                cliente.setNit(nit);
            }
        }
    }

    //Metodo para obtener una lista de clientes
    public void setListaClientes(ArrayList<Cliente> listadoClientes) {
        //this.listadoClientes.clear();
        if (listadoClientes != null && !listadoClientes.isEmpty()) {
            this.listadoClientes.addAll(listadoClientes);
        }
    }

}
