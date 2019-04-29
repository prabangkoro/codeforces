import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    in.nextLine();
    String[] tiles = new String[n];
    boolean[][] filled = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      tiles[i] = in.nextLine();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (tiles[i].charAt(j) == '#') {
          filled[i][j] = true;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (tiles[i].charAt(j) != '.' ||
            filled[i][j] ||
            i == 0 || i == (n - 1) ||
            j == 0 || j == (n - 1)) continue;
        if ((tiles[i + 1].charAt(j) == '.' && !filled[i + 1][j]) &&
            (tiles[i - 1].charAt(j) == '.' && !filled[i - 1][j]) &&
            (tiles[i].charAt(j + 1) == '.' && !filled[i][j + 1]) &&
            (tiles[i].charAt(j - 1) == '.' && !filled[i][j - 1])) {
            filled[i][j] = true;
            filled[i + 1][j] = true;
            filled[i - 1][j] = true;
            filled[i][j + 1] = true;
            filled[i][j - 1] = true;
          }
      }
    }

    boolean allFilled = true;
    for (int i = 0; i < n && allFilled; i++) {
      for (int j = 0; j < n && allFilled; j++) {
        if (!filled[i][j]) {
          allFilled = false;
        }
      }
    }

    out.println(allFilled ? "YES" : "NO");

    in.close();
    out.close();
  }
}