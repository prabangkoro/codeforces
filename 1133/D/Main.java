import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static int gcd (int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  static long generateCombinedInteger (int numerator, int denominator) {
    int num = numerator;
    int den = denominator;
    if (den < 0) {
      den *= -1;
      num *= -1;
    }
    if (den != 0) {
      int gcd = gcd(Math.abs(num), Math.abs(den));
      num /= gcd;
      den /= gcd;
    }
    return (num << 32) | den;
  }
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
    }

    boolean[] zeroImpossible = new boolean[n];
    int zeroImpossibleCount = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == 0 && b[i] != 0) {
        zeroImpossible[i] = true;
        zeroImpossibleCount++;
      }
    }

    if (zeroImpossibleCount == n) {
      out.println(0);
    } else {
      ArrayList<Long> hashAB = new ArrayList<>();
      
      for (int i = 0; i < n; i++) {
        if (!zeroImpossible[i]) {
          // b_a[i] = generateCombinedInteger(b[i], a[i]);
          hashAB.add(generateCombinedInteger(b[i], a[i]));
          // out.println(b_a[i]);
        }
      }
  
      Collections.sort(hashAB);
  
      int counterMax = 1;
      int counter = 1;
      long prev = hashAB.get(0);
      for (int i = 1; i < n; i++) {
        if (prev == hashAB.get(i)) {
          counter++;
          counterMax = Math.max(counterMax, counter);
        } else {
          counter = 0;
        }
      }
  
      out.println(counterMax);
    }


    in.close();
    out.close();
  }
}