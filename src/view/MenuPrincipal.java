package view;

import controller.MenuPrincipalController;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {

    private final MenuPrincipalController controller;

    //Instânciar Objetos
    
    public MenuPrincipal() {
        initComponents();
        this.controller = new MenuPrincipalController(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSair = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        MenuItemClientes = new javax.swing.JMenuItem();
        MenuItemServico = new javax.swing.JMenuItem();
        MenuItemAtualizar = new javax.swing.JMenuItem();
        jMenuOperacao = new javax.swing.JMenu();
        jMenuItemAgenda = new javax.swing.JMenuItem();
        jMenuConfiguracoes = new javax.swing.JMenu();
        jMenuItemUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSair.setText("Sair do Sistema");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 150, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/janela usuário.jpeg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuCadastro.setLabel("Cadastro");

        MenuItemClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/cliente icon.png"))); // NOI18N
        MenuItemClientes.setText("Clientes");
        MenuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemClientesActionPerformed(evt);
            }
        });
        jMenuCadastro.add(MenuItemClientes);

        MenuItemServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/serviço icon.png"))); // NOI18N
        MenuItemServico.setText("Serviço");
        MenuItemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemServicoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(MenuItemServico);

        MenuItemAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/atualizar icon.png"))); // NOI18N
        MenuItemAtualizar.setText("Atualizar");
        MenuItemAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemAtualizarActionPerformed(evt);
            }
        });
        jMenuCadastro.add(MenuItemAtualizar);

        jMenuBar1.add(jMenuCadastro);

        jMenuOperacao.setLabel("Operação");

        jMenuItemAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/agenda icon.png"))); // NOI18N
        jMenuItemAgenda.setText("Agenda");
        jMenuItemAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgendaActionPerformed(evt);
            }
        });
        jMenuOperacao.add(jMenuItemAgenda);

        jMenuBar1.add(jMenuOperacao);

        jMenuConfiguracoes.setText("Configurações");

        jMenuItemUsuario.setText("Editar Usuário");
        jMenuItemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuarioActionPerformed(evt);
            }
        });
        jMenuConfiguracoes.add(jMenuItemUsuario);

        jMenuBar1.add(jMenuConfiguracoes);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Sair
    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "Deseja Sair da Conta?");
        if (resp == 0) {
            JOptionPane.showMessageDialog(null, "Conta Encerrada");
            this.dispose();
        }
    }//GEN-LAST:event_btnSairActionPerformed

    //Operação - Agenda
    private void jMenuItemAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgendaActionPerformed
        this.controller.navegarParaAgenda();
        this.dispose();
    }//GEN-LAST:event_jMenuItemAgendaActionPerformed

    //Cadastro - Clientes
    private void MenuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuItemClientesActionPerformed

    //Cadastro - Serviço
    private void MenuItemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuItemServicoActionPerformed

    //Cadastro - Atualizar
    private void MenuItemAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemAtualizarActionPerformed
        this.controller.navegarParaAtualizar();
    }//GEN-LAST:event_MenuItemAtualizarActionPerformed

    //Configurações - Editar Usuário
    private void jMenuItemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuarioActionPerformed
        EditaUsuario editaUsuario = new EditaUsuario();
        editaUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItemUsuarioActionPerformed
private void jMenuItemConfigActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Implement configuration handling code
        JOptionPane.showMessageDialog(null, "Configurações serão implementadas aqui.");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuItemAtualizar;
    private javax.swing.JMenuItem MenuItemClientes;
    private javax.swing.JMenuItem MenuItemServico;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuConfiguracoes;
    private javax.swing.JMenuItem jMenuItemAgenda;
    private javax.swing.JMenuItem jMenuItemUsuario;
    private javax.swing.JMenu jMenuOperacao;
    // End of variables declaration//GEN-END:variables

    //Métodos Auxiliares
    
    

}
