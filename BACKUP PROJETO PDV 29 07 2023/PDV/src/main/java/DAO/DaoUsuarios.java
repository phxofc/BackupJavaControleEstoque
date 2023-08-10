package DAO;



import conexoes.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

        String sql = "insert tbl_usuario (usu_nome, usu_login, usu_senha) values (?, ?, ?);";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pModelUsuario.getUsuNome());
            stmt.setString(2, pModelUsuario.getUsuLogin());
            stmt.setString(3, pModelUsuario.getUsuSenha());
            stmt.execute();

        } catch (Exception e) {
            System.out.println("ERRO AO INSERIR USUARIO: " + e.getMessage());
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
    
    //metodo para pegar um usuario do banco pelo id
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
    
    
    public ArrayList<ModelUsuario> getAllUsuario(){
        String sql = "SELECT * FROM tbl_usuario";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();
           //criar arraylist
           ArrayList<ModelUsuario> listaModelUsuarios = new ArrayList<>();
           //pecorrer o rs e salva as informações de uma variavel
           //curso e depois salva essa variavel dentro da lista
           while(rs.next()){
               ModelUsuario modelUsuario = new ModelUsuario();
               
              modelUsuario.setIdUsuario(rs.getInt(1));
                modelUsuario.setUsuNome(rs.getString(2));
                modelUsuario.setUsuLogin(rs.getString((3)));
                modelUsuario.setUsuSenha(rs.getString(4));
                
                //jogar elemento dentro da lista
               listaModelUsuarios.add(modelUsuario);
           }
           return listaModelUsuarios;
           
        } catch (Exception e) {
            System.out.println("ERRO AO LISTAR USUARIOS: "+e.getMessage());
            return null;
        }finally{
            this.close();
        }
    }

}

