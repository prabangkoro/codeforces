import java.io.*;
import java.util.*;

public class Main {
  static InputStream inputStream = System.in;
  static OutputStream outputStream = System.out;
  static InputReader in = new InputReader(inputStream);
  static PrintWriter out = new PrintWriter(outputStream);

  static int gcd (int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
  }
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int[][] M = new int[n][n];
    int[] ans = new int[n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
       int inp = in.nextInt();
       M[i][j] = inp; 
      }
    }

    int[] gcd_list = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < n; j++) {
        gcd_list[i] = gcd(gcd_list[i], M[i][j]);
      }
    }


    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        out.print(M[i][j] / gcd_list[i]);
        out.print(" ");
      }
      out.println();
    }


    // for (int i = 0; i < n; i++) {
    //   out.print(ans[i]);
    //   out.print(" ");
    // }
    out.close();
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public long nextLong () {
      return Long.parseLong(next());
    }

    public char nextChar () {
      return next().charAt(0);
    }
  }
}