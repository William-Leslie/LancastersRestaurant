package Screens;

import Components.*;
import Management.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.util.*;
import java.util.List;

public class Inventory extends JPanel {
    public Inventory(CWindow window) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(Colors.background);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.gridx = 1;
        constraints.gridwidth = 6;

        CNavbar navbar = new CNavbar("Inventory", event -> window.switchTo(new Home(window)));
        constraints.gridy = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(10, 10, 0, 10);
        this.add(navbar, constraints);

        JPanel panelMain = new JPanel(new GridBagLayout());
        GridBagConstraints mainConstraints = new GridBagConstraints();
        panelMain.setBackground(Colors.background);
        mainConstraints.weightx = 1;
        mainConstraints.weighty = 1;
        mainConstraints.fill = GridBagConstraints.BOTH;
        mainConstraints.insets = new Insets(48, 96, 16, 8);

        // HEADERS
        mainConstraints.gridx = 1;
        mainConstraints.gridy++;
        CLabel headerOrder = new CLabel("ORDER", 24);
        headerOrder.setForeground(Colors.blue);
        mainConstraints.anchor = GridBagConstraints.WEST;
        mainConstraints.insets = new Insets(8, 80, 8, 40);
        panelMain.add(headerOrder, mainConstraints);

        mainConstraints.gridx++;
        CLabel headerName = new CLabel("NAME", 24);
        headerName.setForeground(Colors.blue);
        mainConstraints.anchor = GridBagConstraints.CENTER;
        mainConstraints.insets = new Insets(8, 40, 8, 40);
        panelMain.add(headerName, mainConstraints);

        mainConstraints.gridx++;
        CLabel headerStock = new CLabel("STOCK", 24);
        headerStock.setForeground(Colors.blue);
        mainConstraints.anchor = GridBagConstraints.CENTER;
        mainConstraints.insets = new Insets(8, 40, 8, 40);
        panelMain.add(headerStock, mainConstraints);

        mainConstraints.gridx++;
        CLabel headerPrice = new CLabel("PRICE", 24);
        headerPrice.setForeground(Colors.blue);
        mainConstraints.anchor = GridBagConstraints.CENTER;
        mainConstraints.insets = new Insets(8, 40, 8, 80);
        panelMain.add(headerPrice, mainConstraints);

        List<MIngredient> ingredients = MIngredient.getInventory();
        HashMap<MIngredient, JCheckBox> checkboxes = new HashMap<>();

        // DATA
        // TODO: sort by out of stock and/or in upcoming menus
        for (MIngredient ingredient : ingredients) {
            mainConstraints.gridx = 0;
            mainConstraints.weightx = 1.5;
            mainConstraints.gridy++;
            mainConstraints.weighty = 1;

            JCheckBox boxOrder = new JCheckBox("Add to order", false);
            boxOrder.setBackground(Colors.background);
            boxOrder.setForeground(Colors.text);
            boxOrder.setFocusPainted(false);
            boxOrder.setFont(Resources.getFont(18));
            boxOrder.addActionListener(e -> {
                if (boxOrder.isSelected()) {
                    boxOrder.setForeground(Colors.primary);
                } else {
                    boxOrder.setForeground(Colors.text);
                }
            });
            checkboxes.put(ingredient, boxOrder);
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.WEST;
            mainConstraints.insets = new Insets(8, 80, 8, 40);
            panelMain.add(boxOrder, mainConstraints);

            CLabel labelName = new CLabel(ingredient.name);
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.CENTER;
            mainConstraints.insets = new Insets(8, 40, 8, 40);
            panelMain.add(labelName, mainConstraints);

            CLabel labelStock = new CLabel(ingredient.stock + "/" + ingredient.threshold + ingredient.unit);
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.CENTER;
            mainConstraints.insets = new Insets(8, 40, 8, 40);
            panelMain.add(labelStock, mainConstraints);

            CLabel labelPrice = new CLabel(CPrice.of(ingredient.price));
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.CENTER;
            mainConstraints.insets = new Insets(8, 40, 8, 80);
            panelMain.add(labelPrice, mainConstraints);

            if (ingredient.stock < ingredient.threshold) {
                labelName.setForeground(Colors.red);
                labelStock.setForeground(Colors.red);
                labelPrice.setForeground(Colors.red);
            }
        }

        CScroll scrollMain = new CScroll(panelMain);
        constraints.gridy = 2;
        constraints.weighty = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        this.add(scrollMain, constraints);

        // Parameters on bottom
        constraints.gridx = 1;
        constraints.gridy++;
        constraints.weighty = 0;
        constraints.gridwidth = 1;

        JPanel panelBottom = new JPanel(new GridBagLayout());
        GridBagConstraints bottomConstraints = new GridBagConstraints();
        bottomConstraints.gridx = 0;
        bottomConstraints.weightx = 1;

        CButton selectLowButton = new CButton("Select Low Stock", event -> {
            for (HashMap.Entry<MIngredient, JCheckBox> entry : checkboxes.entrySet()) {
                boolean selected = entry.getKey().stock < entry.getKey().threshold;
                entry.getValue().setSelected(selected);
                if (selected) {
                    entry.getValue().setForeground(Colors.primary);
                } else {
                    entry.getValue().setForeground(Colors.text);
                }
            }
        });
        selectLowButton.setForeground(Colors.background);
        selectLowButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Colors.background));
        bottomConstraints.gridx++;
        bottomConstraints.fill = GridBagConstraints.BOTH;
        bottomConstraints.anchor = GridBagConstraints.EAST;
        bottomConstraints.insets = new Insets(5, 80, 5, 40);
        panelBottom.add(selectLowButton, bottomConstraints);

        CButton selectAllButton = new CButton("Select All", event -> {
            for (HashMap.Entry<MIngredient, JCheckBox> entry : checkboxes.entrySet()) {
                entry.getValue().setSelected(true);
                entry.getValue().setForeground(Colors.primary);
            }
        });
        selectAllButton.setForeground(Colors.background);
        selectAllButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Colors.background));
        bottomConstraints.gridx++;
        bottomConstraints.fill = GridBagConstraints.BOTH;
        bottomConstraints.anchor = GridBagConstraints.EAST;
        bottomConstraints.insets = new Insets(5, 40, 5, 40);
        panelBottom.add(selectAllButton, bottomConstraints);

        CButton selectNoneButton = new CButton("Unselect All", event -> {
            for (HashMap.Entry<MIngredient, JCheckBox> entry : checkboxes.entrySet()) {
                entry.getValue().setSelected(false);
                entry.getValue().setForeground(Colors.text);
            }
        });
        selectNoneButton.setForeground(Colors.background);
        selectNoneButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Colors.background));
        bottomConstraints.gridx++;
        bottomConstraints.fill = GridBagConstraints.BOTH;
        bottomConstraints.anchor = GridBagConstraints.EAST;
        bottomConstraints.insets = new Insets(5, 40, 5, 40);
        panelBottom.add(selectNoneButton, bottomConstraints);

        CButton orderButton = new CButton("Order Selected", event -> {
            MOrder order = new MOrder();
            order.ordered = LocalDate.now();
            order.arrival = order.ordered.plusDays(7);
            order.items = new HashMap<>();
            for (HashMap.Entry<MIngredient, JCheckBox> entry : checkboxes.entrySet()) {
                if (entry.getValue().isSelected()) {
                    order.items.put(entry.getKey(), entry.getKey().threshold);
                    entry.getValue().setSelected(false);
                    entry.getValue().setForeground(Colors.text);
                }
            }
            if (order.items.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nothing selected to order!");
                return;
            }
            order.addToDB();
            JOptionPane.showMessageDialog(this, "Ordered successfully!");
        });
        orderButton.setForeground(Colors.background);
        orderButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Colors.background));
        bottomConstraints.gridx++;
        bottomConstraints.fill = GridBagConstraints.BOTH;
        bottomConstraints.anchor = GridBagConstraints.EAST;
        bottomConstraints.insets = new Insets(5, 40, 5, 80);
        panelBottom.add(orderButton, bottomConstraints);

        // ADD BOTTOM PANEL
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(panelBottom, constraints);
    }
}
