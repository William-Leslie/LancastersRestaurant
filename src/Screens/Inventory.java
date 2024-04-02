package Screens;

import Components.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;

public class Inventory extends JPanel {
    public Inventory(JPanel screens) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;

        CNavbar navbar = new CNavbar("Inventory", event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Home.name());
        });
        constraints.gridx = 1;
        constraints.gridy++;
        constraints.weighty = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(10, 10, 0, 10);
        this.add(navbar, constraints);

        // FIXME: Dummy data
        // TODO: Add units and prices
        String[][] ingredientsData = {
            {"Milk", "10", "20"},
            {"Egg", "20", "15"},
            {"Flour", "30", "10"},
        };
        String[] IngredientsHeader = {"Ingredient", "In Stock", "Minimum Stock"};

        // FIXME: Theme JTable
        JTable tableInventory = new JTable(ingredientsData, IngredientsHeader);
        tableInventory.setForeground(new Color(0x2b3336));
        tableInventory.setRowHeight(30);
        tableInventory.setFont(Resources.getFont(20));

        CScroll scrollInventory = new CScroll(tableInventory);
        scrollInventory.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xaaaaaa)));
        constraints.gridx = 1;
        constraints.gridy++;
        constraints.weighty = 1;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(10, 10, 0, 10);
        this.add(scrollInventory, constraints);

        CTextField fieldIngredient = new CTextField();
        constraints.gridx = 1;
        constraints.gridy++;
        constraints.weightx = 6;
        constraints.weighty = 0;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        this.add(fieldIngredient, constraints);

        CButton buttonAdd = new CButton("Add", null);
        constraints.gridx = 2;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 0, 10, 10);
        this.add(buttonAdd, constraints);
    }
}
