package Components;

import Resources.*;

import javax.swing.*;
import java.awt.*;

public class Logo extends JLabel {
    public Logo(int width, int height) {
        super(new ImageIcon(Resources.getLogo(Integer.max(width, height))));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        this.setPreferredSize(new Dimension(width, height));
    }
}
