package Components;

import Resources.*;

import javax.swing.*;
import java.awt.*;

public class CPasswordField extends JPasswordField {
    public CPasswordField(int textSize) {
        super(0);
        this.setForeground(new Color(0x2b3336));
        this.setBackground(new Color(0xffffff));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xaaaaaa)));
        this.setFont(Resources.getFont(textSize));
    }

    public CPasswordField() {
        this(20);
    }
}
