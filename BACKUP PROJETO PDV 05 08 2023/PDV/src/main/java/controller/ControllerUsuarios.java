
package controller;

import DAO.DaoUsuarios;
import java.util.ArrayList;
import model.ModelUsuario;


public class ControllerUsuarios {
    
    private DaoUsuarios daoUsuarios = new DaoUsuarios();
    
    public boolean SalvarUsuarioController(ModelUsuario pModelUsuario){
        
        if(this.daoUsuarios.inserir(pModelUsuario)) {
            return true;
        } else {
            return false;
        }
        
    }
    
    public boolean AlterarUsuarioController(ModelUsuario pModelUsuarios){
        return this.daoUsuarios.alterarUsuario(pModelUsuarios);
    }
    
    public boolean DeletarUsuariosController(int idUsuario){
        return this.daoUsuarios.deletarUsuario(idUsuario);
    }
    
     public ModelUsuario getUsuarioController(int idUsuario){
        return this.daoUsuarios.getUsuario(idUsuario);
    }
     public ArrayList<ModelUsuario> getAllUsuarioController(){
        return this.daoUsuarios.getAllUsuario();
    }
    
    
}
