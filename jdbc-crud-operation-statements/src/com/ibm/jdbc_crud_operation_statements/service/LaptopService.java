package com.ibm.jdbc_crud_operation_statements.service;

import com.ibm.jdbc_crud_operation_statements.dao.LaptopDao;
import com.ibm.jdbc_crud_operation_statements.dto.Laptop;

public class LaptopService {
    
    public void insertLaptop(Laptop laptop) {

        LaptopDao dao = new LaptopDao();
        if(laptop.getPrice()<=40000){
            System.out.println("inside laptop service");
            dao.insertLaptop(laptop);

        }
        else{
            System.out.println("price is too high");
        }
    }
    public void updateLaptop(Laptop laptop) {
        LaptopDao dao = new LaptopDao();
        dao.updateLaptop(laptop);
    }


    public void deleteLaptop(Laptop laptop) {
        LaptopDao dao = new LaptopDao();
        dao.deleteLaptop(laptop);
    }


    public void displayLaptop() {
        LaptopDao dao = new LaptopDao();
        dao.displayLaptop();
    }
}
