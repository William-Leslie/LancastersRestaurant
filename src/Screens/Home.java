package Screens;

import Components.*;
import Resources.Colors;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Home extends JPanel {
    public Home(JPanel screens) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(Colors.primary);

        // Inner panel with user info, easier to manage
        JPanel panelUser = new JPanel(new GridBagLayout());
        GridBagConstraints userConstraints = new GridBagConstraints();
        panelUser.setBackground(Colors.primary);
        userConstraints.fill = GridBagConstraints.BOTH;

        CButton buttonLogout = new CButton("Logout", event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Login.name());
        });
        buttonLogout.setPreferredSize(new Dimension(150, 0));
        userConstraints.gridx = 1;
        userConstraints.gridy = 1;
        userConstraints.gridheight = 2;
        userConstraints.weightx = 0;
        userConstraints.insets = new Insets(0, 0, 0, 10);
        panelUser.add(buttonLogout, userConstraints);

        CLabel labelUser = new CLabel("User: " + "lancaster");
        userConstraints.gridx = 2;
        userConstraints.gridy = 1;
        userConstraints.gridheight = 1;
        userConstraints.weightx = 0;
        userConstraints.insets = new Insets(0, 0, 0, 0);
        panelUser.add(labelUser, userConstraints);

        CLabel labelRole = new CLabel("Role: " + "admin");
        userConstraints.gridx = 2;
        userConstraints.gridy = 2;
        userConstraints.gridheight = 1;
        userConstraints.weightx = 0;
        userConstraints.insets = new Insets(0, 0, 0, 0);
        panelUser.add(labelRole, userConstraints);

        userConstraints.gridx = 3;
        userConstraints.gridy = 1;
        userConstraints.gridheight = 2;
        userConstraints.weightx = 1;
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
        panelButtons.setBackground(Colors.primary);
        buttonConstraints.fill = GridBagConstraints.BOTH;
        buttonConstraints.weightx = 1;
        buttonConstraints.weighty = 1;
        buttonConstraints.insets = new Insets(10, 0, 10, 0);

        CButton buttonStaff = new CButton("Staff", 26, event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Staff.name());
        });
        buttonStaff.setForeground(Colors.secondary);
        buttonStaff.setBackground(Colors.primary);
        buttonConstraints.gridy++;
        panelButtons.add(buttonStaff, buttonConstraints);

        CButton buttonWines = new CButton("Wines", 26, event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Wines.name());
        });
        buttonWines.setForeground(Colors.secondary);
        buttonWines.setBackground(Colors.primary);
        buttonConstraints.gridy++;
        panelButtons.add(buttonWines, buttonConstraints);

        CButton buttonMenus = new CButton("Menus", 26, event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Menus.name());
        });
        buttonMenus.setForeground(Colors.secondary);
        buttonMenus.setBackground(Colors.primary);
        buttonConstraints.gridy++;
        panelButtons.add(buttonMenus, buttonConstraints);

        CButton buttonInventory = new CButton("Inventory", 26, event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Inventory.name());
        });
        buttonInventory.setForeground(Colors.secondary);
        buttonInventory.setBackground(Colors.primary);
        buttonConstraints.gridy++;
        panelButtons.add(buttonInventory, buttonConstraints);

        CButton buttonSales = new CButton("Sales", 26, event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Sales.name());
        });
        buttonSales.setForeground(Colors.secondary);
        buttonSales.setBackground(Colors.primary);
        buttonConstraints.gridy++;
        panelButtons.add(buttonSales, buttonConstraints);

        CButton buttonPayroll = new CButton("Payroll & HR", 26, event -> {
            try {
                Desktop.getDesktop().open(new java.io.File("resources/index.html"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttonPayroll.setForeground(Colors.secondary);
        buttonPayroll.setBackground(Colors.primary);
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
