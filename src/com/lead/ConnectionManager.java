package com.lead;

import java.sql.*;
import javax.sql.*;

/**
 * Created by Majd on 4/11/2017.
 */
public class ConnectionManager {
    private static String url = "jdbc:mysql://localhost:3306/users";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "meisme@1212";
    private static Connection con;


    public static Connection getConnection() {

        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }
        return con;
    }
}
