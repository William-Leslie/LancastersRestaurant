package Screens;

import Resources.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JPanel {
    private JLabel imageLogo = Resources.getLogo(300, 300);
    private JLabel labelUsername = new JLabel("USERNAME");
    private JTextField fieldUsername = new JTextField(20);
    private JLabel labelPassword = new JLabel("PASSWORD");
    private JPasswordField fieldPassword = new JPasswordField(20);
    private JButton buttonLogin = new JButton("Login");

    public Login (JPanel screens) {
        super();
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(0x2b3336));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(this.imageLogo, constraints);

        this.labelUsername.setForeground(new Color(0xaaaaaa));
        this.labelUsername.setFont(Resources.getFont(18));
        constraints.gridy++;
        constraints.insets = new Insets(20, 0, 0, 0);
        this.add(this.labelUsername, constraints);

        this.fieldUsername.setForeground(new Color(0x2b3336));
        this.fieldUsername.setBackground(new Color(0xffffff));
        this.fieldUsername.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0xaaaaaa)));
        this.fieldUsername.setFont(Resources.getFont(18));
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(this.fieldUsername, constraints);

        this.labelPassword.setForeground(new Color(0xaaaaaa));
        this.labelPassword.setFont(Resources.getFont(18));
        constraints.gridy++;
        constraints.insets = new Insets(20, 0, 0, 0);
        this.add(this.labelPassword, constraints);

        this.fieldPassword.setForeground(new Color(0x2b3336));
        this.fieldPassword.setBackground(new Color(0xffffff));
        this.fieldPassword.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0xaaaaaa)));
        this.fieldPassword.setFont(Resources.getFont(18));
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(this.fieldPassword, constraints);

        this.buttonLogin.setForeground(new Color(0x2b3336));
        this.buttonLogin.setBackground(new Color(0xaaaaaa));
        this.buttonLogin.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0xffffff)));
        this.buttonLogin.setFont(Resources.getFont(26));
        this.buttonLogin.setFocusPainted(false);
        constraints.gridy++;
        constraints.insets = new Insets(30, 0, 0, 0);
        this.add(this.buttonLogin, constraints);
    }
}
