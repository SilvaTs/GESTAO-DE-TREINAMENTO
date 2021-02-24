package br.com.daniel.gui;

import br.com.daniel.dao.UsuarioDAO;
import static br.com.daniel.dao.UsuarioDAO.rss;
import br.com.daniel.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Daniel
 */
public class GUIConsultarUsuario extends javax.swing.JInternalFrame {

  
    private Usuario usuario;
    private UsuarioDAO usuarioDAO;

    PreparedStatement pst = null;
    ResultSet rs = null;

    public GUIConsultarUsuario() {
        initComponents();
    }

    private void pesquisarUsuarios() {

        try {
            usuarioDAO = new UsuarioDAO();
            usuario = new Usuario();
            usuario.setNome(jTxtPesquisarUsuarios.getText());
            if (jTxtPesquisarUsuarios.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Digite um Nome ou a Letra Inical Da Pessoa");

            } else {

                usuarioDAO.buscarUsuarioPorNome(usuario);

                jTblTreinamento.setModel(DbUtils.resultSetToTableModel(rss));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtPesquisarUsuarios = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblTreinamento = new javax.swing.JTable();
        BtBuscar = new javax.swing.JButton();

        setClosable(true);
        setTitle("TELA CONSULTAR PESSOA");

        jTblTreinamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sala", "Espaço"
            }
        ));
        jTblTreinamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblTreinamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblTreinamento);

        BtBuscar.setText("BUSCAR");
        BtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTxtPesquisarUsuarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtPesquisarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTblTreinamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblTreinamentoMouseClicked

    }//GEN-LAST:event_jTblTreinamentoMouseClicked

    private void BtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarActionPerformed
        pesquisarUsuarios();
    }//GEN-LAST:event_BtBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTblTreinamento;
    private javax.swing.JTextField jTxtPesquisarUsuarios;
    // End of variables declaration//GEN-END:variables
}
