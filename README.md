# Amiel Microservices Ecosystem

Welcome to the Amiel Microservices Ecosystem project! This repository hosts a collection of Spring Boot microservices designed to handle various business logic and integrate seamlessly in a microservices architecture.

## Services

### 1. Service Registry
- **Description:** Manages service registration and discovery using Netflix Eureka.
- **Endpoint:** [http://localhost:8761](http://localhost:8761)
- **Usage:** Centralized service registration for all microservices.

### 2. API Gateway
- **Description:** Acts as the gateway for all client requests, providing routing, filtering, and more.
- **Endpoint:** [http://localhost:8765](http://localhost:8765)
- **Usage:** Entry point to the microservices ecosystem, handling requests and routing them to appropriate services.

### 3. Config Server
- **Description:** Centralized configuration management using Spring Cloud Config.
- **Endpoint:** [http://localhost:8888](http://localhost:8888)
- **Usage:** Provides externalized configuration to all microservices, promoting consistency and flexibility.

### 4. User Service
- **Description:** Manages user-related operations, such as user registration, authentication, and profile management.
- **Endpoint:** [http://localhost:8081](http://localhost:8081)
- **Usage:** Handles user-specific business logic and interacts with the user database.

### 5. Sample Service
- **Description:** Demonstrates a sample microservice handling generic business logic.
- **Endpoint:** [http://localhost:8086](http://localhost:8086)
- **Usage:** Provides a template for implementing business logic in other microservices.

## Getting Started

To run the Amiel Microservices Ecosystem locally, follow these steps:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/amiel-microservices.git
   cd amiel-microservices
