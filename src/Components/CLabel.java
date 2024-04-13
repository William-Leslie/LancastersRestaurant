package Components;

import Resources.*;

import javax.swing.*;

public class CLabel extends JLabel {
    public CLabel(String text, int textSize) {
        super(text);
        this.setForeground(Colors.text);
        this.setFont(Resources.getFont(textSize));
    }

    public CLabel(String text) {
        this(text, 20);
    }
}
