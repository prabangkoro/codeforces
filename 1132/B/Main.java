import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);
        int n = scanner.nextInt();
        int[] a = new int[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            total += a[i];
        }
        
        Arrays.sort(a);

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            output.println(total - a[n - scanner.nextInt()]);
            output.flush();
        }
    }
}