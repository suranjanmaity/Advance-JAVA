package com.qsp.jdbc_prepared_statement_eve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.qsp.jdbc_prepared_statement_eve.connection.CarConnection;
import com.qsp.jdbc_prepared_statement_eve.dto.Car;

public class CarDao {
    Connection connection = CarConnection.getConnection();

    public void insertCar(Car car) {
        String insertString  = "insert into car values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertString);
            preparedStatement.setInt(1, car.getId());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.setDouble(4, car.getPrice());

            preparedStatement.execute();
            
        } catch (Exception e) {
            e.getStackTrace();
        }
        
    }

    public void updateCar(Car car) {
        String insertString  = "update car set brand=?, model=?, price=? where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertString);
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setDouble(3, car.getPrice());
            preparedStatement.setInt(4, car.getId());

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


    public void deleteCar(Car car) {
        String update = "delete from car where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setInt(1, car.getId());
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

    public void deleteAllCar() {
        String update = "delete from car";
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
        String select = "select * from car where id=?";
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
    // get by id
    public LinkedList<Car> displayCar() {
        String select = "select * from car";
        LinkedList<Car> linkedList = new LinkedList<Car>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Car mobile = new Car();
                mobile.setId(resultSet.getInt("id"));
                mobile.setBrand(resultSet.getString("brand"));
                mobile.setPrice(resultSet.getInt("price"));
                mobile.setModel(resultSet.getString("model"));
                linkedList.add(mobile);
            }
            return linkedList;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}
