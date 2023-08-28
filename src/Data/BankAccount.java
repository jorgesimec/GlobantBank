package Data;

public class BankAccount {
    private int accountNumber;
    private String openingDate;
    private double balance;

    public BankAccount(int accountNumber, String openingDate, double balance) {
        this.accountNumber = accountNumber;
        this.openingDate = openingDate;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        double tax = amount < 1000 ? 200 : (amount * 0.15) + 200;
        if (balance >= amount + tax) {
            balance -= amount + tax;
            System.out.println("Withdraw successful. Tax: $" + tax);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void addMoney(double amount) {
        balance += amount;
        System.out.println("Money added successfully.");
    }

    public void transfer(BankAccount otherAccount, double amount) {
        if (balance >= amount + 100) {
            balance -= amount + 100;
            otherAccount.balance += amount;
            System.out.println("Transfer successful. Tax: $100");
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }
}

