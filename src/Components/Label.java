package Components;

import Resources.*;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label(String text) {
        super(text);
        this.setForeground(new Color(0xaaaaaa));
        this.setFont(Resources.getFont(20));
    }
}
