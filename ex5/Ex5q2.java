class T extends Thread {
    int d;
    T(int d) {
        this.d = d;
    }
    public void run() {
        try {
            Thread.sleep(d);   
            for (int i = 1; i <= 5; i++) {
                System.out.println(getName() + " Running");
                Thread.sleep(500);
            }
        } catch (Exception e) {
        }
    }
}
public class Ex5q2 {
    public static void main(String args[]) throws Exception {
        T t1 = new T(5000);
        T t2 = new T(5000);
        T t3 = new T(0);
        T t4 = new T(0);
        T t5 = new T(0);
        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");
        t4.setName("T4");
        t5.setName("T5");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(7);
        t4.setPriority(5);
        t5.setPriority(3);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        System.out.println("T1 Alive : " + t1.isAlive() + "\nT2 Alive : " + t2.isAlive() + "\nT3 Alive : " + t3.isAlive() + "\nT4 Alive : " + t4.isAlive() + "\nT5 Alive : " + t5.isAlive());
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        System.out.println("Longest lasting threads: T1 and T2");
    }
}