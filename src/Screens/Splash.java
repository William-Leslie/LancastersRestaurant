package Screens;

import Components.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Screen shown at startup before login
 */
public class Splash extends JPanel {
    public Splash(CWindow window) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(Colors.background);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        CLogo logo = new CLogo(400, 400);
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(logo, constraints);

        // Switch to log in screen after 3 seconds
        java.util.TimerTask timerTask = new java.util.TimerTask() {
            @Override
            public void run() {
                window.switchTo(new Login(window));
            }
        };
        new java.util.Timer().schedule(timerTask, 3000);

        this.addMouseListener(new MouseListener() {
            @Override // Click to skip splashscreen
            public void mouseClicked(MouseEvent event) {
                if (event.getButton() == MouseEvent.BUTTON1) {
                    timerTask.cancel();
                    timerTask.run();
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
    }
}
