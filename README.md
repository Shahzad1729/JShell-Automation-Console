# 🚀 JShell Automation Framework

A lightweight, developer-focused automation utility built using **Java + JShell (Java REPL)** to **interactively execute, debug, and validate automation code** without running full test suites.

---

## 📌 Overview

This project is designed to speed up automation development by enabling **real-time execution of Java automation code** using **JShell**.

Instead of running full frameworks (TestNG/Maven), you can:
- Execute Selenium/Appium commands instantly  
- Validate locators quickly  
- Debug failing scenarios interactively  
- Prototype automation logic before integrating into your main framework  

---

## 🎯 Problem It Solves

Traditional automation workflow:


Write Code → Compile → Run Test → Debug → Repeat


This framework simplifies it to:


Write Code → Run in JShell → Debug instantly


---

## 🏗️ Project Structure


JShell Automation/
│
├── src/
│ └── main/
│ └── java/
│ ├── core/ # Core automation logic
│ ├── utils/ # Driver, config, helpers
│ └── jshell/ # JShell integration classes
│
├── scripts/ # JShell scripts (.jsh files)
│ ├── login.jsh
│ ├── test-flow.jsh
│ └── ...
│
├── config/ # Configuration files
│ ├── config.properties
│ └── ...
│
├── logs/ # Execution logs
│
├── pom.xml # Maven dependencies
└── README.md


---

## ⚙️ Tech Stack

- **Java (JDK 9+)** – Required for JShell  
- **JShell** – Interactive Java REPL  
- **Selenium / Appium** – (Optional) for automation execution  
- **Maven** – Dependency management  

---

## 🚀 Installation

```bash
# Clone repository
git clone <your-repo-url>

# Navigate into project
cd JShell-Automation

# Install dependencies
mvn clean install
## ▶️ Getting Started
1. Start JShell
jshell
2. Load Project Classes
/open src/main/java/utils/DriverFactory.java

Or load multiple files as needed.

3. Run JShell Script
jshell scripts/test.jsh
## 🧪 Example Usage
Initialize WebDriver
var driver = DriverFactory.getDriver();
Open Application
driver.get("https://example.com");
Locate Element
var element = driver.findElement(By.id("username"));
Perform Action
element.sendKeys("testuser");
## 🔄 Workflow
Start JShell
Load required classes
Execute automation commands
Validate results instantly
Move stable logic into main framework
## 🧠 Key Features
✅ Interactive Execution

Run Java automation code line-by-line.

✅ Faster Debugging

No need for full test execution cycles.

✅ Locator Validation

Quickly test XPath/CSS selectors.

✅ Rapid Prototyping

Experiment with automation logic before framework integration.

✅ Lightweight Setup

No TestNG/JUnit dependency required for execution.

🧩 Integration with Main Framework

This project is not a replacement but a supporting utility.

## Works best with:

Selenium + TestNG frameworks
Appium mobile automation
API testing frameworks
📊 Use Cases
Debug failing test cases
Validate locators before committing
Try new automation approaches
Reduce development time
Train beginners in automation
