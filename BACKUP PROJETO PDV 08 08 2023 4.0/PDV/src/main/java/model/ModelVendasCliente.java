
package model;

import java.util.ArrayList;


public class ModelVendasCliente {
    
    private ModelVenda modelVenda;
    private ModelCliente modelCliente;
    private ArrayList<ModelVendasCliente> listaModelVendasCliente;

    public ModelVenda getModelVenda() {
        return modelVenda;
    }

    public void setModelVenda(ModelVenda modelVenda) {
        this.modelVenda = modelVenda;
    }

    public ModelCliente getModelCliente() {
        return modelCliente;
    }

    public void setModelCliente(ModelCliente modelCliente) {
        this.modelCliente = modelCliente;
    }

    public ArrayList<ModelVendasCliente> getListaModelVendasCliente() {
        return listaModelVendasCliente;
    }

    public void setListaModelVendasCliente(ArrayList<ModelVendasCliente> listaModelVendasCliente) {
        this.listaModelVendasCliente = listaModelVendasCliente;
    }
    
    
    
}
