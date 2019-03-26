import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] An = new int[n];
        int max = 0;
        boolean consFirst = true;
        int countFirst = 0;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            An[i] = a;
            if (a == 1 && consFirst) {
                countFirst++;
            } else {
                consFirst = false;
            }
            if (a == 1) {
                counter++;
                max = Math.max(max, counter);
            } else {
                counter = 0;
            }
        }

        // out.println("max: " + max);
        // out.println("countFirst: " + countFirst);

        if (max < n) {
            int ij = n - 1;
            while (ij >= 0 && An[ij] == 1) {
                ij--;
            }
            int countLast = n - (ij + 1);
            max = Math.max(max, countFirst + countLast);
        }

        out.println(max);

        out.flush();
    }
}