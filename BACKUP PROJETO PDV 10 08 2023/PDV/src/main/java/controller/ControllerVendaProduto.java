/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DaoVendasProdutos;
import java.util.ArrayList;
import model.ModelProdutos;
import model.ModelVendaProduto;


public class ControllerVendaProduto {
    private DaoVendasProdutos daoVendasProduto = new DaoVendasProdutos();
   
    
        //salvar produto controller
    public boolean SalvarVendaProdutoController(ArrayList<ModelVendaProduto> pListaModelVendaProduto){
        
        if(this.daoVendasProduto.inserir(pListaModelVendaProduto)){
           return true;
        }else{
            return false;
        }
        
        
    }
    }
    

