package br.com.daniel.gui;

import br.com.daniel.dao.UsuarioDAO;
import br.com.daniel.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class GUICadastroUsuario extends javax.swing.JInternalFrame {

    private Usuario usuario;
    private UsuarioDAO usuarioDAO;

    PreparedStatement pst = null;
    ResultSet rs = null;

    public GUICadastroUsuario() {
        initComponents();
    }

    private void adicionar() {

        try {

            usuario = new Usuario();

            if ((jTxtNomeUsuario.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Preencha o campo nome");
                jTxtNomeUsuario.requestFocus();
            } else if ((jTxtSobreNomeUsuario.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Preencha o campo sobre nome");
                jTxtSobreNomeUsuario.requestFocus();

            } else {

                usuario.setNome(jTxtNomeUsuario.getText());
                usuario.setSobreNome(jTxtSobreNomeUsuario.getText());

                usuarioDAO = new UsuarioDAO();
                usuarioDAO.salvar(usuario);
                JOptionPane.showMessageDialog(null, "Usuário Inserido Com Sucesso! ");

                limpaCampo();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void limpaCampo() {
        jTxtNomeUsuario.setText("");
        jTxtSobreNomeUsuario.setText("");
        jTxtNomeUsuario.requestFocus();
    }
 
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtNomeUsuario = new javax.swing.JTextField();
        jTxtSobreNomeUsuario = new javax.swing.JTextField();
        BtSairUsuario = new javax.swing.JButton();
        BtCadastrarUsuario = new javax.swing.JButton();
        jLblSobreNomeUsuario = new javax.swing.JLabel();
        jLblNomeUsuario = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Tela de Cadastro de Pessoas");

        BtSairUsuario.setText("SAIR");
        BtSairUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSairUsuarioActionPerformed(evt);
            }
        });

        BtCadastrarUsuario.setText("CADASTRAR");
        BtCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCadastrarUsuarioActionPerformed(evt);
            }
        });

        jLblSobreNomeUsuario.setText("SOBRE NOME");

        jLblNomeUsuario.setText("NOME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTxtNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                        .addComponent(jTxtSobreNomeUsuario)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BtCadastrarUsuario)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(BtSairUsuario)))
                    .addComponent(jLblNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblSobreNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblSobreNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtSobreNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtCadastrarUsuario)
                    .addComponent(BtSairUsuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtSairUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSairUsuarioActionPerformed
        dispose();
    }//GEN-LAST:event_BtSairUsuarioActionPerformed

    private void BtCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCadastrarUsuarioActionPerformed
        adicionar();
    }//GEN-LAST:event_BtCadastrarUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCadastrarUsuario;
    private javax.swing.JButton BtSairUsuario;
    private javax.swing.JLabel jLblNomeUsuario;
    private javax.swing.JLabel jLblSobreNomeUsuario;
    private javax.swing.JTextField jTxtNomeUsuario;
    private javax.swing.JTextField jTxtSobreNomeUsuario;
    // End of variables declaration//GEN-END:variables
}
