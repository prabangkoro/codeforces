import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n, h, m;
    n = in.nextInt();
    h = in.nextInt();
    m = in.nextInt();

    int[] height = new int[n];
    for (int i = 0; i < n; i++) {
      height[i] = h;
    }

    for (int i = 0; i < m; i++) {
      int l, r, x;
      l = in.nextInt() - 1;
      r = in.nextInt() - 1;
      x = in.nextInt();
      while (l <= r) {
        height[l] = Math.min(height[l], x);
        l++;
      }
    }

    int profit = 0;
    for (int i = 0; i < n; i++) {
      profit += height[i] * height[i];
    }

    out.println(profit);

    in.close();
    out.close();
  }
}