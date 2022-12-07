package com.qsp.jdbc_prepared_statement_eve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.qsp.jdbc_prepared_statement_eve.connection.MobileConnection;
import com.qsp.jdbc_prepared_statement_eve.dto.Mobile;

public class MobileDao {
    
    Connection connection = MobileConnection.getConnection();
    
    public void insertMobile(Mobile mobile) {
        String insertString = "insert into mobile values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertString);
            preparedStatement.setInt(1, mobile.getId());
            preparedStatement.setString(2, mobile.getBrand());
            preparedStatement.setDouble(3, mobile.getPrice());
            preparedStatement.setString(4, mobile.getColor());
            preparedStatement.setString(5, mobile.getCamera());
            preparedStatement.execute();
            System.out.println("data inserted");

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    
    public void updateMobile(Mobile mobile) {
        String update = "update mobile set color=?, price=?, camera=? where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, mobile.getColor());
            preparedStatement.setDouble(2, mobile.getPrice());
            preparedStatement.setString(3, mobile.getCamera());
            preparedStatement.setInt(4, mobile.getId());
            preparedStatement.executeUpdate();
            
            int id= preparedStatement.executeUpdate();
            if (id!=0) {
                System.out.println("data updated");
            } else {
                System.out.println("id does not exist");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        
    }

    public void deleteMobile(Mobile mobile) {
        String update = "delete from mobile where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setInt(1, mobile.getId());

            int id= preparedStatement.executeUpdate();
            if (id!=0) {
                System.out.println("data deleted");
            } else {
                System.out.println("id does not exist");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        
    }

    public void deleteAllMobile() {
        String update = "delete from mobile";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int id= preparedStatement.executeUpdate();
            if (id!=0) {
                System.out.println("all data deleted");
            } else {
                System.out.println("id does not exist");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        
    }

    // get by id
    public int getById(int id) {
        String select = "select * from mobile where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet != null) {
                    int getId = resultSet.getInt(1);
                    return getId;
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return 0;
    }

    // display method
    public LinkedList<Mobile> displayMobile() {
        String select = "select * from mobile";
        LinkedList<Mobile> linkedList = new LinkedList<Mobile>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Mobile mobile = new Mobile();
                mobile.setId(resultSet.getInt("id"));
                mobile.setBrand(resultSet.getString("brand"));
                mobile.setPrice(resultSet.getInt("price"));
                mobile.setColor(resultSet.getString("color"));
                mobile.setCamera(resultSet.getString("camera"));
                linkedList.add(mobile);
            }
            return linkedList;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}
