package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeInsert {

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
            System.out.println("Connection made : "+conn);

            // step 3 create the statement
            Statement statement = conn.createStatement();

            // step 4 execute query
            String insert = "insert into employee values(1002, 'ramurao', 'ramurao@gmail.com')";
            statement.execute(insert);
            System.out.println("inserted...");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        finally{
            // step 5 close the connection
            try {
                conn.close();
                System.out.println("Connection made : "+conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
    }
}
