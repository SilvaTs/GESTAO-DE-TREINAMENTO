package br.com.daniel.gui;

import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * @author Daniel
 */
public class GUITelaPrincipal extends javax.swing.JFrame {

    public GUITelaPrincipal() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);

    }

    private void centralizaForm(JInternalFrame frame) {
        Dimension desktopSize = areaTrabalho.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        areaTrabalho = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuCadastroUsuario = new javax.swing.JMenuItem();
        MenuCadastroSala = new javax.swing.JMenuItem();
        MenuCadastroEspacoCafe = new javax.swing.JMenuItem();
        MenuCadastroTreinamento = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestão de Treinamento V1.0.0");

        javax.swing.GroupLayout areaTrabalhoLayout = new javax.swing.GroupLayout(areaTrabalho);
        areaTrabalho.setLayout(areaTrabalhoLayout);
        areaTrabalhoLayout.setHorizontalGroup(
            areaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );
        areaTrabalhoLayout.setVerticalGroup(
            areaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );

        jMenu1.setText("CADASTRO");

        MenuCadastroUsuario.setText("Cadastrar Usuário");
        MenuCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(MenuCadastroUsuario);

        MenuCadastroSala.setText("Cadastrar Sala do Evento");
        MenuCadastroSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroSalaActionPerformed(evt);
            }
        });
        jMenu1.add(MenuCadastroSala);

        MenuCadastroEspacoCafe.setText("Cadastrar ESPAÇO CAFÉ");
        MenuCadastroEspacoCafe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroEspacoCafeActionPerformed(evt);
            }
        });
        jMenu1.add(MenuCadastroEspacoCafe);

        MenuCadastroTreinamento.setText("Cadastrar Treinamento");
        MenuCadastroTreinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroTreinamentoActionPerformed(evt);
            }
        });
        jMenu1.add(MenuCadastroTreinamento);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("CONSULTA");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaTrabalho)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaTrabalho)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroUsuarioActionPerformed
        GUICadastroUsuario frame = new GUICadastroUsuario();
        centralizaForm(frame);
        frame.setVisible(true);
        areaTrabalho.add(frame);
    }//GEN-LAST:event_MenuCadastroUsuarioActionPerformed

    private void MenuCadastroSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroSalaActionPerformed
        GUICadastroSala frame = new GUICadastroSala();
        centralizaForm(frame);
        frame.setVisible(true);
        areaTrabalho.add(frame);
    }//GEN-LAST:event_MenuCadastroSalaActionPerformed

    private void MenuCadastroEspacoCafeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroEspacoCafeActionPerformed
        GUICadastroEspacoCafe frame = new GUICadastroEspacoCafe();
        centralizaForm(frame);
        frame.setVisible(true);
        areaTrabalho.add(frame);
    }//GEN-LAST:event_MenuCadastroEspacoCafeActionPerformed

    private void MenuCadastroTreinamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroTreinamentoActionPerformed
        GUICadastroTreinamento frame = new GUICadastroTreinamento();
        centralizaForm(frame);
        frame.setVisible(true);
        areaTrabalho.add(frame);
    }//GEN-LAST:event_MenuCadastroTreinamentoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUITelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUITelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUITelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUITelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUITelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuCadastroEspacoCafe;
    private javax.swing.JMenuItem MenuCadastroSala;
    private javax.swing.JMenuItem MenuCadastroTreinamento;
    private javax.swing.JMenuItem MenuCadastroUsuario;
    public static javax.swing.JDesktopPane areaTrabalho;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
