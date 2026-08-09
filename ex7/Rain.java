import javax.swing.*;
import java.awt.*;
import java.util.*;
class Drop {
    int x, y, sp;
    Drop(int x, int sp) {
        this.x = x;
        this.y = 0;
        this.sp = sp;
    }
}
public class Rain extends JPanel {
    ArrayList<Drop> d = new ArrayList<>();
    Random r = new Random();
    int n, maxSp;
    Rain(int n, int maxSp) {
        this.n = n;
        this.maxSp = maxSp;
        javax.swing.Timer t = new javax.swing.Timer(50, e -> {
            if (d.size() < n) {
                int x = r.nextInt(getWidth());
                int sp = 2 + r.nextInt(maxSp - 1);
                d.add(new Drop(x, sp));
            }
            for (int i = 0; i < d.size(); i++) {
                d.get(i).y += d.get(i).sp;
                if (d.get(i).y > getHeight()) {
                    d.remove(i);
                    i--;
                }
            }
            repaint();
        });
        t.start();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for (Drop x : d) g.drawLine(x.x, x.y, x.x, x.y + 10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter maximum number of raindrops and speed: ");
        int n = sc.nextInt();
        int sp = sc.nextInt();
        JFrame f = new JFrame("Rain Simulation");
        f.add(new Rain(n, sp));
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        sc.close();
    }
}