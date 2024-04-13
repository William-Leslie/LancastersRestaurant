package Screens;

import Components.*;
import Resources.Colors;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {
    public Login(Window window) {
        super(new GridBagLayout());
        this.setBackground(Colors.background);
        GridBagConstraints constraints = new GridBagConstraints(); // Constraints passed to each item
        constraints.fill = GridBagConstraints.HORIZONTAL; // All items stretch horizontally by default

        // Logo
        CLogo logo = new CLogo(300, 300);
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(logo, constraints);

        // Username text
        CLabel labelUsername = new CLabel("USERNAME", 18);
        constraints.gridy++;
        constraints.insets = new Insets(20, 0, 0, 0);
        this.add(labelUsername, constraints);

        // Username field
        // FIXME: Enter should login
        CTextField fieldUsername = new CTextField();
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(fieldUsername, constraints);

        // Password text
        CLabel labelPassword = new CLabel("PASSWORD", 18);
        constraints.gridy++;
        constraints.insets = new Insets(20, 0, 0, 0);
        this.add(labelPassword, constraints);

        // Password field
        // FIXME: Enter should login
        CPasswordField fieldPassword = new CPasswordField();
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(fieldPassword, constraints);

        // Login button
        CButton buttonLogin = new CButton("Login", 26, event -> {
            String username = fieldUsername.getText();
            String password = new String(fieldPassword.getPassword());
            if (username.equals("lancaster") && password.equals("lancaster")) {
                fieldUsername.setText("");
                fieldPassword.setText("");
                window.switchTo(new Home(window));
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login credentials!");
            }
        });
        buttonLogin.setPreferredSize(new Dimension(0, 50));
        constraints.gridy++;
        constraints.insets = new Insets(30, 0, 0, 0);
        this.add(buttonLogin, constraints);
    }
}
