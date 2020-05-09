import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static int gcd (int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
  }
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();

    int[][] segments = new int[m][2];
    HashSet<Long> hash_segments = new HashSet<>();
    for (int i = 0; i < m; i++) {
      int start_line = in.nextInt();
      int end_line = in.nextInt();
      segments[i][0] = Math.min(start_line, end_line);
      segments[i][1] = Math.max(start_line, end_line);
      hash_segments.add(((long)segments[i][0] << 32) | (long)segments[i][1]);
    }

    TreeSet<Integer> steps = new TreeSet<>();
    for (int i = 1; i < n; i++) {
      steps.add(gcd(i, n));
    }

    Iterator<Integer> it = steps.iterator();
    boolean match = true;
    while (it.hasNext()) {
      int k = it.next();
      for (int i = 0; i < m; i++) {
        int a = segments[i][0] + k;
        int b = segments[i][1] + k;
        if (a > n) a -= n;
        if (b > n) b -= n;
        long hash_ab = ((long)Math.min(a, b) << 32) | (long)Math.max(a, b);
        if (hash_segments.contains(hash_ab)) {
          match = true;
        } else {
          match = false;
          break;
        }
      }
      if (match) break;
    }

    if (match) {
      out.println("Yes");
    } else {
      out.println("No");
    }

    in.close();
    out.close();
  }
}