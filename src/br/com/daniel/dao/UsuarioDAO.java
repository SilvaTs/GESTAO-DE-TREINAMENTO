
package br.com.daniel.dao;

import br.com.daniel.factory.ConnectionFactory;
import br.com.daniel.model.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    public static PreparedStatement pst = null;
    public ResultSet rs = null;
   
    public static Connection connection;

    public UsuarioDAO() throws SQLException {
        this.connection = ConnectionFactory.conecta();
    }

    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome,sobrenome) VALUES (?,?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getSobreNome());
          
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


}
