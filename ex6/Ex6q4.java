import java.io.*;
import java.util.*;
class SensorPacket implements Serializable {
    double t, h, p;
    SensorPacket(double t, double h, double p) {
        this.t = t; this.h = h; this.p = p;
    }
    public String toString() {
        return "Temp: " + t + "°C, Humidity: " + h + "%, Pressure: " + p + " hPa";
    }
}
public class Ex6q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter number of packets: ");
            int n = sc.nextInt();
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            for (int i = 1; i <= n; i++) {
                System.out.println("\nEnter packet " + i + " temperature, humidity, and pressure:");
                double t = sc.nextDouble();
                double h = sc.nextDouble();
                double p = sc.nextDouble();
                oo.writeObject(new SensorPacket(t, h, p));
            }
            oo.close();
            byte[] b = bo.toByteArray();
            ByteArrayInputStream bi = new ByteArrayInputStream(b);
            FilterInputStream fi = new FilterInputStream(bi) {};
            ObjectInputStream oi = new ObjectInputStream(fi);
            ArrayList<SensorPacket> list = new ArrayList<>();
            while (true) {
                try {
                    SensorPacket s = (SensorPacket) oi.readObject();
                    if (s.t > 30) list.add(s);
                } catch (EOFException e) { break; }
            } 
            oi.close();
            System.out.println("\nPackets with temperature > 30:");
            for (SensorPacket s : list) System.out.println(s);
            System.out.println("Total: " + list.size());
        } catch (IOException e) { System.out.println("IO Error"); } 
          catch (ClassNotFoundException e) { System.out.println("Class not found"); }
        sc.close();
    }
}