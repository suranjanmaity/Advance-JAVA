package com.qsp.jdbc_prepared_statement_eve.service;

import com.qsp.jdbc_prepared_statement_eve.dao.CarDao;
import com.qsp.jdbc_prepared_statement_eve.dto.Car;

public class CarService {
    CarDao carDao = new CarDao();
    public void InsertCar(Car car) {
        carDao.InsertCar(car);
    }
}
