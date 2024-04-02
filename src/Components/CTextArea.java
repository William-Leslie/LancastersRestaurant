package Components;

import Resources.*;

import javax.swing.*;
import java.awt.*;

public class CTextArea extends JTextArea {
    public CTextArea(String initialText, int textSize) {
        super(initialText);
        this.setForeground(new Color(0x2b3336));
        this.setBackground(new Color(0xffffff));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xaaaaaa)));
        this.setFont(Resources.getFont(textSize));
        this.setCaretPosition(0);
        this.setAutoscrolls(false);
    }

    public CTextArea(String initialText) {
        this(initialText, 20);
    }

    public CTextArea(int textSize) {
        this(null, textSize);
    }

    public CTextArea() {
        this(null, 20);
    }
}
