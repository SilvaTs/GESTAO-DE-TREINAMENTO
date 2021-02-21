
package br.com.daniel.dao;

import br.com.daniel.factory.ConnectionFactory;
import br.com.daniel.model.Evento;
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

}
