package Screens;

import Resources.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Selection extends JPanel {
    public Selection(JPanel screens) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));

        // Inner panel with user info, easier to manage
        JPanel panelUser = new JPanel(new GridBagLayout());
        GridBagConstraints userConstraints = new GridBagConstraints();
        panelUser.setBackground(new Color(0x2b3336));
        userConstraints.fill = GridBagConstraints.HORIZONTAL;

        userConstraints.gridx++;
        userConstraints.weightx = 10;
        panelUser.add(Box.createHorizontalGlue(), userConstraints);

        JLabel labelUser = new JLabel("User: " + "lancaster");
        labelUser.setForeground(new Color(0xaaaaaa));
        labelUser.setFont(Resources.getFont(20));
        userConstraints.gridx++;
        userConstraints.weightx = 0;
        userConstraints.insets = new Insets(0, 0, 0, 0);
        panelUser.add(labelUser, userConstraints);

        JButton buttonLogout = new JButton("Logout");
        buttonLogout.setForeground(new Color(0x2b3336));
        buttonLogout.setBackground(new Color(0xaaaaaa));
        buttonLogout.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonLogout.setFont(Resources.getFont(20));
        buttonLogout.setFocusPainted(false);
        buttonLogout.addActionListener(event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Login.name());
        });
        userConstraints.gridx++;
        userConstraints.weightx = 1;
        userConstraints.insets = new Insets(0, 10, 0, 0);
        panelUser.add(buttonLogout, userConstraints);

        // Add the user panel to this screen
        constraints.gridy++;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(10, 10, 0, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelUser, constraints);

        Component spacerTop = Box.createVerticalGlue();
        constraints.gridy++;
        constraints.weightx = 0;
        constraints.weighty = 1;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(spacerTop, constraints);

        JLabel logo = Resources.getLogo(300, 300);
        constraints.gridy++;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(logo, constraints);

        // Inner panel with all the buttons, easier to manage
        JPanel panelButtons = new JPanel(new GridBagLayout());
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        panelButtons.setBackground(new Color(0x2b3336));
        buttonConstraints.fill = GridBagConstraints.BOTH;
        buttonConstraints.weightx = 1;
        buttonConstraints.weighty = 1;

        buttonConstraints.gridy = 0;
        buttonConstraints.gridheight = 1;
        panelButtons.add(Box.createVerticalGlue(), buttonConstraints);
        buttonConstraints.gridy = 1;
        buttonConstraints.gridheight = 1;
        panelButtons.add(Box.createVerticalGlue(), buttonConstraints);
        JButton buttonKitchen = new JButton("Kitchen");
        buttonKitchen.setForeground(new Color(0xC8C8C8));
        buttonKitchen.setBackground(new Color(0x455A61));
        buttonKitchen.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonKitchen.setFont(Resources.getFont(26));
        buttonKitchen.setFocusPainted(false);
        buttonKitchen.setPreferredSize(new Dimension(2, 2));
        buttonConstraints.gridx++;
        buttonConstraints.gridy = 2;
        buttonConstraints.gridheight = 3;
        buttonConstraints.insets = new Insets(0, 0, 0, 0);
        buttonKitchen.addActionListener(event -> {
//            CardLayout cl = (CardLayout) screens.getLayout();
//            cl.show(screens, Screen.Kitchen.name());
        });
        panelButtons.add(buttonKitchen, buttonConstraints);

        buttonConstraints.gridy = 0;
        buttonConstraints.gridheight = 1;
        panelButtons.add(Box.createVerticalGlue(), buttonConstraints);
        JButton buttonSupplier = new JButton("Supplier");
        buttonSupplier.setForeground(new Color(0xC8C8C8));
        buttonSupplier.setBackground(new Color(0x506D7B));
        buttonSupplier.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonSupplier.setFont(Resources.getFont(26));
        buttonSupplier.setFocusPainted(false);
        buttonSupplier.setPreferredSize(new Dimension(2, 2));
        buttonConstraints.gridx++;
        buttonConstraints.gridy = 1;
        buttonConstraints.gridheight = 3;
        buttonConstraints.insets = new Insets(0, 10, 0, 0);
        buttonSupplier.addActionListener(event -> {
//            CardLayout cl = (CardLayout) screens.getLayout();
//            cl.show(screens, Screen.Supplier.name());
        });
        panelButtons.add(buttonSupplier, buttonConstraints);
        buttonConstraints.gridy = 4;
        buttonConstraints.gridheight = 1;
        panelButtons.add(Box.createVerticalGlue(), buttonConstraints);

        JButton buttonHome = new JButton("Home");
        buttonHome.setForeground(new Color(0xC8C8C8));
        buttonHome.setBackground(new Color(0x557B8A));
        buttonHome.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonHome.setFont(Resources.getFont(26));
        buttonHome.setFocusPainted(false);
        buttonHome.setPreferredSize(new Dimension(2, 2));
        buttonConstraints.gridx++;
        buttonConstraints.gridy = 0;
        buttonConstraints.gridheight = 3;
        buttonConstraints.insets = new Insets(0, 10, 0, 0);
        buttonHome.addActionListener(event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Home.name());
        });
        panelButtons.add(buttonHome, buttonConstraints);
        buttonConstraints.gridy = 3;
        buttonConstraints.gridheight = 1;
        panelButtons.add(Box.createVerticalGlue(), buttonConstraints);
        buttonConstraints.gridy = 4;
        buttonConstraints.gridheight = 1;
        panelButtons.add(Box.createVerticalGlue(), buttonConstraints);

        buttonConstraints.gridy = 0;
        buttonConstraints.gridheight = 1;
        panelButtons.add(Box.createVerticalGlue(), buttonConstraints);
        JButton buttonPayroll = new JButton("Payroll");
        buttonPayroll.setForeground(new Color(0xC8C8C8));
        buttonPayroll.setBackground(new Color(0x506D7B));
        buttonPayroll.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonPayroll.setFont(Resources.getFont(26));
        buttonPayroll.setFocusPainted(false);
        buttonPayroll.setPreferredSize(new Dimension(2, 2));
        buttonConstraints.gridx++;
        buttonConstraints.gridy = 1;
        buttonConstraints.gridheight = 3;
        buttonConstraints.insets = new Insets(0, 10, 0, 0);
        buttonPayroll.addActionListener(event -> {
//            CardLayout cl = (CardLayout) screens.getLayout();
//            cl.show(screens, Screen.Payroll.name());
        });
        panelButtons.add(buttonPayroll, buttonConstraints);
        buttonConstraints.gridy = 4;
        buttonConstraints.gridheight = 1;
        panelButtons.add(Box.createVerticalGlue(), buttonConstraints);

        buttonConstraints.gridy = 0;
        buttonConstraints.gridheight = 1;
        panelButtons.add(Box.createVerticalGlue(), buttonConstraints);
        buttonConstraints.gridy = 1;
        buttonConstraints.gridheight = 1;
        panelButtons.add(Box.createVerticalGlue(), buttonConstraints);
        JButton buttonFoh = new JButton("FOH");
        buttonFoh.setForeground(new Color(0xC8C8C8));
        buttonFoh.setBackground(new Color(0x455A61));
        buttonFoh.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonFoh.setFont(Resources.getFont(26));
        buttonFoh.setFocusPainted(false);
        buttonFoh.setPreferredSize(new Dimension(2, 2));
        buttonConstraints.gridx++;
        buttonConstraints.gridy = 2;
        buttonConstraints.gridheight = 3;
        buttonConstraints.insets = new Insets(0, 10, 0, 0);
        buttonFoh.addActionListener(event -> {
//            CardLayout cl = (CardLayout) screens.getLayout();
//            cl.show(screens, Screen.Foh.name());
        });
        panelButtons.add(buttonFoh, buttonConstraints);

        // Add the button panel to this screen
        constraints.gridy++;
        constraints.weightx = 1;
        constraints.weighty = 3;
        constraints.insets = new Insets(60, 60, 0, 60);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelButtons, constraints);

        Component spacerBottom = Box.createVerticalGlue();
        constraints.gridy++;
        constraints.weightx = 0;
        constraints.weighty = 1;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(spacerBottom, constraints);
    }
}
