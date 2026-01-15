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
id – int, primary key, auto-increment

name – varchar(100)

email – varchar(100), unique

password – varchar(255)

### Tasks Table
Tasks Table

id – int, primary key, auto-increment

title – varchar(255)

description – text

status – varchar(20)

Pending

Completed

Cancelled

user_id – int, foreign key (Users.id)
## Task History
Task History Table

id – int, primary key, auto-increment

task_id – int

user_id – int

action – varchar(20)

CREATED

UPDATED

DELETED

STATUS_CHANGED

title – varchar(255)

action_time – timestamp (default: current time)

## Authentication and Security
- Session management using HttpSession
- User-specific task access control
- Password handling with validation (hashing recommended)
- Prevention of unauthorized access to application resources
## Project Structure
-------> src/com/taskmanager/controller <-------

LoginServlet.java – Handles user login

RegisterServlet.java – Handles user registration

ForgotPasswordServlet.java – Password reset logic

TaskServlet.java – Task CRUD operations

LogoutServlet.java – Session termination

---------->src/com/taskmanager/dao<---------

UserDAO.java – User database operations

TaskDAO.java – Task database operations

HistoryDAO.java – Task history persistence

------------> src/com/taskmanager/model <------

User.java – User entity

Task.java – Task entity

TaskHistory.java – Task history entity

-------> src/com/taskmanager/util <------------

DBConnection.java – Database connection utility


------> Frontend (JSP) <-------------

WebContent/css – Application stylesheets

WebContent/js – Client-side scripts

login.jsp – User login page

register.jsp – User registration page

forgotPassword.jsp – Password recovery page

dashboard.jsp – Task management dashboard

history.jsp – Task history view




