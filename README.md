# Google Search Prompt Automation

This project demonstrates a single automated Selenium test where a prompt is used to accept a search term, which is then searched on Google. The test waits for a suggestion list to appear and clicks the suggestion matching the prompt input.

## ✅ Tech Stack

- Java 11
- Maven
- Selenium WebDriver
- JUnit 4

## ▶️ How to Run

```bash
mvn clean test
```

## 📂 Structure

```
src/test/java/com/learning/
│   |── bookprograms/ch3browserAgnostics/
│       └── TestGoogleSearch.java
│   └── helper/
│       └── BaseTestClass.java

```

> Requires Chrome and Java 11 installed.
