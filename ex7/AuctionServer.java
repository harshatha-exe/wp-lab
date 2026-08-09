import java.io.*;
import java.net.*;
import java.util.*;
public class AuctionServer {
    static int max = 0;
    static String win = "";
    static ArrayList<PrintWriter> cs = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Auction Server Started...");
        while (true) {
            Socket s = ss.accept();
            System.out.println("Client connected.");
            new ClientHandler(s).start();
        }
    }
    static class ClientHandler extends Thread {
        Socket s;
        BufferedReader in;
        PrintWriter out;
        String name;
        ClientHandler(Socket s) throws IOException {
            this.s = s;
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream(), true);
            synchronized (cs) { cs.add(out); }
        }
        public void run() {
            try {
                out.println("Enter your name:");
                name = in.readLine();
                out.println("Current highest bid: " + max);
                String msg;
                while ((msg = in.readLine()) != null) {
                    int bid = Integer.parseInt(msg);
                    synchronized (AuctionServer.class) {
                        if (bid > max) {
                            max = bid;
                            win = name;
                            System.out.println(name + " placed bid: " + bid);
                            sendAll("New highest bid: " + max + " by " + win);
                        } 
                        else 
                            out.println("Bid rejected. Current highest bid: "+ max);
                    }
                }
            } catch (Exception e) { System.out.println("Client disconnected."); }
        }
    }
    static void sendAll(String msg) {
        synchronized (cs) {
            for (PrintWriter out : cs) 
                out.println(msg);
        }
    }
}