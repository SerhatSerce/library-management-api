# Library Management API (Spring Boot)

A **RESTful Library Management API** built with **Java, Spring Boot and PostgreSQL**.  
This project demonstrates a clean backend design using **layered architecture**, **DTO pattern**, **validation**, and **global exception handling**.

---

# Features

- Create, read, update and delete books (CRUD)
- DTO-based request/response structure
- Input validation with Hibernate Validator
- Global exception handling
- Clean layered architecture (Controller → Service → Repository)

---

# Architecture

The project follows a layered architecture:

Controller → Service → Repository → Entity → Database

- **Controller Layer**: Handles HTTP requests and API endpoints
- **Service Layer**: Contains business logic
- **Repository Layer**: Handles database operations via Spring Data JPA
- **Entity Layer**: Represents database tables
- **DTO Layer**: Separates API models from database models
- **Exception Handling**: Centralized error handling using `@RestControllerAdvice`

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
│   ├── BookRequest.java
│   └── BookResponse.java
│
├── exception
│   ├── BookNotFoundException.java
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
- Lombok

---

# Base URL

```
http://localhost:8080
```

---

# API Endpoints

| Method | Endpoint | Description |
|--------|---------|------------|
| GET    | `/books`       | List all books |
| GET    | `/books/{id}`  | Get book by ID |
| POST   | `/books`       | Create a new book |
| PUT    | `/books/{id}`  | Update a book |
| DELETE | `/books/{id}`  | Delete a book |

---

# Example Request

POST `/books`

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin"
}
```

---

# Example Response

```json
{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin"
}
```

---

# Database

- **Database**: PostgreSQL
- **Database Name**: `library_db`
- **Table**: `books`

---

# How to Run

1. Clone the repository

```
git clone https://github.com/SerhatSerce/library-management-api.git
```

2. Open in IntelliJ IDEA

3. Configure PostgreSQL in `application.properties`

4. Run:

```
LibraryManagementApiApplication.java
```

---

# Learning Outcomes

- Building REST APIs with Spring Boot
- Applying layered architecture
- Using DTO for clean API design
- Implementing validation and exception handling
- Integrating PostgreSQL with Spring Data JPA