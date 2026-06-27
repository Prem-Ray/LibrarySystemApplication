# 📚 Library Management System

A RESTful Library Management System built with **Spring Boot**, **Spring Data JPA**, and **H2 Database**. This project demonstrates CRUD operations, entity relationships, DTO mapping, custom JPQL queries, exception handling, and REST API development following clean architecture principles.

---

## 🚀 Features

- 👤 Manage Authors
  - Create Author
  - Update Author
  - Delete Author
  - Get Author by ID
  - Get Author by Name
  - Get All Authors

- 📖 Manage Books
  - Publish Book
  - Update Book
  - Delete Book
  - Get Book by ID
  - Get Book by Title
  - Get All Books
  - Find Books Published After a Given Date

- 🔗 One-to-Many Relationship
  - One Author can have multiple Books
  - Each Book belongs to one Author

- 🔄 DTO Mapping using ModelMapper

- ⚡ Custom JPQL Queries

- ❌ Exception Handling

- 🗄️ H2 In-Memory Database

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- ModelMapper
- Maven
- Lombok

---

## 📂 Project Structure

```
src
├── controller
├── dto
├── entity
├── mapper
├── repository
├── service
└── resources
```

---

## 🗃️ Entity Relationship

```
Author
-------
id
name
email

        1
Author -----------< Book
                  *

Book
-------
id
name
publishedDate
author
```

---

## 📌 API Endpoints

### Author APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/authors` | Get all authors |
| GET | `/authors/{id}` | Get author by ID |
| GET | `/authors/name/{name}` | Get author by name |
| POST | `/authors` | Create author |
| PUT | `/authors/{id}` | Update author |
| DELETE | `/authors/{id}` | Delete author |

---

### Book APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/books` | Get all books |
| GET | `/books/{id}` | Get book by ID |
| GET | `/books/title?title=Clean Code` | Get book by title |
| GET | `/books/after-date?date=2024-01-01` | Books after date |
| POST | `/books` | Publish book |
| PUT | `/books/{id}` | Update book |
| DELETE | `/books/{id}` | Delete book |

---

## 📥 Sample Request

### Create Author

```json
{
  "name": "Robert C. Martin",
  "email": "unclebob@example.com"
}
```

### Create Book

```json
{
  "name": "Clean Code",
  "publishedDate": "2008-08-01",
  "authorId": 1
}
```

---

## ⚙️ Running the Project

### Clone the repository

```bash
git clone https://github.com/Prem-Ray/LibrarySystemApplication.git
```

### Navigate to the project

```bash
cd LibrarySystemApplication
```

### Build

```bash
mvn clean install
```

### Run

```bash
mvn spring-boot:run
```

---

## 🗄️ H2 Database

Open:

```
http://localhost:8081/h2-console
```

Use:

```
JDBC URL:
jdbc:h2:mem:librarydb

Username:
sa

Password:
```

---

## 📚 Learning Outcomes

This project helped me understand:

- Spring Boot REST APIs
- Spring Data JPA
- Entity Relationships
- DTO Pattern
- ModelMapper
- JPQL & Custom Queries
- Exception Handling
- CRUD Operations
- Clean Layered Architecture

---

## 👨‍💻 Author

**Premanshu Ray**

GitHub: https://github.com/Prem-Ray

---

## ⭐ If you found this project useful, consider giving it a star!
