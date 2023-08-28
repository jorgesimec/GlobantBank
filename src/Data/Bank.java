package Data;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, User> users;

    public Bank() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public void printAllClients() {
        for (User user : users.values()) {
            BankAccount account = user.getSavingsAccount();
            System.out.println("Username: " + user.getUsername() + ", Account Number: " + account.getAccountNumber() + ", Opening Date: " + account.getOpeningDate() + ", Balance: $" + account.getBalance());
        }
    }
}
