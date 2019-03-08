package screens;

import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {


    private JPasswordField pwField;
    private JTextField userNameField;
    private JLabel userNameLabel, pwLabel;
    private JButton submit;

    public UserPanel(Dimension dim){
        setSize(dim);
        setBackground(Color.ORANGE);
        userNameLabel = new JLabel("USERNAME: ");
        add(userNameLabel);
        userNameField = new JTextField(30);
        add(userNameField);
        pwLabel = new JLabel("PASSWORD: ");
        add(pwLabel);
        pwField = new JPasswordField((30));
        add(pwField);
    }


}
