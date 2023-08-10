
package model;


public class ModelUsuario {
    private int idUsuario;
    private String usuNome;
    private String usuLogin;
    private String usuSenha;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuNome() {
        return usuNome;
    }

    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    @Override
    public String toString() {
        return "ModelUsuario{" + "idUsuario=" + idUsuario + ", usuNome=" + usuNome + ", usuLogin=" + usuLogin + ", usuSenha=" + usuSenha + '}';
    }
    
    
    
    
    
}
