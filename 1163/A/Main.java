import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();
    int remaining = n - m;

    int[] circle = new int[n];
    for (int i = 0; i < n && remaining > 0; i++) {
      if (i % 2 != 0) {
        circle[i] = 1;
        remaining--;
      }
    }

    if (remaining > 0) {
      for (int i = n - 1; i >= 0 && remaining > 0; i--) {
        if (circle[i] != 1) {
          circle[i] = 1;
          remaining--;
        }
      }
    }

    int ans = 0;
    // for (int i = 0; i < n; i++) {
    //   out.println("i: " + i + " circle: " + circle[i]);
    // }
    for (int i = 0; i < n - 1; i++) {
      if (circle[i] == 0 && circle[i + 1] == 1) ans++;
    }

    if (m == 0) {
      out.println(1);
    } else {
      out.println(ans);
    }

    in.close();
    out.close();
  }
}