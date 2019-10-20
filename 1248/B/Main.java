import java.io.*;
import java.util.*;

public class Main {
  static InputStream inputStream = System.in;
  static OutputStream outputStream = System.out;
  static InputReader in = new InputReader(inputStream);
  static PrintWriter out = new PrintWriter(outputStream);
  
  public static void main(String[] args) {
    int n = in.nextInt();

    long sum = 0;
    long[] sticks = new long[n];
    for (int i = 0; i < n; i++) {
      long input = in.nextInt();
      
      sticks[i] = input;

      sum += input;
    }

    Arrays.sort(sticks);
    long A = 0;
    long B = 0;
    for (int i = 0; i < n / 2; i++) {
      A += sticks[i];
    }
    B = sum - A;

    // out.println("n / 2: " + n / 2);
    // out.println("A: " + A + " B: " + B);

    out.println((A * A + B * B));

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