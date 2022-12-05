package com.ty.jdbc_crud_with_statements.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ty.jdbc_crud_with_statements.dto.Customer;

public class CustomerDao  {
    // insert method 
    public void insertCustomer(Customer customer){
    Connection connection= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements";
            String user = "maity";
            String pass = "1Q2w3e4r@";
            connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            String insert = "insert into customer values ( "+customer.getCustomerId()+", '"+customer.getCustomerName()+"', '"+customer.getCustomerEmail()+"')";
            statement.execute(insert);
            System.out.println("data inserted");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    // ---------------------------------------------------get by id--------------------------------------------------------
    // --this method is only used for geting the id from database and store it in a variable-------------------------------
    public int getById(int id) {
    Connection connection= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements";
            String user = "maity";
            String pass = "1Q2w3e4r@";
            connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            String insert = "select * cusotmer where id = "+id+"";
            ResultSet resultSet = statement.executeQuery(insert);
            try {
                int id1 = resultSet.getInt(1);
                return id1;
            } catch (Exception e) {
                e.getStackTrace();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    // ---------------------------------------------------update name--------------------------------------------------------
    public void updateCustomer(String name, int id){
        Connection connection= null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements";
                String user = "maity";
                String pass = "1Q2w3e4r@";
                connection = DriverManager.getConnection(url, user, pass);
                Statement statement = connection.createStatement();

                String insert = "update customer set name = '"+name+"' where id = "+id+"";

                statement.execute(insert);
                System.out.println("data updated");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
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
