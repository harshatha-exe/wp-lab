import java.util.*;
class Account {
    double balance;
    String accountNumber;
    private double interestRate;
    Account(double balance, String accNo, double interestRate) {
        this.balance = balance;
        this.accountNumber = accNo;
        this.interestRate = interestRate;
    }
    void calculateInterest() {
        System.out.println("Interest Amount = " +
                (balance * interestRate / 100));
    }
    boolean validateDeposit(double amt) {
        return amt > 0;
    }
    protected void updateBalance(double amt) {
        balance += amt;
    }
    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}
class SavingsAccount extends Account {
    double minimumBalance;
    SavingsAccount(double bal, String acc,
                   double rate, double min) {
        super(bal, acc, rate);
        minimumBalance = min;
    }
    void displaySavings() {
        display();
        System.out.println("Minimum Balance: " + minimumBalance);
    }
}
class CurrentAccount extends Account {
    double overdraftLimit;
    CurrentAccount(double bal, String acc,
                   double rate, double limit) {
        super(bal, acc, rate);
        overdraftLimit = limit;
    }
    void displayCurrent() {
        display();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Account Type: 1. Savings 2. Current ");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        System.out.print("\nEnter Balance: ");
        double bal = sc.nextDouble();
        System.out.print("Enter Account Number: ");
        String acc = sc.next();
        System.out.print("Enter Interest Rate (%): ");
        double rate = sc.nextDouble();
        if (choice == 1) {
            System.out.print("Enter Minimum Balance: ");
            double min = sc.nextDouble();
            SavingsAccount s =
                    new SavingsAccount(bal, acc, rate, min);
            System.out.println("\n--- Savings Account Details ---");
            s.displaySavings();
            s.calculateInterest();
        } else if (choice == 2) {
            System.out.print("Enter Overdraft Limit: ");
            double limit = sc.nextDouble();
            CurrentAccount c =
                    new CurrentAccount(bal, acc, rate, limit);
            System.out.println("\n--- Current Account Details ---");
            c.displayCurrent();
            c.calculateInterest();
        } else 
            System.out.println("Invalid Choice!");
        sc.close();
    }
}