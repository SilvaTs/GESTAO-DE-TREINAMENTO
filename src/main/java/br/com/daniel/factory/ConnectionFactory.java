package br.com.daniel.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionFactory {

   static String banco = "bd_treinamentos", senha = "";
    public static Connection con = null;
   
    public static String endereco
            = "jdbc:mysql://localhost:3306/" + banco + "?user=root&password=" + senha;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Erro do sistema", "falha ao carregar o drive"
                    + e,
                    JOptionPane.ERROR_MESSAGE);

        }
    }

public static Connection conecta() throws SQLException{
       if(con==null || con.isClosed()){
            
             con = (Connection) DriverManager.getConnection(endereco);
             }
             return con;
    }
       public static Connection desconecta() throws SQLException{
        con.close();
        return con;
    }
}
