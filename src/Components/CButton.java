package Components;

import Resources.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CButton extends JButton {
    public CButton(String label, int textSize, ActionListener clickAction) {
        super(label);
        this.setForeground(new Color(236, 235, 231));
        this.setBackground(new Color(0xaaaaaa));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        this.setFont(Resources.getFont(textSize));
        this.setFocusPainted(false);
        this.addActionListener(clickAction);
    }

    public CButton(String label, ActionListener clickAction) {
        this(label, 20, clickAction);
    }
}
