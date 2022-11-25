package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class EmployeeDelete {
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
            String delete = "delete from employee where id =1001";
            int id = statement.executeUpdate(delete);
            if (id!=0) {
                System.out.println("Data deleted...");
            } else {
                System.out.println("check id no that is not present");
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
