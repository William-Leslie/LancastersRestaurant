package Screens;

import Components.*;

import javax.swing.*;
import java.awt.*;

public class Splash extends JPanel {
    public Splash(JPanel screens) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));
        constraints.fill = GridBagConstraints.HORIZONTAL;

        Logo logo = new Logo(400, 400);
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(logo, constraints);
    }
}
