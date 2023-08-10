/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexoes.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelVendaProduto;

/**
 *
 * @author phdfr
 */
public class DaoVendasProdutos extends Conexao {

    //sempre lembrar de fazer isso abaixo para nao da erro de conn = null
    //criar construtor da classe. o construtor é executado automaticamente 
    //sempre que um novo obj é criado
    private Conexao conexao;
    private Connection conn;
    private ResultSet rs;
    private String resultado;

    public DaoVendasProdutos() {
        this.conexao = new Conexao();
        this.conn = this.conexao.Conexao();

    }

    //inserir
    public boolean inserir(ModelVendaProduto pModelVendaProduto) {

        String sql = "insert into tbl_vendas_produtos (fk_produto, fk_vendas, ven_pro_valor, ven_pro_quantidade) values (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setInt(1, pModelVendaProduto.getProduto());
            stmt.setInt(2, pModelVendaProduto.getVenda());
            stmt.setDouble(3, pModelVendaProduto.getVenProValor());
            stmt.setInt(3, pModelVendaProduto.getVenProQuantidade());
            stmt.execute();

        } catch (Exception e) {
            System.out.println("ERRO AO INSERIR Venda do Produto " + e.getMessage());
            return false;
        } finally {
            this.close();
        }
        return true;

    }

    //retornar get all usuarios
    public ArrayList<ModelVendaProduto> getAllVendaProduto() {
        String sql = "SELECT * FROM tbl_vendas_produtos";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //retorna todos os resultados nessa variavel rs
            ResultSet rs = stmt.executeQuery();
            //criar arraylist
            ArrayList<ModelVendaProduto> listaModelVendaProduto = new ArrayList<>();
            //pecorrer o rs e salva as informações de uma variavel
            //curso e depois salva essa variavel dentro da lista
            while (rs.next()) {
                //obs: quando usa rs é pq ta buscando do BANCO!!!
                ModelVendaProduto modelVendaProduto = new ModelVendaProduto();

                modelVendaProduto.setIdVendasProduto(rs.getInt(1));
                modelVendaProduto.setProduto(rs.getInt(2));
                modelVendaProduto.setVenda(rs.getInt(3));
                modelVendaProduto.setVenProValor(rs.getDouble(4));
                modelVendaProduto.setVenProQuantidade(rs.getInt(5));
                //jogar elemento dentro da lista
                listaModelVendaProduto.add(modelVendaProduto);

            }
            return listaModelVendaProduto;

        } catch (Exception e) {
            System.out.println("ERRO ao listar todos as vendas: " + e.getMessage());
            return null;
        } finally {
            this.close();
        }

    }
    
     //retornar um registro
     
         public ModelVendaProduto getVendaProduto(int idVendaProduto) {
        String sql = "SELECT * FROM tbl_usuario WHERE id__vendas_produtos= ?";

        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idVendaProduto);
            ResultSet rs = stmt.executeQuery();
           

            ModelVendaProduto modelVendaProduto = new ModelVendaProduto();

            
            if (rs.next()) {
                modelVendaProduto.setIdVendasProduto(rs.getInt(1));
                modelVendaProduto.setProduto(rs.getInt(2));
                modelVendaProduto.setVenda(rs.getInt(3));
                modelVendaProduto.setVenProValor(rs.getDouble(4));
                modelVendaProduto.setVenProQuantidade(rs.getInt(5));
            }else{
                System.out.println("não existe linhas ");
            }

            return modelVendaProduto;

        } catch (Exception e) {
            System.out.println("ERRO ao listar 1 venda:" + e.getMessage());
            return null;
        }finally{
            this.close();
        }

    }
         
          //alterar
     
     public boolean alterarVendaProduto(ModelVendaProduto pModelVendaProduto){
        String sql = "UPDATE tbl_vendas_produtos SET fk_produto=?, fk_vendas=?, ven_pro_valor=?, ven_pro_quantidade=? WHERE id_vendas_produtos = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, pModelVendaProduto.getProduto());
            stmt.setInt(2, pModelVendaProduto.getVenda());
            stmt.setDouble(3, pModelVendaProduto.getVenProValor());
            stmt.setInt(3, pModelVendaProduto.getVenProQuantidade());
            stmt.setInt(4, pModelVendaProduto.getIdVendasProduto());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao alterar venda do produto: "+ e.getMessage());
            return false;
        }
        finally{
            this.close();
        } 
        return true;
    }
     
     //deletar
    
    
     public boolean deletarVendaProduto(int idVendaProduto){
        String sql = "DELETE FROM tbl_vendas_produtos WHERE id_vendas_produtos = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idVendaProduto);
            stmt.execute();
            
            
        } catch (Exception e) {
            System.out.println("Erro ao deletar Venda do Produto: "+e.getMessage());
            return false;
        }finally{
            this.close();
        } 
        return true;
    }

}
