import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int si = s.charAt(i) - '0';
            // out.println("si: " + si);
            if (si % 2 == 0) {
                sum += (i + 1);
            }
        }
        out.println(sum);
        out.close();
    }
}