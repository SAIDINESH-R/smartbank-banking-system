# SmartBank – Modular Banking System

SmartBank is a secure and modular banking backend system built using Java and Spring Boot. It simulates essential banking operations including account creation, balance inquiries, deposits, and withdrawals. The application exposes RESTful APIs protected by Spring Security and stores data persistently in a PostgreSQL database. The system is containerized using Docker to ensure consistent deployment and easy local development.

SmartBank demonstrates best practices in backend development, including layered architecture (Controller, Service, Repository), exception handling, security, and integration with a relational database. It is designed to be easily extensible for future additions such as user roles, transaction logging, or microservice architecture.

---

## Technology Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security (Basic Authentication)
- PostgreSQL
- Docker & Docker Compose
- Maven
- JUnit & Mockito (for testing)

---

## Key Features

- RESTful APIs for managing bank accounts
- Account creation with initial balance setup
- Secure deposit and withdrawal operations with validation
- Retrieve individual or all account details
- Protected endpoints using Spring Security (Basic Authentication)
- Configuration and deployment using Docker Compose

---

## Getting Started

### Prerequisites

- Java 17+
- Maven
- Docker & Docker Compose
- PostgreSQL (if not using Docker)

### Clone the Repository

Clone the project to your local machine:

```bash
git clone https://github.com/SAIDINESH-R/smartbank-banking-system.git
cd smartbank-banking-system


# Available API Endpoints

HTTP_METHOD   ENDPOINT                         DESCRIPTION
----------   ------------------------------- ------------------------------------
GET          /api/accounts                    Get all accounts
GET          /api/accounts/{id}               Get account by ID
POST         /api/accounts                    Create a new account
POST         /api/accounts/{acc}/deposit     Deposit to an account
POST         /api/accounts/{acc}/withdraw    Withdraw from an account
DELETE       /api/accounts/{id}              Delete an account by ID



## Project Structure

```bash
smartbank-banking-system/
├── src/
│   ├── main/
│   │   ├── java/com/saidinesh/smartbank/
│   │   │   ├── controller/         # REST API Controllers
│   │   │   ├── service/            # Business Logic Layer
│   │   │   ├── model/              # Entity Models
│   │   │   ├── repository/         # Spring Data JPA Repositories
│   │   │   └── config/             # Security Configuration
│   └── resources/
│       └── application.properties  # App configuration
├── docker-compose.yml              # Docker setup
├── pom.xml                         # Maven project configuration
└── README.md                       # Project documentation
