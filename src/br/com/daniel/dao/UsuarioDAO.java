package br.com.daniel.dao;

import br.com.daniel.factory.ConnectionFactory;
import br.com.daniel.model.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static ResultSet rss = null;

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

    public void buscarUsuarioPorNome(Usuario usuario) {
        try {
            
            String sql = "select\n"
                    + "\n"
                    + "sa.nome as Sala, ec.descricao as Espaço\n"                 
                    + "\n"
                    + "from\n"
                    + "evento ev\n"
                    + "inner join sala sa on(sa.id = ev.sala_id)\n"
                    + "inner join espaco_cafe ec on(ec.id = ev.espaco_cafe_id)\n"
                    + "inner join usuario us on(us.id = ev.usuario_id)\n"
                    + "where us.nome  LIKE '%" + usuario.getNome() + "%'\n" ;
            
            pst = connection.prepareStatement(sql);

            rss = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

}
