package Components;

import javax.swing.*;
import javax.swing.plaf.basic.*;
import java.awt.*;

public class CScroll extends JScrollPane {
    public CScroll(Component content) {
        super(content);
        this.setPreferredSize(new Dimension(0, 0));
        this.setBorder(null);
        this.getVerticalScrollBar().setUnitIncrement(8);
        this.getVerticalScrollBar().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(166, 165, 163)));
        this.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(43, 51, 54);
                this.trackColor = new Color(222, 222, 222);
            }
        });
        this.getVerticalScrollBar().getComponent(0).setBackground(new Color(43, 51, 54));
        this.getVerticalScrollBar().getComponent(1).setBackground(new Color(43, 51, 54));
        this.getVerticalScrollBar().setPreferredSize(new Dimension(15, 0));
    }
}
