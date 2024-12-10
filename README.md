# QR-Code-Generator  

QR-Code-Generator is a web application designed to generate QR codes for student information. This project uses modern backend technologies to ensure efficient and reliable functionality.  

---

## 🚀 Features  
- **QR Code Generation:** Generate QR codes for students' data.  
- **Data Storage:** Store student details securely in a PostgreSQL database.  
- **Simple and Efficient Design:** Built for ease of use and performance.  

---

## 🛠️ Technologies Used  

### Backend  
- **Spring Boot Framework**  
- **Spring Data JPA**: Simplifies database interactions using ORM.  
- **Zxing Library**: For generating QR codes.  

### Database  
- **PostgreSQL**: Reliable and powerful relational database management system.  

---

## 🗂️ Data Model  

- **Student:** Represents student details to be encoded into QR codes.  

  **Attributes:**  
  - `id`: Unique identifier for each student.  
  - `name`: The name of the student.  
  - `email`: The email address of the student.  
  - `phone`: Contact number of the student.  
  - `address`: The address of the student.  

---

## 📖 Setup  

### 1. Prerequisites  
- Java 17 or higher  
- Maven or Gradle  
- PostgreSQL  

### 2. Clone the Repository  
```bash
git clone https://github.com/username/qr-code-generator.git
cd qr-code-generator
