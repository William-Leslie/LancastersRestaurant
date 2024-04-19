package Components;

import Screens.*;

import javax.swing.*;
import java.awt.*;

/**
 * Main window component
 * <p> Houses one active Screen at a time, which handled the logic to switch active Screen
 * <p> Each Screen should pass a reference to its CWindow object to allow switching active Screen
 * <p> Defaults to showing the Splash Screen right away
 */
public class CWindow extends JFrame {
    private final JPanel viewport;
    private JPanel screen;

    /** Create a main window component
     */
    public CWindow() {
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

    /** Switch what Screen is currently being shown in this CWindow
     * Screen objects may be created and switched to on-the-fly
     * @param screen new screen to show on the window
     */
    public void switchTo(JPanel screen) {
        this.viewport.add(screen);
        if (this.screen != null) {
            this.viewport.remove(this.screen);
        }
        this.screen = screen;
    }
}
