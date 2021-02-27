package br.com.daniel.dao;

import static br.com.daniel.dao.UsuarioDAO.rss;
import br.com.daniel.factory.ConnectionFactory;
import br.com.daniel.model.Evento;
import br.com.daniel.model.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class EventoDAO {

    public static PreparedStatement pst = null;
    public ResultSet rs = null;
    private int resultadoSala = 0;
    public static Connection connection;

    public EventoDAO() throws SQLException {
        this.connection = ConnectionFactory.conecta();
    }

    public void salvar(Evento evento) {
        compararUsuario();
        String sql = "INSERT INTO evento (intervalo, etapa, espaco_cafe_id, usuario_id, sala_id ) VALUES (?,?,?,?,?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setString(1, evento.getIntervalo());
            pst.setInt(2, evento.getEtapa());
            pst.setInt(3, evento.getEspacoCafe().getId());
            pst.setInt(4, evento.getUsuario().getId());
            pst.setInt(5, evento.getSala().getId());
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void alterar(Evento evento) {
    
        try {

            String query = "update evento set intervalo=?, etapa=?, espaco_cafe_id=?, usuario_id=? , sala_id=? where id=?";
            pst = connection.prepareStatement(query);
            pst.setInt(6, evento.getId());
            pst.setString(1, evento.getIntervalo());
            pst.setInt(2, evento.getEtapa());
            pst.setInt(3, evento.getEspacoCafe().getId());
            pst.setInt(4, evento.getUsuario().getId());
            pst.setInt(5, evento.getSala().getId());
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void buscarEventoPorNomeDoUsuario(Usuario usuario) {
        try {

            String sql = "select\n"
                    + "\n"
                    + " ev.intervalo,ev.etapa,ec.descricao AS Espaço  , us.nome AS pessoas, sa.nome AS Sala\n"
                    + "\n"
                    + "from\n"
                    + "evento ev\n"
                    + "inner join sala sa on(sa.id = ev.sala_id)\n"
                    + "inner join espaco_cafe ec on(ec.id = ev.espaco_cafe_id)\n"
                    + "inner join usuario us on(us.id = ev.usuario_id)\n"
                    + "where us.nome  LIKE '%" + usuario.getNome() + "%'\n";

            pst = connection.prepareStatement(sql);

            rss = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void compararUsuario() {
        try {
            String sqlquery = "SELECT e.salaid\n"
                    + "FROM (\n"
                    + "	SELECT COUNT(ev.id) AS qtd, ev.sala_id AS salaid  FROM evento AS ev \n"
                    + "	GROUP BY ev.sala_id)  e\n"
                    + "ORDER BY e.qtd ASC\n"
                    + "LIMIT 1;";
            pst = connection.prepareStatement(sqlquery);
            ResultSet rs = pst.executeQuery(sqlquery);

            while (rs.next()) {
                String retorno = rs.getString("salaid");
                resultadoSala = (Integer.parseInt(retorno));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void getTodosEventos() {

        try {
            String sql = "select\n"
                    + "\n"
                    + "ev.id AS IdEvento, ev.intervalo,ev.etapa,ec.descricao AS Espaço  , us.nome AS pessoas, sa.nome AS Sala\n"
                    + "\n"
                    + "from\n"
                    + "evento ev\n"
                    + "inner join sala sa on(sa.id = ev.sala_id)\n"
                    + "inner join espaco_cafe ec on(ec.id = ev.espaco_cafe_id)\n"
                    + "inner join usuario us on(us.id = ev.usuario_id)\n";

            pst = connection.prepareStatement(sql);
            rss = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
