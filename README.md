# url-sh 🚀

A high-performance, minimalist URL shortener built with **Spring Boot 4.0**, **Java 21**, and **PostgreSQL**. This application uses a custom **Base62 encoding** algorithm to generate short, clean identifiers for long URLs.

---

## ✨ Features

- **Base62 Encoding:** Efficiently converts database IDs into compact short codes
- **Instant Redirection:** Performs `HTTP 302` redirects to the original destination
- **RESTful Architecture:** Clean separation of concerns with Controller-Service-Repository patterns
- **Production Ready:** Fully decoupled configuration using environment variables for secure deployment

---

## 🛠️ Technology Stack

- **Backend:** Java 21, Spring Boot 4.0.1
- **Persistence:** Spring Data JPA, Hibernate
- **Database:** PostgreSQL
- **Build Tool:** Maven
- **Frontend:** HTML5, CSS3 (Glassmorphism UI), JavaScript (Fetch API)

---

## 🔌 API Documentation

### 1. Create a Short URL

**Endpoint:** `POST /shorten`  
**Content-Type:** `application/json`

**Request Body:**

```json
{
  "originalURL": "https://www.ssn.edu.in"
}
```

**Successful Response:**

```json
{
  "shortURL": "3",
  "OriginalURL": "https://www.ssn.edu.in",
  "createdAt": "2025-12-25 12:29:39"
}
```

### 2. Redirect to Original

**Endpoint:** `GET /{shortCode}`  
**Description:** Takes the short code and performs an immediate browser redirect.

**Example:**  
`http://localhost:8080/3` → Redirects to `https://www.ssn.edu.in`

---

## 🚀 Local Setup & Installation

### 1. Clone the Repository

```bash
git clone https://github.com/Shivaprakash-NP/url-sh.git
cd url-sh
```

### 2. Configure Environment Variables

The application is configured to use environment variables to protect your database credentials. Set these in your terminal (Arch Linux/Linux/macOS):

```bash
export DB_URL=jdbc:postgresql://localhost:5432/your_db_name
export DB_USER=your_postgres_username
export DB_PASSWORD=your_postgres_password
```

**For Windows (Command Prompt):**

```cmd
set DB_URL=jdbc:postgresql://localhost:5432/your_db_name
set DB_USER=your_postgres_username
set DB_PASSWORD=your_postgres_password
```

**For Windows (PowerShell):**

```powershell
$env:DB_URL="jdbc:postgresql://localhost:5432/your_db_name"
$env:DB_USER="your_postgres_username"
$env:DB_PASSWORD="your_postgres_password"
```

### 3. Build and Run

```bash
./mvnw clean spring-boot:run
```

---

## 📦 Deployment Configuration

In `src/main/resources/application.properties`, the app uses the following configuration to remain cloud-agnostic:

```properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
```

When deploying to platforms like **Render**, **Railway**, or **AWS**, simply add `DB_URL`, `DB_USER`, and `DB_PASSWORD` as Environment Variables in your service dashboard.

---

## 🎯 Usage Example

### Create a Short URL

```bash
curl -X POST http://localhost:8080/shorten \
  -H "Content-Type: application/json" \
  -d '{"originalURL": "https://www.ssn.edu.in"}'
```

### Access the Short URL

Simply visit `http://localhost:8080/3` in your browser, and you'll be redirected to the original URL.

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

---

## 📄 License

This project is licensed under the MIT License.

---

## 👨‍💻 Author

**Shivaprakash N P**  
Computer Science & Engineering Student

[![GitHub](https://img.shields.io/badge/GitHub-Shivaprakash--NP-blue?style=flat&logo=github)](https://github.com/Shivaprakash-NP)

---

## 🌟 Show Your Support

Give a ⭐️ if this project helped you!

---

**Made with ❤️ using Spring Boot and Java 21**
