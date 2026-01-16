# Task Management System
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
-----------------------> src/main/java/com/taskmanager/controllers <------------------------------
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
HistoryServlet.java – Displays task history (added/updated/deleted actions) //

--------------------------> src/main/java/com/taskmanager/dao <------------------------------
DBConnection.java – Database connection utility (JDBC + MySQL)
UserDAO.java – User database operations (register/login/forgot/reset)
TaskDAO.java – Task database operations (CRUD + status updates)
TaskHistoryDAO.java – Stores and fetches task history records //
--------------------------> src/main/java/com/taskmanager/model <------------------------------
User.java – User entity (id, name, email, password etc.)
Task.java – Task entity (id, title, description, status, dueDate etc.)
TaskHistory.java – History entity (action, taskId, userId, timestamp etc.) //


---------------------------------------------------------Frontend (JSP)---------------------------------------------------------------------------------------------------------------------------------------------

--------------------------> src/main/webapp/css <------------------------------
app.css – Common UI styling for the application //
-------------------------->   src/main/webapp     <------------------------------
login.jsp – Login page
register.jsp – Registration page
forgotPassword.jsp – Forgot password page
resetPassword.jsp – Reset password page
dashboard.jsp – Main dashboard page
addTask.jsp – Add new task page
editTask.jsp – Edit task page
history.jsp – Task history page //




