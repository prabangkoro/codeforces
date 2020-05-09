import java.io.*;
import java.util.*;

public class Main {
  static InputStream inputStream = System.in;
  static OutputStream outputStream = System.out;
  static InputReader in = new InputReader(inputStream);
  static PrintWriter out = new PrintWriter(outputStream);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();

    int[] qtyX = new int[n + 1];
    int[] qtyY = new int[n + 1];
    int withoutX = 0;
    int withoutY = 0;

    int x = in.nextInt();
    int y = in.nextInt();

    for (int i = 0; i < m - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();

      if (a != x && b != x) {
        qtyY[a]++;
        qtyY[b]++;
        withoutX++;
      }
      if (a != y && b != y) {
        qtyX[a]++;
        qtyX[b]++;
        withoutY++;
      }
    }

    boolean OK = false;
    for (int i = 1; i < n + 1 && !OK; i++) {
      if (qtyX[i] == withoutY || qtyY[i] == withoutX) {
        OK = true;
      }
    }

    out.println(OK ? "YES" : "NO");


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