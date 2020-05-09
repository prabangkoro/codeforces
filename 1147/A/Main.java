import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  // static int N_MAX = 100001;
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int k = in.nextInt();

    int[] first_occurence = new int[n + 1];
    int[] last_occurence = new int[n + 1];
    // for (int i = 0; i <= n; i++) {
    //   first_occurence[i] = -1;
    //   last_occurence[i] = -1;
    // }

    int[] questions = new int[k];
    for (int i = 0; i < k; i++) {
      questions[i] = in.nextInt();
      if (first_occurence[questions[i]] == 0) {
        first_occurence[questions[i]] = i + 1;
      }
      last_occurence[questions[i]] = i + 1;
    }

    int ans = 0;
    for (int i = 1; i <= n; i++) {
      // p == q
      if (first_occurence[i] == 0) {
        ans++;
        // out.println("p == q: " + i);
      }
      // | p - q | <= 1
      if (i != n) {
        if (first_occurence[i] == 0 || first_occurence[i + 1] == 0) {
          ans += 2;
          continue;
        }
        int p = i, q = i + 1;
        if (last_occurence[q] < first_occurence[p]) {
          ans++;
          // out.println("p < q: " + i + " , " + (i + 1));
        }
        p = i + 1; q = i;
        if (last_occurence[q] < first_occurence[p]) {
          ans++;
          // out.println("p > q: " + (i + 1) + " , " + i);
        }
      }
    }

    out.println(ans);

    in.close();
    out.close();
  }
}