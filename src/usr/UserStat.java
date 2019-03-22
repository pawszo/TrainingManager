package usr;

import screens.UserPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserStat extends JPanel implements ActionListener {

    private JButton updateButton;
    private JTextField weightField;
    private JLabel weightLabel;
    private UserPanel userPanel;
    private JPanel buttonPanel;

    public UserStat(UserPanel userPanel) {
        this.userPanel = userPanel;
        setLayout(new GridLayout(2, 1));
        createComponents();
        addComponents();
        setVisible(false);
    }

    private void createComponents() {
        weightField = new JTextField(20);
        updateButton = new JButton("UPDATE STATS");
        updateButton.addActionListener(this);
        weightLabel = new JLabel("Enter current weight");
        weightLabel.setVerticalAlignment(SwingConstants.CENTER);
        weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
    }





    private void addComponents() {
        buttonPanel.add(weightLabel);
        buttonPanel.add(weightField);
        buttonPanel.add(updateButton);
        add(buttonPanel);

    }












    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
