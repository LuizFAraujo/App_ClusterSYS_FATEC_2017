/**/
package view.usuario;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.*;
import model.bean.Usuario;
import model.dao.UsuarioDAO;
import view._util.*;

public class Tela_Cadastro_Usuario extends javax.swing.JDialog {

    // permissões:
    // 0 = visistantes
    // 1 = administradores
    // 2 = usuários
    private int idPermissao = 0; // controle de permissão de usuário
    private boolean permAdm = false;
    private boolean permUser = false;
    //--------------------------------------------------------------------------
    private boolean modoEditar = false; // chamada através de outra tela
    private boolean modoCadastrar = false; // chamada através da tela principal
    private static boolean modoEditarUpdate = false; // controle, se algo alterado no modo editar
    //--------------------------------------------------------------------------
    private boolean modoNovoLocal = false; // modo para inclusão de registro
    private boolean modoEdicaoLocal = false; // modo para edição de registro
    private int indiceLista = -1; // controle de exibição do índice da lista
    private static List<Usuario> list_Usuarios = new ArrayList<>(); // lista completa dos usuários

    //==========================================================================
    //                          GETTERS / SETTERS
    //==========================================================================
    public static List<Usuario> getList_Usuarios() {
        return list_Usuarios;
    }

    //==========================================================================
    //                              CONSTRUTORES
    //==========================================================================
    // modo padrão do sistema
    public Tela_Cadastro_Usuario(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    //==========================================================================
    // modo padrão, apartir dele chama a busca de usuario
    public Tela_Cadastro_Usuario(Frame parent, boolean modal, int permissao) {
        super(parent, modal);
        initComponents();

        modoCadastrar = true;
        idPermissao = permissao;
        setPermissoes();

        loadView(); // carrega a tela
        init();
    }

    //==========================================================================
    // modo secundario, será chamado apartir de outra tela, para edição
    public Tela_Cadastro_Usuario(Frame parent, boolean modal,
            int permissao, List<Usuario> list, int userId) {
        super(parent, modal);
        initComponents();

        modoEditar = true;
        idPermissao = permissao;
        setPermissoes();

        list_Usuarios = list;
        loadView(returnIndiceByValueId(userId)); // carrega dados na tela

        init();
    }

    //==========================================================================
    // sequencia importante: initComponents(), setPermissoes(), loadView(), init()
    //==========================================================================
    // permissões
    private void setPermissoes() {
        permAdm = idPermissao == 1;
        permUser = idPermissao == 2;
    }

    //==========================================================================
    private void init() {
        setIcones();
        setIconesAlternado();
        setNames();
        Tools_Buttons.configButtons(pnBotao, 2);
        Tools_Buttons.setActionButtons(pnBotao);
        Tools_Buttons.configButtons(pnNavegacao, 2);
        Tools_Buttons.setActionButtons(pnNavegacao);
        Tools_SetIcon.setIcon(this, "/view/_images/24/usuario_cadastro_Gnd_24.png");
        Tools_SetFundoPainel.carregaImagem(pnFundo, "/view/_images/geral/fundo_telas.jpg");
    }

//==============================================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFundo = new javax.swing.JPanel();
        pnCampos = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lbLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lbSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        lbNvAcesso = new javax.swing.JLabel();
        cbNvAcesso = new javax.swing.JComboBox<>();
        pnNavegacao = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        pnBotao = new javax.swing.JPanel();
        btnNovo_Salvar = new javax.swing.JButton();
        btnConfirmar_Pesquisar = new javax.swing.JButton();
        btnEditar_Salvar = new javax.swing.JButton();
        btnSair_Cancelar = new javax.swing.JButton();
        btnExcluir_Cancelar = new javax.swing.JButton();
        pnStatusBar = new javax.swing.JPanel();
        lbStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuário");
        setResizable(false);

        pnFundo.setOpaque(false);

        pnCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnCampos.setOpaque(false);

        lbCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodigo.setText("Código");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setName("Código"); // NOI18N

        lbNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNome.setText("Nome");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtNome.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNome.setToolTipText("<html>\n<p>Informar o nome do usuário.\n<html/>");
        txtNome.setName("Nome"); // NOI18N
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        lbLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbLogin.setText("Login");

        txtLogin.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtLogin.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtLogin.setToolTipText("<html>\n<p>Informar um usuário para login.\n<html/>");
        txtLogin.setName("Login"); // NOI18N
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginKeyPressed(evt);
            }
        });

        lbSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSenha.setText("Senha");

        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtSenha.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSenha.setToolTipText("<html>\n<p>Informar uma senha para login.\n<html/>");
        txtSenha.setName("Senha"); // NOI18N
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });

        lbNvAcesso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNvAcesso.setText("Nível de Acesso");

        cbNvAcesso.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        cbNvAcesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor" }));
        cbNvAcesso.setToolTipText("<html>\n<p>Informar o nível de acesso.\n<html/>");
        cbNvAcesso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNvAcessoItemStateChanged(evt);
            }
        });
        cbNvAcesso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbNvAcessoKeyPressed(evt);
            }
        });

        pnNavegacao.setOpaque(false);

        btnPrimeiro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/22/primeiro_Pqn_22.png"))); // NOI18N
        btnPrimeiro.setToolTipText("Primeiro registro.");
        btnPrimeiro.setIconTextGap(5);
        btnPrimeiro.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });

        btnAnterior.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/22/anterior_Pqn_22.png"))); // NOI18N
        btnAnterior.setToolTipText("Registro anterior.");
        btnAnterior.setIconTextGap(5);
        btnAnterior.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnProximo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/22/proximo_Pqn_22.png"))); // NOI18N
        btnProximo.setToolTipText("Próximo registro.");
        btnProximo.setIconTextGap(5);
        btnProximo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });

        btnUltimo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/22/ultimo_Pqn_22.png"))); // NOI18N
        btnUltimo.setToolTipText("Último registro.");
        btnUltimo.setIconTextGap(5);
        btnUltimo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnNavegacaoLayout = new javax.swing.GroupLayout(pnNavegacao);
        pnNavegacao.setLayout(pnNavegacaoLayout);
        pnNavegacaoLayout.setHorizontalGroup(
            pnNavegacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNavegacaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnNavegacaoLayout.setVerticalGroup(
            pnNavegacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNavegacaoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnNavegacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnCamposLayout = new javax.swing.GroupLayout(pnCampos);
        pnCampos.setLayout(pnCamposLayout);
        pnCamposLayout.setHorizontalGroup(
            pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCamposLayout.createSequentialGroup()
                                .addComponent(lbNome)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNome)))
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLogin)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNvAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbNvAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addComponent(pnNavegacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnCamposLayout.setVerticalGroup(
            pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnCamposLayout.createSequentialGroup()
                                .addComponent(lbCodigo)
                                .addGap(0, 0, 0)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnCamposLayout.createSequentialGroup()
                                .addComponent(lbNome)
                                .addGap(0, 0, 0)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCamposLayout.createSequentialGroup()
                                .addComponent(lbLogin)
                                .addGap(0, 0, 0)
                                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCamposLayout.createSequentialGroup()
                                .addComponent(lbNvAcesso)
                                .addGap(0, 0, 0)
                                .addComponent(cbNvAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lbSenha)
                        .addGap(0, 0, 0)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnBotao.setOpaque(false);

        btnNovo_Salvar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNovo_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/novo_Pqn_32.png"))); // NOI18N
        btnNovo_Salvar.setText("Novo");
        btnNovo_Salvar.setIconTextGap(5);
        btnNovo_Salvar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNovo_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovo_SalvarActionPerformed(evt);
            }
        });

        btnConfirmar_Pesquisar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnConfirmar_Pesquisar.setText("Pesquisar");
        btnConfirmar_Pesquisar.setIconTextGap(5);
        btnConfirmar_Pesquisar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnConfirmar_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmar_PesquisarActionPerformed(evt);
            }
        });

        btnEditar_Salvar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditar_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/editar_Pqn_32.png"))); // NOI18N
        btnEditar_Salvar.setText("Editar");
        btnEditar_Salvar.setIconTextGap(5);
        btnEditar_Salvar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnEditar_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar_SalvarActionPerformed(evt);
            }
        });

        btnSair_Cancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSair_Cancelar.setText("Sair");
        btnSair_Cancelar.setIconTextGap(5);
        btnSair_Cancelar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSair_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair_CancelarActionPerformed(evt);
            }
        });

        btnExcluir_Cancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnExcluir_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/excluir_Pqn_32.png"))); // NOI18N
        btnExcluir_Cancelar.setText("Excluir");
        btnExcluir_Cancelar.setIconTextGap(5);
        btnExcluir_Cancelar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnExcluir_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotaoLayout = new javax.swing.GroupLayout(pnBotao);
        pnBotao.setLayout(pnBotaoLayout);
        pnBotaoLayout.setHorizontalGroup(
            pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnEditar_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnExcluir_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnConfirmar_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSair_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnBotaoLayout.setVerticalGroup(
            pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotaoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnFundoLayout = new javax.swing.GroupLayout(pnFundo);
        pnFundo.setLayout(pnFundoLayout);
        pnFundoLayout.setHorizontalGroup(
            pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnFundoLayout.setVerticalGroup(
            pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
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
            .addComponent(pnFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnStatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    //==========================================================================
    //                            AÇÃO DOS BOTÕES
    //==========================================================================
    private void btnNovo_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovo_SalvarActionPerformed

        boolean checkSave = true;

        if (modoNovoLocal) {
            if (validaTxt()) {

                Usuario user = new Usuario();

                user.setNome(txtNome.getText().trim());
                user.setLogin(txtLogin.getText());
                user.setSenha(txtSenha.getText());
                user.setNivelAcesso(cbNvAcesso.getSelectedItem().toString());

                int newId = UsuarioDAO.create(user); // cria novo registro e retorna o id

                if (newId > 0) {
                    modoEditarUpdate = modoEditar; // indica que registro foi alterado (desliga botão cancelar, neste modo)
                    Tela_Pesquisa_Usuario.setModoEditarUpdate(modoEditarUpdate);

                    refreshList(); // atualiza a lista
                    loadView(returnIndiceByValueId(newId)); // mostra na tela o registro adicionado
                } else {
                    loadView(indiceLista);
                }

            } else {
                checkSave = false;
            }
        } else {
            limpaPrepara(); // prepara a tela
        }

        //--------------------------------------
        // *** deve ficar no fim ***
        // atualiza o status de tela
        if (checkSave) {
            modoNovoLocal = !modoNovoLocal;
            lbStatus.setText(modoNovoLocal ? "" : lbStatus.getText());
            refreshView();
        }
    }//GEN-LAST:event_btnNovo_SalvarActionPerformed

    //==========================================================================
    private void btnEditar_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar_SalvarActionPerformed

        boolean checkSave = true;

        if (modoEdicaoLocal) {
            if (validaTxt()) {
                int id = Integer.parseInt(txtCodigo.getText());

                Usuario user = new Usuario();

                user.setId(id);
                user.setNome(txtNome.getText().trim());
                user.setLogin(txtLogin.getText());
                user.setSenha(txtSenha.getText());
                user.setNivelAcesso(cbNvAcesso.getSelectedItem().toString());

                // atualiza o registro e exibe aviso de ok
                if (UsuarioDAO.update(user)) {
                    Tools_Message.showUpdateMessage();
                }

                modoEditarUpdate = modoEditar; // indica que registro foi alterado (desliga botão cancelar, neste modo)
                Tela_Pesquisa_Usuario.setModoEditarUpdate(modoEditarUpdate);

                refreshList(); // atualiza a lista
                loadView(returnIndiceByValueId(id)); // mostra na tela o registro atualizado
            } else {
                checkSave = false;
            }
        }

        //--------------------------------------
        // *** deve ficar no fim ***
        // atualiza o status de tela
        if (checkSave) {
            modoEdicaoLocal = !modoEdicaoLocal;
            lbStatus.setText(modoEdicaoLocal ? null : lbStatus.getText());
            refreshView();
        }
    }//GEN-LAST:event_btnEditar_SalvarActionPerformed

    //==========================================================================
    private void btnExcluir_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir_CancelarActionPerformed

        if (modoNovoLocal || modoEdicaoLocal) {

            // cancela modo novo ou modo edição
            if (modoNovoLocal) {
                limpaPrepara();
            }
            loadView(indiceLista);

        } else { // exclui o registro atual

            Usuario user = new Usuario();
            int idAtual = Integer.parseInt(txtCodigo.getText());
            user.setId(idAtual);

            // apaga o registro e exibe mensagem confirmando
            if (Tools_Message.showConfirmDelete()) {
                if (UsuarioDAO.delete(user)) {
                    Tools_Message.showDeleteMessage();
                }

                modoEditarUpdate = modoEditar; // indica que registro foi alterado (desliga botão cancelar, neste modo)
                Tela_Pesquisa_Usuario.setModoEditarUpdate(modoEditarUpdate);

                refreshList(); // atualiza a lista

                //------------------------------------------
                // pega o próximo id,
                // se não existir pega o anterior,
                // ou retorna -1 se não existir
                int tamList = list_Usuarios.size();
                int posNewShowId = -1; // posição do id a exibir

                for (int i = 0; i < tamList; i++) {
                    user = list_Usuarios.get(i);

                    if (user.getId() > idAtual) {
                        posNewShowId = i;
                        break;
                    } else if (user.getId() < idAtual) {
                        posNewShowId = i;
                    }
                }

                //------------------------------------------
                loadView(posNewShowId); // mostra o id seguinte, se não houver então o anterior
            }
        }

        modoNovoLocal = false;
        modoEdicaoLocal = false;
        refreshView();
    }//GEN-LAST:event_btnExcluir_CancelarActionPerformed

    //==========================================================================
    private void btnConfirmar_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmar_PesquisarActionPerformed

        if (modoCadastrar) {
            Tela_Pesquisa_Usuario tela = new Tela_Pesquisa_Usuario(null, true, idPermissao, list_Usuarios);
            tela.setVisible(true);

            int idFound = Tela_Pesquisa_Usuario.getIdFound();
            loadView(returnIndiceByValueId(idFound)); // mostra o registro retornado da pesquisa

        } else if (modoEditar) {
            modoEditarUpdate = false;
            dispose();
        }
    }//GEN-LAST:event_btnConfirmar_PesquisarActionPerformed

    //==========================================================================
    private void btnSair_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair_CancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnSair_CancelarActionPerformed

    //==========================================================================
    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        navegarAte("Primeiro");
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    //==========================================================================
    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        navegarAte("Anterior");
    }//GEN-LAST:event_btnAnteriorActionPerformed

    //==========================================================================
    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        navegarAte("Proximo");
    }//GEN-LAST:event_btnProximoActionPerformed

    //==========================================================================
    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        navegarAte("Ultimo");
    }//GEN-LAST:event_btnUltimoActionPerformed

    //==========================================================================
    //==========================================================================
    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        if (!txtNome.getText().isEmpty()) {
            Tools.simulateTab(evt); // simula pressionar tab
        }
    }//GEN-LAST:event_txtNomeKeyPressed

    //==========================================================================
    private void txtLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyPressed

        if (!txtLogin.getText().isEmpty()
                && !txtSenha.getText().isEmpty()
                && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (modoNovoLocal) {
                btnNovo_Salvar.requestFocus();
            } else if (modoEdicaoLocal) {
                btnEditar_Salvar.requestFocus();
            }
        } else if (!txtLogin.getText().isEmpty()) {
            Tools.simulateTab(evt);
        }
    }//GEN-LAST:event_txtLoginKeyPressed

    //==========================================================================
    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed

        if (!txtSenha.getText().isEmpty() && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (modoNovoLocal) {
                btnNovo_Salvar.requestFocus();
            } else if (modoEdicaoLocal) {
                btnEditar_Salvar.requestFocus();
            }
        }
    }//GEN-LAST:event_txtSenhaKeyPressed

    //==========================================================================
    private void cbNvAcessoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNvAcessoItemStateChanged

        if (!txtLogin.getText().isEmpty() && !txtSenha.getText().isEmpty()) {
            if (modoNovoLocal) {
                btnNovo_Salvar.requestFocus();
            } else if (modoEdicaoLocal) {
                btnEditar_Salvar.requestFocus();
            }
        }
    }//GEN-LAST:event_cbNvAcessoItemStateChanged

    //==========================================================================
    private void cbNvAcessoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbNvAcessoKeyPressed
        if (modoNovoLocal) {
            btnNovo_Salvar.requestFocus();
        } else if (modoEdicaoLocal) {
            btnEditar_Salvar.requestFocus();
        }
    }//GEN-LAST:event_cbNvAcessoKeyPressed

//==============================================================================
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
            java.util.logging.Logger.getLogger(Tela_Cadastro_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_Cadastro_Usuario dialog = new Tela_Cadastro_Usuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnConfirmar_Pesquisar;
    private javax.swing.JButton btnEditar_Salvar;
    private javax.swing.JButton btnExcluir_Cancelar;
    private javax.swing.JButton btnNovo_Salvar;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSair_Cancelar;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox<String> cbNvAcesso;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNvAcesso;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JPanel pnBotao;
    private javax.swing.JPanel pnCampos;
    private javax.swing.JPanel pnFundo;
    private javax.swing.JPanel pnNavegacao;
    private javax.swing.JPanel pnStatusBar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
//==============================================================================
    /**/

    //==========================================================================
    // carrega a lista de usuários
    private void refreshList() {
        list_Usuarios = null;
        list_Usuarios = UsuarioDAO.read();
    }

    //==========================================================================
    // carrega dados na tela, na abertura
    private void loadView() {

        if (permAdm || permUser) {
            refreshList();
            indiceLista = 0;
        } else {
            indiceLista = -1;
        }

        loadView(indiceLista);
    }

    //==========================================================================
    // carrega dados na tela
    private void loadView(int indiceID) {

        if (indiceID >= 0 && indiceID <= list_Usuarios.size() - 1) {

            Usuario user = new Usuario();
            user = list_Usuarios.get(indiceID);

            //-----------------------------------------------------
            // monta informações na tela
            txtCodigo.setText(Integer.toString(user.getId()));
            txtNome.setText(user.getNome());
            txtLogin.setText(user.getLogin());
            txtSenha.setText(null);
            String nivelAcesso = user.getNivelAcesso();

            for (int i = 0; i < cbNvAcesso.getItemCount(); i++) {
                if (nivelAcesso.equals(cbNvAcesso.getItemAt(i))) {
                    cbNvAcesso.setSelectedIndex(i);
                    break;
                }
            }
            //-----------------------------------------------------

            refreshStatuBar(Integer.parseInt(txtCodigo.getText()));
        } else {
            refreshStatuBar(0);
        }

        refreshView();
    }

    //==========================================================================
    // retorna a posição (indice) pelo valor do id
    private int returnIndiceByValueId(int id) {

        if (id > 0) {

            int tamList = list_Usuarios.size(); // pega o tamanho da lista (item 1 = index 0)
            int posId = -1; // posição do id na lista

            Usuario user = new Usuario();

            // retorna a posição do id na lista
            for (int i = 0; i < tamList; i++) {
                user = list_Usuarios.get(i);

                if (id == user.getId()) {
                    posId = i;
                    break;
                }
            }

            indiceLista = posId;
            return indiceLista;
        }
        return -1;
    }

    //==========================================================================
    // atualiza a barra de status
    private void refreshStatuBar(int numRegistro) {
        String spc = "   ";
        lbStatus.setText(numRegistro > 0
                ? spc + "Registro nº: " + Integer.toString(numRegistro)
                : spc + "Registro não encontrado.");
    }

    //==========================================================================
    // limpa e prepara a tela para entrada de dados
    private void limpaPrepara() {
        Tools_Texts.clearTextsContainer(pnCampos);
        txtNome.requestFocus();
    }

    //==========================================================================
    // valida preenchimento de dados
    private boolean validaTxt() {

        // lista de itens a ignorar
        String[] ignore = {txtCodigo.getName()};

        Object obj = Tools_Texts.returnTxtNull(pnCampos, ignore);

        // se todos campos preenchidos...
        if (obj == null) {

            String strLog = txtLogin.getText();
            String strSnh = txtSenha.getText();

            // verifica se login tem espaço lateral
            if (strLog.equals(strLog.trim())) {

                // verifica se senha tem espaços
                if (strSnh.equals(strSnh.replace(" ", ""))) {

                    // se tudo ok, retorna...
                    return true;

                } else {
                    //-------------------------------------------
                    // caso o senha tenha espaços...
                    Tools_Message.showErrorMessageValidation(
                            "\nA senha não deve ter espaços." + "         \n\n");

                    txtSenha.setText(null);
                    txtSenha.requestFocus();
                }

            } else {
                //-------------------------------------------
                // caso o login tenha espaço lateral...
                Tools_Message.showErrorMessageValidation(
                        "\nO login não deve ter espaço lateral." + "    \n\n");

                txtLogin.setText(null);
                txtLogin.requestFocus();
            }

        } //--------------------------------------------
        else {
            // avisa e posiciona no objeto vazio
            Tools_Texts.goToNullObject(obj);
        }

        return false;
    } // fim validaTxt

    //==========================================================================
    // executa ação dos botões de navegação
    private void navegarAte(String local) {
        local = local.toUpperCase();
        int tamList = list_Usuarios != null ? list_Usuarios.size() : 0;

        switch (local) {
            case "PRIMEIRO":
                indiceLista = 0;
                btnProximo.requestFocus();
                break;
            case "ANTERIOR":
                indiceLista--;
                break;
            case "PROXIMO":
                indiceLista++;
                break;
            case "ULTIMO":
                indiceLista = tamList - 1;
                btnAnterior.requestFocus();
                break;
        }

        btnPrimeiro.setEnabled(indiceLista > 0);
        btnAnterior.setEnabled(indiceLista > 0);
        btnProximo.setEnabled(indiceLista < tamList - 1);
        btnUltimo.setEnabled(indiceLista < tamList - 1);

        loadView(indiceLista);

    } // fim navegarAte

    //==========================================================================
    //                            CONFIGURAÇÕES
    //==========================================================================
    // seta nome nas caixas de texto, para usar em evento (usa o texto dos jLabels)
    private void setNames() {
        txtCodigo.setName(lbCodigo.getText());
        txtNome.setName(lbNome.getText());
        txtLogin.setName(lbLogin.getText());
        txtSenha.setName(lbSenha.getText());
    }

    //==========================================================================
    // seta icones nos botões
    private void setIcones() {
        String path = "/view/_images/22/";
        String ext = ".png";

        btnPrimeiro.setPressedIcon(btnPrimeiro.getIcon());
        btnPrimeiro.setRolloverIcon(Tools.setIcon("primeiro_Gnd_22", ext, path));

        btnAnterior.setPressedIcon(btnAnterior.getIcon());
        btnAnterior.setRolloverIcon(Tools.setIcon("anterior_Gnd_22", ext, path));

        btnProximo.setPressedIcon(btnProximo.getIcon());
        btnProximo.setRolloverIcon(Tools.setIcon("proximo_Gnd_22", ext, path));

        btnUltimo.setPressedIcon(btnUltimo.getIcon());
        btnUltimo.setRolloverIcon(Tools.setIcon("ultimo_Gnd_22", ext, path));
    }

    //==========================================================================
    // altera aparencia e texto, conforme modo ativo
    private void setIconesAlternado() {
        String path = "/view/_images/32/";
        String ext = ".png";
        String img;

        //-------------------------
        // btnConfirmar_Pesquisar
        btnConfirmar_Pesquisar.setText(modoCadastrar ? "Pesquisar" : "Ok");
        img = modoCadastrar ? "pesquisar_Pqn_32" : "ok_Pqn_32";
        btnConfirmar_Pesquisar.setIcon(Tools.setIcon(img, ext, path));
        btnConfirmar_Pesquisar.setPressedIcon(btnConfirmar_Pesquisar.getIcon());
        img = modoCadastrar ? "pesquisar_Gnd_32" : "ok_Gnd_32";
        btnConfirmar_Pesquisar.setRolloverIcon(Tools.setIcon(img, ext, path));

        //-------------------------
        // btnSair_Cancelar
        btnSair_Cancelar.setText(modoCadastrar ? "Sair" : "Cancelar");
        img = modoCadastrar ? "sair_Pqn_32" : "cancelar_02_Pqn_32";
        btnSair_Cancelar.setIcon(Tools.setIcon(img, ext, path));
        btnSair_Cancelar.setPressedIcon(btnSair_Cancelar.getIcon());
        img = modoCadastrar ? "sair_Gnd_32" : "cancelar_02_Gnd_32";
        btnSair_Cancelar.setRolloverIcon(Tools.setIcon(img, ext, path));

    }

    //==========================================================================
    // altera o estado da tela, para incluir, editar, ou ler
    private void refreshView() {

        int tamList = list_Usuarios != null ? list_Usuarios.size() : 0;

        //---------------------------------------------------------
        boolean habilita = (modoNovoLocal || modoEdicaoLocal);
        txtNome.setEditable(habilita);
        txtLogin.setEditable(habilita);
        txtSenha.setEditable(habilita);
        cbNvAcesso.setEnabled(habilita);

        btnEditar_Salvar.setEnabled(!modoNovoLocal && permAdm);
        btnNovo_Salvar.setEnabled(!modoEdicaoLocal && permAdm);
        btnExcluir_Cancelar.setEnabled(permAdm);

        btnConfirmar_Pesquisar.setEnabled((!(modoNovoLocal || modoEdicaoLocal) && modoCadastrar) || (modoEditarUpdate && modoEditar));
        btnSair_Cancelar.setEnabled(!modoEditarUpdate);

        btnPrimeiro.setEnabled(!(modoNovoLocal || modoEdicaoLocal) && indiceLista > 0 && (permAdm || permUser));
        btnAnterior.setEnabled(!(modoNovoLocal || modoEdicaoLocal) && indiceLista > 0 && (permAdm || permUser));
        btnProximo.setEnabled(!(modoNovoLocal || modoEdicaoLocal) && indiceLista < tamList - 1 && (permAdm || permUser));
        btnUltimo.setEnabled(!(modoNovoLocal || modoEdicaoLocal) && indiceLista < tamList - 1 && (permAdm || permUser));

        btnNovo_Salvar.setToolTipText(modoNovoLocal ? "Salvar inclusão." : "Adicionar registro.");
        btnEditar_Salvar.setToolTipText(modoEdicaoLocal ? "Salvar alteração." : "Editar registro.");
        btnExcluir_Cancelar.setToolTipText(modoNovoLocal ? "Cancelar." : "Excluir registro.");
        btnConfirmar_Pesquisar.setToolTipText(modoCadastrar ? "Pesquisar registro." : "Confirmar edição.");
        btnSair_Cancelar.setToolTipText(modoCadastrar ? "Sair, fechar tela." : "Cancelar edição.");

        //---------------------------------------------------------
        //---------------------------------------------------------
        String path = "/view/_images/32/";
        String ext = ".png";
        String img;

        //-------------------------
        // btnNovo_Salvar
        btnNovo_Salvar.setText(modoNovoLocal ? "Salvar" : "Novo");
        img = modoNovoLocal ? "salvar_Pqn_32" : "novo_Pqn_32";
        btnNovo_Salvar.setIcon(Tools.setIcon(img, ext, path));
        btnNovo_Salvar.setPressedIcon(btnNovo_Salvar.getIcon());
        img = modoNovoLocal ? "salvar_Gnd_32" : "novo_Gnd_32";
        btnNovo_Salvar.setRolloverIcon(Tools.setIcon(img, ext, path));

        //-------------------------
        // btnEditar_Salvar
        btnEditar_Salvar.setText(modoEdicaoLocal ? "Salvar" : "Editar");
        img = modoEdicaoLocal ? "salvar_Pqn_32" : "editar_Pqn_32";
        btnEditar_Salvar.setIcon(Tools.setIcon(img, ext, path));
        btnEditar_Salvar.setPressedIcon(btnEditar_Salvar.getIcon());
        img = modoEdicaoLocal ? "salvar_Gnd_32" : "editar_Gnd_32";
        btnEditar_Salvar.setRolloverIcon(Tools.setIcon(img, ext, path));

        //-------------------------
        // btnExcluir_Cancelar
        btnExcluir_Cancelar.setText(modoNovoLocal || modoEdicaoLocal ? "Cancelar" : "Excluir");
        img = modoNovoLocal || modoEdicaoLocal ? "cancelar_Pqn_32" : "excluir_Pqn_32";
        btnExcluir_Cancelar.setIcon(Tools.setIcon(img, ext, path));
        btnExcluir_Cancelar.setPressedIcon(btnExcluir_Cancelar.getIcon());
        img = modoNovoLocal || modoEdicaoLocal ? "cancelar_Gnd_32" : "excluir_Gnd_32";
        btnExcluir_Cancelar.setRolloverIcon(Tools.setIcon(img, ext, path));

        //---------------------------------------------------------
        //---------------------------------------------------------
    }

} // fim class
