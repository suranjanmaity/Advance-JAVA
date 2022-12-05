package com.qsp.jdbc_prepared_statement_eve.cotroller;

import java.util.Scanner;

import com.qsp.jdbc_prepared_statement_eve.dto.Car;
import com.qsp.jdbc_prepared_statement_eve.service.CarService;

public class CarController {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Car car = new Car();
            CarService carService = new CarService();

            while (true) {
                System.out.println("1.insert\nenter your choice");
                int ch = scanner.nextInt();
                switch (ch) {
                    case 1:
                        {
                            System.out.println("enter the car id");
                            car.setId(scanner.nextInt());
                            System.out.println("enter the car brand");
                            car.setBrand(scanner.next());
                            System.out.println("enter the car model");
                            car.setModel(scanner.next());
                            System.out.println("enter the car price");

                            car.setPrice(scanner.nextDouble());
                            
                            carService.InsertCar(car);
                        }
                        break;
                
                    default:
                        break;
                }
            }
        }
    }
}
