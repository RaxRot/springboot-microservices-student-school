# 🏗️ Microservices Example (Spring Boot + Spring Cloud)

This project demonstrates a simple **microservices architecture** using Spring Boot and Spring Cloud.

## 🔹 Services

- **Config Server (8888)**  
  Centralized configuration for all microservices.

- **Discovery Server (8761)**  
  Eureka service registry for service discovery.

- **Student Service (8090)**
    - Manages student data in PostgreSQL (`students` database).
    - Endpoints:
        - `GET /api/v1/students` → list all students
        - `GET /api/v1/students/school/{id}` → list students by school
        - `POST /api/v1/students` → create a new student

- **School Service (8070)**
    - Manages school data.
    - Uses **Feign Client** to call Student Service.
    - Endpoints:
        - `GET /api/v1/schools` → list all schools
        - `GET /api/v1/schools/with-students/{id}` → school with students

- **API Gateway (8222)**
    - Single entry point for all clients.
    - Routes requests to the proper microservice via Eureka.
    - Routes:
        - `/api/v1/students/**` → Student Service
        - `/api/v1/schools/**` → School Service

## 🔹 How It Works
1. All services fetch their config from **Config Server**.
2. Services register in **Eureka Discovery**.
3. Clients send requests through **API Gateway (8222)**.
4. Gateway forwards requests to the correct service.
5. School Service fetches students from Student Service via Feign.

## 🔹 Example Requests
- `GET http://localhost:8222/api/v1/students`
- `GET http://localhost:8222/api/v1/students/school/1`
- `GET http://localhost:8222/api/v1/schools`
- `GET http://localhost:8222/api/v1/schools/with-students/1`

---
