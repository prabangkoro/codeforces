import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static int[] counter = new int[(int)2e5+5];

  static long gcd (long a, long b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  public static void main(String[] args) {
    int n = in.nextInt();
    long[] a = new long[n];
    long[] b = new long[n];

    for (int i = 0; i < n; i++) a[i] = in.nextLong();
    for (int i = 0; i < n; i++) b[i] = in.nextLong();

    HashMap<String, Integer> fractions = new HashMap<>();
    int idx = 0;
    int base = 0;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == 0) {
        if (b[i] == 0) {
          base++;
        }
        continue;
      }
      long gcd = gcd(a[i], b[i]);
      a[i] /= gcd;
      b[i] /= gcd;
      String fraction = b[i] + "/" + a[i];
      if (!fractions.containsKey(fraction)) {
        fractions.put(fraction, idx++);
      }
      ans = Math.max(ans, ++counter[fractions.get(fraction)]);
    }

    out.println(ans + base);

    in.close();
    out.close();
  }
}