import java.util.*;
class Calculator {
    static int powering(int num1, int num2) {
        return (int) Math.pow(num1, num2);
    }
    static double powerDouble(double num1, double num2) {
        return Math.pow(num1, num2);
    }
}
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.print("Enter two doubles: ");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        System.out.println("Integer Power: " +
                Calculator.powering(a, b));
        System.out.println("Double Power: " +
                Calculator.powerDouble(x, y));
    }
}