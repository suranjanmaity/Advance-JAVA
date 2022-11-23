package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Employee {

    public static void main(String[] args) {
        
        //step 1 load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // step 2 establish the commection
            String url = "jdbc:mysql://localhost:3306/";
            String user = "maity";
            String pass = "1Q2w3e4r@";

            Connection conn = DriverManager.getConnection(url, user, pass);

            System.out.println(conn);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        
    }
}
