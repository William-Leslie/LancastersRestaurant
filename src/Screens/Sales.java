package Screens;

import Components.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class Sales extends JPanel {

    private DefaultCategoryDataset dishData;
    private DefaultCategoryDataset takingsData;
    private DefaultCategoryDataset bookingDataCombined;
    private JFreeChart chart1;
    private JFreeChart chart2;
    private JFreeChart chart3;
    public Sales(JPanel screens) {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;

        CNavbar navbar = new CNavbar("Sales", event -> {
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
        mainConstraints.fill = GridBagConstraints.BOTH;
        mainConstraints.weightx = 1;
        mainConstraints.insets = new Insets(16, 16, 16, 16);

        dishData = new DefaultCategoryDataset();
        takingsData = new DefaultCategoryDataset();
        bookingDataCombined = new DefaultCategoryDataset();

        //Date Set Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.setBackground(new Color(0x2b3336));

        CButton day = new CButton("Day", e -> updateData("day"));
        buttonPanel.add(day);

        CButton week = new CButton("Week", e -> updateData("week"));
        buttonPanel.add(week);

        CButton month = new CButton("Month", e -> updateData("month"));
        buttonPanel.add(month);

        CButton year = new CButton("Year", e -> updateData("year"));
        buttonPanel.add(year);

        // Add the buttonPanel to the main panel
        mainConstraints.gridy = 0;
        mainConstraints.gridx = 0;
        panelMain.add(buttonPanel, mainConstraints);

        //Set Default Data Day
        updateData("day");

        // Create charts
        chart1 = ChartFactory.createBarChart(
                "Most Popular Dishes",
                "Amount",
                "Dish",
                dishData,
                PlotOrientation.VERTICAL,
                true, true, false);

        chart2 = ChartFactory.createBarChart(
                "Takings",
                "Date",
                "Amount",
                takingsData,
                PlotOrientation.VERTICAL,
                true, true, false);

        chart3 = ChartFactory.createBarChart(
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
    public void updateData(String date){
        dishData.clear();
        takingsData.clear();
        bookingDataCombined.clear();

        // FIXME: USE THE COMMAND "dishData.addValue(value:amount,rowKey:String dishID, columnKey:dishID)" to add data.
        // FIXME: USE THE COMMAND "takingsData.addValue(value:amount,rowKey:takings, columnKey:date)" to add data.
        // FIXME: USE THE COMMAND "bookingDataCombined.addValue(value:amount,rowKey:String type, columnKey:date)" to add data.
        switch(date) {
            case "day": //Today's Values
                //Values need to be added from maximum to minimum
                dishData.addValue(60, "Pasta", "Pasta");
                dishData.addValue(40, "Chicken", "Chicken");
                dishData.addValue(30, "Fish", "Fish");
                dishData.addValue(20, "Eggs", "Eggs");
                dishData.addValue(10, "Pizza", "Pizza");

                takingsData.addValue(120, "Takings", "Today");

                bookingDataCombined.addValue(200, "Online", "Today");
                bookingDataCombined.addValue(240, "Phone", "Today");
                break;
            case "week":
                dishData.addValue(600, "Pasta", "Pasta");
                dishData.addValue(300, "Lamb", "Chicken");
                dishData.addValue(250, "Fish", "Fish");
                dishData.addValue(200, "Eggs", "Eggs");
                dishData.addValue(100, "Pizza", "Pizza");

                takingsData.addValue(120, "Takings", "Monday");
                takingsData.addValue(100, "Takings", "Tuesday");
                takingsData.addValue(160, "Takings", "Wednesday");
                takingsData.addValue(120, "Takings", "Thursday");
                takingsData.addValue(160, "Takings", "Friday");
                takingsData.addValue(120, "Takings", "Saturday");
                takingsData.addValue(120, "Takings", "Sunday");

                bookingDataCombined.addValue(200, "Online", "Monday");
                bookingDataCombined.addValue(240, "Phone", "Monday");
                bookingDataCombined.addValue(260, "Online", "Tuesday");
                bookingDataCombined.addValue(230, "Phone", "Tuesday");
                bookingDataCombined.addValue(100, "Online", "Wednesday");
                bookingDataCombined.addValue(170, "Phone", "Wednesday");
                bookingDataCombined.addValue(220, "Online", "Thursday");
                bookingDataCombined.addValue(130, "Phone", "Thursday");

                break;
            case "month": //Instead of doing Week 1 etc. could do starting day of week e.g. 08/04/2024 - 14/04/2024
                takingsData.addValue(120, "Takings", "Week 1");
                takingsData.addValue(100, "Takings", "Week 2");
                takingsData.addValue(160, "Takings", "Week 3");
                takingsData.addValue(120, "Takings", "Week 4");

                break;
            case "year":
                takingsData.addValue(120, "Takings", "January");
                takingsData.addValue(100, "Takings", "February");
                takingsData.addValue(160, "Takings", "March");
                takingsData.addValue(120, "Takings", "April");
                takingsData.addValue(160, "Takings", "May");
                takingsData.addValue(120, "Takings", "June");
                takingsData.addValue(120, "Takings", "July");
                takingsData.addValue(120, "Takings", "August");
                takingsData.addValue(160, "Takings", "September");
                takingsData.addValue(120, "Takings", "October");
                takingsData.addValue(120, "Takings", "November");
                takingsData.addValue(120, "Takings", "December");

                //If labels are touching too much use this to rotatename labels:
                //CategoryPlot plot2 = (CategoryPlot) chart2.getPlot();
                //CategoryAxis xAxis2 = plot2.getDomainAxis();
                //xAxis2.setCategoryLabelPositions(CategoryLabelPositions.UP_90);

                break;
            default:
                break;
        }
    }
}
