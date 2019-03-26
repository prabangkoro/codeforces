import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = scanner.nextInt();
        Integer[] a = new Integer[n];
         
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a);

        for (int i = 0; i < n; i += 2) {
            out.print(a[i] + " ");
        }

        int k = n - 1;
        if (k % 2 == 0) {
            k--;
        }

        for (int i = k; i >= 1; i -= 2) {
            out.print(a[i] + " ");
        }

        out.flush();
    }
}