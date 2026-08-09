import java.util.*;
class T1 extends Thread {
    long end;
    T1(long end) {
        this.end = end;
    }
    public void run() {
        try {
            while (System.currentTimeMillis() < end) {
                System.out.println("Hello!");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
        }
    }
}
class T2 extends Thread {
    long end;
    T2(long end) {
        this.end = end;
    }
    public void run() {
        try {
            while (System.currentTimeMillis() < end) {
                System.out.println("Happy Holidays!");
                Thread.sleep(2000);
            }
        } catch (Exception e) {
        }
    }
}
class T3 extends Thread {
    long end;
    T3(long end) {
        this.end = end;
    }
    public void run() {
        try {
            while (System.currentTimeMillis() < end) {
                System.out.println("Enjoy!");
                Thread.sleep(5000);
            }
        } catch (Exception e) {
        }
    }
}
public class Ex5q1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Run for how many seconds? ");
        int s = sc.nextInt();
        long end = System.currentTimeMillis() + s * 1000;
        T1 t1 = new T1(end);
        T2 t2 = new T2(end);
        T3 t3 = new T3(end);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Program finished.");
    }
}