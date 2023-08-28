package Test;

import Data.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        BankAccount account1 = new BankAccount(1001, "2023-01-01", 1000);
        User user1 = new User("Mark", "pass1", account1);
        bank.addUser(user1);

        BankAccount account2 = new BankAccount(1002, "2023-02-01", 1000);
        User user2 = new User("Elon", "pass2", account2);
        bank.addUser(user2);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Globant Bank!");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        User currentUser = bank.getUser(username);
        if (currentUser != null) {
            BankAccount currentAccount = currentUser.getSavingsAccount();
            System.out.println("Welcome " + username + "!");
            int choice;

            do {
                System.out.println("\nPlease select an option:");
                System.out.println("1. Add Money");
                System.out.println("2. Withdraw");
                System.out.println("3. Transfer");
                System.out.println("4. Print All Clients and Their Information");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character left by nextInt()

                switch (choice) {
                    case 1:
                        System.out.print("Enter the amount to add: ");
                        double addAmount = scanner.nextDouble();
                        currentAccount.addMoney(addAmount);
                        break;
                    case 2:
                        System.out.print("Enter the amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        currentAccount.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter the recipient's username: ");
                        String recipientUsername = scanner.next();
                        User recipient = bank.getUser(recipientUsername);
                        if (recipient != null) {
                            System.out.print("Enter the amount to transfer: ");
                            double transferAmount = scanner.nextDouble();
                            currentAccount.transfer(recipient.getSavingsAccount(), transferAmount);
                        } else {
                            System.out.println("Recipient not found.");
                        }
                        break;
                    case 4:
                        bank.printAllClients();
                        break;
                    case 0:
                        System.out.println("Exiting Globant Bank. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }

            } while (choice != 0);
        } else {
            System.out.println("User not found. Exiting Globant Bank.");
        }

        scanner.close();
    }
}