import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class DecodeAnswers {
    public static String ans = "";
    public static void main(String[] args) {
        ans = "";
        try {
            Scanner file = new Scanner(new File("ans.txt"));
            while (file.hasNextLine()) {
                String line = file.nextLine();
                if (line.matches("[a-fA-F]")) {
                    ans += line;
                }
            }
            file.close();
            System.out.println("Decoded Answers: " + ans);
            System.out.println("Final Decoded Answers: " + FinalAnswer.finalAnswers(ans));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}