package com.ibm.jdbc_crud_operation_statements.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ibm.jdbc_crud_operation_statements.dto.Laptop;

public class LaptopDao {
    //insert 
    public void insertLaptop(Laptop laptop) {
        Connection connection = null;
        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // establish connection
            String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements";
            String user = "maity";
            String pass = "1Q2w3e4r@";
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection made : "+connection);

            // create statement
            Statement statement = connection.createStatement();
            System.out.println("statement created");
            String insert = "insert into laptop values("+laptop.getId()+", '"+laptop.getName()+"', "+laptop.getPrice()+", '"+laptop.getColor()+"')";

            // execute query
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

    
    // update name
    public void updateLaptop(Laptop laptop) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements";
            String user = "maity";
            String pass = "1Q2w3e4r@";
            connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            String update = "update laptop set name ='"+laptop.getName()+"' where id = "+laptop.getId()+"";
            int id = statement.executeUpdate(update);
            if (id!=0) {
                System.out.println("data updated");
            } else {
                System.out.println("id is not present");
            }
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
    public void deleteLaptop(Laptop laptop) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements";
            String user = "maity";
            String pass = "1Q2w3e4r@";
            connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            String delete = "delete from laptop where id = "+laptop.getId()+"";
            int id = statement.executeUpdate(delete);
            if (id!=0) {
                System.out.println("data deleted");
            } else {
                System.out.println("id is not present");
            }
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

    // display
    public void displayLaptop() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements";
            String user = "maity";
            String pass = "1Q2w3e4r@";
            connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            String display = "select * from laptop";
            ResultSet resultSet = statement.executeQuery(display);
            while (resultSet.next()) {
                System.out.println("----------------------------------------------");
                System.out.print("id = "+resultSet.getInt(1)+" ");
                System.out.print("name = "+resultSet.getString(2)+" ");
                System.out.println("price = "+resultSet.getString(3));
                System.out.println("color = "+resultSet.getString(4));
                System.out.println("----------------------------------------------");
            }
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
}
