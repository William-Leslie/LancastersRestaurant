package Screens;

import Components.*;
import Resources.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Inventory extends JPanel {
    public Inventory(JPanel screens) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Inner panel for top bar, easier to manage
        JPanel panelTopbar = new JPanel(new GridBagLayout());
        GridBagConstraints topbarConstraints = new GridBagConstraints();
        panelTopbar.setBackground(new Color(0x2b3336));

        JButton buttonBack = new JButton("Back");
        buttonBack.setForeground(new Color(0x2b3336));
        buttonBack.setBackground(new Color(0xaaaaaa));
        buttonBack.setFont(Resources.getFont(20));
        buttonBack.setFocusPainted(false);
        buttonBack.addActionListener(event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Home.name());
        });
        topbarConstraints.gridx++;
        topbarConstraints.gridy = 1;
        topbarConstraints.gridheight = 2;
        topbarConstraints.weightx = 2;
        topbarConstraints.insets = new Insets(0, 0, 0, 0);
        topbarConstraints.fill = GridBagConstraints.BOTH;
        panelTopbar.add(buttonBack, topbarConstraints);

        topbarConstraints.gridx++;
        topbarConstraints.gridy = 1;
        topbarConstraints.gridheight = 2;
        topbarConstraints.weightx = 5;
        topbarConstraints.insets = new Insets(0, 0, 0, 0);
        topbarConstraints.fill = GridBagConstraints.VERTICAL;
        panelTopbar.add(Box.createHorizontalGlue(), topbarConstraints);

        Logo logo = new Logo(100, 100);
        logo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        logo.setPreferredSize(new Dimension(100, 50));
        topbarConstraints.gridx++;
        topbarConstraints.gridy = 1;
        topbarConstraints.gridheight = 2;
        topbarConstraints.weightx = 0;
        topbarConstraints.insets = new Insets(0, 0, 0, 0);
        topbarConstraints.fill = GridBagConstraints.VERTICAL;
        panelTopbar.add(logo, topbarConstraints);

        JLabel labelTitle = new JLabel("Inventory");
        labelTitle.setForeground(new Color(0xaaaaaa));
        labelTitle.setFont(Resources.getFont(20));
        topbarConstraints.gridx++;
        topbarConstraints.gridy = 1;
        topbarConstraints.gridheight = 2;
        topbarConstraints.weightx = 0;
        topbarConstraints.insets = new Insets(0, 0, 0, 0);
        topbarConstraints.fill = GridBagConstraints.VERTICAL;
        panelTopbar.add(labelTitle, topbarConstraints);

        topbarConstraints.gridx++;
        topbarConstraints.gridy = 1;
        topbarConstraints.gridheight = 2;
        topbarConstraints.weightx = 5;
        topbarConstraints.insets = new Insets(0, 0, 0, 0);
        topbarConstraints.fill = GridBagConstraints.VERTICAL;
        panelTopbar.add(Box.createHorizontalGlue(), topbarConstraints);

        JLabel labelUser = new JLabel("User: " + "lancaster");
        labelUser.setForeground(new Color(0xaaaaaa));
        labelUser.setFont(Resources.getFont(20));
        topbarConstraints.gridx++;
        topbarConstraints.gridy = 1;
        topbarConstraints.gridheight = 1;
        topbarConstraints.weightx = 0;
        topbarConstraints.insets = new Insets(0, 0, 0, 0);
        topbarConstraints.fill = GridBagConstraints.VERTICAL;
        topbarConstraints.anchor = GridBagConstraints.EAST;
        panelTopbar.add(labelUser, topbarConstraints);

        JLabel labelRole = new JLabel("Role: " + "admin");
        labelRole.setForeground(new Color(0xaaaaaa));
        labelRole.setFont(Resources.getFont(20));
        topbarConstraints.gridy = 2;
        topbarConstraints.gridheight = 1;
        topbarConstraints.weightx = 0;
        topbarConstraints.insets = new Insets(0, 0, 0, 0);
        topbarConstraints.fill = GridBagConstraints.VERTICAL;
        topbarConstraints.anchor = GridBagConstraints.EAST;
        panelTopbar.add(labelRole, topbarConstraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.gridheight = 1;
        constraints.insets = new Insets(10, 10, 0, 10);
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(panelTopbar, constraints);
        JLabel labelIngredient = new JLabel("ingredient");
        labelIngredient.setForeground(new Color(0xaaaaaa));
        labelIngredient.setFont(Resources.getFont(18));
        constraints.gridy++;
        constraints.insets = new Insets(10, 0, 0, 0);
        this.add(labelIngredient, constraints);

        //dummy data for now
       String[][] rec = {
                { "1", "Steve", "AUS" },
                { "2", "Virat", "IND" },
                { "3", "Kane", "NZ" },
        };
        String[] header = { "IngredientID", "Name", "StockLevel" };
        JTable inventoryTable = new JTable(rec,header);
        inventoryTable.setRowHeight(30);
        JScrollPane selection = new JScrollPane(inventoryTable);


        inventoryTable.setForeground(new Color(0x2b3336));
        inventoryTable.setBackground(new Color(0xffffff));
        inventoryTable.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0xaaaaaa)));
        inventoryTable.setFont(Resources.getFont(15));
        constraints.gridy++;
        constraints.insets = new Insets(10, 0, 0, 0);
        this.add(selection, constraints);

    

        String inventoryNames[]= { "ingredient", "dish"};

      /*  JList<String> inventorySelection = new JList<>(inventoryNames);
        inventorySelection.setForeground(new Color(0x2b3336));
        inventorySelection.setBackground(new Color(0xffffff));
        inventorySelection.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0xaaaaaa)));
        inventorySelection.setFont(Resources.getFont(18));
        constraints.gridy++;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridheight = 1;
        constraints.insets = new Insets(10, 0, 0, 0);
        this.add(inventorySelection,constraints);*/

        JTextField ingredientName = new JTextField(20);
        ingredientName.setForeground(new Color(0x2b3336));
        ingredientName.setBackground(new Color(0xffffff));
        ingredientName.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0xaaaaaa)));
        ingredientName.setFont(Resources.getFont(18));
        constraints.gridy++;
        constraints.insets = new Insets(10, 200, 0, 200);
        this.add(ingredientName, constraints);

        JPanel panelButtons = new JPanel(new GridBagLayout());
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        panelButtons.setBackground(new Color(0x2b3336));
        buttonConstraints.fill = GridBagConstraints.BOTH;
        buttonConstraints.weightx = 1;
        buttonConstraints.weighty = 1;
        buttonConstraints.insets = new Insets(0, 300, 0, 300);

        JButton buttonAdd = new JButton("Add");
        buttonAdd.setForeground(new Color(0xcccccc));
        buttonAdd.setBackground(new Color(0x557b8a));
        buttonAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonAdd.setFont(Resources.getFont(26));
        buttonAdd.setFocusPainted(false);
        buttonConstraints.gridy++;
        panelButtons.add(buttonAdd, buttonConstraints);



        constraints.gridx = 1;
        constraints.gridy = -1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 0, 0, 0);
        //panelButtons.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        this.add(panelButtons, constraints);






    }


}
