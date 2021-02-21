
package br.com.daniel.dao;

import br.com.daniel.factory.ConnectionFactory;
import br.com.daniel.model.EspacoCafe;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EspacoCafeDAO {

    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
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

     public List<EspacoCafe> buscarTodosEspacoCafe() {
        List<EspacoCafe> model = new ArrayList<>();
        try {

            String query = "SELECT * FROM espaco_cafe";
            pst = connection.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                EspacoCafe espacoCafe = new EspacoCafe();
                espacoCafe.setId(rs.getInt(1));
                espacoCafe.setDescricao(rs.getString(2));
                espacoCafe.setLotacao(rs.getInt(3));
                model.add(espacoCafe);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return model;
    }

}
