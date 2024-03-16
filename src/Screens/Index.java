package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Index extends JPanel {
    private JButton buttonEnter = new JButton("Enter");

    public Index (JPanel screens) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(0x2b3336));

        this.buttonEnter.setBackground(new Color(0xaaaaaa));
        this.buttonEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)screens.getLayout();
                cl.show(screens, Screen.Login.name());
            }
        });
        this.add(this.buttonEnter);
    }
}
