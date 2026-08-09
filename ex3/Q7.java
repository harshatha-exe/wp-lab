import java.util.*;
abstract class Marks {
    abstract double getPercentage();
}
class A extends Marks {
    int m1, m2, m3;
    A(int m1, int m2, int m3) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }
    double getPercentage() {
        return (m1 + m2 + m3) / 3.0;
    }
}
class B extends Marks {
    int m1, m2, m3, m4;
    B(int a, int b, int c, int d) {
        m1 = a;
        m2 = b;
        m3 = c;
        m4 = d;
    }
    double getPercentage() {
        return (m1 + m2 + m3 + m4) / 4.0;
    }
}
public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Student A (3 subjects marks):");
        A a = new A(
                sc.nextInt(),
                sc.nextInt(),
                sc.nextInt()
        );
        System.out.println("Student B (4 subjects marks):");
        B b = new B(
                sc.nextInt(),
                sc.nextInt(),
                sc.nextInt(),
                sc.nextInt()
        );
        System.out.println(
                "A Percentage: " +
                        a.getPercentage());
        System.out.println(
                "B Percentage: " +
                        b.getPercentage());
    }
}