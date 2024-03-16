package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Selection extends JPanel {
    private JButton buttonSelection = new JButton("Selection");

    public Selection (JPanel screens) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(0x2b3336));

        this.buttonSelection.setBackground(new Color(0xaaaaaa));
        this.add(this.buttonSelection);
    }
}
