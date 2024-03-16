import Screens.Screen;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
    private JPanel screens = new JPanel(new CardLayout());

    public Main() {
        super("Lancaster's Restaurant");

        this.screens.add(new Screens.Index(this.screens), Screen.Index.name());
        this.screens.add(new Screens.Login(this.screens), Screen.Login.name());
        this.screens.add(new Screens.Selection(this.screens), Screen.Selection.name());
        this.screens.add(new Screens.Home(this.screens), Screen.Home.name());

        CardLayout cl = (CardLayout)this.screens.getLayout();
        cl.show(this.screens, Screen.Index.name());

        this.add(this.screens);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(200, 200));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}