import java.net.*;
public class WeatherDevice {
    public static void main(String[] args) throws Exception {
        DatagramSocket s = new DatagramSocket(5000);
        byte[] b = new byte[1024];
        System.out.println("Waiting for weather updates...");
        while (true) {
            DatagramPacket dp = new DatagramPacket(b, b.length);
            s.receive(dp);
            String msg = new String(dp.getData(), 0, dp.getLength());
            System.out.println("Weather Update: " + msg);
        }
    }
}