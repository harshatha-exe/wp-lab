import java.util.*;

class Gen extends Thread {

    int n;
    int count;
    Gen(int count) {
        this.count = count;
    }
    public void run() {

        Random r = new Random();

        try {

            for (int i = 1; i <= count; i++) {

                n = r.nextInt(100);

                System.out.println("Generated : " + n);

                if (n % 2 == 0) {
                    new Sq(n).start();
                } else {
                    new Cu(n).start();
                }

                Thread.sleep(1000);
            }

        } catch (Exception e) {
        }
    }
}

class Sq extends Thread {

    int n;

    Sq(int n) {
        this.n = n;
    }

    public void run() {
        System.out.println("Square = " + (n * n));
    }
}

class Cu extends Thread {

    int n;

    Cu(int n) {
        this.n = n;
    }

    public void run() {
        System.out.println("Cube = " + (n * n * n));
    }
}

public class Ex5q3 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many random numbers to generate: ");
        int count = sc.nextInt();
        Gen g = new Gen(count);
        g.start();

    }
}