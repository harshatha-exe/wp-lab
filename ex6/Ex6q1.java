import java.io.*;
import java.util.*;
public class Ex6q1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream("input.txt");
            StringBuilder word = new StringBuilder();
            int ch;
            while ((ch = fis.read()) != -1) {
                if (Character.isLetterOrDigit((char) ch)) {
                    word.append((char) ch);
                } 
                else if (word.length() > 0) {
                    String w = word.toString().toLowerCase();
                    map.put(w, map.getOrDefault(w, 0) + 1);
                    word.setLength(0);
                }
            }
            if (word.length() > 0) {
                String w = word.toString().toLowerCase();
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
            fis.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> a.getKey().compareTo(b.getKey()));
        try {
            FileOutputStream fos = new FileOutputStream("output.txt");
            PrintWriter out = new PrintWriter(fos);
            out.println("WORDS IN ALPHABETICAL ORDER");
            for (Map.Entry<String, Integer> entry : list) 
                out.println(entry.getKey() + " : " + entry.getValue());
            list.sort((a, b) -> {int result = b.getValue().compareTo(a.getValue());
                if (result == 0)  return a.getKey().compareTo(b.getKey());
                return result;
            });
            out.println("\nWORDS IN FREQUENCY ORDER");
            for (Map.Entry<String, Integer> entry : list) 
                out.println(entry.getKey() + " : " + entry.getValue());
            out.close();
            System.out.println("Output written to output.txt");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}