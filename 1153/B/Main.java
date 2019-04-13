import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();
    int h = in.nextInt();

    int frontView[] = new int[m];
    int leftView[] = new int[n];
    int topView[][] = new int[n][m];

    for (int i = 0; i < m; i++) {
      frontView[i] = in.nextInt();
    }

    for (int i = 0; i < n; i++) {
      leftView[i] = in.nextInt();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        topView[i][j] = in.nextInt();
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (topView[i][j] == 0) {
          out.print(0 + " ");
        } else {
          int height = Math.min(frontView[j], leftView[i]);
          out.print(height + " ");
        }
      }
      out.println();
    }

    in.close();
    out.close();
  }
}