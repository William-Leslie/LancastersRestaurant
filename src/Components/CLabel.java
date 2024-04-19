package Components;

import Resources.*;

import javax.swing.*;

/**
 * Themed label component
 */
public class CLabel extends JLabel {

    /** Create a themed label component
     * @param text textual content of the label
     * @param textSize font size for the label text
     */
    public CLabel(String text, int textSize) {
        super(text);
        this.setForeground(Colors.text);
        this.setFont(Resources.getFont(textSize));
    }

    /** Create a themed label component with default font size of 20
     * @param text textual content of the label
     */
    public CLabel(String text) {
        this(text, 20);
    }
}
