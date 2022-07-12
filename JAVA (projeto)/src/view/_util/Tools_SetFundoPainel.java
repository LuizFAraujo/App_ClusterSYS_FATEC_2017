/**/
package view._util;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Tools_SetFundoPainel extends JFrame implements Border {

    private BufferedImage img;

    public Tools_SetFundoPainel() {
    }

    public Tools_SetFundoPainel(BufferedImage image) {
        this.img = image;
    }

    //==========================================================================
    // Overrides Border
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        // centralizado
//        int x0 = x + (width - img.getWidth()) / 2;
//        int y0 = y + (height - img.getHeight()) / 2;
//        g.drawImage(img, x0, y0, null);

        // preenchido
        g.drawImage(img, 0, 0, c.getWidth(), c.getHeight(), c);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    //==========================================================================
    public static void carregaImagem(JDesktopPane desktopPane, String pathImage) {
        try {
            InputStream img = desktopPane.getClass().getResourceAsStream(pathImage);
            BufferedImage image = ImageIO.read(img);
            desktopPane.setBorder(new Tools_SetFundoPainel(image));
        } catch (IOException ex) {
            System.out.println("Imagem não encontrada!");
        }
    }

    public static void carregaImagem(JPanel panel, String pathImage) {
        try {
            InputStream img = panel.getClass().getResourceAsStream(pathImage);
            BufferedImage image = ImageIO.read(img);
            panel.setBorder(new Tools_SetFundoPainel(image));
        } catch (IOException ex) {
            System.out.println("Imagem não encontrada!");
        }
    }

} // fim class
