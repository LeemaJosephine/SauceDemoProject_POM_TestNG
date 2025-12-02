# SauceDemoProject

Automation framework for the **Sauce Demo** web application using **Java + Selenium WebDriver + TestNG + Maven**.  
This project demonstrates an industry-style Page Object Model (POM) + TestNG automation framework with CI/CD integration.

---

##  Tech Stack

- Java (8/11+)
- Selenium WebDriver
- TestNG
- Maven (pom.xml)
- Page Object Model (POM)
- Extent reports
- Git & GitHub

---

##  Repository Layout 

```
SauceDemoProject/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   │   └── ProjectSpecificMethods.java
│   │   │   │
│   │   │   ├── pages/
│   │   │   │   ├── CartPage.java
│   │   │   │   ├── CheckOutPage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── InventoryPage.java
│   │   │   │   └── Inventory_itemPage.java
│   │   │   │
│   │   │   └── utils/
│   │   │       ├── Listener.java
│   │   │       └── UtilityClass.java
│   │   │
│   │   └── resources/
│
│   └── test/
│       ├── java/
│       │   └── test/
│       │       ├── TC_001_LoginTest.java
│       │       ├── TC_002_ProductList.java
│       │       ├── TC_003_AddToCart.java
│       │       └── TC_004_CheckOut.java
│       │
│       └── resources/
│           └── data/
│               ├── config.properties
│               └── SwagLabsTestData.xlsx
│
├── testOutput/
│   ├── extentReport/
|       └── SwagLabsAppReport.html
│   └── screenShots/
│
├── pom.xml
├── testng.xml
└── README.md
```

---

##  **Framework Architecture**

###  Page Object Model (POM)
- Each page has its own class in `src/main/java/pages/`
- Encapsulates locators + page-specific actions
- Increases readability, maintainability, and reusability

###  Base Class
- `ProjectSpecificMethods.java`
- Handles:
  - Browser setup/teardown
  - Implicit/Explicit waits
  - Screenshot capture
  - Common reusable methods

###  Utilities
- `UtilityClass.java`: Excel handling, config reader, waits, reusable helpers  
- `Listener.java`: TestNG listener for logging, reporting, screenshots on failure

###  Test Data (Externalized)
- `config.properties` → URL, browser, credentials  
- `SwagLabsTestData.xlsx` → Data-driven testing support  

###  Reporting
- Extent Reports generated under `testOutput/extentReport/`
- Screenshots stored under `screenShots/`

---

## Prerequisites

1. Java JDK 8 or 11+ installed and `JAVA_HOME` set.  
2. Maven installed and on your `PATH`.  
3. Chrome / Firefox browser installed.  
4. Browser driver - Used WebDriverManager in code to manage drivers automatically.

---

## How to Run Tests

### 1) Clone repository
```bash
git clone https://github.com/LeemaJosephine/SauceDemoProject.git
cd SauceDemoProject
```
### 2) Run full TestNG suite (default)
```
mvn clean test
```
---
## **Typical Tasks Covered (example test cases)**

1. Login with valid and invalid credentials
2. Product listing and details validation
3. Add to cart / Remove from cart operations
4. Checkout flow validations
5. Verification of page titles, URLs, and UI elements

---
