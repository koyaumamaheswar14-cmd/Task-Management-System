# Personal Task Management System
A full-stack web application that allows users to securely register, log in, reset passwords, and manage their personal tasks.  
This project was developed as part of a **Full Stack Developer Intern – Technical Assignment**
## Project Overview
The Personal Task Management System is a web-based application designed to help users manage their daily tasks efficiently.  
The system ensures data privacy through session-based authentication and allows users to perform task-related operations in a secure environment.
## Features
### Authentication
- User registration
- User login
- Forgot password functionality
- Session-based authentication
- Restricted access for unauthenticated users
### Task Management (CRUD)
- Create new tasks
- View all tasks
- Edit existing tasks
- Delete tasks
### Additional Enhancements
- Task status support (Pending, Completed, Cancelled)
- Task filtering based on status
- Past Operations On Tasks(History)
- Input validation and error handling
- Clean and responsive user interface
## Tech Stack
### Frontend
- HTML5
- CSS3
- JavaScript
- JSP 
### Backend
- Java
- Java Servlets
- JDBC
### Database
- MySQL
### Server
- Apache Tomcat (Version 11.0)
## Database Schema
### Users Table
+----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| id       | int          | NO   | PRI | NULL    | auto_increment |
| name     | varchar(100) | YES  |     | NULL    |                |
| email    | varchar(100) | YES  | UNI | NULL    |                |
| password | varchar(255) | YES  |     | NULL    |                |
+----------+--------------+------+-----+---------+----------------+
### Tasks Table
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | int          | NO   | PRI | NULL    | auto_increment |
| title       | varchar(255) | YES  |     | NULL    |                |
| description | text         | YES  |     | NULL    |                |
| status      | varchar(20)  | YES  |     | NULL    |                |
| user_id     | int          | YES  | MUL | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
## Task History
+-------------+--------------+------+-----+-------------------+-------------------+
| Field       | Type         | Null | Key | Default           | Extra             |
+-------------+--------------+------+-----+-------------------+-------------------+
| id          | int          | NO   | PRI | NULL              | auto_increment    |
| task_id     | int          | YES  |     | NULL              |                   |
| user_id     | int          | YES  |     | NULL              |                   |
| action      | varchar(20)  | YES  |     | NULL              |                   |
| title       | varchar(255) | YES  |     | NULL              |                   |
| action_time | timestamp    | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
+-------------+--------------+------+-----+-------------------+-------------------+
## Authentication and Security
- Session management using HttpSession
- User-specific task access control
- Password handling with validation (hashing recommended)
- Prevention of unauthorized access to application resources
## Project Structure
Task-Management-System/
│
├── src/
│   ├── com.taskmanager.controller
│   │   ├── LoginServlet.java
│   │   ├── RegisterServlet.java
│   │   ├── ForgotPasswordServlet.java
│   │   ├── TaskServlet.java
│   │   └── LogoutServlet.java
│   │
│   ├── com.taskmanager.dao
│   │   ├── UserDAO.java
│   │   ├── TaskDAO.java
│   │   └── HistoryDAO.java
│   │
│   ├── com.taskmanager.model
│   │   ├── User.java
│   │   ├── Task.java
│   │   └── TaskHistory.java
│   │
│   └── com.taskmanager.util
│       └── DBConnection.java
│
├── WebContent/
│   ├── css/
│   ├── js/
│   ├── login.jsp
│   ├── register.jsp
│   ├── forgotPassword.jsp
│   ├── dashboard.jsp
│   └── history.jsp
│
├── database/
│   └── task_management.sql
│
├── README.md




