/**
 * BankAccount.java
 * 
 * Represents a bank account in the Simple Banking System.
 * Encapsulates account details such as account holder name, account number,
 * and balance, while providing methods for balance inquiry, deposits, and withdrawals.
 * 
 * CodeAlpha Java Programming Internship Project
 */
public class BankAccount {
    private String accountHolderName;
    private final String accountNumber;
    private double balance;

    /**
     * Constructor to initialize an account with a starting balance of 0.0.
     *
     * @param accountHolderName Name of the account holder
     * @param accountNumber     Unique account number
     */
    public BankAccount(String accountHolderName, String accountNumber) {
        this(accountHolderName, accountNumber, 0.0);
    }

    /**
     * Overloaded constructor to initialize an account with a specified initial balance.
     *
     * @param accountHolderName Name of the account holder
     * @param accountNumber     Unique account number
     * @param initialBalance    Starting balance (must be non-negative)
     */
    public BankAccount(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = Math.max(0.0, initialBalance);
    }

    /**
     * Retrieves the account holder name.
     *
     * @return account holder name
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }

    /**
     * Updates the account holder name.
     *
     * @param accountHolderName new name
     */
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    /**
     * Retrieves the account number.
     *
     * @return account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Retrieves the current balance.
     *
     * @return current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposits a positive amount into the account.
     *
     * @param amount the amount to deposit (must be > 0)
     * @return true if deposit succeeded, false otherwise
     */
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println(" [!] Invalid deposit amount! The amount must be greater than $0.00.");
            return false;
        }

        this.balance += amount;
        System.out.printf(" [+] Successfully deposited: $%,.2f%n", amount);
        System.out.printf(" [+] Updated Balance: $%,.2f%n", this.balance);
        return true;
    }

    /**
     * Withdraws a specified amount from the account if sufficient funds exist.
     *
     * @param amount the amount to withdraw (must be > 0 and <= balance)
     * @return true if withdrawal succeeded, false otherwise
     */
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" [!] Invalid withdrawal amount! The amount must be greater than $0.00.");
            return false;
        }

        if (amount > this.balance) {
            System.out.printf(" [!] Insufficient funds! Attempted to withdraw $%,.2f, but current balance is $%,.2f.%n",
                    amount, this.balance);
            return false;
        }

        this.balance -= amount;
        System.out.printf(" [+] Successfully withdrew: $%,.2f%n", amount);
        System.out.printf(" [+] Updated Balance: $%,.2f%n", this.balance);
        return true;
    }

    /**
     * Displays a clean formatted summary of the account details.
     */
    public void displayAccountSummary() {
        System.out.println("\n=========================================");
        System.out.println("            ACCOUNT SUMMARY              ");
        System.out.println("=========================================");
        System.out.println(" Account Holder : " + accountHolderName);
        System.out.println(" Account Number : " + accountNumber);
        System.out.printf(" Current Balance: $%,.2f%n", balance);
        System.out.println("=========================================");
    }
}
