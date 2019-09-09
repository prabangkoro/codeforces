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
      long sum = 0;
      long n = in.nextLong();
      long m = in.nextLong();

      if (m <= n) {
        if (n <= m * 10) {
          long cur = m;
          while (cur <= n) {
            sum += cur % 10;
            cur += m;
          }
        } else {
          long lastDigitPatternSum = 0;
          for (int j = 1; j <= 10; j++) {
            lastDigitPatternSum += (m * j)% 10;
          }

          sum = n / (m * 10) * lastDigitPatternSum;

          long current = 0;
          n %= (m * 10);
          for (int j = 1; j <= 10 && (current + m) <= n; j++) {
            current += m;
            sum += (m * j) % 10;
          }
        }
      }
      out.println(sum);
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