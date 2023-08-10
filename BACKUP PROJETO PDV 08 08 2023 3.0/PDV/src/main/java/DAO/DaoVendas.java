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
import model.ModelVenda;

/**
 *
 * @author phdfr
 */
public class DaoVendas extends Conexao {

    //sempre lembrar de fazer isso abaixo para nao da erro de conn = null
    //criar construtor da classe. o construtor é executado automaticamente 
    //sempre que um novo obj é criado
    private Conexao conexao;
    private Connection conn;
    private ResultSet rs;
    private String resultado;

    public DaoVendas() {
        this.conexao = new Conexao();
        this.conn = this.conexao.Conexao();

    }

    //inserir
    public boolean inserir(ModelVenda pModelVenda) {

        String sql = "insert into tbl_vendas(fk_cliente, fk_produto, ven_data_venda, ven_valor_liquido, ven_valor_bruto, ven_valor_desconto) values (?, ?, ?, ?, ?);";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setInt(1, pModelVenda.getCliente());
            stmt.setInt(2, pModelVenda.getProduto());
            stmt.setDate(3, pModelVenda.getDataVenda());
            stmt.setDouble(4, pModelVenda.getVenValorLiquido());
            stmt.setDouble(3, pModelVenda.getVenValorBruto());
            stmt.setDouble(3, pModelVenda.getVenValorDesconto());
            stmt.execute();

        } catch (Exception e) {
            System.out.println("ERRO AO INSERIR venda " + e.getMessage());
            return false;
        } finally {
            this.close();
        }
        return true;

    }

    //retornar get all 
    public ArrayList<ModelVenda> getAllVenda() {
        String sql = "SELECT * FROM tbl_vendas";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //retorna todos os resultados nessa variavel rs
            ResultSet rs = stmt.executeQuery();
            //criar arraylist
            ArrayList<ModelVenda> listaModelVendas = new ArrayList<>();
            //pecorrer o rs e salva as informações de uma variavel
            //curso e depois salva essa variavel dentro da lista
            while (rs.next()) {
                //obs: quando usa rs é pq ta buscando do BANCO!!!
                ModelVenda modelVenda = new ModelVenda();

                modelVenda.setIdVenda(rs.getInt(1));
                modelVenda.setCliente(rs.getInt(2));
                modelVenda.setProduto(rs.getInt(3));
                modelVenda.setDataVenda(rs.getDate(4));
                modelVenda.setVenValorLiquido(rs.getDouble(5));
                modelVenda.setVenValorBruto(rs.getDouble(6));
                modelVenda.setVenValorDesconto(rs.getDouble(7));

                //jogar elemento dentro da lista
                listaModelVendas.add(modelVenda);

            }
            return listaModelVendas;

        } catch (Exception e) {
            System.out.println("ERRO ao listar todos as vendas: " + e.getMessage());
            return null;
        } finally {
            this.close();
        }

    }

    //retornar um registro
    public ModelVenda getVenda(int pIdVenda) {
        String sql = "SELECT * FROM tbl_vendas WHERE id_vendas= ?";

        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, pIdVenda);
            ResultSet rs = stmt.executeQuery();

            ModelVenda modelVenda = new ModelVenda();

            if (rs.next()) {
                modelVenda.setIdVenda(rs.getInt(1));
                modelVenda.setCliente(rs.getInt(2));
                modelVenda.setProduto(rs.getInt(3));
                modelVenda.setDataVenda(rs.getDate(4));
                modelVenda.setVenValorLiquido(rs.getDouble(5));
                modelVenda.setVenValorBruto(rs.getDouble(6));
                modelVenda.setVenValorDesconto(rs.getDouble(7));
            } else {
                System.out.println("não existe linhas ");
            }

            return modelVenda;

        } catch (Exception e) {
            System.out.println("ERRO ao listar 1 venda:" + e.getMessage());
            return null;
        } finally {
            this.close();
        }

    }
    
    //alterar
     
     public boolean alterarVenda(ModelVenda pModelVenda){
        String sql = "UPDATE tbl_vendas SET fk_cliente=?, fk_produto=?, ven_data_venda=?, ven_valor_liquido=?, ven_valor_bruto=?, ven_valor_desconto=? WHERE id_vendas = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, pModelVenda.getCliente());
            stmt.setInt(2, pModelVenda.getProduto());
            stmt.setDate(3, pModelVenda.getDataVenda());
            stmt.setDouble(4, pModelVenda.getVenValorLiquido());
            stmt.setDouble(5, pModelVenda.getVenValorBruto());
            stmt.setDouble(6, pModelVenda.getVenValorDesconto());
            stmt.setInt(7, pModelVenda.getIdVenda());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao alterar venda: "+ e.getMessage());
            return false;
        }
        finally{
            this.close();
        } 
        return true;
    }
     
     
     //deletar
    
    
     public boolean deletarVenda(int idVenda){
        String sql = "DELETE FROM tbl_bendas WHERE id_vendas = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idVenda);
            stmt.execute();
            
            
        } catch (Exception e) {
            System.out.println("Erro ao deletar venda : "+e.getMessage());
            return false;
        }finally{
            this.close();
        } 
        return true;
    }

}
