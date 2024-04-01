package Screens;

import Resources.Resources;

import javax.swing.*;
import java.awt.*;

public class Staff extends JPanel {
    private static class Employee {
        public String name;
        public String role;
        public boolean onHoliday;
        private Employee(String name, String role, boolean onHoliday) {
            this.name = name;
            this.role = role;
            this.onHoliday = onHoliday;
        }
    }
    private Employee[] employees = new Employee[] {
        new Employee("Luis J. Burrus", "FOH", false),
        new Employee("Richard K. Moreno", "FOH", true),
        new Employee("Edward J. Villacorta", "FOH", false),
        new Employee("Cecelia D. Nolasco", "Kitchen", false),
        new Employee("John V. Roe", "Kitchen", false),
        new Employee("Bessie D. Fisk", "Kitchen", true),
        new Employee("Jolene K. Lang", "Management", false),
        new Employee("Gregg T. Edwards", "Management", true),
        new Employee("Luis J. Burrus", "FOH", false),
        new Employee("Richard K. Moreno", "FOH", true),
        new Employee("Edward J. Villacorta", "FOH", false),
        new Employee("Cecelia D. Nolasco", "Kitchen", false),
        new Employee("John V. Roe", "Kitchen", false),
        new Employee("Bessie D. Fisk", "Kitchen", true),
        new Employee("Jolene K. Lang", "Management", false),
        new Employee("Gregg T. Edwards", "Management", true),
        new Employee("Luis J. Burrus", "FOH", false),
        new Employee("Richard K. Moreno", "FOH", true),
        new Employee("Edward J. Villacorta", "FOH", false),
        new Employee("Cecelia D. Nolasco", "Kitchen", false),
        new Employee("John V. Roe", "Kitchen", false),
        new Employee("Bessie D. Fisk", "Kitchen", true),
        new Employee("Jolene K. Lang", "Management", false),
        new Employee("Gregg T. Edwards", "Management", true),
        new Employee("Luis J. Burrus", "FOH", false),
        new Employee("Richard K. Moreno", "FOH", true),
        new Employee("Edward J. Villacorta", "FOH", false),
        new Employee("Cecelia D. Nolasco", "Kitchen", false),
        new Employee("John V. Roe", "Kitchen", false),
        new Employee("Bessie D. Fisk", "Kitchen", true),
        new Employee("Jolene K. Lang", "Management", false),
        new Employee("Gregg T. Edwards", "Management", true),
        new Employee("Luis J. Burrus", "FOH", false),
        new Employee("Richard K. Moreno", "FOH", true),
        new Employee("Edward J. Villacorta", "FOH", false),
        new Employee("Cecelia D. Nolasco", "Kitchen", false),
        new Employee("John V. Roe", "Kitchen", false),
        new Employee("Bessie D. Fisk", "Kitchen", true),
        new Employee("Jolene K. Lang", "Management", false),
        new Employee("Gregg T. Edwards", "Management", true),
        new Employee("Luis J. Burrus", "FOH", false),
        new Employee("Richard K. Moreno", "FOH", true),
        new Employee("Edward J. Villacorta", "FOH", false),
        new Employee("Cecelia D. Nolasco", "Kitchen", false),
        new Employee("John V. Roe", "Kitchen", false),
        new Employee("Bessie D. Fisk", "Kitchen", true),
        new Employee("Jolene K. Lang", "Management", false),
        new Employee("Gregg T. Edwards", "Management", true),
    };

    public Staff(JPanel screens) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.gridx = 1;
        constraints.gridwidth = 6;

        JPanel panelNavbar = Resources.getNavbar("Staff", event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Home.name());
        });
        constraints.gridy = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(10, 10, 0, 10);
        this.add(panelNavbar, constraints);

        JPanel panelMain = new JPanel(new GridBagLayout());
        GridBagConstraints mainConstraints = new GridBagConstraints();
        panelMain.setBackground(new Color(0x2b3336));
        mainConstraints.insets = new Insets(8, 16, 8, 16);

        for(Employee employee : this.employees) {
            mainConstraints.gridy++;
            mainConstraints.gridx = 0;

            JLabel labelName = new JLabel(employee.name);
            labelName.setForeground(new Color(0xaaaaaa));
            labelName.setFont(Resources.getFont(20));
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.WEST;
            panelMain.add(labelName, mainConstraints);

            JLabel labelRole = new JLabel(employee.role);
            labelRole.setForeground(new Color(0xaaaaaa));
            labelRole.setFont(Resources.getFont(20));
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.CENTER;
            panelMain.add(labelRole, mainConstraints);

            // TODO: Theming JCheckBox
            JCheckBox checkboxHoliday = new JCheckBox("On Holiday", employee.onHoliday);
            checkboxHoliday.setForeground(new Color(0xaaaaaa));
            checkboxHoliday.setBackground(new Color(0x2b3336));
            checkboxHoliday.setFont(Resources.getFont(20));
            checkboxHoliday.setFocusPainted(false);
            checkboxHoliday.addActionListener(event -> employee.onHoliday = checkboxHoliday.isSelected());
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.EAST;
            panelMain.add(checkboxHoliday, mainConstraints);
        }

        // TODO: Theming JScrollPane
        JScrollPane scrollMain = new JScrollPane(panelMain);
        scrollMain.setPreferredSize(new Dimension(0, 0));
        scrollMain.getVerticalScrollBar().setUnitIncrement(8);
        scrollMain.setBorder(null);
        constraints.gridy = 2;
        constraints.weighty = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        this.add(scrollMain, constraints);

        // Parameters on bottom
        constraints.weighty = 0;
        constraints.gridy = 3;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.EAST;

        JLabel labelHalfHour = new JLabel("Half Hour Limit");
        labelHalfHour.setForeground(new Color(0xaaaaaa));
        labelHalfHour.setFont(Resources.getFont(20));
        constraints.gridx++;
        constraints.fill = GridBagConstraints.VERTICAL;
        this.add(labelHalfHour, constraints);

        // TODO: Theming JSpinners
        JSpinner spinnerHalfHour = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        constraints.gridx++;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(spinnerHalfHour, constraints);

        JLabel labelPreBook = new JLabel("Pre Book Limit");
        labelPreBook.setForeground(new Color(0xaaaaaa));
        labelPreBook.setFont(Resources.getFont(20));
        constraints.gridx++;
        constraints.fill = GridBagConstraints.VERTICAL;
        this.add(labelPreBook, constraints);

        JSpinner spinnerPreBook = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        constraints.gridx++;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(spinnerPreBook, constraints);

        JLabel labelMaxDining = new JLabel("Max Dining Limit");
        labelMaxDining.setForeground(new Color(0xaaaaaa));
        labelMaxDining.setFont(Resources.getFont(20));
        constraints.gridx++;
        constraints.fill = GridBagConstraints.VERTICAL;
        this.add(labelMaxDining, constraints);

        JSpinner spinnerMaxDining = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        constraints.gridx++;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(spinnerMaxDining, constraints);
    }
}
