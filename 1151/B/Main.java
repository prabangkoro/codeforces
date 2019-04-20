import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();

    int[][] matrix = new int[n][m];
    boolean[] variety = new boolean[n];
    int[] sequence = new int[n];
    for (int i = 0; i < n; i++) {
      Set<Integer> distinct = new HashSet<>();
      for (int j = 0; j < m; j++) {
        matrix[i][j] = in.nextInt();
        distinct.add(matrix[i][j]);
      }
      sequence[i] = 0;
      if (distinct.size() > 1) {
        variety[i] = true;
      }
    }

    boolean hasDistinct = false;
    for (int i = 0; i < n; i++) {
      hasDistinct |= variety[i];
    }
    if (n == 1) {
      if (hasDistinct) {
        out.println("TAK");
        for (int i = 0; i < m; i++) {
          if (matrix[0][i] == 0) continue;
          sequence[0] = i;
          break;
        }
        out.print((sequence[0] + 1));
      } else {
        if (matrix[0][sequence[0]] == 0) {
          out.println("NIE");
        } else {
          out.println("TAK");
          out.print((sequence[0] + 1));
        }
      }
    } else if (hasDistinct) {
      for (int i = 0; i < n; i++) {
        if (!variety[i]) continue;
        int oldNumber = matrix[i][sequence[i]];
        for (int j = 0; j < m; j++) {
          if (oldNumber == matrix[i][j]) continue;
          sequence[i] = j;
          break;
        }
        break;
      }
      out.println("TAK");
      for (int i = 0; i < n; i++) {
        out.print((sequence[i] + 1) + " ");
      }
    } else {
      int prevNumber = matrix[0][0];
      boolean distinct = false;
      for (int i = 1; i < n; i++) {
        if (prevNumber == matrix[i][0]) continue;
        distinct = true;
        break;
      }
      if (distinct) {
        out.println("TAK");
        for (int i = 0; i < n; i++) {
          out.print((sequence[i] + 1) + " ");
        }
      } else {
        out.println("NIE");
      }
    }

    in.close();
    out.close();
  }
}