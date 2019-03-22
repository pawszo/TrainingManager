package exercise;

import javax.swing.*;
import java.awt.*;


/** List holding set of exercise + parameter
 *
 */
public class TrainingList extends JList{

    public TrainingList() {
        setPreferredSize(new Dimension(450, 200));
        setLayoutOrientation(JList.VERTICAL);
    }
}
