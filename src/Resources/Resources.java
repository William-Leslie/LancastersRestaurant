package Resources;

import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class Resources {
    private static BufferedImage logo = null;
    private static Font font = null;

    public static Image getLogo(int size) {
        try {
            if (Resources.logo == null) {
                Resources.logo = ImageIO.read(Resources.class.getResourceAsStream("/assets/LancastersLogo.jpg"));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            Resources.logo = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        }
        return Resources.logo.getScaledInstance(size, size, Image.SCALE_SMOOTH);
    }

    public static Font getFont(float size) {
        try {
            if (Resources.font == null) {
                Resources.font = Font.createFont(Font.TRUETYPE_FONT, Resources.class.getResourceAsStream("/assets/AbrilFatface-Regular.ttf"));
            }
        } catch (IOException | FontFormatException exception) {
            exception.printStackTrace();
            Resources.font = new Font("serif", Font.PLAIN, 20);
        }
        return Resources.font.deriveFont(size);
    }
}
