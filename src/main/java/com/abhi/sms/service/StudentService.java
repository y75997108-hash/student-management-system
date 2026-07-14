package com.abhi.sms.service;

import com.abhi.sms.dao.StudentDAO;
import com.abhi.sms.model.Student;
import java.util.List;

public class StudentService {

    private StudentDAO studentDAO = new StudentDAO();

    public boolean addStudent(Student student){
        if (student.getName().isBlank()) {
            System.out.println("Name cannot be empty..");
            return false;
        }

        if (student.getAge() < 16 || student.getAge() > 60) {
            System.out.println("Age must between 16 and 60");
            return false;
        }

        if (student.getBranch().isBlank()) {
            System.out.println("Branch cant be empty");
        }

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
