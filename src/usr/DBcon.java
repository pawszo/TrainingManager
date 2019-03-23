package usr;

import java.sql.*;
import java.util.ArrayList;

public class DBcon {

    /** DB CONNECTION CREDENTIALS */

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String url       = "jdbc:mysql://localhost:3306/trainingmanager";
    static final String DBuser     = "root";
    static final String DBpassword  = "root";


    public static void connect() {
        Connection conn = null;
        Statement stmt = null;


        try {
            Class.forName(JDBC_DRIVER); //register JDBC driver

            conn = DriverManager.getConnection(url, DBuser, DBpassword);  //open connection
            System.out.println("CONNECTION SUCCESSFUL");

            stmt = conn.createStatement();  // create statement

            String sql = "SELECT id, username, email, password FROM user";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");

                System.out.println(id);
                System.out.println(username);
                System.out.println(email);
                System.out.println(password);

            }
            rs.close();



        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("CONNECTION FAILED : " + e );
        } finally {
            try{
                if(conn != null) conn.close();
            } catch(SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static boolean checkUserPassword(String username, String password) {
        Connection conn = null;
        Statement stmt = null;
        int id = -1;

        try {
            Class.forName(JDBC_DRIVER); //register JDBC driver

            conn = DriverManager.getConnection(url, DBuser, DBpassword);  //open connection
            System.out.println("CONNECTION SUCCESSFUL");

            stmt = conn.createStatement();  // create statement

            String sql = "SELECT id FROM user WHERE username = \"" + username + "\" AND password = \"" + password + "\";";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                id = rs.getInt("id");
                User.currID = id;
            }




        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("CONNECTION FAILED : " + e );
        } finally {
            try{
                if(conn != null) conn.close();
                if(id != -1) return true;
                else return false;
            } catch(SQLException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
    }

    public static void insertUser(String username, String email, String password, char sex ) {
        Connection conn = null;
        Statement stmt = null;


        try {
            Class.forName(JDBC_DRIVER); //register JDBC driver

            conn = DriverManager.getConnection(url, DBuser, DBpassword);  //open connection
            System.out.println("CONNECTION SUCCESSFUL");

            stmt = conn.createStatement();  // create statement

            String sql = "INSERT INTO user (username, email, sex, password) VALUES ('" + username + "', '" + email + "', '" + sex + "', '" + password + "');";
            stmt.executeUpdate(sql);

            stmt.close();



        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("CONNECTION FAILED : " + e );
        } finally {
            try{
                if(conn != null) conn.close();
            } catch(SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**Adds notes into database. WHen add button is used, this method is invoked, then notelist is refreshed with sync method. */
    public static void addNotes(String note) {
        Connection conn = null;
        Statement stmt = null;


        try {
            Class.forName(JDBC_DRIVER); //register JDBC driver

            conn = DriverManager.getConnection(url, DBuser, DBpassword);  //open connection
            System.out.println("CONNECTION SUCCESSFUL");

            stmt = conn.createStatement();  // create statement

            String sql = "INSERT INTO note (userID, note, date) VALUES ('" + User.currentUser.getUserID() + "', '" + note + "', now());";
            stmt.executeUpdate(sql);

            stmt.close();



        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("CONNECTION FAILED : " + e );
        } finally {
            try{
                if(conn != null) conn.close();
            } catch(SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static ArrayList<String> getNoteArrayList() {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<String> noteArray = new ArrayList<>();


        try {
            Class.forName(JDBC_DRIVER); //register JDBC driver

            conn = DriverManager.getConnection(url, DBuser, DBpassword);  //open connection
            System.out.println("CONNECTION SUCCESSFUL");

            stmt = conn.createStatement();  // create statement

            String sql = "SELECT note FROM note WHERE userID='" + User.currentUser.getUserID() + "';";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                String note = rs.getString("note");
                noteArray.add(note);


            }
            rs.close();



        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("CONNECTION FAILED : " + e );
        } finally {
            try{
                if(conn != null) conn.close();
                return noteArray;
            } catch(SQLException ex) {
                System.out.println(ex.getMessage());
                return noteArray;
            }
        }
    }
    /** DETELE NOTE FROM TABLE FOR THE LOGGED IN USER */
    public static void deleteNote(String note) {
        Connection conn = null;
        Statement stmt = null;


        try {
            Class.forName(JDBC_DRIVER); //register JDBC driver

            conn = DriverManager.getConnection(url, DBuser, DBpassword);  //open connection
            System.out.println("CONNECTION SUCCESSFUL");

            stmt = conn.createStatement();  // create statement

            String sql = "DELETE FROM note WHERE userID='" + User.currentUser.getUserID() + "' AND note='" + note + "';";
            stmt.executeUpdate(sql);

            stmt.close();



        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("CONNECTION FAILED : " + e );
        } finally {
            try{
                if(conn != null) conn.close();
            } catch(SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static String getNoteDate(String note) {
        Connection conn = null;
        Statement stmt = null;
        String date = "";


        try {
            Class.forName(JDBC_DRIVER); //register JDBC driver

            conn = DriverManager.getConnection(url, DBuser, DBpassword);  //open connection
            System.out.println("CONNECTION SUCCESSFUL");

            stmt = conn.createStatement();  // create statement

            String sql = "SELECT date FROM note WHERE userID='" + User.currentUser.getUserID() + "' AND note='" + note + "';";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                date = rs.getString("date");
            }
            rs.close();



        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("CONNECTION FAILED : " + e );
        } finally {
            try{
                if(conn != null) conn.close();
                return date;
            } catch(SQLException ex) {
                System.out.println(ex.getMessage());
                return date;
            }
        }
    }
}
