package Screens;

import Resources.Resources;

import javax.swing.*;
import java.awt.*;

public class Index extends JPanel {
    public Index(JPanel screens) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel logo = Resources.getLogo(300, 300);
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(logo, constraints);

        JButton buttonEnter = new JButton("Enter");
        buttonEnter.setForeground(new Color(0x2b3336));
        buttonEnter.setBackground(new Color(0xaaaaaa));
        buttonEnter.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0xffffff)));
        buttonEnter.setFont(Resources.getFont(26));
        buttonEnter.setFocusPainted(false);
        constraints.gridy++;
        constraints.insets = new Insets(30, 0, 0, 0);
        buttonEnter.addActionListener(event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Login.name());
        });
        this.add(buttonEnter, constraints);
    }
}
