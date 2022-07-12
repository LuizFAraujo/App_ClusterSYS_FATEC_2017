/* Seta um ícone em frames e dialogos */
package view._util;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public final class Tools_SetIcon extends JFrame {

    //==========================================================================
    // Frame
    public static void setIcon(Frame frame, String pathImage) {

        try {
            frame.setIconImage(returnImage(pathImage));
        } catch (Exception e) {
            //
        }

    }

    //==========================================================================
    // JInternalFrame
    public static void setIcon(JInternalFrame jFrame, String pathImage) {

        try {
//            jFrame.setFrameIcon((Icon) returnImage(pathImage));
//            jFrame.setFrameIcon(new ImageIcon(pathImage)); 
            jFrame.setFrameIcon(returnImageIcon(pathImage));
        } catch (Exception e) {
            //
        }

    }

    //==========================================================================
    // JDialog
    public static void setIcon(JDialog dialog, String pathImage) {

        try {
            dialog.setIconImage(returnImage(pathImage));
        } catch (Exception e) {
            //
        }

    }

    //==========================================================================
    // retorna uma imagem apartir de uma string
    public static Image returnImage(String pathImage) {
        return Toolkit.getDefaultToolkit().getImage(Tools_SetIcon.class.getResource(pathImage));
    }

    //==========================================================================
    // retorna uma "imagem icon" apartir de uma string
    public static ImageIcon returnImageIcon(String pathImage) {
        return new ImageIcon(Tools_SetIcon.class.getResource(pathImage));
    }

} // fim class

//
//
//-----------------------------------------------------------------
//                            BACKUP
//-----------------------------------------------------------------
//
//
//    // atribuí o ícone
//    public void setIcon(Frame form, String img) {
//        try {
//
//            // método 01
//            // import javax.imageio.ImageIO;
////            form.setIconImage(ImageIO.read(getClass().getResourceAsStream(img)));
//            // método 02
//            // import java.awt.Toolkit;
//            form.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(img)));
//
//        } catch (Exception e) {
//
//            // apresenta uma mensagem de erro se não encontrar o ícone
//            JOptionPane.showMessageDialog(null,
//                    "Imagem de ícone da barra de título não encontrada!"
//                    + "\nO sistema assumirá um ícone padrão.", // mensagem
//                    "Erro!", // titulo da mensagem
//                    JOptionPane.ERROR_MESSAGE // ícone
//            );
//
//        }
//    } // fim setIcon
