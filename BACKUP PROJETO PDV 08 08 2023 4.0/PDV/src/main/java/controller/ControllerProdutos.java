
package controller;

import DAO.DaoProdutos;
import java.util.ArrayList;
import model.ModelProdutos;


public class ControllerProdutos {
    
    private DaoProdutos daoProdutos = new DaoProdutos();
    
    
    //salvar produto controller
    public boolean SalvarProdutoController(ModelProdutos pModelProdutos){
        
        if(this.daoProdutos.inserir(pModelProdutos)){
           return true;
        }else{
            return false;
        }
        
        
    }
    //Deletar  produto controller
    public boolean DeletarProdutoController(int idProduto){
        
       return this.daoProdutos.deletar(idProduto);
        
    }
    //alterar produto controller
     public boolean AlterarProdutoController(ModelProdutos pModelProdutos){
        
      return  this.daoProdutos.alterarProdutoDAO(pModelProdutos);
        
    }
     
     //select do produto controller
     public ModelProdutos getProdutoController(int pIdProduto){
        
      return this.daoProdutos.getProduto(pIdProduto);
        
    }
     
      //select do produto controller
     public ModelProdutos getProdutoController(String pNomeProduto){
        
      return this.daoProdutos.getProduto(pNomeProduto);
        
    }
     
     //retornar lista produto controller
     //verificar dps esse "list"
     
     
     public ArrayList<ModelProdutos> getAllProdutoController(){
        
      return this.daoProdutos.getAllProdutos();
        
    }
    
}
