import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static long MOD = 998244353;

  public static void main(String[] args) {
    int n = in.nextInt();

    long[] val = new long[n];
    for (long i = 0; i < n; i++) {
      long input = in.nextLong();
      val[(int)i] = input * (i + 1) * ((long)n - i);
    }
    Arrays.sort(val);
    
    ArrayList<Long> b = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      b.add(in.nextLong());
    }
    Collections.sort(b);

    long ans = 0;
    for (int i = n - 1; i >= 0; i--) {
      // out.println("i: " + i);
      long incr = ((val[i] % MOD) * b.get(n - 1 - i)) % MOD;
      ans = (ans + incr) % MOD;
    }

    out.println(ans);

    in.close();
    out.close();
  }
}