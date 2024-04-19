package Components;

import Resources.*;

import javax.swing.*;

/**
 * Themed text area component
 */
public class CTextArea extends JTextArea {

    /** Create a themed text area component
     * @param initialText text to insert into the text area by default
     * @param textSize font size for the text area
     */
    public CTextArea(String initialText, int textSize) {
        super(initialText);
        this.setForeground(Colors.background);
        this.setDisabledTextColor(Colors.secondary);
        this.setBackground(Colors.white);
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Colors.frame));
        this.setFont(Resources.getFont(textSize));
        this.setCaretPosition(0);
        this.setAutoscrolls(false);
    }

    /** Create a themed text area component with default font size of 20
     * @param initialText text to insert into the text area by default
     */
    public CTextArea(String initialText) {
        this(initialText, 20);
    }

    /** Create a themed text area component with no default text
     * @param textSize font size for the text area
     */
    public CTextArea(int textSize) {
        this(null, textSize);
    }

    /** Create a themed text area component with no default text and default font size of 20
     */
    public CTextArea() {
        this(null, 20);
    }
}
