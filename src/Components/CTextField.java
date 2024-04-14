package Components;

import Resources.*;

import javax.swing.*;

public class CTextField extends JTextField {
    public CTextField(String initialText, int textSize) {
        super(initialText);
        this.setForeground(Colors.background);
        this.setDisabledTextColor(Colors.frame);
        this.setBackground(Colors.white);
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Colors.frame));
        this.setFont(Resources.getFont(textSize));
    }

    public CTextField(String initialText) {
        this(initialText, 20);
    }

    public CTextField(int textSize) {
        this(null, textSize);
    }

    public CTextField() {
        this(null, 20);
    }
}
