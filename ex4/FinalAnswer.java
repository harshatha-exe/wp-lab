import java.util.Scanner;
public class FinalAnswer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the answers: ");
        String answers = scanner.nextLine();
        System.out.println(finalAnswers(answers));
    }
    public static String finalAnswers(String answers) {
        answers = answers.replaceAll("e", "b");
        answers = answers.replaceAll("E", "A");
        answers = answers.replaceAll("f", "c");
        answers = answers.replaceAll("F", "D");
        answers = answers.toLowerCase();
        return answers;
    }
}