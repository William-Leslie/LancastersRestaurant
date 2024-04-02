package Components;

import Resources.*;

import javax.swing.*;
import java.awt.*;

public class CTextField extends JTextField {
    public CTextField(String initialText, int textSize) {
        super(initialText);
        this.setForeground(new Color(0x2b3336));
        this.setBackground(new Color(0xffffff));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xaaaaaa)));
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
