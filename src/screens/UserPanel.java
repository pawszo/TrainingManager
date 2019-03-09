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
    private JButton logIn, logOut, currentButton, createAccountButton;
    private User user;



    private JDialog logon;
    private JDialog createUser;

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
        if (user == null) {
            currentButton = logIn;
            userInfo.setText("Log in or register to continue");
        } else {
            currentButton = logOut;
            userInfo.setText("Logged in as: " + user.getUserName() + ".");
        }
        currentButton.addActionListener(this);
        createAccountButton = new JButton("CREATE NEW USER");
        createAccountButton.addActionListener(this);

    }
    private void addComponents() {
        add(currentButton);
        add(createAccountButton);
        add(userInfo);
    }



    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() == logIn) {
            System.out.println("LOG IN DIALOG");
            logon = new Logon(this);

        }
        if(actionEvent.getSource() == logOut) {
            System.out.println("LOG OUT");
        }
        if(actionEvent.getSource() == createAccountButton) {
            System.out.println("CREATE NEW USER DIALOG");
            createUser = new CreateUser(this);
          ;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
