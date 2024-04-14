package Components;

import Management.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CNavbar extends JPanel {
    public CNavbar(String title, ActionListener backAction) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(Colors.background);

        CButton buttonBack = new CButton("Back", backAction);
        buttonBack.setPreferredSize(new Dimension(150, 0));
        constraints.gridx++;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        constraints.weightx = 0;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.BOTH;
        this.add(buttonBack, constraints);

        constraints.gridx++;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        constraints.weightx = 1;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.VERTICAL;
        this.add(Box.createHorizontalGlue(), constraints);

        CLogo logo = new CLogo(100, 50);
        logo.setBorder(null);
        constraints.gridx++;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        constraints.weightx = 0;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.VERTICAL;
        this.add(logo, constraints);

        CLabel labelTitle = new CLabel(title, 32);
        constraints.gridx++;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        constraints.weightx = 0;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.VERTICAL;
        this.add(labelTitle, constraints);

        constraints.gridx++;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        constraints.weightx = 1;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.VERTICAL;
        this.add(Box.createHorizontalGlue(), constraints);

        CLabel labelUser = new CLabel("User: " + MAuthUser.username);
        constraints.gridx++;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.anchor = GridBagConstraints.EAST;
        this.add(labelUser, constraints);

        CLabel labelRole = new CLabel("Role: " + MAuthUser.role);
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.weightx = 0;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.anchor = GridBagConstraints.EAST;
        this.add(labelRole, constraints);
    }
}
