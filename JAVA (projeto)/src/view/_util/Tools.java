/* Lista de utilitários:
simulateTab
setIcon
turnOnOffObject
 */
package view._util;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tools {

    //==========================================================================
    // simula pressionar tecla tab
    public static void simulateTab(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                Robot rb = new Robot();
                rb.keyPress(KeyEvent.VK_TAB); //simula pressionar tab
            } catch (AWTException ex) {
                // para saber qual erro
                //ex.printStackTrace();
                System.out.println(ex);
            }
        }
    } // fim simulateTab

    //==========================================================================
    // retorna um icone, para aplicar em botões, etc.
    public static ImageIcon setIcon(String nome, String extensao, String path) {
        //ImageIcon icon = new ImageIcon(getClass().getResource(path + nome + extensao));
        // getClass(), não pode usar em um método estático
        // então, ao invés de utilizar ..getClass().getResource()..
        // utilizado ..Tools.class.getResource().., com class, pega desta própria classe

        return new ImageIcon(Tools.class.getResource(path + nome + extensao));
    } // fim setIcon

    //==========================================================================
    // recebe duas listas, uma para habilitar, outra para desabilitar
    public static void turnOnOffObject(Object[] objTrue, Object[] objFalse) {
        turnOnOffObject(objTrue, true);
        turnOnOffObject(objFalse, false);
    } // fim preparaTela

    //--------------------------------------------------------------------------
    // habilita/desabilita objetos
    public static void turnOnOffObject(Object[] object, boolean bool) {

//        for (int i = 0; i < object.length; i++) {
//            Object obj = object[i];
//
        for (Object obj : object) {
            String tipoObj = obj.getClass().getCanonicalName();
            tipoObj = tipoObj.replace("javax.swing.", "");

            switch (tipoObj) {
                case "JTextField":
                    ((JTextField) obj).setEditable(bool);
                    break;
                case "JButton":
                    ((JButton) obj).setEnabled(bool);
                    break;
                case "JCheckBox":
                    ((JCheckBox) obj).setEnabled(bool);
                    break;
                case "JComboBox":
                    ((JComboBox) obj).setEnabled(bool);
                    break;
            }
        }
    } // fim turnOnOffObject

} // fim class
