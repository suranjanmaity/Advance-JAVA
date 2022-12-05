package com.qsp.jdbc_prepared_statement_eve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.qsp.jdbc_prepared_statement_eve.connection.MobileConnection;
import com.qsp.jdbc_prepared_statement_eve.dto.Mobile;

public class MobileDao {
    
    Connection connection = null;

    
    public void insertMobile(Mobile mobile) {
        connection = MobileConnection.getConnection();
        String insertString = "insert into mobile values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertString);
            preparedStatement.setInt(1, mobile.getId());
            preparedStatement.setString(2, mobile.getBrand());
            preparedStatement.setDouble(3, mobile.getPrice());
            preparedStatement.setString(4, mobile.getColor());
            preparedStatement.setString(5, mobile.getCamera());
            preparedStatement.execute();
            
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
