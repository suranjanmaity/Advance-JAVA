package com.ty.jdbc_crud_with_statements.controller;

import com.ty.jdbc_crud_with_statements.dto.Customer;
import com.ty.jdbc_crud_with_statements.service.CustomerService;

public class CustomerController {
    public static void main(String[] args) {
        Customer customer = new Customer();
        CustomerService customerService = new CustomerService();
        customer.setCustomerId(101);
        customer.setCustomerName("customer");
        customer.setCustomerEmail("customer@gmail.com");
        customerService.insertCustomer(customer);
    }
}
