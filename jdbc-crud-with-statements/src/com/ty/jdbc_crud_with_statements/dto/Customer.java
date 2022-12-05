package com.ty.jdbc_crud_with_statements.dto;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerEmail;
    public String getCustomerEmail() {
        return customerEmail;
    }
    public int getCustomerId() {
        return customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
