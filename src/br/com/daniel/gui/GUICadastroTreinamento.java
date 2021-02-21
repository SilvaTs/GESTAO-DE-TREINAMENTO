package br.com.daniel.gui;

import br.com.daniel.dao.EspacoCafeDAO;
import br.com.daniel.dao.EventoDAO;
import br.com.daniel.dao.SalaDAO;
import br.com.daniel.dao.UsuarioDAO;
import br.com.daniel.model.EspacoCafe;
import br.com.daniel.model.Evento;
import br.com.daniel.model.Sala;
import br.com.daniel.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class GUICadastroTreinamento extends javax.swing.JInternalFrame {

    // private final DefaultTableModel modelTable = new DefaultTableModel();
    //private JTable table = new JTable(modelTable);
    private Evento objEvento;
    private EventoDAO objDAO;
    private EspacoCafe espacoCafe;
    private Usuario usuario;
    private Sala sala;
    private List<EspacoCafe> listarEspacoCafe;
    private List<Usuario> listarUsuarios;
    private List<Sala> listarSalas;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public GUICadastroTreinamento() {
        initComponents();
    }

    private void adicionar() {

        try {

//        if ((jTxtFabricante.getText().isEmpty()) || (jTxtModelo.getText().isEmpty()) || (jTxtDescricao.getText().isEmpty()) 
//                || (jTxtQuantidade.getText().isEmpty() || (jTxtValorUnit.getText().isEmpty()))) {
//            JOptionPane.showMessageDialog(null, "Informe valores para os campos");
//        } else {
            espacoCafe = new EspacoCafe();
            usuario = new Usuario();
            sala = new Sala();
            objEvento = new Evento();

            objEvento.setIntervalo(jTxtIntervaloTreinamento.getText());

            int etapa = Integer.parseInt((String) JCBEtapa.getSelectedItem());
            objEvento.setEtapa(etapa);

            int posicaoEspacoCafe = JCBEspacoCafe.getSelectedIndex();
            EspacoCafe espacoCafe = listarEspacoCafe.get(posicaoEspacoCafe);
            objEvento.setEspacoCafe(espacoCafe);

            int posicaoUsario = JCBUsuario.getSelectedIndex();
            Usuario usuario = listarUsuarios.get(posicaoUsario);
            objEvento.setUsuario(usuario);

            int posicaoSala = JCBUsuario.getSelectedIndex();
            Sala sala = listarSalas.get(posicaoSala);
            objEvento.setSala(sala);

            objDAO = new EventoDAO();
            objDAO.salvar(objEvento);
            JOptionPane.showMessageDialog(null, "Cadastro Inserido com Sucesso!");

            limpaCampo();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void limpaCampo() {
        jTxtIntervaloTreinamento.setText("");

        jTxtIntervaloTreinamento.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtPesquisarUsuarios = new javax.swing.JTextField();
        BtBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblTreinamento = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLblNomeCliente = new javax.swing.JLabel();
        jLblEnderecoCliente = new javax.swing.JLabel();
        jLblTelefoneCliente = new javax.swing.JLabel();
        jLblEmailCliente = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtIdTreinamento = new javax.swing.JTextField();
        jTxtIntervaloTreinamento = new javax.swing.JTextField();
        JCBEtapa = new javax.swing.JComboBox();
        JCBUsuario = new javax.swing.JComboBox();
        JCBEspacoCafe = new javax.swing.JComboBox();
        JCBSala = new javax.swing.JComboBox();
        BtSairSalaTreinamento = new javax.swing.JButton();
        BtAtualizarTreinamento = new javax.swing.JButton();
        BtCadastrarTreinamento = new javax.swing.JButton();

        setClosable(true);

        BtBuscar.setText("BUSCAR");

        jTblTreinamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Intervalo", "Etapa", "Espaço do Café", "Usuário", "Sala"
            }
        ));
        jTblTreinamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblTreinamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblTreinamento);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText(" ID ");

        jLblNomeCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLblNomeCliente.setText("Intervalo");

        jLblEnderecoCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLblEnderecoCliente.setText("Etapa");

        jLblTelefoneCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLblTelefoneCliente.setText("Espaço do Café");

        jLblEmailCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLblEmailCliente.setText("Usuário");

        jLabel4.setText("Sala");

        jTxtIdTreinamento.setEnabled(false);

        JCBEtapa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", " " }));

        JCBUsuario.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JCBUsuarioAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        JCBEspacoCafe.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JCBEspacoCafeAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        JCBSala.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JCBSalaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        BtSairSalaTreinamento.setText("SAIR");
        BtSairSalaTreinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSairSalaTreinamentoActionPerformed(evt);
            }
        });

        BtAtualizarTreinamento.setText("ATUALIZAR");

        BtCadastrarTreinamento.setText("CADASTRAR");
        BtCadastrarTreinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCadastrarTreinamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLblNomeCliente)
                    .addComponent(jLblEnderecoCliente)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLblTelefoneCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLblEmailCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JCBSala, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCBEspacoCafe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTxtIdTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCBEtapa, 0, 295, Short.MAX_VALUE)
                            .addComponent(jTxtIntervaloTreinamento)
                            .addComponent(JCBUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtCadastrarTreinamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtAtualizarTreinamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtSairSalaTreinamento))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jTxtPesquisarUsuarios)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(BtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtPesquisarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtIdTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtIntervaloTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblNomeCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblEnderecoCliente)
                    .addComponent(JCBEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblTelefoneCliente)
                    .addComponent(JCBEspacoCafe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblEmailCliente)
                    .addComponent(JCBUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCBSala, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtAtualizarTreinamento)
                    .addComponent(BtSairSalaTreinamento)
                    .addComponent(BtCadastrarTreinamento))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTblTreinamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblTreinamentoMouseClicked
        //setar_campos();
    }//GEN-LAST:event_jTblTreinamentoMouseClicked

    private void BtSairSalaTreinamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSairSalaTreinamentoActionPerformed
        dispose();
    }//GEN-LAST:event_BtSairSalaTreinamentoActionPerformed

    private void JCBEspacoCafeAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_JCBEspacoCafeAncestorAdded
        EspacoCafeDAO espacoCafeDAO = null;
        try {
            espacoCafeDAO = new EspacoCafeDAO();
        } catch (SQLException ex) {
            Logger.getLogger(GUICadastroTreinamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        listarEspacoCafe = espacoCafeDAO.buscarTodosEspacoCafe();
        JCBEspacoCafe.removeAll();

        for (EspacoCafe espacoCafe : listarEspacoCafe) {
            JCBEspacoCafe.addItem(espacoCafe.getDescricao());
        }
    }//GEN-LAST:event_JCBEspacoCafeAncestorAdded

    private void JCBUsuarioAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_JCBUsuarioAncestorAdded
        UsuarioDAO usuarioDAO = null;
        try {
            usuarioDAO = new UsuarioDAO();
        } catch (SQLException ex) {
            Logger.getLogger(GUICadastroTreinamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        listarUsuarios = usuarioDAO.buscarTodosUsuarios();
        JCBUsuario.removeAll();

        for (Usuario usuario : listarUsuarios) {
            JCBUsuario.addItem(usuario.getNome());
        }
    }//GEN-LAST:event_JCBUsuarioAncestorAdded

    private void JCBSalaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_JCBSalaAncestorAdded
        SalaDAO salaDAO = null;
        try {
            salaDAO = new SalaDAO();
        } catch (SQLException ex) {
            Logger.getLogger(GUICadastroTreinamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        listarSalas = salaDAO.buscarTodasSalas();
        JCBSala.removeAll();

        for (Sala sala : listarSalas) {
            JCBSala.addItem(sala.getNome());
        }
    }//GEN-LAST:event_JCBSalaAncestorAdded

    private void BtCadastrarTreinamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCadastrarTreinamentoActionPerformed
        adicionar();
    }//GEN-LAST:event_BtCadastrarTreinamentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAtualizarTreinamento;
    private javax.swing.JButton BtBuscar;
    private javax.swing.JButton BtCadastrarTreinamento;
    private javax.swing.JButton BtSairSalaTreinamento;
    private javax.swing.JComboBox JCBEspacoCafe;
    private javax.swing.JComboBox JCBEtapa;
    private javax.swing.JComboBox JCBSala;
    private javax.swing.JComboBox JCBUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLblEmailCliente;
    private javax.swing.JLabel jLblEnderecoCliente;
    private javax.swing.JLabel jLblNomeCliente;
    private javax.swing.JLabel jLblTelefoneCliente;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTblTreinamento;
    private javax.swing.JTextField jTxtIdTreinamento;
    private javax.swing.JTextField jTxtIntervaloTreinamento;
    private javax.swing.JTextField jTxtPesquisarUsuarios;
    // End of variables declaration//GEN-END:variables
}
