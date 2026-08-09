import java.util.*;

class Acc {

    int bal;

    Acc(int b) {
        bal = b;
    }

    synchronized void dep(int a) {
        bal += a;
        System.out.println(Thread.currentThread().getName() +
                " Deposited " + a +
                " Balance = " + bal);
    }

    synchronized void wd(int a) {

        if (bal >= a) {
            bal -= a;
            System.out.println(Thread.currentThread().getName() +
                    " Withdrew " + a +
                    " Balance = " + bal);
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " Withdrawal Failed");
        }
    }
}

class Dep extends Thread {

    Acc ac;
    int a;

    Dep(Acc ac, int a) {
        this.ac = ac;
        this.a = a;
    }

    public void run() {
        ac.dep(a);
    }
}

class Wd extends Thread {

    Acc ac;
    int a;

    Wd(Acc ac, int a) {
        this.ac = ac;
        this.a = a;
    }

    public void run() {
        ac.wd(a);
    }
}

public class Ex5q5 {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        int b = sc.nextInt();

        System.out.print("Enter deposit amount: ");
        int d = sc.nextInt();

        System.out.print("Enter withdrawal amount: ");
        int w = sc.nextInt();

        Acc ac = new Acc(b);

        Dep t1 = new Dep(ac, d);
        Wd t2 = new Wd(ac, w);
        Dep t3 = new Dep(ac, d);
        Wd t4 = new Wd(ac, w);

        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");
        t4.setName("T4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println("Final Balance = " + ac.bal);
    }
}