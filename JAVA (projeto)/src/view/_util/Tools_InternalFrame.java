/**/
package view._util;

import java.awt.Dimension;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class Tools_InternalFrame extends JInternalFrame {

    //==========================================================================
    // exibe InternalFrame centralizado em relação ao DesktopPane
    public static void showCentralized(JInternalFrame internalFrame, JDesktopPane desktopPane) {
        Dimension d = desktopPane.getSize();
        internalFrame.setLocation(
                (d.width - internalFrame.getSize().width) / 2,
                (d.height - internalFrame.getSize().height) / 2);
        desktopPane.add(internalFrame);
        internalFrame.setVisible(true);
    }

    //==========================================================================
    // exibe InternalFrame mazimizado em relação ao DesktopPane
    public static void showMazimized(JInternalFrame internalFrame, JDesktopPane desktopPane) {
        desktopPane.add(internalFrame);
        
        // abre maximizado
        try {
            internalFrame.setMaximum(true);
        } catch (PropertyVetoException ex) {
            System.out.println("Não foi possível abrir o formulário!!!");
        }
        
        internalFrame.setVisible(true);
    }

} // fim class
