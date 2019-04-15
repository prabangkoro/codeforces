import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int t = in.nextInt();
    int minWaitTime = 1000000;

    int ans = 1;
    for (int i = 0; i < n; i++) {
      int s = in.nextInt();
      int d = in.nextInt();
      if (s >= t) {
        if (minWaitTime >= (s - t)) {
          minWaitTime = (s - t);
          ans = i + 1;
        }
      } else {
        // int latestTime = (int)Math.ceil((double)(t - s) / (double)d) * d + s;
        int latestTime = ((t - s) / d) * d + s;
        if (latestTime < t) latestTime += d;
        // out.println("i: " + (i + 1) + " latestTime: " + latestTime);
        if (minWaitTime >= (latestTime - t)) {
          minWaitTime = (latestTime - t);
          ans = i + 1;
        }
      }
    }
    // out.println(minWaitTime);

    out.println(ans);
    in.close();
    out.close();
  }
}