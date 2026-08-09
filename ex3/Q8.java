import java.util.*;

class Book {
    String name, publisher;
    int year, edition;
    double price;

    Book(String n, String p, int y, int e, double pr) {
        name = n;
        publisher = p;
        year = y;
        edition = e;
        price = pr;
    }

    void display() {
        System.out.println("\nBook Name: " + name + "\tPublisher: " + publisher + "\tYear: " + year + "\tEdition: " + edition + "\tPrice: " + price);
    }
}

class CollegeBook extends Book {
    String subject;

    CollegeBook(String n, String p, int y, int e,
                double pr, String sub) {
        super(n, p, y, e, pr);
        subject = sub;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Subject: " + subject);
    }
}

class StoryBook extends Book {
    String genre;

    StoryBook(String n, String p, int y, int e,
              double pr, String genre) {
        super(n, p, y, e, pr);
        this.genre = genre;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Genre: " + genre);
    }
}

public class Q8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. College Book 2. Story Book Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name, publisher, year, edition, price: ");
        String name = sc.nextLine();
        String publisher = sc.nextLine();
        int year = sc.nextInt();
        int edition = sc.nextInt();
        double price = sc.nextDouble();
        sc.nextLine();
        Book b;   // Upcasting
        if (choice == 1) {
            System.out.print("Enter Subject: ");
            String subject = sc.nextLine();
            b = new CollegeBook(
                    name, publisher,
                    year, edition,
                    price, subject);
        } else {
            System.out.print("Enter Genre: ");
            String genre = sc.nextLine();
            b = new StoryBook(
                    name, publisher,
                    year, edition,
                    price, genre);
        }

        // Upcasting demonstration
        System.out.println("\n--- Using Upcasting ---");
        b.display();

        // Downcasting demonstration
        System.out.println("\n--- Using Downcasting ---");

        if (b instanceof CollegeBook) {

            CollegeBook cb = (CollegeBook) b;

            System.out.println(
                    "Downcasted to CollegeBook");
            System.out.println(
                    "Subject: " + cb.subject);

        } else if (b instanceof StoryBook) {

            StoryBook sb = (StoryBook) b;

            System.out.println(
                    "Downcasted to StoryBook");
            System.out.println(
                    "Genre: " + sb.genre);
        }

        sc.close();
    }
}