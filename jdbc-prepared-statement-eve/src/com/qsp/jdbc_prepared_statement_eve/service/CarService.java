package com.qsp.jdbc_prepared_statement_eve.service;

import java.util.LinkedList;

import com.qsp.jdbc_prepared_statement_eve.dao.CarDao;
import com.qsp.jdbc_prepared_statement_eve.dto.Car;

public class CarService {
    CarDao carDao = new CarDao();
    public void insertCar(Car car) {
        carDao.insertCar(car);
    }
    public void updateCar(Car car) {
        if (car.getId()==carDao.getById(car.getId())) {
            carDao.updateCar(car);
        }
    }
    public void deleteCar(Car car) {
        if (car.getId()==carDao.getById(car.getId())) {
            carDao.deleteCar(car);
        }
    }
    public void deleteAllCar() {
        carDao.deleteAllCar();
    }
    public LinkedList<Car> displayCar() {
        return carDao.displayCar();
    }
}
