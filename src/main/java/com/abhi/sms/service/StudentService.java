package com.abhi.sms.service;

import com.abhi.sms.dao.StudentDAO;
import com.abhi.sms.model.Student;
import java.util.List;

public class StudentService {

    private StudentDAO studentDAO = new StudentDAO();

    public boolean addStudent(Student student){

         return studentDAO.addStudent(student);

    }
    public List<Student> getAllStudent(){
        return studentDAO.getAllStudent();
    }

    public Student getStudentById(int id){
        return studentDAO.getStudentById(id);
    }

    public boolean updateStudent(Student student){
        return studentDAO.updateStudent(student);
    }

    public boolean deleteStudent(int id){
        return studentDAO.deleteStudent(id);
    }

}
