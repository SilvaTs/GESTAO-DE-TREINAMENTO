
package br.com.daniel.dao;

import br.com.daniel.factory.ConnectionFactory;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    public static PreparedStatement pst = null;
    public ResultSet rs = null;
    public static ResultSet rss = null;
    public static ResultSet rsss = null;

    public static Connection con;

    public UsuarioDAO() throws SQLException {
        this.con = ConnectionFactory.conecta();
    }

//    public void salvar(Produtos produtos) {
//        String sql = "INSERT INTO produto (fabricante,modelo,descricao,qtd,valorunit) VALUES (?,?,?,?,?)";
//        try {
////            Connection con = BDconexao.conecta();
//
//            pst = con.prepareStatement(sql);
//            pst.setString(1, produtos.getFabricante());
//            pst.setString(2, produtos.getModelo());
//            pst.setString(3, produtos.getDescricao());
//            pst.setInt(4, produtos.getQtd());
//            pst.setDouble(5, produtos.getValorunit());
//            pst.executeUpdate();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
//
//    public void alterar(Produtos produtos) {
//
//        try {
////            Connection con = BDconexao.conecta();
//
//            String query = "update produto set fabricante=?, modelo=?, descricao=?, qtd=?, valorunit=? where idproduto=?";
//            pst = con.prepareStatement(query);
//            pst.setInt(6, produtos.getIdproduto());
//            pst.setString(1, produtos.getFabricante());
//            pst.setString(2, produtos.getModelo());
//            pst.setString(3, produtos.getDescricao());
//            pst.setInt(4, produtos.getQtd());
//            pst.setDouble(5, produtos.getValorunit());
//            pst.executeUpdate();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
//
//    public void buscarProdutosPorFabricante(Produtos objProduto) {
//        try {
////            Connection con = BDconexao.conecta();
//
//            String sql = "SELECT * FROM produto WHERE fabricante LIKE '%" + objProduto.getFabricante() + "%' ";
//
//            pst = con.prepareStatement(sql);
//
//            rss = pst.executeQuery();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//
//        }
//    }
//
//    public void deletarProduto(Produtos objProdutos) {
//
//        try {
////                Connection con = BDconexao.conecta();
//
//            String sql = "delete from produto where idproduto=?";
//            pst = con.prepareStatement(sql);
//            pst.setString(1, String.valueOf(objProdutos.getIdproduto()));
//            pst.executeUpdate();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//
//    }
//
//    public List<Produtos> buscarTodosProdutos() {
//        List<Produtos> model = new ArrayList<>();
//        try {
//
//            String query = "SELECT * FROM produto";
//            pst = con.prepareStatement(query);
//            rss = pst.executeQuery();
//
//            while (rss.next()) {
//                Produtos produtos = new Produtos();
//                produtos.setIdproduto(rss.getInt(1));
//                produtos.setFabricante(rss.getString(2));
//                produtos.setModelo(rss.getString(3));
//                produtos.setDescricao(rss.getString(4));
//                produtos.setQtd(rss.getInt(5));
//                produtos.setValorunit(rss.getDouble(6));
//                model.add(produtos);
//            }
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//        return model;
//    }
//
//    public void getTodosProdutos() {
//
//        try {
//
//            String query = "SELECT * FROM produto";
//            pst = con.prepareStatement(query);
//            rss = pst.executeQuery();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

}
