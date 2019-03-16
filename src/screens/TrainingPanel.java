package screens;

import javax.swing.*;
import java.awt.*;

public class TrainingPanel extends JPanel {

    private JLabel timer;
    private double count;

    public TrainingPanel(Dimension dim) {
        setSize(dim);
        setBackground(new Color(100, 86, 38));
        createTimer();
    }

    public void createTimer() {
        count = 0.00;
        timer = new JLabel(Double.toString(count));
        add(timer);
    }
}
