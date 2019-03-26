import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) {
    int n = in.nextInt();

    long start = System.currentTimeMillis();

    Boolean prime[] = new Boolean[n];
    Arrays.fill(prime, Boolean.TRUE);
    for (int i = 2; i * i <= n; i++) {
      if (prime[i - 1]) {
        for (int j = i * i; j <= n; j += i) {
          prime[j - 1] = false;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      if (prime[i]) out.print((i + 1) + ", ");
    }

    long end = System.currentTimeMillis();
    out.println("elapsed time: " + (end - start) + " ms");

    in.close();
    out.close();
  }
}