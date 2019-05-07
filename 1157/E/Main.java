import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) {
    int n = in.nextInt();

    int[] conj_a = new int[n];
    TreeMap<Integer, Integer> b_tm = new TreeMap<>();

    for (int i = 0; i < n; i++) {
      int input = in.nextInt();
      conj_a[i] = n - input;
    }

    for (int i = 0; i < n; i++) {
      int input = in.nextInt();
      if (b_tm.containsKey(input)) {
        int count = b_tm.get(input) + 1;
        b_tm.replace(input, count);
      } else {
        b_tm.put(input, 1);
      }
    }

    int[] ans = new int[n];

    for (int i = 0; i < n; i++) {
      int min_b = b_tm.firstKey();
      int max_b = b_tm.lastKey();
      // out.println("conj a: " + conj_a[i] + " min b: " + min_b + " max b: " + max_b);
      if (min_b > conj_a[i] || max_b < conj_a[i]) {
        ans[i] = ((n - conj_a[i]) + min_b) % n;
        int count = b_tm.get(min_b) - 1;
        if (count == 0) {
          b_tm.remove(min_b);
        } else {
          b_tm.replace(min_b, count);
        }
      } else {
        Map.Entry least = b_tm.ceilingEntry(conj_a[i]);
        // out.println("least key: " + least.getKey());
        ans[i] = (int)least.getKey() - conj_a[i];
        // out.println("counter curr: " + least.getValue());
        int count = (int)least.getValue() - 1;
        if (count == 0) {
          b_tm.remove(least.getKey());
        } else {
          b_tm.replace((int)least.getKey(), count);
        }
      }
    }

    for (int answer : ans) {
      out.print(answer + " ");
    }

    out.println();

    // for (Map.Entry mapEntry : b_tm.entrySet()) {
    //   out.println(mapEntry.getKey() + " " + mapEntry.getValue());
    // }

    in.close();
    out.close();
  }
}