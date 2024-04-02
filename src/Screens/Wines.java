package Screens;

import Components.*;

import javax.swing.*;
import java.awt.*;

public class Wines extends JPanel {
    public Wines(JPanel screens) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;

        CNavbar navbar = new CNavbar("Wines", event -> {
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
