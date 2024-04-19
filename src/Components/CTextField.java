package Components;

import Resources.*;

import javax.swing.*;

/**
 * Themed text field component
 */
public class CTextField extends JTextField {

    /** Create a themed text field component
     * @param initialText text to insert into the text field by default
     * @param textSize font size for the text field
     */
    public CTextField(String initialText, int textSize) {
        super(initialText);
        this.setForeground(Colors.background);
        this.setDisabledTextColor(Colors.secondary);
        this.setBackground(Colors.white);
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Colors.frame));
        this.setFont(Resources.getFont(textSize));
    }

    /** Create a themed text field component with default font size of 20
     * @param initialText text to insert into the text field by default
     */
    public CTextField(String initialText) {
        this(initialText, 20);
    }

    /** Create a themed text field component with no default text
     * @param textSize font size for the text field
     */
    public CTextField(int textSize) {
        this(null, textSize);
    }

    /** Create a themed text field component with no default text and default font size of 20
     */
    public CTextField() {
        this(null, 20);
    }
}
