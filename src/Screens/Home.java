package Screens;

import Components.*;

import javax.swing.*;
import java.awt.*;

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

        CButton buttonLogout = new CButton("Logout", event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Login.name());
        });
        userConstraints.gridx++;
        userConstraints.weightx = 1;
        userConstraints.insets = new Insets(0, 0, 0, 10);
        panelUser.add(buttonLogout, userConstraints);

        CLabel labelUser = new CLabel("User: " + "lancaster");
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
        constraints.gridheight = 1;
        constraints.insets = new Insets(10, 10, 0, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelUser, constraints);

        CLogo logo = new CLogo(400, 400);
        logo.setBorder(null);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridheight = 2;
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

        CButton buttonStaff = new CButton("Staff", 26, event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Staff.name());
        });
        buttonStaff.setForeground(new Color(0xcccccc));
        buttonStaff.setBackground(new Color(0x557b8a));
        buttonConstraints.gridy++;
        panelButtons.add(buttonStaff, buttonConstraints);

        CButton buttonWines = new CButton("Wines", 26, event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Wines.name());
        });
        buttonWines.setForeground(new Color(0xcccccc));
        buttonWines.setBackground(new Color(0x557b8a));
        buttonConstraints.gridy++;
        panelButtons.add(buttonWines, buttonConstraints);

        CButton buttonMenus = new CButton("Menus", 26, event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Menus.name());
        });
        buttonMenus.setForeground(new Color(0xcccccc));
        buttonMenus.setBackground(new Color(0x557b8a));
        buttonConstraints.gridy++;
        panelButtons.add(buttonMenus, buttonConstraints);

        CButton buttonInventory = new CButton("Inventory", 26, event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Inventory.name());
        });
        buttonInventory.setForeground(new Color(0xcccccc));
        buttonInventory.setBackground(new Color(0x557b8a));
        buttonConstraints.gridy++;
        panelButtons.add(buttonInventory, buttonConstraints);

        CButton buttonSales = new CButton("Sales", 26, event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Sales.name());
        });
        buttonSales.setForeground(new Color(0xcccccc));
        buttonSales.setBackground(new Color(0x557b8a));
        buttonConstraints.gridy++;
        panelButtons.add(buttonSales, buttonConstraints);

        CButton buttonPayroll = new CButton("Payroll & HR", 26, event -> {
            // TODO: Open external webpage?
        });
        buttonPayroll.setForeground(new Color(0xcccccc));
        buttonPayroll.setBackground(new Color(0x557b8a));
        buttonConstraints.gridy++;
        panelButtons.add(buttonPayroll, buttonConstraints);

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
