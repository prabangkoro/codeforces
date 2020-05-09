import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) {
    int n = in.nextInt();

    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Math.abs(in.nextInt());
    }
    Arrays.sort(a);

    // for (int i = 0; i < n; i++) {
    //   out.print(a[i] + " ");
    // }
    // out.println();

    int left = 0;
    int right = 1;
    long ans = 0;
    while (left < n - 1) {
      while (right < n && a[right] <= 2 * a[left]) right++;
      // out.println("l: " + left + " r: " + right);
      ans += right - left - 1;
      left++;
    }

    out.println(ans);

    in.close();
    out.close();
  }
}