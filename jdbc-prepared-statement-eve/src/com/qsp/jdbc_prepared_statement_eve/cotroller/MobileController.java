package com.qsp.jdbc_prepared_statement_eve.cotroller;

import java.util.Scanner;

import com.qsp.jdbc_prepared_statement_eve.dto.Mobile;
import com.qsp.jdbc_prepared_statement_eve.service.MobileService;

public class MobileController {
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            Mobile mobile = new Mobile();
            MobileService mobileService = new MobileService();
            while (true) {
                System.out.println("1.insert\ngive your choice\n");
                int ch = scanner.nextInt();
                switch (ch) {
                    case 1:
                        {
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
                
                    default:
                        break;
                }
            }
        }
    }
}
