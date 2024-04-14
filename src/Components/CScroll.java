package Components;

import Resources.*;

import javax.swing.*;
import javax.swing.plaf.basic.*;
import java.awt.*;

public class CScroll extends JScrollPane {
    public CScroll(Component content) {
        super(content);
        this.setPreferredSize(new Dimension(0, 0));
        this.setBorder(null);
        this.getVerticalScrollBar().setUnitIncrement(16);
        this.getVerticalScrollBar().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Colors.frame));
        this.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Colors.secondary;
                this.trackColor = Colors.background;
            }
        });
        this.getVerticalScrollBar().getComponent(0).setBackground(Colors.background);
        this.getVerticalScrollBar().getComponent(1).setBackground(Colors.background);
        this.getVerticalScrollBar().setPreferredSize(new Dimension(15, 0));
    }
}
