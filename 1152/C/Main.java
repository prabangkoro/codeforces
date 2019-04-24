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
    long a = in.nextLong();
    long b = in.nextLong();

    long diff = Math.abs(b - a);
    long gcdAB = gcd(a, b);
    // if (diff != 0 && gcdAB != a && gcdAB != b) {
    //   long number = 0;
    //   if (a > b) {
    //     number = a;
    //   } else {
    //     number = b;
    //   }
    //   long multiplier = (long)Math.ceil((double) number / diff);
    //   long ans = multiplier * diff - number;
    //   out.println(ans);
    // } else {
    //   out.println(0);
    // }
    long counter = 0;
    if (diff != 0 && gcdAB != a && gcdAB != b) {
      while (gcd(a, b) != diff) {
        a++;
        b++;
        counter++;
      }
    }

    out.println(counter);

    in.close();
    out.close();
  }
}