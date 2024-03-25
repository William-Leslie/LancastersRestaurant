package Screens;

import Resources.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JPanel {

    public Home(JPanel screens) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));

        // Inner panel with user info, easier to manage
        JPanel panelUser = new JPanel(new GridBagLayout());
        GridBagConstraints userConstraints = new GridBagConstraints();
        panelUser.setBackground(new Color(0x2b3336));
        userConstraints.fill = GridBagConstraints.HORIZONTAL;

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
        userConstraints.insets = new Insets(0, 0, 0, 10);
        panelUser.add(buttonLogout, userConstraints);

        JLabel labelUser = new JLabel("User: " + "lancaster");
        labelUser.setForeground(new Color(0xaaaaaa));
        labelUser.setFont(Resources.getFont(20));
        userConstraints.gridx++;
        userConstraints.weightx = 0;
        userConstraints.insets = new Insets(0, 0, 0, 0);
        panelUser.add(labelUser, userConstraints);

        userConstraints.gridx++;
        userConstraints.weightx = 10;
        panelUser.add(Box.createHorizontalGlue(), userConstraints);

        // Add the user panel to this screen
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(10, 10, 0, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelUser, constraints);

        JLabel logo = Resources.getLogo(400, 400);
        logo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(logo, constraints);

        JPanel panelButtons = new JPanel(new GridBagLayout());
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        panelButtons.setBackground(new Color(0x2b3336));
        buttonConstraints.fill = GridBagConstraints.BOTH;
        buttonConstraints.weightx = 1;
        buttonConstraints.weighty = 1;
        buttonConstraints.insets = new Insets(10, 0, 10, 0);

        JButton buttonStaff = new JButton("Staff");
        buttonStaff.setForeground(new Color(0xcccccc));
        buttonStaff.setBackground(new Color(0x557b8a));
        buttonStaff.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonStaff.setFont(Resources.getFont(26));
        buttonStaff.setFocusPainted(false);
        buttonConstraints.gridy++;
        panelButtons.add(buttonStaff, buttonConstraints);

        JButton buttonWines = new JButton("Wines");
        buttonWines.setForeground(new Color(0xcccccc));
        buttonWines.setBackground(new Color(0x557b8a));
        buttonWines.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonWines.setFont(Resources.getFont(26));
        buttonWines.setFocusPainted(false);
        buttonConstraints.gridy++;
        panelButtons.add(buttonWines, buttonConstraints);

        JButton buttonMenus = new JButton("Menus");
        buttonMenus.setForeground(new Color(0xcccccc));
        buttonMenus.setBackground(new Color(0x557b8a));
        buttonMenus.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonMenus.setFont(Resources.getFont(26));
        buttonMenus.setFocusPainted(false);
        buttonConstraints.gridy++;
        panelButtons.add(buttonMenus, buttonConstraints);

        JButton buttonIngredients = new JButton("Ingredients");
        buttonIngredients.setForeground(new Color(0xcccccc));
        buttonIngredients.setBackground(new Color(0x557b8a));
        buttonIngredients.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonIngredients.setFont(Resources.getFont(26));
        buttonIngredients.setFocusPainted(false);
        buttonConstraints.gridy++;
        panelButtons.add(buttonIngredients, buttonConstraints);

        JButton buttonSales = new JButton("Sales");
        buttonSales.setForeground(new Color(0xcccccc));
        buttonSales.setBackground(new Color(0x557b8a));
        buttonSales.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonSales.setFont(Resources.getFont(26));
        buttonSales.setFocusPainted(false);
        buttonConstraints.gridy++;
        panelButtons.add(buttonSales, buttonConstraints);

        JButton buttonParameters = new JButton("Restaurant Capacity");
        buttonParameters.setForeground(new Color(0xcccccc));
        buttonParameters.setBackground(new Color(0x557b8a));
        buttonParameters.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonParameters.setFont(Resources.getFont(26));
        buttonParameters.setFocusPainted(false);
        buttonConstraints.gridy++;
        panelButtons.add(buttonParameters, buttonConstraints);

        // Add the button panel to this screen
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridheight = 2;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelButtons, constraints);
    }
}
