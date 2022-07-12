/**/
package view.produto;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.SwingConstants;
import javax.swing.table.*;
import model.bean.Produto;
import model.dao.ProdutoDAO;
import view._util.*;

public class Tela_Pesquisa_Produto_Venda extends javax.swing.JDialog {

    // permissões:
    // 0 = visistantes
    // 1 = administradores
    // 2 = usuários
    private int idPermissao = 0; // controle de permissão de usuário
    private boolean permAdm = false;
    private boolean permUser = false;
    //--------------------------------------------------------------------------
    private boolean modoBuscarUser = false; // chamada através de outra tela
    private boolean modoPesquisarLocal = false; // chamada através da tela principal
    private static boolean modoEditarUpdate = false; // controle, se algo alterado no modo editar (chamada a outra tela)
    //--------------------------------------------------------------------------
    private List<Produto> list_Produtos = new ArrayList<>(); // lista completa dos produtos
    private List<Produto> list_Search = new ArrayList<>(); // lista para usar em list_Search
//    private List<Produto> list_Inclusao = new ArrayList<>(); // lista para usar na em venda (inclusão de itens)
    private ArrayList<Integer[]> list_Id_Qtd = new ArrayList<>(); // lista de IDs de produtos e quantidades

//    private ArrayList<Object> list_Inclusao_tst = new ArrayList<>();
//    private ArrayList<String> lista2 = new ArrayList<>();
    //--------------------------------------------------------------------------
    private static int idFound = 0; // id encontrado na pesquisa

    //==========================================================================
    //                          GETTERS / SETTERS
    //==========================================================================
    public static int getIdFound() {
        return idFound;
    }

    public static void setModoEditarUpdate(boolean modoEditarUpdate) {
        Tela_Pesquisa_Produto_Venda.modoEditarUpdate = modoEditarUpdate;
    }

//    public List<Produto> getList_Inclusao() {
//        return list_Inclusao;
//    }
    public ArrayList getList_Id_Qtd() {
        return list_Id_Qtd;
    }

    //==========================================================================
    //                              CONSTRUTORES
    //==========================================================================
    // modo padrão do sistema
    public Tela_Pesquisa_Produto_Venda(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    // modo padrão, apartir dele chama a busca de produto
    public Tela_Pesquisa_Produto_Venda(Frame parent, boolean modal, int permissao) {
        super(parent, modal);
        initComponents();

        txtQuantidade.setEnabled(false);
        btnIncluir.setEnabled(false);

        idPermissao = permissao;
        setPermissoes();
        modoPesquisarLocal = true;
        init();
    }

    // modo secundario, será chamado apartir de outra tela, para edição
    public Tela_Pesquisa_Produto_Venda(Frame parent, boolean modal,
            int permissao, List<Produto> list) {
        super(parent, modal);
        initComponents();

        list_Produtos = list;

        txtQuantidade.setEnabled(false);
        btnIncluir.setEnabled(false);

        idPermissao = permissao;
        setPermissoes();

        //load
        modoBuscarUser = true;
        init();
    }

    // modo terciario, será chamado apartir da tela de venda
    public Tela_Pesquisa_Produto_Venda(Frame parent, int permissao) {
        super(parent, true);
        initComponents();

        btnConfirmar_Editar.setEnabled(false);

        idPermissao = permissao;
        setPermissoes();

        //load
        modoBuscarUser = true;
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

        //----------------------------------------------------------------------
        setIcones();
        setIconesAlternado();
        setToolTipTextButton();
        
        Tools_Buttons.configButtons(pnBotao, 2);
        Tools_Buttons.setActionButtons(pnBotao);
        
        Tools_Buttons.configButtons(pnInclusao1, 2);
        Tools_Buttons.setActionButtons(pnInclusao1);
        
        Tools_SetIcon.setIcon(this, "/view/_images/24/produto_consulta_Gnd_24.png");
        Tools_SetFundoPainel.carregaImagem(pnFundo, "/view/_images/geral/fundo_telas.jpg");

        loadTable(); // carrega a tabela (gridview)
        lbStatus.setText("");
        txtQuantidade.setName(lbQuantidade.getText());
    }

//==============================================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFundo = new javax.swing.JPanel();
        pnPesquisa = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        pnTabLista = new javax.swing.JPanel();
        scroll_tb_Produtos = new javax.swing.JScrollPane();
        tb_Produtos = new javax.swing.JTable();
        lbNumRegistroTab = new javax.swing.JLabel();
        pnBotao = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnConfirmar_Editar = new javax.swing.JButton();
        btnSair_Cancelar = new javax.swing.JButton();
        pnFiltro = new javax.swing.JPanel();
        ckComeca = new javax.swing.JCheckBox();
        ckTermina = new javax.swing.JCheckBox();
        pnInclusao1 = new javax.swing.JPanel();
        pnInclusao2 = new javax.swing.JPanel();
        lbQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnIncluir = new javax.swing.JButton();
        pnStatusBar = new javax.swing.JPanel();
        lbStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa Produto");
        setResizable(false);

        pnFundo.setOpaque(false);

        pnPesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pesquisa"));
        pnPesquisa.setOpaque(false);

        lbNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNome.setText("Nome");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtNome.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNome.setToolTipText("<html>\n<p>Informar um nome para pesquisar (ESC limpa o campo).\n<html/>");
        txtNome.setName("Nome"); // NOI18N
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnPesquisaLayout = new javax.swing.GroupLayout(pnPesquisa);
        pnPesquisa.setLayout(pnPesquisaLayout);
        pnPesquisaLayout.setHorizontalGroup(
            pnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPesquisaLayout.createSequentialGroup()
                        .addComponent(lbNome)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtNome))
                .addContainerGap())
        );
        pnPesquisaLayout.setVerticalGroup(
            pnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPesquisaLayout.createSequentialGroup()
                .addComponent(lbNome)
                .addGap(0, 0, 0)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnTabLista.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Registros"));
        pnTabLista.setOpaque(false);

        tb_Produtos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tb_Produtos.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tb_Produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Categoria", "Preço", "Código Forn."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Produtos.getTableHeader().setReorderingAllowed(false);
        tb_Produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ProdutosMouseClicked(evt);
            }
        });
        tb_Produtos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_ProdutosKeyPressed(evt);
            }
        });
        scroll_tb_Produtos.setViewportView(tb_Produtos);
        if (tb_Produtos.getColumnModel().getColumnCount() > 0) {
            tb_Produtos.getColumnModel().getColumn(0).setMinWidth(50);
            tb_Produtos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb_Produtos.getColumnModel().getColumn(0).setMaxWidth(50);
            tb_Produtos.getColumnModel().getColumn(2).setMinWidth(110);
            tb_Produtos.getColumnModel().getColumn(2).setPreferredWidth(110);
            tb_Produtos.getColumnModel().getColumn(2).setMaxWidth(110);
            tb_Produtos.getColumnModel().getColumn(3).setMinWidth(110);
            tb_Produtos.getColumnModel().getColumn(3).setPreferredWidth(110);
            tb_Produtos.getColumnModel().getColumn(3).setMaxWidth(110);
            tb_Produtos.getColumnModel().getColumn(4).setMinWidth(80);
            tb_Produtos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_Produtos.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        lbNumRegistroTab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNumRegistroTab.setText("Nenhum registro encontrado.");

        javax.swing.GroupLayout pnTabListaLayout = new javax.swing.GroupLayout(pnTabLista);
        pnTabLista.setLayout(pnTabListaLayout);
        pnTabListaLayout.setHorizontalGroup(
            pnTabListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTabListaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnTabListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTabListaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbNumRegistroTab)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnTabListaLayout.createSequentialGroup()
                        .addComponent(scroll_tb_Produtos)
                        .addContainerGap())))
        );
        pnTabListaLayout.setVerticalGroup(
            pnTabListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTabListaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(scroll_tb_Produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNumRegistroTab)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnBotao.setOpaque(false);

        btnPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/nv_primeiro_Pqn_32.png"))); // NOI18N
        btnPrimeiro.setText("Primeiro");
        btnPrimeiro.setToolTipText("Primeiro registro.");
        btnPrimeiro.setIconTextGap(2);
        btnPrimeiro.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/nv_anterior_Pqn_32.png"))); // NOI18N
        btnAnterior.setText("Anterior");
        btnAnterior.setToolTipText("Registro anterior.");
        btnAnterior.setIconTextGap(2);
        btnAnterior.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/nv_proximo_Pqn_32.png"))); // NOI18N
        btnProximo.setText("Próximo");
        btnProximo.setToolTipText("Próximo registro.");
        btnProximo.setIconTextGap(2);
        btnProximo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });

        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/nv_ultimo_Pqn_32.png"))); // NOI18N
        btnUltimo.setText("Último");
        btnUltimo.setToolTipText("Último registro.");
        btnUltimo.setIconTextGap(2);
        btnUltimo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/atualizar_Pqn_32.png"))); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setToolTipText("Atualizar lista (nova consulta ao banco de dados).");
        btnAtualizar.setIconTextGap(2);
        btnAtualizar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnConfirmar_Editar.setText("Editar");
        btnConfirmar_Editar.setIconTextGap(2);
        btnConfirmar_Editar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnConfirmar_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmar_EditarActionPerformed(evt);
            }
        });

        btnSair_Cancelar.setText("Sair");
        btnSair_Cancelar.setIconTextGap(2);
        btnSair_Cancelar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSair_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotaoLayout = new javax.swing.GroupLayout(pnBotao);
        pnBotao.setLayout(pnBotaoLayout);
        pnBotaoLayout.setHorizontalGroup(
            pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotaoLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(btnPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnConfirmar_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSair_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        pnBotaoLayout.setVerticalGroup(
            pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotaoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSair_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConfirmar_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Nome que"));
        pnFiltro.setOpaque(false);

        ckComeca.setSelected(true);
        ckComeca.setText("Começa por...");
        ckComeca.setToolTipText("<html>\n<p>Filtrar por palavras que começam com...\n<html/>");
        ckComeca.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ckComecaStateChanged(evt);
            }
        });

        ckTermina.setText("Termina por...");
        ckTermina.setToolTipText("<html>\n<p>Filtrar por palavras que terminam com...\n<html/>");
        ckTermina.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ckTerminaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnFiltroLayout = new javax.swing.GroupLayout(pnFiltro);
        pnFiltro.setLayout(pnFiltroLayout);
        pnFiltroLayout.setHorizontalGroup(
            pnFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckComeca)
                    .addComponent(ckTermina))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnFiltroLayout.setVerticalGroup(
            pnFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFiltroLayout.createSequentialGroup()
                .addComponent(ckComeca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckTermina)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnInclusao1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Inclusão"));
        pnInclusao1.setOpaque(false);

        lbQuantidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbQuantidade.setText("Qtde");

        txtQuantidade.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtQuantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQuantidade.setToolTipText("Quantidade do item a incluir.");
        txtQuantidade.setName("Nome"); // NOI18N
        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnInclusao2Layout = new javax.swing.GroupLayout(pnInclusao2);
        pnInclusao2.setLayout(pnInclusao2Layout);
        pnInclusao2Layout.setHorizontalGroup(
            pnInclusao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInclusao2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnInclusao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbQuantidade)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnInclusao2Layout.setVerticalGroup(
            pnInclusao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInclusao2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lbQuantidade)
                .addGap(0, 0, 0)
                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/itemAdd_Pqn_32.png"))); // NOI18N
        btnIncluir.setText("Incluir");
        btnIncluir.setToolTipText("Inclui o item na lista de compra.");
        btnIncluir.setIconTextGap(2);
        btnIncluir.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnInclusao1Layout = new javax.swing.GroupLayout(pnInclusao1);
        pnInclusao1.setLayout(pnInclusao1Layout);
        pnInclusao1Layout.setHorizontalGroup(
            pnInclusao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInclusao1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnInclusao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnInclusao1Layout.setVerticalGroup(
            pnInclusao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInclusao1Layout.createSequentialGroup()
                .addGroup(pnInclusao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnInclusao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnFundoLayout = new javax.swing.GroupLayout(pnFundo);
        pnFundo.setLayout(pnFundoLayout);
        pnFundoLayout.setHorizontalGroup(
            pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnFundoLayout.createSequentialGroup()
                        .addComponent(pnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnInclusao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnTabLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnFundoLayout.setVerticalGroup(
            pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTabLista, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnFiltro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnInclusao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
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
            .addComponent(pnStatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
            .addComponent(pnFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        loadTable();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    //==========================================================================
    private void btnConfirmar_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmar_EditarActionPerformed
        execConfirmar_Editar();
    }//GEN-LAST:event_btnConfirmar_EditarActionPerformed

    //==========================================================================
    private void btnSair_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair_CancelarActionPerformed

        if (modoPesquisarLocal) {
            this.dispose();
        } else if (modoBuscarUser) {
            idFound = 0;
            this.dispose();
        }
    }//GEN-LAST:event_btnSair_CancelarActionPerformed
    //==========================================================================
    //==========================================================================
    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed

        //--------------------------------------------------
        // se modo confirma ativo
        if (modoBuscarUser) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                execConfirmar_Editar();
            }
        }

        //--------------------------------------------------
        // se setas direcionas para cima ou para baixo...
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            navegarAte("Anterior");
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            navegarAte("Proximo");
        }
    }//GEN-LAST:event_txtNomeKeyPressed

    //==========================================================================
    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased

        // se entrada na caixa de texto não for as teclas direcionais...
        if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN) {

            // se tecla esc, limpa a busca
            if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                txtNome.setText("");
            }

            loadSearchTable(txtNome.getText());

            if (tb_Produtos.getRowCount() > 0) {
                tb_Produtos.setRowSelectionInterval(0, 0);
            }
        }


    }//GEN-LAST:event_txtNomeKeyReleased

    //==========================================================================
    private void ckComecaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ckComecaStateChanged
        if (!ckComeca.isSelected() && !ckTermina.isSelected()) {
            ckTermina.setSelected(true);
        }

        loadSearchTable(txtNome.getText());
    }//GEN-LAST:event_ckComecaStateChanged

    //==========================================================================
    private void ckTerminaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ckTerminaStateChanged
        if (!ckComeca.isSelected() && !ckTermina.isSelected()) {
            ckComeca.setSelected(true);
        }

        loadSearchTable(txtNome.getText());
    }//GEN-LAST:event_ckTerminaStateChanged

    private void tb_ProdutosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ProdutosKeyPressed
        // se setas direcionas para cima ou para baixo...
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            refreshButtons(tb_Produtos.getSelectedRow(), tb_Produtos.getModel().getRowCount());
        }

        if (tb_Produtos.getSelectedRow() > 0 && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtQuantidade.requestFocus();
        }


    }//GEN-LAST:event_tb_ProdutosKeyPressed

    private void tb_ProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ProdutosMouseClicked
        refreshButtons(tb_Produtos.getSelectedRow(), tb_Produtos.getModel().getRowCount());

        if (tb_Produtos.getSelectedRow() > 0) {
            txtQuantidade.requestFocus();
        }

    }//GEN-LAST:event_tb_ProdutosMouseClicked

    private void txtQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyPressed

        if (!txtQuantidade.getText().isEmpty() && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnIncluir.requestFocus();
        }

    }//GEN-LAST:event_txtQuantidadeKeyPressed

    private void txtQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyReleased
        txtQuantidade.setText(txtQuantidade.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_txtQuantidadeKeyReleased

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed

        int qtd = !"".equals(txtQuantidade.getText().trim()) ? Integer.parseInt(txtQuantidade.getText()) : 0;

        if (tb_Produtos.getRowCount() > 0) {

            if (qtd > 0) {
                int id = (int) tb_Produtos.getValueAt(tb_Produtos.getSelectedRow(), 0);

                Integer[] dados = {id, qtd};

                list_Id_Qtd.add(dados);
                txtQuantidade.setText("");
                tb_Produtos.requestFocus();
                btnConfirmar_Editar.setEnabled(true);

            } else {
                // avisa e posiciona no objeto vazio
                Tools_Texts.goToNullObject(txtQuantidade);
            }
        } else {
            Tools_Message.showErrorMessageValidation("Nenhum item selecionado.");
        }

    }//GEN-LAST:event_btnIncluirActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Pesquisa_Produto_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Pesquisa_Produto_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Pesquisa_Produto_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Pesquisa_Produto_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Tela_Pesquisa_Produto_Venda dialog = new Tela_Pesquisa_Produto_Venda(new javax.swing.JFrame(), true);
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

//==============================================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnConfirmar_Editar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSair_Cancelar;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JCheckBox ckComeca;
    private javax.swing.JCheckBox ckTermina;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNumRegistroTab;
    private javax.swing.JLabel lbQuantidade;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JPanel pnBotao;
    private javax.swing.JPanel pnFiltro;
    private javax.swing.JPanel pnFundo;
    private javax.swing.JPanel pnInclusao1;
    private javax.swing.JPanel pnInclusao2;
    private javax.swing.JPanel pnPesquisa;
    private javax.swing.JPanel pnStatusBar;
    private javax.swing.JPanel pnTabLista;
    private javax.swing.JScrollPane scroll_tb_Produtos;
    private javax.swing.JTable tb_Produtos;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
//==============================================================================
    /**/

    //==========================================================================
    // seta icones nos botões
    private void setIcones() {
        String path = "/view/_images/32/";
        String ext = ".png";

        btnPrimeiro.setPressedIcon(btnPrimeiro.getIcon());
        btnPrimeiro.setRolloverIcon(Tools.setIcon("nv_primeiro_Gnd_32", ext, path));

        btnAnterior.setPressedIcon(btnAnterior.getIcon());
        btnAnterior.setRolloverIcon(Tools.setIcon("nv_anterior_Gnd_32", ext, path));

        btnProximo.setPressedIcon(btnProximo.getIcon());
        btnProximo.setRolloverIcon(Tools.setIcon("nv_proximo_Gnd_32", ext, path));

        btnUltimo.setPressedIcon(btnUltimo.getIcon());
        btnUltimo.setRolloverIcon(Tools.setIcon("nv_ultimo_Gnd_32", ext, path));

        btnAtualizar.setPressedIcon(btnAtualizar.getIcon());
        btnAtualizar.setRolloverIcon(Tools.setIcon("atualizar_Gnd_32", ext, path));
        
        btnIncluir.setPressedIcon(btnIncluir.getIcon());
        btnIncluir.setRolloverIcon(Tools.setIcon("itemAdd_Gnd_32", ext, path));

    }

    //==========================================================================
    // altera aparencia e texto do btnConfirmar_Editar
    private void setIconesAlternado() {
        String path = "/view/_images/32/";
        String ext = ".png";

        if (modoPesquisarLocal) {
            btnConfirmar_Editar.setText("Editar");
            btnConfirmar_Editar.setIcon(Tools.setIcon("editar_Pqn_32", ext, path));
            btnConfirmar_Editar.setPressedIcon(btnConfirmar_Editar.getIcon());
            btnConfirmar_Editar.setRolloverIcon(Tools.setIcon("editar_Gnd_32", ext, path));

            btnSair_Cancelar.setText("Sair");
            btnSair_Cancelar.setIcon(Tools.setIcon("sair_Pqn_32", ext, path));
            btnSair_Cancelar.setPressedIcon(btnSair_Cancelar.getIcon());
            btnSair_Cancelar.setRolloverIcon(Tools.setIcon("sair_Gnd_32", ext, path));

        } else if (modoBuscarUser) {
            btnConfirmar_Editar.setText("Confirmar");
            btnConfirmar_Editar.setIcon(Tools.setIcon("ok_Pqn_32", ext, path));
            btnConfirmar_Editar.setPressedIcon(btnConfirmar_Editar.getIcon());
            btnConfirmar_Editar.setRolloverIcon(Tools.setIcon("ok_Gnd_32", ext, path));

            btnSair_Cancelar.setText("Cancelar");
            btnSair_Cancelar.setIcon(Tools.setIcon("cancelar_02_Pqn_32", ext, path));
            btnSair_Cancelar.setPressedIcon(btnSair_Cancelar.getIcon());
            btnSair_Cancelar.setRolloverIcon(Tools.setIcon("cancelar_02_Gnd_32", ext, path));
        }

    }

    //==========================================================================
    // altera o estado da tela, para incluir, editar, ou ler
    private void setToolTipTextButton() {
        btnConfirmar_Editar.setToolTipText(modoPesquisarLocal ? "Editar registro selecionado." : "Confirmar pesquisa.");
        btnSair_Cancelar.setToolTipText(modoPesquisarLocal ? "Sair, fechar tela." : "Cancelar pesquisa.");
    }

    //==========================================================================
    // atualiza o label de contagem
    private void refreshCount() {
        lbNumRegistroTab.setText(Tools_Tables.refreshCount(tb_Produtos));
    }

    //==========================================================================
    // executa ação do btnConfirmar_Editar
    private void execConfirmar_Editar() {
        if (modoPesquisarLocal) {

            int id;
            int a = 0;
            if (tb_Produtos.getRowCount() > 0) {
                id = (int) tb_Produtos.getValueAt(tb_Produtos.getSelectedRow(), 0);
            } else {
                id = 0;
            }

            Tela_Cadastro_Produto tela = new Tela_Cadastro_Produto(null, true, idPermissao, list_Produtos, id);
            tela.setVisible(true);

            // se houve alteração...
            if (modoEditarUpdate) {
                list_Produtos = Tela_Cadastro_Produto.getList_Produtos();
                loadTable(list_Produtos);
                txtNome.setText(null);
            }

        } else if (modoBuscarUser) {
            idFound = (int) tb_Produtos.getValueAt(tb_Produtos.getSelectedRow(), 0);
            dispose();
        }
    }

    //==========================================================================
    // executa ação dos botões de navegação
    private void navegarAte(String local) {

        Tools_Tables.valueChangedScrollTable(tb_Produtos);
        local = local.toUpperCase();
        int tamTable = tb_Produtos.getModel().getRowCount(); // tamanho da lista
        int linha = tb_Produtos.getSelectedRow(); // seleção atual

        if (tamTable > 0) {
            switch (local) {
                case "PRIMEIRO":
                    linha = 0;
                    break;
                case "ANTERIOR":
                    linha = linha - 1 >= 0 ? linha - 1 : linha;
                    break;
                case "PROXIMO":
                    linha = linha + 1 < tamTable ? linha + 1 : linha;
                    break;
                case "ULTIMO":
                    linha = tamTable - 1;
                    break;
            }
            tb_Produtos.setRowSelectionInterval(linha, linha);
        }
        refreshButtons(linha, tamTable);
    } // fim navegarAte

    //==========================================================================
    // atualiza o status dos botões de navegação
    private void refreshButtons(int linhaAtual, int tamanhoTabela) {
        btnPrimeiro.setEnabled(linhaAtual > 0);
        btnAnterior.setEnabled(linhaAtual > 0);
        btnProximo.setEnabled(linhaAtual < tamanhoTabela - 1);
        btnUltimo.setEnabled(linhaAtual < tamanhoTabela - 1);
    }

    //==========================================================================
    //==========================================================================
    //                         OPERAÇÕES COM A TABELA
    //==========================================================================
    //==========================================================================
    // carrega a lista de produtos
    private void refreshList() {
        list_Produtos = null;
        list_Produtos = ProdutoDAO.read();
    }

    //==========================================================================
    // carrega a tabela apartir de uma lista
    public void loadTable() {

        if (permAdm || permUser) {
            refreshList();
            loadTable(list_Produtos);
        } else {
            list_Produtos = null;
        }

        refreshCount();
        this.txtNome.setText(null);
        this.txtNome.requestFocus();
    }

    //==========================================================================
    // carrega a tabela com a lista informada
    private void loadTable(List<Produto> list) {

        DefaultTableModel tabela = (DefaultTableModel) tb_Produtos.getModel();
        tabela.setNumRows(0); // limpa, para evitar exibir dado duplicado ao inserir dados

        tb_Produtos.setRowSorter(new TableRowSorter(tabela)); // para habilitar ordenar atravéz de clique nas colunas da tabala

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();// para colocar a coluna centralizada
        center.setHorizontalAlignment(SwingConstants.CENTER);

        tb_Produtos.getColumnModel().getColumn(0).setCellRenderer(center);
        tb_Produtos.getColumnModel().getColumn(2).setCellRenderer(center);
        tb_Produtos.getColumnModel().getColumn(3).setCellRenderer(center);
        tb_Produtos.getColumnModel().getColumn(4).setCellRenderer(center);

        list.forEach((produto) -> {
            tabela.addRow(new Object[]{
                produto.getId(),
                produto.getNome(),
                produto.getCategoria(),
                produto.getPreco(),
                produto.getId_fornecedor()
            });
        });

        if (tb_Produtos.getRowCount() > 0) {
            tb_Produtos.setRowSelectionInterval(0, 0);
            refreshButtons(0, tb_Produtos.getModel().getRowCount());
        }
    }

    //==========================================================================
    // atualiza e carrega a lista de pequisa
    public void loadSearchTable(String search) {
        list_Search.clear();

        // se lista não for nula...
        if (list_Produtos != null) {

            for (int i = 0; i < list_Produtos.size(); i++) {

                String lineProduto = list_Produtos.get(i).getNome().toUpperCase();
                search = search.toUpperCase();

                //---------------------------------------------------------
                // opção de seleção de filtro
                int op = ckComeca.isSelected() && ckTermina.isSelected() ? 1 // "começa com" e "termina com" (ou seja, em qualquer posição)
                        : ckComeca.isSelected() && !ckTermina.isSelected() ? 2 // pesquisar nome que "começa com"
                        : 3; // pesquisar nome que "termina com"

                //---------------------------------------------------------
                switch (op) {
                    case 1:
                        // se a pesquisa for uma substring da linha pesquisada
                        if (lineProduto.contains(search)) {
                            list_Search.add(list_Produtos.get(i)); // adiciona na lista de pesquisa
                        }
                        break;

                    case 2:
                        // se a pesquisa estiver no começo da linha pesquisada
                        if (lineProduto.indexOf(search) == 0) {
                            list_Search.add(list_Produtos.get(i));
                        }
                        break;

                    case 3:
                        int posSpc = lineProduto.lastIndexOf(" "); // posição do ultimo espaço

                        // se a pesquisa estiver no fim da linha pesquisada
                        if (lineProduto.lastIndexOf(search) == posSpc + 1) {
                            list_Search.add(list_Produtos.get(i));
                        }
                        break;
                }

            } // fim for

            loadTable(list_Search); // carrega a tabela com a lista de pesquisa   
        }

        refreshCount();
    }

} // fim class
