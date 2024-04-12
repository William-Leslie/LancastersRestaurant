package Components;

import Resources.*;

import javax.swing.*;
import java.awt.*;

public class CLogo extends JLabel {
    public CLogo(int width, int height) {
        super(new ImageIcon(Resources.getLogo(Integer.max(width, height))));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
                new Color(Colors.secondary.getRGB())));
        this.setPreferredSize(new Dimension(width, height));
    }
}
