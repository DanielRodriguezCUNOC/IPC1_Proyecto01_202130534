package com.cobra.clientes;

public class DatosParaTablaCliente {
    ControlClienteDAO controlClienteDAO = ControlClienteDAO.getInstance();
    String[] columnName = {"Nombre", "NIT", "Cantidad de compras"};
    Object[][] data = new Object[controlClienteDAO.getClientes().size()][3];

    public DatosParaTablaCliente() {
        rellenarArreglo();
    }

    public void rellenarArreglo() {
        for (int i = 0; i < controlClienteDAO.getClientes().size(); i++) {
            data[i][0] = controlClienteDAO.getClientes().get(i).getNombre();
            data[i][1] = controlClienteDAO.getClientes().get(i).getNit();
            data[i][2] = controlClienteDAO.getClientes().get(i).getCantidadCompras();
        }
    }

    public String[] getColumns() {
        return columnName;
    }

    public Object[][] getData() {
        return data;
    }
}
