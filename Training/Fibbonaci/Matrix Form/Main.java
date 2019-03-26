import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  static long[][] identity = {{1, 0}, {0, 1}};
  static long MOD = (long) 1e9 + 7;

  static long[][] multiplyMatrix (long[][] matrixA, long[][] matrixB) {
    long[][] result = new long[2][2];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        for (int k = 0; k < 2; k++) {
          result[i][j] = ((matrixA[i][k] * matrixB[k][j]) % MOD + result[i][j] + MOD) % MOD;
        }
      }
    }
    return result;
  }

  static long[][] fast_pow (long[][] matrix, long exponent) {
    if (exponent == 0) {
      return identity;
    }
    long[][] mid = fast_pow(matrix, exponent / 2);
    if (exponent % 2 == 0) {
      return multiplyMatrix(mid, mid);
    } else {
      return multiplyMatrix(multiplyMatrix(mid, mid), matrix);
    }
  }
  public static void main(String[] args) {
    int n = in.nextInt();

    int F0 = 0;
    int F1 = 1;
    long[][] P0 = {{0, 1}, {1, 1}};

    for (int i = 1; i <= n; i++) {
      long[][] Pn = fast_pow(P0, i);
      long Fn = ((F0 * Pn[0][0]) % MOD + (F1 * Pn[1][0]) % MOD + MOD) % MOD;
      out.println("i: " + i + " Fn: " + Fn);
    }
    in.close();
    out.close();
  }
}