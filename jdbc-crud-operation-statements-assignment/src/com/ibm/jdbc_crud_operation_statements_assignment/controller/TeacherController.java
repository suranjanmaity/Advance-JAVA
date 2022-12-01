package com.ibm.jdbc_crud_operation_statements_assignment.controller;

import java.util.LinkedList;
import java.util.Scanner;

import com.ibm.jdbc_crud_operation_statements_assignment.dto.Teacher;
import com.ibm.jdbc_crud_operation_statements_assignment.service.TeacherService;

public class TeacherController {
    public static void main(String[] args) {
        
        try (Scanner scn = new Scanner(System.in)) {
            int exit=0;
            while (exit!=0) {
                Teacher teacher = new Teacher();
                TeacherService service = new TeacherService();
                System.out.println();
                System.out.println("1.Insert\n2.Update\n3.Delete\n4.Display\nany other to EXIT\n");
                System.out.print("enter your choice : ");
                int choice=scn.nextInt();
                switch (choice) {
                    case 1:{
                        System.out.println("Enter id :");
                        int id = scn.nextInt();
                        teacher.setId(id);
                        System.out.println("Enter name :");
                        String name= scn.next();
                        teacher.setName(name);
                        System.out.println("Enter email :");
                        String email = scn.next();
                        teacher.setEmail(email);
                        System.out.println("Enter phone no :");
                        int pno = scn.nextInt();
                        teacher.setId(pno);
                        service.insertTeacher(teacher);
                        
                        break;
                    }
                    case 2:{
                        System.out.println("Enter id :");
                        int id = scn.nextInt();
                        teacher.setId(id);
                        System.out.println("Enter name :");
                        String name= scn.next();
                        teacher.setName(name);
                        service.updateTeacher(teacher);
                        break;
                    }
                    case 3:{
                        System.out.println("Enter id :");
                        int id = scn.nextInt();
                        teacher.setId(id);
                        service.deleteTeacher(teacher);
                        break;
                    }
                    case 4:{
                        LinkedList<Teacher> teachers = service.displayTeacher();
                        for(Teacher teacher2 : teachers) {
                            System.out.println("====================================");
                            System.out.println("id :"+teacher2.getId());
                            System.out.println("id :"+teacher2.getName());
                            System.out.println("id :"+teacher2.getEmail());
                            System.out.println("id :"+teacher2.getPnone());
                            System.out.println("====================================");
                        }
                        break;
                    }   
                
                    default:{
                        exit++;
                        break;
                    }
                }
            }
        }
    }
}
