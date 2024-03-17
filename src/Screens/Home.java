package Screens;

import Resources.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JPanel {

    private JLabel Logo = Resources.getLogo(400,400);
    private JButton buttonStaff = new JButton("Staff");
    private JButton buttonWines = new JButton("Wines");
    private JButton buttonMenus = new JButton("Menus");
    private JButton buttonIngredients = new JButton("Ingredients");
    private JButton buttonSales = new JButton("Sales");
    private JButton buttonParameters = new JButton("Parameters");

    public Home (JPanel screens) {
        super();
        setLayout(new BorderLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setBackground(new Color(0x2b3336));

        this.Logo.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.add(this.Logo,BorderLayout.WEST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(0x2b3336));
        this.buttonStaff.setForeground(new Color(0xcccccc));
        this.buttonStaff.setBackground(new Color(0x557b8a));
        this.buttonStaff.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        this.buttonStaff.setFont(Resources.getFont(26));
        this.buttonStaff.setFocusPainted(false);
        this.buttonStaff.setPreferredSize(new Dimension(600,100));
        buttonPanel.add(this.buttonStaff);

        this.buttonIngredients.setForeground(new Color(0xcccccc));
        this.buttonIngredients.setBackground(new Color(0x557b8a));
        this.buttonIngredients.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        this.buttonIngredients.setFont(Resources.getFont(26));
        this.buttonIngredients.setFocusPainted(false);
        this.buttonIngredients.setPreferredSize(new Dimension(600,100));
        buttonPanel.add(this.buttonIngredients);

        this.buttonSales.setForeground(new Color(0xcccccc));
        this.buttonSales.setBackground(new Color(0x557b8a));
        this.buttonSales.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        this.buttonSales.setFont(Resources.getFont(26));
        this.buttonSales.setFocusPainted(false);
        this.buttonSales.setPreferredSize(new Dimension(600,100));
        buttonPanel.add(this.buttonSales);

        this.buttonParameters.setForeground(new Color(0xcccccc));
        this.buttonParameters.setBackground(new Color(0x557b8a));
        this.buttonParameters.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        this.buttonParameters.setFont(Resources.getFont(26));
        this.buttonParameters.setFocusPainted(false);
        this.buttonParameters.setPreferredSize(new Dimension(600,100));
        buttonPanel.add(this.buttonParameters);

        this.buttonWines.setForeground(new Color(0xcccccc));
        this.buttonWines.setBackground(new Color(0x557b8a));
        this.buttonWines.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        this.buttonWines.setFont(Resources.getFont(26));
        this.buttonWines.setFocusPainted(false);
        this.buttonWines.setPreferredSize(new Dimension(600,100));
        buttonPanel.add(this.buttonWines);

        this.buttonWines.setForeground(new Color(0xcccccc));
        this.buttonWines.setBackground(new Color(0x557b8a));
        this.buttonWines.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xffffff)));
        this.buttonWines.setFont(Resources.getFont(26));
        this.buttonWines.setFocusPainted(false);
        this.buttonWines.setPreferredSize(new Dimension(600,100));
        buttonPanel.add(this.buttonWines);

        this.add(buttonPanel);



    }
}
