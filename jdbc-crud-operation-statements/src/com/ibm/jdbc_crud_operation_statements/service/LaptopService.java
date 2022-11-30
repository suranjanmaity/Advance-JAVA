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
}
