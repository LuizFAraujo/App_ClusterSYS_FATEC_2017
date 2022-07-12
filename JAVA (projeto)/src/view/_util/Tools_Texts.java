/*
clearTextsContainer
checkTxtNull
returnTxtNull
checkAllTxtNull
validaEspacoLateral
 */
package view._util;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class Tools_Texts {

    //==========================================================================
    // varre e limpa todas caixas de texto de um Container
    public static void clearTextsContainer(Container painelContainer) {

        for (int i = 0; i < painelContainer.getComponentCount(); i++) {

            Component c = painelContainer.getComponent(i);

            if (c instanceof JTextField) { // se for uma caixa de texto...
                ((JTextField) c).setText(null);
            }
        } // fim if
    } // fim clearTextsContainer

    //==========================================================================
    // checagem de preenchimento de JTextField num Container
    public static boolean checkTxtNull(Container container) {

        for (int i = 0; i < container.getComponentCount(); i++) {

            Component c = container.getComponent(i);

            if (c instanceof JTextField) {
                JTextField txt = (JTextField) c;

                // se campo vazio...
                if ("".equals(txt.getText().trim())) {
                    return false;
                }
            }
        }

        return true;
    }

    //==========================================================================
    // checagem de preenchimento de JTextField num Container
    // com lista a ignorar
    public static Object returnTxtNull(Container container, String[] ignore) {

        for (int i = 0; i < container.getComponentCount(); i++) {

            String nameCompNull = null;
            Component comp = container.getComponent(i);

            //----------------------------------------
            // JTextField
            if (comp instanceof JTextField) {
                JTextField txt = (JTextField) comp;

                if ("".equals(txt.getText().trim())) {
//                    return comp;
                    nameCompNull = comp.getName();
                }

            } else { //

                //----------------------------------------
                // JPasswordField
                if (comp instanceof JPasswordField) {
                    JPasswordField txt = (JPasswordField) comp;

                    if ("".equals(Arrays.toString(txt.getPassword()).trim())) {
//                        return comp;
                        nameCompNull = comp.getName();
                    }
                }

            }

            //------------------------------------------------------------
            // verifica se nome componente nulo esta na lista de ignorados
            if (nameCompNull != null) {

                for (int k = 0; k <= ignore.length - 1; k++) {

                    // se houver lista de ignorados, faz chegagem
                    if (ignore.length > 0) {
                        String nameIgnore = ignore[k];

                        // retorna o componente somente se não tiver na lista
                        if (!nameCompNull.equals(nameIgnore)) {
                            return comp;
                        }
                    } else { // senão retorna o componente
                        return comp;
                    }
                }
            }

        } // fim for

        return null;
    }

    //==========================================================================
    // checagem de preenchimento de JTextField num Container
    public static Object returnTxtNull_bkp(Container container) {

        for (int i = 0; i < container.getComponentCount(); i++) {

            Component comp = container.getComponent(i);

            //----------------------------------------
            // JTextField
            if (comp instanceof JTextField) {
                JTextField txt = (JTextField) comp;

                if ("".equals(txt.getText().trim())) {
                    return comp;
                }

            } else { //

                //----------------------------------------
                // JPasswordField
                if (comp instanceof JPasswordField) {
                    JPasswordField txt = (JPasswordField) comp;

                    if ("".equals(Arrays.toString(txt.getPassword()).trim())) {
                        return comp;
                    }
                }

            }

        } // fim for

        return null;
    }

    //==========================================================================
    //==========================================================================
    // avisa sobre intem não preenchido e posiciona o cursor no objeto
    public static void goToNullObject(Object obj) {

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

        // posiciona o cursor no objeto
        if (obj instanceof JTextField) {
            JTextField txt = (JTextField) obj;
            txt.requestFocus();
        } else {
            JPasswordField txt = (JPasswordField) obj;
            txt.requestFocus();
        }

    }

    //==========================================================================
    // retorna o nome do objeto nulo
    public static String getNameNullObject(Object obj) {

        String name = null;

        // pega o nome do objeto (que, no caso, esta com o mesmo titulo do label)
        if (obj instanceof JTextField) {
            JTextField txt = (JTextField) obj;
            name = txt.getName();
        } else {
            JPasswordField txt = (JPasswordField) obj;
            name = txt.getName();
        }

        return name;
    }

    //==========================================================================
    // checagem em cascado de preenchimento de JTextField em Containers
    public static boolean checkAllTxtNull(Container container) {

        for (int i = 0; i < container.getComponentCount(); i++) {

            Component c = container.getComponent(i);

            if (c instanceof JTextField) {
                JTextField txt = (JTextField) c;

                // se campo vazio...
                if ("".equals(txt.getText().trim())) {
                    return false;
                }
            } //
            //*********************************************************************
            // checar funcinamento com Container (verificar se funciona desta forma)
            // se não funcionar, fazer um switch, e ao invés usar Container, usar
            // JPanel e outros do tipo Container
            // obs: desta forma abaixo não testado, testado apenas na de cima com um Container
            else if (c instanceof Container) {
                checkTxtNull((Container) c);
            }
        }

        return true;
    }

    //==========================================================================
    // verifica e valida se um Container contêm JTextField e/ou
    // JPasswordField com espaçamento lateral
    // false = não permitido
    // true = validado
    public static boolean validaEspacoLateral(Container container) {

        for (int i = 0; i < container.getComponentCount(); i++) {

            Component comp = container.getComponent(i); // pega o componente container

            //----------------------------------------
            // JTextField
            if (comp instanceof JTextField) {
                JTextField txt = (JTextField) comp;
                if (!validaEspacoLateral(txt)) {
                    return false;
                }
            } else { //
                //----------------------------------------
                // JPasswordField
                if (comp instanceof JPasswordField) {
                    JPasswordField txt = (JPasswordField) comp;
                    if (!validaEspacoLateral(txt)) {
                        return false;
                    }
                }

            }
        }

        return true;
    } // validaEspacoLateral Container

    //--------------------------------------------------------------------------
    // verifica e valida se um JTextField contêm espaçamento lateral
    // false = não permitido
    // true = validado
    public static boolean validaEspacoLateral(JTextField txt) {
        String str1 = txt.getText().trim();
        String str2 = txt.getText();

        return (str1.equals(str2));
    } // validaEspacoLateral JTextField

    //--------------------------------------------------------------------------
    // verifica e valida se um JPasswordField contêm espaçamento lateral
    // false = não permitido
    // true = validado
    public static boolean validaEspacoLateral(JPasswordField txt) {
        String str1 = new String(txt.getPassword()).trim();
        String str2 = new String(txt.getPassword());

        return (str1.equals(str2));
    } // validaEspacoLateral JPasswordField

//    //==========================================================================
//    // retorna cnpj formatado
//    public static String getCnpjFormated(String cnpj) {
//
//        String x = "";
//        String s;
//
////        StringBuilder cnpjFormated = new StringBuilder(cnpj);
////        cnpj.
////        
//        return x.toString();
//    }
    //==========================================================================
    // retorna cnpj formatado
    public static String formatString(String string, String mask) {

        MaskFormatter maskForm = null;
        try {
            maskForm = new MaskFormatter(mask);
            maskForm.setValueContainsLiteralCharacters(false);
            return maskForm.valueToString(string);
        } catch (ParseException ex) {
            Logger.getLogger(Tools_Texts.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //==========================================================================
    // retorna cnpj formatado
    public static String getCnpjFormated(String cnpj) {
        String mask = "##.###.###/####-##";
        return formatString(cnpj, mask);
    }

    //==========================================================================
    // retorna cpf formatado
    public static String getCpfFormated(String cpf) {
        String mask = "###.###.###-##";
        return formatString(cpf, mask);
    }

    //==========================================================================
    // retorna telefone formatado
    public static String getTelefoneFormated(String fone) {
        String mask = "(##) ####-####";
        return formatString(fone, mask);
    }

    //==========================================================================
    // retorna valor moeda formadado apartir de um double
    public static String getMoedaFormated(Double valor) {
        String mask = "#,##";
//        String mask = "¤#,##0.00";
        return formatString(Double.toString(valor), mask);
    }

    //==========================================================================
    // retorna valor moeda formadado apartir de um float
    public static String getMoedaFormated(Float valor) {
        String mask = "#,##";
        return formatString(Float.toString(valor), mask);
    }

    //==========================================================================
    // System.out.println(new Date(System.currentTimeMillis()).);
    // retorna a data atual
    public static String getDataAtual() {

        Date data = new Date(System.currentTimeMillis());
//        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");

        return formatarDate.format(data);

//        Calendar calendar = new GregorianCalendar();
//        Date date = new Date();
//        calendar.setTime(date);
//        return calendar.getTime();
    }

} // fim class
