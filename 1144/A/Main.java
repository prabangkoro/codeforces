import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    
    public static void main(String[] args) {
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            String input = in.nextLine();
            char[] inputChar = input.toCharArray();
            Arrays.sort(inputChar);
            boolean diverse = true;
            for (int j = 0; j < inputChar.length - 1 && diverse; j++) {
                // out.println("inputChar: " + (int)inputChar[j] + " & " + ((int)inputChar[j + 1] - 1));
                if ((int)inputChar[j] == ((int)inputChar[j + 1] - 1)) continue;
                diverse = false;
            }
            out.println(diverse ? "Yes" : "No");
        }

        in.close();
        out.close();
    }
}