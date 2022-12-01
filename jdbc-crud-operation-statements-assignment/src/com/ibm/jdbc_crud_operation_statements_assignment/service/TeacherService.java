package com.ibm.jdbc_crud_operation_statements_assignment.service;

import java.util.LinkedList;

import com.ibm.jdbc_crud_operation_statements_assignment.dao.TeacherDao;
import com.ibm.jdbc_crud_operation_statements_assignment.dto.Teacher;

public class TeacherService {
    TeacherDao dao = new TeacherDao();
    
    public void insertTeacher(Teacher teacher) {
        dao.insertTeacher(teacher);
    }
    public void updateTeacher(Teacher teacher) {
        dao.updateTeacher(teacher);
    }
    public void deleteTeacher(Teacher teacher) {
        dao.displayTeacher();
    }
    public LinkedList<Teacher> displayTeacher() {
        return dao.displayTeacher();
    }
    
}
