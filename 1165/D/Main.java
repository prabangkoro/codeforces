import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static long solve (int[] divisors) {
    int n = divisors.length;
    Arrays.sort(divisors);
    long X = divisors[0] * divisors[n - 1];
    for (int i = 1; i <= n - 1 - i; i++) {
      if (divisors[i] * divisors[n - 1 - i] != X) return -1;
    }
    return X;
  }
  
  public static void main(String[] args) {
    int t = in.nextInt();

    for (int i = 0; i < t; i++) {
      int n = in.nextInt();
      int[] divisors = new int[n];
      for (int j = 0; j < n; j++) {
        divisors[j] = in.nextInt();
      }
      out.println(solve(divisors));
    }

    in.close();
    out.close();
  }
}