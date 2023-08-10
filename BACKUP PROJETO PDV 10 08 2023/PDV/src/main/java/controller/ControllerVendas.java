/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DaoVendas;
import java.util.ArrayList;
import model.ModelVenda;

/**
 *
 * @author phdfr
 */
public class ControllerVendas {
    private DaoVendas daoVendas = new DaoVendas();
    
    public int SalvarVendaController(ModelVenda pModelVenda){
        
        if(this.daoVendas.inserir(pModelVenda)>0) {
            return 1;
        } else {
            return 0;
        }
        
    }
    
    
    public boolean AlterarVendaController(ModelVenda pModelVendas){
        return this.daoVendas.alterarVenda(pModelVendas);
    }
    
    public boolean DeletarVendaController(int idVenda){
        return this.daoVendas.deletarVenda(idVenda);
    }
    
     public ModelVenda getVendaController(int idVenda){
        return this.daoVendas.getVenda(idVenda);
    }
     public ArrayList<ModelVenda> getAllVendaController(){
        return this.daoVendas.getAllVenda();
    }

    
    
}
