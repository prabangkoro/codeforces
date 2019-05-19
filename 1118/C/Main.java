import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static int MAXN = 1001;
  static int[] countMember = new int[MAXN];
  
  public static void main(String[] args) {
    int n = in.nextInt();

    int[] members = new int[n * n];
    for (int i = 0; i < n * n; i++) {
      int input = in.nextInt();
      members[i] = input;
      countMember[input]++;
    }
    Arrays.sort(members);

    // odd count check
    int odd = 0;
    int oddNumber = 0;
    for (int i = 1; i < MAXN; i++) {
      if (countMember[i] % 2 != 0) {
        odd++;
        oddNumber = i;
      }
    }

    if (n == 1) {
      out.println("YES");
      out.println(oddNumber);
    } else if (odd > 1) {
      out.println("NO");
    } else if (odd == 1) {
      if (n % 2 == 0) {
        out.println("NO");
      } else {
        int[][] ans = new int[n][n];
        boolean OK = true;
        int counter = 0;
        boolean oddTaken = false;
        ans[n / 2 + 1][n / 2 + 1] = oddNumber;
        for (int i = 0; i * 2 < n; i++) {
          for (int j = 0; j * 2 < n; j++) {
            if (counter < n * n && countMember[members[counter]] % 2 == 0 && countMember[members[counter]] % 4 != 0) {
              OK = false;
            }
            if (counter < n * n && countMember[members[counter]] % 2 != 0 && !oddTaken) {
              // out.println("odd taken counter: " + counter);
              counter++;
              oddTaken = true;
            }
            // out.println("i: " + i + " j: " + j + " counter: " + counter);
            if (i == n / 2 && j == n / 2) {
              // out.println("invoked at i: " + i + " j: " + j);
              ans[i][j] = oddNumber;
              continue;
            }
            ans[i][j] = members[counter++];
            if (i != (n - 1 - i) && j != (n - 1 - j)) {
              ans[i][n - 1 - j] = members[counter++];
              ans[n - 1 - i][j] = members[counter++];
              ans[n - 1 - i][n - 1 - j] = members[counter++];
            } else if (i != (n - 1 - i)) {
              ans[n - 1 - i][j] = members[counter++];
            } else if (j != (n - 1 - j)) {
              ans[i][n - 1 - j] = members[counter++];
            }
          }
        }
        if (OK) {
          out.println("YES");
          for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
              out.print(ans[i][j] + " ");
            }
            out.println();
          }
        } else {
          out.println("NO");
        }
      }
    } else {
      int[][] ans = new int[n][n];
      boolean OK = true;
      int counter = 0;
      for (int i = 0; i * 2 < n && OK; i++) {
        for (int j = 0; j * 2 < n && OK; j++) {
          if (countMember[members[counter]] % 4 != 0) {
            OK = false;
          }
          ans[i][j] = members[counter++];
          ans[i][n - 1 - j] = members[counter++];
          ans[n - 1 - i][j] = members[counter++];
          ans[n - 1 - i][n - 1 - j] = members[counter++];
        }
      }
      if (OK) {
        out.println("YES");
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            out.print(ans[i][j] + " ");
          }
          out.println();
        }
      } else {
        out.println("NO");
      }
    }

    in.close();
    out.close();
  }
}