/**/
package view.geral;

import java.awt.event.KeyEvent;
import javax.swing.*;
import model.bean.Usuario;
import model.dao.UsuarioDAO;
import view.Tela_Principal;
import view._util.*;

public class Tela_Login extends javax.swing.JDialog {

    Usuario userLogin = null;

//    public Usuario getUserLogin() {
//        return userLogin;
//    }
    // variáveis de validação
    private int id;
    private String nome;
    private String nivelAcesso;
    private String login;
    private String senha;

    //==========================================================================
    public Tela_Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setIcones();
        setNames();
        Tools_Buttons.configButtons(pnBotao, -3);
        Tools_Buttons.setActionButtons(pnBotao);
        Tools_SetIcon.setIcon(this, "/view/_images/24/logInOut_Gnd_24.png");

        // aplica um fundo à área de trabalho
        Tools_SetFundoPainel.carregaImagem(pnFundo, "/view/_images/geral/fundo_login.jpg");

    }

//==============================================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFundo = new javax.swing.JPanel();
        lbLogo = new javax.swing.JLabel();
        pnBotao = new javax.swing.JPanel();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnVisitante = new javax.swing.JButton();
        pnEntrada = new javax.swing.JPanel();
        lbLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lbSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autenticação");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/geral/logo_login.png"))); // NOI18N
        lbLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        pnBotao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnBotao.setOpaque(false);

        btnConfirmar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/ok_Pqn_32.png"))); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setToolTipText("Confirmar dados.");
        btnConfirmar.setIconTextGap(-3);
        btnConfirmar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/cancelar_02_Pqn_32.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar.");
        btnCancelar.setIconTextGap(-3);
        btnCancelar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnVisitante.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVisitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/visitante_Pqn_32.png"))); // NOI18N
        btnVisitante.setText("Visitante");
        btnVisitante.setToolTipText("Entrar como visitante.");
        btnVisitante.setIconTextGap(-3);
        btnVisitante.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisitanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotaoLayout = new javax.swing.GroupLayout(pnBotao);
        pnBotao.setLayout(pnBotaoLayout);
        pnBotaoLayout.setHorizontalGroup(
            pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotaoLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(btnVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        pnBotaoLayout.setVerticalGroup(
            pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotaoLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        pnEntrada.setOpaque(false);

        lbLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/usuarios_Gnd_32.png"))); // NOI18N

        txtLogin.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(0, 60, 120));
        txtLogin.setText("admin");
        txtLogin.setToolTipText("Entrada de login.");
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginKeyPressed(evt);
            }
        });

        lbSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/chave_Gnd_32.png"))); // NOI18N

        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(0, 60, 120));
        txtSenha.setText("123");
        txtSenha.setToolTipText("Entrada de senha.");
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnEntradaLayout = new javax.swing.GroupLayout(pnEntrada);
        pnEntrada.setLayout(pnEntradaLayout);
        pnEntradaLayout.setHorizontalGroup(
            pnEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEntradaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnEntradaLayout.createSequentialGroup()
                        .addComponent(lbLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnEntradaLayout.createSequentialGroup()
                        .addComponent(lbSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnEntradaLayout.setVerticalGroup(
            pnEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEntradaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnEntradaLayout.createSequentialGroup()
                        .addComponent(lbLogin)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnFundoLayout = new javax.swing.GroupLayout(pnFundo);
        pnFundo.setLayout(pnFundoLayout);
        pnFundoLayout.setHorizontalGroup(
            pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLogo)
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFundoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pnBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnFundoLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(pnEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnFundoLayout.setVerticalGroup(
            pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundoLayout.createSequentialGroup()
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnFundoLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lbLogo))
                    .addGroup(pnFundoLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(pnEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(582, 258));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //==========================================================================
    private void txtLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyPressed

        boolean log = txtLogin.getText().isEmpty();
        boolean snh = new String(txtSenha.getPassword()).isEmpty();

        if (!log && !snh) {

            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                btnConfirmar.requestFocus();
            }
        } else if (!log && snh) {
            Tools.simulateTab(evt); // simula pressionar tab
            //txtSenha.requestFocus();
        }

    }//GEN-LAST:event_txtLoginKeyPressed

    //==========================================================================
    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed

        boolean log = txtLogin.getText().isEmpty();
        boolean snh = new String(txtSenha.getPassword()).isEmpty();

        if (!log && !snh) {

            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                btnConfirmar.requestFocus();
            }
        } else if (log && !snh) {
            txtLogin.requestFocus();
        }

    }//GEN-LAST:event_txtSenhaKeyPressed

    //==========================================================================
    private void btnVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisitanteActionPerformed

        // entra com visitante
        userLogin = new Usuario();
        userLogin.setId(0);
        userLogin.setNome("Visitante");
        userLogin.setNivelAcesso("Visitante");
        userLogin.setLogin(null);
        userLogin.setSenha(null);

        Tela_Principal.setUserLogado(userLogin);

        this.dispose();

    }//GEN-LAST:event_btnVisitanteActionPerformed

    //==========================================================================
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed

        // se todos campos preenchidos...
        if (validaTxt()) {
            String strL = txtLogin.getText();
            String strS = new String(txtSenha.getPassword());

            // checa o login e armazena o Usuário, para passar
            // para o tela principal
            userLogin = UsuarioDAO.checkLoginReturnUser(strL, strS);

            // se recebeu um usuário...
            if (userLogin != null) {
                Tela_Principal.setUserLogado(userLogin);
                this.dispose();
            } else {
                Tools_Message.showErrorMessageValidation("Dados incorretos.");
                Tools_Texts.clearTextsContainer(pnEntrada); // limpa campos
                txtLogin.requestFocus(); // posiciona o cursor em login
            }
        }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    //==========================================================================
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    //==========================================================================
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cancelar();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_Login dialog = new Tela_Login(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVisitante;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JPanel pnBotao;
    private javax.swing.JPanel pnEntrada;
    private javax.swing.JPanel pnFundo;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
//==============================================================================
    /**/

    //==========================================================================
    // cancela ou sai da tela
    private void cancelar() {

        if (Tela_Principal.getmainFormLoad()) {
            this.dispose();
        } else {
            System.exit(0);
        }

    }

    //==========================================================================
    // seta icones nos botões
    private void setIcones() {
        String path = "/view/_images/32/";
        String ext = ".png";

        btnVisitante.setPressedIcon(btnVisitante.getIcon());
        btnVisitante.setRolloverIcon(Tools.setIcon("visitante_Gnd_32", ext, path));

        btnConfirmar.setPressedIcon(btnConfirmar.getIcon());
        btnConfirmar.setRolloverIcon(Tools.setIcon("ok_Gnd_32", ext, path));

        btnCancelar.setPressedIcon(btnCancelar.getIcon());
        btnCancelar.setRolloverIcon(Tools.setIcon("cancelar_02_Gnd_32", ext, path));

    }

    //==========================================================================
    // seta nome nas caixas de texto, para usar em evento
    private void setNames() {
        txtLogin.setName("Login");
        txtSenha.setName("Senha");
    }

    //==========================================================================
    // valida preenchimento de dados
    private boolean validaTxt() {

        Object obj = Tools_Texts.returnTxtNull(pnEntrada, null);

        // se todos campos preenchidos...
        if (obj == null) {

            return true;

        } else { // se hover campo vazio...

            String msg = null;

            // pega o nome do objeto (que, no caso, esta com o mesmo titulo do label)
            if (obj instanceof JTextField) {
                JTextField txt = (JTextField) obj;
                msg = txt.getName();
            } else {
                JPasswordField txt = (JPasswordField) obj;
                msg = txt.getName();
            }

            // mensagem
            msg = "O campo \"" + msg + "\" deve ser preenchido." + "     ";
            Tools_Message.showErrorMessageValidation(msg);

            if (obj instanceof JTextField) {
                JTextField txt = (JTextField) obj;
                txt.requestFocus();
            } else {
                JPasswordField txt = (JPasswordField) obj;
                txt.requestFocus();
            }

        }

        return false;
    } // fim validaTxt

    //==========================================================================
    // getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
} // fim class
