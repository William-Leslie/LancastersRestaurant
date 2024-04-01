package Components;

import Resources.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Navbar extends JPanel {
    public Navbar(String title, ActionListener backAction) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));

        JButton buttonBack = new JButton("Back");
        buttonBack.setForeground(new Color(0x2b3336));
        buttonBack.setBackground(new Color(0xaaaaaa));
        buttonBack.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonBack.setFont(Resources.getFont(20));
        buttonBack.setFocusPainted(false);
        buttonBack.addActionListener(backAction);
        constraints.gridx++;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        constraints.weightx = 2;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.BOTH;
        this.add(buttonBack, constraints);

        constraints.gridx++;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        constraints.weightx = 5;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.VERTICAL;
        this.add(Box.createHorizontalGlue(), constraints);

        JLabel logo = Resources.getLogo(100, 100);
        logo.setBorder(null);
        logo.setPreferredSize(new Dimension(100, 50));
        constraints.gridx++;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        constraints.weightx = 0;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.VERTICAL;
        this.add(logo, constraints);

        JLabel labelTitle = new JLabel(title);
        labelTitle.setForeground(new Color(0xaaaaaa));
        labelTitle.setFont(Resources.getFont(20));
        constraints.gridx++;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        constraints.weightx = 0;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.VERTICAL;
        this.add(labelTitle, constraints);

        constraints.gridx++;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        constraints.weightx = 5;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.VERTICAL;
        this.add(Box.createHorizontalGlue(), constraints);

        JLabel labelUser = new JLabel("User: " + "lancaster");
        labelUser.setForeground(new Color(0xaaaaaa));
        labelUser.setFont(Resources.getFont(20));
        constraints.gridx++;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.anchor = GridBagConstraints.EAST;
        this.add(labelUser, constraints);

        JLabel labelRole = new JLabel("Role: " + "admin");
        labelRole.setForeground(new Color(0xaaaaaa));
        labelRole.setFont(Resources.getFont(20));
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.weightx = 0;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.anchor = GridBagConstraints.EAST;
        this.add(labelRole, constraints);
    }
}
