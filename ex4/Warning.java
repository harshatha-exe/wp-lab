import java.io.*;
import java.util.Scanner;
public class Warning {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("students.dat"));
            PrintWriter op = new PrintWriter(new FileWriter("warning.dat"));
            while (sc.hasNext()) {
                String name = sc.next();
                int hrs = sc.nextInt();
                double qp = sc.nextDouble();
                double gpa = qp / hrs;
                boolean warn = false;
                if (hrs < 30) {
                    if (gpa < 1.5) 
                        warn = true;
                } else if (hrs < 60) {
                    if (gpa < 1.75) 
                        warn = true;
                } else {
                    if (gpa < 2.0) 
                        warn = true;
                }
                if (warn) 
                    op.println(name + " " + hrs + " " + gpa);
            }
            sc.close();
            op.close();
            System.out.println("Academic warning list created successfully.");
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: Input file students.dat was not found.");
        }
        catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in the input file.");
        }
        catch (IOException e) {
            System.out.println("Error: An input/output error occurred.");
        }
    }
}