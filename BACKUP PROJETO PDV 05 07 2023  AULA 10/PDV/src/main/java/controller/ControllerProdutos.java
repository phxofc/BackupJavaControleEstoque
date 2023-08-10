
package controller;

import DAO.DaoProdutos;
import java.util.ArrayList;
import java.util.List;
import model.ModelProdutos;


public class ControllerProdutos {
    
    private DaoProdutos daoProdutos = new DaoProdutos();
    
    
    //salvar produto controller
    public void SalvarProdutoController(ModelProdutos pModelProdutos){
        
        this.daoProdutos.inserir(pModelProdutos);
        
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
     
     //retornar lista produto controller
     //verificar dps esse "list"
     
     
     public List<ModelProdutos> getAllProdutoController(){
        
      return this.daoProdutos.getAllProdutos();
        
    }
    
}
