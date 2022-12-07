package com.qsp.jdbc_prepared_statement_eve.cotroller;

import java.util.LinkedList;
import java.util.Scanner;

import com.qsp.jdbc_prepared_statement_eve.dto.Mobile;
import com.qsp.jdbc_prepared_statement_eve.service.MobileService;

public class MobileController {
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            MobileService mobileService = new MobileService();
            while (true) {
                System.out.print("\n1.insert\n2.update\n3.delete\n4.delete all\n5.display all\nany other to exit\ngive your choice : ");
                int ch = scanner.nextInt();
                switch (ch) {
                    // insert
                    case 1:
                        {
                            Mobile mobile = new Mobile();
                            System.out.println("insert the id");
                            mobile.setId(scanner.nextInt());
                            System.out.println("insert the name");
                            mobile.setBrand(scanner.next());
                            System.out.println("insert the price");
                            mobile.setPrice(scanner.nextDouble());
                            System.out.println("insert the color");
                            mobile.setColor(scanner.next());
                            System.out.println("insert the camera");
                            mobile.setCamera(scanner.next());

                            mobileService.insertMobile(mobile);
                        }
                        break;
                        // update by id
                    case 2:
                    {
                        Mobile mobile = new Mobile();
                        System.out.println("enter the id");
                        mobile.setId(scanner.nextInt());

                        System.out.println("enter the  new price");
                        mobile.setPrice(scanner.nextDouble());
                        System.out.println("enter the new color");
                        mobile.setColor(scanner.next());
                        System.out.println("enter the new camera");
                        mobile.setCamera(scanner.next());

                        mobileService.updateMobile(mobile);
                    }
                    break;
                    // delete by id
                    case 3:
                    {
                        Mobile mobile = new Mobile();
                        System.out.println("enter the id");
                        mobile.setId(scanner.nextInt());
                        mobileService.deleteMobile(mobile);
                    }
                    break;
                    // delete by id
                    case 4:
                    {
                        mobileService.deleteAllMobile();
                    }
                    break;
                    // display all
                    case 5:
                    {
                        LinkedList<Mobile> linkedList = mobileService.displayMobile();
                        for (Mobile car2 : linkedList) {
                            System.out.println("------------------------------------");
                            System.out.println("id: "+car2.getId());
                            System.out.println("brand: "+car2.getBrand());
                            System.out.println("color: "+car2.getColor());
                            System.out.println("camera: "+car2.getCamera());
                            System.out.println("price: "+car2.getPrice());
                            System.out.println("------------------------------------");
                        }
                    }
                    break;
                
                    default:
                        System.exit(1);
                }
            }
        }
    }
}
