package com.qsp.jdbc_prepared_statement_eve.cotroller;

import java.util.LinkedList;
import java.util.Scanner;

import com.qsp.jdbc_prepared_statement_eve.dto.Car;
import com.qsp.jdbc_prepared_statement_eve.service.CarService;

public class CarController {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Car car = new Car();
            CarService carService = new CarService();

            while (true) {
                System.out.print("\n1.insert\n2.update\n3.delete\n4.delete all\n5.display all\nany other to exit\ngive your choice : ");
                int ch = scanner.nextInt();
                switch (ch) {
                    // insert
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
                        
                        carService.insertCar(car);
                    }
                    break;
                    // update by id
                    case 2:
                    {
                        System.out.println("enter the car id");
                        car.setId(scanner.nextInt());
                        System.out.println("enter the new car brand");
                        car.setBrand(scanner.next());
                        System.out.println("enter the new car model");
                        car.setModel(scanner.next());
                        System.out.println("enter the new car price");
                        car.setPrice(scanner.nextDouble());
                        
                        carService.updateCar(car);
                    }
                    break;
                    // delete by id
                    case 3:
                    {
                        System.out.println("enter the car id");
                        car.setId(scanner.nextInt());
                        
                        carService.deleteCar(car);
                    }
                    break;
                    // delete all
                    case 4:
                    {
                        carService.deleteAllCar();
                    }
                    break;
                    // display all
                    case 5:
                    {
                        LinkedList<Car> linkedList = carService.displayCar();
                        for (Car car2 : linkedList) {
                            System.out.println("------------------------------------");
                            System.out.println("id: "+car2.getId());
                            System.out.println("brand: "+car2.getBrand());
                            System.out.println("model: "+car2.getModel());
                            System.out.println("price: "+car2.getPrice());
                            System.out.println("------------------------------------");
                        }
                    }
                    break;
                    default:
                    {
                        System.exit(1);
                    }
                }
            }
        }
    }
}
