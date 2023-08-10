
package controller;

import DAO.DaoUsuarios;
import java.util.ArrayList;
import model.ModelUsuario;


public class ControllerUsuarios {
    
    private DaoUsuarios daoUsuarios = new DaoUsuarios();
    
    public boolean SalvarUsuarioController(ModelUsuario daoUsuarios){
        
        if (this.daoUsuarios.inserirUsuario(daoUsuarios)) {
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
    
     public ModelUsuario getClienteController(int idUsuario){
        return this.daoUsuarios.getUsuario(idUsuario);
    }
     public ArrayList<ModelUsuario> getAllClienteController(){
        return this.daoUsuarios.getAllUsuario();
    }
    
    
}
