package Screens;

import Components.*;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {
    public Login(JPanel screens) {
        super(new GridBagLayout());
        this.setBackground(new Color(0x2b3336));
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
                CardLayout cl = (CardLayout) screens.getLayout();
                cl.show(screens, Screen.Home.name());
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login credentials!");
            }
        });
        constraints.gridy++;
        constraints.insets = new Insets(30, 0, 0, 0);
        this.add(buttonLogin, constraints);
    }
}
