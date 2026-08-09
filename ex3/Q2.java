import java.util.*;

class Printer {

    void print(int n, char c) {
        System.out.println("Integer: " + n);
        System.out.println("Character: " + c);
    }

    void print(char c, int n) {
        System.out.println("Character: " + c);
        System.out.println("Integer: " + n);
    }
}

public class Q2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter integer: ");
        int n = sc.nextInt();

        System.out.print("Enter character: ");
        char c = sc.next().charAt(0);

        Printer p = new Printer();

        System.out.println("\nMethod 1:");
        p.print(n, c);

        System.out.println("\nMethod 2:");
        p.print(c, n);
    }
}