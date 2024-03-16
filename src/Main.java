import Screens.*;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
    public Main() {
        // Initialize window with title
        super("Lancaster's Restaurant");

        // Screens contained in a CardLayout manager, must be passed to each screen to be able to change active screen
        JPanel screens = new JPanel(new CardLayout());

        // Create all screens and pass screens manager reference, each screen is identified by Screen enum name
        screens.add(new Screens.Index(screens), Screen.Index.name());
        screens.add(new Screens.Login(screens), Screen.Login.name());
        screens.add(new Screens.Selection(screens), Screen.Selection.name());
        screens.add(new Screens.Home(screens), Screen.Home.name());

        // Show initial screen
        CardLayout cl = (CardLayout) screens.getLayout();
        cl.show(screens, Screen.Index.name());

        // Add screens manager to main window
        this.add(screens);
        this.pack();

        // Set main window configuration
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(800, 800));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Create and show window in event loop
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}