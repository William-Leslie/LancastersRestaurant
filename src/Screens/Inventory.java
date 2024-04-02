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
        String[][] rec = {
            {"1", "Steve", "AUS"},
            {"2", "Virat", "IND"},
            {"3", "Kane", "NZ"},
        };
        String[] header = {"IngredientID", "Name", "StockLevel"};
        JTable inventoryTable = new JTable(rec, header);
        inventoryTable.setRowHeight(30);
        JScrollPane selection = new JScrollPane(inventoryTable);

        // TODO: Theming JTable
        inventoryTable.setForeground(new Color(0x2b3336));
        // inventoryTable.setBackground(new Color(0x455a61));
        selection.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xaaaaaa)));
        inventoryTable.setFont(Resources.getFont(15));
        constraints.gridx = 1;
        constraints.gridy++;
        constraints.weighty = 1;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(10, 10, 0, 10);
        this.add(selection, constraints);

        String[] inventoryNames = {"ingredient", "dish"};

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
        constraints.gridx = 1;
        constraints.gridy++;
        constraints.weighty = 0;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        this.add(ingredientName, constraints);

        JButton buttonAdd = new JButton("Add");
        buttonAdd.setForeground(new Color(0xcccccc));
        buttonAdd.setBackground(new Color(0x557b8a));
        buttonAdd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        buttonAdd.setFont(Resources.getFont(26));
        buttonAdd.setFocusPainted(false);
        constraints.gridx = 2;
        constraints.weighty = 0;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 0, 10, 10);
        this.add(buttonAdd, constraints);
    }
}
