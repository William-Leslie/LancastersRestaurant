package Screens;

import Resources.Resources;

import javax.swing.*;
import java.awt.*;

public class Menus extends JPanel {
    public Menus(JPanel screens) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Inner panel for top bar, easier to manage
        JPanel panelTopbar = new JPanel(new GridBagLayout());
        GridBagConstraints topbarConstraints = new GridBagConstraints();
        panelTopbar.setBackground(new Color(0x2b3336));

        JButton buttonBack = new JButton("Back");
        buttonBack.setForeground(new Color(0x2b3336));
        buttonBack.setBackground(new Color(0xaaaaaa));
        buttonBack.setFont(Resources.getFont(20));
        buttonBack.setFocusPainted(false);
        buttonBack.addActionListener(event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Home.name());
        });
        topbarConstraints.gridx++;
        topbarConstraints.gridy = 1;
        topbarConstraints.gridheight = 2;
        topbarConstraints.weightx = 2;
        topbarConstraints.insets = new Insets(0, 0, 0, 0);
        topbarConstraints.fill = GridBagConstraints.BOTH;
        panelTopbar.add(buttonBack, topbarConstraints);

        topbarConstraints.gridx++;
        topbarConstraints.gridy = 1;
        topbarConstraints.gridheight = 2;
        topbarConstraints.weightx = 5;
        topbarConstraints.insets = new Insets(0, 0, 0, 0);
        topbarConstraints.fill = GridBagConstraints.VERTICAL;
        panelTopbar.add(Box.createHorizontalGlue(), topbarConstraints);

        JLabel logo = Resources.getLogo(100, 100);
        logo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        logo.setPreferredSize(new Dimension(100, 50));
        topbarConstraints.gridx++;
        topbarConstraints.gridy = 1;
        topbarConstraints.gridheight = 2;
        topbarConstraints.weightx = 0;
        topbarConstraints.insets = new Insets(0, 0, 0, 0);
        topbarConstraints.fill = GridBagConstraints.VERTICAL;
        panelTopbar.add(logo, topbarConstraints);

        JLabel labelTitle = new JLabel("Menu List");
        labelTitle.setForeground(new Color(0xaaaaaa));
        labelTitle.setFont(Resources.getFont(20));
        topbarConstraints.gridx++;
        topbarConstraints.gridy = 1;
        topbarConstraints.gridheight = 2;
        topbarConstraints.weightx = 0;
        topbarConstraints.insets = new Insets(0, 0, 0, 0);
        topbarConstraints.fill = GridBagConstraints.VERTICAL;
        panelTopbar.add(labelTitle, topbarConstraints);

        topbarConstraints.gridx++;
        topbarConstraints.gridy = 1;
        topbarConstraints.gridheight = 2;
        topbarConstraints.weightx = 5;
        topbarConstraints.insets = new Insets(0, 0, 0, 0);
        topbarConstraints.fill = GridBagConstraints.VERTICAL;
        panelTopbar.add(Box.createHorizontalGlue(), topbarConstraints);

        JLabel labelUser = new JLabel("User: " + "lancaster");
        labelUser.setForeground(new Color(0xaaaaaa));
        labelUser.setFont(Resources.getFont(20));
        topbarConstraints.gridx++;
        topbarConstraints.gridy = 1;
        topbarConstraints.gridheight = 1;
        topbarConstraints.weightx = 0;
        topbarConstraints.insets = new Insets(0, 0, 0, 0);
        topbarConstraints.fill = GridBagConstraints.VERTICAL;
        topbarConstraints.anchor = GridBagConstraints.EAST;
        panelTopbar.add(labelUser, topbarConstraints);

        JLabel labelRole = new JLabel("Role: " + "admin");
        labelRole.setForeground(new Color(0xaaaaaa));
        labelRole.setFont(Resources.getFont(20));
        topbarConstraints.gridy = 2;
        topbarConstraints.gridheight = 1;
        topbarConstraints.weightx = 0;
        topbarConstraints.insets = new Insets(0, 0, 0, 0);
        topbarConstraints.fill = GridBagConstraints.VERTICAL;
        topbarConstraints.anchor = GridBagConstraints.EAST;
        panelTopbar.add(labelRole, topbarConstraints);

        // Add the user panel to this screen
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.gridheight = 1;
        constraints.insets = new Insets(10, 10, 0, 10);
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelTopbar, constraints);
    }
}
