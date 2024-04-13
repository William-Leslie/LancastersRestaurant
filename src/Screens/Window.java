package Screens;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private final JPanel viewport;
    private JPanel screen;

    public Window() {
        // Initialize window with title
        super("Lancaster's Restaurant");

        // Screens contained in panel with CardLayout, passed to each screen to be able to change active screen
        this.viewport = new JPanel(new CardLayout());
        CardLayout cl = (CardLayout) this.viewport.getLayout();

        // Show splash screen, new screens are created on the fly
        this.switchTo(new Splash(this));
        cl.show(this.viewport, null);

        // Add screens manager to main window
        this.add(this.viewport);
        this.pack();

        // Set main window configuration
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(1100, 700));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void switchTo(JPanel screen) {
        this.viewport.add(screen);
        if (this.screen != null) {
            this.viewport.remove(this.screen);
        }
        this.screen = screen;
    }
}
