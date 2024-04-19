package Components;

import Resources.*;

import javax.swing.*;

/**
 * Themed password field component
 * <p> Hides inputted characters with * symbols
 */
public class CPasswordField extends JPasswordField {

    /** Create a themed password field component
     * @param textSize font size for the password field
     */
    public CPasswordField(int textSize) {
        super(0);
        this.setForeground(Colors.background);
        this.setDisabledTextColor(Colors.secondary);
        this.setBackground(Colors.white);
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Colors.frame));
        this.setFont(Resources.getFont(textSize));
    }

    /** Create a themed password field component with default font size of 20
     */
    public CPasswordField() {
        this(20);
    }
}
