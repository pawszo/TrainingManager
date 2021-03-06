package usr;

import screens.UserPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setAlwaysOnTop(true);
        setResizable(false);
        userNameLabel = new JLabel("USERNAME: ");
        userNameField = new JTextField(30);
        pwLabel = new JLabel("PASSWORD: ");
        pwLabel.setBounds(20, 20, 100, 30);
        pwField = new JPasswordField(30);
        submit = new JButton("Submit");
        submit.addActionListener(this);
        lostPw = new JButton("Lost password?");
        lostPw.addActionListener(this);
        info = new JLabel("Enter your username and password to continue.");

        start();

        setVisible(true);
    }

    private void start() {
        user = new User();
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

        if (actionEvent.getSource() == submit) {
            System.out.println("Validating credentials...");
            if (DBcon.checkUserPassword(userNameField.getText(), pwField.getText())) {
                this.user = new User(userNameField.getText());
                System.out.println("LOGIN SUCCESSFULL");
                this.userPanel.setLoggedIn(user);
                this.setVisible(false);
            }
        /*    if(userNameField.getText().equals(user.getUserName()) &&
                pwField.getText().equals(user.getPassword())) {
                System.out.println("Login successfull");
                userPanel.setUser(new User(userNameField.getText(), pwField.getText()));
            } */
            else {
                failCount++;
                System.out.println("Login failed.");
                if (failCount < 5) {
                    info.setText("Login failed " + failCount + " times.\nCheck spelling.");
                } else {
                    info.setText("Login failed " + failCount + " times.\nUse option \"Lost password?\"");
                }
            }
            //    System.out.println(userNameField.getText());
            //    System.out.println(pwField.getText());
        }
        if (actionEvent.getSource() == lostPw) {
            userPanel.setLostPassword(new LostPassword(userPanel));
            this.setVisible(false);
        }
    }
}
