import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();

    int[][] segments = new int[m][2];
    for (int i = 0; i < m; i++) {
      segments[i][0] = in.nextInt();
      segments[i][1] = in.nextInt();
    }

    boolean[] crawled = new boolean[m];
    boolean symetrical = true;
    for (int i = 0; i < m && symetrical; i++) {
      if (crawled[i]) continue;
      int diff = Math.abs(segments[i][0] - segments[i][1]);
      diff = Math.min(n - diff, diff);
      if (n % diff != 0) {
        symetrical = false;
        break;
      }
      for (int j = i; j < m; j++) {
        if (crawled[j]) continue;
        int curr_diff = Math.abs(segments[j][0] - segments[j][1]);
        curr_diff = Math.min(n - curr_diff, curr_diff);
        if (curr_diff != diff) continue;
        if (Math.abs(segments[j][0] - segments[i][0]) % diff == 0) {
          crawled[j] = true;
        }
      }
    }

    for (int i = 0; i < m && symetrical; i++) {
      if (!crawled[i]) {
        symetrical = false;
      }
    }

    out.println(symetrical ? "Yes" : "No");

    in.close();
    out.close();
  }
}