package com.ibm.jdbc_crud_operation_statements.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.ibm.jdbc_crud_operation_statements.dto.Laptop;

public class LaptopDao {
    //insert 
    public void insertLaptop(Laptop laptop) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements";
            String user = "maity";
            String pass = "1Q2w3e4r@";
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection made : "+connection);
            Statement statement = connection.createStatement();
            System.out.println("statement created");
            String insert = "insert into laptop values("+laptop.getId()+", '"+laptop.getName()+"', "+laptop.getPrice()+", '"+laptop.getColor()+"')";

            statement.execute(insert);
            System.out.println("data inserted");
        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        }
        finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    
    // delete
    // public void deleteLaptop(Laptop laptop) {
    //     Connection connection = null;
    //     try {
    //         Class.forName("com.mysql.cj.jdbc.Driver");
    //         String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements";
    //         String user = "maity";
    //         String pass = "1Q2w3e4r@";
    //         connection = DriverManager.getConnection(url, user, pass);
    //         Statement statement = connection.createStatement();
    //         String delete = "";
    //         statement.executeQuery(delete);
    //     } catch (ClassNotFoundException | SQLException e) {
    //         e.getStackTrace();
    //     }
    //     finally{
    //         try {
    //             connection.close();
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }
}
