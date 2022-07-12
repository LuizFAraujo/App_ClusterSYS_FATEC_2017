/**/
package view._util;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Tools_Tables {

    //==========================================================================
    // atualiza um label com a contagem de registros
    public static String refreshCount(JTable table) {
        String msg;
        int num = table.getRowCount();

        switch (num) {
            case 0:
                msg = "Nenhum registro encontrado.";
                break;

            case 1:
                msg = "Um registro encontrado.";
                break;

            case 2:
                msg = "Dois registros encontrados.";
                break;

            case 3:
                msg = "Três registros encontrados.";
                break;

            default:
                msg = Integer.toString(num) + " resgistros encontrados.";
        }

        return msg;
    } // fim refreshCount

    //==========================================================================
    // faz com que a tabela suba e desça ao teclar UP ou DOWN do teclado
    public static void valueChangedScrollTable(JTable table) {

        ListSelectionModel sel = table.getSelectionModel();

        sel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                table.scrollRectToVisible(table.getCellRect(table.getSelectedRow(), 0, true));
            }
        });

    } // valueChangedScrollTable

//    //==========================================================================
//    // listener
//    public static void keyUpDownFrame(Frame frame) {
//        
//        frame.addKeyListener(new KeyListener() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                //
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                //
//            }
//
//            @Override
//            public void keyTyped(KeyEvent e) {
//                //
//            }
//        });
//
//    }
} // fim class

//
//
//
//
//
//
//    //==========================================================================
//    // atualiza e carrega a lista de pequisa
//    public void loadSearchTable(String search, List list_Search, List list_Main, int option) {
//
//        list_Search.clear(); // apaga toda a lista, ante de carregar novamente
//
//        for (int i = 0; i < list_Main.size(); i++) {
//
////            int coluna = list_Main.
//            String lineUser = "";
////            String lineUser = list_Main.get(i).getNome().toUpperCase();
//            search = search.toUpperCase();
//
//            //---------------------------------------------------------
//            // opção de seleção de filtro
////            int op = 0;
////            if (ckComeca.isSelected() && ckTermina.isSelected()) {
////                op = 1; // "começa com" e "termina com" (ou seja, em qualquer posição)
////            } else if (ckComeca.isSelected() && !ckTermina.isSelected()) {
////                op = 2; // pesquisar nome que "começa com"
////            } else if (!ckComeca.isSelected() && ckTermina.isSelected()) {
////                op = 3; // pesquisar nome que "termina com"
////            }
//            //---------------------------------------------------------
//            switch (option) {
//                case 1:
//                    // se a pesquisa for uma substring da linha pesquisada
//                    if (lineUser.contains(search)) {
//                        list_Search.add(list_Main.get(i)); // adiciona na lista de pesquisa
//                    }
//                    break;
//
//                case 2:
//                    // se a pesquisa estiver no começo da linha pesquisada
//                    if (lineUser.indexOf(search) == 0) {
//                        list_Search.add(list_Main.get(i));
//                    }
//                    break;
//
//                case 3:
//                    int posSpc = lineUser.lastIndexOf(" "); // posição do ultimo espaço
//
//                    // se a pesquisa estiver no fim da linha pesquisada
//                    if (lineUser.lastIndexOf(search) == posSpc + 1) {
//                        list_Search.add(list_Main.get(i));
//                    }
//                    break;
//            }
//
//        } // fim for
//
////        loadTable(list_Search); // carrega a tabela com a lista de pesquisa
////        refreshCount();
//    }
//
//
//
//
//    //==========================================================================
//    // aponta para a linha onde se encontra o resultado, ao estar digitando
//    public static void goToBusca(String busca, JTable tabela) {
//
//        int coluna = 1; // n da coluna onde se encontra o texto a ser localizado. 
//
//        for (int i = 0; i < tabela.getRowCount(); i++) {
//
//            String linha = String.valueOf(tabela.getValueAt(i, coluna)).toUpperCase();
//            busca = busca.toUpperCase();
//
////            int res = linha.indexOf(busca);
//            if (linha.contains(busca)) {
//                tabela.setRowSelectionInterval(i, i);
//                return;
//            }
//
//        } // fim for
//
//    }
