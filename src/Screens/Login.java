package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JPanel {
    private JButton buttonLogin = new JButton("Login");

    public Login (JPanel screens) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(0x2b3336));

        this.buttonLogin.setBackground(new Color(0xaaaaaa));
        this.add(this.buttonLogin);
    }
}
