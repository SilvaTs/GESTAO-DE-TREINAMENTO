package br.com.daniel.gui;

import br.com.daniel.dao.SalaDAO;
import static br.com.daniel.dao.UsuarioDAO.rss;
import br.com.daniel.model.EspacoCafe;
import br.com.daniel.model.Sala;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Daniel
 */
public class GUIConsultarSalaOuEspacoCafe extends javax.swing.JInternalFrame {

    private EspacoCafe espacoCafe;
    private Sala sala;
    private SalaDAO salaDAO;

    PreparedStatement pst = null;
    ResultSet rs = null;

    public GUIConsultarSalaOuEspacoCafe() {
        initComponents();
    }

    private void pesquisarUsuariosPorSalaouEspacoCafe() {

        try {
            salaDAO = new SalaDAO();
            sala = new Sala();
            espacoCafe = new EspacoCafe();
            sala.setNome(jTxtPesquisarSalaOuEspacoCafe.getText());
            espacoCafe.setDescricao(jTxtPesquisarSalaOuEspacoCafe.getText());
          
            if (jTxtPesquisarSalaOuEspacoCafe.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Digite Nome da Sala ou do Espaço Café");

            } else {

                salaDAO.buscarSalaOuEspacoCafe(sala, espacoCafe);

                jTblTreinamento.setModel(DbUtils.resultSetToTableModel(rss));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTblTreinamento = new javax.swing.JTable();
        jTxtPesquisarSalaOuEspacoCafe = new javax.swing.JTextField();
        BtBuscarSalaOuEspacoCafe = new javax.swing.JButton();

        setClosable(true);
        setTitle("Tela de Cosultar Por Sala ou Espaço Café");

        jTblTreinamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pessoas"
            }
        ));
        jTblTreinamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblTreinamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblTreinamento);

        BtBuscarSalaOuEspacoCafe.setText("BUSCAR");
        BtBuscarSalaOuEspacoCafe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarSalaOuEspacoCafeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTxtPesquisarSalaOuEspacoCafe, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtBuscarSalaOuEspacoCafe))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTxtPesquisarSalaOuEspacoCafe, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtBuscarSalaOuEspacoCafe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTblTreinamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblTreinamentoMouseClicked

    }//GEN-LAST:event_jTblTreinamentoMouseClicked

    private void BtBuscarSalaOuEspacoCafeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarSalaOuEspacoCafeActionPerformed
        pesquisarUsuariosPorSalaouEspacoCafe();
    }//GEN-LAST:event_BtBuscarSalaOuEspacoCafeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscarSalaOuEspacoCafe;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTblTreinamento;
    private javax.swing.JTextField jTxtPesquisarSalaOuEspacoCafe;
    // End of variables declaration//GEN-END:variables
}
