package Screens;

import Components.*;

import javax.swing.*;
import java.awt.*;

public class Menus extends JPanel {
    public Menus(JPanel screens) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));
        constraints.fill = GridBagConstraints.HORIZONTAL;

        Navbar navbar = new Navbar("Menus", event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Home.name());
        });
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.gridheight = 1;
        constraints.insets = new Insets(10, 10, 0, 10);
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(navbar, constraints);
    }
}
