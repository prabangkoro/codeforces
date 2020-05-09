import java.io.*;
import java.util.*;

public class Main {
  static InputStream inputStream = System.in;
  static OutputStream outputStream = System.out;
  static InputReader in = new InputReader(inputStream);
  static PrintWriter out = new PrintWriter(outputStream);
  
  public static void main(String[] args) {
    int q = in.nextInt();

    for (int i = 0; i < q; i++) {
      int k = in.nextInt();
      int n = in.nextInt();
      int a = in.nextInt();
      int b = in.nextInt();

      int kLeft = k - b * n;
      // out.println("K left: " + kLeft);
      // out.println("a - b: " + (a - b));
      if (kLeft <= 0) out.println(-1);
      else {
        int turnLeft = (kLeft / (a - b));
        boolean zeroAble = kLeft % (a - b) == 0;
        if (zeroAble) turnLeft--;
        turnLeft = Math.min(turnLeft, n);
        out.println(turnLeft);
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