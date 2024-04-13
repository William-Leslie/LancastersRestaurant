package Screens;

import Components.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;

public class Menus extends JPanel {
    public Menus(Window window) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(Colors.background);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;

        CNavbar navbar = new CNavbar("Menus", event -> {
            window.switchTo(new Home(window));
        });
        constraints.gridy = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(10, 10, 0, 10);
        this.add(navbar, constraints);

        JPanel panelMain = new JPanel(new GridBagLayout());
        GridBagConstraints mainConstraints = new GridBagConstraints();
        panelMain.setBackground(new Color(0x2b3336));
        mainConstraints.fill = GridBagConstraints.BOTH;
        mainConstraints.weightx = 1;
        mainConstraints.insets = new Insets(16, 16, 16, 16);

        LocalDateTime today = LocalDate.now().atStartOfDay(); // Midnight
        LocalDateTime monday = today.minusDays(today.getDayOfWeek().getValue() - 1); // Find Monday, getValue() does +1

        // Get current and next 4 weeks
        for (LocalDateTime stop = monday.plusWeeks(5); monday.isBefore(stop); monday = monday.plusWeeks(1)) {
            JPanel panelMenu = new JPanel(new GridBagLayout());
            GridBagConstraints menuConstraints = new GridBagConstraints();
            panelMenu.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
            menuConstraints.weightx = 1;

            if (monday.isBefore(today) || monday.isEqual(today)) {
                CLabel labelCurrent = new CLabel("Current week");
                labelCurrent.setForeground(Colors.text);
                menuConstraints.gridx = 1;
                menuConstraints.gridy = 1;
                menuConstraints.gridheight = 3;
                menuConstraints.insets = new Insets(16, 16, 16, 16);
                menuConstraints.anchor = GridBagConstraints.SOUTHWEST;
                panelMenu.add(labelCurrent, menuConstraints);

                panelMenu.setBackground(Colors.primary);
            } else {
                panelMenu.setBackground(Colors.secondary);
            }

            // TODO: Show if approved and sent to FOH

            CLabel labelDate = new CLabel(CDate.of(monday) + "   -   " + CDate.of(monday.plusDays(6)), 26);
            labelDate.setForeground(Colors.text);
            menuConstraints.gridx = 1;
            menuConstraints.gridy = 1;
            menuConstraints.gridheight = 3;
            menuConstraints.insets = new Insets(16, 16, 16, 16);
            menuConstraints.anchor = GridBagConstraints.NORTHWEST;
            panelMenu.add(labelDate, menuConstraints);

            CLabel labelAvgPrice = new CLabel("Average Price: " + CPrice.of(24.65), 18);
            labelAvgPrice.setForeground(Colors.text);
            menuConstraints.gridx = 2;
            menuConstraints.gridy = 1;
            menuConstraints.gridheight = 1;
            menuConstraints.insets = new Insets(16, 16, 2, 16);
            menuConstraints.anchor = GridBagConstraints.EAST;
            panelMenu.add(labelAvgPrice, menuConstraints);

            CLabel labelMaxPrice = new CLabel("Maximum Price: " + CPrice.of(35), 18);
            labelMaxPrice.setForeground(Colors.text);
            menuConstraints.gridx = 2;
            menuConstraints.gridy = 2;
            menuConstraints.gridheight = 1;
            menuConstraints.insets = new Insets(2, 16, 0, 16);
            menuConstraints.anchor = GridBagConstraints.EAST;
            panelMenu.add(labelMaxPrice, menuConstraints);

            CLabel labelMinPrice = new CLabel("Minimum Price: " + CPrice.of(7), 18);
            labelMinPrice.setForeground(Colors.text);
            menuConstraints.gridx = 2;
            menuConstraints.gridy = 3;
            menuConstraints.gridheight = 1;
            menuConstraints.insets = new Insets(2, 16, 16, 16);
            menuConstraints.anchor = GridBagConstraints.EAST;
            panelMenu.add(labelMinPrice, menuConstraints);
            panelMenu.addMouseListener(new MouseListener() {
                @Override // Click menu to go edit it
                public void mouseClicked(MouseEvent event) {
                    if (event.getButton() == MouseEvent.BUTTON1) {
                        window.switchTo(new EditMenu(window));
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

            mainConstraints.gridy++;
            panelMain.add(panelMenu, mainConstraints);
        }

        mainConstraints.gridy++;
        mainConstraints.weighty = 1;
        panelMain.add(Box.createVerticalGlue(), mainConstraints);

        CScroll scrollMain = new CScroll(panelMain);
        constraints.gridy = 2;
        constraints.weighty = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        this.add(scrollMain, constraints);
    }
}
