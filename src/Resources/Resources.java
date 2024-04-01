package Resources;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class Resources {
    private static BufferedImage logo = null;
    private static Font font = null;

    public static JPanel getNavbar(String title, ActionListener backAction) {
        JPanel panelNavbar = new JPanel(new GridBagLayout());
        GridBagConstraints navbarConstraints = new GridBagConstraints();
        panelNavbar.setBackground(new Color(0x2b3336));

        JButton buttonBack = new JButton("Back");
        buttonBack.setForeground(new Color(0x2b3336));
        buttonBack.setBackground(new Color(0xaaaaaa));
        buttonBack.setFont(Resources.getFont(20));
        buttonBack.setFocusPainted(false);
        buttonBack.addActionListener(backAction);
        navbarConstraints.gridx++;
        navbarConstraints.gridy = 1;
        navbarConstraints.gridheight = 2;
        navbarConstraints.weightx = 2;
        navbarConstraints.insets = new Insets(0, 0, 0, 0);
        navbarConstraints.fill = GridBagConstraints.BOTH;
        panelNavbar.add(buttonBack, navbarConstraints);

        navbarConstraints.gridx++;
        navbarConstraints.gridy = 1;
        navbarConstraints.gridheight = 2;
        navbarConstraints.weightx = 5;
        navbarConstraints.insets = new Insets(0, 0, 0, 0);
        navbarConstraints.fill = GridBagConstraints.VERTICAL;
        panelNavbar.add(Box.createHorizontalGlue(), navbarConstraints);

        JLabel logo = Resources.getLogo(100, 100);
        logo.setBorder(null);
        logo.setPreferredSize(new Dimension(100, 50));
        navbarConstraints.gridx++;
        navbarConstraints.gridy = 1;
        navbarConstraints.gridheight = 2;
        navbarConstraints.weightx = 0;
        navbarConstraints.insets = new Insets(0, 0, 0, 0);
        navbarConstraints.fill = GridBagConstraints.VERTICAL;
        panelNavbar.add(logo, navbarConstraints);

        JLabel labelTitle = new JLabel(title);
        labelTitle.setForeground(new Color(0xaaaaaa));
        labelTitle.setFont(Resources.getFont(20));
        navbarConstraints.gridx++;
        navbarConstraints.gridy = 1;
        navbarConstraints.gridheight = 2;
        navbarConstraints.weightx = 0;
        navbarConstraints.insets = new Insets(0, 0, 0, 0);
        navbarConstraints.fill = GridBagConstraints.VERTICAL;
        panelNavbar.add(labelTitle, navbarConstraints);

        navbarConstraints.gridx++;
        navbarConstraints.gridy = 1;
        navbarConstraints.gridheight = 2;
        navbarConstraints.weightx = 5;
        navbarConstraints.insets = new Insets(0, 0, 0, 0);
        navbarConstraints.fill = GridBagConstraints.VERTICAL;
        panelNavbar.add(Box.createHorizontalGlue(), navbarConstraints);

        JLabel labelUser = new JLabel("User: " + "lancaster");
        labelUser.setForeground(new Color(0xaaaaaa));
        labelUser.setFont(Resources.getFont(20));
        navbarConstraints.gridx++;
        navbarConstraints.gridy = 1;
        navbarConstraints.gridheight = 1;
        navbarConstraints.weightx = 0;
        navbarConstraints.insets = new Insets(0, 0, 0, 0);
        navbarConstraints.fill = GridBagConstraints.VERTICAL;
        navbarConstraints.anchor = GridBagConstraints.EAST;
        panelNavbar.add(labelUser, navbarConstraints);

        JLabel labelRole = new JLabel("Role: " + "admin");
        labelRole.setForeground(new Color(0xaaaaaa));
        labelRole.setFont(Resources.getFont(20));
        navbarConstraints.gridy = 2;
        navbarConstraints.gridheight = 1;
        navbarConstraints.weightx = 0;
        navbarConstraints.insets = new Insets(0, 0, 0, 0);
        navbarConstraints.fill = GridBagConstraints.VERTICAL;
        navbarConstraints.anchor = GridBagConstraints.EAST;
        panelNavbar.add(labelRole, navbarConstraints);

        return panelNavbar;
    }

    public static JLabel getLogo(int width, int height) {
        try {
            if(Resources.logo == null) {
                Resources.logo = ImageIO.read(new File("resources/LancastersLogo.jpeg"));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            Resources.logo = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        }
        Image resized = Resources.logo.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(resized));
        logo.setSize(new Dimension(width, height));
        logo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        return logo;
    }

    public static Font getFont(float size) {
        try {
            if(Resources.font == null) {
                Resources.font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/AbrilFatface-Regular.ttf"));
            }
        } catch (IOException | FontFormatException exception) {
            exception.printStackTrace();
            Resources.font = new Font("serif", Font.PLAIN, 20);
        }
        return Resources.font.deriveFont(size);
    }
}
