package Resources;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class Resources {
    public static JLabel getLogo(int width, int height) {
        JLabel logo = null;
        try {
            BufferedImage image = ImageIO.read(new File("resources/LancastersLogo.jpeg"));
            Image resized = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            logo = new JLabel(new ImageIcon(resized));
        } catch (IOException exception) {
            logo = new JLabel("Logo");
        }
        logo.setSize(new Dimension(width, height));
        logo.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0xffffff)));
        return logo;
    }
}
