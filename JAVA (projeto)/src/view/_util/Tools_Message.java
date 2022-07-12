/*

 */
package view._util;

import javax.swing.JOptionPane;

public class Tools_Message {

    private static String spc = "   "; // espaço no título

    //==========================================================================
    // exibe informação de "sucesso" ao atualizar um registro
    public static void showUpdateMessage() {
        JOptionPane.showMessageDialog(null,
                "      " + "Atualizado com sucesso.", // mensagem
                spc + "Informação", // título
                JOptionPane.INFORMATION_MESSAGE); // ícone
    }

    //==========================================================================
    // exibe informação de "sucesso" ao excluir um registro
    public static void showDeleteMessage() {
        JOptionPane.showMessageDialog(null,
                "      " + "Excluído com sucesso.", // mensagem
                spc + "Informação", // título
                JOptionPane.INFORMATION_MESSAGE); // ícone
    }

    //==========================================================================
    // exibe informação de erro ao tentar validar
    public static void showErrorMessageValidation(String mensagem) {
        JOptionPane.showMessageDialog(null,
                mensagem,
                spc + "Erro ao validar!", // título
                JOptionPane.WARNING_MESSAGE); // ícone
    }

    //==========================================================================
    // exibe mensagem para confirmação de exclusão
    public static boolean showConfirmDelete() {
        // opções de botão
        Object[] options = {"Sim", "Cancelar"};

        int resp = JOptionPane.showOptionDialog(
                null,
                "Deseja mesmo excluir este registro?",
                spc + "Confirmação",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        return resp == 0; // se for 0, retorna true
    }

}
