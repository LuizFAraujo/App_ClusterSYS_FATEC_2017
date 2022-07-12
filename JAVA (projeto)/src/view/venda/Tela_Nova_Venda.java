/**/
package view.venda;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Produto;
import model.bean.Usuario;
import model.bean.pessoa.Cliente;
import model.dao.ProdutoDAO;
import view._util.Tools;
import view._util.Tools_Buttons;
import view._util.Tools_Message;
import view._util.Tools_SetFundoPainel;
import view._util.Tools_SetIcon;
import view._util.Tools_Texts;
import view.cliente.Tela_Pesquisa_Cliente;
import view.produto.Tela_Pesquisa_Produto_Venda;

public class Tela_Nova_Venda extends javax.swing.JInternalFrame {

    // permissões:
    // 0 = visistantes
    // 1 = administradores
    // 2 = usuários
    private int idPermissao = 0; // controle de permissão de usuário
    private boolean permAdm = false;
    private boolean permUser = false;

    private Usuario userLogado = null;

    private List<Cliente> list_Clientes = new ArrayList<>(); // lista completa dos clientes
    private List<Produto> list_Inclusao = new ArrayList<>(); // lista para adicionar itens à tabela
    private ArrayList<Integer[]> list_Id_Qtd = new ArrayList<>(); // lista de IDs de produtos e quantidades

    //==========================================================================
    //                              CONSTRUTORES
    //==========================================================================
    // modo padrão do sistema
    public Tela_Nova_Venda() {
        initComponents();
        init();
    }

    //==========================================================================
    // modo padrão para fazer nova venda
    public Tela_Nova_Venda(Usuario userLogado, int permissao) {
        initComponents();
        this.userLogado = userLogado;
        idPermissao = permissao;
        init();
    }

    //==========================================================================
    //==========================================================================
    //==========================================================================
    private void init() {
        this.setMinimumSize(this.getPreferredSize()); // define tamanho minimo do form

        btnRemoverItem.setEnabled(false);
        btnConfirmar.setEnabled(false);

        readUser();
        setPermissoes();
        setIcones();

        Tools_Buttons.configButtons(pnBotao, 2);
        Tools_Buttons.setActionButtons(pnBotao);

        Tools_Buttons.configButtons(pnCliente, 2);
        Tools_Buttons.setActionButtons(pnCliente);

        Tools_SetIcon.setIcon(this, "/view/_images/24/venda_nova_Gnd_24.png");
        Tools_SetFundoPainel.carregaImagem(pnFundo, "/view/_images/geral/fundo_telas.jpg");

        txtData.setText(Tools_Texts.getDataAtual());
        lbStatus.setText("");
        lbTotalVenda.setText("R$0.00");
    }

    private void setPermissoes() {
        permAdm = idPermissao == 1;
        permUser = idPermissao == 1;
    }

//==============================================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFundo = new javax.swing.JPanel();
        pnVendedor = new javax.swing.JPanel();
        lbCodigoVendedor = new javax.swing.JLabel();
        txtCodigoVendedor = new javax.swing.JTextField();
        lbNomeVendedor = new javax.swing.JLabel();
        txtNomeVendedor = new javax.swing.JTextField();
        pnVenda1 = new javax.swing.JPanel();
        lbCodigoVenda = new javax.swing.JLabel();
        txtCodigoVenda = new javax.swing.JTextField();
        lbData = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        pnCliente = new javax.swing.JPanel();
        lbCodigoCliente = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();
        lbNomeCliente = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        txtTelefoneCliente = new javax.swing.JFormattedTextField();
        lbTelefoneCliente = new javax.swing.JLabel();
        btnPesquisarCliente = new javax.swing.JButton();
        pnTabLista = new javax.swing.JPanel();
        scroll_tb_ItensVenda = new javax.swing.JScrollPane();
        tb_ItensVenda = new javax.swing.JTable();
        pnVenda2 = new javax.swing.JPanel();
        lbTotalVenda = new javax.swing.JLabel();
        pnBotao = new javax.swing.JPanel();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAdicionarItem = new javax.swing.JButton();
        btnRemoverItem = new javax.swing.JButton();
        pnStatusBar = new javax.swing.JPanel();
        lbStatus = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(718, 509));

        pnFundo.setOpaque(false);

        pnVendedor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Vendedor"));
        pnVendedor.setOpaque(false);

        lbCodigoVendedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodigoVendedor.setText("Código");

        txtCodigoVendedor.setEditable(false);
        txtCodigoVendedor.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtCodigoVendedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoVendedor.setToolTipText("Código do vendedor.");
        txtCodigoVendedor.setName("Código"); // NOI18N

        lbNomeVendedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNomeVendedor.setText("Nome");

        txtNomeVendedor.setEditable(false);
        txtNomeVendedor.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtNomeVendedor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNomeVendedor.setToolTipText("Nome do vendedor.");
        txtNomeVendedor.setName(""); // NOI18N

        javax.swing.GroupLayout pnVendedorLayout = new javax.swing.GroupLayout(pnVendedor);
        pnVendedor.setLayout(pnVendedorLayout);
        pnVendedorLayout.setHorizontalGroup(
            pnVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVendedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCodigoVendedor)
                    .addComponent(txtCodigoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNomeVendedor)
                    .addComponent(txtNomeVendedor))
                .addContainerGap())
        );
        pnVendedorLayout.setVerticalGroup(
            pnVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVendedorLayout.createSequentialGroup()
                .addGroup(pnVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnVendedorLayout.createSequentialGroup()
                        .addComponent(lbCodigoVendedor)
                        .addGap(0, 0, 0)
                        .addComponent(txtCodigoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnVendedorLayout.createSequentialGroup()
                        .addComponent(lbNomeVendedor)
                        .addGap(0, 0, 0)
                        .addComponent(txtNomeVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pnVenda1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Venda"));
        pnVenda1.setOpaque(false);

        lbCodigoVenda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodigoVenda.setText("Código");

        txtCodigoVenda.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtCodigoVenda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoVenda.setToolTipText("Código de venda.");
        txtCodigoVenda.setName("Código"); // NOI18N

        lbData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbData.setText("Data");

        txtData.setEditable(false);
        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtData.setText("00/00/0000");
        txtData.setToolTipText("Data atual.");
        txtData.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtData.setName(""); // NOI18N

        javax.swing.GroupLayout pnVenda1Layout = new javax.swing.GroupLayout(pnVenda1);
        pnVenda1.setLayout(pnVenda1Layout);
        pnVenda1Layout.setHorizontalGroup(
            pnVenda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVenda1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnVenda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCodigoVenda)
                    .addComponent(txtCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnVenda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnVenda1Layout.createSequentialGroup()
                        .addComponent(lbData)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtData, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnVenda1Layout.setVerticalGroup(
            pnVenda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVenda1Layout.createSequentialGroup()
                .addGroup(pnVenda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnVenda1Layout.createSequentialGroup()
                        .addComponent(lbData)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnVenda1Layout.createSequentialGroup()
                        .addComponent(lbCodigoVenda)
                        .addGap(0, 0, 0)
                        .addComponent(txtCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pnCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cliente"));
        pnCliente.setOpaque(false);

        lbCodigoCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodigoCliente.setText("Código");

        txtCodigoCliente.setEditable(false);
        txtCodigoCliente.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtCodigoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoCliente.setToolTipText("Código do cliente.");
        txtCodigoCliente.setName("Código"); // NOI18N

        lbNomeCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNomeCliente.setText("Nome");

        txtNomeCliente.setEditable(false);
        txtNomeCliente.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtNomeCliente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNomeCliente.setToolTipText("Nome do cliente.");
        txtNomeCliente.setName(""); // NOI18N

        txtTelefoneCliente.setEditable(false);
        try {
            txtTelefoneCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefoneCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefoneCliente.setToolTipText("Telefone do cliente.");
        txtTelefoneCliente.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtTelefoneCliente.setName(""); // NOI18N

        lbTelefoneCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTelefoneCliente.setText("Telefone");

        btnPesquisarCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPesquisarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/procurar_Pqn_32.png"))); // NOI18N
        btnPesquisarCliente.setToolTipText("Pesquisar cliente.");
        btnPesquisarCliente.setIconTextGap(5);
        btnPesquisarCliente.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnClienteLayout = new javax.swing.GroupLayout(pnCliente);
        pnCliente.setLayout(pnClienteLayout);
        pnClienteLayout.setHorizontalGroup(
            pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCodigoCliente)
                    .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNomeCliente)
                    .addComponent(txtNomeCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnClienteLayout.setVerticalGroup(
            pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnClienteLayout.createSequentialGroup()
                .addGroup(pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnClienteLayout.createSequentialGroup()
                        .addComponent(lbTelefoneCliente)
                        .addGap(0, 0, 0)
                        .addComponent(txtTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnClienteLayout.createSequentialGroup()
                        .addComponent(lbCodigoCliente)
                        .addGap(0, 0, 0)
                        .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnClienteLayout.createSequentialGroup()
                        .addComponent(lbNomeCliente)
                        .addGap(0, 0, 0)
                        .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pnTabLista.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Itens"));
        pnTabLista.setOpaque(false);

        tb_ItensVenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tb_ItensVenda.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tb_ItensVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Quantidade", "Valor Unit.", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class
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
        tb_ItensVenda.getTableHeader().setReorderingAllowed(false);
        scroll_tb_ItensVenda.setViewportView(tb_ItensVenda);
        if (tb_ItensVenda.getColumnModel().getColumnCount() > 0) {
            tb_ItensVenda.getColumnModel().getColumn(0).setMinWidth(50);
            tb_ItensVenda.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb_ItensVenda.getColumnModel().getColumn(0).setMaxWidth(50);
            tb_ItensVenda.getColumnModel().getColumn(2).setMinWidth(70);
            tb_ItensVenda.getColumnModel().getColumn(2).setPreferredWidth(70);
            tb_ItensVenda.getColumnModel().getColumn(2).setMaxWidth(70);
            tb_ItensVenda.getColumnModel().getColumn(3).setMinWidth(100);
            tb_ItensVenda.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_ItensVenda.getColumnModel().getColumn(3).setMaxWidth(100);
            tb_ItensVenda.getColumnModel().getColumn(4).setMinWidth(100);
            tb_ItensVenda.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_ItensVenda.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        javax.swing.GroupLayout pnTabListaLayout = new javax.swing.GroupLayout(pnTabLista);
        pnTabLista.setLayout(pnTabListaLayout);
        pnTabListaLayout.setHorizontalGroup(
            pnTabListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTabListaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(scroll_tb_ItensVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );
        pnTabListaLayout.setVerticalGroup(
            pnTabListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTabListaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(scroll_tb_ItensVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        pnVenda2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Valor Venda"));
        pnVenda2.setOpaque(false);
        pnVenda2.setLayout(new java.awt.CardLayout());

        lbTotalVenda.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbTotalVenda.setForeground(new java.awt.Color(153, 0, 51));
        lbTotalVenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotalVenda.setText("R$");
        lbTotalVenda.setToolTipText("Total da compra.");
        pnVenda2.add(lbTotalVenda, "card2");

        pnBotao.setOpaque(false);

        btnConfirmar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/ok_Pqn_32.png"))); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setToolTipText("Confirma venda.");
        btnConfirmar.setIconTextGap(2);
        btnConfirmar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/cancelar_02_Pqn_32.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancela venda.");
        btnCancelar.setIconTextGap(2);
        btnCancelar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAdicionarItem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAdicionarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/itemAdd_Pqn_32.png"))); // NOI18N
        btnAdicionarItem.setText("Adicionar");
        btnAdicionarItem.setToolTipText("Pesquisa itens para adicionar a lista.");
        btnAdicionarItem.setIconTextGap(2);
        btnAdicionarItem.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemActionPerformed(evt);
            }
        });

        btnRemoverItem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRemoverItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/32/itemRemove_Pqn_32.png"))); // NOI18N
        btnRemoverItem.setText("Remover");
        btnRemoverItem.setToolTipText("Remove um item da lista.");
        btnRemoverItem.setIconTextGap(2);
        btnRemoverItem.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotaoLayout = new javax.swing.GroupLayout(pnBotao);
        pnBotao.setLayout(pnBotaoLayout);
        pnBotaoLayout.setHorizontalGroup(
            pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pnBotaoLayout.setVerticalGroup(
            pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotaoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnFundoLayout = new javax.swing.GroupLayout(pnFundo);
        pnFundo.setLayout(pnFundoLayout);
        pnFundoLayout.setHorizontalGroup(
            pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTabLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnFundoLayout.createSequentialGroup()
                        .addComponent(pnVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(pnVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFundoLayout.createSequentialGroup()
                        .addComponent(pnVenda2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );
        pnFundoLayout.setVerticalGroup(
            pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(pnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnTabLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnVenda2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        setBounds(0, 0, 718, 509);
    }// </editor-fold>//GEN-END:initComponents

    //==========================================================================
    private void btnPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarClienteActionPerformed
        Tela_Pesquisa_Cliente tela = new Tela_Pesquisa_Cliente(null, idPermissao);
        tela.setVisible(true);

        int idFound = Tela_Pesquisa_Cliente.getIdFound();
        list_Clientes = Tela_Pesquisa_Cliente.getList_Clientes();

        if (idFound > 0) {
            Cliente cliente = new Cliente();
            cliente = list_Clientes.get(idFound - 1);

            txtCodigoCliente.setText(Integer.toString(cliente.getId()));
            txtNomeCliente.setText(cliente.getNome());
            txtTelefoneCliente.setText(cliente.getTelefone());
        }
    }//GEN-LAST:event_btnPesquisarClienteActionPerformed

    //==========================================================================
    private void btnAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarItemActionPerformed
        Tela_Pesquisa_Produto_Venda tela = new Tela_Pesquisa_Produto_Venda(null, idPermissao);
        tela.setVisible(true);

        list_Id_Qtd = tela.getList_Id_Qtd();
        loadTable(list_Id_Qtd);
    }//GEN-LAST:event_btnAdicionarItemActionPerformed

    //==========================================================================
    private void btnRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverItemActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) tb_ItensVenda.getModel();

        if (tb_ItensVenda.getSelectedRow() > 0) {
            tabela.removeRow(tb_ItensVenda.getSelectedRow());

            calcTotal();
            enableButton();
        } else {
            Tools_Message.showErrorMessageValidation("Nenhum item selecionado.");
        }


    }//GEN-LAST:event_btnRemoverItemActionPerformed

    //==========================================================================
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        dispose();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    //==========================================================================
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnPesquisarCliente;
    private javax.swing.JButton btnRemoverItem;
    private javax.swing.JLabel lbCodigoCliente;
    private javax.swing.JLabel lbCodigoVenda;
    private javax.swing.JLabel lbCodigoVendedor;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbNomeCliente;
    private javax.swing.JLabel lbNomeVendedor;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbTelefoneCliente;
    private javax.swing.JLabel lbTotalVenda;
    private javax.swing.JPanel pnBotao;
    private javax.swing.JPanel pnCliente;
    private javax.swing.JPanel pnFundo;
    private javax.swing.JPanel pnStatusBar;
    private javax.swing.JPanel pnTabLista;
    private javax.swing.JPanel pnVenda1;
    private javax.swing.JPanel pnVenda2;
    private javax.swing.JPanel pnVendedor;
    private javax.swing.JScrollPane scroll_tb_ItensVenda;
    private javax.swing.JTable tb_ItensVenda;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtCodigoVenda;
    private javax.swing.JTextField txtCodigoVendedor;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeVendedor;
    private javax.swing.JFormattedTextField txtTelefoneCliente;
    // End of variables declaration//GEN-END:variables
//==============================================================================
    /**/

    //==========================================================================
    private void readUser() {
        txtCodigoVendedor.setText(Integer.toString(userLogado.getId()));
        txtNomeVendedor.setText(userLogado.getNome());
    }

    //==========================================================================
    public static void addItemTable(String dado) {
        int i = 1;
        int b = 5;
        Tela_Nova_Venda nn = new Tela_Nova_Venda();
        String sss = dado;
        nn.txtNomeVendedor.setText("dddd");
    }

//==========================================================================
    // carrega a tabela com a lista informada
    private void loadTable(ArrayList<Integer[]> list) {

        DefaultTableModel tabela = (DefaultTableModel) tb_ItensVenda.getModel();
//        tabela.setNumRows(0); // limpa, para evitar exibir dado duplicado ao inserir dados

        tb_ItensVenda.setRowSorter(new TableRowSorter(tabela)); // para habilitar ordenar atravéz de clique nas colunas da tabala

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();// para colocar a coluna centralizada
        center.setHorizontalAlignment(SwingConstants.CENTER);

        tb_ItensVenda.getColumnModel().getColumn(0).setCellRenderer(center);
        tb_ItensVenda.getColumnModel().getColumn(2).setCellRenderer(center);
        tb_ItensVenda.getColumnModel().getColumn(3).setCellRenderer(center);
        tb_ItensVenda.getColumnModel().getColumn(4).setCellRenderer(center);

        int tamList = list_Id_Qtd.size();

        // adiciona lista produtos à tabela
        for (int i = 0; i < tamList; i++) {

            Integer[] dados = new Integer[2];
            dados = list.get(i);

            int id = dados[0];
            int qtd = dados[1];

            Produto produto = ProdutoDAO.readID(id);

            tabela.addRow(new Object[]{
                produto.getId(),
                produto.getNome(),
                qtd,
                produto.getPreco(),
                qtd * produto.getPreco()

            });

        } // fim for

        calcTotal();
        enableButton();

    } // fim loadTable

    //==========================================================================
    // habilita botão
    private void enableButton() {
        if (tb_ItensVenda.getRowCount() > 0) {
            btnConfirmar.setEnabled(true);
            btnRemoverItem.setEnabled(true);
        }
    }

    //==========================================================================
    // calcula total
    private void calcTotal() {
        DefaultTableModel tabela = (DefaultTableModel) tb_ItensVenda.getModel();

        int tamTable = tabela.getRowCount();
        double total = 0;

        for (int i = 0; i < tamTable; i++) {
            total += Double.parseDouble(tabela.getValueAt(i, 4).toString());
        }
        lbTotalVenda.setText("R$" + Double.toString(total));
    }

    //==========================================================================
    // seta icones nos botões
    private void setIcones() {
        String path = "/view/_images/32/";
        String ext = ".png";

        btnAdicionarItem.setPressedIcon(btnAdicionarItem.getIcon());
        btnAdicionarItem.setRolloverIcon(Tools.setIcon("itemAdd_Gnd_32", ext, path));

        btnRemoverItem.setPressedIcon(btnRemoverItem.getIcon());
        btnRemoverItem.setRolloverIcon(Tools.setIcon("itemRemove_Gnd_32", ext, path));

        btnConfirmar.setPressedIcon(btnConfirmar.getIcon());
        btnConfirmar.setRolloverIcon(Tools.setIcon("ok_Gnd_32", ext, path));

        btnCancelar.setPressedIcon(btnCancelar.getIcon());
        btnCancelar.setRolloverIcon(Tools.setIcon("cancelar_02_Gnd_32", ext, path));

        btnPesquisarCliente.setPressedIcon(btnPesquisarCliente.getIcon());
        btnPesquisarCliente.setRolloverIcon(Tools.setIcon("procurar_Gnd_32", ext, path));

    }

} // fim class
