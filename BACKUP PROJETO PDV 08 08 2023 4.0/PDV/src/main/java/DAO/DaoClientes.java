package DAO;

import conexoes.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelCliente;

public class DaoClientes extends Conexao {

    private Conexao conexao;
    private Connection conn;
    private ResultSet rs;
    private String resultado;

    public DaoClientes() {
        this.conexao = new Conexao();
        this.conn = this.conexao.Conexao();

    }

    public boolean inserirCliente(ModelCliente pModelCliente) {

        String sql = "insert into tbl_cliente (cli_nome,cli_endereco,cli_bairro,cli_cidade,\n"
                + "cli_uf,cli_cep,cli_telefone) values (?, ?, ?, ?, ?, ?, ?); ";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            stmt.setString(1, pModelCliente.getCliNome());
            stmt.setString(2, pModelCliente.getCliEndereco());
            stmt.setString(3, pModelCliente.getCliBairro());
            stmt.setString(4, pModelCliente.getCliCidade());
            stmt.setString(5, pModelCliente.getCliUf());
            stmt.setString(6, pModelCliente.getCliCep());
            stmt.setString(7, pModelCliente.getCliTelefone());
            stmt.execute();
        } catch (Exception e) {
            
            System.out.println("ERRO AO INSERIR CLIENTE: "+e.getMessage());
            return false;
        }finally{
            this.close();
        }
        return true;

    }
    
    public boolean deletarCliente(int idCliente){
        
        String sql = "DELETE FROM tbl_cliente WHERE id_cliente = ?";
        
        try {
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            stmt.execute();
            
        } catch (Exception e) {
            System.out.println("ERRO AO DELETAR CLIENTE: "+e.getMessage());
            return false;
        }finally{
            this.close();
        }
        return true;
    }
    
    public boolean alterarClienteDAO(ModelCliente pModelCliente){
        
        String sql = "UPDATE tbl_cliente SET cli_nome=?, cli_endereco=?, cli_bairro=?, cli_cidade=?, cli_uf=?, cli_cep=?, cli_telefone=? WHERE id_cliente = ?;";
        
        
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
  
            stmt.setString(1, pModelCliente.getCliNome());
            stmt.setString(2, pModelCliente.getCliEndereco());
            stmt.setString(3, pModelCliente.getCliBairro());
            stmt.setString(4, pModelCliente.getCliCidade());
            stmt.setString(5, pModelCliente.getCliUf());
            stmt.setString(6, pModelCliente.getCliCep());
            stmt.setString(7, pModelCliente.getCliTelefone());
            stmt.setInt(8, pModelCliente.getIdCliente());
            stmt.execute();
            
        } catch (Exception e) {
            System.out.println("ERRO AO ALTERAR CLIENTE: "+e.getMessage());
            
        }finally{
            this.close();
        }
        return true;
        
    }
    
    public ModelCliente getCliente(int idCliente){
        String sql = "SELECT * FROM tbl_cliente WHERE id_cliente = ?;";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            
            ModelCliente modelCliente = new ModelCliente();
            
            if(rs.next()){
                modelCliente.setIdCliente(rs.getInt(1));
                modelCliente.setCliNome(rs.getString(2));
                modelCliente.setCliEndereco(rs.getString((3)));
                modelCliente.setCliBairro(rs.getString(4));
                modelCliente.setCliCidade(rs.getString(5));
                modelCliente.setCliUf(rs.getString(6));
                modelCliente.setCliCep(rs.getString(7));
                modelCliente.setCliTelefone(rs.getString(8));
            }else{
                System.out.println("NÃO EXISTE CLIENTE");
            }
            return modelCliente;
            
            
        } catch (Exception e) {
            System.out.println("erro ao pegar cliente: "+e.getMessage());
            return null;
        }finally{
            this.close();
        }
        
        
    }
    
    
     public ModelCliente getCliente(String pNomeCliente){
        String sql = "SELECT * FROM tbl_cliente WHERE cli_nome = ?;";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pNomeCliente);
            ResultSet rs = stmt.executeQuery();
            
            ModelCliente modelCliente = new ModelCliente();
            
            if(rs.next()){
                modelCliente.setIdCliente(rs.getInt(1));
                modelCliente.setCliNome(rs.getString(2));
                modelCliente.setCliEndereco(rs.getString((3)));
                modelCliente.setCliBairro(rs.getString(4));
                modelCliente.setCliCidade(rs.getString(5));
                modelCliente.setCliUf(rs.getString(6));
                modelCliente.setCliCep(rs.getString(7));
                modelCliente.setCliTelefone(rs.getString(8));
            }else{
                System.out.println("NÃO EXISTE CLIENTE");
            }
            return modelCliente;
            
            
        } catch (Exception e) {
            System.out.println("erro ao pegar cliente: "+e.getMessage());
            return null;
        }finally{
            this.close();
        }
        
        
    }
    
    
    
             public ArrayList<ModelCliente> getAllClientes(){
        String sql = "SELECT * FROM tbl_cliente";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //retorna todos os resultados nessa variavel rs
           ResultSet rs = stmt.executeQuery();
           //criar arraylist
           ArrayList<ModelCliente> listaModelClientes = new ArrayList<>();
           //pecorrer o rs e salva as informações de uma variavel
           //curso e depois salva essa variavel dentro da lista
           while(rs.next()){
               //obs: quando usa rs é pq ta buscando do BANCO!!!
               ModelCliente modelCliente = new ModelCliente();
               
              modelCliente.setIdCliente(rs.getInt(1));
                modelCliente.setCliNome(rs.getString(2));
                modelCliente.setCliEndereco(rs.getString((3)));
                modelCliente.setCliBairro(rs.getString(4));
                modelCliente.setCliCidade(rs.getString(5));
                modelCliente.setCliUf(rs.getString(6));
                modelCliente.setCliCep(rs.getString(7));
                modelCliente.setCliTelefone(rs.getString(8));
                //jogar elemento dentro da lista
               listaModelClientes.add(modelCliente);
                
               
           }
           return listaModelClientes;
            
        } catch (Exception e) {
            System.out.println("ERRO ao listar todos os clientes: "+e.getMessage());
            return null;
        }finally{
            this.close();
        }
        
    }

}
