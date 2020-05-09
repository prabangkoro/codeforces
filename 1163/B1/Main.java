import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static int NMAX = (int)1e5 + 1;
  static int[] frequency = new int[NMAX];
  static int[] f_counter = new int[NMAX];
  
  public static void main(String[] args) {
    int n = in.nextInt();

    int ans = 0;
    int f_max = 0;
    for (int i = 1; i <= n; i++) {
      int input = in.nextInt();
      f_counter[frequency[input]]--;
      frequency[input]++;
      f_counter[frequency[input]]++;
      f_max = Math.max(f_max, frequency[input]);

      boolean ok = false;
      // one color appears once
      if (f_counter[i] == 1){ ok = true; }
      // each color appears once
      else if (f_counter[1] == i) { ok = true; }
      // one color appears once, and the other have same frequency
      else if (f_counter[1] == 1 && f_counter[f_max] * f_max == i - 1) { ok = true; }
      // one color appears one more than the other. the other have same frequency
      else if (f_counter[f_max] == 1 && f_counter[f_max - 1] * (f_max - 1) == (i - f_max)) { ok = true; }

      if (ok) ans = i;
    }

    out.println(ans);

    in.close();
    out.close();
  }
}