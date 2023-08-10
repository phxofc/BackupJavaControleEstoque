package DAO;

import conexoes.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        
        String sql = "DELETE * FROM tbl_cliente WHERE id_cliente = ?";
        
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
    
    public boolean alterarCliente(ModelCliente pModelCliente){
        
        String sql = "UPDATE tbl_cliente SET cli_nome=? cli_endereco=?, cli_bairro=?, cli_cidade=?, cli_uf=?, cli_cep=?, cli_telefone=? WHERE id_cliente = ?;";
        
        
        
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

}
