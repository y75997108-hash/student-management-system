package com.abhi.sms.dao;
import com.abhi.sms.model.Student;
import java.sql.Connection;
import com.abhi.sms.util.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

public class StudentDAO 
{
        public boolean addStudent(Student student)
        {
            // Code to add student to the database
            String sql = "INSERT INTO student(name,age,branch) VALUES(?,?,?)";

            try(Connection connection = DBConnection.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(sql))
            {
                preparedStatement.setString(1, student.getName());
                preparedStatement.setInt(2, student.getAge());
                preparedStatement.setString(3, student.getBranch());

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;

            }catch(SQLException e){
                e.printStackTrace();
                return false;
            }
        }
        public List<Student> getAllStudent(){
            List<Student> students = new ArrayList<>();

            String sql = "SELECT * FROM student";

            try(Connection connection =  DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery())
            {
                while (resultSet.next()) 
                {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String branch = resultSet.getString("branch");

                    Student student = new Student(
                                                id,
                                                name,
                                                age,
                                                branch);
                    students.add(student);
                    
                }
                
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }

            return students;

        }

        public Student getStudentById(int id){
            String sql = "SELECT * FROM student WHERE ID = ?";
            try(Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ){

                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        
                        String name = resultSet.getString("name");
                        int age = resultSet.getInt("age");
                        String branch = resultSet.getString("branch");

                        Student student = new Student(
                                                    id,
                                                    name,
                                                    age,
                                                    branch );
                        return student;
                    }

                    
                
            } catch (SQLException e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
            return null;
        }

        public boolean updateStudent(Student student){
            String sql = "UPDATE student SET name = ? , age = ?, branch = ? WHERE id = ?";

            try(Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                    preparedStatement.setString(1,student.getName());
                    preparedStatement.setInt(2, student.getAge());
                    preparedStatement.setString(3,student.getBranch());
                    preparedStatement.setInt(4, student.getId());

                    int rowsAffected = preparedStatement.executeUpdate();
                    return rowsAffected>0;

                }catch(SQLException e){
                    System.out.println(e.getMessage());
                    return false;
                }
        }

        public boolean deleteStudent(int id){
            String sql = "DELETE FROM student WHERE id = ?";
            try(Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    int rowsAffected = preparedStatement.executeUpdate();
                    return rowsAffected>0;
                
            } catch (Exception e) {
                // TODO: handle exception
            return false;

            }
        }
}
