package Components;

import Resources.*;

import javax.swing.*;

public class CTextArea extends JTextArea {
    public CTextArea(String initialText, int textSize) {
        super(initialText);
        this.setForeground(Colors.background);
        this.setDisabledTextColor(Colors.frame);
        this.setBackground(Colors.white);
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Colors.frame));
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
