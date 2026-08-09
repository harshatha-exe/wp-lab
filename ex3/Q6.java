import java.util.*;
interface Account {
    void deposit(double amt);
    void withdraw(double amt);
    void calculateInterest();
    void viewBalance();
}
class SavingsAccount implements Account {
    double balance;
    SavingsAccount(double balance) {
        this.balance = balance;
    }
    public void deposit(double amt) {
        balance += amt;
        System.out.println("Amount Deposited Successfully!");
    }
    public void withdraw(double amt) {
        if (balance - amt >= 0) {
            balance -= amt;
            System.out.println("Withdrawal Successful!");
        } else 
            System.out.println("Insufficient balance.");
    }
    public void calculateInterest() {
        System.out.println("Interest = " + (balance * 0.05));
    }
    public void viewBalance() {
        System.out.println("Current Balance = " + balance);
    }
}
class CurrentAccount implements Account {
    double balance;
    CurrentAccount(double balance) {
        this.balance = balance;
    }
    public void deposit(double amt) {
        balance += amt;
        System.out.println("Amount Deposited Successfully!");
    }
    public void withdraw(double amt) {
        if (amt <= balance + 5000) {
            balance -= amt;
            System.out.println("Withdrawal Successful!");
        } else 
            System.out.println("Overdraft Limit Exceeded!");
    }
    public void calculateInterest() {
        System.out.println("Current Accounts do not earn interest.");
    }
    public void viewBalance() {
        System.out.println("Current Balance = " + balance);
    }
}
class Bank {
    ArrayList<Account> accounts = new ArrayList<>();
    void addAccount(Account a) {
        accounts.add(a);
    }
}
public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Account Type: 1. Savings Account 2. Current Account");
        int choice = sc.nextInt();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        Account acc = null;
        Bank bank = new Bank();
        if (choice == 1) {
            acc = new SavingsAccount(balance);
            bank.addAccount(acc);
        } else if (choice == 2) {
            acc = new CurrentAccount(balance);
            bank.addAccount(acc);
        } else {
            System.out.println("Invalid Choice!");
            return;
        }
        int option;
        System.out.println("1. Deposit 2. Withdraw 3. View Balance 4. Calculate Interest 5. Exit");
        do {
            System.out.print("Enter your option: ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    acc.withdraw(wd);
                    break;
                case 3:
                    acc.viewBalance();
                    break;
                case 4:
                    acc.calculateInterest();
                    break;
                case 5: return;
                default:
                    System.out.println("Invalid Option!");
            }
        } while (option != 5);
        sc.close();
    }
}