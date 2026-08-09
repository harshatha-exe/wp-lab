import java.io.*;
public class Ex6q2 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("ip.txt");
            FileWriter fw = new FileWriter("op.txt");
            int ch;
            while ((ch = fr.read()) != -1) 
                fw.write(Character.toUpperCase((char) ch));
            fr.close(); fw.close();
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
