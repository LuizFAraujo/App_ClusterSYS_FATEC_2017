/**/
package view.cliente;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.SwingConstants;
import javax.swing.table.*;
import model.bean.pessoa.Cliente;
import model.dao.ClienteDAO;
import view._util.*;

public class Tela_Pesquisa_Cliente extends javax.swing.JDialog {

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
    private static List<Cliente> list_Clientes = new ArrayList<>(); // lista completa dos clientes
    private List<Cliente> list_Search = new ArrayList<>(); // lista para usar em list_Search
    //--------------------------------------------------------------------------
    private static int idFound = 0; // id encontrado na pesquisa
//    private static Cliente cliFound = null; // cliente encontrado na pesquisa

    //==========================================================================
    //                          GETTERS / SETTERS
    //==========================================================================
    public static int getIdFound() {
        return idFound;
    }

    public static List<Cliente> getList_Clientes() {
        return list_Clientes;
    }

//    public static Cliente getCliFound() {
//        return cliFound;
//    }
    
    public static void setModoEditarUpdate(boolean modoEditarUpdate) {
        Tela_Pesquisa_Cliente.modoEditarUpdate = modoEditarUpdate;
    }

    //==========================================================================
    //                              CONSTRUTORES
    //==========================================================================
    // modo padrão do sistema
    public Tela_Pesquisa_Cliente(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    // modo padrão, apartir dele chama a busca de cliente
    public Tela_Pesquisa_Cliente(Frame parent, boolean modal, int permissao) {
        super(parent, modal);
        initComponents();

        idPermissao = permissao;
        setPermissoes();
        modoPesquisarLocal = true;
        init();
    }

    // modo secundario, será chamado apartir de outra tela, para edição
    public Tela_Pesquisa_Cliente(Frame parent, boolean modal,
            int permissao, List<Cliente> list) {
        super(parent, modal);
        initComponents();

        list_Clientes = list;

        idPermissao = permissao;
        setPermissoes();

        //load
        modoBuscarUser = true;
        init();
    }

    // modo terciario, será chamado apartir da tela de venda
    public Tela_Pesquisa_Cliente(Frame parent, int permissao) {
        super(parent, true);
        initComponents();

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
        Tools_SetIcon.setIcon(this, "/view/_images/24/cliente_consulta_Gnd_24.png");
        Tools_SetFundoPainel.carregaImagem(pnFundo, "/view/_images/geral/fundo_telas.jpg");

        loadTable(); // carrega a tabela (gridview)
        lbStatus.setText("");
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
        scroll_tb_Clientes = new javax.swing.JScrollPane();
        tb_Clientes = new javax.swing.JTable();
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
        pnStatusBar = new javax.swing.JPanel();
        lbStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa Cliente");
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

        tb_Clientes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tb_Clientes.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tb_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Telefone", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Clientes.getTableHeader().setReorderingAllowed(false);
        tb_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ClientesMouseClicked(evt);
            }
        });
        tb_Clientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_ClientesKeyPressed(evt);
            }
        });
        scroll_tb_Clientes.setViewportView(tb_Clientes);
        if (tb_Clientes.getColumnModel().getColumnCount() > 0) {
            tb_Clientes.getColumnModel().getColumn(0).setMinWidth(50);
            tb_Clientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb_Clientes.getColumnModel().getColumn(0).setMaxWidth(50);
            tb_Clientes.getColumnModel().getColumn(2).setMinWidth(110);
            tb_Clientes.getColumnModel().getColumn(2).setPreferredWidth(110);
            tb_Clientes.getColumnModel().getColumn(2).setMaxWidth(110);
            tb_Clientes.getColumnModel().getColumn(3).setMinWidth(260);
            tb_Clientes.getColumnModel().getColumn(3).setPreferredWidth(260);
            tb_Clientes.getColumnModel().getColumn(3).setMaxWidth(260);
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
                        .addComponent(scroll_tb_Clientes)
                        .addContainerGap())))
        );
        pnTabListaLayout.setVerticalGroup(
            pnTabListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTabListaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(scroll_tb_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnFundoLayout = new javax.swing.GroupLayout(pnFundo);
        pnFundo.setLayout(pnFundoLayout);
        pnFundoLayout.setHorizontalGroup(
            pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnFundoLayout.createSequentialGroup()
                        .addComponent(pnPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

            if (tb_Clientes.getRowCount() > 0) {
                tb_Clientes.setRowSelectionInterval(0, 0);
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

    private void tb_ClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ClientesKeyPressed
        // se setas direcionas para cima ou para baixo...
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            refreshButtons(tb_Clientes.getSelectedRow(), tb_Clientes.getModel().getRowCount());
        }
    }//GEN-LAST:event_tb_ClientesKeyPressed

    private void tb_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ClientesMouseClicked
        refreshButtons(tb_Clientes.getSelectedRow(), tb_Clientes.getModel().getRowCount());
    }//GEN-LAST:event_tb_ClientesMouseClicked

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
            java.util.logging.Logger.getLogger(Tela_Pesquisa_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Pesquisa_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Pesquisa_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Pesquisa_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_Pesquisa_Cliente dialog = new Tela_Pesquisa_Cliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSair_Cancelar;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JCheckBox ckComeca;
    private javax.swing.JCheckBox ckTermina;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNumRegistroTab;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JPanel pnBotao;
    private javax.swing.JPanel pnFiltro;
    private javax.swing.JPanel pnFundo;
    private javax.swing.JPanel pnPesquisa;
    private javax.swing.JPanel pnStatusBar;
    private javax.swing.JPanel pnTabLista;
    private javax.swing.JScrollPane scroll_tb_Clientes;
    private javax.swing.JTable tb_Clientes;
    private javax.swing.JTextField txtNome;
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
        lbNumRegistroTab.setText(Tools_Tables.refreshCount(tb_Clientes));
    }

    //==========================================================================
    // executa ação do btnConfirmar_Editar
    private void execConfirmar_Editar() {
        if (modoPesquisarLocal) {

            int id;
            if (tb_Clientes.getRowCount() > 0) {
                id = (int) tb_Clientes.getValueAt(tb_Clientes.getSelectedRow(), 0);
            } else {
                id = 0;
            }

            Tela_Cadastro_Cliente tela = new Tela_Cadastro_Cliente(null, true, idPermissao, list_Clientes, id);
            tela.setVisible(true);

            // se houve alteração...
            if (modoEditarUpdate) {
                list_Clientes = Tela_Cadastro_Cliente.getList_Clientes();
                loadTable(list_Clientes);
                txtNome.setText(null);
            }

        } else if (modoBuscarUser) {
            idFound = (int) tb_Clientes.getValueAt(tb_Clientes.getSelectedRow(), 0);
            dispose();
        }
    }

    //==========================================================================
    // executa ação dos botões de navegação
    private void navegarAte(String local) {

        Tools_Tables.valueChangedScrollTable(tb_Clientes);
        local = local.toUpperCase();
        int tamTable = tb_Clientes.getModel().getRowCount(); // tamanho da lista
        int linha = tb_Clientes.getSelectedRow(); // seleção atual

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
            tb_Clientes.setRowSelectionInterval(linha, linha);
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
    // carrega a lista de clientes
    private void refreshList() {
        list_Clientes = null;
        list_Clientes = ClienteDAO.read();
    }

    //==========================================================================
    // carrega a tabela apartir de uma lista
    public void loadTable() {

        if (permAdm || permUser) {
            refreshList();
            loadTable(list_Clientes);
        } else {
            list_Clientes = null;
        }

        refreshCount();
        this.txtNome.setText(null);
        this.txtNome.requestFocus();
    }

    //==========================================================================
    // carrega a tabela com a lista informada
    private void loadTable(List<Cliente> list) {

        DefaultTableModel tabela = (DefaultTableModel) tb_Clientes.getModel();
        tabela.setNumRows(0); // limpa, para evitar exibir dado duplicado ao inserir dados

        tb_Clientes.setRowSorter(new TableRowSorter(tabela)); // para habilitar ordenar atravéz de clique nas colunas da tabala

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();// para colocar a coluna centralizada
        center.setHorizontalAlignment(SwingConstants.CENTER);

        tb_Clientes.getColumnModel().getColumn(0).setCellRenderer(center);
        tb_Clientes.getColumnModel().getColumn(2).setCellRenderer(center);

        list.forEach((cliente) -> {
            tabela.addRow(new Object[]{
                cliente.getId(),
                cliente.getNome(),
                Tools_Texts.getTelefoneFormated(cliente.getTelefone()),
                cliente.getEmail()
            });
        });

        if (tb_Clientes.getRowCount() > 0) {
            tb_Clientes.setRowSelectionInterval(0, 0);
            refreshButtons(0, tb_Clientes.getModel().getRowCount());
        }
    }

    //==========================================================================
    // atualiza e carrega a lista de pequisa
    public void loadSearchTable(String search) {
        list_Search.clear();

        // se lista não for nula...
        if (list_Clientes != null) {

            for (int i = 0; i < list_Clientes.size(); i++) {

                String lineCliente = list_Clientes.get(i).getNome().toUpperCase();
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
                        if (lineCliente.contains(search)) {
                            list_Search.add(list_Clientes.get(i)); // adiciona na lista de pesquisa
                        }
                        break;

                    case 2:
                        // se a pesquisa estiver no começo da linha pesquisada
                        if (lineCliente.indexOf(search) == 0) {
                            list_Search.add(list_Clientes.get(i));
                        }
                        break;

                    case 3:
                        int posSpc = lineCliente.lastIndexOf(" "); // posição do ultimo espaço

                        // se a pesquisa estiver no fim da linha pesquisada
                        if (lineCliente.lastIndexOf(search) == posSpc + 1) {
                            list_Search.add(list_Clientes.get(i));
                        }
                        break;
                }

            } // fim for

            loadTable(list_Search); // carrega a tabela com a lista de pesquisa   
        }

        refreshCount();
    }

} // fim class
