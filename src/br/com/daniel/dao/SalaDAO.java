package br.com.daniel.dao;

import static br.com.daniel.dao.UsuarioDAO.connection;
import static br.com.daniel.dao.UsuarioDAO.pst;
import static br.com.daniel.dao.UsuarioDAO.rss;
import br.com.daniel.factory.ConnectionFactory;
import br.com.daniel.model.EspacoCafe;
import br.com.daniel.model.Sala;
import br.com.daniel.model.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SalaDAO {

    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static Connection connection;

    public SalaDAO() throws SQLException {
        this.connection = ConnectionFactory.conecta();
    }

    public void salvar(Sala sala) {
        String sql = "INSERT INTO sala (nome,lotacao) VALUES (?,?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setString(1, sala.getNome());
            pst.setInt(2, sala.getLotacao());

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public List<Sala> buscarTodasSalas() {
        List<Sala> model = new ArrayList<>();
        try {

            String query = "SELECT * FROM sala";
            pst = connection.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Sala sala = new Sala();
                sala.setId(rs.getInt(1));
                sala.setNome(rs.getString(2));
                sala.setLotacao(rs.getInt(3));
                model.add(sala);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return model;
    }

    public void buscarSalaOuEspacoCafe(Sala sala, EspacoCafe espacoCafe) {
        try {

            String sql = "select\n"
                    + "\n"
                    + "us.nome as Pessoas\n"
                    + "\n"
                    + "from\n"
                    + "evento ev\n"
                    + "inner join sala sa on(sa.id = ev.sala_id)\n"
                    + "inner join espaco_cafe ec on(ec.id = ev.espaco_cafe_id)\n"
                    + "inner join usuario us on(us.id = ev.usuario_id)\n"
                    + "where sa.nome LIKE '%" + sala.getNome()+"%' or ec.descricao LIKE '%"+ espacoCafe.getDescricao()+ "%' \n";


            pst = connection.prepareStatement(sql);

            rss = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

}
