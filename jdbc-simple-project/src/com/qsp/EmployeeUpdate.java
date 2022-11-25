package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeUpdate {
    public static void main(String[] args) {
        Connection conn= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/jdbc-simple-project";
            String user = "maity";
            String pass = "1Q2w3e4r@";
            
            conn = DriverManager.getConnection(url, user, pass);
            
            Statement statement = conn.createStatement();
            System.out.println("Connection made : "+conn);

            String update = "update employee set name ='rohit' where id = 1000";
            int id = statement.executeUpdate(update);
            if (id!=0) {
                System.out.println("Data Updated...");
            } else {
                System.out.println("check your id that is not present");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        }
        finally{
            try {
                conn.close();
                System.out.println("Connection made : "+conn);
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}
