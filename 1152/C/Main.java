import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static int gcd (int a, int b) {
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
    int gcdAB = gcd(a, b);
    if (diff != 0 && gcdAB != a && gcdAB != b) {
      int number = Math.max(a, b);
      int multiplier = (int)Math.ceil((double) number / diff);
      int maxCounter = multiplier * diff - number;
      int counter = 0;
      int minAB = Math.min(a, b);
      int maxAB = Math.max(a, b);
      while ((maxAB % minAB) != 0 && counter < maxCounter) {
        a++;
        b++;
        counter++;
        minAB = Math.min(a, b);
        maxAB = Math.max(a, b);
      }
      out.println(Math.min(counter, maxCounter));
    } else {
      out.println(0);
    }
    // long counter = 0;
    // long gcdAB = gcd(a, b);
    // if (diff != 0 && gcdAB != a && gcdAB != b) {
    //   while (gcdAB != diff && gcdAB != Math.min(a, b)) {
    //     a++;
    //     b++;
    //     counter++;
    //     gcdAB = gcd(a, b);
    //   }
    // }
    // out.println(counter);

    in.close();
    out.close();
  }
}