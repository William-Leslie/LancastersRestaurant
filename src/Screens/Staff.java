package Screens;

import Components.*;
import Resources.*;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.geometry.HPos;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class Staff extends JPanel {
    // FIXME: Dummy data
    private static class Employee {
        public String name;
        public int employeeID;
        public String role;
        public boolean onHoliday;

        private Employee(String name, int employeeID, String role, boolean onHoliday) {
            this.name = name;
            this.employeeID = employeeID;
            this.role = role;
            this.onHoliday = onHoliday;
        }
    }

    private Scene createScene() {
        // create pane for scene
        GridPane gridpane = new GridPane();

        // set column sizing for gridPane
        ColumnConstraints column0 = new ColumnConstraints();
        column0.setPercentWidth(45);
        gridpane.getColumnConstraints().add(column0); // second column gets 55% of width

        // create date picker
        DatePicker datePicker = new DatePicker();
        datePicker.setOnAction(e -> {
            LocalDate date = datePicker.getValue();
            System.out.println("Selected date: " + date); // return selected date
        });

        // set placeholder/default value to today's date
        LocalDate today = LocalDate.now();
        datePicker.setValue(today);

        // misc.
        datePicker.setPrefWidth(200);
        datePicker.setPrefHeight(40);
        datePicker.setShowWeekNumbers(false);

        // unsure what this does, but seems to be necessary
        LocalDate localDate = datePicker.getValue();
        ChronoLocalDate chronoDate =
                ((localDate != null) ? datePicker.getChronology().date(localDate) : null);
        System.out.println("Selected date: " + chronoDate); // return selected date

        // equivalent to JavaSwing label
        Text text = new Text();
        text.setText("Select date:");

        // add nodes (text, datepicker) to gridPane
        gridpane.add(text, 0, 0); // first column
        gridpane.add(datePicker, 1, 0); // second column

        // positioning of nodes within gridPane
        GridPane.setHalignment(text, HPos.RIGHT);
        GridPane.setHalignment(datePicker, HPos.LEFT);
        javafx.geometry.Insets gridInsets = new javafx.geometry.Insets(0, 10, 0, 10);
        GridPane.setMargin(text, gridInsets);
        GridPane.setMargin(datePicker, gridInsets);

        // create scene with the completed gridPane
        Scene sc = new Scene(gridpane, 100, 40);
        sc.getStylesheets().add("CSS/staff.css"); // add CSS styling
        return sc;
    }

    public Staff(CWindow window) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.gridx = 1;
        constraints.gridwidth = 6;

        CNavbar navbar = new CNavbar("Staff", event -> {
            window.switchTo(new Home(window));
        });
        constraints.gridy = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(10, 10, 0, 10);
        this.add(navbar, constraints);

        // create a datePicker panel, then run the datePicker scene in a new thread
        // FIXME: what?????
        JFXPanel panelDate = new JFXPanel();
        new Thread(() -> {
            Scene scene = createScene();
            panelDate.setScene(scene);
        }).start();

        constraints.gridy++;
        constraints.insets = new Insets(10, 0, 10, 0);
        this.add(panelDate, constraints);

        // panel for employees
        JPanel panelMain = new JPanel(new GridBagLayout());
        GridBagConstraints mainConstraints = new GridBagConstraints();
        panelMain.setBackground(new Color(0x2b3336)); // slightly lighter color than primary

        // TODO: Rework holiday handling
        // FIXME: Dummy data
        Employee[] employees = new Employee[]{
                new Employee("Luis J. Burrus", 32487, "FOH", false),
                new Employee("Richard K. Moreno", 35396, "FOH", true),
                new Employee("Edward J. Villacorta", 21487, "FOH", false),
                new Employee("Cecelia D. Nolasco", 79521, "Kitchen", false),
                new Employee("John V. Roe", 52437, "Kitchen", false),
                new Employee("Bessie D. Fisk", 32187, "Kitchen", true),
                new Employee("Jolene K. Lang", 67687, "Management", false),
                new Employee("Gregg T. Edwards", 32454, "Management", true),
                new Employee("Luis J. Burrus", 32484, "FOH", false),
                new Employee("Richard K. Moreno", 46287, "FOH", true),
                new Employee("Edward J. Villacorta", 55587, "FOH", false),
                new Employee("Cecelia D. Nolasco", 33287, "Kitchen", false),
                new Employee("John V. Roe", 21481, "Kitchen", false),
                new Employee("Bessie D. Fisk", 23483, "Kitchen", true),
                new Employee("Jolene K. Lang", 65486, "Management", false),
                new Employee("Gregg T. Edwards", 35485, "Management", true),
                new Employee("Luis J. Burrus", 32547, "FOH", false),
                new Employee("Richard K. Moreno", 12487, "FOH", true),
                new Employee("Edward J. Villacorta", 21485, "FOH", false),
                new Employee("Cecelia D. Nolasco", 32406, "Kitchen", false),
                new Employee("John V. Roe", 12451, "Kitchen", false),
                new Employee("Bessie D. Fisk", 34876, "Kitchen", true),
                new Employee("Jolene K. Lang", 55487, "Management", false),
                new Employee("Gregg T. Edwards", 31287, "Management", true),
                new Employee("Luis J. Burrus", 12453, "FOH", false),
                new Employee("Richard K. Moreno", 12437, "FOH", true),
                new Employee("Edward J. Villacorta", 24227, "FOH", false),
                new Employee("Cecelia D. Nolasco", 31498, "Kitchen", false),
                new Employee("John V. Roe", 32657, "Kitchen", false),
                new Employee("Bessie D. Fisk", 82287, "Kitchen", true),
                new Employee("Jolene K. Lang", 90537, "Management", false),
                new Employee("Gregg T. Edwards", 30437, "Management", true),
                new Employee("Luis J. Burrus", 25486, "FOH", false),
                new Employee("Richard K. Moreno", 38484, "FOH", true),
                new Employee("Edward J. Villacorta", 37487, "FOH", false),
                new Employee("Cecelia D. Nolasco", 32248, "Kitchen", false),
                new Employee("John V. Roe", 50687, "Kitchen", false),
                new Employee("Bessie D. Fisk", 32047, "Kitchen", true),
                new Employee("Jolene K. Lang", 10487, "Management", false),
                new Employee("Gregg T. Edwards", 21247, "Management", true),
                new Employee("Luis J. Burrus", 66485, "FOH", false),
                new Employee("Richard K. Moreno", 32406, "FOH", true),
                new Employee("Edward J. Villacorta", 44667, "FOH", false),
                new Employee("Cecelia D. Nolasco", 32466, "Kitchen", false),
                new Employee("John V. Roe", 88548, "Kitchen", false),
                new Employee("Bessie D. Fisk", 66489, "Kitchen", true),
                new Employee("Jolene K. Lang", 32997, "Management", false),
                new Employee("Gregg T. Edwards", 20386, "Management", true),
        };

        // ON HOLIDAY
        mainConstraints.gridx = 0;
        mainConstraints.gridy = 0;
        mainConstraints.weighty = 4;
        mainConstraints.anchor = GridBagConstraints.WEST;
        mainConstraints.insets = new Insets(8, 16, 8, 0);
        CLabel labelHoliday = new CLabel("ON HOLIDAY", 24);
        labelHoliday.setForeground(Colors.red);
        panelMain.add(labelHoliday, mainConstraints);

        for (Employee employee : employees) {
            if (employee.onHoliday) {
                mainConstraints.gridx = 0;
                mainConstraints.gridy++;
                mainConstraints.weighty = 1;

                CLabel labelName = new CLabel(employee.name);
                mainConstraints.gridx++;
                mainConstraints.weightx = 1.5;
                mainConstraints.anchor = GridBagConstraints.WEST;
                mainConstraints.insets = new Insets(8, 0, 8, 80);
                panelMain.add(labelName, mainConstraints);

                CLabel labelID = new CLabel(Integer.toString(employee.employeeID));
                mainConstraints.gridx++;
                mainConstraints.anchor = GridBagConstraints.CENTER;
                mainConstraints.insets = new Insets(8, 40, 8, 80);
                panelMain.add(labelID, mainConstraints);

                CLabel labelRole = new CLabel(employee.role);
                mainConstraints.gridx++;
                mainConstraints.anchor = GridBagConstraints.EAST;
                mainConstraints.insets = new Insets(8, 40, 8, 120);
                panelMain.add(labelRole, mainConstraints);
            }
        }

        // NOT ON HOLIDAY
        mainConstraints.gridx = 0;
        mainConstraints.gridy++;
        mainConstraints.weighty = 16;
        mainConstraints.anchor = GridBagConstraints.WEST;
        mainConstraints.insets = new Insets(8, 16, 8, 0);
        CLabel labelNotHoliday = new CLabel("WORKING", 24);
        labelNotHoliday.setForeground(Colors.blue);
        panelMain.add(labelNotHoliday, mainConstraints);

        for (Employee employee2 : employees) {
            if (!employee2.onHoliday) {
                mainConstraints.gridx = 0;
                mainConstraints.gridy++;
                mainConstraints.weighty = 1;

                CLabel labelName = new CLabel(employee2.name);
                mainConstraints.gridx++;
                mainConstraints.weightx = 1.5;
                mainConstraints.anchor = GridBagConstraints.WEST;
                mainConstraints.insets = new Insets(8, 0, 8, 80);
                panelMain.add(labelName, mainConstraints);

                CLabel labelID = new CLabel(Integer.toString(employee2.employeeID));
                mainConstraints.gridx++;
                mainConstraints.anchor = GridBagConstraints.CENTER;
                mainConstraints.insets = new Insets(8, 40, 8, 80);
                panelMain.add(labelID, mainConstraints);

                CLabel labelRole = new CLabel(employee2.role);
                mainConstraints.gridx++;
                mainConstraints.anchor = GridBagConstraints.EAST;
                mainConstraints.insets = new Insets(8, 40, 8, 120);
                panelMain.add(labelRole, mainConstraints);
            }
        }

        // I left the code for the checkbox as comments, just in case
        /*
        JCheckBox checkboxHoliday = new JCheckBox("On Holiday", employee.onHoliday);
        checkboxHoliday.setForeground(new Color(0xaaaaaa));
        checkboxHoliday.setBackground(new Color(0x2b3336));
        checkboxHoliday.setFont(Resources.getFont(20));
        checkboxHoliday.setFocusPainted(false);
        checkboxHoliday.addActionListener(event -> employee.onHoliday = checkboxHoliday.isSelected());
        mainConstraints.gridx++;
        mainConstraints.anchor = GridBagConstraints.EAST;
        panelMain.add(checkboxHoliday, mainConstraints);
        */

        CScroll scrollMain = new CScroll(panelMain);
        constraints.gridx = 1;
        constraints.weightx = 1;
        constraints.gridy++;
        constraints.weighty = 1;
        constraints.insets = new Insets(10, 20, 10, 20);
        this.add(scrollMain, constraints);

        // Parameters on bottom
        // TODO: Limit parameters should be date based
        constraints.weighty = 0;
        constraints.gridy++;
        constraints.gridx = 0;
        constraints.gridwidth = 1;

        CLabel labelHalfHour = new CLabel("Half Hour Limit");
        constraints.gridx++;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.insets = new Insets(10, 0, 10, 8);
        constraints.anchor = GridBagConstraints.EAST;
        this.add(labelHalfHour, constraints);

        // FIXME: Theme JSpinner
        JSpinner spinnerHalfHour = new JSpinner(new SpinnerNumberModel(6, 0, 99, 1));
        constraints.gridx++;
        constraints.fill = GridBagConstraints.BOTH;
        spinnerHalfHour.setPreferredSize(new Dimension(10, 40));
        constraints.anchor = GridBagConstraints.WEST;
        this.add(spinnerHalfHour, constraints);

        CLabel labelPreBook = new CLabel("Pre Book Limit");
        constraints.gridx++;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.anchor = GridBagConstraints.EAST;
        this.add(labelPreBook, constraints);

        // FIXME: Theme JSpinner
        JSpinner spinnerPreBook = new JSpinner(new SpinnerNumberModel(10, 0, 99, 1));
        constraints.gridx++;
        constraints.fill = GridBagConstraints.BOTH;
        spinnerPreBook.setPreferredSize(new Dimension(10, 40));
        constraints.anchor = GridBagConstraints.WEST;
        this.add(spinnerPreBook, constraints);

        CLabel labelMaxDining = new CLabel("Max Dining Limit");
        constraints.gridx++;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.anchor = GridBagConstraints.EAST;
        this.add(labelMaxDining, constraints);

        // FIXME: Theme JSpinner
        JSpinner spinnerMaxDining = new JSpinner(new SpinnerNumberModel(18, 0, 99, 1));
        constraints.gridx++;
        constraints.fill = GridBagConstraints.BOTH;
        spinnerMaxDining.setPreferredSize(new Dimension(10, 40));
        constraints.insets = new Insets(10, 8, 10, 70);
        constraints.anchor = GridBagConstraints.WEST;
        this.add(spinnerMaxDining, constraints);
    }
}
