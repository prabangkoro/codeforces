import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static void TAK (int[] sequence) {
    out.println("TAK");
    for (int seq : sequence) {
      out.print((seq + 1) + " ");
    }
  }
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();

    int[][] matrix = new int[n][m];
    int[] sequence = new int[n];
    int xor = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = in.nextInt();
      }
      xor ^= matrix[i][0];
    }

    if (xor != 0) {
      TAK(sequence);
    } else {
      boolean distinct = false;
      for (int i = 0; i < n && !distinct; i++) {
        for (int j = 0; j < m && !distinct; j++) {
          if (matrix[i][0] != matrix[i][j]) {
            sequence[i] = j;
            distinct = true;
          }
        }
      }
      if (distinct) {
        TAK(sequence);
      } else {
        out.println("NIE");
      }
    }

    in.close();
    out.close();
  }
}