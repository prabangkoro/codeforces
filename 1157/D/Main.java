import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    long n = in.nextLong();
    long k = in.nextLong();

    long remaining = n - k * (k + 1) / 2;
    // out.println("sum: " + (k * (k + 1) / 2));
    // out.println("remaining: " + remaining);
    
    boolean OK = remaining >= 0;
    if (!OK) out.println("NO");
    else {
      long[] ans = new long[(int)k];
      long dividen = remaining / k;
      for (int i = 0; i < k; i++) {
        ans[i] = i + 1;
        if (dividen > 0) {
          ans[i] += dividen;
          remaining -= dividen;
        }
      }

      long counter = k;
      while (remaining > 0 && counter >= 1) {
        long take = Math.min(remaining, ans[(int)counter - 2] - 1);
        // out.println("take: " + take);
        if (take < 0) {
          OK = false;
          break;
        }
        ans[(int)counter - 1] += take;
        remaining -= take;
        counter--;
      }
      if (OK) {
        out.println("YES");
        for (int i = 0; i < k; i++) {
          out.print(ans[i] + " ");
        }
      } else {
        out.println("NO");
      }
    }

    in.close();
    out.close();
  }
}