
package controller;

import DAO.DaoVendasCliente;
import java.util.ArrayList;
import model.ModelVendasCliente;


public class ControllerVendasCliente {
    private DaoVendasCliente daoVendasCliente = new DaoVendasCliente();
    
    public ArrayList<ModelVendasCliente> getListaVendasClienteController() {
       return this.daoVendasCliente.getAllVendaCliente();
    }
    
}
