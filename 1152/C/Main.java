import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static long gcd (long a, long b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }
  
  public static void main(String[] args) {
    int a = in.nextInt();
    int b = in.nextInt();

    int diff = Math.abs(b - a);
    // iterate all divisors of (b - a)
    TreeSet<Integer> divisors = new TreeSet<>();
    for (int i = 1; i * i <= diff; i++) {
      if (diff % i != 0) continue;
      divisors.add(i);
      if (diff != (i * i)) {
        divisors.add(diff / i);
      }
    }
    
    long minLcm = Long.MAX_VALUE;
    int k = 0;
    for (int d : divisors) {
      int kCurr = (d - a % d) % d;
      long newA = (long)a + (long)kCurr;
      long newB = (long)b + (long)kCurr;
      long lcm = newA / gcd(newA, newB) * newB;
      out.println("d: " + d + " k: " + kCurr + " lcm: " + lcm);
      if (lcm < minLcm) {
        k = kCurr;
        minLcm = lcm;
      }
    }

    out.println(k);
    // if (Math.max(a, diff) % Math.min(a, diff) == 0) {
    //   out.println(0);
    // } else {
    // }

    in.close();
    out.close();
  }
}