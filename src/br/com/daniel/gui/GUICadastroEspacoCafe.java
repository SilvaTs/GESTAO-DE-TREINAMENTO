package br.com.daniel.gui;

import br.com.daniel.dao.EspacoCafeDAO;
import br.com.daniel.model.EspacoCafe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class GUICadastroEspacoCafe extends javax.swing.JInternalFrame {

    private EspacoCafe espacoCafe;
    private EspacoCafeDAO espacoCafeDAO;

    PreparedStatement pst = null;
    ResultSet rs = null;

    public GUICadastroEspacoCafe() {
        initComponents();
    }

    private void adicionar() {

        try {

            espacoCafe = new EspacoCafe();

            if ((jTxtNomeEspacoCafe.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Preencha o campo nome");
                jTxtNomeEspacoCafe.requestFocus();
            } else if ((jTxtLotacaoEspacoCafe.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Preencha o campo lotação");
                jTxtLotacaoEspacoCafe.requestFocus();

            } else {
                int quantidade = Integer.parseInt(jTxtLotacaoEspacoCafe.getText());
                espacoCafe.setDescricao(jTxtNomeEspacoCafe.getText());
                espacoCafe.setLotacao(quantidade);

                espacoCafeDAO = new EspacoCafeDAO();
                espacoCafeDAO.salvar(espacoCafe);
                JOptionPane.showMessageDialog(null, "Espaço Café Inserida Com Sucesso!");

                limpaCampo();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void limpaCampo() {
        jTxtNomeEspacoCafe.setText("");
        jTxtLotacaoEspacoCafe.setText("");
        jTxtNomeEspacoCafe.requestFocus();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblNomeEspacoCafe = new javax.swing.JLabel();
        jTxtNomeEspacoCafe = new javax.swing.JTextField();
        jLblLotacaoEspacoCafe = new javax.swing.JLabel();
        jTxtLotacaoEspacoCafe = new javax.swing.JTextField();
        BtCadastrarEspacoCafe = new javax.swing.JButton();
        BtSairEspacoCafe = new javax.swing.JButton();

        setClosable(true);
        setTitle("Tela de Cadastro Espaço Café");

        jLblNomeEspacoCafe.setText("NOME");

        jLblLotacaoEspacoCafe.setText("LOTAÇÃO");

        BtCadastrarEspacoCafe.setText("CADASTRAR");
        BtCadastrarEspacoCafe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCadastrarEspacoCafeActionPerformed(evt);
            }
        });

        BtSairEspacoCafe.setText("SAIR");
        BtSairEspacoCafe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSairEspacoCafeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(BtCadastrarEspacoCafe)
                .addGap(18, 18, 18)
                .addComponent(BtSairEspacoCafe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLblLotacaoEspacoCafe)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLblNomeEspacoCafe)
                                .addGap(301, 301, 301))
                            .addComponent(jTxtNomeEspacoCafe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTxtLotacaoEspacoCafe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLblNomeEspacoCafe, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTxtNomeEspacoCafe, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblLotacaoEspacoCafe, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtLotacaoEspacoCafe, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtCadastrarEspacoCafe)
                    .addComponent(BtSairEspacoCafe))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtSairEspacoCafeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSairEspacoCafeActionPerformed
        dispose();
    }//GEN-LAST:event_BtSairEspacoCafeActionPerformed

    private void BtCadastrarEspacoCafeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCadastrarEspacoCafeActionPerformed
        adicionar();
    }//GEN-LAST:event_BtCadastrarEspacoCafeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCadastrarEspacoCafe;
    private javax.swing.JButton BtSairEspacoCafe;
    private javax.swing.JLabel jLblLotacaoEspacoCafe;
    private javax.swing.JLabel jLblNomeEspacoCafe;
    private javax.swing.JTextField jTxtLotacaoEspacoCafe;
    private javax.swing.JTextField jTxtNomeEspacoCafe;
    // End of variables declaration//GEN-END:variables

}
