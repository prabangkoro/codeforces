import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    Long m = in.nextLong();
    Long k = in.nextLong();

    long maxA = 0;
    long maxB = 0;
    for (int i = 0; i < n; i++) {
      long input = in.nextLong();
      if (input > maxA) {
        maxB = maxA;
        maxA = input;
      } else {
        maxB = Math.max(maxB, input);
      }
    }

    // out.println("max A: " + maxA + " max B: " + maxB);

    long segments = m / (k + 1);
    long happy = segments * maxA * k + segments * maxB;
    happy += (m % (k + 1)) * maxA;

    out.println(happy);

    in.close();
    out.close();
  }
}