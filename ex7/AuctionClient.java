import java.io.*;
import java.net.*;
import java.util.*;
public class AuctionClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);
        System.out.println(in.readLine());
        String name = sc.nextLine();
        out.println(name);
        Thread t = new Thread(() -> {
            try {
                String msg;
                while ((msg = in.readLine()) != null) 
                    System.out.println("\n" + msg);
            } catch (IOException e) {
                System.out.println("Disconnected.");
            }
        });
        t.start();
        while (true) {
            System.out.print("Enter bid (0 to exit): ");
            int bid = sc.nextInt();
            if (bid == 0) break;
            out.println(bid);
        }
        s.close(); sc.close();
    }
}