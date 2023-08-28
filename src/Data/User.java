package Data;

public class User {
    private String username;
    private String password;
    private BankAccount savingsAccount;

    public User(String username, String password, BankAccount savingsAccount) {
        this.username = username;
        this.password = password;
        this.savingsAccount = savingsAccount;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public BankAccount getSavingsAccount() {
        return savingsAccount;
    }
}
