# Simple Banking System

> **CodeAlpha Java Programming Internship - Task Submission**

A console-based **Simple Banking System** built in Java using core **Object-Oriented Programming (OOP)** principles, input validation, and a user-friendly menu-driven console interface.

---

## 📌 Features

1. **Object-Oriented Design (OOPs)**:
   - Modular architecture separating business logic (`BankAccount`) from the UI/driver logic (`SimpleBankingSystem`).
   - Strong **encapsulation** with `private` fields and controlled `public` accessor and mutator methods.

2. **Account Creation**:
   - Prompts the user to register an account by entering their **Account Holder Name**, **Account Number**, and optional **Initial Deposit**.
   - Input validation prevents empty names, empty account numbers, and negative deposits.

3. **Menu-Driven Console Interface**:
   - **Check Account Balance**: View current balance formatted with currency and commas.
   - **Deposit Money**: Validates deposit amounts (rejects zero or negative values).
   - **Withdraw Money**: Checks for sufficient balance before deduction (prevents overdrafts and negative amounts).
   - **View Account Summary**: Displays complete account details at any time.
   - **Exit**: Gracefully exits the application.

4. **Robust Control Flow & Input Handling**:
   - Powered by a `do-while` loop and `switch` statement to keep the application interactive until the user decides to exit.
   - Prevents crashes from invalid inputs (e.g., entering letters when a number is expected) using safe parsing and prompt validation.

---

## 📂 Project Structure

```
Simple Banking System/
├── BankAccount.java          # Core domain model representing a bank account
├── SimpleBankingSystem.java  # Menu-driven console interface and driver
└── README.md                 # Project documentation
```

---

## 🛠️ Requirements & Compilation

### Prerequisites
- Java Development Kit (JDK 8 or higher; tested on JDK 26)

### How to Compile
Open your terminal/command prompt in the project directory and run:

```bash
javac BankAccount.java SimpleBankingSystem.java
```

### How to Run
Execute the compiled driver class:

```bash
java SimpleBankingSystem
```

---

## 💻 Sample Program Walkthrough

```text
=================================================
           SIMPLE BANKING SYSTEM                 
         CodeAlpha Java Internship               
=================================================

>>> STEP 1: CREATE YOUR BANK ACCOUNT
-----------------------------------------
Enter Account Holder Name: Alice Smith
Enter Account Number     : AC987654321
Enter Initial Deposit (or 0 for none): $1000

[+] Account created successfully for Alice Smith!

=========================================
            ACCOUNT SUMMARY              
=========================================
 Account Holder : Alice Smith
 Account Number : AC987654321
 Current Balance: $1,000.00
=========================================

=========================================
               MAIN MENU                 
=========================================
 1. Check Account Balance
 2. Deposit Money
 3. Withdraw Money
 4. View Account Summary
 5. Exit
=========================================
Enter your choice (1-5): 2

--- [ DEPOSIT MONEY ] ---
Enter amount to deposit: $500.00
 [+] Successfully deposited: $500.00
 [+] Updated Balance: $1,500.00

Press Enter to return to the main menu...

=========================================
               MAIN MENU                 
=========================================
 1. Check Account Balance
 2. Deposit Money
 3. Withdraw Money
 4. View Account Summary
 5. Exit
=========================================
Enter your choice (1-5): 3

--- [ WITHDRAW MONEY ] ---
Enter amount to withdraw: $2000.00
 [!] Insufficient funds! Attempted to withdraw $2,000.00, but current balance is $1,500.00.

Press Enter to return to the main menu...

=========================================
               MAIN MENU                 
=========================================
 1. Check Account Balance
 2. Deposit Money
 3. Withdraw Money
 4. View Account Summary
 5. Exit
=========================================
Enter your choice (1-5): 5

=========================================
  Thank you for using Simple Banking System! 
          Have a wonderful day!            
=========================================
```

---

## 🛡️ OOP Principles Applied

- **Encapsulation**: Account state (`balance`, `accountNumber`, `accountHolderName`) is kept private and can only be modified through controlled, validated operations (`deposit`, `withdraw`).
- **Data Validation**: Enforces business constraints (positive amounts, non-negative balances).
- **Separation of Concerns**: `BankAccount` maintains account state and operations, while `SimpleBankingSystem` handles user interaction and program execution flow.
