import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static boolean eligible (int x, int y) {
    return Math.min(Math.abs(x), Math.abs(y)) >= Math.min(Math.abs(x - y), Math.abs(x + y)) &&
      Math.max(Math.abs(x), Math.abs(y)) <= Math.max(Math.abs(x - y), Math.abs(x + y));
  }
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int pos = 0;
    int neg = 0;

    int[] a = new int[n];
    int[] b = new int[n];
    int countA = 0, countB = 0;
    for (int i = 0; i < n; i++) {
      int input = in.nextInt();
      if (input >= 0) {
        pos++;
        a[countA++] = input;
      } else {
        neg++;
        b[countB++] = input;
      }
    }

    out.println("count A: " + countA);
    out.println("count B: " + countB);
    // ++ and --
    int ans = pos * (pos - 1) / 2 + neg * (neg - 1) / 2;
    out.println("first ans: " + ans);
    for (int i = 0; i < countA; i++) {
      for (int j = 0; j < countB; j++) {
        out.println("ai: " + a[i] + " bj: " + b[j] + " el: " + eligible(a[i], b[j]));
        // if (eligible(a[i], b[j])) ans++;
      }
    }

    out.println(ans);

    in.close();
    out.close();
  }
}