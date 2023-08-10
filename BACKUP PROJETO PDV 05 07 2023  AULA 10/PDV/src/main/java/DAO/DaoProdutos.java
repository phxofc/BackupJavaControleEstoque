
package DAO;

import conexoes.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ModelProdutos;


public class DaoProdutos extends Conexao {
    
    
    //inserir
    public void inserir(ModelProdutos pModelProdutos) {

        String sql = "insert into tbl_produto (pro_nome,pro_valor,pro_estoque) values (?, ?, ?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, pModelProdutos.getProNome());
            stmt.setDouble(2, pModelProdutos.getProValor());
            stmt.setInt(3, pModelProdutos.getProEstoque());
            stmt.execute();
            

        } catch (Exception e) {
            System.out.println("ERRO AO INSERIR PESSOA " + e.getMessage());
        }finally{
            this.close();
        }

    }
    
    //deletar
    
    
     public boolean deletar(int idProduto){
        String sql = "DELETE FROM tbl_produto WHERE id_produto = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idProduto);
            stmt.execute();
            
            
        } catch (Exception e) {
            System.out.println("Erro ao deletar : "+e.getMessage());
            return false;
        }finally{
            this.close();
        } 
        return true;
    }
     
     
     //alterar
     
     public boolean alterarProdutoDAO(ModelProdutos pModelProdutos){
        String sql = "UPDATE tbl_produto SET pro_nome=?, pro_valor=?, pro_estoque=? WHERE id_produto = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pModelProdutos.getProNome());
            stmt.setDouble(2, pModelProdutos.getProValor());
            stmt.setInt(3, pModelProdutos.getProEstoque());
            stmt.setInt(4, pModelProdutos.getIdProduto());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro na edição: "+ e.getMessage());
            return false;
        }
        finally{
            this.close();
        } 
        return true;
    }
     
     //retornar um registro
     
         public ModelProdutos getProduto(int pIdProduto) {
        String sql = "SELECT * FROM tbl_produto WHERE id_produto = ?";

        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, pIdProduto);
            ResultSet rs = stmt.executeQuery();
           

            ModelProdutos modelProdutos = new ModelProdutos();

            
            if (rs.next()) {
                modelProdutos.setIdProduto(rs.getInt(1));
                modelProdutos.setProNome(rs.getString(2));
                modelProdutos.setProValor(rs.getDouble(3));
                modelProdutos.setProEstoque(rs.getInt(4));    
            }else{
                System.out.println("não existe linhas ");
            }

            return modelProdutos;

        } catch (Exception e) {
            System.out.println("ERRO:" + e.getMessage());
            return null;
        }finally{
            this.close();
        }

    }
         
         //listar todos os produtos
         
         public List<ModelProdutos> getAllProdutos(){
        String sql = "SELECT * FROM tbl_produto";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //retorna todos os resultados nessa variavel rs
           ResultSet rs = stmt.executeQuery();
           //criar arraylist
           List<ModelProdutos> listaModelProdutos = new ArrayList<>();
           //pecorrer o rs e salva as informações de uma variavel
           //curso e depois salva essa variavel dentro da lista
           while(rs.next()){
               //obs: quando usa rs é pq ta buscando do BANCO!!!
               ModelProdutos modelProdutos = new ModelProdutos();
               
               modelProdutos.setIdProduto(rs.getInt(1));
                modelProdutos.setProNome(rs.getString(2));
                modelProdutos.setProValor(rs.getDouble(3));
                modelProdutos.setProEstoque(rs.getInt(4));
                //jogar elemento dentro da lista
                listaModelProdutos.add(modelProdutos);
                
               
           }
           return listaModelProdutos;
            
        } catch (Exception e) {
            System.out.println("ERRO ao listar todos os produtos: "+e.getMessage());
            return null;
        }finally{
            this.close();
        }
        
    }
    
    
}
