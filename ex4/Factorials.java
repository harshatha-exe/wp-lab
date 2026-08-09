import java.util.Scanner;
public class Factorials {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number (-1 to exit): ");
            int n = sc.nextInt();
            if (n == -1)
                break;
            try {
                int ans = MathUtils.factorial(n);
                System.out.println("Factorial = " + ans);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
/*Enter a number (-1 to exit): -7
Factorial is not defined for negative numbers.
Enter a number (-1 to exit): 17
Factorial is defined only up to 16.
Enter a number (-1 to exit): -1 */