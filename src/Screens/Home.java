package Screens;

import Components.*;
import Management.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;
import java.nio.file.*;

/**
 * Screen for homepage with buttons to select submenus
 */
public class Home extends JPanel {
    public Home(CWindow window) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(Colors.background);

        // Inner panel with user info, easier to manage
        JPanel panelUser = new JPanel(new GridBagLayout());
        GridBagConstraints userConstraints = new GridBagConstraints();
        panelUser.setBackground(Colors.background);
        userConstraints.fill = GridBagConstraints.BOTH;

        CButton buttonLogout = new CButton("Logout", e -> {
            MAuthUser.logout();
            window.switchTo(new Login(window));
        });
        buttonLogout.setPreferredSize(new Dimension(150, 0));
        userConstraints.gridx = 1;
        userConstraints.gridy = 1;
        userConstraints.gridheight = 2;
        userConstraints.weightx = 0;
        userConstraints.insets = new Insets(0, 0, 0, 10);
        panelUser.add(buttonLogout, userConstraints);

        CLabel labelUser = new CLabel("User: " + MAuthUser.username);
        userConstraints.gridx = 2;
        userConstraints.gridy = 1;
        userConstraints.gridheight = 1;
        userConstraints.weightx = 0;
        userConstraints.insets = new Insets(0, 0, 0, 0);
        panelUser.add(labelUser, userConstraints);

        CLabel labelRole = new CLabel("Role: " + MAuthUser.role);
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

        // TODO: add cog icon to add new login users and change password

        JPanel panelButtons = new JPanel(new GridBagLayout());
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        panelButtons.setBackground(Colors.background);
        buttonConstraints.fill = GridBagConstraints.BOTH;
        buttonConstraints.weightx = 1;
        buttonConstraints.weighty = 1;
        buttonConstraints.insets = new Insets(10, 0, 10, 0);

        CButton buttonStaff = new CButton("Staff", 26, event -> window.switchTo(new Staff(window, null)));
        buttonStaff.setForeground(Colors.text);
        buttonStaff.setBackground(Colors.secondary);
        buttonConstraints.gridy++;
        panelButtons.add(buttonStaff, buttonConstraints);

        CButton buttonWines = new CButton("Wines", 26, event -> window.switchTo(new Wines(window)));
        buttonWines.setForeground(Colors.text);
        buttonWines.setBackground(Colors.secondary);
        buttonConstraints.gridy++;
        panelButtons.add(buttonWines, buttonConstraints);

        CButton buttonMenus = new CButton("Menus", 26, event -> window.switchTo(new Menus(window)));
        buttonMenus.setForeground(Colors.text);
        buttonMenus.setBackground(Colors.secondary);
        buttonConstraints.gridy++;
        panelButtons.add(buttonMenus, buttonConstraints);

        CButton buttonInventory = new CButton("Inventory", 26, event -> window.switchTo(new Inventory(window)));
        buttonInventory.setForeground(Colors.text);
        buttonInventory.setBackground(Colors.secondary);
        buttonConstraints.gridy++;
        panelButtons.add(buttonInventory, buttonConstraints);

        CButton buttonSales = new CButton("Sales", 26, event -> window.switchTo(new Sales(window)));
        buttonSales.setForeground(Colors.text);
        buttonSales.setBackground(Colors.secondary);
        buttonConstraints.gridy++;
        panelButtons.add(buttonSales, buttonConstraints);

        CButton buttonPayroll = new CButton("Payroll & HR", 26, event -> {
            try {
                Path tempDir = Files.createTempDirectory("Lancasters-PayrollHR-");
                Path html = tempDir.resolve("index.html");
                Path gif = tempDir.resolve("cog.gif");
                Path css = tempDir.resolve("index.css");
                Files.write(html, Resources.class.getResourceAsStream("/assets/PayrollHR/index.html").readAllBytes());
                Files.write(gif, Resources.class.getResourceAsStream("/assets/PayrollHR/cog.gif").readAllBytes());
                Files.write(css, Resources.class.getResourceAsStream("/assets/PayrollHR/index.css").readAllBytes());
                Desktop.getDesktop().open(html.toFile());
                html.toFile().deleteOnExit();
                gif.toFile().deleteOnExit();
                css.toFile().deleteOnExit();
                tempDir.toFile().deleteOnExit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        buttonPayroll.setForeground(Colors.text);
        buttonPayroll.setBackground(Colors.secondary);
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
