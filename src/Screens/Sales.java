package Screens;

import Components.*;
import FOHtoManagement.*;
import Management.*;
import Resources.*;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.util.*;

/**
 * Screen to view sales and bookings from front of house
 */
public class Sales extends JPanel {
    private final DefaultCategoryDataset dishData;
    private final DefaultCategoryDataset takingsData;
    private final DefaultCategoryDataset bookingDataCombined;

    public Sales(CWindow window) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(Colors.background);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;

        CNavbar navbar = new CNavbar("Sales", event -> window.switchTo(new Home(window)));
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

        dishData = new DefaultCategoryDataset();
        takingsData = new DefaultCategoryDataset();
        bookingDataCombined = new DefaultCategoryDataset();

        // Date Set Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.setBackground(Colors.background);

        CButton day = new CButton("Day", e -> updateData("day"));
        buttonPanel.add(day);

        CButton week = new CButton("Week", e -> updateData("week"));
        buttonPanel.add(week);

        CButton month = new CButton("Month", e -> updateData("month"));
        buttonPanel.add(month);

        // Add the buttonPanel to the main panel
        mainConstraints.gridy = 0;
        mainConstraints.gridx = 0;
        panelMain.add(buttonPanel, mainConstraints);

        //Set Default Data Day
        updateData("day");

        // Create charts
        JFreeChart chart1 = ChartFactory.createBarChart(
                "Most Popular Dishes",
                "Amount",
                "Dish",
                dishData,
                PlotOrientation.VERTICAL,
                true, true, false);

        JFreeChart chart2 = ChartFactory.createBarChart(
                "Takings",
                "Date",
                "Amount",
                takingsData,
                PlotOrientation.VERTICAL,
                true, true, false);

        JFreeChart chart3 = ChartFactory.createBarChart(
                "Booking Combined",
                "Date",
                "Amount",
                bookingDataCombined,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Create ChartPanel for first chart
        ChartPanel chartPanel1 = new ChartPanel(chart1);
        chartPanel1.setPreferredSize(new java.awt.Dimension(560, 367));
        mainConstraints.gridy = 1;
        panelMain.add(chartPanel1, mainConstraints);

        // Create ChartPanel for second chart
        ChartPanel chartPanel2 = new ChartPanel(chart2);
        chartPanel2.setPreferredSize(new java.awt.Dimension(560, 367));
        mainConstraints.gridy = 2;
        panelMain.add(chartPanel2, mainConstraints);

        // Create ChartPanel for second chart
        ChartPanel chartPanel3 = new ChartPanel(chart3);
        chartPanel3.setPreferredSize(new java.awt.Dimension(560, 367));
        mainConstraints.gridy = 3;
        panelMain.add(chartPanel3, mainConstraints);

        mainConstraints.gridy++;
        mainConstraints.weighty = 1;
        panelMain.add(Box.createVerticalGlue(), mainConstraints);

        CScroll scrollMain = new CScroll(panelMain);
        constraints.gridy = 2;
        constraints.weighty = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        this.add(scrollMain, constraints);
    }

    public void updateData(String date) {
        dishData.clear();
        takingsData.clear();
        bookingDataCombined.clear();

        try {

            FOHtoManagement foh = new FOHtoManagementImpl();
            Map<Integer, String> dishNames = MDish.getDishNames();

            switch (date) {
                case "day": { //Today's Values
                    LocalDate day = LocalDate.now();

                    double takings = 0;
                    HashMap<Integer, Integer> dishPurchases = new HashMap<>();
                    HashSet<SalesToManagement> sales = foh.getSales(day);
                    for (SalesToManagement sale : sales) {
                        takings += sale.getTotal();
                        for (int dishID : sale.getDishList()) {
                            if (dishPurchases.containsKey(dishID)) {
                                dishPurchases.put(dishID, dishPurchases.get(dishID) + 1);
                            } else {
                                dishPurchases.put(dishID, 1);
                            }
                        }
                    }
                    HashMap<String, Integer> bookingAmounts = new HashMap<>();
                    HashSet<BookingsToManagement> bookings = foh.getBookings(day);
                    for (BookingsToManagement booking : bookings) {
                        String type = booking.getType();
                        if (bookingAmounts.containsKey(type)) {
                            bookingAmounts.put(type, bookingAmounts.get(type) + 1);
                        } else {
                            bookingAmounts.put(type, 1);
                        }
                    }

                    for (HashMap.Entry<Integer, Integer> entry : dishPurchases.entrySet()) {
                        String name = dishNames.get(entry.getKey());
                        dishData.addValue(entry.getValue(), name, name);
                    }

                    takingsData.addValue(takings, "Takings", "Today");

                    for (HashMap.Entry<String, Integer> entry : bookingAmounts.entrySet()) {
                        bookingDataCombined.addValue(entry.getValue(), entry.getKey(), "Today");
                    }
                    break;
                }

                case "week": {
                    HashMap<Integer, Integer> dishPurchases = new HashMap<>();
                    LocalDate today = LocalDate.now();
                    // Calculate the date of the Monday of the previous week
                    LocalDate mondayOfCurrentWeek = today.minusDays(today.getDayOfWeek().getValue() - 1);
                    for (int iDay = 0; iDay < 7; iDay++) {
                        LocalDate day = mondayOfCurrentWeek.plusDays(iDay);

                        double takings = 0;
                        HashSet<SalesToManagement> sales = foh.getSales(day);
                        for (SalesToManagement sale : sales) {
                            takings += sale.getTotal();
                            for (int dishID : sale.getDishList()) {
                                if (dishPurchases.containsKey(dishID)) {
                                    dishPurchases.put(dishID, dishPurchases.get(dishID) + 1);
                                } else {
                                    dishPurchases.put(dishID, 1);
                                }
                            }
                        }
                        HashMap<String, Integer> bookingAmounts = new HashMap<>();
                        HashSet<BookingsToManagement> bookings = foh.getBookings(day);
                        for (BookingsToManagement booking : bookings) {
                            String type = booking.getType();
                            if (bookingAmounts.containsKey(type)) {
                                bookingAmounts.put(type, bookingAmounts.get(type) + 1);
                            } else {
                                bookingAmounts.put(type, 1);
                            }
                        }

                        takingsData.addValue(takings, "Takings", day.getDayOfWeek().toString());

                        for (HashMap.Entry<String, Integer> entry : bookingAmounts.entrySet()) {
                            bookingDataCombined.addValue(entry.getValue(), entry.getKey(), day.getDayOfWeek().toString());
                        }
                    }

                    for (HashMap.Entry<Integer, Integer> entry : dishPurchases.entrySet()) {
                        String name = dishNames.get(entry.getKey());
                        dishData.addValue(entry.getValue(), name, name);
                    }

                    break;
                }

                case "month": { //Instead of doing Week 1 etc. could do starting day of week e.g. 08/04/2024 - 14/04/2024
                    HashMap<Integer, Integer> dishPurchases = new HashMap<>();
                    for (int iWeek = 0; iWeek < 4; iWeek++) {
                        double takings = 0;
                        HashMap<String, Integer> bookingAmounts = new HashMap<>();
                        for (int iDay = 0; iDay < 7; iDay++) {
                            LocalDate day = LocalDate.now().minusDays(iWeek * 7 + iDay);

                            HashSet<SalesToManagement> sales = foh.getSales(day);
                            for (SalesToManagement sale : sales) {
                                takings += sale.getTotal();
                                for (int dishID : sale.getDishList()) {
                                    if (dishPurchases.containsKey(dishID)) {
                                        dishPurchases.put(dishID, dishPurchases.get(dishID) + 1);
                                    } else {
                                        dishPurchases.put(dishID, 1);
                                    }
                                }
                            }
                            HashSet<BookingsToManagement> bookings = foh.getBookings(day);
                            for (BookingsToManagement booking : bookings) {
                                String type = booking.getType();
                                if (bookingAmounts.containsKey(type)) {
                                    bookingAmounts.put(type, bookingAmounts.get(type) + 1);
                                } else {
                                    bookingAmounts.put(type, 1);
                                }
                            }
                        }

                        takingsData.addValue(takings, "Takings", "Week " + (iWeek + 1));

                        for (HashMap.Entry<String, Integer> entry : bookingAmounts.entrySet()) {
                            bookingDataCombined.addValue(entry.getValue(), entry.getKey(), "Week " + (iWeek + 1));
                        }
                    }

                    for (HashMap.Entry<Integer, Integer> entry : dishPurchases.entrySet()) {
                        String name = dishNames.get(entry.getKey());
                        dishData.addValue(entry.getValue(), name, name);
                    }

                    break;
                }

                default:
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Could not contact FOH for sales!");
        }
    }
}
