
package br.com.daniel.dao;

import br.com.daniel.factory.ConnectionFactory;
import br.com.daniel.model.Sala;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class SalaDAO {

    public static PreparedStatement pst = null;
    public ResultSet rs = null;
   
    public static Connection connection;

    public SalaDAO() throws SQLException {
        this.connection = ConnectionFactory.conecta();
    }

    public void salvar(Sala sala) {
        String sql = "INSERT INTO sala (nome,lotacao) VALUES (?,?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setString(1, sala.getNome());
            pst.setString(2, sala.getLotacao());
          
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


}
