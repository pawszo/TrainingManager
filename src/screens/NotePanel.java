package screens;

import javax.swing.*;
import java.awt.*;

public class NotePanel extends JPanel {

    private JTextField noteField;

    public NotePanel(Dimension dim) {
        setSize(dim);
        setBackground(Color.pink);
        noteField = new JTextField();
        noteField.setPreferredSize(new Dimension((int) (dim.getWidth()*0.75), (int) (dim.getHeight()*0.75)));
        noteField.setToolTipText("Enter your training notes here");
        add(noteField);
    }
}
