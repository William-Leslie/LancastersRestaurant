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
        super(new GridBagLayout());
        this.setBackground(new Color(0x2b3336));
        GridBagConstraints constraints = new GridBagConstraints(); // Constraints passed to each item
        constraints.fill = GridBagConstraints.HORIZONTAL; // All items stretch horizontally by default

        // Logo
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(this.imageLogo, constraints);

        // Username text
        this.labelUsername.setForeground(new Color(0xaaaaaa));
        this.labelUsername.setFont(Resources.getFont(18));
        constraints.gridy++;
        constraints.insets = new Insets(20, 0, 0, 0);
        this.add(this.labelUsername, constraints);

        // Username field
        this.fieldUsername.setForeground(new Color(0x2b3336));
        this.fieldUsername.setBackground(new Color(0xffffff));
        this.fieldUsername.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0xaaaaaa)));
        this.fieldUsername.setFont(Resources.getFont(18));
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(this.fieldUsername, constraints);

        // Password text
        this.labelPassword.setForeground(new Color(0xaaaaaa));
        this.labelPassword.setFont(Resources.getFont(18));
        constraints.gridy++;
        constraints.insets = new Insets(20, 0, 0, 0);
        this.add(this.labelPassword, constraints);

        // Password field
        this.fieldPassword.setForeground(new Color(0x2b3336));
        this.fieldPassword.setBackground(new Color(0xffffff));
        this.fieldPassword.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0xaaaaaa)));
        this.fieldPassword.setFont(Resources.getFont(18));
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(this.fieldPassword, constraints);

        // Login button
        this.buttonLogin.setForeground(new Color(0x2b3336));
        this.buttonLogin.setBackground(new Color(0xaaaaaa));
        this.buttonLogin.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0xffffff)));
        this.buttonLogin.setFont(Resources.getFont(26));
        this.buttonLogin.setFocusPainted(false);
        this.buttonLogin.addActionListener(event -> {
            String username = this.fieldUsername.getText();
            String password = new String(this.fieldPassword.getPassword());
            if(username.equals("lancaster") && password.equals("lancaster")) {
                CardLayout cl = (CardLayout)screens.getLayout();
                cl.show(screens, Screen.Selection.name());
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login credentials!");
            }
        });
        constraints.gridy++;
        constraints.insets = new Insets(30, 0, 0, 0);
        this.add(this.buttonLogin, constraints);
    }
}
