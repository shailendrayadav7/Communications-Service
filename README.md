# Project Case Study: Communications Service Provider REST APIs with Cucumber Testing and CI/CD

## Project Overview
In this project, I tackled the challenge of developing a suite of REST APIs for a communications service provider. These APIs manage the provider's catalog, consumer and enterprise customer orders, service provisioning, and enterprise customer information. The core technologies employed include Spring Boot for API development, Cucumber for behavior-driven testing with Selenium, and a robust CI/CD pipeline for automated build, test, and deployment.

## APIs Developed
1. **Catalog API**:
   - Endpoints: `GET /api/catalog`, `POST /api/catalog`, `PUT /api/catalog/{id}`, `DELETE /api/catalog/{id}`
   - Description: Seamlessly manage products, plans, and features within the service catalog.

2. **Ordering API for Consumer Customers**:
   - Endpoints: `POST /api/consumer/customers/{customerId}/orders`, `PUT /api/consumer/customers/{customerId}/orders/{orderId}`, `GET /api/consumer/customers/{customerId}/orders`, `GET /api/consumer/orders/{orderId}`, `GET /api/consumer/orders/status/{orderId}`
   - Description: Empower consumer customers to create, modify, list, and access their orders through intuitive endpoints.

## Behavior-Driven Testing with Cucumber
To ensure the reliability of these APIs, I embraced the power of behavior-driven testing (BDD) using Cucumber. Through meticulously crafted feature files, scenarios, and corresponding steps, I accurately described the expected behavior of each API. Selenium, combined with an appropriate WebDriver such as ChromeDriver, was employed to perform comprehensive end-to-end testing.

## CI/CD: Jenkins Build Stage
For seamless integration and deployment, I established a robust CI/CD pipeline utilizing Jenkins. Focusing on the build stage, this pipeline automates the process of compiling, testing, and validating the application. With every commit, Jenkins ensures the quality and stability of the codebase before proceeding.

## Frontend: HTML UI Client
To complement the backend APIs, I crafted a simple yet effective HTML UI client using ReactJS. This client facilitates interaction with the APIs, enabling users to send requests to endpoints and view results effortlessly. The UI client, designed to be responsive and user-friendly, emphasizes the effective execution of the APIs.

[Repository Link](https://github.com/shailendrayadav7/Communications-Service)
