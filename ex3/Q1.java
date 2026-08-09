import java.util.*;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

class Money {
    double amount;

    Money(double amount) {
        this.amount = amount;
    }

    Money(Money m) {
        this.amount = m.amount;
    }
}

class CreditCard {
    Person owner;
    Money balance;
    Money creditLimit;

    CreditCard(Person owner, Money creditLimit) {
        this.owner = owner;
        this.creditLimit = new Money(creditLimit);
        this.balance = new Money(0);
    }

    CreditCard(Person owner, Money creditLimit, Money balance) {
        this.owner = owner;
        this.creditLimit = new Money(creditLimit);
        this.balance = new Money(balance);
    }

    void display() {
        System.out.println("\n--- Credit Card Details ---");
        System.out.println("Owner: " + owner.name);
        System.out.println("Balance: " + balance.amount);
        System.out.println("Credit Limit: " + creditLimit.amount);
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter owner name: ");
        String name = sc.nextLine();

        System.out.print("Enter credit limit: ");
        double limit = sc.nextDouble();

        System.out.print("Enter balance: ");
        double bal = sc.nextDouble();

        Person p = new Person(name);
        Money credit = new Money(limit);
        Money balance = new Money(bal);

        CreditCard c = new CreditCard(p, credit, balance);
        c.display();
        sc.close();
    }
}