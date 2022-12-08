package com.qsp.jdbc_prepared_statement_eve.service;

import java.util.LinkedList;

import com.qsp.jdbc_prepared_statement_eve.dao.GameDao;
import com.qsp.jdbc_prepared_statement_eve.dto.Game;

public class GameService {
    GameDao gameDao = new GameDao();
    // inset method
    public void insertGame(Game game) {
        gameDao.insertGame(game);
    }
    // update method by id
    public void updateGame(Game game) {
        gameDao.updateGame(game);
    }
    // delete method by id
    public void deleteGame(Game game) {
        gameDao.deleteGame(game);
    }
    // delete all method
    public void deleteAllGame() {
        gameDao.deleteAllGame();
    }
    // display all method
    public LinkedList<Game> displayAllGame() {
        return gameDao.displayAllGame();
    }
    // get by id method
    public int getById(int id) {
        return gameDao.getById(id);
    }
    // insert in batch
    public void insertAddBatch(LinkedList<Game> game) {
        gameDao.insertAddBatch(game);
    }
}
