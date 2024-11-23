import java.util.Scanner;

public class Task2 {

    // Variable to store account balance
    private double balance;

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited $%.2f%n", amount);
        } else {
            System.out.println("Invalid deposit amount. Please try again.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew $%.2f%n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            System.out.println("Invalid withdrawal amount. Please try again.");
        }
    }

    // Method to check the balance
    public void checkBalance() {
        System.out.printf("Your current balance is $%.2f%n", balance);
    }

    // Main menu to interact with the user
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("Welcome to the Simple Banking Application!");
        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next();
            }
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawalAmount = scanner.nextDouble();
                    withdraw(withdrawalAmount);
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the Simple Banking Application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select an option between 1 and 4.");
            }
        } while (option != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        // Create an instance of the Task2 class
        Task2 app = new Task2();
        app.showMenu();
    }
}
