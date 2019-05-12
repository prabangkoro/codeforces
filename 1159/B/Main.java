import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int[] a = new int[n];

    int min_a = Integer.MAX_VALUE;
    int k = Integer.MAX_VALUE;
    int min_a_idx = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();

      if (min_a > a[i]) min_a_idx = i;
      min_a = Math.min(a[i], min_a);
    }
    
    k = min_a / Math.max(n - 1 - min_a_idx, min_a_idx);
    for (int i = 0; i < n; i++) {
      int k_2 = Math.min(a[i], a[0]) / Math.max(n - 1 - i, i);
      k = Math.min(k, k_2);
    }

    // out.println("min a index: " + min_a_idx);
    out.println(k);
    // if (k == 0) {
    // } else {
    //   for (int i = 0; i < n - 1; i++) {
    //     for (int j = i + 1; j < n; j++) {
    //       k = Math.min(k, Math.min(a[i], a[j]) / Math.abs(i - j));
    //     }
    //   }
    //   out.println(k);
    // }

    in.close();
    out.close();
  }
}