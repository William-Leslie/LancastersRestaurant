import Components.*;

import javax.swing.*;

/**
 * Main class to run the program
 */
public class Main {

    /** Start the program by showing the main window
     * @param args commandline arguments received, unused
     */
    public static void main(String[] args) {
        // Create and show window in event loop
        SwingUtilities.invokeLater(() -> new CWindow().setVisible(true));
    }
}
