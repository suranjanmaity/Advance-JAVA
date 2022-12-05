package com.qsp.jdbc_prepared_statement_eve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.qsp.jdbc_prepared_statement_eve.connection.CarConnection;
import com.qsp.jdbc_prepared_statement_eve.dto.Car;

public class CarDao {
    Connection connection = null;

    public void InsertCar(Car car) {
        connection = CarConnection.getConnection();
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
}
