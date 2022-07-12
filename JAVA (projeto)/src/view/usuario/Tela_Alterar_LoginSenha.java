/**/
package view.usuario;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import model.bean.Usuario;
import model.dao.UsuarioDAO;
import view.Tela_Principal;
import view._util.*;

public class Tela_Alterar_LoginSenha extends javax.swing.JDialog {

    private Usuario userLogado = null;
    private String spc = "   "; // espaço para o label da barra de status

//    public Usuario getUserLogado() {
//        return userLogado;
//    }
    public Tela_Alterar_LoginSenha(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setIcones();
        setNames();

        Tools_Buttons.configButtons(pnBotao, 2);
        Tools_Buttons.setActionButtons(pnBotao);
        Tools_SetIcon.setIcon(this, "/view/_images/24/usuario_alterarLoginSenha_Gnd_24.png");
        Tools_SetFundoPainel.carregaImagem(pnFundo, "/view/_images/geral/fundo_telas.jpg");
        

        loadUser(); // carrega informações do usuario

    }

//==============================================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFundo = new javax.swing.JPanel();
        pnCampos = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lbLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lbSenhaAtual = new javax.swing.JLabel();
        txtSenhaAtual = new javax.swing.JPasswordField();
        lbNovaSenha = new javax.swing.JLabel();
        txtNovaSenha = new javax.swing.JPasswordField();
        lbConfNvSenha = new javax.swing.JLabel();
        txtConfNvSenha = new javax.swing.JPasswordField();
        pnBotao = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        pnStatusBar = new javax.swing.JPanel();
        lbStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alteração de Login / Senha");
        setResizable(false);

        pnFundo.setOpaque(false);

        pnCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnCampos.setOpaque(false);

        lbCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodigo.setText("Código");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setToolTipText("Código do usuário.");
        txtCodigo.setName("Código"); // NOI18N

        lbLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbLogin.setText("Login");

        txtLogin.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtLogin.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtLogin.setToolTipText("<html>\n<p>Informar um novo login ou o atual.\n<html/>");
        txtLogin.setName("Login"); // NOI18N
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginKeyPressed(evt);
            }
        });

        lbSenhaAtual.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSenhaAtual.setText("Senha Atual");

        txtSenhaAtual.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtSenhaAtual.setToolTipText("<html>\n<p>Informar a senha antiga.\n<html/>");
        txtSenhaAtual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaAtualKeyPressed(evt);
            }
        });

        lbNovaSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNovaSenha.setText("Nova Senha");

        txtNovaSenha.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtNovaSenha.setToolTipText("<html>\n<p>Informar uma nova senha.\n<html/>");
        txtNovaSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNovaSenhaKeyPressed(evt);
            }
        });

        lbConfNvSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbConfNvSenha.setText("Nova Senha - Confirmar");

        txtConfNvSenha.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtConfNvSenha.setToolTipText("<html>\n<p>Confirmar a nova senha.\n<html/>");
        txtConfNvSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConfNvSenhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnCamposLayout = new javax.swing.GroupLayout(pnCampos);
        pnCampos.setLayout(pnCamposLayout);
        pnCamposLayout.setHorizontalGroup(
            pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLogin)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSenhaAtual)
                            .addComponent(txtSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNovaSenha)
                            .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbConfNvSenha)
                            .addComponent(txtConfNvSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnCamposLayout.setVerticalGroup(
            pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lbSenhaAtual)
                        .addGap(0, 0, 0)
                        .addComponent(txtSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lbCodigo)
                        .addGap(0, 0, 0)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLogin)
                        .addGap(0, 0, 0)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lbNovaSenha)
                        .addGap(0, 0, 0)
                        .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lbConfNvSenha)
                        .addGap(0, 0, 0)
                        .addComponent(txtConfNvSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnBotao.setOpaque(false);

        btnSair.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/sair_Pqn_32.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setToolTipText("Cancelar alterações.");
        btnSair.setIconTextGap(5);
        btnSair.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/salvar_Pqn_32.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("Salvar alterações.");
        btnSalvar.setIconTextGap(5);
        btnSalvar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotaoLayout = new javax.swing.GroupLayout(pnBotao);
        pnBotao.setLayout(pnBotaoLayout);
        pnBotaoLayout.setHorizontalGroup(
            pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotaoLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        pnBotaoLayout.setVerticalGroup(
            pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotaoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnFundoLayout = new javax.swing.GroupLayout(pnFundo);
        pnFundo.setLayout(pnFundoLayout);
        pnFundoLayout.setHorizontalGroup(
            pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnFundoLayout.setVerticalGroup(
            pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnStatusBar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnStatusBar.setOpaque(false);
        pnStatusBar.setLayout(new java.awt.CardLayout());

        lbStatus.setText("   Mensagem...");
        pnStatusBar.add(lbStatus, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnStatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyPressed
        if (!txtLogin.getText().isEmpty()) {
            Tools.simulateTab(evt); // simula pressionar tab
        }
    }//GEN-LAST:event_txtLoginKeyPressed

    private void txtSenhaAtualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaAtualKeyPressed
        if (!new String(txtSenhaAtual.getPassword()).isEmpty()) {
            Tools.simulateTab(evt); // simula pressionar tab
        }
    }//GEN-LAST:event_txtSenhaAtualKeyPressed

    private void txtNovaSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNovaSenhaKeyPressed
        if (!new String(txtNovaSenha.getPassword()).isEmpty()) {
            Tools.simulateTab(evt); // simula pressionar tab
        }
    }//GEN-LAST:event_txtNovaSenhaKeyPressed

    private void txtConfNvSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfNvSenhaKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!new String(txtConfNvSenha.getPassword()).isEmpty()) {
                btnSalvar.requestFocus();
            }
        }
    }//GEN-LAST:event_txtConfNvSenhaKeyPressed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (validaTxt()) {
            String snh1 = userLogado.getSenha();
            String snh2 = new String(txtSenhaAtual.getPassword());
            String snh3 = new String(txtNovaSenha.getPassword());

            // confere digitação da senha atual
            if (snh1.equals(snh2)) {

                // confere se nova senha é diferente da atual
                if (!snh2.equals(snh3)) {

                    // se tudo ok, prossegue para os dados do banco
                    //
                    Usuario user = new Usuario();

                    user = userLogado;
                    user.setLogin(txtLogin.getText());
                    user.setSenha(new String(txtNovaSenha.getPassword()));

                    if (UsuarioDAO.update(user)) { // se atualizado...

                        userLogado = user;
                        Tools_Message.showUpdateMessage(); // mensagem de ok
                        this.dispose();

                    } else { // se houver erro...
                        Tools_Message.showErrorMessageValidation(
                                "Algo inesperado ocorreu.\n"
                                + "Dados não atualizados\n"
                                + "Contate seu administrador e informe o ocorrido.");
                    }

                } else {
                    //-------------------------------------------
                    // caso senha nova e antiga forem iguais...
                    Tools_Message.showErrorMessageValidation(
                            "\nA senha nova deve ser diferente da antiga." + "         \n\n");
                    limpaPrepara();
                }
            } else {
                Tools_Message.showErrorMessageValidation(
                        "     " + "Senha atual não confere!");
                limpaPrepara();
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

//==============================================================================
// Main
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Alterar_LoginSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Alterar_LoginSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Alterar_LoginSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Alterar_LoginSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_Alterar_LoginSenha dialog = new Tela_Alterar_LoginSenha(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbConfNvSenha;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbNovaSenha;
    private javax.swing.JLabel lbSenhaAtual;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JPanel pnBotao;
    private javax.swing.JPanel pnCampos;
    private javax.swing.JPanel pnFundo;
    private javax.swing.JPanel pnStatusBar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JPasswordField txtConfNvSenha;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtNovaSenha;
    private javax.swing.JPasswordField txtSenhaAtual;
    // End of variables declaration//GEN-END:variables
//==============================================================================
    /**/

    //==========================================================================
    // seta icones nos botões
    private void loadUser() {
        userLogado = new Usuario();
        userLogado = Tela_Principal.getUserLogado();
        
        if (userLogado.getId() > 0) { // se houver usuário conectado...

            txtCodigo.setText(Integer.toString(userLogado.getId()));
            txtLogin.setText(userLogado.getLogin());
            txtLogin.requestFocus();
            txtLogin.selectAll();

            lbStatus.setText(spc + "Login atual: " + userLogado.getLogin());
            
        } else { // senão...
            txtLogin.setEnabled(false);
            txtSenhaAtual.setEnabled(false);
            txtNovaSenha.setEnabled(false);
            txtConfNvSenha.setEnabled(false);
            btnSalvar.setEnabled(false);
            lbStatus.setText(spc + "Nenhum usário conectado.");
        }

    }

    //==========================================================================
    // seta icones nos botões
    private void setIcones() {
        String path = "/view/_images/32/";
        String ext = ".png";

        btnSalvar.setPressedIcon(btnSalvar.getIcon());
        btnSalvar.setRolloverIcon(Tools.setIcon("salvar_Gnd_32", ext, path));

        btnSair.setPressedIcon(btnSair.getIcon());
        btnSair.setRolloverIcon(Tools.setIcon("sair_Gnd_32", ext, path));

    }

    //==========================================================================
    // seta nome nas caixas de texto, para usar em evento
    private void setNames() {
        txtCodigo.setName(lbCodigo.getText());
        txtLogin.setName(lbLogin.getText());
        txtSenhaAtual.setName(lbSenhaAtual.getText());
        txtNovaSenha.setName(lbNovaSenha.getText());
        txtConfNvSenha.setName(lbConfNvSenha.getText());
    }

    //==========================================================================
    // valida preenchimento de dados
    private boolean validaTxt() {

        // checagem de campo vazio
        // se houver, retorna o objeto vazio
        // caso contrário, retorna null
        Object obj = Tools_Texts.returnTxtNull(pnCampos, null);

        // se todos campos preenchidos (não retornou nada vazio)...
        if (obj == null) {

            String snhNova1 = new String(txtNovaSenha.getPassword());
            String snhNova2 = new String(txtConfNvSenha.getPassword());

            //-------------------------------------------
            // valida preenchimento da senha
            //
            // verifica se senha nova tem espaços
            if (snhNova1.equals(snhNova1.replace(" ", ""))) {

                // verifica se senha nova confere com "confirma"
                if (snhNova1.equals(snhNova2)) {

                    // se tudo ok, retorna true;
                    return true;

                } else {
                    //-------------------------------------------
                    // caso senha nova não confirmada...
                    Tools_Message.showErrorMessageValidation(
                            "\nEntrada incorreta. Nova senha não confirmada." + "         \n\n");
                    limpaPrepara();
                }

            } else {
                //-------------------------------------------
                // caso senha nova tenha espaços...
                Tools_Message.showErrorMessageValidation(
                        "\nA senha não deve ter espaços." + "         \n\n");
                limpaPrepara();
            }

        } else {
            // avisa e posiciona no objeto vazio
            Tools_Texts.goToNullObject(obj);
        }

        return false;
    } // fim validaTxt

    //==========================================================================
    // limpa e prepara a tela para entrada de dados
    private void limpaPrepara() {
        String cod = txtCodigo.getText();
        Tools_Texts.clearTextsContainer(pnCampos);
        txtCodigo.setText(cod);
        txtLogin.requestFocus();
    }

} // fim class
