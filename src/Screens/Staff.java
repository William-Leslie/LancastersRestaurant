package Screens;

import Components.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;

public class Staff extends JPanel {
    // FIXME: Dummy data
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

    public Staff(JPanel screens) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.gridx = 1;
        constraints.gridwidth = 6;

        CNavbar navbar = new CNavbar("Staff", event -> {
            CardLayout cl = (CardLayout) screens.getLayout();
            cl.show(screens, Screen.Home.name());
        });
        constraints.gridy = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(10, 10, 0, 10);
        this.add(navbar, constraints);

        JPanel panelMain = new JPanel(new GridBagLayout());
        GridBagConstraints mainConstraints = new GridBagConstraints();
        panelMain.setBackground(new Color(0x2b3336));
        mainConstraints.insets = new Insets(8, 16, 8, 16);

        // TODO: Add date selector
        // TODO: Rework holiday handling

        // FIXME: Dummy data
        Employee[] employees = new Employee[]{
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
        for (Employee employee : employees) {
            mainConstraints.gridy++;
            mainConstraints.gridx = 0;

            CLabel labelName = new CLabel(employee.name);
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.WEST;
            panelMain.add(labelName, mainConstraints);

            CLabel labelRole = new CLabel(employee.role);
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.CENTER;
            panelMain.add(labelRole, mainConstraints);

            // FIXME: Theme JCheckBox
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

        CScroll scrollMain = new CScroll(panelMain);
        constraints.gridy = 2;
        constraints.weighty = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        this.add(scrollMain, constraints);

        // Parameters on bottom
        // TODO: Limit parameters should be date based
        constraints.weighty = 0;
        constraints.gridy = 3;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.EAST;

        CLabel labelHalfHour = new CLabel("Half Hour Limit");
        constraints.gridx++;
        constraints.fill = GridBagConstraints.VERTICAL;
        this.add(labelHalfHour, constraints);

        // FIXME: Theme JSpinner
        JSpinner spinnerHalfHour = new JSpinner(new SpinnerNumberModel(6, 0, 99, 1));
        constraints.gridx++;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(spinnerHalfHour, constraints);

        CLabel labelPreBook = new CLabel("Pre Book Limit");
        constraints.gridx++;
        constraints.fill = GridBagConstraints.VERTICAL;
        this.add(labelPreBook, constraints);

        // FIXME: Theme JSpinner
        JSpinner spinnerPreBook = new JSpinner(new SpinnerNumberModel(10, 0, 99, 1));
        constraints.gridx++;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(spinnerPreBook, constraints);

        CLabel labelMaxDining = new CLabel("Max Dining Limit");
        constraints.gridx++;
        constraints.fill = GridBagConstraints.VERTICAL;
        this.add(labelMaxDining, constraints);

        // FIXME: Theme JSpinner
        JSpinner spinnerMaxDining = new JSpinner(new SpinnerNumberModel(18, 0, 99, 1));
        constraints.gridx++;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(spinnerMaxDining, constraints);
    }
}
