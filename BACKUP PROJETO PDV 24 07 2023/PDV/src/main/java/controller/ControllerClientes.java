package controller;

import DAO.DaoClientes;
import java.util.ArrayList;
import model.ModelCliente;

public class ControllerClientes {

    private DaoClientes daoClientes = new DaoClientes();

    public boolean SalvarClienteController(ModelCliente pModelClientes) {

        if (this.daoClientes.inserirCliente(pModelClientes)) {
            return true;
        } else {
            return false;
        }

    }
    
    public boolean AlterarClienteController(ModelCliente pModelClientes){
        return this.daoClientes.alterarClienteDAO(pModelClientes);
    }
    
    public boolean DeletarClienteController(int idCliente){
        return this.daoClientes.deletarCliente(idCliente);
    }
    
    public ModelCliente getClienteController(int idCliente){
        return this.daoClientes.getCliente(idCliente);
    }
    
    public ArrayList<ModelCliente> getAllClienteController(){
        
      return this.daoClientes.getAllClientes();
        
    }
}
