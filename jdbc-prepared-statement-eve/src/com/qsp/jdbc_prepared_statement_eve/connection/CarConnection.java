package com.qsp.jdbc_prepared_statement_eve.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class CarConnection {
    
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        String urlString = "jdbc:mysql://localhost:3306/jdbc-prepared-statement-eve";
        String userString = "maity";
        String passString = "1Q2w3e4r@";
        connection = DriverManager.getConnection(urlString, userString, passString);
        if (connection != null) {
            return connection;
        } else {
            System.out.println("check user pass and url");
        }
        
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}
