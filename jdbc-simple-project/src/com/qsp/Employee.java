package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {

    public static void main(String[] args) {
        
        
        Connection conn = null;
        try {
            //step 1 load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // step 2 establish the commection
            String url = "jdbc:mysql://localhost:3306/jdbc-simple-project";
            String user = "maity";
            String pass = "1Q2w3e4r@";

            conn = DriverManager.getConnection(url, user, pass);

            // step 3 create the statement
            Statement statement = conn.createStatement();

            // step 4 execute query
            String insert = "insert into employee values(1000, 'ram', 'ram@gmail.com')";
            statement.execute(insert);
            System.out.println("inserted...");



            System.out.println(conn);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        finally{
            // step 5 close the connection
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
    }
}
