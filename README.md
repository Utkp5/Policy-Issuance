# Policy Issuance Automation Framework

## Project Overview

This project automates the **Policy Issuance Flow** for the application:

https://pi.policysearch.in/

The automation covers the **complete policy issuance journey until the quote/payment page**, validating the policy details selected by the user.

The framework is built using **Selenium WebDriver, Java, TestNG, and Maven**, following the **Page Object Model (POM)** design pattern for better maintainability and scalability.

---

# Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- Page Object Model (POM)

---

# Project Structure
PolicyIssuanceAutomation
│
├── base
│ └── BaseTest.java
│
├── pages
│ ├── LoginPage.java
│ └── PolicyDetailsPage.java
│
├── tests
│ └── PolicyIssuanceTest.java
│
├── resources
│ └── config.properties
│
└── pom.xml

---

# Test Scenario Covered

The automation script performs the following steps:

1. Launch the application
2. Login using phone number and OTP
3. Enter vehicle registration number
4. Select manufacturer
5. Select car model
6. Select variant
7. Select registration date
8. Select RTO
9. Choose previous policy type
10. Enter customer details
11. Navigate to quote page
12. Validate:
   - Model Name
   - Variant
   - RTO
   - Ownership
   - Registration Date
   - Policy Type
13. Validate that premium price is displayed

---

# How to Run the Project

### 1 Clone Repository
git clone <repo-url>

### 2 Import Project
Import the project into: Eclipse
as a **Maven Project**

### 3 Install Dependencies
Run:mvn clean install

### 4 Run Test
Run the test using: PolicyIssuanceTest.java
or testng.xml


---

# Test Validations

The automation validates:

- Selected **Car Model**
- **Variant**
- **RTO**
- **Ownership**
- **Registration Date**
- **Policy Type**
- **Premium price visibility**

---

# Future Enhancements

- Implement **Extent Reports**
- Add **Data Driven Testing using Excel**
- Add **Screenshot capture on failure**
- Integrate **Log4j Logging**
- Integrate **CI/CD using GitHub Actions**
- Implement **Parallel Execution**

---

# Author
Utkarsh Pandit
QA Automation Engineer

