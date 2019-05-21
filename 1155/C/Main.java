import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  static long gcd (long a, long b) {
    if (b == 0) return a;
    return gcd(b, a % b);
  }
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();

    long[] x = new long[n];
    long[] diff = new long[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.nextLong();
      if (i > 0) diff[i] = x[i] - x[i - 1];
    }
    
    long commonGcd = Long.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      long gcd = Long.MAX_VALUE;
      if (i == 1) {
        gcd = gcd(diff[i], diff[Math.min(n - 1, i + 1)]);
      } else {
        gcd = gcd(commonGcd, diff[i]);
      }
      // out.println("diff1: " + diff[i] + " diff2: " + diff[i + 1] + " gcd: " + gcd);
      commonGcd = Math.min(commonGcd, gcd);
    }
    // out.println("common gcd: " + commonGcd);

    // int[] p = new int[m];
    boolean OK = false;
    int index = 0;
    for (int i = 0; i < m; i++) {
      long input = in.nextLong();
      if (commonGcd % input == 0) {
        OK = true;
        index = i;
      }
    }

    if (OK) {
      out.println("YES");
      out.println(x[0] + " " + (index + 1));
    } else {
      out.println("NO");
    }

    in.close();
    out.close();
  }
}