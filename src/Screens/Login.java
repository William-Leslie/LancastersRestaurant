package Screens;

import Resources.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JPanel {
    public Login(JPanel screens) {
        super(new GridBagLayout());
        this.setBackground(new Color(0x2b3336));
        GridBagConstraints constraints = new GridBagConstraints(); // Constraints passed to each item
        constraints.fill = GridBagConstraints.HORIZONTAL; // All items stretch horizontally by default

        // Logo
        JLabel imageLogo = Resources.getLogo(300, 300);
        imageLogo.addMouseListener(new MouseListener() {
            @Override // Click logo to go back to index
            public void mouseClicked(MouseEvent event) {
                if (event.getButton() == MouseEvent.BUTTON1) {
                    CardLayout cl = (CardLayout) screens.getLayout();
                    cl.show(screens, Screen.Index.name());
                }
            }

            @Override
            public void mousePressed(MouseEvent event) {
            }

            @Override
            public void mouseReleased(MouseEvent event) {
            }

            @Override
            public void mouseEntered(MouseEvent event) {
            }

            @Override
            public void mouseExited(MouseEvent event) {
            }
        });
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(imageLogo, constraints);

        // Username text
        JLabel labelUsername = new JLabel("USERNAME");
        labelUsername.setForeground(new Color(0xaaaaaa));
        labelUsername.setFont(Resources.getFont(18));
        constraints.gridy++;
        constraints.insets = new Insets(20, 0, 0, 0);
        this.add(labelUsername, constraints);

        // Username field
        JTextField fieldUsername = new JTextField(20);
        fieldUsername.setForeground(new Color(0x2b3336));
        fieldUsername.setBackground(new Color(0xffffff));
        fieldUsername.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0xaaaaaa)));
        fieldUsername.setFont(Resources.getFont(18));
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(fieldUsername, constraints);

        // Password text
        JLabel labelPassword = new JLabel("PASSWORD");
        labelPassword.setForeground(new Color(0xaaaaaa));
        labelPassword.setFont(Resources.getFont(18));
        constraints.gridy++;
        constraints.insets = new Insets(20, 0, 0, 0);
        this.add(labelPassword, constraints);

        // Password field
        JPasswordField fieldPassword = new JPasswordField(20);
        fieldPassword.setForeground(new Color(0x2b3336));
        fieldPassword.setBackground(new Color(0xffffff));
        fieldPassword.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0xaaaaaa)));
        fieldPassword.setFont(Resources.getFont(18));
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(fieldPassword, constraints);

        // Login button
        JButton buttonLogin = new JButton("Login");
        buttonLogin.setForeground(new Color(0x2b3336));
        buttonLogin.setBackground(new Color(0xaaaaaa));
        buttonLogin.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0xffffff)));
        buttonLogin.setFont(Resources.getFont(26));
        buttonLogin.setFocusPainted(false);
        buttonLogin.addActionListener(event -> {
            String username = fieldUsername.getText();
            String password = new String(fieldPassword.getPassword());
            if (username.equals("lancaster") && password.equals("lancaster")) {
                CardLayout cl = (CardLayout) screens.getLayout();
                cl.show(screens, Screen.Selection.name());
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login credentials!");
            }
        });
        constraints.gridy++;
        constraints.insets = new Insets(30, 0, 0, 0);
        this.add(buttonLogin, constraints);
    }
}
