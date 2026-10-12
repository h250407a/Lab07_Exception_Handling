// Shows BankAccount refactored to throw checked InsufficientFundsException on overdraft.
class SafeAccount {
    private final String accountNumber;
    private double balance;

    public SafeAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    // Refactored method: throws checked exception instead of returning boolean
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(
                "Declined: Cannot withdraw " + amount + " from balance of " + balance,
                amount - balance
            );
        }
        balance -= amount;
        System.out.printf("Successfully withdrew $%.2f. New Balance: $%.2f%n", amount, balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAccountWithExceptionDemo {
    public static void main(String[] args) {
        SafeAccount account = new SafeAccount("ACC-8899", 200.0);

        try {
            account.withdraw(50.0);
            account.withdraw(300.0); // Fails and triggers exception
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction Blocked: " + e.getMessage());
            System.out.println("Shortfall Amount   : $" + e.getShortfall());
        }

        System.out.println("\nTrade-off Discussion (Exceptions vs Boolean return codes):");
        System.out.println("1. Advantage of Exception: Callers cannot silently ignore failures. It forces explicit handling and carries detailed context (e.g. shortfall).");
        System.out.println("2. Trade-off: Exceptions incur stack-trace allocation overhead and make control flow more verbose than simple boolean flags.");
    }
}
