# JavaCC Project 🚀

Welcome to the **JavaCC Project**! This repository demonstrates how to build a custom lexical analyzer and parser for Java source code using **JavaCC**. 💻✨

## 🌟 Features

- **Lexical Analysis**: Identify tokens in Java source code.
- **Syntax Validation**: Parse and validate Java syntax.
- **Error Reporting**: Highlight errors in the source code.
- **Output Formatting**: Generate clear and organized outputs.

---

## 🛠 Installation and Setup

Follow these steps to set up and run the project on your system:

### 1️⃣ Install Prerequisites

1. **JDK 8**: Download and install from [here](https://www.oracle.com/eg/java/technologies/downloads/#java8-windows) 🟢.
2. **JRE 8**: Download and install from [here](https://www.java.com/en/download/manual.jsp) 🟢.
3. **JavaCC 6.0.1**: Download from [this link](https://drive.google.com/file/d/1rY7HsGAE6Km3v7TN9EujRpwr3ft22V5v/view) 🟢.

### 2️⃣ Configure Environment Variables

- Add **JDK** and **JRE** paths to your system's `PATH` variable.
- Extract the JavaCC archive, and add its `bin` directory to your `PATH`.

### 3️⃣ Clone This Repository

```bash
git clone https://github.com/AnasHany219/JavaCC-Project.git
cd JavaCC-Project
```

---

## ▶️ How to Run

1. Generate the Java parser files using JavaCC:

   ```bash
   javacc JavaAnalyzer.jj
   ```

2. Compile the generated `.java` files:

   ```bash
   javac *.java
   ```

3. Analyze an input file:
   ```bash
   java JavaAnalyzer input.txt
   ```

---

## 📄 Code Explanation

### Sample Java Code to Analyze

```java
/* bla bla bla */
// This is a comment
class MyClass {
    int x = 10;
    if (x == 10) {
        int y = x + 5;
    }
}
```

### Key Features in the Code

1. **Handling Comments**:

   - Multi-line comments (`/* ... */`) and single-line comments (`// ...`) are processed as tokens.

2. **Keywords and Syntax Parsing**:

   - Reserved words like `class`, `if`, and operators like `=` are identified and validated.

3. **Variables and Expressions**:
   - Variable declarations (`int x = 10;`) and arithmetic expressions (`x + 5`) are recognized.

### Highlight: JavaAnalyzer.jj

The file contains grammar definitions for the Java syntax, including:

- **TOKEN Definitions**: Define tokens for keywords, operators, and identifiers.
- **Parsing Rules**: Describe valid Java syntax structures like classes, methods, and control statements.

Example snippet:

```java
TOKEN : {
    < COMMENT: "/*" (~["*"])* "*/" > |
    < SINGLE_LINE_COMMENT: "//" (~["\n", "\r"])* ("\n" | "\r") >
}
```

---

## 📂 Example Input and Output

### Input (`input.txt`)

```java
/* Example Code */
// This is a sample
class Demo {
    int value = 20;
    if (value > 10) {
        value += 5;
    }
}
```

### Output

```
Parsed successfully!
Tokens:
- COMMENT: /* Example Code */
- SINGLE_LINE_COMMENT: // This is a sample
- KEYWORD: class
- IDENTIFIER: Demo
- IDENTIFIER: value
...
```

---
