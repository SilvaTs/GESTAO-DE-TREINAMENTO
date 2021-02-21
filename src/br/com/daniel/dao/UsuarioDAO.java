
package br.com.daniel.dao;

import static br.com.daniel.dao.EspacoCafeDAO.connection;
import static br.com.daniel.dao.EspacoCafeDAO.pst;
import static br.com.daniel.dao.EspacoCafeDAO.rs;
import br.com.daniel.factory.ConnectionFactory;
import br.com.daniel.model.EspacoCafe;
import br.com.daniel.model.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    public static PreparedStatement pst = null;
       public static ResultSet rs = null;
   
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

 public List<Usuario> buscarTodosUsuarios() {
        List<Usuario> model = new ArrayList<>();
        try {

            String query = "SELECT * FROM usuario";
            pst = connection.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setNome(rs.getString(2));
                usuario.setSobreNome(rs.getString(3));
                model.add(usuario);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return model;
    }
    
}
