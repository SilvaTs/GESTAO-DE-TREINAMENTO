/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.daniel.gui;

/**
 *
 * @author Daniel
 */
public class GUICadastroUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUICadastroUsuario
     */
    public GUICadastroUsuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtNomeUsuario = new javax.swing.JTextField();
        jTxtSobreNomeUsuario = new javax.swing.JTextField();
        BtSairUsuario = new javax.swing.JButton();
        BtCadastrarUsuario = new javax.swing.JButton();
        jLblSobreNomeUsuario = new javax.swing.JLabel();
        jLblNomeUsuario = new javax.swing.JLabel();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("CADASTRO DE USUÁRIOS");

        BtSairUsuario.setText("SAIR");
        BtSairUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSairUsuarioActionPerformed(evt);
            }
        });

        BtCadastrarUsuario.setText("CADASTRAR");

        jLblSobreNomeUsuario.setText("SOBRE NOME");

        jLblNomeUsuario.setText("NOME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(BtCadastrarUsuario)
                                    .addGap(18, 18, 18)
                                    .addComponent(BtSairUsuario))
                                .addComponent(jTxtNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                                .addComponent(jTxtSobreNomeUsuario))
                            .addComponent(jLblNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblSobreNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jLblNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblSobreNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jTxtSobreNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtCadastrarUsuario)
                    .addComponent(BtSairUsuario))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtSairUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSairUsuarioActionPerformed
       dispose();
    }//GEN-LAST:event_BtSairUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCadastrarUsuario;
    private javax.swing.JButton BtSairUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblNomeUsuario;
    private javax.swing.JLabel jLblSobreNomeUsuario;
    private javax.swing.JTextField jTxtNomeUsuario;
    private javax.swing.JTextField jTxtSobreNomeUsuario;
    // End of variables declaration//GEN-END:variables
}
