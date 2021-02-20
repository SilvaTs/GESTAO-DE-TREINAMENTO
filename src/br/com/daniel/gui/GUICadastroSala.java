
package br.com.daniel.gui;
    

import br.com.daniel.dao.SalaDAO;
import br.com.daniel.dao.UsuarioDAO;
import br.com.daniel.model.Sala;
import br.com.daniel.model.Usuario;
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
       
       try{
           
        sala = new Sala();                     
       
        if ((jTxtNomeSala.getText().isEmpty()) ) {
            
            JOptionPane.showMessageDialog(null, "Preencha o campo nome");
        }
        else if((jTxtLotacaoSala.getText().isEmpty())){
            
         JOptionPane.showMessageDialog(null, "Preencha o campo lotação");
        
        }
        else {
                              
                sala.setNome(jTxtNomeSala.getText());
                sala.setLotacao(jTxtLotacaoSala.getText());
                
                 salaDAO = new SalaDAO();
                salaDAO.salvar(sala);
                JOptionPane.showMessageDialog(null, "Sala inserida com sucesso! ");

                limpaCampo();
        }
        
       }catch(Exception e) {
        JOptionPane.showMessageDialog(null, e);
       }
    }
   
   private void limpaCampo() {
    jTxtNomeSala.setText("");
    jTxtLotacaoSala.setText("");   
    jTxtNomeSala.requestFocus();
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
        jLblNomeSala = new javax.swing.JLabel();
        jLblLotacaoSala = new javax.swing.JLabel();
        jTxtNomeSala = new javax.swing.JTextField();
        jTxtLotacaoSala = new javax.swing.JTextField();
        BtCadastrarSala = new javax.swing.JButton();
        BtSairSala = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("CADASTRO DE SALAS");

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
                            .addComponent(jTxtLotacaoSala)
                            .addComponent(jLblNomeSala, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(BtCadastrarSala)
                                .addGap(18, 18, 18)
                                .addComponent(BtSairSala))
                            .addComponent(jTxtNomeSala, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(37, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jLblNomeSala, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtNomeSala, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLblLotacaoSala, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTxtLotacaoSala, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtCadastrarSala)
                    .addComponent(BtSairSala))
                .addGap(40, 40, 40))
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblLotacaoSala;
    private javax.swing.JLabel jLblNomeSala;
    private javax.swing.JTextField jTxtLotacaoSala;
    private javax.swing.JTextField jTxtNomeSala;
    // End of variables declaration//GEN-END:variables
}
