# Library Management API (Spring Boot)

A simple **Library Management REST API** built with **Java, Spring Boot and PostgreSQL**.  
This project demonstrates how a backend application can be structured using **layered architecture** with clear separation between **Controller, Service, Repository and Entity layers**.

---

# Features

- Add book
- List all books
- Update book
- Delete book
- DTO based request structure
- Input validation
- Global exception handling
- Layered architecture (Controller → Service → Repository)

---

# Architecture

The project follows a simplified layered architecture:

Controller → Service → Repository → Entity → Database

**Controller Layer**  
Handles HTTP requests and exposes REST API endpoints.

**Service Layer**  
Contains the business logic of the application.

**Repository Layer**  
Responsible for database operations using Spring Data JPA.

**Entity Layer**  
Represents database tables.

**DTO Layer**  
Used to transfer request data and prevent exposing entity objects directly.

**Exception Handling**  
The project uses a **GlobalExceptionHandler** to provide consistent error responses for the API.  
Common exceptions such as validation errors or resource not found errors are handled globally.

**Database**  
PostgreSQL database storing book records.

---

# Project Structure

```
com.serhat.library
│
├── controller
│   └── BookController.java
│
├── service
│   └── BookService.java
│
├── repository
│   └── BookRepository.java
│
├── entity
│   └── Book.java
│
├── dto
│   └── BookRequest.java
│
├── exception
│   └── GlobalExceptionHandler.java
│
└── LibraryManagementApiApplication.java
```

---

# Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- IntelliJ IDEA

---

# Base URL

All API endpoints are served under:

```
http://localhost:8080
```

---

# API Endpoints

| Method | Endpoint | Description |
|------|------|------|
| GET | `/books` | List all books |
| POST | `/books` | Add a new book |
| PUT | `/books/{id}` | Update a book |
| DELETE | `/books/{id}` | Delete a book |

---

# Example Request

POST `/books`

Content-Type: application/json

```
{
  "title": "Clean Code",
  "author": "Robert Martin"
}
```

---

# Example Response

```
[
  {
    "id": 1,
    "title": "Clean Code",
    "author": "Robert Martin"
  }
]
```

---

# Database

This project uses **PostgreSQL** as the relational database.

Database name:

```
library_db
```

Table:

```
books
```

---

# API Testing

The API was tested using:

- Postman

---

# How to Run

1. Clone the repository

```
git clone https://github.com/SerhatSerce/library-management-api.git
```

2. Open the project in **IntelliJ IDEA**

3. Configure your **PostgreSQL database connection** in `application.properties`

4. Run the application

```
LibraryManagementApiApplication.java
```

Application will start at:

```
http://localhost:8080
```

---

# Learning Goals

This project was created to practice:

- Spring Boot backend development
- REST API design
- Layered architecture
- Spring Data JPA
- PostgreSQL integration
- DTO usage
- Input validation
- Exception handling
