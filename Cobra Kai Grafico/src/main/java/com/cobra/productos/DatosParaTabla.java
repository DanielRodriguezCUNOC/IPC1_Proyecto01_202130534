package com.cobra.productos;

import java.util.List;

public class DatosParaTabla {
    String[] columnName = {"Nombre", "Precio", "Stock"};
    ControlProductosDAO controlProductosDAO = ControlProductosDAO.getInstance();
    /*Creamos un arreglo bidimiensional donde: el primer corchete es el numero de filas y el segundo el numero de columnas
     Por ejemplo:
      String[][] data = new String[3][3];
      data[0][0] = "Nombre";
      data[0][1] = "Precio";
      data[0][2] = "Stock";
      [0][0] [0][1] [0][2] donde [0][0] es Nombre, [0][1] es Precio y [0][2] es Stock
    */
    Object[][] data = new Object[controlProductosDAO.getNombresProductos().size()][3];

    public DatosParaTabla() {
        rellenarArreglo();
    }

    //Llenamos el arreglo bidimensional con los datos de los productos

    public void rellenarArreglo() {
        List<String> nombresProductos = controlProductosDAO.getNombresProductos();
        for (int i = 0; i < nombresProductos.size(); i++) {
            data[i][0] = nombresProductos.get(i);
            data[i][1] = controlProductosDAO.getPrecioProducto(nombresProductos.get(i));
            data[i][2] = controlProductosDAO.getStockProducto(nombresProductos.get(i));
        }
    }

    public String[] getColumns() {
        return columnName;
    }

    public Object[][] getData() {
        return data;
    }
}
