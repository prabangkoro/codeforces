import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int b = in.nextInt();
    int a = in.nextInt();
    int maxCapA = a;

    int distance = 0;
    for (int i = 0; i < n; i++) {
      int exposed = in.nextInt();
      // out.println("exposed: " + exposed + " b: " + b + " a:" + a);
      if (b == 0 && a == 0) break;
      if (exposed == 0) {
        if (a > 0) {
          a--;
          distance++;
        } else {
          b--;
          distance++;
        }
      } else {
        if (a == maxCapA) {
          a--;
          distance++;
          continue;
        }
        if (b > 0) {
          b--;
          a = Math.min(a + 1, maxCapA);
          distance++;
        } else {
          a--;
          distance++;
        }
      }
      // out.println("distance: " + distance);
    }

    out.println(distance);

    in.close();
    out.close();
  }
}