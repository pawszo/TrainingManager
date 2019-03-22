package screens;

import javafx.embed.swing.JFXPanel;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.Chart;
import usr.CreateUser;
import usr.Logon;
import usr.User;
import usr.UserStat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class UserPanel extends JPanel implements ActionListener {



    private JTextField userInfo;
    private JButton logIn, logOut, createAccountButton;
    private User user;
    private Frame frame;
    private JPanel logonPanel;
    private UserStat userDetPanel;



    private JDialog logon;
    private JDialog createUser;
    private JDialog lostPassword;

    public UserPanel(Dimension dim, Frame frame){
        setLayout(new GridLayout(2, 1));
        this.frame = frame;
        setSize(dim);
        setBackground(Color.ORANGE);
        createComponents();
        addComponents();

    }

    private void createComponents() {
        logIn = new JButton("LOG IN");
        logOut = new JButton("LOG OUT");
        userInfo = new JTextField();
        userInfo.setText("Log in or register to continue");
        createAccountButton = new JButton("CREATE NEW USER");
        logonPanel = new JPanel();
        logonPanel.setBackground(Color.ORANGE);
        userDetPanel = new UserStat(this);


    }
    private void addComponents() {
        logonPanel.add(logIn);
        logonPanel.add(logOut);
        logonPanel.add(createAccountButton);
        logonPanel.add(userInfo);
       add(logonPanel);
       add(userDetPanel);
        userInfo.setEditable(false);
        logIn.addActionListener(this);
        logOut.addActionListener(this);
        createAccountButton.addActionListener(this);
        logOut.setVisible(false);
    }

    public void setLoggedIn(User user) {
        User.currentUser = user;
        User.currentUser.setUserID(User.currID);
        this.getUserInfo().setText("Logged in as " + User.currentUser.getUserName() + ".");
        this.logIn.setVisible(false);
        logOut.setVisible(true);
        this.createAccountButton.setVisible(false);
        NotePanel.syncNoteList();
        userDetPanel.setVisible(true);

    }

    private void setLoggedOut() {
        User.currentUser = null;
        userInfo.setText("Log in or register to continue");
        logOut.setVisible(false);
        logIn.setVisible(true);
        createAccountButton.setVisible(true);
        userDetPanel.setVisible(false);
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
