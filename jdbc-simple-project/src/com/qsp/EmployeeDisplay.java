package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDisplay {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/jdbc-simple-project";
            String user = "maity";
            String pass = "1Q2w3e4r@";
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection made : "+conn);

            Statement statement= conn.createStatement();
            String display = "select * from employee";
            ResultSet resultSet = statement.executeQuery(display);
            
            while (resultSet.next()) {   
                System.out.print("id = "+resultSet.getInt(1)+" ");
                System.out.print("name = "+resultSet.getString("name")+" ");
                System.out.println("email = "+resultSet.getString(3));
            }
            
        } catch (Exception e) {
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
