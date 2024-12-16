package com.cobra;

import com.cobra.clientes.Cliente;
import com.cobra.clientes.ControlClienteDAO;
import com.cobra.productos.ControlProductosDAO;

public class Main {
    public static void main(String[] args) {
        ControlProductosDAO controlProductosDAO = ControlProductosDAO.getInstance();
        ControlClienteDAO controlClienteDAO = ControlClienteDAO.getInstance();
        controlProductosDAO.addProductoIndividual("Coca Cola", 5.5, 5);
        controlProductosDAO.addProductoIndividual("Fanta", 4.5, 10);
        controlProductosDAO.addProductoIndividual("Sprite", 3.5, 15);
        controlProductosDAO.addProductoIndividual("Aquarius", 2.5, 20);

        Cliente cliente1 = new Cliente("Juan", "123456");
        Cliente cliente2 = new Cliente("Pedro", "654321");
        Cliente cliente3 = new Cliente("Maria", "987654");
        controlClienteDAO.addCliente(cliente1);
        controlClienteDAO.addCliente(cliente2);
        controlClienteDAO.addCliente(cliente3);

        new Login();
    }
}
