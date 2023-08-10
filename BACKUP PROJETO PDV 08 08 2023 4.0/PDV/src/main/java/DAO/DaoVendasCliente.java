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
import model.ModelCliente;
import model.ModelVenda;
import model.ModelVendasCliente;

/**
 *
 * @author phdfr
 */
public class DaoVendasCliente extends Conexao{
    
     //sempre lembrar de fazer isso abaixo para nao da erro de conn = null
    //criar construtor da classe. o construtor é executado automaticamente 
    //sempre que um novo obj é criado
    private Conexao conexao;
    private Connection conn;
    private ResultSet rs;
    private String resultado;

    public DaoVendasCliente() {
        this.conexao = new Conexao();
        this.conn = this.conexao.Conexao();

    }
    
    
    
    
     //retornar get all 
    public ArrayList<ModelVendasCliente> getAllVendaCliente() {
        String sql = "SELECT * FROM tbl_vendas INNER JOIN tbl_cliente ON tbl_cliente.id_cliente = tbl_vendas.fk_cliente;";

        try {
            ModelVendasCliente modelVendasCliente = new ModelVendasCliente();
            ModelCliente modelCliente = new ModelCliente();
            ModelVenda modelVenda = new ModelVenda();
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //retorna todos os resultados nessa variavel rs
            ResultSet rs = stmt.executeQuery();
            //criar arraylist
            ArrayList<ModelVendasCliente> listaModelVendasCliente = new ArrayList<>();
            //pecorrer o rs e salva as informações de uma variavel
            //curso e depois salva essa variavel dentro da lista
            while (rs.next()) {
                //zerar tudo
                modelVendasCliente = new ModelVendasCliente();
                modelCliente = new ModelCliente();
                modelVenda = new ModelVenda();
                
                //setando venda
                modelVenda.setIdVenda(rs.getInt(1));
                modelVenda.setCliente(rs.getInt(2));
                modelVenda.setProduto(rs.getInt(3));
                modelVenda.setDataVenda(rs.getDate(4));
                modelVenda.setVenValorLiquido(rs.getDouble(5));
                modelVenda.setVenValorBruto(rs.getDouble(6));
                modelVenda.setVenValorDesconto(rs.getDouble(7));

                //setando cliente tbm
                
                modelCliente.setIdCliente(rs.getInt(8));
                modelCliente.setCliNome(rs.getString(9));
                modelCliente.setCliEndereco(rs.getString((10)));
                modelCliente.setCliBairro(rs.getString(11));
                modelCliente.setCliCidade(rs.getString(12));
                modelCliente.setCliUf(rs.getString(13));
                modelCliente.setCliCep(rs.getString(14));
                modelCliente.setCliTelefone(rs.getString(15));
                
                //juntando os dois
                modelVendasCliente.setModelVenda(modelVenda);
                modelVendasCliente.setModelCliente(modelCliente);
                
                listaModelVendasCliente.add(modelVendasCliente);

            }
            return listaModelVendasCliente;

        } catch (Exception e) {
            System.out.println("ERRO ao listar todos as vendas: " + e.getMessage());
            return null;
        } finally {
            this.close();
        }

    }
    
}
