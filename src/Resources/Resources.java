package Resources;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class Resources {
    private static BufferedImage logo = null;
    private static Font font = null;

    public static JLabel getLogo(int width, int height) {
        try {
            if(Resources.logo == null) {
                Resources.logo = ImageIO.read(new File("resources/LancastersLogo.jpeg"));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            Resources.logo = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        }
        Image resized = Resources.logo.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(resized));
        logo.setSize(new Dimension(width, height));
        logo.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0xffffff)));
        return logo;
    }

    public static Font getFont(float size) {
        try {
            if(Resources.font == null) {
                Resources.font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/AbrilFatface-Regular.ttf"));
            }
        } catch (IOException | FontFormatException exception) {
            exception.printStackTrace();
            Resources.font = new Font("serif", Font.PLAIN, 20);
        }
        return Resources.font.deriveFont(size);
    }
}
