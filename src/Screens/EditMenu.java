package Screens;

import Components.*;

import javax.swing.*;
import java.awt.*;

public class EditMenu extends JPanel {
    // FIXME: Dummy data
    private static class Dish {
        public String name;
        public String description;
        public int price;

        private Dish(String name, String description, int price) {
            this.name = name;
            this.description = description;
            this.price = price;
        }
    }

    // FIXME: Dummy data
    private static class Course {
        public String name;
        public Dish[] dishes;

        private Course(String name, Dish[] dishes) {
            this.name = name;
            this.dishes = dishes;
        }
    }

    public EditMenu(JPanel screens) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;

        CNavbar navbar = new CNavbar("Edit Menu", event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Menus.name());
        });
        constraints.gridy = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(10, 10, 0, 10);
        this.add(navbar, constraints);

        JPanel panelMain = new JPanel(new GridBagLayout());
        GridBagConstraints mainConstraints = new GridBagConstraints();
        panelMain.setBackground(new Color(0x2b3336));
        mainConstraints.fill = GridBagConstraints.BOTH;
        mainConstraints.weightx = 1;
        mainConstraints.insets = new Insets(16, 16, 16, 16);

        // FIXME: Dummy data
        Course[] courses = new Course[]{
            new Course("First Course", new Dish[]{
                new Dish("Warm Onion Tart", "Quickes Goats Cheese, Worcestershire and Shallots", 12),
                new Dish("Venison Pâté en Croûte", "Hedgerow Jelly, Mustard Fruit and Pistachio", 13),
                new Dish("Lasagne of Rabbit Shoulder", "Mushrooms, Riesling and Thyme", 12),
                new Dish("Grilled Beef Tongue", "Quince, Aged Vinegar and Beetroot", 14),
            }),
            new Course("Second Course", new Dish[]{
                new Dish("Roast Cornish Monkfish", "Cheek, Butternut Squash and Sage", 28),
                new Dish("Our Iberian Pork", "Jerusalem Artichoke and Pickled Walnuts", 32),
                new Dish("Wareham Dorset Sika Deer", "Pale Ale, Prune and Spring Onion", 35),
                new Dish("Short Rib of Red Ruby Beef", "Spinach, Chanterelles and Horseradish", 35),
            }),
            new Course("Third Course", new Dish[]{
                new Dish("Apple Parfait", "Shortbread, Hazelnuts and Sherry", 8),
                new Dish("Plum Ripple Ice Cream", "Caramelised Pastry, Almond Cream and Camomile", 7),
                new Dish("Custard Flan", "Quince and Crème Fraîche", 8),
                new Dish("Selection of Cheese", "Tunworth, Lincolnshire Poacher, Beauvale Blue Crackers and Homemade Chutney", 12),
            }),
        };

        for (Course course : courses) {
            JPanel panelCourse = new JPanel(new GridBagLayout());
            GridBagConstraints courseConstraints = new GridBagConstraints();
            panelCourse.setBackground(new Color(0x455a61));
            panelCourse.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
            courseConstraints.fill = GridBagConstraints.BOTH;
            courseConstraints.weightx = 1;
            courseConstraints.anchor = GridBagConstraints.NORTHWEST;

            CLabel labelCourseName = new CLabel(course.name, 26);
            labelCourseName.setForeground(new Color(0xcccccc));
            courseConstraints.gridy++;
            courseConstraints.insets = new Insets(16, 16, 16, 16);
            panelCourse.add(labelCourseName, courseConstraints);

            for (Dish dish : course.dishes) {
                JPanel panelDish = new JPanel(new GridBagLayout());
                GridBagConstraints dishConstraints = new GridBagConstraints();
                panelDish.setBackground(new Color(0x557b8a));
                panelDish.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
                dishConstraints.fill = GridBagConstraints.BOTH;
                dishConstraints.anchor = GridBagConstraints.NORTHWEST;

                CLabel labelDishName = new CLabel(dish.name, 22);
                labelDishName.setForeground(new Color(0xcccccc));
                dishConstraints.gridx = 1;
                dishConstraints.gridwidth = 1;
                dishConstraints.weightx = 1;
                dishConstraints.gridy = 1;
                dishConstraints.insets = new Insets(16, 16, 16, 16);
                panelDish.add(labelDishName, dishConstraints);

                CLabel labelDishPrice = new CLabel("Suggested: " + dish.price + "    Price: ", 18);
                labelDishPrice.setForeground(new Color(0xcccccc));
                dishConstraints.gridx = 2;
                dishConstraints.gridwidth = 1;
                dishConstraints.weightx = 0;
                dishConstraints.gridy = 1;
                dishConstraints.insets = new Insets(16, 16, 16, 0);
                panelDish.add(labelDishPrice, dishConstraints);

                JSpinner spinnerDishPrice = new JSpinner(new SpinnerNumberModel(dish.price, 0, 99, 1));
                dishConstraints.gridx = 3;
                dishConstraints.gridwidth = 1;
                dishConstraints.weightx = 0;
                dishConstraints.gridy = 1;
                dishConstraints.insets = new Insets(16, 0, 16, 16);
                panelDish.add(spinnerDishPrice, dishConstraints);

                // FIXME: For some reason, adding a JTextArea will scroll to the bottom of the whole window
                CTextArea areaDescription = new CTextArea(dish.description, 16);
                dishConstraints.gridx = 1;
                dishConstraints.gridwidth = 3;
                dishConstraints.weightx = 1;
                dishConstraints.gridy = 2;
                dishConstraints.insets = new Insets(0, 16, 16, 16);
                panelDish.add(areaDescription, dishConstraints);

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

        // TODO: Theming JScrollPane
        JScrollPane scrollMain = new JScrollPane(panelMain);
        scrollMain.setPreferredSize(new Dimension(0, 0));
        scrollMain.getVerticalScrollBar().setUnitIncrement(8);
        scrollMain.setBorder(null);
        constraints.gridy = 2;
        constraints.weighty = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        this.add(scrollMain, constraints);
    }
}
