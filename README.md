            WELCOME TO MY LOGINFORM PROJECT MADE BY HARSHAD MADHAV DHUPPE
                ROLL NO : 3145, PRN NUMBER : 23025331844046
            CSMSS CHH. SHAHU COLLEGE OF ENGINEERING SAMBHAJINAGAR

📌 Student Admission Form – Java + AWT + MySQL

This project is a Java AWT-based Admission Form GUI application that collects student details and stores them in a MySQL database.
The project includes validation features, unique labels, and a confirmation popup after successful submission.

✨ Features

✔ User-friendly GUI form using Java AWT
✔ Stores form data in MySQL database
✔ Confirmation popup after submitting the form
✔ Auto-clears text fields after insertion
✔ Unique fields – Email ID & Programming Skills Known
✔ Code separated into 2 independent Java classes

📂 Project Structure
/Admission-Form-Java
│
├─ DatabaseConnection.java   <-- Handles MySQL connectivity
├─ AdmissionForm.java        <-- GUI form + SQL insert
└─ README.md

🖥 Technologies Used
Component	Technology
Programming Language	Java
GUI Toolkit	AWT (Abstract Window Toolkit)
Database	MySQL
Driver	JDBC Connector
IDE (recommended)	Eclipse / NetBeans / IntelliJ
🔧 Requirements

Before running the project, make sure you have installed:

Software	Status
JDK 17 or above	✔
MySQL Server	✔
JDBC MySQL Connector (mysql-connector-j.jar)	✔
🗄 SQL Setup

Run the following SQL commands in phpMyAdmin / MySQL Workbench:

CREATE DATABASE myform;

USE myform;

CREATE TABLE form (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    middle_name VARCHAR(50),
    last_name VARCHAR(50),
    gender VARCHAR(10),
    address TEXT,
    language VARCHAR(100),
    email VARCHAR(100)
);

🚀 How to Run the Project

Open the project folder in your IDE

Add the MySQL JDBC Connector JAR to the project Build Path

Update DB credentials in DatabaseConnection.java if needed:

URL = "jdbc:mysql://localhost:3306/myform";
USER = "root";
PASSWORD = "#####";


Run the AdmissionForm.java file

Enter details → click Submit


🔮 Future Enhancements

These features can be added in future versions:

🔹 View saved data in a table window
🔹 Export records to PDF / Excel
🔹 Search student by name / ID
🔹 Add login system for admin
🔹 Upload student photo

👨‍💻 Author

Developed by: Harshad Madhav Dhuppe
Feel free to modify and enhance the project ✨

⭐ Support

If you like this project, don’t forget to ⭐ star the repository!
