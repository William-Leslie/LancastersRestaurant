package Screens;

import Components.*;
import Management.*;
import Resources.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.List;

/**
 * Screen to view and edit menu details
 */
public class EditMenu extends JPanel {
    CButton saveButton;

    public EditMenu(CWindow window, MMenu menu) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(Colors.background);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;

        CNavbar navbar = new CNavbar("Edit Menu", event -> {
            if (this.saveButton.isEnabled()) {
                int confirm = JOptionPane.showConfirmDialog(this, "You have unsaved changes! Discard them?");
                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }
            }
            // TODO: Should this go to Home instead? IMO no but maybe?
            window.switchTo(new Menus(window));
        });
        constraints.gridy = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(10, 10, 0, 10);
        this.add(navbar, constraints);

        JPanel panelMain = new JPanel(new GridBagLayout());
        GridBagConstraints mainConstraints = new GridBagConstraints();
        panelMain.setBackground(Colors.background);
        mainConstraints.fill = GridBagConstraints.BOTH;
        mainConstraints.weightx = 1;
        mainConstraints.insets = new Insets(16, 16, 16, 16);

        List<MWine> cellar = MWine.getCellar();
        assert cellar != null;
        cellar.add(0, null); // Allow unselecting the wine
        MWine[] wines = cellar.toArray(new MWine[0]);

        int iCourse = 0;
        for (MCourse course : menu.courses) {
            JPanel panelCourse = new JPanel(new GridBagLayout());
            GridBagConstraints courseConstraints = new GridBagConstraints();
            panelCourse.setBackground(new Color(0x455a61));
            panelCourse.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
            courseConstraints.fill = GridBagConstraints.BOTH;
            courseConstraints.weightx = 1;
            courseConstraints.anchor = GridBagConstraints.NORTHWEST;

            String courseName = switch (iCourse++) {
                case 0 -> "First Course";
                case 1 -> "Second Course";
                case 2 -> "Third Course";
                default -> iCourse + "th Course";
            };
            CLabel labelCourseName = new CLabel(courseName, 26);
            labelCourseName.setForeground(new Color(0xcccccc));
            courseConstraints.gridy++;
            courseConstraints.insets = new Insets(16, 16, 16, 16);
            panelCourse.add(labelCourseName, courseConstraints);

            for (MDish dish : course.dishes) {
                JPanel panelDish = new JPanel(new GridBagLayout());
                GridBagConstraints dishConstraints = new GridBagConstraints();
                panelDish.setBackground(new Color(0x557b8a));
                panelDish.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
                dishConstraints.fill = GridBagConstraints.BOTH;
                dishConstraints.anchor = GridBagConstraints.NORTHWEST;

                CTextField fieldDishName = new CTextField(dish.name, 22);
                fieldDishName.getDocument().addDocumentListener(new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        this.edited();
                    }

                    public void removeUpdate(DocumentEvent e) {
                        this.edited();
                    }

                    public void insertUpdate(DocumentEvent e) {
                        this.edited();
                    }

                    public void edited() {
                        dish.name = fieldDishName.getText();
                        saveButton.setEnabled(true);
                    }
                });
                dishConstraints.gridx = 1;
                dishConstraints.gridwidth = 1;
                dishConstraints.weightx = 1;
                dishConstraints.gridy = 1;
                dishConstraints.insets = new Insets(16, 16, 16, 16);
                panelDish.add(fieldDishName, dishConstraints);

                CLabel labelDishPrice = new CLabel("Suggested: " + CPrice.of(dish.price) + "    Price: £", 18);
                labelDishPrice.setForeground(new Color(0xcccccc));
                dishConstraints.gridx = 2;
                dishConstraints.gridwidth = 1;
                dishConstraints.weightx = 0;
                dishConstraints.gridy = 1;
                dishConstraints.insets = new Insets(16, 16, 16, 0);
                panelDish.add(labelDishPrice, dishConstraints);

                // TODO: Theme JSpinner
                JSpinner spinnerDishPrice = new JSpinner(new SpinnerNumberModel(dish.price, 0, 99, 0.50));
                spinnerDishPrice.setPreferredSize(new Dimension(75, 0));
                spinnerDishPrice.addChangeListener(e -> {
                    dish.price = (Double) spinnerDishPrice.getValue();
                    this.saveButton.setEnabled(true);
                });
                dishConstraints.gridx = 3;
                dishConstraints.gridwidth = 1;
                dishConstraints.weightx = 0;
                dishConstraints.gridy = 1;
                dishConstraints.insets = new Insets(16, 0, 16, 16);
                panelDish.add(spinnerDishPrice, dishConstraints);

                CTextArea areaDescription = new CTextArea(dish.description, 16);
                areaDescription.getDocument().addDocumentListener(new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        this.edited();
                    }

                    public void removeUpdate(DocumentEvent e) {
                        this.edited();
                    }

                    public void insertUpdate(DocumentEvent e) {
                        this.edited();
                    }

                    public void edited() {
                        dish.description = areaDescription.getText();
                        saveButton.setEnabled(true);
                    }
                });
                areaDescription.setRows(2);
                dishConstraints.gridx = 1;
                dishConstraints.gridwidth = 3;
                dishConstraints.weightx = 1;
                dishConstraints.gridy = 2;
                dishConstraints.insets = new Insets(0, 16, 8, 16);
                panelDish.add(areaDescription, dishConstraints);

                JPanel panelDishAllergens = new JPanel(new GridBagLayout());
                GridBagConstraints dishAllergenConstraints = new GridBagConstraints();
                panelDishAllergens.setBackground(new Color(0x557b8a));
                dishAllergenConstraints.fill = GridBagConstraints.BOTH;

                CLabel labelDishAllergens = new CLabel("Allergens: ", 18);
                labelDishAllergens.setForeground(new Color(0xcccccc));
                dishAllergenConstraints.gridx++;
                dishAllergenConstraints.weightx = 0;
                dishAllergenConstraints.insets = new Insets(0, 0, 0, 0);
                panelDishAllergens.add(labelDishAllergens, dishAllergenConstraints);

                StringBuilder allergens = new StringBuilder();
                for (MIngredient ingredient : dish.ingredients.keySet()) {
                    if (ingredient.allergen != null) {
                        if (!allergens.isEmpty()) {
                            allergens.append(", ");
                        }
                        allergens.append(ingredient.allergen);
                    }
                }
                CTextField fieldDishAllergens = new CTextField(allergens.toString(), 16);
                fieldDishAllergens.setEnabled(false);
                dishAllergenConstraints.gridx++;
                dishAllergenConstraints.weightx = 1;
                dishAllergenConstraints.insets = new Insets(0, 6, 0, 0);
                panelDishAllergens.add(fieldDishAllergens, dishAllergenConstraints);

                CLabel labelWine = new CLabel("Wine: ", 18);
                labelWine.setForeground(new Color(0xcccccc));
                dishAllergenConstraints.gridx++;
                dishAllergenConstraints.weightx = 0;
                dishAllergenConstraints.insets = new Insets(0, 12, 0, 0);
                panelDishAllergens.add(labelWine, dishAllergenConstraints);

                // TODO: theme JComboBox
                JComboBox<MWine> comboWine = new JComboBox<>(wines);
                comboWine.setSelectedIndex(0);
                if (dish.wine != null) {
                    for (int i = 1; i < wines.length; i++) {
                        if (wines[i].id == dish.wine.id) {
                            comboWine.setSelectedIndex(i);
                            break;
                        }
                    }
                }
                comboWine.addActionListener(e -> {
                    dish.wine = (MWine) comboWine.getSelectedItem();
                    this.saveButton.setEnabled(true);
                });
                dishAllergenConstraints.gridx++;
                dishAllergenConstraints.weightx = 1;
                dishAllergenConstraints.insets = new Insets(0, 6, 0, 0);
                panelDishAllergens.add(comboWine, dishAllergenConstraints);

                dishConstraints.gridx = 1;
                dishConstraints.gridwidth = 3;
                dishConstraints.weightx = 1;
                dishConstraints.gridy = 3;
                dishConstraints.insets = new Insets(0, 16, 16, 16);
                panelDish.add(panelDishAllergens, dishConstraints);

                courseConstraints.gridy++;
                courseConstraints.insets = new Insets(0, 16, 16, 16);
                panelCourse.add(panelDish, courseConstraints);
            }

            mainConstraints.gridy++;
            panelMain.add(panelCourse, mainConstraints);
        }

        mainConstraints.gridy++;
        mainConstraints.weighty = 1;
        panelMain.add(Box.createVerticalGlue(), mainConstraints);

        CScroll scrollMain = new CScroll(panelMain);
        constraints.gridy = 2;
        constraints.weighty = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        this.add(scrollMain, constraints);

        this.saveButton = new CButton("Save changes", event -> {
            menu.saveChanges();
            this.saveButton.setEnabled(false);
        });
        this.saveButton.setEnabled(false);

        constraints.gridy++;
        constraints.weighty = 0.05;
        constraints.weightx = 0.1;
        constraints.insets = new Insets(0, 400, 5, 400);
        this.add(saveButton, constraints);
    }
}
