/**/
package view;

import model.bean.Usuario;
import view._util.*;
import view.cliente.Tela_Cadastro_Cliente;
import view.cliente.Tela_Pesquisa_Cliente;
import view.fornecedor.*;
import view.geral.*;
import view.produto.Tela_Cadastro_Produto;
import view.produto.Tela_Pesquisa_Produto_Venda;
import view.usuario.*;
import view.venda.Tela_Nova_Venda;

public class Tela_Principal extends javax.swing.JFrame {

    // permissões:
    // 0 = visistantes
    // 1 = administradores
    // 2 = usuários
    private static int idPermissao = 0; // controle de permissão de usuário
    private boolean permAdm = false;
    private boolean permUser = false;

    public static int getIdPermissao() {
        return idPermissao;
    }

    private static Usuario userLogado = null;

    public static void setUserLogado(Usuario userLogado) {
        Tela_Principal.userLogado = userLogado;
    }

    // controle da abertura inicial do form
    private static boolean mainFormLoad = false;

    //==========================================================================
    public Tela_Principal() {
        initComponents();

        //---------------------------------------------
        // aqui tela splash
        exibeLogin(); //tela login

        //---------------------------------------------
        setExtendedState(MAXIMIZED_BOTH); // inicia maximizado
        this.setMinimumSize(this.getPreferredSize()); // define tamanho minimo do form

        //---------------------------------------------
        // seta ícone para o form
        Tools_SetIcon.setIcon(this, "/view/_images/geral/icone_sistema.png");
        // aplica um fundo à área de trabalho
        Tools_SetFundoPainel.carregaImagem(pnAreaTrabalho, "/view/_images/geral/fundo_trabalho.jpg");

        setPermissoes(); // seta permissões de usuário (antes de setPermissoes)
        refreshSystem();

//        new Date(System.currentTimeMillis());
        lb_Data.setText(Tools_Texts.getDataAtual());

        //---------------------------------------------
        // indica que tela principal foi aberta
//        mainFormLoad = true; // (deve ser executado no final, pelo menos após exibir a tela de login)
    }

    //==========================================================================
    // permissões
    private void setPermissoes() {
        permAdm = idPermissao == 1;
        permUser = idPermissao == 2;
    }

//==============================================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnAreaTrabalho = new javax.swing.JDesktopPane();
        pn_StatusBar = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lb_Nivel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lb_Codigo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lb_Nome = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lb_Data = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        menuBarra = new javax.swing.JMenuBar();
        menu_Inicio = new javax.swing.JMenu();
        menuSub1_Usuario = new javax.swing.JMenu();
        menuSub2_PesquisaUsuario = new javax.swing.JMenuItem();
        menuSub2_CadastroUsuario = new javax.swing.JMenuItem();
        sepSub1_Inicio = new javax.swing.JPopupMenu.Separator();
        menuSub2_AlteraLoginSenha = new javax.swing.JMenuItem();
        sep1_Inicio = new javax.swing.JPopupMenu.Separator();
        menu_LogInOff = new javax.swing.JMenuItem();
        sep2_Inicio = new javax.swing.JPopupMenu.Separator();
        menu_Sair = new javax.swing.JMenuItem();
        menu_Venda = new javax.swing.JMenu();
        menuSub1_NovaVenda = new javax.swing.JMenuItem();
        menu_Consulta = new javax.swing.JMenu();
        menuSub1_ConsultaProduto = new javax.swing.JMenuItem();
        menuSub1_ConsultaCliente = new javax.swing.JMenuItem();
        menuSub1_ConsultaFornecedor = new javax.swing.JMenuItem();
        menu_Cadastro = new javax.swing.JMenu();
        menuSub1_CadastroProduto = new javax.swing.JMenuItem();
        menuSub1_CadastroCliente = new javax.swing.JMenuItem();
        menuSub1_CadastroFornecedor = new javax.swing.JMenuItem();
        menu_Ajuda = new javax.swing.JMenu();
        menuSub1_Sobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FACSIS");
        setName("frm_TelaPrincipal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(750, 450));
        setSize(new java.awt.Dimension(0, 200));

        pnAreaTrabalho.setBackground(new java.awt.Color(63, 87, 124));

        javax.swing.GroupLayout pnAreaTrabalhoLayout = new javax.swing.GroupLayout(pnAreaTrabalho);
        pnAreaTrabalho.setLayout(pnAreaTrabalhoLayout);
        pnAreaTrabalhoLayout.setHorizontalGroup(
            pnAreaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        pnAreaTrabalhoLayout.setVerticalGroup(
            pnAreaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.CardLayout());

        lb_Nivel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_Nivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Nivel.setText("Nonononon");
        jPanel1.add(lb_Nivel, "card2");

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new java.awt.CardLayout());

        lb_Codigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_Codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Codigo.setText("00000");
        jPanel2.add(lb_Codigo, "card2");

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new java.awt.CardLayout());

        lb_Nome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_Nome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Nome.setText("Nonon Nononon no Nonon");
        jPanel3.add(lb_Nome, "card2");

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new java.awt.CardLayout());

        lb_Data.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Data.setText("00/00/0000");
        jPanel4.add(lb_Data, "card2");

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pn_StatusBarLayout = new javax.swing.GroupLayout(pn_StatusBar);
        pn_StatusBar.setLayout(pn_StatusBarLayout);
        pn_StatusBarLayout.setHorizontalGroup(
            pn_StatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_StatusBarLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_StatusBarLayout.setVerticalGroup(
            pn_StatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menu_Inicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        menu_Inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/home_Gnd_24.png"))); // NOI18N
        menu_Inicio.setText("       Início       ");
        menu_Inicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_Inicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_Inicio.setIconTextGap(0);
        menu_Inicio.setMargin(new java.awt.Insets(0, 0, 2, 0));
        menu_Inicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        menuSub1_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/usuario_Gnd_24.png"))); // NOI18N
        menuSub1_Usuario.setText("Usuário");

        menuSub2_PesquisaUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/usuario_consulta_Gnd_24.png"))); // NOI18N
        menuSub2_PesquisaUsuario.setText("Pesquisa");
        menuSub2_PesquisaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSub2_PesquisaUsuarioActionPerformed(evt);
            }
        });
        menuSub1_Usuario.add(menuSub2_PesquisaUsuario);

        menuSub2_CadastroUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/usuario_cadastro_Gnd_24.png"))); // NOI18N
        menuSub2_CadastroUsuario.setText("Cadastro");
        menuSub2_CadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSub2_CadastroUsuarioActionPerformed(evt);
            }
        });
        menuSub1_Usuario.add(menuSub2_CadastroUsuario);
        menuSub1_Usuario.add(sepSub1_Inicio);

        menuSub2_AlteraLoginSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/usuario_cadastro_Gnd_24.png"))); // NOI18N
        menuSub2_AlteraLoginSenha.setText("Alterar Login / Senha");
        menuSub2_AlteraLoginSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSub2_AlteraLoginSenhaActionPerformed(evt);
            }
        });
        menuSub1_Usuario.add(menuSub2_AlteraLoginSenha);

        menu_Inicio.add(menuSub1_Usuario);
        menu_Inicio.add(sep1_Inicio);

        menu_LogInOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/logInOut_Gnd_24.png"))); // NOI18N
        menu_LogInOff.setText("Log In");
        menu_LogInOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_LogInOffActionPerformed(evt);
            }
        });
        menu_Inicio.add(menu_LogInOff);
        menu_Inicio.add(sep2_Inicio);

        menu_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/sair_Gnd_24.png"))); // NOI18N
        menu_Sair.setText(" Sair");
        menu_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_SairActionPerformed(evt);
            }
        });
        menu_Inicio.add(menu_Sair);

        menuBarra.add(menu_Inicio);

        menu_Venda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/venda_Gnd_24.png"))); // NOI18N
        menu_Venda.setText("       Venda       ");
        menu_Venda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_Venda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_Venda.setIconTextGap(0);
        menu_Venda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        menuSub1_NovaVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/venda_nova_Gnd_24.png"))); // NOI18N
        menuSub1_NovaVenda.setText("   Nova   ");
        menuSub1_NovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSub1_NovaVendaActionPerformed(evt);
            }
        });
        menu_Venda.add(menuSub1_NovaVenda);

        menuBarra.add(menu_Venda);

        menu_Consulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/consulta_Gnd_24.png"))); // NOI18N
        menu_Consulta.setText("       Consulta       ");
        menu_Consulta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_Consulta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_Consulta.setIconTextGap(0);
        menu_Consulta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        menuSub1_ConsultaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/produto_consulta_Gnd_24.png"))); // NOI18N
        menuSub1_ConsultaProduto.setText("Produto");
        menuSub1_ConsultaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSub1_ConsultaProdutoActionPerformed(evt);
            }
        });
        menu_Consulta.add(menuSub1_ConsultaProduto);

        menuSub1_ConsultaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/cliente_consulta_Gnd_24.png"))); // NOI18N
        menuSub1_ConsultaCliente.setText("Cliente");
        menuSub1_ConsultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSub1_ConsultaClienteActionPerformed(evt);
            }
        });
        menu_Consulta.add(menuSub1_ConsultaCliente);

        menuSub1_ConsultaFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/fornecedor_consulta_Gnd_24.png"))); // NOI18N
        menuSub1_ConsultaFornecedor.setText("Fornecedor");
        menuSub1_ConsultaFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSub1_ConsultaFornecedorActionPerformed(evt);
            }
        });
        menu_Consulta.add(menuSub1_ConsultaFornecedor);

        menuBarra.add(menu_Consulta);

        menu_Cadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/cadastro_Gnd_24.png"))); // NOI18N
        menu_Cadastro.setText("       Cadastro       ");
        menu_Cadastro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_Cadastro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_Cadastro.setIconTextGap(0);
        menu_Cadastro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        menuSub1_CadastroProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/produto_cadastro_Gnd_24.png"))); // NOI18N
        menuSub1_CadastroProduto.setText("Produto");
        menuSub1_CadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSub1_CadastroProdutoActionPerformed(evt);
            }
        });
        menu_Cadastro.add(menuSub1_CadastroProduto);

        menuSub1_CadastroCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/cliente_cadastro_Gnd_24.png"))); // NOI18N
        menuSub1_CadastroCliente.setText("Cliente");
        menuSub1_CadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSub1_CadastroClienteActionPerformed(evt);
            }
        });
        menu_Cadastro.add(menuSub1_CadastroCliente);

        menuSub1_CadastroFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/fornecedor_cadastro_Gnd_24.png"))); // NOI18N
        menuSub1_CadastroFornecedor.setText("Fornecedor");
        menuSub1_CadastroFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSub1_CadastroFornecedorActionPerformed(evt);
            }
        });
        menu_Cadastro.add(menuSub1_CadastroFornecedor);

        menuBarra.add(menu_Cadastro);

        menu_Ajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/ajuda_Gnd_24.png"))); // NOI18N
        menu_Ajuda.setText("       Ajuda       ");
        menu_Ajuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_Ajuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_Ajuda.setIconTextGap(0);
        menu_Ajuda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        menuSub1_Sobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/_images/24/info_Gnd_24.png"))); // NOI18N
        menuSub1_Sobre.setText("Sobre");
        menuSub1_Sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSub1_SobreActionPerformed(evt);
            }
        });
        menu_Ajuda.add(menuSub1_Sobre);

        menuBarra.add(menu_Ajuda);

        setJMenuBar(menuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_StatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnAreaTrabalho)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnAreaTrabalho)
                .addGap(0, 0, 0)
                .addComponent(pn_StatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //==========================================================================
    //      AÇÕES DO MENU
    //==========================================================================
    // exibe a tela de alteraR login/senha
    private void menuSub2_AlteraLoginSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSub2_AlteraLoginSenhaActionPerformed
        Tela_Alterar_LoginSenha tela = new Tela_Alterar_LoginSenha(this, true);
        tela.setVisible(true);

        refreshSystem();
    }//GEN-LAST:event_menuSub2_AlteraLoginSenhaActionPerformed

    private void menuSub2_PesquisaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSub2_PesquisaUsuarioActionPerformed
        Tela_Pesquisa_Usuario tela = new Tela_Pesquisa_Usuario(this, true, idPermissao);
        tela.setVisible(true);
    }//GEN-LAST:event_menuSub2_PesquisaUsuarioActionPerformed

    private void menuSub2_CadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSub2_CadastroUsuarioActionPerformed
        Tela_Cadastro_Usuario tela = new Tela_Cadastro_Usuario(this, true, idPermissao);
        tela.setVisible(true);
    }//GEN-LAST:event_menuSub2_CadastroUsuarioActionPerformed

    private void menu_LogInOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_LogInOffActionPerformed

        // se não houver usuário conectado...
        if (userLogado.getId() < 1) {

            // exibe login
            exibeLogin();
            refreshSystem();

        } else {

            // faz logout, atualizando o usuário como visitante
            idPermissao = 0;
            userLogado.setId(0);
            refreshSystem();
            menu_LogInOff.setText("Log In");
//            menu_LogInOff.setIcon(Tools.setIcon("logOff_Gnd_24", "png", "/view/_images/24/"));
//            menu_LogInOff.seti

        }
    }//GEN-LAST:event_menu_LogInOffActionPerformed

    private void menu_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_SairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menu_SairActionPerformed

    private void menuSub1_NovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSub1_NovaVendaActionPerformed
        Tela_Nova_Venda tela = new Tela_Nova_Venda(userLogado, idPermissao);
//        Tools_InternalFrame.showMazimized(tela, pnAreaTrabalho);
        Tools_InternalFrame.showCentralized(tela, pnAreaTrabalho);
    }//GEN-LAST:event_menuSub1_NovaVendaActionPerformed

    private void menuSub1_ConsultaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSub1_ConsultaProdutoActionPerformed
//        Tela_Pesquisa_Produto tela = new Tela_Pesquisa_Produto(this, true, idPermissao);
        Tela_Pesquisa_Produto_Venda tela = new Tela_Pesquisa_Produto_Venda(this, true, idPermissao);
        tela.setVisible(true);
    }//GEN-LAST:event_menuSub1_ConsultaProdutoActionPerformed

    private void menuSub1_ConsultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSub1_ConsultaClienteActionPerformed
        Tela_Pesquisa_Cliente tela = new Tela_Pesquisa_Cliente(this, true, idPermissao);
        tela.setVisible(true);
    }//GEN-LAST:event_menuSub1_ConsultaClienteActionPerformed

    private void menuSub1_ConsultaFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSub1_ConsultaFornecedorActionPerformed
        Tela_Pesquisa_Fornecedor tela = new Tela_Pesquisa_Fornecedor(this, true, idPermissao);
        tela.setVisible(true);
    }//GEN-LAST:event_menuSub1_ConsultaFornecedorActionPerformed

    private void menuSub1_CadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSub1_CadastroProdutoActionPerformed
        Tela_Cadastro_Produto tela = new Tela_Cadastro_Produto(this, true, idPermissao);
        tela.setVisible(true);
    }//GEN-LAST:event_menuSub1_CadastroProdutoActionPerformed

    private void menuSub1_CadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSub1_CadastroClienteActionPerformed
        Tela_Cadastro_Cliente tela = new Tela_Cadastro_Cliente(this, true, idPermissao);
        tela.setVisible(true);
    }//GEN-LAST:event_menuSub1_CadastroClienteActionPerformed

    private void menuSub1_CadastroFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSub1_CadastroFornecedorActionPerformed
        Tela_Cadastro_Fornecedor tela = new Tela_Cadastro_Fornecedor(this, true, idPermissao);
        tela.setVisible(true);
    }//GEN-LAST:event_menuSub1_CadastroFornecedorActionPerformed

    private void menuSub1_SobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSub1_SobreActionPerformed
        Tela_Sobre tela = new Tela_Sobre(this, true);
        tela.setVisible(true);
    }//GEN-LAST:event_menuSub1_SobreActionPerformed

//==============================================================================
// Main
    public static void main(String args[]) {

        try {
            // GTK+
            // Windows
            // Nimbus
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Tela_Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lb_Codigo;
    private javax.swing.JLabel lb_Data;
    private javax.swing.JLabel lb_Nivel;
    private javax.swing.JLabel lb_Nome;
    private javax.swing.JMenuBar menuBarra;
    private javax.swing.JMenuItem menuSub1_CadastroCliente;
    private javax.swing.JMenuItem menuSub1_CadastroFornecedor;
    private javax.swing.JMenuItem menuSub1_CadastroProduto;
    private javax.swing.JMenuItem menuSub1_ConsultaCliente;
    private javax.swing.JMenuItem menuSub1_ConsultaFornecedor;
    private javax.swing.JMenuItem menuSub1_ConsultaProduto;
    private javax.swing.JMenuItem menuSub1_NovaVenda;
    private javax.swing.JMenuItem menuSub1_Sobre;
    private javax.swing.JMenu menuSub1_Usuario;
    private javax.swing.JMenuItem menuSub2_AlteraLoginSenha;
    private javax.swing.JMenuItem menuSub2_CadastroUsuario;
    private javax.swing.JMenuItem menuSub2_PesquisaUsuario;
    private javax.swing.JMenu menu_Ajuda;
    private javax.swing.JMenu menu_Cadastro;
    private javax.swing.JMenu menu_Consulta;
    private javax.swing.JMenu menu_Inicio;
    private javax.swing.JMenuItem menu_LogInOff;
    private javax.swing.JMenuItem menu_Sair;
    private javax.swing.JMenu menu_Venda;
    public static javax.swing.JDesktopPane pnAreaTrabalho;
    private javax.swing.JPanel pn_StatusBar;
    private javax.swing.JPopupMenu.Separator sep1_Inicio;
    private javax.swing.JPopupMenu.Separator sep2_Inicio;
    private javax.swing.JPopupMenu.Separator sepSub1_Inicio;
    // End of variables declaration//GEN-END:variables
//==============================================================================

    //==========================================================================
    // atualiza sistema conforme alteração de usuário
    private void refreshSystem() {

        // se não tem usuário logado, ou visitante...
        if (userLogado.getId() < 1) {

            // seta o log como visitante
            userLogado.setId(0);
            userLogado.setNome("Visitante");
            userLogado.setNivelAcesso("Visitante");
            userLogado.setLogin(null);
            userLogado.setSenha(null);
        } else {

            if ("Administrador".equals(userLogado.getNivelAcesso())) {
                idPermissao = 1;
            } else {
                idPermissao = 2;
            }

            permAdm = idPermissao == 1;
            permUser = idPermissao == 2;
        }

        //-----------------------------------------------------
        lb_Nivel.setText(userLogado.getNivelAcesso());
        lb_Codigo.setText(Integer.toString(userLogado.getId()));
        lb_Nome.setText(userLogado.getNome());

    }

//    //==========================================================================
//    // controle login/logout - atuaziza o sistema conforme o usuario
//    private void refreshUser() {
////
//    }
//
//    //==========================================================================
//    // seta usuário logado na barra de status
//    private void setLoginStatus() {
//
//    }
    //==========================================================================
    // exibe a tela de login
    private void exibeLogin() {
        Tela_Login tela = new Tela_Login(this, true);
        tela.setVisible(true);
//        userLogado = tela.getUserLogin();

        menu_LogInOff.setText(userLogado.getId() > 0 ? "Log Off" : "Log In");

//        String img = "Log Off".equals(menu_LogInOff.getText()) ? "logOff_Gnd_24" : "logIn_Gnd_24";
//        menu_LogInOff.setIcon(Tools.setIcon(img, "png", "/view/_images/24/"));
    }

    //==========================================================================
    // getters
    public static boolean getmainFormLoad() {
        return mainFormLoad;
    }

    public static Usuario getUserLogado() {
        return userLogado;
    }

} // fim class
