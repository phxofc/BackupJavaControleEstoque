
package DAO;

import conexoes.Conexao;
import java.sql.PreparedStatement;
import model.ModelProdutos;


public class DaoProdutos extends Conexao {
    
    
    
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
    
    
}
