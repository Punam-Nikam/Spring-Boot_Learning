# 🔐 Spring Boot JWT Authentication & User Management API

A secure RESTful User Management API built using Java, Spring Boot, Spring Security, JWT, Spring Data JPA, and MySQL.

This project demonstrates the implementation of CRUD operations, database integration, user authentication, password encryption, and JWT token generation while following a layered architecture approach.

---

## 🚀 Features

### 👤 User Management

* Create User
* Read User By ID
* Update User By ID
* Delete User By ID
* Store User Data in MySQL Database

### 🔒 Authentication & Security

* Spring Security Integration
* Custom UserDetailsService
* Database-Based Authentication
* BCrypt Password Encoding
* JWT Token Generation
* Secure Login Endpoint
* Role-Based User Structure

### 🗄️ Database Integration

* MySQL Database
* Spring Data JPA
* Repository Pattern
* Entity Mapping
* Automatic Query Generation

### ⚡ REST API Development

* RESTful Architecture
* Request & Response Handling
* JSON Data Exchange
* Exception Handling
* Layered Application Design

---

## 🛠️ Technologies Used

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* MySQL
* JWT (JSON Web Token)
* Maven
* BCrypt
* REST API

---

## 📂 Project Structure

```text
src/main/java/com/udemy/punam

├── config
│   └── SecurityConfig
│
├── controller
│   ├── AuthenticationController
│   ├── CreateUserController
│   ├── ReadUserById
│   ├── UpdateUserById
│   └── DeleteById
│
├── exceptionHandler
│   └── UserNotFoundException
│
├── model
│   ├── AuthenticationRequest
│   └── User
│
├── repository
│   └── UserRepository
│
├── service
│   └── CustomUserDetailService
│
├── util
│   └── JWTUtil
│
└── PunamApplication
```

---

## 🏗️ Architecture

Client Request
↓
Controller Layer
↓
Service Layer
↓
Repository Layer
↓
MySQL Database

---

## 🔑 Authentication Flow

### User Registration

1. User sends registration request.
2. Password is encrypted using BCrypt.
3. User details are stored in MySQL.
4. User account is created successfully.

### User Login

1. User sends username and password.
2. AuthenticationManager validates credentials.
3. CustomUserDetailService loads user data from database.
4. Password is verified.
5. JWT token is generated.
6. Token is returned to the client.

---

## 📌 API Endpoints

### Create User

POST `/api/users/createUser`

Request Body

```json
{
  "username": "Virat",
  "password": "virat18",
  "email": "virat18@gmail.com",
  "role": "Developer"
}
```

### Authenticate User

POST `/api/authenticate`

Request Body

```json
{
  "username": "Virat",
  "password": "virat18"
}
```

Response

```text
Login Success : JWT_TOKEN
```

### Read User By ID

GET `/api/users/{id}`

### Update User By ID

PUT `/api/users/{id}`

### Delete User By ID

DELETE `/api/users/{id}`

---

## 🔐 Security Implementation

### Password Encryption

Passwords are encrypted using BCrypt before being stored in the database.

```java
user.setPassword(passwordEncoder.encode(user.getPassword()));
```

### Authentication Components

* AuthenticationManager
* DaoAuthenticationProvider
* CustomUserDetailService
* BCryptPasswordEncoder
* SecurityFilterChain

### JWT Authentication

JWT tokens are generated after successful login and can be used to secure APIs and validate user identity.

---

## 📚 Concepts Learned

### Spring Boot

* Spring Boot Fundamentals
* Dependency Injection
* Bean Management
* Layered Architecture

### REST APIs

* GET Requests
* POST Requests
* PUT Requests
* DELETE Requests
* RequestBody Handling
* ResponseEntity

### Spring Data JPA

* Entity Mapping
* Repository Pattern
* Database Operations
* CRUD Implementation

### MySQL

* Database Connectivity
* Data Persistence
* Table Management

### Spring Security

* Authentication
* Authorization
* UserDetailsService
* AuthenticationManager
* Password Encoding

### JWT

* Token Generation
* Authentication Flow
* Secure API Access

### Exception Handling

* Custom Exceptions
* Error Handling
* User Not Found Scenarios

---

## 🎯 Learning Outcomes

Through this project, I gained practical experience in:

* Building RESTful APIs using Spring Boot
* Implementing CRUD operations
* Integrating MySQL with Spring Data JPA
* Securing applications with Spring Security
* Encrypting passwords using BCrypt
* Implementing JWT Authentication
* Managing users and roles
* Designing layered backend architecture
* Handling exceptions effectively

This project significantly strengthened my understanding of backend development and modern Java application security.

---

## 👨‍💻 Author

Punam Nikam

⭐ Feel free to explore the code and provide feedback!
