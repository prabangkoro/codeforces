import java.io.*;
import java.util.*;

public class Main {
  static InputStream inputStream = System.in;
  static OutputStream outputStream = System.out;
  static InputReader in = new InputReader(inputStream);
  static PrintWriter out = new PrintWriter(outputStream);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int a = in.nextInt();
    int x = in.nextInt();
    int b = in.nextInt();
    int y = in.nextInt();

    boolean OK = false;

    while (a != x && b != y) {
      if (a == b) {
        OK = true;
        break;
      }
      a++;
      if (a > n) a = 1;
      b--;
      if (b < 1) b = n;
    }
    if (a == b) OK = true;


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