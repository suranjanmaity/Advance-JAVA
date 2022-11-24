package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc-simple-project";
            String user = "maity";
            String pass = "1Q2w3e4r@";
            conn = DriverManager.getConnection(url, user, pass);

            Statement statement = conn.createStatement();
            System.out.println(conn);

            String ins = "insert into student values(6,'vijay',27)";
            statement.execute(ins);
            System.out.println("inserted...");
            
            // String upd = "alter table student rename column class to age";
            // statement.executeUpdate(upd);
            // System.out.println("updated...");


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();;
        }
        finally{
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
