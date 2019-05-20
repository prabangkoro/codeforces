import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static int MAXN = 1001;
  static int[] counter = new int[MAXN];

  public static void main(String[] args) {
    int n = in.nextInt();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        ++counter[in.nextInt()];
      }
    }

    int[][] cellMapping = new int[(n + 1) / 2][(n + 1) / 2];
    for (int i = 0; i < (n + 1) / 2; i++) {
      for (int j = 0; j < (n + 1) / 2; j++) {
        if (i != (n - 1 - i) && j != (n - 1 - j)) cellMapping[i][j] = 4;
        else if (i != (n - 1 - i) ^ j != (n - 1 - j)) cellMapping[i][j] = 2;
        else cellMapping[i][j] = 1;
      }
    }

    int[][] ans = new int[n][n];
    boolean OK = true;
    for (int mapper : new int[] {4, 2, 1}) {
      int current = 1;
      for (int i = 0; i < (n + 1) / 2 && OK; i++) {
        for (int j = 0; j < (n + 1) / 2 && OK; j++) {
          if (cellMapping[i][j] != mapper) continue;
          while (current < MAXN && counter[current] < mapper) current++;
          if (current == MAXN) {
            OK = false;
            break;
          }
          ans[i][j] = current;
          ans[n - 1 - i][j] = current;
          ans[i][n - 1 - j] = current;
          ans[n - 1 - i][n - 1 - j] = current;
          counter[current] -= mapper;
        }
      }
      if (!OK) break;
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

    in.close();
    out.close();
  }
}