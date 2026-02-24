# Secure Legacy Modernization (Spring Boot)

A small JVM-based procurement workflow system built to demonstrate **enterprise modernization** and **application security** practices.
The project starts with a clean Spring architecture and is incrementally upgraded with security controls (JWT, RBAC, audit trail, dependency scanning, CI).

## Why this repo exists
I built this project to showcase:
- Spring Boot architecture (controller/service/repository layering)
- Automated testing (integration tests)
- Containerized local environment (PostgreSQL via Docker Compose)
- A realistic modernization path: **from “legacy-ish baseline” to secure, maintainable platform**

## Domain (procurement-like)
Purchase requests go through a simple workflow:
`DRAFT -> SUBMITTED -> APPROVED/REJECTED`

## Day 1 status
✅ Spring Boot 3 / Java 17 / Gradle  
✅ PostgreSQL via docker-compose  
✅ Layered architecture (controller/service/repository)  
✅ DTO validation + safe error responses  
✅ Integration tests (MockMvc)

## Run locally
1) Start Postgres:
```bash
docker compose up -d
```.

This project demonstrates a secure legacy modernization approach for a procurement system. It includes a backend application built with Spring Boot, following best practices for security and architecture. The project is structured to facilitate integration with modern technologies while ensuring the security of legacy components.
## Technologies Used
- Java 17
- Spring Boot
- Gradle
- Docker
- JUnit 5
- Spring Security
- JWT (JSON Web Tokens)
- PostgreSQL
- OWASP Dependency-Check
- SonarQube
- Snyk
- 

## Project Structure

secure-legacy-modernization/
README.md
docs/
architecture.md
threat-model.md
security-review.md
docker-compose.yml
backend/
build.gradle
settings.gradle
gradle.properties
src/main/java/com/example/procuresecure/
ProcureSecureApplication.java
config/
controller/
domain/
dto/
repository/
service/
src/main/resources/
application.yml
src/test/java/com/example/procuresecure/
PurchaseRequestIntegrationTest.java
.gitignore
.env.example
