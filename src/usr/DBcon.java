package usr;

import java.sql.*;

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


}
