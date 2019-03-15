package screens;

import usr.CreateUser;
import usr.Logon;
import usr.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel extends JPanel implements ActionListener {



    private JTextField userInfo;
    private JButton logIn, logOut, createAccountButton;
    private User user;



    private JDialog logon;
    private JDialog createUser;
    private JDialog lostPassword;

    public UserPanel(Dimension dim){
        setSize(dim);
        setBackground(Color.ORANGE);
        setLayout(new FlowLayout());

        createComponents();
        addComponents();

    }

    private void createComponents() {
        logIn = new JButton("LOG IN");
        logOut = new JButton("LOG OUT");
        userInfo = new JTextField();
        userInfo.setText("Log in or register to continue");
        createAccountButton = new JButton("CREATE NEW USER");

    }
    private void addComponents() {
        add(logIn);
        add(logOut);
        add(createAccountButton);
        add(userInfo);
        logIn.addActionListener(this);
        logOut.addActionListener(this);
        createAccountButton.addActionListener(this);
        logOut.setVisible(false);
    }

    public void setLoggedIn(User user) {
        this.user = user;
        this.getUserInfo().setText("Logged in as " + user.getUserName() + ".");
        this.logIn.setVisible(false);
        logOut.setVisible(true);
        this.createAccountButton.setVisible(false);
    }

    private void setLoggedOut() {
        user = null;
        userInfo.setText("Log in or register to continue");
        logOut.setVisible(false);
        logIn.setVisible(true);
        createAccountButton.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() == logIn) {
            System.out.println("LOG IN DIALOG");
            logon = new Logon(this);

        }
        if(actionEvent.getSource() == logOut) {
            System.out.println("LOG OUT");
            setLoggedOut();
        }
        if(actionEvent.getSource() == createAccountButton) {
            System.out.println("CREATE NEW USER DIALOG");
            createUser = new CreateUser(this);

        }
    }

    public JDialog getLogon() {
        return logon;
    }

    public void setLogon(JDialog logon) {
        this.logon = logon;
    }

    public JDialog getCreateUser() {
        return createUser;
    }
    public void setCreateUser(JDialog createUser) {
        this.createUser = createUser;
    }

    public void setLostPassword(JDialog lostPassword) {
        this.lostPassword = lostPassword;
    }
    public JDialog getLostPassword() {
        return lostPassword;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private JTextField getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(JTextField userInfo) {
        this.userInfo = userInfo;
    }
}
