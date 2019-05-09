import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int[] frequency = new int[100001];
    int[] ui = new int[n];
    int max_n = 0;

    for (int i = 0; i < n; i++) {
      int input = in.nextInt();
      ui[i] = input;
      frequency[input]++;
      max_n = Math.max(input, max_n);
    }

    int ans = n;
    for (int i = n - 1; i >= 0; i--) {
      TreeSet<Integer> freqs = new TreeSet<>();
      for (int j = 1; j <= max_n; j++) {
        if (frequency[j] != 0) {
          freqs.add(frequency[j]);
        }
      }
      if (freqs.size() == 2) {
        int p = 0, q = 0;
        for (int j = 1; j <= max_n; j++) {
          if (frequency[j] == freqs.first()) p++;
          else if (frequency[j] == freqs.last()) q++;
        }
        if (p == 1 && (freqs.first() == 1 || freqs.first() == freqs.last() + 1)) {
          ans = i + 1;
          break;
        }
        if (q == 1 && (freqs.last() == 1 || freqs.first() + 1 == freqs.last())) {
          ans = i + 1;
          break;
        }
      }
      frequency[ui[i]]--;
    }

    out.println(ans);

    in.close();
    out.close();
  }
}