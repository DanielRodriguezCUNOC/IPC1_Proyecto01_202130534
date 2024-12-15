package com.cobra;

import com.cobra.productos.ControlProductosDAO;

public class Main {
    public static void main(String[] args) {
        ControlProductosDAO controlProductosDAO = ControlProductosDAO.getInstance();
        controlProductosDAO.addProductoIndividual("Coca Cola", 5.5, 5);
        controlProductosDAO.addProductoIndividual("Fanta", 4.5, 10);
        controlProductosDAO.addProductoIndividual("Sprite", 3.5, 15);
        controlProductosDAO.addProductoIndividual("Aquarius", 2.5, 20);
        new Login();
        
    }
}
