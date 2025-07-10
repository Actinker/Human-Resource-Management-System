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
http://localhost:8080/login.html
```
## 📦 API Endpoints
- Entity	Base URL
- Employees	/api/employees
- Departments	/api/departments
- Leaves	/api/leaves
- Users	/api/users
- States	/api/states
- Salaries	/api/salary-report

Use fetch() in JS to interact with these APIs for CRUD operations.

## 🧪 Usage Flow
- Login as admin or user

- Access dashboard features:

- Add/view employees

- Manage departments & leaves

- Generate salary report

- Logout when done

---

🔗 Made with ❤️
