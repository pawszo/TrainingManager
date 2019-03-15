package usr;

import screens.UserPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateUser extends JDialog implements ActionListener {

    private User user;
    private String password, email;
    private JTextField userNameField, emailField;
    private JPasswordField pwField, pwField2;
    private JLabel userNameLabel, pwLabel, pwLabel2, emailLabel;
    private UserPanel userPanel;
    private JButton submit, registered, ok;

    private JComponent[] fields;

    public CreateUser(UserPanel userPanel) {
        this.userPanel = userPanel;
        setLayout(new FlowLayout());
        setSize(new Dimension(380, 300));
        emailLabel = new JLabel("EMAIL");
        emailField = new JTextField(30);     setLocationRelativeTo(userPanel);
        setAlwaysOnTop(true);
        setResizable(false);
        userNameLabel = new JLabel("USERNAME: ");
        userNameField = new JTextField(30);
        pwLabel = new JLabel("PASSWORD: ");
        pwField = new JPasswordField(30);
        pwLabel2 = new JLabel("CONFIRM PASSWORD: ");
        pwField2 = new JPasswordField(30);
        emailLabel = new JLabel("EMAIL");
        emailField = new JTextField(30);
        submit = new JButton("CREATE USER");
        submit.addActionListener(this);
        registered = new JButton("ALREADY REGISTERED?");
        registered.addActionListener(this);
        ok = new JButton("OK");
        ok.addActionListener(this);

        fields = new JComponent[] {userNameLabel, userNameField, pwLabel, pwField, pwLabel2, pwField2, emailLabel, emailField};

        start();
        setVisible(true);

    }

    private void start() {
        user = new User();
        user.setUserName("username123"); //temporary
        user.setPassword("password1");  //temporary

        for(JComponent f:fields) {
            add(f);
        }
        add(submit);
        add(registered);
        add(ok).setVisible(false);

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() == submit) {
            System.out.println("Checking...");
            if(userNameField.getText().equals("") || pwField.getText().equals("") || emailField.getText().equals("")) {
                System.out.println("You need to enter fill in all fields");
            } else if (pwField.getText().equals(pwField2.getText())) {
                DBcon.insertUser(userNameField.getText(), emailField.getText(), pwField.getText(), 'm');
                System.out.println("NEW ACCOUNT CREATED");
                DBcon.connect();
                for(JComponent f:fields) {
                    f.setEnabled(false);
                }
                ok.setVisible(true);

            }
        }
        if(actionEvent.getSource() == registered) {
            userPanel.setLogon(new Logon(userPanel));
            this.setVisible(false);
        }
        if(actionEvent.getSource() == ok) {
            this.setVisible(false);
        }
    }
}
