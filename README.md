# 🧑‍💼 HRMS – Human Resource Management System

A simple and functional **Human Resource Management System** built using **Spring Boot**, **PostgreSQL**, and a vanilla **HTML/CSS/JavaScript** frontend. This project supports basic HR operations like employee management, departments, leaves, salaries, and user roles.

---

## 🚀 Features

### 👨‍💼 Employee Management
- Add, update, delete, and list employees
- Stores employee code, name, DOB, contact, address, state, department, and base salary

### 🏢 Department Management
- Create, update, delete departments
- Prevent deletion of departments that have employees

### 📆 Leave Management
- Record leave with full-day or half-day options
- Includes remarks and employee reference

### 🔐 User Management
- Role-based login (`ADMIN`, `USER`)
- Admin can manage system users

### 💰 Salary Report
- Generate salary sheets per month/year
- Calculates leave days, TA, DA, and total salary

### 🌍 State Management
- Lists states for employee address input

---

## ⚙️ Tech Stack
```
| Layer       | Technology           |
|-------------|----------------------|
| Backend     | Spring Boot (Java)   |
| Frontend    | HTML, CSS, JS        |
| Database    | PostgreSQL           |
| ORM         | Spring Data JPA      |
| Build Tool  | Maven                |
```
---

## 📁 Project Structure
```
src/
├── main/
│ ├── java/
│ │ ├── controller/ # REST controllers
│ │ ├── model/ # Entity models
│ │ ├── repository/ # Spring JPA Repos
│ ├── resources/
│ │ ├── static/ # HTML, CSS, JS frontend
│ │ ├── application.properties
├── pom.xml
```
---

## 🛠️ Setup & Run

### 🧩 Prerequisites
- Java 17+
- PostgreSQL
- Maven

### 🔧 Configuration

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hrms_db
spring.datasource.username=your_pg_username
spring.datasource.password=your_pg_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## ▶️ Running the App
# In the project root:
```
mvn spring-boot:run
Open your browser at:
[http://localhost:8080](http://localhost:8080/myapp/)
```

## 🧪 Usage Flow
- Login as admin or user

- Access dashboard features:

- Add/view employees

- Manage departments & leaves

- Generate salary report

- Logout when done

---

## 🖼️ Screenshots

### 🔐 Login Page
<img width="1365" height="767" alt="Login Page" src="https://github.com/user-attachments/assets/a0ab3ba5-af91-41fb-8e50-1a4ab4cb8dc7" />

### 👥 Employees Management
<img width="1348" height="767" alt="Employees Page" src="https://github.com/user-attachments/assets/d69cabbe-191e-4d21-969d-36a77826d685" />

### 🏢 Department Management
<img width="1348" height="767" alt="Department Page" src="https://github.com/user-attachments/assets/58661a6d-c2a6-4ed0-87d2-8944eed94bd1" />

### 💰 Salary Report Generation
<img width="1346" height="766" alt="Salary Report Page" src="https://github.com/user-attachments/assets/2cb9b0fa-dbb6-4e2e-aadc-605ccc5caa23" />

---

🔗 Made with ❤️
