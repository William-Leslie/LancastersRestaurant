package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JPanel {
    private JButton buttonHome = new JButton("Home");

    public Home (JPanel screens) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(0x2b3336));

        this.buttonHome.setBackground(new Color(0xaaaaaa));
        this.add(this.buttonHome);
    }
}
