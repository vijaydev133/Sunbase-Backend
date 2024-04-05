# Sunbase Assignment - Backend
Sunbase Assignment that contains backend code

# Tech Stack Used
- Spring Boot
- Java
- JWT Authentication
- SQL (Database: customerdb)

# How to Run the Application
- Clone this repository.
- Open the project in your preferred IDE (Integrated Development Environment).

# Set up the database:
- Make sure MySQL is installed.<br/>
- Update application.properties with your MySQL credentials and database details.<br/>
# SQL query
- make sure to run the below sql query inside the mysql workbench<br/>
create database customerdb; <br/>
create table admindetails( <br/>
	uname varchar(50),<br/>
    upassword varchar(50)<br/>
);<br/>
insert into customerdb.admin_details(uname,upassword) value(1)?, 2)?);<br/>
(instead of 1st question mark add your username, and for second add your password)<br/>


# Start the Application
- Run the AssignmentApplication.java file to start the Spring Boot application.

The backend server should start running, and you should see the application logs in the IDE console.

# Frontend Repository
- Now follow the steps in this repository <br/>
https://github.com/vijaydev133/Sunbase-frontend.git



