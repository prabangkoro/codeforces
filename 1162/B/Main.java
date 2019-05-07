import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n, m;
    n = in.nextInt();
    m = in.nextInt();

    int[][] A = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        A[i][j] = in.nextInt();
      }
    }
    int[][] B = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        B[i][j] = in.nextInt();
      }
    }
    
    int[][] small = new int[n][m];
    int[][] big = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        small[i][j] = Math.min(A[i][j], B[i][j]);
        big[i][j] = Math.max(A[i][j], B[i][j]);
      }
    }
    
    boolean increasing = true;
    for (int i = 0; i < n && increasing; i++) {
      for (int j = 1; j < m && increasing; j++) {
        if (small[i][j] <= small[i][j - 1] ||
            big[i][j] <= big[i][j - 1]) {
          increasing = false;
        }
      }
    }
    for (int i = 0; i < m && increasing; i++) {
      for (int j = 1; j < n && increasing; j++) {
        if (small[j][i] <= small[j - 1][i] ||
            big[j][i] <= big[j - 1][i]) {
          increasing = false;
        }
      }
    }

    out.println(increasing ? "Possible" : "Impossible");

    in.close();
    out.close();
  }
}