

# 📝 Registration Form using Core Java, AWT & MySQL

This is a beginner-friendly project developed using **Core Java and AWT GUI**.  
It is a simple form where the user enters personal details and clicks **Submit**.  
All the form data is stored securely inside a **MySQL database**.

---

## 🚀 Features
✔ Simple and clean registration form  
✔ Google-form style input fields  
✔ Gender selection (Male / Female / Other)  
✔ Data stored in MySQL using JDBC  
✔ Only two Java files — easy to understand for beginners  

---

## 📂 Project Structure
src/
└── loginForm/
├── LoginForm.java
└── DatabaseConnection.java


---

## 🛠️ Technologies Used
| Component | Technology |
|----------|-------------|
| Programming Language | Core Java |
| GUI Library | AWT |
| Database | MySQL |
| Driver | JDBC MySQL Connector |

---

## 🔧 MySQL Database Setup
Run the below SQL commands before running the program:

```sql
CREATE DATABASE formdb;
USE simpleformdb;

CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(50),
    middlename VARCHAR(50),
    lastname VARCHAR(50),
    gender VARCHAR(20),
    age INT,
    address VARCHAR(200)
);
