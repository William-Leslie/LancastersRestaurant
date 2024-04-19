package Resources;

import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

/**
 * Utility class to load resources in different sizes
 */
public class Resources {
    private static BufferedImage logo = null;
    private static Font font = null;

    /** Get logo image in a certain size
     * @param size size of the square logo in pixels
     * @return scaled logo image
     */
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

    /** Get font instance in a certain size
     * @param size size of the font in points
     * @return scaled font instance
     */
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
