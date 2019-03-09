package usr;

import screens.UserPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateUser extends JDialog implements ActionListener {

    private User user;
    private String password;
    private JTextField userNameField;
    private JPasswordField pwField;
    private JLabel userNameLabel, pwLabel;
    private UserPanel userPanel;
    private JButton submit, registered;

    public CreateUser(UserPanel userPanel) {
        this.userPanel = userPanel;
        setLayout(new FlowLayout());
        setSize(new Dimension(380, 200));
        setLocationRelativeTo(userPanel);
        setBackground(Color.blue);
        setAlwaysOnTop(true);
        setResizable(false);
        userNameLabel = new JLabel("NEW USERNAME: ");
        userNameLabel.setVisible(true);

        userNameField = new JTextField(30);
        pwLabel = new JLabel("NEW PASSWORD: ");
        pwLabel.setBounds(20, 20, 100, 30);
        pwField = new JPasswordField(30);
        submit = new JButton("CREATE USER");
        submit.addActionListener(this);
        registered = new JButton("ALREADY REGISTERED?");
        registered.addActionListener(this);

        start();
        setVisible(true);

    }

    private void start() {
        user = new User();
        user.setUserName("username123");
        user.setPassword("password1");
        add(userNameLabel);
        add(userNameField);
        add(pwLabel);
        add(pwField);
        add(submit);
        add(registered);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() == submit) {
            System.out.println("Validating credentials...");
            if(userNameField.getText().equals(user.getUserName()) &&
                    pwField.getText().equals(user.getPassword())) {
                System.out.println("Login successfull");
            }
            else {            }
        }
        if(actionEvent.getSource() == registered) {
            userPanel.setLogon(new Logon(userPanel));
            this.setVisible(false);
        }
    }
}
