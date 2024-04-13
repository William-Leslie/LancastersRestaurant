package Components;

import Resources.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CButton extends JButton {
    public CButton(String label, int textSize, ActionListener clickAction) {
        super(label);
        this.setForeground(Colors.background);
        this.setBackground(Colors.frame);
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Colors.white));
        this.setFont(Resources.getFont(textSize));
        this.setFocusPainted(false);
        this.addActionListener(clickAction);
    }

    public CButton(String label, ActionListener clickAction) {
        this(label, 20, clickAction);
    }
}
