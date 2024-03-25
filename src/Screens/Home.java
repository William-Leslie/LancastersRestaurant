package Screens;

import Resources.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JPanel {

    public Home(JPanel screens) {
        super(new BorderLayout());
        this.setBackground(new Color(0x2b3336));

        JLabel logo = Resources.getLogo(400, 400);
        logo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        logo.addMouseListener(new MouseListener() {
            @Override // Click logo to go back to index
            public void mouseClicked(MouseEvent event) {
                if (event.getButton() == MouseEvent.BUTTON1) {
                    CardLayout cl = (CardLayout) screens.getLayout();
                    cl.show(screens, Screen.Selection.name());
                }
            }

            @Override
            public void mousePressed(MouseEvent event) {
            }

            @Override
            public void mouseReleased(MouseEvent event) {
            }

            @Override
            public void mouseEntered(MouseEvent event) {
            }

            @Override
            public void mouseExited(MouseEvent event) {
            }
        });
        this.add(logo, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonPanel.setBackground(new Color(0x2b3336));
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
        buttonPanel.add(buttonStaff, buttonConstraints);

        JButton buttonWines = new JButton("Wines");
        buttonWines.setForeground(new Color(0xcccccc));
        buttonWines.setBackground(new Color(0x557b8a));
        buttonWines.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonWines.setFont(Resources.getFont(26));
        buttonWines.setFocusPainted(false);
        buttonConstraints.gridy++;
        buttonPanel.add(buttonWines, buttonConstraints);

        JButton buttonMenus = new JButton("Menus");
        buttonMenus.setForeground(new Color(0xcccccc));
        buttonMenus.setBackground(new Color(0x557b8a));
        buttonMenus.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonMenus.setFont(Resources.getFont(26));
        buttonMenus.setFocusPainted(false);
        buttonConstraints.gridy++;
        buttonPanel.add(buttonMenus, buttonConstraints);

        JButton buttonIngredients = new JButton("Ingredients");
        buttonIngredients.setForeground(new Color(0xcccccc));
        buttonIngredients.setBackground(new Color(0x557b8a));
        buttonIngredients.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonIngredients.setFont(Resources.getFont(26));
        buttonIngredients.setFocusPainted(false);
        buttonConstraints.gridy++;
        buttonPanel.add(buttonIngredients, buttonConstraints);

        JButton buttonSales = new JButton("Sales");
        buttonSales.setForeground(new Color(0xcccccc));
        buttonSales.setBackground(new Color(0x557b8a));
        buttonSales.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonSales.setFont(Resources.getFont(26));
        buttonSales.setFocusPainted(false);
        buttonConstraints.gridy++;
        buttonPanel.add(buttonSales, buttonConstraints);

        JButton buttonParameters = new JButton("Restaurant Capacity");
        buttonParameters.setForeground(new Color(0xcccccc));
        buttonParameters.setBackground(new Color(0x557b8a));
        buttonParameters.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonParameters.setFont(Resources.getFont(26));
        buttonParameters.setFocusPainted(false);
        buttonConstraints.gridy++;
        buttonPanel.add(buttonParameters, buttonConstraints);

        buttonWines.setForeground(new Color(0xcccccc));
        buttonWines.setBackground(new Color(0x557b8a));
        buttonWines.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonWines.setFont(Resources.getFont(26));
        buttonWines.setFocusPainted(false);
        buttonConstraints.gridy++;
        buttonPanel.add(buttonWines, buttonConstraints);

        this.add(buttonPanel);
    }
}
