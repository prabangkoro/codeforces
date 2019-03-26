import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static long MOD = (long) 1e9 + 7;

  static long fib (long n) {
    // out.println("fib: " + n);
    if (n == 0) return 0;
    if (n == 1) return 1;
    return (fib(n - 1) + fib(n - 2) + MOD) % MOD;
  }
  public static void main(String[] args) {
    int n = in.nextInt();

    for (int i = 1; i <= n; i++) {
      long Fn = fib(i);
      out.println("i: " + i + " Fn: " + Fn);
    }
    in.close();
    out.close();
  }
}