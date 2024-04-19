package Components;

import Resources.*;

import javax.swing.*;
import java.awt.event.*;

/**
 * Themed button component
 */
public class CButton extends JButton {

    /** Create a themed button component
     * @param label text label for the button
     * @param textSize font size for the button text
     * @param clickAction callback action for button click
     */
    public CButton(String label, int textSize, ActionListener clickAction) {
        super(label);
        this.setForeground(Colors.background);
        this.setBackground(Colors.frame);
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Colors.white));
        this.setFont(Resources.getFont(textSize));
        this.setFocusPainted(false);
        this.addActionListener(clickAction);
    }

    /** Create a themed button component with default font size of 20
     * @param label text label for the button
     * @param clickAction callback action for button click
     */
    public CButton(String label, ActionListener clickAction) {
        this(label, 20, clickAction);
    }
}
