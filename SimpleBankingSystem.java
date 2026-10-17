import java.util.Scanner;

/**
 * SimpleBankingSystem.java
 * 
 * Main driver class for the Simple Banking System application.
 * Provides a menu-driven console interface utilizing a do-while loop
 * and switch statement to facilitate account creation, balance checks,
 * deposits, withdrawals, and account management.
 * 
 * CodeAlpha Java Programming Internship Project
 */
public class SimpleBankingSystem {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayBanner();

        // 1. Account Creation Step
        System.out.println(">>> STEP 1: CREATE YOUR BANK ACCOUNT");
        System.out.println("-----------------------------------------");

        String accountHolderName = promptNonEmptyString("Enter Account Holder Name: ");
        String accountNumber = promptNonEmptyString("Enter Account Number     : ");
        double initialDeposit = promptNonNegativeDouble("Enter Initial Deposit (or 0 for none): $");

        BankAccount account = new BankAccount(accountHolderName, accountNumber, initialDeposit);

        System.out.println("\n[+] Account created successfully for " + account.getAccountHolderName() + "!");
        account.displayAccountSummary();

        // 2. Menu-driven loop using do-while and switch statement
        int choice;
        do {
            displayMenu();
            choice = promptInteger("Enter your choice (1-5): ");

            switch (choice) {
                case 1:
                    // Check Account Balance
                    System.out.println("\n--- [ CHECK ACCOUNT BALANCE ] ---");
                    System.out.printf("Current Balance for Account (%s): $%,.2f%n",
                            account.getAccountNumber(), account.getBalance());
                    break;

                case 2:
                    // Deposit Money
                    System.out.println("\n--- [ DEPOSIT MONEY ] ---");
                    double depositAmount = promptDouble("Enter amount to deposit: $");
                    account.deposit(depositAmount);
                    break;

                case 3:
                    // Withdraw Money
                    System.out.println("\n--- [ WITHDRAW MONEY ] ---");
                    double withdrawAmount = promptDouble("Enter amount to withdraw: $");
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    // View Account Summary
                    account.displayAccountSummary();
                    break;

                case 5:
                    // Exit the program
                    System.out.println("\n=========================================");
                    System.out.println("  Thank you for using Simple Banking System! ");
                    System.out.println("          Have a wonderful day!            ");
                    System.out.println("=========================================\n");
                    break;

                default:
                    System.out.println("\n[!] Invalid choice! Please select an option between 1 and 5.");
                    break;
            }

            if (choice != 5) {
                pressEnterToContinue();
            }

        } while (choice != 5);

        scanner.close();
    }

    /**
     * Prints the application welcome banner.
     */
    private static void displayBanner() {
        System.out.println("=================================================");
        System.out.println("           SIMPLE BANKING SYSTEM                 ");
        System.out.println("         CodeAlpha Java Internship               ");
        System.out.println("=================================================");
        System.out.println();
    }

    /**
     * Prints the console menu options.
     */
    private static void displayMenu() {
        System.out.println("\n=========================================");
        System.out.println("               MAIN MENU                 ");
        System.out.println("=========================================");
        System.out.println(" 1. Check Account Balance");
        System.out.println(" 2. Deposit Money");
        System.out.println(" 3. Withdraw Money");
        System.out.println(" 4. View Account Summary");
        System.out.println(" 5. Exit");
        System.out.println("=========================================");
    }

    /**
     * Prompts the user for a non-empty string.
     *
     * @param prompt message to display
     * @return validated non-empty string
     */
    private static String promptNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("[!] Input cannot be empty. Please try again.");
        }
    }

    /**
     * Prompts the user for any double value with input validation.
     *
     * @param prompt message to display
     * @return parsed double value
     */
    private static double promptDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("[!] Invalid input. Please enter a valid numerical amount (e.g. 50.00).");
            }
        }
    }

    /**
     * Prompts the user for a non-negative double (>= 0).
     *
     * @param prompt message to display
     * @return non-negative double value
     */
    private static double promptNonNegativeDouble(String prompt) {
        while (true) {
            double value = promptDouble(prompt);
            if (value >= 0) {
                return value;
            }
            System.out.println("[!] Amount cannot be negative. Please enter a positive amount or 0.");
        }
    }

    /**
     * Prompts the user for an integer choice.
     *
     * @param prompt message to display
     * @return integer choice
     */
    private static int promptInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[!] Invalid input. Please enter a valid number (e.g., 1, 2, 3, 4, 5).");
            }
        }
    }

    /**
     * Prompts the user to press Enter before displaying the menu again.
     */
    private static void pressEnterToContinue() {
        System.out.print("\nPress Enter to return to the main menu...");
        scanner.nextLine();
    }
}
