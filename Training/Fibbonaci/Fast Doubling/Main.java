import java.io.PrintWriter;
import java.util.Scanner;

import javafx.util.Pair;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static long MOD = (long) 1e9 + 7;

  static long multiplyWithMod (long a, long b) {
    return (a * b) % MOD;
  }

  static long additionWithMod (long a, long b) {
    return (a + b + MOD) % MOD;
  }

  static long substractWithMod (long a, long b) {
    return (a - b + MOD) % MOD;
  }

  static Pair<Long, Long> fib (long n) { 
    if (n == 0) {
      return new Pair<Long,Long>(0L, 1L);
    }
    Pair<Long, Long> mid = fib(n >> 1);
    long Fk = multiplyWithMod(mid.getKey(), (substractWithMod(multiplyWithMod(2, mid.getValue()), mid.getKey())));
    long Fi = additionWithMod(multiplyWithMod(mid.getKey(), mid.getKey()), multiplyWithMod(mid.getValue(), mid.getValue()));
    if (n % 2 == 0) {
      return new Pair<Long,Long>(Fk, Fi);
    } else {
      return new Pair<Long,Long>(Fi, (Fk + Fi + MOD) % MOD);
    }
  }

  public static void main(String[] args) {
    int n = in.nextInt();

    for (int i = 1; i <= n; i++) {
      Pair<Long, Long> ans = fib(i);
      out.println("i: " + i + " Fn: " + ans.getKey());
    }

    in.close();
    out.close();
  }
}