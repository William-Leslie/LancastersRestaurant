package Components;

import Resources.*;

import javax.swing.*;
import java.awt.*;

public class CLabel extends JLabel {
    public CLabel(String text, int textSize) {
        super(text);
        this.setForeground(new Color(0xaaaaaa));
        this.setFont(Resources.getFont(textSize));
    }

    public CLabel(String text) {
        this(text, 20);
    }
}
