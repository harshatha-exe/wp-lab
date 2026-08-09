import java.net.*;
import java.util.*;
public class WeatherStation {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DatagramSocket s = new DatagramSocket();
        s.setBroadcast(true);
        String ip = "255.255.255.255";
        while (true) {
            System.out.print("Enter Temperature, Humidity, and Pressure: ");
            double t = sc.nextDouble();
            double h = sc.nextDouble();
            double p = sc.nextDouble();
            String msg = "Temp: " + t + " C, Humidity: " + h + " %, Pressure: " + p + " hPa";
            byte[] b = msg.getBytes();
            DatagramPacket dp = new DatagramPacket(b, b.length, InetAddress.getByName(ip), 5000);
            s.send(dp);
            System.out.println("Weather data broadcasted.\n");
        }
    }
}
