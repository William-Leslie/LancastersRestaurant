package Screens;

import Components.*;
import Management.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.util.*;
import java.util.List;

/**
 * Screen to manage staff and holidays
 */
public class Staff extends JPanel {
    CButton saveButton;

    public Staff(CWindow window, LocalDate date) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(Colors.background);
        constraints.weightx = 1;
        constraints.gridx = 1;

        CNavbar navbar = new CNavbar("Staff", e -> {
            if (this.saveButton.isEnabled()) {
                int confirm = JOptionPane.showConfirmDialog(this, "You have unsaved changes! Discard them?");
                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }
            }
            window.switchTo(new Home(window));
        });
        constraints.gridy = 1;
        constraints.weighty = 0;
        constraints.gridwidth = 7;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 10, 0, 10);
        this.add(navbar, constraints);

        JPanel panelDate = new JPanel(new GridBagLayout());
        GridBagConstraints dateConstraints = new GridBagConstraints();
        panelDate.setBackground(Colors.background);
        dateConstraints.insets = new Insets(10, 5, 10, 10);

        CLabel labelDate = new CLabel("Date:");
        dateConstraints.fill = GridBagConstraints.VERTICAL;
        dateConstraints.gridx++;
        panelDate.add(labelDate, dateConstraints);

        CDatePicker datePicker = new CDatePicker();
        if (date != null) {
            datePicker.setDate(date);
        }
        datePicker.addDateChangeListener(e -> window.switchTo(new Staff(window, e.getNewDate())));
        dateConstraints.gridx++;
        dateConstraints.fill = GridBagConstraints.VERTICAL;
        panelDate.add(datePicker, dateConstraints);

        constraints.gridx = 1;
        constraints.weightx = 1;
        constraints.gridy++;
        constraints.weighty = 0;
        constraints.gridwidth = 7;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 20, 10, 20);
        this.add(panelDate, constraints);

        List<MStaffMember> staff = MStaffMember.getStaff();
        assert staff != null;
        List<MHoliday> holidays = MHoliday.getOnDate(datePicker.getDate());
        assert holidays != null;
        List<MStaffMember> staffHoliday = new ArrayList<>();
        List<MStaffMember> staffAvailable = new ArrayList<>();
        for (MStaffMember member : staff) {
            boolean onHoliday = false;
            for (MHoliday holiday : holidays) {
                if (member.id == holiday.staffID) {
                    onHoliday = true;
                    break;
                }
            }
            if (onHoliday) {
                staffHoliday.add(member);
            } else {
                staffAvailable.add(member);
            }
        }

        // Holidays on top
        JPanel panelHoliday = new JPanel(new GridBagLayout());
        GridBagConstraints holidayConstraints = new GridBagConstraints();
        panelHoliday.setBackground(Colors.background);
        holidayConstraints.insets = new Insets(10, 5, 10, 10);

        CLabel labelAddHoliday = new CLabel("Add new staff holiday:");
        holidayConstraints.fill = GridBagConstraints.VERTICAL;
        holidayConstraints.gridx++;
        panelHoliday.add(labelAddHoliday, holidayConstraints);

        CDatePicker holidayFrom = new CDatePicker();
        holidayConstraints.fill = GridBagConstraints.VERTICAL;
        holidayConstraints.gridx++;
        panelHoliday.add(holidayFrom, holidayConstraints);

        CDatePicker holidayTo = new CDatePicker();
        holidayConstraints.fill = GridBagConstraints.VERTICAL;
        holidayConstraints.gridx++;
        panelHoliday.add(holidayTo, holidayConstraints);

        JComboBox<MStaffMember> comboStaff = new JComboBox<>(staff.toArray(new MStaffMember[0]));
        holidayConstraints.fill = GridBagConstraints.VERTICAL;
        holidayConstraints.gridx++;
        panelHoliday.add(comboStaff, holidayConstraints);

        CButton addHoliday = new CButton("Add Holiday", event -> {
            if (holidayFrom.getDate().isAfter(holidayTo.getDate())) {
                JOptionPane.showMessageDialog(this, "Start date must be before end date!");
                return;
            }
            MStaffMember member = (MStaffMember) comboStaff.getSelectedItem();
            if (member == null) {
                JOptionPane.showMessageDialog(this, "Please select a member first!");
                return;
            }

            MHoliday holiday = new MHoliday();
            holiday.staffID = member.id;
            holiday.start = holidayFrom.getDate();
            holiday.end = holidayTo.getDate();
            holiday.addToDB();
            window.switchTo(new Staff(window, datePicker.getDate()));
        });
        addHoliday.setPreferredSize(new Dimension(140, 0));
        holidayConstraints.fill = GridBagConstraints.VERTICAL;
        holidayConstraints.gridx++;
        panelHoliday.add(addHoliday, holidayConstraints);

        constraints.gridx = 1;
        constraints.weightx = 1;
        constraints.gridy++;
        constraints.weighty = 0;
        constraints.gridwidth = 7;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 20, 10, 20);
        this.add(panelHoliday, constraints);

        // panel for employees
        JPanel panelMain = new JPanel(new GridBagLayout());
        GridBagConstraints mainConstraints = new GridBagConstraints();
        panelMain.setBackground(Colors.background);

        // ON HOLIDAY
        mainConstraints.gridx = 1;
        mainConstraints.gridy = 0;
        mainConstraints.anchor = GridBagConstraints.WEST;
        mainConstraints.insets = new Insets(8, 16, 8, 0);
        CLabel labelHoliday = new CLabel("ON HOLIDAY", 24);
        labelHoliday.setForeground(Colors.red);
        panelMain.add(labelHoliday, mainConstraints);

        for (MStaffMember member : staffHoliday) {
            mainConstraints.gridx = 0;
            mainConstraints.gridy++;

            CLabel labelName = new CLabel(member.name);
            mainConstraints.gridx++;
            mainConstraints.weightx = 1.5;
            mainConstraints.anchor = GridBagConstraints.WEST;
            mainConstraints.insets = new Insets(8, 80, 8, 40);
            panelMain.add(labelName, mainConstraints);

            CLabel labelRole = new CLabel(member.role);
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.CENTER;
            mainConstraints.insets = new Insets(8, 40, 8, 40);
            panelMain.add(labelRole, mainConstraints);

            CLabel labelDob = new CLabel(CDate.of(member.dateOfBirth));
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.CENTER;
            mainConstraints.insets = new Insets(8, 40, 8, 40);
            panelMain.add(labelDob, mainConstraints);

            CLabel labelAddress = new CLabel(member.address);
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.EAST;
            mainConstraints.insets = new Insets(8, 40, 8, 80);
            panelMain.add(labelAddress, mainConstraints);
        }

        // NOT ON HOLIDAY
        mainConstraints.gridx = 1;
        mainConstraints.gridy++;
        mainConstraints.anchor = GridBagConstraints.WEST;
        mainConstraints.insets = new Insets(8, 16, 8, 0);
        CLabel labelNotHoliday = new CLabel("WORKING", 24);
        labelNotHoliday.setForeground(Colors.blue);
        panelMain.add(labelNotHoliday, mainConstraints);

        for (MStaffMember member : staffAvailable) {
            mainConstraints.gridx = 0;
            mainConstraints.gridy++;

            CLabel labelName = new CLabel(member.name);
            mainConstraints.gridx++;
            mainConstraints.weightx = 1.5;
            mainConstraints.anchor = GridBagConstraints.WEST;
            mainConstraints.insets = new Insets(8, 80, 8, 40);
            panelMain.add(labelName, mainConstraints);

            CLabel labelRole = new CLabel(member.role);
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.CENTER;
            mainConstraints.insets = new Insets(8, 40, 8, 40);
            panelMain.add(labelRole, mainConstraints);

            CLabel labelDob = new CLabel(CDate.of(member.dateOfBirth));
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.CENTER;
            mainConstraints.insets = new Insets(8, 40, 8, 40);
            panelMain.add(labelDob, mainConstraints);

            CLabel labelAddress = new CLabel(member.address);
            mainConstraints.gridx++;
            mainConstraints.anchor = GridBagConstraints.EAST;
            mainConstraints.insets = new Insets(8, 40, 8, 80);
            panelMain.add(labelAddress, mainConstraints);
        }

        mainConstraints.gridy++;
        mainConstraints.weighty = 1;
        panelMain.add(Box.createVerticalGlue(), mainConstraints);

        CScroll scrollMain = new CScroll(panelMain);
        constraints.gridx = 1;
        constraints.weightx = 1;
        constraints.gridy++;
        constraints.weighty = 1;
        constraints.gridwidth = 7;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 20, 10, 20);
        this.add(scrollMain, constraints);

        // Parameters on bottom
        constraints.weighty = 0;
        constraints.gridy++;
        constraints.gridx = 0;
        constraints.gridwidth = 1;

        MBookingCapacity capacity = MBookingCapacity.getOnDate(datePicker.getDate());

        CLabel labelHalfHour = new CLabel("Half Hour Limit");
        constraints.gridx++;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.insets = new Insets(10, 0, 10, 8);
        constraints.anchor = GridBagConstraints.EAST;
        this.add(labelHalfHour, constraints);

        // TODO: Theme JSpinner
        JSpinner spinnerHalfHour = new JSpinner(new SpinnerNumberModel(capacity.halfHourLimit, 0, 99, 1));
        spinnerHalfHour.addChangeListener(e -> {
            capacity.halfHourLimit = (int) spinnerHalfHour.getValue();
            saveButton.setEnabled(true);
        });
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

        JSpinner spinnerPreBook = new JSpinner(new SpinnerNumberModel(capacity.preBookLimit, 0, 99, 1));
        spinnerPreBook.addChangeListener(e -> {
            capacity.preBookLimit = (int) spinnerPreBook.getValue();
            saveButton.setEnabled(true);
        });
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

        JSpinner spinnerMaxDining = new JSpinner(new SpinnerNumberModel(capacity.maxDiningLimit, 0, 99, 1));
        spinnerMaxDining.addChangeListener(e -> {
            capacity.maxDiningLimit = (int) spinnerMaxDining.getValue();
            saveButton.setEnabled(true);
        });
        constraints.gridx++;
        constraints.fill = GridBagConstraints.BOTH;
        spinnerMaxDining.setPreferredSize(new Dimension(10, 40));
        constraints.insets = new Insets(10, 8, 10, 70);
        constraints.anchor = GridBagConstraints.WEST;
        this.add(spinnerMaxDining, constraints);

        this.saveButton = new CButton("Save changes", event -> {
            capacity.saveChanges();
            this.saveButton.setEnabled(false);
        });
        this.saveButton.setEnabled(false);
        constraints.gridx++;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(saveButton, constraints);
    }
}
