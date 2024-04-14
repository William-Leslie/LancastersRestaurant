import Components.*;

import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        // Create and show window in event loop
        SwingUtilities.invokeLater(() -> new CWindow().setVisible(true));
    }
}
