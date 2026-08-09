class A extends Thread {

    public void run() {

        try {

            for (char c = 'A'; c <= 'Z'; c++) {
                System.out.print(c + " ");
                Thread.sleep(1000);
            }

            System.out.println();

        } catch (Exception e) {
        }
    }
}

class Z extends Thread {

    Thread t;

    Z(Thread t) {
        this.t = t;
    }

    public void run() {

        try {

            t.join();

            for (char c = 'Z'; c >= 'A'; c--) {
                System.out.print(c + " ");
                Thread.sleep(2000);
            }

        } catch (Exception e) {
        }
    }
}

public class Ex5q4 {

    public static void main(String args[]) throws Exception {

        A a = new A();
        Z z = new Z(a);

        a.start();
        z.start();

        a.join();
        z.join();

        System.out.println("\nAll threads finished.");
    }
}