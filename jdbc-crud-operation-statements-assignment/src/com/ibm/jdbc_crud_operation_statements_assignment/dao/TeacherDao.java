package com.ibm.jdbc_crud_operation_statements_assignment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import com.ibm.jdbc_crud_operation_statements_assignment.dto.Teacher;

public class TeacherDao {
    // INSERT
    public void insertTeacher(Teacher teacher) {
        Connection connection= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urlString = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements-assignment";
            String userString = "maity";
            String passString = "1Q2w3e4r@";
            connection =  DriverManager.getConnection(urlString, userString, passString);
            System.out.println("connection made");
            Statement statement= connection.createStatement();
            System.out.println("statement created");
            String inseString = "insert into laptop values("+teacher.getId()+",'"+teacher.getName()+"','"+teacher.getEmail()+"',"+teacher.getPnone()+" )";
            statement.execute(inseString);
            System.out.println("data inserted");


        } catch (Exception e) {
            e.getStackTrace();
        }
        finally{
            try {
                connection.close();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
    // UPDATE
    public void updateTeacher(Teacher teacher) {
        Connection connection= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urlString = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements-assignment";
            String userString = "maity";
            String passString = "1Q2w3e4r@";
            connection =  DriverManager.getConnection(urlString, userString, passString);
            System.out.println("connection made");
            Statement statement= connection.createStatement();
            System.out.println("statement created");
            String inseString = "update teacher set name = "+teacher.getName()+" where id = "+teacher.getId()+"";
            int i = statement.executeUpdate(inseString);
            if (i!=0) {
                System.out.println("data updated");
            } else {
                System.out.println("id not present");
            }
        }catch (Exception e) {
            e.getStackTrace();
        }
        finally{
            try {
                connection.close();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
    // DELETE
    public void deleteTeacher(Teacher teacher) {
        Connection connection= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urlString = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements-assignment";
            String userString = "maity";
            String passString = "1Q2w3e4r@";
            connection =  DriverManager.getConnection(urlString, userString, passString);
            System.out.println("connection made");
            Statement statement= connection.createStatement();
            System.out.println("statement created");
            String inseString = "delete from teacher where id = "+teacher.getId()+" ";
            int i = statement.executeUpdate(inseString);
            if (i!=0) {
                System.out.println("data deleted");
            } else {
                System.out.println("id not present");
            }


        } catch (Exception e) {
            e.getStackTrace();
        }
        finally{
            try {
                connection.close();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
    // DISPLAY
    public LinkedList<Teacher> displayTeacher() {
        LinkedList<Teacher> foo = new LinkedList<Teacher>();
        Connection connection= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urlString = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements-assignment";
            String userString = "maity";
            String passString = "1Q2w3e4r@";
            connection =  DriverManager.getConnection(urlString, userString, passString);
            System.out.println("connection made");
            Statement statement= connection.createStatement();
            System.out.println("statement created");
            String inseString = "select * from teacher";
            statement.execute(inseString);
            ResultSet resultSet = statement.executeQuery(inseString);
            
            while (resultSet.next()) {
                Teacher teacher2= new Teacher();
                teacher2.setId(resultSet.getInt(1));
                teacher2.setName(resultSet.getString(2));
                teacher2.setEmail(resultSet.getString(3));
                teacher2.setPnone(resultSet.getInt(4));
                foo.add(teacher2);
            }
          
            return foo;

        } catch (Exception e) {
            e.getStackTrace();
        }
        finally{
            try {
                connection.close();
            } catch (Exception e) {
                e.getStackTrace();
            }
            
        }
        return foo;
    }
}
