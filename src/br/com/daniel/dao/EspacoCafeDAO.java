
package br.com.daniel.dao;

import br.com.daniel.factory.ConnectionFactory;
import br.com.daniel.model.EspacoCafe;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class EspacoCafeDAO {

    public static PreparedStatement pst = null;
    public ResultSet rs = null;
   
    public static Connection connection;

    public EspacoCafeDAO() throws SQLException {
        this.connection = ConnectionFactory.conecta();
    }

    public void salvar(EspacoCafe espacoCafe) {
        String sql = "INSERT INTO espaco_cafe (descricao,lotacao) VALUES (?,?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setString(1, espacoCafe.getDescricao());
            pst.setInt(2, espacoCafe.getLotacao());
          
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


}
