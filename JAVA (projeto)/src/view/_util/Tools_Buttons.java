/*
configButtons
setActionButtons
 */
package view._util;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;

public class Tools_Buttons {

    //==========================================================================
    // configura botões
    public static void configButtons(Container container, int txtGap) {

        for (int i = 0; i < container.getComponentCount(); i++) {

            Component c = container.getComponent(i); // pega o componente container

            if (c instanceof JButton) {
                JButton bt = (JButton) c;

                bt.setBorderPainted(false);
                bt.setContentAreaFilled(false);
                bt.setIconTextGap(txtGap);
                bt.setCursor(new Cursor(Cursor.HAND_CURSOR)); // cursor mão
                bt.setName(bt.getText()); // seta o nome igual ao texto

            }
        }
    } // fim configButtons

    //==========================================================================
    // adiciona eventos ao botão, em tempo de execução
    public static void setActionButtons(Container container) {

        for (int i = 0; i < container.getComponentCount(); i++) {

            Component comp = container.getComponent(i); // pega o componente container

            if (comp instanceof JButton) {
                JButton bt = (JButton) comp;

                //-------------------------------------------------
                // FOCUS
                bt.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        bt.setContentAreaFilled(true);
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        bt.setContentAreaFilled(false);
                    }
                });

                //-------------------------------------------------
                // MOUSE
                // (extendendo a classe abstrata MouseAdapter e
                // reescrevendo somente o que interessa de MouseListener)
                bt.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        bt.setContentAreaFilled(true);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        bt.setContentAreaFilled(false);
                    }
                });

            } // fim if instaceof
        } // fim for
    } // fim setActionButtons

} // fim class
