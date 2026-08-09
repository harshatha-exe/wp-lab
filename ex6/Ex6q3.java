import java.io.*;
public class Ex6q3 {
    public static void main(String[] args) {
        String ip = "server.log", op = "error_logs.txt", line;
        int errorCount = 0;
        try (
            BufferedReader br = new BufferedReader(
                new FileReader(ip));
            BufferedWriter bw = new BufferedWriter(
                new FileWriter(op))
        ) {
            while ((line = br.readLine()) != null) {
                if (line.contains("ERROR")) {
                    bw.write(line);
                    bw.newLine();
                    errorCount++;
                }
            }
            System.out.println("Total ERROR lines found and written: " + errorCount);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}