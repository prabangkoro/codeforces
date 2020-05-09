import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static long solve (long[] divisors) {
    int n = divisors.length;
    Arrays.sort(divisors);
    long X = divisors[0] * divisors[n - 1];
    for (int i = 1; i <= n - 1 - i; i++) {
      if (divisors[i] * divisors[n - 1 - i] != X) return -1;
    }
    return X;
  }

  static long factors (long x) {
    long factors = 0;
    for (long i = 2; i * i <= x; i++) {
      if (x % i != 0) continue;
      factors++;
      if (i * i != x) factors++;
    }
    return factors;
  }
  
  public static void main(String[] args) {
    int t = in.nextInt();

    for (int i = 0; i < t; i++) {
      int n = in.nextInt();
      long[] divisors = new long[n];
      for (int j = 0; j < n; j++) {
        divisors[j] = in.nextLong();
      }
      long X = solve(divisors);
      // out.println("X: " + X + " factors: " + factors(X));
      if (X != -1 && factors(X) == n) out.println(solve(divisors));
      else out.println(-1);
    }

    in.close();
    out.close();
  }
}