# Lab 07: Exception Handling

**Student Details:**
- **Name:** Anesu B Kahanda
- **Registration Number:** H250407A
- **Department:** Computer Science
- **Course:** Object-Oriented Programming in Java

---

## Overview
This laboratory examines fault tolerance and structured error handling in Java:
1. Java exception hierarchy: `Throwable` -> `Error` vs `Exception` (`RuntimeException` unchecked vs checked exceptions).
2. Proper usage of `try`, `catch`, `finally`, `throw`, and `throws`.
3. Catch block ordering (specific before general) and multi-catch expressions.
4. Designing custom checked exceptions carrying structured contextual information.
5. Resource management using `try-with-resources` (`AutoCloseable`) and exception chaining with `.getCause()`.
6. Execution semantics of `finally` blocks when returning out of a `try` block.

---

## Files in this Directory

| File Name | Description |
|---|---|
| `ExceptionBasics.java` | Program 7.1: Try-catch-finally, division by zero, null safety, multi-catch, and general catch blocks. |
| `InsufficientFundsException.java` | Program 7.2: Custom checked exception storing the numerical overdraft shortfall. |
| `Wallet.java` | Program 7.2: Enforces checked exception handling on account overdrafts. |
| `ResourceDemo.java` | Program 7.3: Automatic reverse-order cleanup via `try-with-resources` and wrapped exception chaining. |
| `SafeDivisionDemo.java` | Exercise 1: Divides user numbers safely, handling non-numeric tokens and zero division. |
| `ArrayBoundsHandlingDemo.java` | Exercise 2: Safely handles out-of-bounds array indices. |
| `AgeValidationDemo.java` | Exercise 3: Custom checked `InvalidAgeException` enforcing human age boundaries (0-120). |
| `BankAccountWithExceptionDemo.java` | Exercise 4: Refactors bank withdrawals to throw checked exceptions and evaluates design trade-offs. |
| `FinallyReturnDemo.java` | Exercise 5: Demonstrates that `finally` blocks execute even when a `return` is triggered inside `try`. |

---

## How to Compile and Run

To compile all files:
```bash
javac *.java
```

To run individual programs:
```bash
java ExceptionBasics
java Wallet
java ResourceDemo
java SafeDivisionDemo
java ArrayBoundsHandlingDemo
java AgeValidationDemo
java BankAccountWithExceptionDemo
java FinallyReturnDemo
```

---

## Expected Output Samples

### `Wallet.java`
```
Balance now: 40.0
Cannot spend 60.0; balance is 40.0
Short by: 20.0
```

### `FinallyReturnDemo.java`
```
--- Starting testReturnInTry() ---
1. Inside try block: preparing to return 100
2. Inside finally block: cleanup executes before method exits!
3. Returned value in main: 100
```
