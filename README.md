# Student Management System

## Description
A console-based Student Management System developed using Java, PostgreSQL, JDBC, and Maven.

This application demonstrates CRUD operations, layered architecture (Model, DAO, Service, Utility), and database connectivity using JDBC.

## Features

- Add Student
- View All Students
- Search Student by ID
- Update Student Details
- Delete Student
- Input Validation
- PostgreSQL Database Integration

## Technologies Used

- Java 25
- PostgreSQL 18
- JDBC
- Maven
- Git
- GitHub
- Visual Studio Code

## Project Structure

src
└── main
    └── java
        └── com
            └── abhi
                └── sms
                    ├── model
                    ├── dao
                    ├── service
                    ├── util
                    └── App.java
    
## Database Schema

Student

| Column | Type |
|--------|------|
| id | SERIAL |
| name | VARCHAR |
| age | INTEGER |
| branch | VARCHAR |

## Installation

1. Clone the repository

2. Create a PostgreSQL database named `studentdb`

3. Update database credentials in `DBConnection.java`

4. Run:

```bash
mvn compile


This lets someone else run your project.

---

# Section 8: Future Improvements

This is something many students forget.

Example:

```md
## Future Improvements

- Login System
- Spring Boot REST API
- JavaFX GUI
- Export to CSV
- Unit Testing with JUnit

## Author

Abhishek

GitHub:
https://github.com/y75997108-hash