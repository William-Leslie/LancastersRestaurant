package Screens;

import Components.*;
import Management.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;

/**
 * Screen to log into the program after the splashscreen
 */
public class Login extends JPanel {
    CWindow window;
    CTextField fieldUsername;
    CPasswordField fieldPassword;

    public Login(CWindow window) {
        super(new GridBagLayout());
        this.window = window;
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
        this.fieldUsername = new CTextField();
        this.fieldUsername.addActionListener(e -> this.login());
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(this.fieldUsername, constraints);

        // Password text
        CLabel labelPassword = new CLabel("PASSWORD", 18);
        constraints.gridy++;
        constraints.insets = new Insets(20, 0, 0, 0);
        this.add(labelPassword, constraints);

        // Password field
        this.fieldPassword = new CPasswordField();
        this.fieldPassword.addActionListener(e -> this.login());
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(this.fieldPassword, constraints);

        // Login button
        CButton buttonLogin = new CButton("Login", 26, event -> this.login());
        buttonLogin.setPreferredSize(new Dimension(0, 50));
        constraints.gridy++;
        constraints.insets = new Insets(30, 0, 0, 0);
        this.add(buttonLogin, constraints);
    }

    private void login() {
        String username = this.fieldUsername.getText();
        String password = new String(this.fieldPassword.getPassword());

        if (MAuthUser.login(username, password)) {
            this.fieldUsername.setText("");
            this.fieldPassword.setText("");
            this.window.switchTo(new Home(this.window));
        } else {
            JOptionPane.showMessageDialog(this, "Invalid login credentials!");
        }
    }
}
