/**/
package view.produto;

import java.awt.Frame;
import java.util.*;
import model.bean.Produto;
import model.bean.pessoa.Fornecedor;
import model.dao.FornecedorDAO;
import model.dao.ProdutoDAO;
import view._util.*;
import view.fornecedor.Tela_Pesquisa_Fornecedor;
import view.produto.bkp.Tela_Pesquisa_Produto;

public class Tela_Cadastro_Produto extends javax.swing.JDialog {

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
    private static List<Produto> list_Produtos = new ArrayList<>(); // lista completa dos produtos
    private static List<Fornecedor> list_Fornecedores = new ArrayList<>(); // lista completa dos fornecedores

    //==========================================================================
    //                          GETTERS / SETTERS
    //==========================================================================
    public static List<Produto> getList_Produtos() {
        return list_Produtos;
    }

    //==========================================================================
    //                              CONSTRUTORES
    //==========================================================================
    // modo padrão do sistema
    public Tela_Cadastro_Produto(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    //==========================================================================
    // modo padrão, apartir dele chama a busca de produto
    public Tela_Cadastro_Produto(Frame parent, boolean modal, int permissao) {
        super(parent, modal);
        initComponents();
        Tools_Texts.clearTextsContainer(pnCampos);
        modoCadastrar = true;
        idPermissao = permissao;
        setPermissoes();

        loadView(); // carrega a tela
        init();
    }

    //==========================================================================
    // modo secundario, será chamado apartir de outra tela, para edição
    public Tela_Cadastro_Produto(Frame parent, boolean modal,
            int permissao, List<Produto> list, int prodID) {
        super(parent, modal);
        initComponents();
        Tools_Texts.clearTextsContainer(pnCampos);
        modoEditar = true;
        idPermissao = permissao;
        setPermissoes();

        list_Produtos = list;
        loadView(returnIndiceByValueId(prodID)); // carrega dados na tela

        init();
    }

    //==========================================================================
    // sequencia importante: initComponents(), setPermissoes(), loadView(), init()
    //==========================================================================
    // permissões
    // 1 seta permissão de alterção, 2 seta apenas consulta
    private void setPermissoes() {
        permAdm = idPermissao == 1;
        permUser = idPermissao == 1;
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

        Tools_Buttons.configButtons(pnCampos, 2);
        Tools_Buttons.setActionButtons(pnCampos);

        Tools_SetIcon.setIcon(this, "/view/_images/24/produto_cadastro_Gnd_24.png");
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
        lbCategoria = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        lbPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        pnNavegacao = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        lbCodigoFornecedor = new javax.swing.JLabel();
        txtCodigoFornecedor = new javax.swing.JTextField();
        txtNomeFornecedor = new javax.swing.JTextField();
        lbNomeFornecedor = new javax.swing.JLabel();
        btnPesquisarFornecedor = new javax.swing.JButton();
        pnBotao = new javax.swing.JPanel();
        btnNovo_Salvar = new javax.swing.JButton();
        btnConfirmar_Pesquisar = new javax.swing.JButton();
        btnEditar_Salvar = new javax.swing.JButton();
        btnSair_Cancelar = new javax.swing.JButton();
        btnExcluir_Cancelar = new javax.swing.JButton();
        pnStatusBar = new javax.swing.JPanel();
        lbStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produtos");
        setResizable(false);

        pnFundo.setOpaque(false);

        pnCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnCampos.setOpaque(false);

        lbCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodigo.setText("Código");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setToolTipText("Código do produto.");
        txtCodigo.setName("Código"); // NOI18N

        lbNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNome.setText("Nome");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtNome.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNome.setToolTipText("<html>\n<p>Informar o nome do produto.\n<html/>");
        txtNome.setName(""); // NOI18N
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        lbCategoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCategoria.setText("Categoria");

        txtCategoria.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtCategoria.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCategoria.setToolTipText("Informar o e-mail.");
        txtCategoria.setName(""); // NOI18N
        txtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCategoriaKeyPressed(evt);
            }
        });

        lbPreco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbPreco.setText("Preço");

        txtPreco.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtPreco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPreco.setToolTipText("Informar o número.");
        txtPreco.setName(""); // NOI18N
        txtPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecoKeyReleased(evt);
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

        lbCodigoFornecedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodigoFornecedor.setText("Código F.");

        txtCodigoFornecedor.setEditable(false);
        txtCodigoFornecedor.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtCodigoFornecedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoFornecedor.setToolTipText("Código do fornecedor.");
        txtCodigoFornecedor.setName("Código"); // NOI18N

        txtNomeFornecedor.setEditable(false);
        txtNomeFornecedor.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtNomeFornecedor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNomeFornecedor.setToolTipText("Nome do fornecedor.");
        txtNomeFornecedor.setName(""); // NOI18N

        lbNomeFornecedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNomeFornecedor.setText("Fornecedor");

        btnPesquisarFornecedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPesquisarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/procurar_Pqn_32.png"))); // NOI18N
        btnPesquisarFornecedor.setToolTipText("Pesquisar fornecedor.");
        btnPesquisarFornecedor.setIconTextGap(5);
        btnPesquisarFornecedor.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnPesquisarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarFornecedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCamposLayout = new javax.swing.GroupLayout(pnCampos);
        pnCampos.setLayout(pnCamposLayout);
        pnCamposLayout.setHorizontalGroup(
            pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnNavegacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnCamposLayout.createSequentialGroup()
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCodigoFornecedor)
                                    .addComponent(txtCodigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnCamposLayout.createSequentialGroup()
                                        .addComponent(lbNomeFornecedor)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtNomeFornecedor)))
                            .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbCategoria)
                                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbPreco)
                            .addComponent(txtPreco)
                            .addComponent(btnPesquisarFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pnCamposLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbCodigo, txtCodigo});

        pnCamposLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbCategoria, txtCategoria});

        pnCamposLayout.setVerticalGroup(
            pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposLayout.createSequentialGroup()
                .addContainerGap()
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
                        .addComponent(lbCategoria)
                        .addGap(0, 0, 0)
                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lbPreco)
                        .addGap(0, 0, 0)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lbCodigoFornecedor)
                        .addGap(0, 0, 0)
                        .addComponent(txtCodigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lbNomeFornecedor)
                        .addGap(0, 0, 0)
                        .addComponent(txtNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPesquisarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(btnNovo_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnEditar_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnExcluir_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnConfirmar_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSair_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
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
                    .addComponent(pnCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

                //----------------------------------------------------
                String nome = txtNome.getText();
                String categoria = txtCategoria.getText();
                Double preco = Double.parseDouble(txtPreco.getText());
                int id_fornecedor = Integer.parseInt(txtCodigoFornecedor.getText());

                Produto produto = new Produto(nome, categoria, preco, id_fornecedor);

                //----------------------------------------------------
                int newId = ProdutoDAO.create(produto); // cria novo registro e retorna o id

                // cancela modo novo ou modo edição
                if (newId > 0) {
                    modoEditarUpdate = modoEditar; // indica que registro foi alterado (desliga botão cancelar, neste modo)
                    Tela_Pesquisa_Produto.setModoEditarUpdate(modoEditarUpdate);

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
                //----------------------------------------------------
                int id = Integer.parseInt(txtCodigo.getText());
                String nome = txtNome.getText();
                String categoria = txtCategoria.getText();
                Double preco = Double.parseDouble(txtPreco.getText());
                int id_fornecedor = Integer.parseInt(txtCodigoFornecedor.getText());

                Produto produto = new Produto(id, nome, categoria, preco, id_fornecedor);

                //----------------------------------------------------
                // atualiza o registro e exibe aviso de ok
                if (ProdutoDAO.update(produto)) {
                    Tools_Message.showUpdateMessage();
                }

                modoEditarUpdate = modoEditar; // indica que registro foi alterado (desliga botão cancelar, neste modo)
                Tela_Pesquisa_Produto.setModoEditarUpdate(modoEditarUpdate);

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

            Produto produto = new Produto();
            int idAtual = Integer.parseInt(txtCodigo.getText());
            produto.setId(idAtual);

            // apaga o registro e exibe mensagem confirmando
            if (Tools_Message.showConfirmDelete()) {
                if (ProdutoDAO.delete(produto)) {
                    Tools_Message.showDeleteMessage();
                }

                modoEditarUpdate = modoEditar; // indica que registro foi alterado (desliga botão cancelar, neste modo)
                Tela_Pesquisa_Produto.setModoEditarUpdate(modoEditarUpdate);

                refreshList(); // atualiza a lista

                //------------------------------------------
                // pega o próximo id,
                // se não existir pega o anterior,
                // ou retorna -1 se não existir
                int tamList = list_Produtos.size();
                int posNewShowId = -1; // posição do id a exibir

                for (int i = 0; i < tamList; i++) {
                    produto = list_Produtos.get(i);

                    if (produto.getId() > idAtual) {
                        posNewShowId = i;
                        break;
                    } else if (produto.getId() < idAtual) {
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
//            Tela_Pesquisa_Produto tela = new Tela_Pesquisa_Produto(null, true, idPermissao, list_Produtos);
            Tela_Pesquisa_Produto_Venda tela = new Tela_Pesquisa_Produto_Venda(null, true, idPermissao, list_Produtos);
            tela.setVisible(true);

            int idFound = Tela_Pesquisa_Produto_Venda.getIdFound();
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
    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        if (!txtNome.getText().isEmpty()) {
            Tools.simulateTab(evt); // simula pressionar tab
        }
    }//GEN-LAST:event_txtNomeKeyPressed

    //==========================================================================
    private void txtCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoriaKeyPressed
        if (!txtCategoria.getText().isEmpty()) {
            Tools.simulateTab(evt); // simula pressionar tab
        }
    }//GEN-LAST:event_txtCategoriaKeyPressed

    //==========================================================================
    private void txtPrecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoKeyPressed
//        txtPreco.setText(txtPreco.getText().replaceAll("[^0-9]", ""));
//        txtPreco.setText(txtPreco.getText().replaceAll("[A-Z]", ""));

        if (!txtPreco.getText().isEmpty()) {
            Tools.simulateTab(evt);
        }
    }//GEN-LAST:event_txtPrecoKeyPressed

    //==========================================================================
    private void btnPesquisarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarFornecedorActionPerformed
        Tela_Pesquisa_Fornecedor tela = new Tela_Pesquisa_Fornecedor(null, true, idPermissao, list_Fornecedores);
        tela.setVisible(true);

        int idFound = Tela_Pesquisa_Fornecedor.getIdFound();

        if (idFound > 0) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor = list_Fornecedores.get(idFound - 1);

            txtCodigoFornecedor.setText(Integer.toString(fornecedor.getId()));
            txtNomeFornecedor.setText(fornecedor.getNome());
        }
    }//GEN-LAST:event_btnPesquisarFornecedorActionPerformed

    private void txtPrecoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoKeyReleased
        txtPreco.setText(txtPreco.getText().replaceAll("[^0-9]", ""));
//        txtPreco.setText(txtPreco.getText().replaceAll("[A-Z]", ""));
    }//GEN-LAST:event_txtPrecoKeyReleased

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
            java.util.logging.Logger.getLogger(Tela_Cadastro_Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_Cadastro_Produto dialog = new Tela_Cadastro_Produto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnPesquisarFornecedor;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSair_Cancelar;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbCodigoFornecedor;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNomeFornecedor;
    private javax.swing.JLabel lbPreco;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JPanel pnBotao;
    private javax.swing.JPanel pnCampos;
    private javax.swing.JPanel pnFundo;
    private javax.swing.JPanel pnNavegacao;
    private javax.swing.JPanel pnStatusBar;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoFornecedor;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeFornecedor;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
//==============================================================================
    /**/

    //==========================================================================
    // carrega a lista de produtos e fornecedores
    private void refreshList() {
        list_Produtos = null;
        list_Fornecedores = null;
        list_Produtos = ProdutoDAO.read();
        list_Fornecedores = FornecedorDAO.read();
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

        if (indiceID >= 0 && indiceID <= list_Produtos.size() - 1) {

            Produto produto = new Produto();
            produto = list_Produtos.get(indiceID);

            //-----------------------------------------------------
            // monta informações na tela
            txtCodigo.setText(Integer.toString(produto.getId()));
            txtNome.setText(produto.getNome());
            txtCategoria.setText(produto.getCategoria());
            txtPreco.setText(Double.toString(produto.getPreco()));

            int fornId = produto.getId_fornecedor();

            txtCodigoFornecedor.setText(Integer.toString(fornId));

            // somente será executado se tela de cadastro for chamada
            // apartir de outra tela
            if (list_Fornecedores.size() <= 0) {
                list_Fornecedores = FornecedorDAO.read();
            }

            Fornecedor fornecedor = new Fornecedor();
            fornecedor = list_Fornecedores.get(fornId);

            txtNomeFornecedor.setText(fornecedor.getNome());

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

            int tamList = list_Produtos.size(); // pega o tamanho da lista (item 1 = index 0)
            int posId = -1; // posição do id na lista

            Produto produto = new Produto();

            // retorna a posição do id na lista
            for (int i = 0; i < tamList; i++) {
                produto = list_Produtos.get(i);

                if (id == produto.getId()) {
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
            return true;
        } else {
            // avisa e posiciona no objeto vazio
            Tools_Texts.goToNullObject(obj);
        }

        return false;
    } // fim validaTxt

    //==========================================================================
    // executa ação dos botões de navegação
    private void navegarAte(String local) {
        local = local.toUpperCase();
        int tamList = list_Produtos != null ? list_Produtos.size() : 0;

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
        txtCategoria.setName(lbCategoria.getText());
        txtPreco.setName(lbPreco.getText());
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

        path = "/view/_images/32/";

        btnPesquisarFornecedor.setPressedIcon(btnPesquisarFornecedor.getIcon());
        btnPesquisarFornecedor.setRolloverIcon(Tools.setIcon("procurar_Gnd_32", ext, path));
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

        int tamList = list_Produtos != null ? list_Produtos.size() : 0;

        //---------------------------------------------------------
        boolean habilita = (modoNovoLocal || modoEdicaoLocal);
        txtNome.setEditable(habilita);
        txtCategoria.setEditable(habilita);
        txtPreco.setEditable(habilita);

        btnEditar_Salvar.setEnabled(!modoNovoLocal && permAdm);
        btnNovo_Salvar.setEnabled(!modoEdicaoLocal && permAdm);
        btnExcluir_Cancelar.setEnabled(permAdm);

        btnConfirmar_Pesquisar.setEnabled((!(modoNovoLocal || modoEdicaoLocal) && modoCadastrar) || (modoEditarUpdate && modoEditar));
        btnSair_Cancelar.setEnabled(!modoEditarUpdate);

        btnPrimeiro.setEnabled(!(modoNovoLocal || modoEdicaoLocal) && indiceLista > 0 && (permAdm || permUser));
        btnAnterior.setEnabled(!(modoNovoLocal || modoEdicaoLocal) && indiceLista > 0 && (permAdm || permUser));
        btnProximo.setEnabled(!(modoNovoLocal || modoEdicaoLocal) && indiceLista < tamList - 1 && (permAdm || permUser));
        btnUltimo.setEnabled(!(modoNovoLocal || modoEdicaoLocal) && indiceLista < tamList - 1 && (permAdm || permUser));

        btnPesquisarFornecedor.setEnabled(habilita);

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
