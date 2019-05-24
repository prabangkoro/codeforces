import java.io.*;
import java.util.*;

import javafx.util.Pair;

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
    int[] x = new int[n + 1];
    int[] y = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      x[i] = in.nextInt();
      y[i] = in.nextInt();
    }

    Map<Pair<Integer, Integer>, Long> slopeMap = new Map

    for (int i = 1; i <= n - 1; i++) {
      for (int j = i + 1; j <= n; j++) {
        int x1 = x[i], y1 = y[i];
        int x2 = x[j], y2 = y[j];

        // define a, b, c
        int a = y1 - y2;
        int b = x1 - x2;
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;

        if (a < 0 || (a == 0 && b < 0)) {
          a = -a;
          b = -b;
        }
        Pair<Integer, Integer> slope = new Pair<Integer,Integer>(a, b);

        long c = (long)a * (long)x1 - (long)b * (long)y1;


      }
    }

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