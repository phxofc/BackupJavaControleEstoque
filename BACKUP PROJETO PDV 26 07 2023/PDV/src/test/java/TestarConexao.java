
import conexoes.Conexao;


public class TestarConexao {
    public static void main(String[] args) {
       Conexao conexao = new Conexao();

        try {
            conexao.Conexao();
            if (conexao.conn != null) {
                System.out.println("Conexão estabelecida com sucesso!");
                // Faça outras operações de teste aqui, como consultas ao banco de dados
            } else {
                System.out.println("Falha ao estabelecer conexão.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        } finally {
            conexao.close();
        }
    }
    
}
