package br.edu.impacta.ads.aps.jdbc.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static Conexao conexao;
    
    private Conexao() {
    }
  
    public static Conexao getInstance(){
        if(conexao==null){
            conexao = new Conexao();
        }
        return conexao;
    }
   
    public synchronized Connection getConnection() throws ClassNotFoundException, SQLException{
      
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Empresa","fit", "fit");        
    }
}
