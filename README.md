# SauceDemoProject

Automation framework for the **Sauce Demo** web application using **Java + Selenium WebDriver + TestNG + Maven**.
This project demonstrates an industry-style Page Object Model (POM) + TestNG automation framework with **CI/CD integration via GitHub Actions and Jenkins**.

---

## Tech Stack
- Java (8/11+)
- Selenium WebDriver
- TestNG
- Maven (pom.xml)
- Page Object Model (POM)
- Extent Reports
- GitHub Actions (CI)
- Jenkins (CI)
- Git & GitHub

---

## Repository Layout
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
│   │   └── SwagLabAppReport.html
│   └── screenShots/
│
├── test-output/                # Default TestNG/Surefire output (XML/HTML suite reports)
│
├── Jenkins Configurations.docx # Reference screenshots of the Jenkins freestyle job setup
├── pom.xml
├── testng.xml
├── testngGroup.xml             # Group-based execution (e.g. smoke/regression groups)
├── testngParallel.xml          # Parallel execution suite
└── README.md
```

---

## Framework Architecture

### Page Object Model (POM)
- Each page has its own class in `src/main/java/pages/`
- Encapsulates locators + page-specific actions
- Increases readability, maintainability, and reusability

### Base Class
- `ProjectSpecificMethods.java`
- Handles:
  - Browser setup/teardown
  - Implicit/Explicit waits
  - Screenshot capture
  - Common reusable methods

### Utilities
- `UtilityClass.java`: Excel handling, config reader, waits, reusable helpers
- `Listener.java`: TestNG listener for logging, reporting, screenshots on failure

### Test Data (Externalized)
- `config.properties` → URL, browser, credentials
- `SwagLabsTestData.xlsx` → Data-driven testing support

### Reporting
- Extent Reports generated under `testOutput/extentReport/`
- Screenshots stored under `testOutput/screenShots/`
- Default TestNG/Surefire reports generated under `test-output/`

### Test Suites
- `testng.xml` → Default full suite run
- `testngGroup.xml` → Run tests by TestNG group (e.g., smoke/regression)
- `testngParallel.xml` → Run tests in parallel for faster execution

---

## CI/CD Integration

### GitHub Actions
A CI workflow (`.github/workflows/`) runs automatically on every push and pull request to `master`:

| Step | Description |
|---|---|
| Checkout Repository | Pulls the latest code (`actions/checkout@v4`) |
| Setup Java | Installs Temurin JDK 17 with Maven dependency caching (`actions/setup-java@v4`) |
| Verify Java / Maven | Confirms `java -version` and `mvn -version` |
| Build Project | `mvn clean compile` |
| Execute TestNG Tests | `mvn clean test` |
| Upload Test Reports | Publishes `test-output/**` and `testOutput/**` as build artifacts (always runs, even on failure) |

Runner: `windows-latest`
Triggers: `push` and `pull_request` on the `master` branch

### Jenkins
A **Freestyle project** (`DemoWebShopJenkinsIntegration`) is configured to build the project as an additional CI pipeline:

- **Source Code Management:** Git → `https://github.com/LeemaJosephine/DemoWebShopPOM.git`, branch `*/master`
- **Build Triggers:**
  - Build whenever a SNAPSHOT dependency is built
  - Build periodically on a schedule (`10 13 * * *`)
- **Build step:** Invoke top-level Maven target
  - Root POM: `pom.xml`
  - Goals: `test`
- **Build Settings:** Email notification on every unstable build and on each failed module, sent to the configured recipient
- Reference configuration screenshots are documented in `Jenkins Configurations.docx`

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
```bash
mvn clean test
```

### 3) Run a specific suite
```bash
mvn clean test -DsuiteXmlFile=testngGroup.xml
mvn clean test -DsuiteXmlFile=testngParallel.xml
```

---

## Typical Tasks Covered (example test cases)
1. Login with valid and invalid credentials
2. Product listing and details validation
3. Add to cart / Remove from cart operations
4. Checkout flow validations
5. Verification of page titles, URLs, and UI elements

---
