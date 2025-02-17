package br.com.daniel.gui;

import br.com.daniel.dao.EspacoCafeDAO;
import br.com.daniel.dao.EventoDAO;
import br.com.daniel.dao.SalaDAO;
import br.com.daniel.dao.UsuarioDAO;
import static br.com.daniel.dao.UsuarioDAO.rss;
import static br.com.daniel.gui.GUIConsultarUsuario.jTblTreinamento;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Daniel
 */
public class GUICadastroTreinamento extends javax.swing.JInternalFrame {

    private final DefaultTableModel modelTable = new DefaultTableModel();
    ;
    private JTable table = new JTable(modelTable);
    private Evento evento;
    private EventoDAO eventoDAO;
    private EspacoCafe espacoCafe;
    private Usuario usuario;
    private Sala sala;
    private UsuarioDAO usuarioDAO;
    private List<EspacoCafe> listarEspacoCafe;
    private List<Usuario> listarUsuarios;
    private List<Sala> listarSalas;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public GUICadastroTreinamento() {
        initComponents();
    }

    public static boolean isHoraValida(String horaParaValidacao) {
        boolean isHoraValida = false;

        Pattern pattern = Pattern.compile("([01][0-9]|2[0-3]):[0-5][0-9]");
        Matcher matcher = pattern.matcher(horaParaValidacao);
        isHoraValida = matcher.matches();

        return isHoraValida;
    }

    private void adicionar() {

        try {

            if (jTxtIntervaloTreinamento.getText().contentEquals("  :  ")) {
                JOptionPane.showMessageDialog(null, "Informe a Hora");
                jTxtIntervaloTreinamento.requestFocus();
            } else if (JCBEspacoCafe.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Não Contém Nenhum Espaço Café Cadastrado");
            } else if (JCBUsuario.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Não Contém Nenhum Usuário Cadastrado");
            } else if (JCBSala.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Não Contém Nenhuma Sala Cadastrada");
            } else {
                espacoCafe = new EspacoCafe();
                usuario = new Usuario();
                sala = new Sala();
                evento = new Evento();

                evento.setIntervalo(jTxtIntervaloTreinamento.getText());

                int etapa = Integer.parseInt((String) JCBEtapa.getSelectedItem());
                evento.setEtapa(etapa);

                int posicaoEspacoCafe = JCBEspacoCafe.getSelectedIndex();
                EspacoCafe espacoCafe = listarEspacoCafe.get(posicaoEspacoCafe);
                evento.setEspacoCafe(espacoCafe);

                int posicaoUsario = JCBUsuario.getSelectedIndex();
                Usuario usuario = listarUsuarios.get(posicaoUsario);
                evento.setUsuario(usuario);

                int posicaoSala = JCBSala.getSelectedIndex();
                Sala sala = listarSalas.get(posicaoSala);
                evento.setSala(sala);

                eventoDAO = new EventoDAO();
                eventoDAO.salvar(evento);
                JOptionPane.showMessageDialog(null, "Cadastro Inserido com Sucesso!");
                pesquisarUsuarios();
                limpaCampo();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void alterar() {
        try {

            if (jTxtIntervaloTreinamento.getText().contentEquals("  :  ")) {
                JOptionPane.showMessageDialog(null, "Informe a Hora");
                jTxtIntervaloTreinamento.requestFocus();
            } else if (JCBEspacoCafe.getSelectedItem() == null || JCBUsuario.getSelectedItem() == null
                    || JCBSala.getSelectedItem() == null) {

            } else {
                espacoCafe = new EspacoCafe();
                usuario = new Usuario();
                sala = new Sala();
                evento = new Evento();

                evento.setIntervalo(jTxtIntervaloTreinamento.getText());

                int etapa = Integer.parseInt((String) JCBEtapa.getSelectedItem());
                evento.setEtapa(etapa);

                int posicaoEspacoCafe = JCBEspacoCafe.getSelectedIndex();
                EspacoCafe espacoCafe = listarEspacoCafe.get(posicaoEspacoCafe);
                evento.setEspacoCafe(espacoCafe);

                int posicaoUsario = JCBUsuario.getSelectedIndex();
                Usuario usuario = listarUsuarios.get(posicaoUsario);
                evento.setUsuario(usuario);

                int posicaoSala = JCBSala.getSelectedIndex();
                Sala sala = listarSalas.get(posicaoSala);
                evento.setSala(sala);

                int id = Integer.parseInt(jTxtIdTreinamento.getText());
                evento.setId(id);
                eventoDAO = new EventoDAO();
                eventoDAO.alterar(evento);

                JOptionPane.showMessageDialog(null, "Atualizado com sucesso! ");
                pesquisarUsuarios();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void pesquisarUsuarios() {

        try {
            eventoDAO = new EventoDAO();
            usuario = new Usuario();
            usuario.setNome(jTxtPesquisarUsuarios.getText());
            if (jTxtPesquisarUsuarios.getText().isEmpty()) {

                atualizaTabela();
            } else {

                eventoDAO.buscarEventoPorNomeDoUsuario(usuario);

                jTblTreinamento.setModel(DbUtils.resultSetToTableModel(rss));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void atualizaTabela() {

        buscarEventos();
        DefaultTableModel tmp = modelTable;
        tmp.getDataVector().removeAllElements();
        tmp.fireTableDataChanged();
        table.repaint();

    }

    private void buscarEventos() {

        try {

            eventoDAO = new EventoDAO();
            eventoDAO.getTodosEventos();
            jTblTreinamento.setModel(DbUtils.resultSetToTableModel(rss));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void setar_campos() {

        int setar = jTblTreinamento.getSelectedRow();
        jTxtIdTreinamento.setText(jTblTreinamento.getModel().getValueAt(setar, 0).toString());
        jTxtIntervaloTreinamento.setText(jTblTreinamento.getModel().getValueAt(setar, 1).toString());

        int colunaEtapa = 2;
        String etapaSelecionado = jTblTreinamento.getModel().getValueAt(setar, colunaEtapa).toString();
        JCBEtapa.setSelectedItem(etapaSelecionado);

        int colunaEspacoCafe = 3;
        String espacoCafeSelecionado = jTblTreinamento.getModel().getValueAt(setar, colunaEspacoCafe).toString();
        JCBEspacoCafe.setSelectedItem(espacoCafeSelecionado);

        int colunaUsuario = 4;
        String usuarioSelecionado = jTblTreinamento.getModel().getValueAt(setar, colunaUsuario).toString();
        JCBUsuario.setSelectedItem(usuarioSelecionado);

        int colunaSala = 5;
        String salaSelecionado = jTblTreinamento.getModel().getValueAt(setar, colunaSala).toString();
        JCBSala.setSelectedItem(salaSelecionado);

        //a linha abaixo desabilita o botão adicionar
        jTxtIdTreinamento.setEnabled(false);
        jTxtIntervaloTreinamento.setEnabled(false);
        JCBEtapa.setEnabled(false);
        JCBEspacoCafe.setEnabled(false);
        JCBUsuario.setEnabled(false);

        BtCadastrarTreinamento.setEnabled(false);

    }

    private void limpaCampo() {
        jTxtIntervaloTreinamento.setText("");

        jTxtIntervaloTreinamento.requestFocus();
    }

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
        JCBEtapa = new javax.swing.JComboBox();
        JCBUsuario = new javax.swing.JComboBox();
        JCBEspacoCafe = new javax.swing.JComboBox();
        JCBSala = new javax.swing.JComboBox();
        BtSairSalaTreinamento = new javax.swing.JButton();
        BtAtualizarTreinamento = new javax.swing.JButton();
        BtCadastrarTreinamento = new javax.swing.JButton();
        jTxtIntervaloTreinamento = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Tela  Cadastro de Treinamento");

        BtBuscar.setText("BUSCAR");
        BtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarActionPerformed(evt);
            }
        });

        jTblTreinamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "IdEvento", "Intervalo", "Etapa", "Espaço ", "Pessoas", "Sala"
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
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JCBUsuarioAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        JCBEspacoCafe.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JCBEspacoCafeAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        JCBSala.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JCBSalaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        BtSairSalaTreinamento.setText("SAIR");
        BtSairSalaTreinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSairSalaTreinamentoActionPerformed(evt);
            }
        });

        BtAtualizarTreinamento.setText("ATUALIZAR");
        BtAtualizarTreinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAtualizarTreinamentoActionPerformed(evt);
            }
        });

        BtCadastrarTreinamento.setText("CADASTRAR");
        BtCadastrarTreinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCadastrarTreinamentoActionPerformed(evt);
            }
        });

        try {
            jTxtIntervaloTreinamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTxtIntervaloTreinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtIntervaloTreinamentoActionPerformed(evt);
            }
        });

        jLabel1.setText("NOME DA PESSOA :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLblEnderecoCliente)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtCadastrarTreinamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtAtualizarTreinamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtSairSalaTreinamento))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtPesquisarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLblTelefoneCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLblEmailCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                            .addComponent(jLabel4)
                            .addComponent(jLblNomeCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JCBSala, 0, 173, Short.MAX_VALUE)
                            .addComponent(JCBUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCBEtapa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCBEspacoCafe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTxtIntervaloTreinamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                .addComponent(jTxtIdTreinamento, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxtPesquisarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtIdTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLblNomeCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTxtIntervaloTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTblTreinamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblTreinamentoMouseClicked
        setar_campos();
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
        try {

            if (isHoraValida(jTxtIntervaloTreinamento.getText().toString()) == true) {

                adicionar();

            } else {

                JOptionPane.showMessageDialog(null, "HORA INVÁLIDA");

            }

        } catch (Exception e) {
            e.printStackTrace();

        }


    }//GEN-LAST:event_BtCadastrarTreinamentoActionPerformed

    private void jTxtIntervaloTreinamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtIntervaloTreinamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtIntervaloTreinamentoActionPerformed

    private void BtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarActionPerformed
        pesquisarUsuarios();
    }//GEN-LAST:event_BtBuscarActionPerformed

    private void BtAtualizarTreinamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAtualizarTreinamentoActionPerformed
        alterar();
    }//GEN-LAST:event_BtAtualizarTreinamentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAtualizarTreinamento;
    private javax.swing.JButton BtBuscar;
    private javax.swing.JButton BtCadastrarTreinamento;
    private javax.swing.JButton BtSairSalaTreinamento;
    private javax.swing.JComboBox JCBEspacoCafe;
    private javax.swing.JComboBox JCBEtapa;
    private javax.swing.JComboBox JCBSala;
    private javax.swing.JComboBox JCBUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLblEmailCliente;
    private javax.swing.JLabel jLblEnderecoCliente;
    private javax.swing.JLabel jLblNomeCliente;
    private javax.swing.JLabel jLblTelefoneCliente;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTblTreinamento;
    private javax.swing.JTextField jTxtIdTreinamento;
    private javax.swing.JFormattedTextField jTxtIntervaloTreinamento;
    private javax.swing.JTextField jTxtPesquisarUsuarios;
    // End of variables declaration//GEN-END:variables
}
