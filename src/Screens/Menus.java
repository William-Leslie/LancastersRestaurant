package Screens;

import Components.*;

import javax.swing.*;
import java.awt.*;
import java.time.*;

public class Menus extends JPanel {
    public Menus(JPanel screens) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;

        CNavbar navbar = new CNavbar("Menus", event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Home.name());
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
        monday = monday.plusWeeks(5);
        while(monday.isAfter(today)) {
            monday = monday.minusWeeks(1);

            JPanel panelMenu = new JPanel(new GridBagLayout());
            GridBagConstraints menuConstraints = new GridBagConstraints();
            panelMenu.setBackground(new Color(0x2b3336));
            panelMenu.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));

            CLabel labelDate = new CLabel(monday.toString());
            menuConstraints.gridx++;
            menuConstraints.anchor = GridBagConstraints.WEST;
            panelMenu.add(labelDate, menuConstraints);

            mainConstraints.gridy++;
            panelMain.add(panelMenu, mainConstraints);
        }

        mainConstraints.gridy++;
        mainConstraints.weighty = 1;
        panelMain.add(Box.createVerticalGlue(), mainConstraints);

        // TODO: Theming JScrollPane
        JScrollPane scrollMain = new JScrollPane(panelMain);
        scrollMain.setPreferredSize(new Dimension(0, 0));
        scrollMain.getVerticalScrollBar().setUnitIncrement(8);
        scrollMain.setBorder(null);
        constraints.gridy = 2;
        constraints.weighty = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        this.add(scrollMain, constraints);
    }
}
