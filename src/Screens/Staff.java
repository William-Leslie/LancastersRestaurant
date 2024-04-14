package Screens;

import Components.*;
import Management.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.util.*;
import java.util.List;

public class Staff extends JPanel {
    public Staff(CWindow window, LocalDate date) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(Colors.background);
        constraints.weightx = 1;
        constraints.gridx = 1;
        constraints.gridwidth = 6;

        CNavbar navbar = new CNavbar("Staff", event -> window.switchTo(new Home(window)));
        constraints.gridy = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 10, 0, 10);
        this.add(navbar, constraints);

        CDatePicker datePicker = new CDatePicker();
        if (date != null) {
            datePicker.setDate(date);
        }
        datePicker.addDateChangeListener(e -> {
            System.out.println(e.getNewDate());
            window.switchTo(new Staff(window, e.getNewDate()));
        });
        constraints.gridy++;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.insets = new Insets(10, 0, 10, 0);
        this.add(datePicker, constraints);

        // panel for employees
        JPanel panelMain = new JPanel(new GridBagLayout());
        GridBagConstraints mainConstraints = new GridBagConstraints();
        panelMain.setBackground(new Color(0x2b3336)); // slightly lighter color than primary

        List<MStaffMember> staff = MStaffMember.getStaff();
        List<MHoliday> holidays = MHoliday.getOnDate(datePicker.getDate());
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

        // FIXME: Allow adding holidays

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
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 20, 10, 20);
        this.add(scrollMain, constraints);

        // Parameters on bottom
        // FIXME: Limit parameters should be date based
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

        // TODO: Theme JSpinner
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

        JSpinner spinnerMaxDining = new JSpinner(new SpinnerNumberModel(18, 0, 99, 1));
        constraints.gridx++;
        constraints.fill = GridBagConstraints.BOTH;
        spinnerMaxDining.setPreferredSize(new Dimension(10, 40));
        constraints.insets = new Insets(10, 8, 10, 70);
        constraints.anchor = GridBagConstraints.WEST;
        this.add(spinnerMaxDining, constraints);
    }
}
