package usr;

import screens.UserPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Scanner;

public class Logon extends JDialog implements ActionListener {
    // private PasswordAuthentication // later for authenticator
    // private Authenticator // authentication for network connection

    private User user;
    private String password;
    private JTextField userNameField;
    private JPasswordField pwField;
    private JLabel userNameLabel, pwLabel;
    private JButton submit, lostPw;
    private UserPanel userPanel;
    private JLabel info;
    private JTextArea area;
    private int failCount = 0;



    public Logon(UserPanel userPanel) {
        this.userPanel = userPanel;
        setLayout(new FlowLayout());
        setSize(new Dimension(380, 200));
        setLocationRelativeTo(userPanel);
        setBackground(Color.blue);
        setAlwaysOnTop(true);
        setResizable(false);
        userNameLabel = new JLabel("USERNAME: ");
        userNameLabel.setVisible(true);

        userNameField = new JTextField(30);
        pwLabel = new JLabel("PASSWORD: ");
        pwLabel.setBounds(20, 20, 100, 30);
        pwField = new JPasswordField(30);
        submit = new JButton("Submit");
        submit.addActionListener(this);
        lostPw = new JButton("Lost password?");
        info = new JLabel("Enter your username and password to continue.");

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
        add(lostPw);
        add(info);

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() == submit) {
            System.out.println("Validating credentials...");
            if(userNameField.getText().equals(user.getUserName()) &&
                pwField.getText().equals(user.getPassword())) {
                System.out.println("Login successfull");
                userPanel.setUser(new User(userNameField.getText(), pwField.getText()));
            }
            else {
                failCount++;
                System.out.println("Login failed.");
                if(failCount < 5) {
                    info.setText("Login failed " + failCount + " times.\nCheck spelling.");
                } else {
                    info.setText("Login failed " + failCount + " times.\nUse option \"Lost password?\"");
                }
            }
        //    System.out.println(userNameField.getText());
        //    System.out.println(pwField.getText());
        }
    }
}
