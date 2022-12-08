package com.qsp.jdbc_prepared_statement_eve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import com.qsp.jdbc_prepared_statement_eve.connection.GameConnection;
import com.qsp.jdbc_prepared_statement_eve.dto.Game;

public class GameDao {
    Connection connection = GameConnection.getConnection();
    // insert method
    public void insertGame(Game game) {
        String insert = "insert into game values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, game.getId());
            preparedStatement.setString(2, game.getName());
            preparedStatement.setInt(3, game.getTeamPlayer());
            preparedStatement.setDouble(4, game.getExpense());
            preparedStatement.execute();
            System.out.println("data inserted");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    // update method by id
    public void updateGame(Game game) {
        String insert = "update game set name =?, player=?, expense=? where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(4, game.getId());
            preparedStatement.setString(1, game.getName());
            preparedStatement.setInt(2, game.getTeamPlayer());
            preparedStatement.setDouble(3, game.getExpense());
            int id = preparedStatement.executeUpdate();
            if (id!=0) {
                System.out.println("data updated");
            } else {
                System.out.println("data not updated");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    // delete method by id
    public void deleteGame(Game game) {
        String insert = "delete from game where id =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, game.getId());
            int id = preparedStatement.executeUpdate();
            if (id!=0) {
                System.out.println("data deleted");
            } else {
                System.out.println("data not deleted");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    // delete all method
    public void deleteAllGame() {
        String insert = "delete from game";
        try {
            Statement statement = connection.createStatement();
            int id = statement.executeUpdate(insert);
            if (id!=0) {
                System.out.println("all data deleted");
            } else {
                System.out.println("data not deleted");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    // display all method
    public LinkedList<Game> displayAllGame() {
        String insert = "select * from game";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(insert);
            LinkedList<Game> linkedList = new LinkedList<Game>();
            while (resultSet.next()) {
                Game game = new Game();
                game.setId(resultSet.getInt("id"));
                game.setName(resultSet.getString("name"));
                game.setTeamPlayer(resultSet.getInt("player"));
                game.setExpense(resultSet.getDouble("expense"));
                linkedList.add(game);
            }
            return linkedList;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
    // get by id method
    public int getById(int id) {
        String insert = "select * from game";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(insert);
            int getId;
            if (resultSet!=null) {
                while (resultSet.next()) {
                    getId = resultSet.getInt("id");
                    return getId;
                }
            } else {
                System.out.println("id not present");
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return 0;
    }
    // insert in batch
    public void insertAddBatch(LinkedList<Game> game2) {
        String insert = "insert into game values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            for (Game game : game2) {
                preparedStatement.setInt(1, game.getId());
                preparedStatement.setString(2, game.getName());
                preparedStatement.setInt(3, game.getTeamPlayer());
                preparedStatement.setDouble(4, game.getExpense());
                preparedStatement.execute();
            }
            System.out.println("data inserted");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    

}
