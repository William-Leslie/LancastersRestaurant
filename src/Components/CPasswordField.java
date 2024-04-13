package Components;

import Resources.*;

import javax.swing.*;
import java.awt.*;

public class CPasswordField extends JPasswordField {
    public CPasswordField(int textSize) {
        super(0);
        this.setForeground(Colors.background);
        this.setBackground(Colors.white);
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Colors.frame));
        this.setFont(Resources.getFont(textSize));
    }

    public CPasswordField() {
        this(20);
    }
}
