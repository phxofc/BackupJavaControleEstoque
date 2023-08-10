package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private Statement stmt;
    private ResultSet rs;
    public Connection conn;
    public String resultado = "";

    public Connection Conexao() {

        String url = "jdbc:mysql://localhost:3306/projetojava?autoReconnect=true&useSSL=false";
        String usr = "root";
        String pas = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usr, pas);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return conn;
        } catch (Exception e) {
            System.out.println("Erro" + e.getMessage());
            return null;
        }

    }
    
    
    public void close() {
        try {
            if (conn != null) {
                // Fechar a conexão
                conn.close();
                System.out.println("Conexão fechada com sucesso.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
    
    
    

}


