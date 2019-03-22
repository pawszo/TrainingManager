package usr;

public class User {


    public User() {
        userName = null;
        password = null;
    }

    public User(String username) {
        userName = username;
    }


    private String userName;
    private String password;
    private String email;
    private int userID;
    public static int currID;


    public static User currentUser = null;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int id) {
        this.userID = id;
    }

    @Override
    public String toString() {
        String word = "USERNAME: " + this.userName + "\n";
        word += "EMAIL: " + this.email + "\n";
        word += "USER_ID: " + this.userID + "\n";
        return word;
    }
}
