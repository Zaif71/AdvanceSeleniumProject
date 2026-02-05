# 🚀 Selenium Automation Framework (Java + Cucumber)

## 📌 Project Overview
This project is a scalable Selenium Automation Framework built using Java, Cucumber (BDD), TestNG, and Maven.
It follows industry best practices and is designed for maintainable, reusable, and CI/CD-ready automation testing.

The framework automates end-to-end functional testing of the SauceDemo application with support for multi-environment execution and Allure reporting.

---

## 🛠️ Tech Stack
- Programming Language: Java 17
- Automation Tool: Selenium WebDriver
- BDD Framework: Cucumber
- Test Runner: TestNG
- Build Tool: Maven
- Reporting: Allure
- CI/CD: GitHub Actions
- Design Pattern: Page Object Model (POM) 

---

## 📂 Project Structure
src
├── main
│   └── java
│       ├── pages
│       ├── utils
│       └── config
│
└── test
    ├── java
    │   ├── runners
    │   ├── stepdefinitions
    │   └── hooks
    │
    └── resources
        ├── features
        ├── config
        ├── allure.properties
        └── environment.properties

---

## ✅ Key Features
- Page Object Model (POM) implementation
- BDD-style automation using Cucumber
- Thread-safe WebDriver using ThreadLocal
- Tag-based execution (@smoke, @regression, @logout)
- Multi-environment support (qa, uat, prod)
- Incognito & headless execution support
- Screenshot capture on test failure
- Allure reporting with environment metadata
- GitHub Actions CI pipeline
- GitHub Pages for report deployment
- SonarQube static code analysis integration
---

## 🧪 Test Coverage
- Login (positive & negative scenarios)
- Add to Cart functionality
- Checkout flow
- Logout functionality
- Data-driven testing using Scenario Outline and DataTables

---

## 🏷️ Tag-Based Execution
Run specific test sets using tags:

mvn test -Dcucumber.filter.tags="@smoke"
mvn test -Dcucumber.filter.tags="@regression"
mvn test -Dcucumber.filter.tags="@logout"

---

## 🌍 Environment Execution
Run tests against different environments:

mvn test -Denv=qa
mvn test -Denv=uat

Environment details are visible inside Allure reports.

---

## 📊 Allure Reporting
Allure report provides:
- Step-wise execution
- Screenshots on failure
- Environment & execution metadata
- Tester information

Generate report locally:

allure serve target/allure-results

---
## 🔍 SonarQube Code Quality
- SonarQube ensures high code quality by providing:
- Quality Gate validation to prevent blocker and critical issues
- Code smell and duplication detection
- Maintainability and reliability analysis
- Security hotspot identification
- Technical debt tracking

## 🔁 CI/CD Integration
- Automated execution on push and pull requests
- Headless execution via GitHub Actions
- Allure report published using GitHub Pages

---


## 👨‍💻 Tested By
Zaif Techi

---

## 📌 Best Practices Followed
- No hard-coded values
- No Thread.sleep usage
- Explicit waits only
- Clean separation of layers
- Config-driven execution
- Scalable and maintainable architecture

---

## 🚀 How to Run the Project
git clone <repository-url>
cd Advance-Selenium
mvn clean test

---

## 📈 Future Enhancements
- API automation integration
- Dockerized test execution
- Cross-browser testing
- Flaky test detection
- Execution dashboard

---

## ⭐ Why This Framework?
This framework follows real-world industry standards and is suitable for enterprise automation projects, CI/CD pipelines, and resume showcase for Automation QA roles.
