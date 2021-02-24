package br.com.daniel.gui;

import br.com.daniel.dao.SalaDAO;
import br.com.daniel.model.Sala;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class GUICadastroSala extends javax.swing.JInternalFrame {

    private Sala sala;
    private SalaDAO salaDAO;

    PreparedStatement pst = null;
    ResultSet rs = null;

    public GUICadastroSala() {
        initComponents();
    }

    private void adicionar() {

        try {

            sala = new Sala();

            if ((jTxtNomeSala.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Preencha o campo nome");
                jTxtNomeSala.requestFocus();
            } else if ((jTxtLotacaoSala.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Preencha o campo lotação");
                jTxtLotacaoSala.requestFocus();
            } else {
                int quantidade = Integer.parseInt(jTxtLotacaoSala.getText());
                sala.setNome(jTxtNomeSala.getText());
                sala.setLotacao(quantidade);

                salaDAO = new SalaDAO();
                salaDAO.salvar(sala);
                JOptionPane.showMessageDialog(null, "Sala Inserida Com Sucesso! ");

                limpaCampo();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void limpaCampo() {
        jTxtNomeSala.setText("");
        jTxtLotacaoSala.setText("");
        jTxtNomeSala.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblNomeSala = new javax.swing.JLabel();
        jLblLotacaoSala = new javax.swing.JLabel();
        jTxtNomeSala = new javax.swing.JTextField();
        jTxtLotacaoSala = new javax.swing.JTextField();
        BtCadastrarSala = new javax.swing.JButton();
        BtSairSala = new javax.swing.JButton();

        setClosable(true);
        setTitle("Tela de Cadastro de Salas");

        jLblNomeSala.setText("NOME");

        jLblLotacaoSala.setText("LOTAÇÃO");

        BtCadastrarSala.setText("CADASTRAR");
        BtCadastrarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCadastrarSalaActionPerformed(evt);
            }
        });

        BtSairSala.setText("SAIR");
        BtSairSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSairSalaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblLotacaoSala)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTxtLotacaoSala, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(jLblNomeSala, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtNomeSala, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(BtCadastrarSala)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtSairSala)))
                        .addContainerGap(37, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLblNomeSala, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtNomeSala, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblLotacaoSala, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtLotacaoSala, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtCadastrarSala)
                    .addComponent(BtSairSala))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtSairSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSairSalaActionPerformed
        dispose();
    }//GEN-LAST:event_BtSairSalaActionPerformed

    private void BtCadastrarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCadastrarSalaActionPerformed
        adicionar();
    }//GEN-LAST:event_BtCadastrarSalaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCadastrarSala;
    private javax.swing.JButton BtSairSala;
    private javax.swing.JLabel jLblLotacaoSala;
    private javax.swing.JLabel jLblNomeSala;
    private javax.swing.JTextField jTxtLotacaoSala;
    private javax.swing.JTextField jTxtNomeSala;
    // End of variables declaration//GEN-END:variables
}
