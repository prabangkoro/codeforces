import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Arrays;
// import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a);
        int result = 1;

        int l = 0;
        int r = 0;
        while (r < n) {
            if (a[r] - a[l] <= 5) {
                result = Math.max(result, r - l + 1);
                r++;
            } else {
                l++;
            }
        }

        output.println(result);
        output.flush();
    }
}