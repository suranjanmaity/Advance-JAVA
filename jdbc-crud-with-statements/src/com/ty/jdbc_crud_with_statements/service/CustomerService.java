package com.ty.jdbc_crud_with_statements.service;

import com.ty.jdbc_crud_with_statements.dao.CustomerDao;
import com.ty.jdbc_crud_with_statements.dto.Customer;

public class CustomerService {
    CustomerDao dao = new CustomerDao();
    public void insertCustomer(Customer customer){
        dao.insertCustomer(customer);
    }

    // update method
    public void updateCustomer(String name, int id) {
        int id1  = dao.getById(id);
        if (id == id1) {
            dao.updateCustomer(name, id);
        }
        else{
            System.out.println("hey this "+id+" is not present "+id1);
        }
    }
}
