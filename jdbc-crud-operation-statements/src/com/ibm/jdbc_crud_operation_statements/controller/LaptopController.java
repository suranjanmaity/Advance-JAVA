package com.ibm.jdbc_crud_operation_statements.controller;

import java.util.Scanner;

import com.ibm.jdbc_crud_operation_statements.dto.Laptop;
import com.ibm.jdbc_crud_operation_statements.service.LaptopService;

public class LaptopController {
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            Laptop laptop = new Laptop();
            LaptopService laptopService = new LaptopService();
            while (true) {
            System.out.println("\n1.insert\n2.update\n3.delete\n4.display\nenter your choice : ");
            int choice = scanner.nextInt();
                switch (choice) {
                    case 1:{

                        System.out.println("enter laptopId");
                        laptop.setId(scanner.nextInt());
                        System.out.println("enter laptopName");
                        laptop.setName(scanner.next());
                        System.out.println("enter laptopPrice");
                        laptop.setPrice(scanner.nextDouble());
                        System.out.println("enter laptopColor");
                        laptop.setColor(scanner.next());
                        
                        laptopService.insertLaptop(laptop);
                        break;
                    }
                    // update
                    case 2: {
                        System.out.println("enter laptopId");
                        laptop.setId(scanner.nextInt());
                        System.out.println("enter laptopName");
                        laptop.setName(scanner.next());
                        
                        laptopService.updateLaptop(laptop);
                        break;
                    }
                    // delete
                    case 3:{
                        System.out.println("enter laptopId");
                        laptop.setId(scanner.nextInt());

                        laptopService.deleteLaptop(laptop);
                        break;
                    }
                    // display
                    case 4:{
                        laptopService.displayLaptop();
                        break;
                    }
                    
                    default:{
                        System.out.println("invalid choice.\n");
                        break;
                    }
                }
            }
        }
        
    }
}
