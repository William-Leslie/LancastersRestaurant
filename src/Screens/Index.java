package Screens;

import Resources.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Index extends JPanel {
    private JButton buttonEnter = new JButton("Enter");
    private JLabel Logo = Resources.getLogo(300,300);


    public Index (JPanel screens) {
        super();
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(this.Logo, constraints);

        this.buttonEnter.setForeground(new Color(0x2b3336));
        this.buttonEnter.setBackground(new Color(0xaaaaaa));
        this.buttonEnter.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0xffffff)));
        this.buttonEnter.setFont(Resources.getFont(26));
        this.buttonEnter.setFocusPainted(false);
        constraints.gridy++;
        constraints.insets = new Insets(30, 0, 0, 0);
        this.buttonEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)screens.getLayout();
                cl.show(screens, Screen.Login.name());
            }        });

        this.add(this.buttonEnter, constraints);


    }
}
