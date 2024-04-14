package Screens;

import Components.*;
import Management.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Wines extends JPanel {
    public Wines(CWindow window) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(Colors.background);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.gridx = 1;
        constraints.gridwidth = 6;

        CNavbar navbar = new CNavbar("Wines", event -> window.switchTo(new Home(window)));
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
        panelMain.add(Box.createVerticalGlue(), mainConstraints);

        // HEADERS
        mainConstraints.gridx = 1;
        mainConstraints.gridy++;
        CLabel headerName = new CLabel("NAME", 24);
        headerName.setForeground(Colors.blue);
        mainConstraints.anchor = GridBagConstraints.WEST;
        mainConstraints.insets = new Insets(8, 0, 8, 80);
        panelMain.add(headerName, mainConstraints);

        mainConstraints.gridx++;
        CLabel headerYear = new CLabel("YEAR", 24);
        headerYear.setForeground(Colors.blue);
        mainConstraints.anchor = GridBagConstraints.CENTER;
        mainConstraints.insets = new Insets(8, 40, 8, 80);
        panelMain.add(headerYear, mainConstraints);

        mainConstraints.gridx++;
        CLabel headerPrice = new CLabel("PRICE", 24);
        headerPrice.setForeground(Colors.blue);
        mainConstraints.anchor = GridBagConstraints.CENTER;
        panelMain.add(headerPrice, mainConstraints);

        mainConstraints.gridx++;
        CLabel headerStock = new CLabel("STOCK", 24);
        headerStock.setForeground(Colors.blue);
        mainConstraints.anchor = GridBagConstraints.CENTER;
        mainConstraints.insets = new Insets(8, 40, 8, 120);
        panelMain.add(headerStock, mainConstraints);

        List<MWine> wines = MWine.getCellar();

        // DATA
        // FIXME: sort by out of stock and/or in upcoming menus
        for (MWine wine : wines) {
            mainConstraints.gridx = 0;
            mainConstraints.weightx = 1.5;
            mainConstraints.gridy++;
            mainConstraints.weighty = 1;

            CLabel labelName = new CLabel(wine.name);
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.WEST;
            mainConstraints.insets = new Insets(8, 0, 8, 80);
            panelMain.add(labelName, mainConstraints);

            CLabel labelYear = new CLabel(wine.year);
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.CENTER;
            mainConstraints.insets = new Insets(8, 40, 8, 80);
            panelMain.add(labelYear, mainConstraints);

            CLabel labelPrice = new CLabel(CPrice.of(wine.price));
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.CENTER;
            mainConstraints.insets = new Insets(8, 40, 8, 80);
            panelMain.add(labelPrice, mainConstraints);

            CLabel labelStock = new CLabel(Integer.toString(wine.stock));
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.CENTER;
            mainConstraints.insets = new Insets(8, 40, 8, 120);
            panelMain.add(labelStock, mainConstraints);

            if (wine.stock == 0) {
                labelName.setForeground(Colors.red);
                labelYear.setForeground(Colors.red);
                labelPrice.setForeground(Colors.red);
                labelStock.setForeground(Colors.red);
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

        // NAME
        bottomConstraints.gridx++;
        bottomConstraints.fill = GridBagConstraints.VERTICAL;
        bottomConstraints.anchor = GridBagConstraints.EAST;
        bottomConstraints.insets = new Insets(5, 1, 5, 1);
        CLabel editName = new CLabel("Name: ");
        editName.setForeground(new Color(33, 33, 33));
        panelBottom.add(editName, bottomConstraints);

        bottomConstraints.gridx++;
        bottomConstraints.fill = GridBagConstraints.BOTH;
        bottomConstraints.anchor = GridBagConstraints.WEST;
        CTextField nameText = new CTextField(" Merlot", 16);
        nameText.setForeground(new Color(33, 33, 33)); // slightly lighter than black
        nameText.setPreferredSize(new Dimension(80, 40));
        panelBottom.add(nameText, bottomConstraints);

        // YEAR
        bottomConstraints.gridx++;
        bottomConstraints.fill = GridBagConstraints.VERTICAL;
        bottomConstraints.anchor = GridBagConstraints.EAST;
        CLabel labelHalfHour = new CLabel("Year: ");
        labelHalfHour.setForeground(new Color(33, 33, 33));
        panelBottom.add(labelHalfHour, bottomConstraints);

        bottomConstraints.gridx++;
        bottomConstraints.fill = GridBagConstraints.BOTH;
        bottomConstraints.anchor = GridBagConstraints.WEST;
        CTextField yearText = new CTextField(" 2024", 16);
        yearText.setForeground(new Color(33, 33, 33));
        yearText.setPreferredSize(new Dimension(10, 40));
        panelBottom.add(yearText, bottomConstraints);

        // PRICE
        bottomConstraints.gridx++;
        bottomConstraints.fill = GridBagConstraints.VERTICAL;
        bottomConstraints.anchor = GridBagConstraints.EAST;
        CLabel labelPreBook = new CLabel("Price: £");
        labelPreBook.setForeground(new Color(33, 33, 33));
        panelBottom.add(labelPreBook, bottomConstraints);

        bottomConstraints.gridx++;
        bottomConstraints.fill = GridBagConstraints.BOTH;
        bottomConstraints.anchor = GridBagConstraints.WEST;
        CTextField priceText = new CTextField(" 19.99", 16);
        priceText.setForeground(new Color(33, 33, 33));
        priceText.setPreferredSize(new Dimension(10, 40));
        panelBottom.add(priceText, bottomConstraints);

        // STOCK
        bottomConstraints.gridx++;
        bottomConstraints.fill = GridBagConstraints.VERTICAL;
        bottomConstraints.anchor = GridBagConstraints.EAST;
        CLabel labelMaxDining = new CLabel("Stock:");
        labelMaxDining.setForeground(new Color(33, 33, 33));
        panelBottom.add(labelMaxDining, bottomConstraints);

        bottomConstraints.gridx++;
        bottomConstraints.fill = GridBagConstraints.BOTH;
        bottomConstraints.anchor = GridBagConstraints.WEST;
        JSpinner spinnerMaxDining = new JSpinner(new SpinnerNumberModel(1, 0, 99, 1));
        spinnerMaxDining.setPreferredSize(new Dimension(1, 1));
        panelBottom.add(spinnerMaxDining, bottomConstraints);

        // ADD WINE
        CButton wineButton = new CButton("Add wine", event -> {
            // FIXME: Add wine to records, then display
        });
        wineButton.setForeground(Colors.background);
        wineButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Colors.background));

        bottomConstraints.gridx++;
        bottomConstraints.fill = GridBagConstraints.BOTH;
        bottomConstraints.anchor = GridBagConstraints.EAST;
        bottomConstraints.insets = new Insets(5, 100, 5, 50);
        panelBottom.add(wineButton, bottomConstraints);

        // ADD BOTTOM PANEL
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(panelBottom, constraints);
    }
}
