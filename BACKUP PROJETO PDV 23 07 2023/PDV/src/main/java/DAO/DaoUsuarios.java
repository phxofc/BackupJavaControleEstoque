package DAO;

import com.mysql.cj.PreparedQuery;
import com.mysql.cj.xdevapi.Result;
import conexoes.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.ModelUsuario;

public class DaoUsuarios extends Conexao {

    private Conexao conexao;
    private Connection connection;
    private ResultSet rs;
    private String resultado;

    public DaoUsuarios() {
        this.conexao = new Conexao();
        this.conn = this.conexao.Conexao();

    }

    //metodo inserir usuario
    public boolean inserirUsuario(ModelUsuario pModelUsuario) {

        String sql = "INSERT INTO tbl_usuario (usu_nome, usu_login, usu_senha) values (?, ?, ?);";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pModelUsuario.getUsuNome());
            stmt.setString(2, pModelUsuario.getUsuLogin());
            stmt.setString(3, pModelUsuario.getUsuSenha());
            stmt.execute();

        } catch (Exception e) {
            System.out.println("ERRO AO INSERIR USUARIO" + e.getMessage());
            return false;
        } finally {
            this.close();
        }
        return true;
    }

    //metodo deletar usuario
    public boolean deletarUsuario(int idUsuario) {

        String sql = "DELETE FROM tbl_usuario WHERE id_usuario = ?;";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("ERRO AO DELETAR O USUARIO"+e.getMessage());
            return false;
        }finally{
            this.close();
        }
        return true;

    }
    
    //metodo alterar usuario
    
    public boolean alterarUsuario(ModelUsuario pModelUsuario){
        String sql = "UPDATE tbl_usuario SET usu_nome=?, usu_login=?, usu_senha=? WHERE id_usuario=?;";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pModelUsuario.getUsuNome());
            stmt.setString(2, pModelUsuario.getUsuLogin());
            stmt.setString(3, pModelUsuario.getUsuSenha());
            stmt.setInt(4, pModelUsuario.getIdUsuario());
            stmt.execute();

        } catch (Exception e) {
            System.out.println("ERRO AO ALTERAR USUARIO"+ e.getMessage());
            return false;
        }finally{
            this.close();
        }
        return true;
    }
    
    //metodo para pegar um cliente do banco pelo id
    public ModelUsuario getUsuario(int idUsuario) {
        String sql = "SELECT * FROM tbl_usuario WHERE id_usuario = ?;";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            
            
            ModelUsuario modelUsuario = new ModelUsuario();
            
            if(rs.next()){
                modelUsuario.setIdUsuario(rs.getInt(1));
                modelUsuario.setUsuNome(rs.getString(2));
                modelUsuario.setUsuLogin(rs.getString(3));
                modelUsuario.setUsuSenha(rs.getString(4));
                
            }else{
                System.out.println("NÃO EXISTE USUARIO");
            }
            return modelUsuario;
        } catch (Exception e) {
            System.out.println("ERRO AO LISTAR USUARIOS"+e.getMessage());
            return null;
        }finally{
            this.close();
        }
        
    
}

}

