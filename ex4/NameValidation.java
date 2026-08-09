import java.util.Scanner;
public class NameValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        if (!name.matches("[A-Za-z]+\\s+[A-Za-z]+")) 
            System.out.println("Incorrect format for name");
        else
            System.out.println("Valid name");
        sc.close();
    }
}