
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
    public  ResultSet rs = null;
   
    public static Connection connection;

    public EventoDAO() throws SQLException {
        this.connection = ConnectionFactory.conecta();
    }

    public void salvar(Evento evento) {
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
                    + "where us.nome  LIKE '%" + usuario.getNome() + "%'\n" ;
            
            pst = connection.prepareStatement(sql);

            rss = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
        
          public void getTodosEventos() {

        try {
            String sql = "select\n"
                            + "\n"
                            + " ev.intervalo,ev.etapa,ec.descricao AS Espaço  , us.nome AS pessoas, sa.nome AS Sala\n"                 
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
