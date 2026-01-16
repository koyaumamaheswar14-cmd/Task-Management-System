# Task Management System
A full-stack web application that allows users to securely register, log in, reset passwords, and manage their personal tasks.  
This project was developed as part of a **Full Stack Developer Intern – Technical Assignment**
## Project Overview
The Task Management System is a web-based application designed to help users manage their daily tasks efficiently.  
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


1) Users Table (users)

id INT PRIMARY KEY AUTO_INCREMENT

name VARCHAR(100) NOT NULL

email VARCHAR(100) UNIQUE NOT NULL

password VARCHAR(255) NOT NULL


2) Tasks Table (tasks)

id INT PRIMARY KEY AUTO_INCREMENT

title VARCHAR(255) NOT NULL

description TEXT

status VARCHAR(20) NOT NULL

Values: Pending, Completed, Cancelled

user_id INT NOT NULL (Foreign Key → users.id)


3) Task History Table (task_history)

id INT PRIMARY KEY AUTO_INCREMENT

task_id INT NOT NULL

user_id INT NOT NULL

action VARCHAR(20) NOT NULL

Values: CREATED, UPDATED, DELETED, STATUS_CHANGED

title VARCHAR(255) NOT NULL

action_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP

## Authentication and Security
- Session management using HttpSession
- User-specific task access control
- Password validation implemented (hashing can be added for production)
- Prevention of unauthorized access to application resources
## Project Structure
//--- src/main/java/com/taskmanager/controllers --->
LoginServlet.java – Handles user login authentication

RegisterServlet.java – Handles new user registration

ForgotPasswordServlet.java – Handles forgot password validation (email/username check)

ResetPasswordServlet.java – Updates user password securely

LogoutServlet.java – Ends session and logs out user

DashboardServlet.java – Loads dashboard data for logged-in users

TaskListServlet.java – Displays all tasks of the user

ViewTaskServlet.java – View a single task details

AddTaskServlet.java – Adds new task

EditTaskServlet.java – Loads task data into edit form

UpdateTaskServlet.java – Updates existing task

DeleteTaskServlet.java – Deletes a task

HistoryServlet.java – Displays task history (added/updated/deleted actions)

//


//---src/main/java/com/taskmanager/dao ------>

DBConnection.java – Database connection utility (JDBC + MySQL)

UserDAO.java – User database operations (register/login/forgot/reset)

TaskDAO.java – Task database operations (CRUD + status updates)

TaskHistoryDAO.java – Stores and fetches task history records

//


//---src/main/java/com/taskmanager/model ---->

User.java – User entity (id, name, email, password etc.)

Task.java – Task entity (id, title, description, status, dueDate etc.)

TaskHistory.java – History entity (action, taskId, userId, timestamp etc.) 

//


Frontend (JSP)
______________________________________________________________________________________________________________________________________________________


//---src/main/webapp/css -->

app.css – Common UI styling for the application

//

//---src/main/webapp-->

login.jsp – Login page

register.jsp – Registration page

forgotPassword.jsp – Forgot password page

resetPassword.jsp – Reset password page

dashboard.jsp – Main dashboard page

addTask.jsp – Add new task page

editTask.jsp – Edit task page

history.jsp – Task history page 

//


How to Run the Project Locally
__________________________________________________________________________________________________________________________________________________________________

Prerequisites :-

Java (JDK 17+ recommended)

Eclipse IDE (Enterprise Java / EE)

Apache Tomcat (Version 11.0)

MySQL Server

MySQL Connector/J (JDBC Driver)

Step 1: Clone the Repository


git clone <your-github-repo-url>

Step 2: Import Project into Eclipse


Open Eclipse

Go to File → Import

Select Existing Projects into Workspace

Choose the project folder and click Finish

Step 3: Create Database in MySQL


CREATE DATABASE taskmanager_db;

Step 4: Create Tables


Run the SQL queries for:

users

tasks

task_history

Step 5: Configure Database Connection


Open:

src/main/java/com/taskmanager/dao/DBConnection.java

Update your MySQL credentials:

String url = "jdbc:mysql://localhost:3306/taskmanager_db";
String user = "root";
String password = "your_password";

Step 6: Add MySQL JDBC Driver


Download MySQL Connector/J

In Eclipse:-

Right click project → Build Path → Configure Build Path

Go to Libraries

Click Add External JARs

Select the MySQL connector .jar file

Step 7: Configure Apache Tomcat in Eclipse


Go to Window → Preferences → Server → Runtime Environments

Click Add

Select Apache Tomcat

Browse your Tomcat installation folder and finish setup

Step 8: Run the Application


Right click project → Run As → Run on Server

Select Tomcat Server

Start the server

Step 9: Open in Browser


http://localhost:8080/TaskManagementSystem/

Testing Flow
_______________________________________________________________________________________________________________________________________________________________

1)Register a new user

2)Login using registered credentials

3)Add tasks

4)Update/Edit/Delete tasks

5)View task history



