package Screens;

import Resources.Resources;

import javax.swing.*;
import java.awt.*;

public class Splash extends JPanel {
    public Splash(JPanel screens) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel logo = Resources.getLogo(400, 400);
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(logo, constraints);

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        CardLayout cl = (CardLayout) screens.getLayout();
                        cl.show(screens, Screen.Login.name());
                    }
                },
                3000
        );
    }
}
