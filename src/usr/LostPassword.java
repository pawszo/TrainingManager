package usr;

import screens.UserPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LostPassword extends JDialog implements ActionListener {

    private User user;
    private String userName, email;
    private JTextField userNameField, emailField;
    private JLabel userNameLabel, emailLabel;
    private JButton send;
    private UserPanel userPanel;
    private JComponent[] fields;

    public LostPassword(UserPanel userPanel) {
        this.userPanel = userPanel;
        setLayout(new FlowLayout());
        setSize(new Dimension(380, 200));
        setLocationRelativeTo(userPanel);
        setAlwaysOnTop(true);
        setResizable(false);

        userNameLabel = new JLabel("USERNAME: ");
        userNameField = new JTextField(30);
        emailLabel = new JLabel("EMAIL");
        emailField = new JTextField(30);
        send = new JButton("SEND REMINDER");
        send.addActionListener(this);
        fields = new JComponent[] {userNameLabel, userNameField, emailLabel, emailField, send};

        setVisible(true);
        start();
    }

    private void start() {
        for(JComponent f:fields) {
            add(f);
        }
    }





    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() == send) {
            System.out.println("Reminder sent!");
            this.setVisible(false);
        }
    }
}
