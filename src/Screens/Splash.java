package Screens;

import Components.*;
import Resources.Colors;

import javax.swing.*;
import java.awt.*;

public class Splash extends JPanel {
    public Splash(Window window) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(Colors.background);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        CLogo logo = new CLogo(400, 400);
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(logo, constraints);

        // Switch to log in screen after 3 seconds
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        window.switchTo(new Login(window));
                    }
                },
                3000
        );
    }
}
