# 🏛 User Management System – Java Servlet Web Application

This is a **User Management System** implemented as a **Dynamic Web Project in Eclipse** (non-Maven).  
It allows users to **Create, Read, Update, and Delete (CRUD)** records using **Java Servlets** for backend logic and **HTML/CSS/JavaScript** for frontend UI.  
The application uses **Aiven MySQL** for database persistence.

---

## 🌐 Live / Local Backend URL

If running locally with Tomcat:


http://localhost:8080/crudBackend


---

## 🚀 Features

- 👤 Create new users with Name, Email, and Age  
- 🔄 Update existing users by ID  
- 📍 View user details by ID  
- 🗑 Delete users by ID  
- ⚡ Simple interactive UI with HTML/CSS/JS  
- 🌐 Database persistence using MySQL  

---

## 🛠️ Tech Stack

### Frontend
- HTML5  
- CSS3  
- JavaScript (ES6)  
- Fetch API for server requests  

### Backend
- Java Servlets (Jakarta EE)  
- Service + Controller design  
- JDBC for MySQL database connectivity  

### Database
- **Aiven MySQL** – Cloud-hosted database  

### Server / IDE
- Apache Tomcat 10.1  
- Eclipse IDE  
- Dynamic Web Project (Non-Maven)

---

## ⚙️ Local Setup

1️⃣ **Clone the repository**  
```bash
git clone https://github.com/Ashwani5977/user-management-system.git
cd user-management-system

2️⃣ Import project into Eclipse

File → Import → Existing Dynamic Web Project

Select the user-management-system folder

Set Target Runtime = Apache Tomcat 10.1

3️⃣ Configure Database
Update database credentials in UserService.java (or DB util class):

private static final String DB_URL = "jdbc:mysql://<aiven-host>:<port>/<database>";
private static final String DB_USER = "<username>";
private static final String DB_PASSWORD = "<password>";

4️⃣ Run the project

Right-click → Run As → Run on Server

Open browser: http://localhost:8080/crudBackend/index.html

📂 Project Structure
crudBackend/
├── WebContent/
│   ├── index.html       # Frontend UI
│   ├── style.css        # CSS Styling
│   └── function.js      # JavaScript for CRUD
├── src/
│   └── com/
│       ├── controller/
│       │   └── UserApiServlet.java
│       ├── dto/
│       │   └── UserDTO.java
│       └── service/
│           └── UserService.java
└── WEB-INF/
    ├── web.xml          # Servlet configuration
    └── lib/             # External libraries if any
🎯 Project Objective

To build a simple CRUD web application demonstrating:

Java Servlets for backend processing

MySQL database for persistence

Plain HTML/CSS/JS frontend for user interaction

Separation of concerns using DTO and Service pattern

🔮 Future Enhancements

Add user authentication

Improve UI with responsive design

Input validation and error handling

Convert to Maven/Spring Boot project for scalability
