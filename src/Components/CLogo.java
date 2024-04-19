package Components;

import Resources.*;

import javax.swing.*;
import java.awt.*;

/**
 * Themed logo component
 */
public class CLogo extends JLabel {

    /** Create a themed logo component
     * @param width width of the logo in pixels
     * @param height height of the logo in pixels
     */
    public CLogo(int width, int height) {
        super(new ImageIcon(Resources.getLogo(Integer.max(width, height))));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Colors.text));
        this.setPreferredSize(new Dimension(width, height));
    }
}
