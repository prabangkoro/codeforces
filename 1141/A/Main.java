import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();

        int nStart = n;
        boolean dividable = true;
        int counter = 0;
        while (nStart < m && dividable) {
            int multiplier = m / nStart;
            if (multiplier % 3 == 0) {
                nStart *= 3;
            } else if (multiplier % 2 == 0) {
                nStart *= 2;
            } else {
                dividable = false;
            }
            counter++;
        }

        if (dividable) {
            out.println(counter);
        } else {
            out.println(-1);
        }
        out.flush();
    }
}