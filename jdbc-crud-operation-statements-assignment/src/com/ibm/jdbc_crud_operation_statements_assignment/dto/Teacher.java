package com.ibm.jdbc_crud_operation_statements_assignment.dto;
public class Teacher {
    private int id;
    private String name;
    private String email;
    private int pnone;
    // get
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public int getPnone() {
        return pnone;
    }
    // set
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPnone(int pnone) {
        this.pnone = pnone;
    }

}
