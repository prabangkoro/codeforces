import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static int MAXN = 1001;
  static int[] countMember = new int[MAXN];
  
  public static void main(String[] args) {
    int n = in.nextInt();

    for (int i = 0; i < n * n; i++) {
      ++countMember[in.nextInt()];
    }

    int[][] cellMapping = new int[(n + 1) / 2][(n + 1) / 2];
    for (int i = 0; i < (n + 1) / 2; i++) {
      for (int j = 0; j < (n + 1) / 2; j++) {
        if (i != (n - 1 - i) && j != (n - 1 - j)) {
          cellMapping[i][j] = 4;
        } else if (i != (n - 1 - i) ^ j != (n - 1 - j)) {
          cellMapping[i][j] = 2;
        } else {
          cellMapping[i][j] = 1;
        }
      }
    }

    int[][] a = new int[n][n];
    boolean undone = false;
    for (int map : new int[] {4, 2, 1}) {
      int counter = 1;
      for (int i = 0; i < (n + 1) / 2 && !undone; i++) {
        for (int j = 0; j < (n + 1) / 2 && !undone; j++) {
          if (cellMapping[i][j] != map) continue;
          while (counter < MAXN && countMember[counter] < cellMapping[i][j]) counter++;
          if (counter == MAXN) {
            undone = true;
          } else {
            a[i][j] = counter;
            a[n - 1 - i][j] = counter;
            a[i][n - 1 - j] = counter;
            a[n - 1 - i][n - 1 - j] = counter;
            countMember[counter] -= map;
          }
        }
      }
      if (undone) break;
    }

    if (undone) {
      out.println("NO");
    } else {
      out.println("YES");
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          out.print(a[i][j] + " ");
        }
        out.println();  
      }
    }

    in.close();
    out.close();
  }
}