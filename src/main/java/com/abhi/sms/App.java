package com.abhi.sms;

import java.util.Scanner;

import com.abhi.sms.model.Student;
import com.abhi.sms.service.StudentService;

import java.util.InputMismatchException;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();

        while (true) {
            displayMenu();
            System.out.print("Enter Your Choice :- ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:         // ADD STUDENT IN DATABASE
                    addStudent(scanner, studentService);
                    break;
                case 2:
                    viewStudent(studentService);
                    break;
                case 3:
                    searchStudent(scanner, studentService);
                    break;
                case 4:
                    updateStudent(scanner, studentService);
                    break;
                case 5:
                    deleteStudent(scanner, studentService);
                    break;
                case 6:
                    System.out.println("Exit $ Thank you ");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("invalid input");
                    break;
            }
        }
    }

    private static void displayMenu(){                                   //DISPLAY METHOD
        System.out.println("\n==============================");
        System.out.println(" STUDENT MANAGEMENT SYSTEM");
        System.out.println("==============================");

        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
    }

    private static void printStudent(Student student) {

            System.out.println("-------------------------");
            System.out.println("ID      : " + student.getId());
            System.out.println("Name    : " + student.getName());
            System.out.println("Age     : " + student.getAge());
            System.out.println("Branch  : " + student.getBranch());
            System.out.println("-------------------------");

    }

    private static void addStudent(Scanner scanner,StudentService studentService){      //ADD STUDENT METHOD
                    Student student = readStudentDetails(scanner);
                           
                    System.out.printf("\nYou entered\nName - %s\nAge - %d\nBranch - %s",student.getName(),student.getAge(),student.getBranch());
                    

                    boolean isAdded =  studentService.addStudent(student);

                    if (isAdded) {
                         System.out.println("\nStudent Added Sucessfully");
                    }else{
                     System.out.println("\nStudent Not Added!");
                    }
                    
                    
    }
    private static void viewStudent(StudentService studentService){      //VIEW STUDENT METHOD
            List<Student> students = studentService.getAllStudent();

            if (students.isEmpty()) {
                System.out.println("No Student Found!");
            }else{
                System.out.println("===== Student List =====");
                System.out.printf(
                        "%-5s%-27s%-5s %-10s%n",
                         "ID",
                         "NAME",
                         "AGE",
                         "BRANCH");
                System.out.println("===========================================");
                for(Student student:students){
                     System.out.printf(
                                  "%-6d %-25s %-5d %-10s %n%n",
                                  student.getId(),
                                  student.getName(),
                                  student.getAge(),
                                  student.getBranch() );
                                                        
                }
            }

    }

    private static void searchStudent(Scanner scanner, StudentService studentService){
        System.out.println("Enter student id");

        int id = scanner.nextInt();
        scanner.nextLine();
           
        Student student = studentService.getStudentById(id);

        if (student!=null) {
            printStudent(student);
        }
        else{
            System.out.println("Student not found");
        }
        
            
    }

    private static void updateStudent(Scanner scanner,StudentService studentService){
        System.out.println("Enter student id you want to Update");

        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = studentService.getStudentById(id);

        if (student!=null) {
            System.out.println(" CURRENT STUDENT DETAILS ");
            printStudent(student);
            student.setId(id);
            student = readStudentDetails(scanner);
            student.setName(student.getName());
            
            student.setAge(student.getAge());
            
            student.setBranch(student.getBranch() );
            boolean update = studentService.updateStudent(student);

            if (update) {
                    System.out.println("UPDATED SUCCESSFULLY");      
            }
            else{
                System.out.println("Some error occured in updation");
            }

        }
        else{
            System.out.println("Student not found");
        }

    }

    private static void deleteStudent(Scanner scanner,StudentService studentService){
                System.out.println("Enter student id you want to delete");

                int id = scanner.nextInt();
                scanner.nextLine();

                Student student = studentService.getStudentById(id);
                if (student!=null) {
                    System.out.println("Student details :-");
                    printStudent(student);
                    
                    System.out.println("Are sure, you want to remove the student.....Y/N");
                    String choice = scanner.nextLine().trim();
                 
                    if ("Y".equalsIgnoreCase(choice)) {
                        boolean result = studentService.deleteStudent(id);
                        if (result) {
                            System.out.println("DELETED SUCCESSFULLY");
                        }else{
                            System.out.println("some error occured in deletion");
                             }
                    }else{
                        System.out.println("Choose Correct Option and try again");
                         }
                }else{
                    System.out.println("Student Details not found");

                }
                
    }

    private static Student readStudentDetails(Scanner scanner){
             int age;
             System.out.print("Enter Name: ");
             String name = scanner.nextLine();
             
             while (true) {
                try {
                    System.out.print("Enter Age: ");
                    age = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    // TODO: handle exception
                    System.out.println("plzz Enter Valid Age....");
                }
                
             }
             

             System.out.print("Enter Branch: ");
             String branch = scanner.nextLine();
             return new Student(name,age,branch);
    }
}