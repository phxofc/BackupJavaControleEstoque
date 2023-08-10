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
import model.ModelUsuario;


public class DaoUsuarios extends Conexao {
    
       //sempre lembrar de fazer isso abaixo para nao da erro de conn = null
    //criar construtor da classe. o construtor é executado automaticamente 
    //sempre que um novo obj é criado
    private Conexao conexao;
    private Connection conn;
    private ResultSet rs;
    private String resultado;
    
    public DaoUsuarios() {
        this.conexao = new Conexao();
        this.conn = this.conexao.Conexao();

    }
    
    
     //inserir
    public boolean inserir(ModelUsuario pModelUsuarios) {

        String sql = "insert into tbl_usuario (usu_nome,usu_login,usu_senha) values (?, ?, ?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, pModelUsuarios.getUsuNome());
            stmt.setString(2, pModelUsuarios.getUsuLogin());
            stmt.setString(3, pModelUsuarios.getUsuSenha());
            stmt.execute();
            

        } catch (Exception e) {
            System.out.println("ERRO AO INSERIR Usuarios " + e.getMessage());
            return false;
        }finally{
            this.close();
        }
        return true;

    }
    
    //retornar get all usuarios
     public ArrayList<ModelUsuario> getAllUsuario(){
        String sql = "SELECT * FROM tbl_usuario";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //retorna todos os resultados nessa variavel rs
           ResultSet rs = stmt.executeQuery();
           //criar arraylist
           ArrayList<ModelUsuario> listaModelUsuarios = new ArrayList<>();
           //pecorrer o rs e salva as informações de uma variavel
           //curso e depois salva essa variavel dentro da lista
           while(rs.next()){
               //obs: quando usa rs é pq ta buscando do BANCO!!!
               ModelUsuario modelUsuario = new ModelUsuario();
               
               modelUsuario.setIdUsuario(rs.getInt(1));
                modelUsuario.setUsuLogin(rs.getString(2));
                modelUsuario.setUsuNome(rs.getString(3));
                modelUsuario.setUsuSenha(rs.getString(4));
                //jogar elemento dentro da lista
                listaModelUsuarios.add(modelUsuario);
                
               
           }
           return listaModelUsuarios;
            
        } catch (Exception e) {
            System.out.println("ERRO ao listar todos os usuarios: "+e.getMessage());
            return null;
        }finally{
            this.close();
        }
        
    }
     
     
     
     //retornar um registro
     
         public ModelUsuario getUsuario(int pIdUsuario) {
        String sql = "SELECT * FROM tbl_usuario WHERE id_usuario= ?";

        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, pIdUsuario);
            ResultSet rs = stmt.executeQuery();
           

            ModelUsuario modelUsuario = new ModelUsuario();

            
            if (rs.next()) {
                modelUsuario.setIdUsuario(rs.getInt(1));
                modelUsuario.setUsuLogin(rs.getString(2));
                modelUsuario.setUsuNome(rs.getString(3));
                modelUsuario.setUsuSenha(rs.getString(4));    
            }else{
                System.out.println("não existe linhas ");
            }

            return modelUsuario;

        } catch (Exception e) {
            System.out.println("ERRO ao listar 1 usuario:" + e.getMessage());
            return null;
        }finally{
            this.close();
        }

    }
         
         
         //alterar
     
     public boolean alterarUsuario(ModelUsuario pModelUsuario){
        String sql = "UPDATE tbl_usuario SET usu_nome=?, usu_login=?, usu_senha=? WHERE id_usuario = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pModelUsuario.getUsuNome());
            stmt.setString(2, pModelUsuario.getUsuLogin());
            stmt.setString(3, pModelUsuario.getUsuSenha());
            stmt.setInt(4, pModelUsuario.getIdUsuario());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao alterar usuario: "+ e.getMessage());
            return false;
        }
        finally{
            this.close();
        } 
        return true;
    }
    
     
     //deletar
    
    
     public boolean deletarUsuario(int idUsuario){
        String sql = "DELETE FROM tbl_usuario WHERE id_usuario = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            stmt.execute();
            
            
        } catch (Exception e) {
            System.out.println("Erro ao deletar usuario : "+e.getMessage());
            return false;
        }finally{
            this.close();
        } 
        return true;
    }

    public boolean getValidarUsuarioDao(ModelUsuario pmodelUsuario) {
        
         String sql = "SELECT * FROM tbl_usuario WHERE usu_login= ? AND usu_senha= ?";

        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pmodelUsuario.getUsuLogin());
            stmt.setString(2, pmodelUsuario.getUsuSenha());
            ResultSet rs = stmt.executeQuery();
           

            if(rs.next()){
                return true;
                
            }else{
                return false;
                
            }
           

        } catch (Exception e) {
            System.out.println("ERRO ao validar 1 usuario:" + e.getMessage());
            return false;
        }finally{
            this.close();
        }
     
    }
     
}
